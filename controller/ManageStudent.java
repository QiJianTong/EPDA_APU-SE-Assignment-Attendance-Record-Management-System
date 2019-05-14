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
import model.Attendance;
import model.AttendanceFacade;

import model.ClassFacade;
import model.Classes;
import model.Schedule;
import model.ScheduleFacade;
import model.Student;
import model.StudentFacade;

/**
 *
 * @author 91310
 */
@WebServlet(name = "ManageStudent", urlPatterns = {"/ManageStudent"})
public class ManageStudent extends HttpServlet {

    @EJB
    private ScheduleFacade scheduleFacade;

    @EJB
    private AttendanceFacade attendanceFacade;

 

    @EJB
    private ClassFacade classFacade;

   

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
        //int phone = Integer.parseInt(request.getParameter("phone"));
        String phone = request.getParameter("phone");
        String passport = request.getParameter("passport");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String att = request.getParameter("att");
         String scheduleid = request.getParameter("scheid");
          //String classesid = request.getParameter("classid");
        //String att = null;
        //String cla = null;
        
        String operation = request.getParameter("operation");
        
       // Classes c = new Classes(cla);
        //classFacade.create(c);
        
        //Attendance a = new Attendance(status);
        //attendanceFacade.create(a);
        
       //String stuid = request.getParameter("stuid");
        String cid = request.getParameter("classid");
       
      
       
        Student stu = new Student(id,name,gender, phone, passport, email, address,att,cid);
     
          Classes c = classFacade.find(cid);
        //request.getRequestDispatcher("adminpage.jsp").forward(request, response);
        
