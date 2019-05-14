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
import model.Admin;
import model.AdminFacade;
import model.HOS;
import model.HOSFacade;
import model.Lecturer;
import model.LecturerFacade;
import model.Student;
import model.StudentFacade;

/**
 *
 * @author 91310
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @EJB
    private LecturerFacade lecturerFacade;

    @EJB
    private HOSFacade hOSFacade;

    @EJB
    private StudentFacade studentFacade;

    @EJB
    private AdminFacade adminFacade;

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
         String usertype = request.getParameter("usertype");
        String id = request.getParameter("id");  
        String password = request.getParameter("passport");  
        Student s = studentFacade.find(id);   
        Lecturer l = lecturerFacade.find(id);
        HOS hos = hOSFacade.find(id);
       
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            switch(usertype) {
                
            case "student":
                if(s != null){
                    if(s.getPassport().equals(password)){
                        request.getRequestDispatcher("studentpage.jsp").include(request, response);
                        out.print("<br><br>");
                    if(s.getGender().equals("M"))
                        out.print("Welcome Mr. "+s.getName()+"!");
                    else
                        out.print("Welcome Ms. "+s.getName()+"!");
                    
                        HttpSession session=request.getSession();
                        session.setAttribute("stul",s);
                    } else{
                        out.print("Sorry, wrong password!<br><br>");
                        request.getRequestDispatcher("login.jsp").include(request, response);
                    }
                } else{
                        out.print("Sorry, wrong user name!<br><br>");  
                        request.getRequestDispatcher("login.jsp").include(request, response);
                    }
                break;
                
            case "admin":
                if(Admin.name != null){
                if(Admin.password.equals(password)){
                    request.getRequestDispatcher("adminpage.jsp").include(request, response);
                    out.print("<br><br>");
                    out.print("Welcome Administrative Officer!");
                    HttpSession session=request.getSession();
                    session.setAttribute("admin",s);
                    
                } else{
                    out.print("Sorry, wrong password!<br><br>");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }
            } else{
                out.print("Sorry, wrong user name!<br><br>");  
                // out.print(s+s.getPassport()+(password));  
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
                break;
               
            case "hos":
                 if(hos != null){
                    if(hos.getPassport().equals(password)){
                        request.getRequestDispatcher("hos.jsp").include(request, response);
                        out.print("<br><br>");
                    if(hos.getGender().equals("M"))
                        out.print("Welcome Mr. "+hos.getName()+"!");
                    else
                        out.print("Welcome Ms. "+hos.getName()+"!");
                        HttpSession session=request.getSession();
                        session.setAttribute("hos",hos);
                    } else{
                        out.print("Sorry, wrong password!<br><br>");
                        request.getRequestDispatcher("login.jsp").include(request, response);
                    }
                } else{
                        out.print("Sorry, wrong user name!<br><br>");  
                        request.getRequestDispatcher("login.jsp").include(request, response);
                    }
                break;
             
            case "lecturer":
                if(l != null){
                    if(l.getPassport().equals(password)){
                        request.getRequestDispatcher("lecturer.jsp").include(request, response);
                        out.print("<br><br>");
                    if(l.getGender().equals("M"))
                        out.print("Welcome Mr. "+l.getName()+"!");
                    else
                        out.print("Welcome Ms. "+l.getName()+"!");
                        HttpSession session=request.getSession();
                        session.setAttribute("lect",l);
                    } else{
                        out.print("Sorry, wrong password!<br><br>");
                        request.getRequestDispatcher("login.jsp").include(request, response);
                    }
                } else{
                        out.print("Sorry, wrong user name!<br><br>");  
                        request.getRequestDispatcher("login.jsp").include(request, response);
                    }
                break;
           
            default:
                out.print("Sorry, wrong user name!<br><br>");  
                break;
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
