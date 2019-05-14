<%-- 
    Document   : addstudent
    Created on : 2019-5-12, 18:59:39
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Management</title>
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
         <h1>Student Management Page</h1>
 <form action="ManageStudent" method="POST">
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
                        Class ID:
                    </td> 
                    <td>
                        <input type="text" name="classid" value="${classid}" size="20">
                        <input type="Submit" name="operation" value="Delete student from this class" />
                        <input type="Submit" name="operation" value="Check Attendance" /><br>
                    </td>
                 <br>
                     
                  
                </tr>
                <tr><td></td><td>Please enter a single class id to check attendance</td></tr>
                
                 <tr ${hidden2}hidden>
                    <td>
                        Class List:
                    </td> 
                    <td>
                        <input type="text" name="cid" value="${stu.classeslist}" size="100">
                    </td>
                     
                   
                </tr>
                 <tr>
                     <td ${hidden}hidden>
                        Schedule ID:
                    </td> 
                    <td ${hidden}hidden>
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
                        Please select a schedule then click the button one more time! 
                    </td>
                    
                </tr>
                <tr>
                    <td  ${hidden}hidden >
                       Attendance:
                    </td> 
                    
                    <td ${hidden}hidden>
                        <select    name="att" >
                         <option value="${atte}">${atte}</option>
                        <option value ="Present">Present</option>
                        <option value ="Absent" >Absent</option>
                        <option value ="Null">Null</option>
                        </select>
                        Total Attendance:  ${attn}%
                         <input type="Submit" name="operation" value="Modify Attendance" />
                    </td>
                    <td   ${hidden}hidden >
                     
                    </td> 
                    <td   ${hidden}hidden >
                       
                    </td> 
                </tr>
                
               
                
            </table>
              <tr>
                    <td colspan="2">
                    <input type="Submit" name="operation" value="Add" />
                    <input type="Submit" name="operation" value="Edit" />
                    <input type="Submit" name="operation" value="Delete" />
                    <input type="Submit" name="operation" value="Search" />
                    <input type="Submit" name="operation" value="Clear" />
                    </td>
                </tr>  
        </form>
                 <form action="AllStudents" method="POST">  
                     <input type="Submit" name="all" value="All Students" />
                 </form>
                     <form action="AllClasses" method="POST">  
                     <input type="Submit" name="all" value="All Classes" />
                    
                 </form>
    </body>
</html>
