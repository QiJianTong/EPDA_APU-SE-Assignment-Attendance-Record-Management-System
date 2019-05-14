<%-- 
    Document   : hosprofile
    Created on : Aug 29, 2018, 9:43:57 PM
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

        </style>
    </head>
    <body>
         <td><a href="hos.jsp">Home</a></td>   |
        <td><a href="hosprofile.jsp">My Profile</a></td>   |
        <td><a href="allatt.jsp ">View Attendance</a></td>   |
        <td><a href="addclass.jsp">Class Management</a></td>   
        <td><a href="login.jsp">Logout</a></td>   
         <form action="EditHos" method="POST">
            <table>
                <tr>
                    <td>
                        ID:
                    </td> 
                    <td>
                        <input type="text" name="id" value="${hos.id}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Name:
                    </td> 
                    <td>
                        <input type="text" name="name" value="${hos.name}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Gender:
                    </td> 
                    <td>
                        <input type="text" name="gender" value="${hos.gender}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Phone:
                    </td> 
                    <td>
                        <input type="text" name="phone" value="${hos.phone}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Passport:
                    </td> 
                    <td>
                        <input type="text" name="passport" value="${hos.passport}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                       Email:
                    </td> 
                    <td>
                        <input type="text" name="email" value="${hos.email}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Address:
                    </td> 
                    <td>
                        <input type="text" name="address" value="${hos.address}" size="20">
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
