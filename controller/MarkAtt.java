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
import model.Student;
import model.StudentFacade;

/**
 *
 * @author 91310
 */
@WebServlet(name = "MarkAtt", urlPatterns = {"/MarkAtt"})
public class MarkAtt extends HttpServlet {

    @EJB
    private AttendanceFacade attendanceFacade;

    @EJB
    private StudentFacade studentFacade;

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
        String cid = request.getParameter("cid");
        
        //request.setAttribute("cid", cid);
       /* 
        String scheid = request.getParameter("scheid");
        
        Classes clas = classFacade.find(cid);
        request.setAttribute("clas", clas);
       
        for(int i=0; i>clas.getScheList().size();i++){
            clas.getScheList().get(i);
        }
        */
        
        
       try (PrintWriter out = response.getWriter()) {
           HttpSession session=request.getSession(false);  
        Lecturer lect = (Lecturer)session.getAttribute("lect");
       
        //String cid="525";//***********//***********//***********//***********//***********//***********
                    
                    Classes clas = classFacade.find(cid);//***********
                        //out.print(clas.getScheList().size());
                        
                      /* 
                        for(int i=0; i<clas.getScheList().size();i++){
                       int x= i+1;
                         request.setAttribute("scheid"+x, clas.getScheList().get(i).getId());
                           
                            }  */
        //***********//***********//***********//***********//***********//***********//***********
        String scheid = request.getParameter("scheid");
        int schedule =Integer.parseInt(scheid);
        if(clas ==null||scheid ==null){
             request.getRequestDispatcher("attendance.jsp").include(request, response);
             out.print("sorry, class is not exists. ");
        }else{
            List listc = lect.getClist();
            ArrayList<Classes> listclass = new ArrayList<Classes>();
            listclass.addAll(listc);
       
            request.getRequestDispatcher("attendance.jsp").include(request, response);
           
                    out.print("<form action=\"SaveAtt\" method=\"POST\"> ");
                    out.print("Current Class: ");
                    out.print("<input type=\"text\" name=\"cid\" value="+cid+" size=\"20\"><br><br>");
                    out.print("Current ScheduleID :");
                    out.print("<input type=\"text\" name=\"scheid\" value="+clas.getScheList().get(schedule).getId()+" size=\"20\"><br><br>");
                    out.print(
                    "<table border=\"1\">\n" +
"    <tr>\n" +
"        <th>Student ID</th>\n" +
"        <th>Student Name</th>\n" +
                            "        <th>Attendance</th>\n" +

                            
"    </tr>\n" +
"    <tr>\n" ); 
                   
                    
                    for(int x = 0; x<listclass.size(); x++){ 
                       Classes c = listclass.get(x);
                    if(c.getId().equals(cid)) {
                         //request.setAttribute("cid", cid);
                    //List stulist = c.getSlist();
                    List stulist = c.getSlist();
                    ArrayList<Student> lists = new ArrayList<Student>();
                    lists.addAll(stulist);
                   
                    
                    ArrayList<Attendance> alist = new ArrayList<Attendance>();
                    alist.addAll(attendanceFacade.findAll());
                    
                   
                    
                    
                    
                    
                    for(int i = 0; i< stulist.size(); i++){
                 Student stu =  lists.get(i);
                 
                
                 
                 
                 //stu1.getAddress();
                        out.print("<td><a >"+ stu.getId() + "</a></td>\n" +
"                                   <td>"+ stu.getName() +"</td>\n" +
                                    "<td>\n" );
                               boolean shift = false; 
                       
                                //stu.getAttendance() 
                                 for(int a= 0; a <alist.size();a++){
                                   //
                                    if(stu.equals(alist.get(a).getStu())&&clas.equals(alist.get(a).getClasses())&&clas.getScheList().get(schedule).equals(alist.get(a).getSche()) ){
                                 out.print("<select name=\"att"+ i+"\">\n" +
"                                           <option value=\""+  alist.get(a).getStatus()+" \"> "+ alist.get(a).getStatus()+"</option>\n "
                                        + "<option value =\"Present\">Present</option>\n  "
        + "<option value =\"Absent\" >Absent</option>\n"
        + "<option value =\"Null\">Null</option>\n"
        + " </select>\n"
        + " </td>\n"
        + "</tr>\n");        
                          out.print("<p   hidden=\"hidden\" name=\"attid\" value=\""+alist.get(a).getId() +"\">"+alist.get(a).getId() +"</p>     ");                 
                             shift = true;      
                             // out.print("<p  name=\"true\">1</p>     ");
                                out.print("<input  hidden=\"hidden\" type=\"text\" name=\"true\" value=\"true\" size=\"20\">");
                                    }
                                    if(shift){
                                      break;  
                                    }
                                } 
                                 
                             if(!shift){
                                 out.print("<select name=\"att"+ i+"\">\n" +
            "<option value =\"Present\">Present</option>\n  "
        + "<option value =\"Absent\" >Absent</option>\n"
        + "<option value =\"Null\">Null</option>\n"
        + " </select>\n"
        + " </td>\n"
        + "</tr>\n");             
                       //out.print("<p  name=\"false\">2</p>     ");        
                         out.print("<input hidden=\"hidden\" type=\"text\" name=\"false\" value=\"false\" size=\"20\">");        
                             }   
                                 
                                        
                                         
                                 
                                 
                                
                                 
                                
                                
                                
                                
                                
                                
 }  
                   }}
        
                  out.print("</table> ");
        //***********************************************************************************************//       
       /*
            out.print(
                    "<table border=\"1\">\n" +"    <tr>\n" +
                    "<th>Stchedule ID</th>\n" +
                    "</tr>\n" +
                    "<tr>\n" 
            ); 
            
                    for(int x = 0; x<listclass.size(); x++){ 
                       Classes c = listclass.get(x);
                    if(c.getId().equals(cid)) {
                      
                    List schelist = c.getScheList();
                    ArrayList<Schedule> schelists = new ArrayList<Schedule>();
                    schelists.addAll(schelist);
                    
                    for(int i = 0; i< schelist.size(); i++){
                    Schedule sche =  schelists.get(i);
                 
                        out.print(
                            "<td><a >"+ sche.getId() + "</a></td>\n" +
                            "<td>"+ sche.getOrder() +"</td>\n" +
                            "</tr>\n" 

                        ); 
                    }
                    
                   }}
        
                  out.print("</table> ");
        
        
        */
        
          //***********************************************************************************************//      
                  
                  
                  
                  
                  
                  out.print(" <input type=\"Submit\" name=\"operation\" value=\"Finish\" /> ");
                     out.print("</form> ");
       
        }
        
        
           
           
           
           
               
                     
                  // request.getRequestDispatcher("mark.jsp").include(request, response);
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
