/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.HOS;
import model.Lecturer;
import model.LecturerFacade;
import model.Student;

/**
 *
 * @author 91310
 */
@WebServlet(name = "EditLect", urlPatterns = {"/EditLect"})
public class EditLect extends HttpServlet {

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
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String passport = request.getParameter("passport");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String operation = request.getParameter("operation");
       
        HttpSession session=request.getSession(false);  
        Lecturer lect = (Lecturer)session.getAttribute("lect");
        
      
        
        //Lecturer lec = new Lecturer(id,name,gender, phone, passport, email, address);
       
         if (operation.equalsIgnoreCase("View")) {
          request.setAttribute("lec", lect);
         
         }else if (operation.equalsIgnoreCase("Save")) {
             lect.setAddress(address);
             lect.setEmail(email);
             lect.setGender(gender);
             lect.setPassport(passport);
             lect.setPhone(phone);
             lect.setName(name);
             lecturerFacade.edit(lect);
         }
        
            //lecturerFacade.find(lect);
            //Lecturer lect = lecturerFacade.find(id);
           
       
        
        request.getRequestDispatcher("lectprofile.jsp").forward(request, response);
        try (PrintWriter out = response.getWriter()) {
            out.print("success!");  
            request.getRequestDispatcher("lectprofile.jsp").include(request, response);
      
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
