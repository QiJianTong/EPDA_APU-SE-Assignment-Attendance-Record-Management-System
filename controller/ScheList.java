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
import model.ClassFacade;
import model.Classes;

/**
 *
 * @author User
 */
@WebServlet(name = "ScheList", urlPatterns = {"/ScheList"})
public class ScheList extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
        request.getRequestDispatcher("attendance.jsp").include(request, response);
                String cid="525";
                    
                    Classes clas = classFacade.find(cid);//***********
                        out.print(clas.getScheList().size());
                        
                       
                        for(int i=0; i>clas.getScheList().size();i++){
                       int x= i+1;
                         request.setAttribute("scheid"+x, clas.getScheList().get(i).getId());
                           
                            }  
                       out.print("<form>"); 
                         for(int i=0; i<clas.getScheList().size();i++){
               int x= i+1;
                  out.print(" <input type=\"radio\" name=\"scheid\" value=\""+clas.getScheList().get(i).getId() +"\">"+x+"<br>");
                    } 
             out.print("</form>"); 
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
