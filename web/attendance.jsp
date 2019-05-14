<%-- 
    Document   : attendance
    Created on : Aug 27, 2018, 11:25:29 PM
    Author     : 91310
--%>


<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="java.util.List"%>
<%@page import="model.ClassFacade"%>
<%@page import="javax.ejb.EJB"%>
<%@page import="model.Classes"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mark Attendance</title>
           <style>
            body
{
	background-color:#d0e4fe;
        position: absolute;
        left:600px;
        top:100px;
}
h1
{
	color:darkblue;
	text-align:center;
}
h2
{
	color:darkblue;
	text-align:center;
}

        </style>
    </head>
    <body>
        <td><a href="lecturer.jsp">Home</a></td>   |
        <td><a href="lectprofile.jsp">My Profile</a></td>   |
        <td><a href="attendance.jsp ">Mark Attendance</a></td>   |
        
         <td><a href="login.jsp">Logout</a></td>   
         <h2>Seclect a class to mark attendance.</h2>
            
       
        <form action="MarkAtt" method="POST">  
              
                     <tr>
                    <td>
                        ID:
                    </td> 
                    <td>
                        <input type="text" name="cid" value="${c.id}" size="20" >
                    </td>
                   
                </tr>
                       <tr>
                    <td>
                        Schedule ID:
                    </td> 
             
            <select name="scheid">
                
                <option value="0">1</option>
                <option value="1">2</option>
                <option value="2">3</option>
                <option value="3">4</option>
                <option value="4">5</option>
                <option value="5">6</option>
                <option value="6">7</option>
                <option value="7">8</option>
            </select>
                         
                     
                    
                    <input type="Submit" name="s" value="Search" />
                </tr>  
        </form>
        
        <form action="LectClass" method="POST">  
                     <input type="Submit" name="all" value="Classes" />
        </form>
        
    </body>
</html>
