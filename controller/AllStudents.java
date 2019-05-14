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
import model.Student;
import model.StudentFacade;

/**
 *
 * @author 91310
 */
@WebServlet(name = "AllStudents", urlPatterns = {"/AllStudents"})
public class AllStudents extends HttpServlet {

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
         List list = studentFacade.findAll();
        ArrayList<Student> liststu = new ArrayList<Student>();
        liststu.addAll(list);
               
        try (PrintWriter out = response.getWriter()) {
           
                   
                    out.print("<br><br>");
                    
                    out.print(
                    "<table border=\"1\">\n" +
"    <tr>\n" +
"        <th>ID</th>\n" +
"        <th>Name</th>\n" +
"        <th>Address</th>\n" +
                            "        <th>Gender</th>\n" +
                            "        <th>Email</th>\n" +
                            "        <th>Phone</th>\n" +
                            "        <th>Passport</th>\n" +
                            "        <th>ClassList</th>\n" +
                            
"    </tr>\n" +
"    <tr>\n" ); 
                    
                for(int i = 0; i<list.size(); i++){
                 Student stu1 = liststu.get(i);
                 //stu1.getAddress();
                        out.print("<td>"+ stu1.getId() + "</td>\n" +
"        <td>"+ stu1.getName() +"</td>\n" +
        "        <td>"+ stu1.getAddress() +"</td>\n" +
                       "        <td>"+ stu1.getGender() +"</td>\n" +
                                      "        <td>"+ stu1.getEmail() +"</td>\n" +
                                                     "        <td>"+ stu1.getPhone() +"</td>\n" +
                                                                    "        <td>"+ stu1.getPassport() +"</td>\n" +
                                                                                   "        <td>"+ stu1.getClasseslist() +"</td>\n" +
"    </tr>\n" 

); }   
                    out.print("</table>");
                   
          
                   // HttpSession session=request.getSession();  
                   // session.setAttribute("who",stu1);                    
              
           
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
