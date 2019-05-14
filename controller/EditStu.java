/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Attendance;
import model.AttendanceFacade;
import model.Student;
import model.StudentFacade;

/**
 *
 * @author 91310
 */
@WebServlet(name = "EditStu", urlPatterns = {"/EditStu"})
public class EditStu extends HttpServlet {

    @EJB
    private AttendanceFacade attendanceFacade;

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
         String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String passport = request.getParameter("passport");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String operation = request.getParameter("operation");
         String a = request.getParameter("a");
        HttpSession session=request.getSession(false);  
        Student stu = (Student)session.getAttribute("stul");
        
        

        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         if (operation.equalsIgnoreCase("View")) {
             
          request.setAttribute("stu", stu);
  
         }else if (operation.equalsIgnoreCase("Save")) {
             stu.setAddress(address);
             stu.setEmail(email);
             stu.setGender(gender);
             stu.setPassport(passport);
             stu.setPhone(phone);
             stu.setName(name);
             //stu.setAttendance(att);
             studentFacade.edit(stu);
               out.print("success!");  
         }else if (operation.equalsIgnoreCase("View Attendance")) {
             
             
            request.setAttribute("stu", stu);
            boolean t = false;
            for(int b=0;b<stu.getClasseslist().size();b++){
                if(stu.getClasseslist().get(b).getId().equals(a)){
                                ArrayList<Attendance> alist = new ArrayList<Attendance>();
            alist.addAll(attendanceFacade.findAll());
            out.print("Class Name:");
            out.print("<td><a >"+ stu.getClasseslist().get(b).getClassname()+ "</a></td>\n");
            
            
            
            out.print(
                    "<table border=\"1\">\n" +
"    <tr>\n" +
"        <th>Schedule ID</th>\n" +
"        <th>Attendance Status</th>\n" +                           
"    </tr>\n" ); 
          int x=1;
          int ar = 0;
          for(int i=0; i<alist.size();i++){
               
              if(stu.equals(alist.get(i).getStu())&&stu.getClasseslist().get(b).equals(alist.get(i).getClasses())){
                  // out.print("***"+alist.get(i).getStatus()+"***");
                if(alist.get(i).getStatus().equals("Present")){
                             ar++; 
                            // out.print("***"+ar+"***");
                         }
                  out.print("<tr><td><a >"+ x + "</a></td>\n" +
"                                   <td>"+ alist.get(i).getStatus() +"</td>\n" +
                                    " </tr>" );
                  x++;
              }
          }
          
          if((x-1)<8){
              for(int d = 0;d<8-(x-1);d++){
                  int f= x-1+d+1;
                   out.print("<tr><td><a >"+f + "</a></td>\n" +
"                                   <td>Null</td>\n" +
                                    " </tr>" );
              }
              
          }
           out.print("</table> ");
           int j = x-1;
           float attn =ar*100/j;
          // out.print(j); 
          // out.print(ar); 
             out.print("Total Attendance: "+attn+"%");
             t=true;
              //out.print("success!");  
                }
                
            }
            if(!t){
                     out.print("Class ID wrong!");  
                }

             
         }
         
           
           request.getRequestDispatcher("studentpage.jsp").include(request, response);
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
