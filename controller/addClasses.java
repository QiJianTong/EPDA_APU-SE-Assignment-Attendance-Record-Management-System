/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Attendance;
import model.AttendanceFacade;
import model.ClassFacade;
import model.Classes;
import model.HOS;
import model.Lecturer;
import model.LecturerFacade;
import model.Schedule;
import model.ScheduleFacade;

import model.Student;
import model.StudentFacade;

/**
 *
 * @author 91310
 */
@WebServlet(name = "addClasses", urlPatterns = {"/addClasses"})
public class addClasses extends HttpServlet {

    @EJB
    private AttendanceFacade attendanceFacade;

    @EJB
    private StudentFacade studentFacade;

    @EJB
    private ScheduleFacade scheduleFacade;

   

    @EJB
    private LecturerFacade lecturerFacade;

    @EJB
    private ClassFacade classFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String id = request.getParameter("id");
        String name = request.getParameter("name");
        String lecid = request.getParameter("lecid");
         String operation = request.getParameter("operation");
         
         Lecturer lec = lecturerFacade.find(lecid); 
         Classes c = new Classes(id,name,lecid,lec);
         //Classes cla = classFacade.find(id);
           // request.setAttribute("c", cla);//？
         HttpSession session=request.getSession(false);  
        HOS hos = (HOS)session.getAttribute("hos");
       //HOS hos = new HOS();
        Classes classes = classFacade.find(id);
       // request.getRequestDispatcher("addclass.jsp").forward(request, response);
        
        try (PrintWriter out = response.getWriter()) {
            
             if (operation.equalsIgnoreCase("Add")) {
            try{
               // Classes classes = classFacade.find(id);
                
              if(lec ==null){
                  out.print("Sorry, wrong Lecturer ID!<br><br>"); 
              }else if(!lec.getHos().equals(hos.getId()) ){
                  out.print("Sorry, You only can manage your lecturers and classes!<br><br>"); 
                  out.print(lec.getHos()+"****"+hos.getId()+"!<br><br>"); 
              }
              else if(classes != null){
                  out.print("Sorry, the ID already exists!<br><br>"); 
              }
              else{
                    classFacade.create(c);
                    lec.getClist().add(c);
                    lecturerFacade.edit(lec);//？
                      request.setAttribute("c", c);
                  
              //
               Classes classes1 = classFacade.find(id);
               List schelist = scheduleFacade.findAll();
                int s= 1;
              for(int i=schelist.size()+1;i<schelist.size()+9; i++){
                 
                   Schedule sd = new Schedule(i,s);
                  scheduleFacade.create(sd);
                  classes1.getScheList().add(sd);
                  classFacade.edit(classes1);
                 // c.getScheList().add(i);
                  s++;
              //  classFacade.edit(c); 
              }
             
             out.print("Class Created!<br><br>");
              }
            
             }catch(Exception e){
                
            }
          
        } else if (operation.equalsIgnoreCase("Edit")) {
            try{
                // Lecturer lec = lecturerFacade.find(lecid); 
              
                if(lec==null){
                     out.print("Sorry, wrong Lecturer ID!<br><br>");
                }else if(!lec.getHos().equals(hos.getId()) ){
                  out.print("Sorry, You only can manage your lecturers and classes!<br><br>"); 
                  out.print(lec.getHos()+"****"+hos.getId()+"!<br><br>"); 
              }
                else if(id==null || name==null || lecid==null ){
                out.print("Sorry,please complete the information!<br><br>");
            }
                else if(classes.getLecturer()==null){
                    lec.getClist().add(c);
                    lecturerFacade.edit(lec);
                    classFacade.edit(c);
                    out.print("Class updated!<br><br>");
                }
                else{
                     classFacade.edit(c);
                    out.print("Class updated!<br><br>");
                    request.setAttribute("c", classes);
                }
                    
            
             }catch(Exception e){
                
            }
           
        } else if (operation.equalsIgnoreCase("Delete")) {
            try{
                 Classes classes1 = classFacade.find(id);
                 lec.getClist().remove(c);
                    lecturerFacade.edit(lec);
                    
                  ArrayList<Student>  slist = new  ArrayList<Student>();
                  slist.addAll(studentFacade.findAll());
                  
                  for(int i=0;i<slist.size();i++){
                      if(slist.get(i).getClasseslist().get(i).equals(c)){
                          slist.get(i).getClasseslist().remove(c);
                          studentFacade.edit(slist.get(i));
                      }
                  }
                  ArrayList<Attendance>  alist = new  ArrayList<>();
                  alist.addAll(attendanceFacade.findAll());
                  for(int i=0;i<alist.size();i++){
                      
                      if(alist.get(i).getClasses().equals(classes1)){
                          Attendance att = attendanceFacade.find(alist.get(i).getId());
                            
                            attendanceFacade.remove(att);
                      }
                     
                     
                    
                  }
                   //** 
                 //classes.setClassname("!!PleaseAttention:DeletedClass!!");
                    //classFacade.edit(classes);
                    classFacade.remove(c);
                    out.print("Class deleted!<br><br>");
                
                
                
                
           
          // request.setAttribute("c",classes);
            }catch(Exception e){
                
            }
            
        } else if (operation.equalsIgnoreCase("Search")) {
            
            try{
            Classes cla = classFacade.find(id);
            if(cla ==null){
                out.print("Sorry, please input a correct ClassID!<br><br>");
            }else{
                request.setAttribute("c", cla);  
                
            }
          
             }catch(Exception e){
                
            }
        }
             out.print("");  
            request.getRequestDispatcher("addclass.jsp").include(request, response);
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
