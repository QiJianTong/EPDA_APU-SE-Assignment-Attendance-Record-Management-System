<%-- 
    Document   : lectprofile
    Created on : Aug 27, 2018, 10:18:13 PM
    Author     : 91310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Profile</title>
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
         <h2>Edit Your Information</h2>
     
        
        <form action="EditLect" method="POST">
            <table>
                <tr>
                    <td>
                        ID:
                    </td> 
                    <td>
                        <input type="text" name="id" value="${lec.id}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Name:
                    </td> 
                    <td>
                        <input type="text" name="name" value="${lec.name}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Gender:
                    </td> 
                    <td>
                        <input type="text" name="gender" value="${lec.gender}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Phone:
                    </td> 
                    <td>
                        <input type="text" name="phone" value="${lec.phone}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Passport:
                    </td> 
                    <td>
                        <input type="text" name="passport" value="${lec.passport}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                       Email:
                    </td> 
                    <td>
                        <input type="text" name="email" value="${lec.email}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Address:
                    </td> 
                    <td>
                        <input type="text" name="address" value="${lec.address}" size="20">
                    </td>
                </tr>
                
                
            </table>
              <tr>
                    
                  
                    <td colspan="2">
                    <input type="Submit" name="operation" value="View" />
                    <input type="Submit" name="operation" value="Save" />
                    
                    </td>
                    
                    
                    
                </tr>  
        </form>
                
        
        
    </body>
</html>
