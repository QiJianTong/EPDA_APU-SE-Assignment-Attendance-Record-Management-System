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
import model.Lecturer;
import model.Schedule;
import model.ScheduleFacade;
import model.Student;
import model.StudentFacade;

/**
 *
 * @author 91310
 */
@WebServlet(name = "SaveAtt", urlPatterns = {"/SaveAtt"})
public class SaveAtt extends HttpServlet {

    @EJB
    private ScheduleFacade scheduleFacade;

    @EJB
    private AttendanceFacade attendanceFacade;

    @EJB
    private ClassFacade classFacade;

    @EJB
    private StudentFacade studentFacade;

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
        
        String sf = request.getParameter("false");
        String st = request.getParameter("true");
        String attid = request.getParameter("attid");
       
        
        String scheidstring = request.getParameter("scheid");
     
     int ss = Integer.parseInt(scheidstring)-1;
        try (PrintWriter out = response.getWriter()) {
            
            
            //Schedule scheid = scheduleFacade.find(scheidstring);
            String cid =request.getParameter("cid");
           //Schedule s =scheduleFacade.find("1");
            List<Schedule> li = scheduleFacade.findAll();
       ;
                    Classes cla = classFacade.find(cid);
                 
                    List stulist = cla.getSlist();
                    request.setAttribute("cla", cla);
                    ArrayList<Student> lists = new ArrayList<Student>();
                    lists.addAll(stulist);
                    
                  
                      
                    
                   for(int i = 0; i< stulist.size();i++ ){
                     
                          String att1 = request.getParameter("att"+i);
                      
                        
                        
                         
                         Student stu =  lists.get(i);
                        // stu.setAttendance(att1);
                        // studentFacade.edit(stu);
                    //************************************************************//  //************************************************************//       
                       if(sf!=null  ){
                            Attendance attendance = new Attendance();
                        attendanceFacade.create(attendance);
                        attendance.setSche( li.get(ss));
                        attendance.setStu(stu);
                        attendance.setStatus(att1);
                        attendance.setClasses(cla);
                        attendanceFacade.edit(attendance);
                       }else if(st!=null){
                           
                       ArrayList<Attendance> alist = new ArrayList<Attendance>();
                        alist.addAll(attendanceFacade.findAll());
                        
                       Attendance attendance=    attendanceFacade.find(alist.get(i).getId());
                       attendance.setStatus(att1);
                        attendanceFacade.edit(attendance);
                       }
                    
                    
                   
                       //************************************************************//  //************************************************************//
                       
                     
        }
        
        request.getRequestDispatcher("attendance.jsp").include(request, response);
            //out.println(st);
            //out.println(sf);
             //  out.println(attid);
               if(st!=null){
                    out.println("Attendance successfully modified");
               }else{
                   out.println("Attendance successfully Saved");
               }
           
           
            
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