        try (PrintWriter out = response.getWriter()) {
               ArrayList<Attendance> alist = new ArrayList<Attendance>();
                    alist.addAll(attendanceFacade.findAll());
      
        if (operation.equalsIgnoreCase("Add")) {
            
            try{
                 Student searchedStudent = studentFacade.find(id);
             
             if(c==null){
                 out.print("Sorry, wrong Class ID!<br><br>");
                      
             }
             else if(searchedStudent != null){
                  out.print("Sorry, the ID exists!<br><br>"); 
              }else{
                 
                 
                     boolean shift = false; 
                    for(int i = 0; i<alist.size();i++){
                        if(alist.get(i).getSche().equals(c.getScheList().get(0))) {
                             out.print("Sorry, the class already started!<br><br>");
                             shift=true;
                             break;
                        }
                    }
                  if(!shift){
                 studentFacade.create(stu);
                 c.getSlist().add(stu);
                 Student student =  studentFacade.find(id);
                 student.setSchelist(c.getScheList());
                 student.getClasseslist().add(c);
                 studentFacade.edit(student);
                 classFacade.edit(c); 
                 out.print("Student create successful！");

                  }
                 
                
            
             }
           
             
            }catch(Exception e){
                
            }
            
            
           // request.setAttribute("stu", stu);
        } else if (operation.equalsIgnoreCase("Edit")) {
            try{
                Student searchedStudent = studentFacade.find(id);
            if(searchedStudent==null){
                  out.print("Sorry, wrong Student ID!<br><br>");
            }
                
            if(cid.equals("")){
                            searchedStudent.setAddress(address);
                            searchedStudent.setEmail(email);
                            searchedStudent.setGender(gender);
                            searchedStudent.setPassport(passport);
                            searchedStudent.setPhone(phone);
                            searchedStudent.setName(name);
                            studentFacade.edit(searchedStudent);
                            out.print("Student information modified!<br><br>");
                }
                else if(c==null){
                            searchedStudent.setAddress(address);
                            searchedStudent.setEmail(email);
                            searchedStudent.setGender(gender);
                            searchedStudent.setPassport(passport);
                            searchedStudent.setPhone(phone);
                            searchedStudent.setName(name);
                            studentFacade.edit(searchedStudent);
                            out.print("Student information modified!<br><br>");
                            out.print("But Class ID was Wrong!<br><br>");
                        //request.getRequestDispatcher("adminpage.jsp").forward(request, response);
                }
                            boolean g = false;
                            for(int h=0; h<searchedStudent.getClasseslist().size();h++){
                                //student has class
                               if(c.equals(searchedStudent.getClasseslist().get(h))){
                                    g=true;
                                    searchedStudent.setAddress(address);
                                searchedStudent.setEmail(email);
                                searchedStudent.setGender(gender);
                                searchedStudent.setPassport(passport);
                                searchedStudent.setPhone(phone);
                                searchedStudent.setName(name);
                                studentFacade.edit(searchedStudent);
                                out.print("Student information modified!<br><br>");
                                out.print("But student already in this class！"); 
                                break;
                               } 
                            }
                            
                        boolean p = false; 
                        if(!g){
                            
                             //when add/edit class, if class started ....
                            for(int  y= 0;y<alist.size();y++){
                                
                                    if(alist.get(y).getSche().equals(c.getScheList().get(0))) {
                                        out.print("Sorry, the class already started!<br><br>");
                                        p=true;
                                        break;   
                                    } 
                                
                            }
                        }  
                        
                         if(!p){
                            searchedStudent.setAddress(address);
                            searchedStudent.setEmail(email);
                            searchedStudent.setGender(gender);
                            searchedStudent.setPassport(passport);
                            searchedStudent.setPhone(phone);
                            searchedStudent.setName(name);
                           
                           
                              
                            //add student to class
                            if(!g){
                                 searchedStudent.getClasseslist().add(c );
                            
                            for(int k =0;k<c.getScheList().size();k++){
                                searchedStudent.getSchelist().add(c.getScheList().get(k));
                            }
                            
                            c.getSlist().add(searchedStudent);
                            classFacade.edit(c); 
                             studentFacade.edit(searchedStudent);
                          
                 
                            out.print("Student edit successful！");
                            }  
                            
                           
                           
                        }
                        
                        
                        
                        
             
                  
                   
              
               
               
              
              
               
              
                    
                
               /*   if(!shift){
            
                       Classes c1 = classFacade.find(searchedStudent.getC());
                   c1.getSlist().remove(searchedStudent);
              classFacade.edit(c1); 
               for(int i=0;i<alist.size();i++){
               if( searchedStudent.equals(alist.get(i).getStu())){
                 attendanceFacade.remove(alist.get(i));
           }
           }
                   c.getSlist().add(searchedStudent);
                  classFacade.edit(c); 
                   searchedStudent.setAddress(address);
             searchedStudent.setEmail(email);
             searchedStudent.setGender(gender);
             searchedStudent.setPassport(passport);
             searchedStudent.setPhone(phone);
             searchedStudent.setName(name);
             searchedStudent.setCla(cid);
             //***
              searchedStudent.getClasseslist().add(c);
             //
                   studentFacade.edit(searchedStudent);
                   
                   
                  out.print("Student edit successful！");

                  }
                 
                  */  
                    
                  
                
                
           
            
            
             
           
             }catch(Exception e){
                
            }
            
        } else if (operation.equalsIgnoreCase("Delete")) {
            try{
               // Schedule sche = scheduleFacade.find(id)
            Student searchedStudent = studentFacade.find(id);
            
            //delete all classes of this student
             if(searchedStudent==null){
                  out.print("Sorry, wrong Student ID!<br><br>");
            }
            
            //delete student from all classes 
            for(int l = 0;l<searchedStudent.getClasseslist().size();l++){
               
                    searchedStudent.getClasseslist().get(l).getSlist().remove(searchedStudent);
                    classFacade.edit(searchedStudent.getClasseslist().get(l)); 
                
               
            }
            searchedStudent.getClasseslist().clear();
           //c.getSlist().remove(searchedStudent);
           
           //alist.remove(stu);
           for(int i=0;i<alist.size();i++){
               if(searchedStudent.equals(alist.get(i).getStu())){
                 attendanceFacade.remove(alist.get(i));
           }
           }
           ///attendanceFacade.findAll().remove(stu);
           //scheduleFacade.findAll().remove(searchedStudent);
           searchedStudent.getSchelist().clear();//.remove(stu);
           studentFacade.edit(searchedStudent);
           studentFacade.remove(searchedStudent);
            out.print("Student delete successful！");
             }catch(Exception e){
                
            }
           
           
            
        } else if (operation.equalsIgnoreCase("Search")) {
            try{
                
            Student searchedStudent = studentFacade.find(id);
            if(searchedStudent ==null){
                 out.print("Sorry, wrong Student ID!<br><br>");
            }else{
                 request.setAttribute("stu", searchedStudent);
                  request.setAttribute("scheid2",scheduleid);
                  request.setAttribute("hidden2", "!");
                 //***************************************************
                 //ArrayList<Attendance> alist = new ArrayList<Attendance>();
         // alist.addAll(attendanceFacade.findAll());
         // out.print("<td><a >"+ stu.getC() + "</a></td>\n");
         
                 
                 
                 
                 //*****************************
                 
                 
                 
                 
                 
                 //request.setAttribute("att", searchedStudent);
            }
           
             }catch(Exception e){
                
            }
        }else if (operation.equalsIgnoreCase("Clear")) {
            try{
                
                    request.setAttribute("stu", null);
                    request.setAttribute("scheid2",  null);
                    request.setAttribute("atte",  null);
                    request.setAttribute("attn", null);
                    //request.setAttribute("hidden", "!");
            }catch(Exception e){}
            
        }else if (operation.equalsIgnoreCase("Check Attendance")) {
            try{
                   
                 Student searchedStudent = studentFacade.find(id);
               boolean sss = false;    
            if(searchedStudent != null){
                for(int k=0;k<searchedStudent.getClasseslist().size();k++){
                    if(searchedStudent.getClasseslist().get(k).getId().equals(cid)){
                        request.setAttribute("hidden2", "!");
                      sss = true;
                  request.setAttribute("stu", searchedStudent);
                  request.setAttribute("scheid2",scheduleid); 
                  request.setAttribute("classid",cid); 
                        int i=0;
         int ar = 0;
         int g =0;
          int x=1;
          int p =0;
          while(x<9){
             
              if(scheduleid.equals(x+"")){
                 
               while(i<alist.size()){
                    if(searchedStudent.equals(alist.get(i).getStu())&&cid.equals(alist.get(i).getClasses().getId())){
                      //  request.setAttribute("atte", alist.get(i).getStatus());
                         //out.print(ar+"/n");
                         g++;
                         if(alist.get(i).getStatus().equals("Present")){
                             ar++; 
                             //out.print("***"+ar+"***");
                         }
                             
                       // break;
                        if(alist.get(i).getSche().getOrder()==Integer.valueOf(scheduleid)){//最后一个p==(x-1
                            request.setAttribute("atte", alist.get(i).getStatus());
                           // g=x;
                          // break;
                       }
                       i++;
                      p++;
                    }else{
                        i++;
                    }
                }
               break;
                   
            } else{
                  x++;
              }
          }
        
         
           request.setAttribute("hidden", "!");
         
          
           int j = x-1;
           float attn =100*ar/g;
            // out.print(attn+"%");  
           // out.print(j);
           // out.print(ar);
             request.setAttribute("attn", attn); 
                        
                        // request.setAttribute("hidden", "!");
                         break;
                    }
                }
                if(!sss){
                        out.print("Sorry, wrong Class ID, please enter A correct ClassID!<br><br>");
                       
                    }
            }else{
                 out.print("Sorry, wrong Student ID!<br><br>");
            }
                    
                   
            }catch(Exception e){}
            
        }else if (operation.equalsIgnoreCase("Delete student from this class")) {
            try{
                  Student searchedStudent = studentFacade.find(id);
            
                if(c==null){
                 out.print("Sorry, wrong Class ID!<br><br>");
                        
             }else{
                   c.getSlist().remove(searchedStudent);
                   classFacade.edit(c);
                   
                    searchedStudent.getClasseslist().remove(c);
                    studentFacade.edit(searchedStudent);
                    
                    boolean x = false;
                    boolean y =false;
                    for(int i=0;i<alist.size();i++){
                        
                        if( searchedStudent.equals(alist.get(i).getStu())&&c.equals(alist.get(i).getClasses())){
                            attendanceFacade.remove(alist.get(i));
                           x=true;
                          
                        }
                       
                    }
                    
                    //check if class started or not yet-----no attendance 
                  /*  for(int i=0;i<alist.size();i++){
                        
                        
                        if(alist.get(i).getClasses().equals(c)){
                            y = true;
                            
                        }
                    }*/
                  //  if(x){
                  
                        //searchedStudent.getSchelist().size()
                            for(int i =0;i<c.getScheList().size();i++){
                          //  if(c.getScheList().get(i).equals(searchedStudent.getSchelist().get(i))){
                            searchedStudent.getSchelist().remove(c.getScheList().get(i));
                            studentFacade.edit(searchedStudent);
                            y=true;
                            
                            
                           // }
                            } 
                        if(y){
                            out.print("Removed!<br><br>");
                        }else {
                            out.print("Remove failed!<br><br>");
                        }
                        
                   // }
                    
                   
                    
                }  
                     
                   
            }catch(Exception e){}
            
        } else if (operation.equalsIgnoreCase("Modify Attendance")) {
            try{ 
                Student searchedStudent = studentFacade.find(id);
                boolean p = false;
               //modify attendance  ---else : no attendance 
               if(scheduleid.equals("")){
                   out.print("Please select a schedule then click the button one more time! !<br><br>");
               }else{
                    for(int  y= 0;y<alist.size();y++){
                   if(c.equals(alist.get(y).getClasses())&&searchedStudent.equals(alist.get(y).getStu())&&alist.get(y).getSche().getOrder()==Integer.valueOf(scheduleid)){
                                    alist.get(y).setStatus(att);
                                    attendanceFacade.edit(alist.get(y)); 
                                    p=true;
                                    out.print("Attendance Modified!<br><br>");
                                    break;
                    }
                 }
            if(!p){
                 out.print("Class not start yet, you cannot create attendance for this student!<br><br>");
            }
               }
              
            
            
            
            }catch(Exception e){}}
             out.print("");  
            request.getRequestDispatcher("addstudent.jsp").include(request, response);
           
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
