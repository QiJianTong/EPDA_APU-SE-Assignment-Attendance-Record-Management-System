<%-- 
    Document   : studentpage
    Created on : Aug 26, 2018, 3:20:56 PM
    Author     : 91310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Page</title>
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
    <h1>Student Page</h1>
    
       <td><a href="login.jsp">Logout</a></td>   
       <form  action="EditStu" method="POST">
            <table>
                <tr>
                    <td>
                        ID:
                    </td> 
                    <td>
                        <input type="text" name="id" value="${stu.id}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Name:
                    </td> 
                    <td>
                        <input type="text" name="name" value="${stu.name}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Gender:
                    </td> 
                    <td>
                        <input type="text" name="gender" value="${stu.gender}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Phone:
                    </td> 
                    <td>
                        <input type="text" name="phone" value="${stu.phone}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Passport:
                    </td> 
                    <td>
                        <input type="text" name="passport" value="${stu.passport}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                       Email:
                    </td> 
                    <td>
                        <input type="text" name="email" value="${stu.email}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Address:
                    </td> 
                    <td>
                        <input type="text" name="address" value="${stu.address}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Class List:
                    </td> 
                    <td>
                        <input type="text" name="clist" value="${stu.classeslist}" size="20">
                    </td>
                </tr>
                
            </table>
              <tr>
                    
                  
                    <td colspan="2">
                    <input type="Submit" name="operation" value="View" />
                    <input type="Submit" name="operation" value="Save" /><br><br>
                    
                     Input A single Class ID to check attendance:
                     <input type="text" name="a" value="" size="20">
                     <input type="Submit" name="operation" value="View Attendance" />
                    </td>
                    
                    
                    
                </tr>  
        </form>
         
         
    </body>
</html>
