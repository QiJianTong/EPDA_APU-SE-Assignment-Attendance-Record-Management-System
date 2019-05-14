<%-- 
    Document   : addclass
    Created on : Aug 27, 2018, 9:39:04 AM
    Author     : 91310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Class</title>
    </head>
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
    <body>
        <td><a href="hos.jsp">Home</a></td>   |
        <td><a href="hosprofile.jsp">My Profile</a></td>   |
        <td><a href="allatt.jsp ">View Attendance</a></td>   |
        <td><a href="addclass.jsp">Class Management</a></td>   
        <td><a href="login.jsp">Logout</a></td>   
        <p>Hello! You logged in as: ${hos.id}</p>
       <form action="addClasses" method="POST">
            <table>
                <tr>
                    <td>
                        ID:
                    </td> 
                    <td>
                        <input type="text" name="id" value="${c.id}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Name:
                    </td> 
                    <td>
                        <input type="text" name="name" value="${c.classname}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Lecturer ID:
                    </td> 
                    <td>
                        <input type="text" name="lecid" value="${c.lecturer.id}" size="20">
                    </td>
                </tr>
                
            </table>
              <tr>
                    <td >
                    <input type="Submit" name="operation" value="Add" />
                    <input type="Submit" name="operation" value="Edit" />
                    <input type="Submit" name="operation" value="Delete" />
                    <input type="Submit" name="operation" value="Search" />
                    
                    </td>
                </tr>  
        </form>
                 <form action="Alllect" method="POST">  
                     <input type="Submit" name="all" value="All Lecturers" />
                 </form>
                    
                     <form action="AllClasses" method="POST">  
                     <input type="Submit" name="all" value="All Classes" />
                     
                 </form>
                  
    </body>
</html>
