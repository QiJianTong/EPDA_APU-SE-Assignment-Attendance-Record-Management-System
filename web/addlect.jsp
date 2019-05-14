<%-- 
    Document   : addclass
    Created on : Aug 26, 2018, 7:54:00 PM
    Author     : 91310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lecturer Management</title> 
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
        <td><a href="adminpage.jsp">Home</a></td>   |
        <td><a href="addlect.jsp">Lecturer Management</a></td>   |
        <td><a href="addhos.jsp">Head of school Management</a></td>   |
        <td><a href="addstudent.jsp">Student Management</a></td>  | 
        <td><a href="login.jsp">Logout</a></td>  
         
         <h1>Lecturer Management Page</h1>
      <form action="ManageLect" method="POST">
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
                 <tr>
                    <td>
                        Head of School ID:
                    </td> 
                    <td>
                        <input type="text" name="hid" value="${lec.hos1.id}" size="20">
                    </td>
                </tr>
               
                
            </table>
              <tr>
                    <td colspan="2">
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
                    <br><br>
                   <form action="Allhos" method="POST">  
                     <input type="Submit" name="all" value="All Head of Schools" />
                 </form>
    </body>
</html>
