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
import model.HOS;
import model.HOSFacade;
import model.Lecturer;
import model.LecturerFacade;
import model.Student;

/**
 *
 * @author 91310
 */
@WebServlet(name = "ManageLect", urlPatterns = {"/ManageLect"})
public class ManageLect extends HttpServlet {

    @EJB
    private HOSFacade hOSFacade;

    @EJB
    private ClassFacade classFacade;

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
        String hid = request.getParameter("hid");
        String operation = request.getParameter("operation");
        
      
        HOS hos = hOSFacade.find(hid);
        Lecturer lec = new Lecturer(id,name,gender, phone, passport, email, address,hid,hos);
       
        
        
        Lecturer lect = lecturerFacade.find(id);
       // request.getRequestDispatcher("addlect.jsp").forward(request, response);
        try (PrintWriter out = response.getWriter()) {
            
            if (operation.equalsIgnoreCase("Add")) {
                   
            try{
                
                
             if(hos==null){
                 out.print("Sorry, Wrong HOS ID!<br><br>");
             }
             else if(lect != null){
                  out.print("Sorry, the ID already exists!<br><br>"); 
              }else{
                    lecturerFacade.create(lec);
                    hos.getLlist().add(lec);//**
                    hOSFacade.edit(hos);
                    request.setAttribute("lec", lec);
                    out.print("Lecturer Created! <br><br>");
             }   
            
            
            
           
             }catch(Exception e){
                
            }
        } else if (operation.equalsIgnoreCase("Edit")) {
            try{
               // HOS hos = hOSFacade.find(hid);
                if(hos == null){
                    out.print("Sorry, wrong HOS ID!<br><br>");
                }else{
                    HOS hoss = hOSFacade.find(lect.getHos());
                    if(hos.equals(hoss)){
                        
            lecturerFacade.edit(lec);
            request.setAttribute("lec", lec);
            out.print("Lecturer edit successful !<br><br>");
                    }else{
                        
                         //hoss.getLlist().remove(lec);
                    //hos.getLlist().add(lec);
            //hOSFacade.edit(hos);
            //Lecturer lect = lecturerFacade.find(id);
            lecturerFacade.edit(lec);
            request.setAttribute("lec", lec);
            out.print("Lecturer edit successful !<br><br>");
                    }
                   
                }
            
            
             }catch(Exception e){
                
            }
        } else if (operation.equalsIgnoreCase("Delete")) {
            try{
           //HOS hos = hOSFacade.find(hid);
          // hos.getLlist().remove(lec);
          // hOSFacade.edit(hos);   
          //Classes classes =classFacade.find(id)
                  
          if(lect ==null){
                      out.print("Sorry, the lecturer is not exist !<br><br>");
                 }else if(lect.getClist().isEmpty()){
                        lecturerFacade.remove(lec);
                        out.print("Lecturer removed successful !<br><br>");
                 }
           else{
                        for(int i=0; i<lect.getClist().size();i++){
                      lect.getClist().get(i).setLecturer(null);//**
                      classFacade.edit(lect.getClist().get(i));
                  }
          
                        lecturerFacade.remove(lec);
                        out.print("Lecturer removed successful !<br><br>");
                 }
           
           
            }catch(Exception e){
                
            }
        } else if (operation.equalsIgnoreCase("Search")) {
            try{
                  
                 if(lect ==null){
                      out.print("Sorry, the lecturer is not exist !<br><br>");
                 }else{
                      request.setAttribute("lec", lect);
                 }
           
           }catch(Exception e){
                
            }
           
            
        }
            
            out.print("");  
            request.getRequestDispatcher("addlect.jsp").include(request, response);
      
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
