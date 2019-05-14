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
import model.Lecturer;
import model.LecturerFacade;
import model.Student;

/**
 *
 * @author 91310
 */
@WebServlet(name = "Alllect", urlPatterns = {"/Alllect"})
public class Alllect extends HttpServlet {

    @EJB
    private LecturerFacade lecturerFacade;

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
         List list = lecturerFacade.findAll();
        ArrayList<Lecturer> listlec = new ArrayList<Lecturer>();
        listlec.addAll(list);
        
        try (PrintWriter out = response.getWriter()) {
             //request.getRequestDispatcher("addlect.jsp").include(request, response);
             out.print("<br><br>");
                    //out.print(list);
                    //out.print(studentFacade.find(list.addAll(list)) );
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
                            "        <th>Head of School</th>\n" +
                            
"    </tr>\n" +
"    <tr>\n" ); 
                    
                for(int i = 0; i<list.size(); i++){
                 Lecturer lect = listlec.get(i);
                 //lect.getAddress();
                        out.print("<td>"+ lect.getId() + "</td>\n" +
"        <td>"+ lect.getName() +"</td>\n" +
        "        <td>"+ lect.getAddress() +"</td>\n" +
                       "        <td>"+ lect.getGender() +"</td>\n" +
                                      "        <td>"+ lect.getEmail() +"</td>\n" +
                                                     "        <td>"+ lect.getPhone() +"</td>\n" +
                                                                    "        <td>"+ lect.getPassport() +"</td>\n" +
                                                                                   "        <td>"+ lect.getHos1().getId() +"</td>\n" +
"    </tr>\n" 

); }   
                    out.print("</table>");
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
