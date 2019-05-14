<%-- 
    Document   : allatt
    Created on : Aug 29, 2018, 10:02:49 PM
    Author     : 91310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Class Attendance Record</title>
         <style>
            body
{
	background-color:#d0e4fe;
        position: absolute;
        left:600px;
        top:100px;
}
h3
{
	color:darkblue;
	text-align:center;
}

        </style>
    </head>
    
    <body>
     <td><a href="hos.jsp">Home</a></td>   |
        <td><a href="hosprofile.jsp">My Profile</a></td>   |
        <td><a href="allatt.jsp ">View Attendance</a></td>   |
        <td><a href="addclass.jsp">Class Management</a></td>   
        <td><a href="login.jsp">Logout</a></td>   
        <h3>View Class Attendance Record</h3>
                     <form action="Allatt" method="POST">  
                     
                     <tr>
                    <td>
                        Class ID:
                    </td> 
                    <td>
                        <input type="text" name="cid" value="${c.id}" size="20">
                    </td>
                     <br><br>
                    <td>
                        Schedule ID:
                    </td> 
                    <td  >
                        <select    name="scheid" >
                             <option value ="${scheid2}">${scheid2}</option>
                         <option value ="1">1</option>
                        <option value ="2">2</option>
                        <option value ="3">3</option>
                        <option value ="4">4</option>
                         <option value ="5">5</option>
                        <option value ="6">6</option>
                        <option value ="7">7</option>
                        <option value ="8">8</option>
                        </select>
                       
                    </td>
                </tr>
                     <tr>
                    
                    <input type="Submit" name="s" value="Search" />
                </tr>  
        </form>
    </body>
</html>
