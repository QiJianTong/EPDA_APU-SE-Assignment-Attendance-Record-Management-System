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
import model.ClassFacade;
import model.Classes;
import model.Student;

/**
 *
 * @author 91310
 */
@WebServlet(name = "AllClasses", urlPatterns = {"/AllClasses"})
public class AllClasses extends HttpServlet {

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
         List list = classFacade.findAll();
        ArrayList<Classes> listc = new ArrayList<Classes>();
        listc.addAll(list);
               
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
                  // request.getRequestDispatcher("adminpage.jsp").include(request, response);
                   //request.getRequestDispatcher("addclass.jsp").forward(request, response);
                    //request.getRequestDispatcher("adminpage.jsp").forward(request, response);
                   //request.getRequestDispatcher("addclass.jsp").include(request, response);
                    out.print("<br><br>");
                    //out.print(list);
                    //out.print(studentFacade.find(list.addAll(list)) );
                    out.print(
                    "<table border=\"1\">\n" +
"    <tr>\n" +
"        <th>ID</th>\n" +
"        <th>Name</th>\n" +
"        <th>Lecturer</th>\n" +
                            "        <th>HOS</th>\n" +
"    </tr>\n" +
"    <tr>\n" ); 
                    
                for(int i = 0; i<list.size(); i++){
                 Classes cla = listc.get(i);
                 
                        out.print("<td>"+ cla.getId() + "</td>\n" +
"        <td>"+ cla.getClassname() +"</td>\n" +
        "        <td>   "+ cla.getLecturer().getId() +"</td>\n" +
                     "        <td>   "+ cla.getLecturer().getHos1().getId() +"</td>\n" + 
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
