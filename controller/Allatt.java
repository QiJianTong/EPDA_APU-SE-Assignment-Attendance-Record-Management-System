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
import model.Student;

/**
 *
 * @author 91310
 */
@WebServlet(name = "Allatt", urlPatterns = {"/Allatt"})
public class Allatt extends HttpServlet {

    @EJB
    private AttendanceFacade attendanceFacade;

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
         HttpSession session=request.getSession(false);  
        HOS hos = (HOS)session.getAttribute("hos");
        String cid = request.getParameter("cid");
        
      
        
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("allatt.jsp").include(request, response);
           Classes cla = classFacade.find(cid);
            String scheid = request.getParameter("scheid");
            
            if(cla==null){
                                  out.print("Sorry, Wrong Class ID");
                            }
                            else if (scheid.equals("")){
                                out.print("Sorry, Wrong Schedule ID");
                            }else{  
            
            
        int schedule =Integer.parseInt(scheid);
       
       List slist = cla.getSlist();
       ArrayList<Student> lists = new ArrayList<Student>();
       lists.addAll(slist);
        
        ArrayList<Lecturer> llist = new ArrayList<>();
        llist.addAll(lecturerFacade.findAll());
        
        //ArrayList<Classes> clist = new ArrayList<>();
        //clist.addAll(lecturerFacade.findAll());
       ArrayList<Attendance> alist = new ArrayList<>();
        alist.addAll(attendanceFacade.findAll());
        
       
        
                                  
            
            
        out.print(
                    "<table border=\"1\">\n" +
"    <tr>\n" +
"        <th>Student ID</th>\n" +
"        <th>Student Name</th>\n" +
 "        <th>Attendance</th>\n" +

                            
"    </tr>\n" +
"    <tr>\n" ); 
        int f = 0,r=0;
        boolean o = false,x = false,y = false,z= false;
         for(int k=0;k<llist.size();k++){
             o=true;
            if(llist.get(k).getHos1().equals(hos)){
                x=true;
                for(int n=0;n<llist.get(k).getClist().size();n++){
                    if(llist.get(k).getClist().get(n).getId().equals(cid)){
                        y=true;
                        for(int i=0;i<llist.get(k).getClist().get(n).getSlist().size();i++){
                            out.print("<td><a >"+ llist.get(k).getClist().get(n).getSlist().get(i).getId() + "</a></td>\n" +
                            "<td>"+ llist.get(k).getClist().get(n).getSlist().get(i).getName() +"</td>\n" );
                            for(int a= 0; a <alist.size();a++){
                                if(llist.get(k).getClist().get(n).getSlist().get(i).equals(alist.get(a).getStu()) 
                                    && 
                                    llist.get(k).getClist().get(n).equals(alist.get(a).getClasses())
                                    &&
                                    llist.get(k).getClist().get(n).getScheList().get(schedule-1).equals(alist.get(a).getSche()) )
                                {
                                   
                                          z=true;
                                        out.print("<td>"+  alist.get(a).getStatus() +"</td>\n" +
                                                    "</tr>\n" ); 
                                        f++;
                                        if(alist.get(a).getStatus().equals("Present")){
                                          r++;  
                                        }
                                     
                                    
                                }                           
                            }                           
                        }
                    }
                }
            }
        }
                   
                    
                            out.print("</table> ");
                            out.print("Total: "+f+"Students<br><br>"+r+" Student(s) Present<br><br>"+(f-r)+" Student(s) Absent<br><br> Total Attendance of this Class: "+(r*100/f)+"%");
                            if(!o){
                                        out.print("Sorry, there is no lecturer in the database ");
                                }else if(!x){
                                        out.print("Sorry, this class is not under your department");
                                }else if(!y){
                                        out.print("Sorry, this class is not under your department");
                                }else if(!z){
                                        out.print("Sorry, there is no attendance to show");
                                }
        }}
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
