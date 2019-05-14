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
import model.HOS;
import model.HOSFacade;
import model.Lecturer;
import model.LecturerFacade;

/**
 *
 * @author 91310
 */
@WebServlet(name = "HosManage", urlPatterns = {"/HosManage"})
public class HosManage extends HttpServlet {

    @EJB
    private LecturerFacade lecturerFacade;

    @EJB
    private HOSFacade hOSFacade;

    

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
        
      
        
       HOS hos = new HOS(id,name,gender, phone, passport, email, address);
        
        
         HOS searchhos = hOSFacade.find(id);
        //request.getRequestDispatcher("addhos.jsp").include(request, response);
        try (PrintWriter out = response.getWriter()) {
            if (operation.equalsIgnoreCase("Add")) {
                try{
                   if(id.equals("")){
                 out.print("Sorry,the passport and id should not empty！");
            }else{
                hOSFacade.create(hos);
            request.setAttribute("hoss", hos); 
             out.print("HOS added！");
            } 
                    
                }catch(Exception e){
                
            }
            
           
        } else if (operation.equalsIgnoreCase("Edit")) {
           
            if(searchhos==null){
                 out.print("Sorry, Wrong HOS ID！<br><br>");
            }else{
                hOSFacade.edit(hos);
                //request.setAttribute("hoss", searchhos);
                out.print("HOS modified！<br><br>");
            }
            
            
        } else if (operation.equalsIgnoreCase("Delete")) {
             if(searchhos ==null){
                out.print("Sorry,Wrong ID！<br><br>");
           }else{
                  ArrayList<Lecturer> llist = new ArrayList<Lecturer>(); 
                  llist.addAll(lecturerFacade.findAll());
                  
                for(int i=0; i<llist.size();i++) {
                if(llist.get(i).getHos1().equals(hos)){
                    Lecturer l = lecturerFacade.find(llist.get(i).getId());
                    
                    l.setHos1(null);
                    lecturerFacade.edit(l); 
                     
                }
                }
                
             
            
                hOSFacade.remove(hos);
                out.print("HOS deleted！<br><br>");
             }
           
        } else if (operation.equalsIgnoreCase("Search")) {
          
           if(searchhos ==null){
                out.print("Sorry,Wrong ID！<br><br>");
           }else{
               request.setAttribute("hoss", searchhos); 
           }
           
            
        }
            out.print("");  
            request.getRequestDispatcher("addhos.jsp").include(request, response);
      
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
