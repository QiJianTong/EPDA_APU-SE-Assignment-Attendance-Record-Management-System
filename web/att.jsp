<%-- 
    Document   : att
    Created on : Aug 28, 2018, 2:58:13 PM
    Author     : 91310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Save Attendance for this Class</title>
    </head>
    <body>
        <td><a href="lecturer.jsp">Home</a></td> 
        <form action="SaveAtt" method="POST"> 
        
          <table border=\"1\">
          <tr>
                    <td>
                        ID:
                    </td> 
                    <td>
                        <input type="text" name="sid" value="${stu.id}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Attendance:
                    </td> 
                    <td>
                        <input type="text" name="att" value="${stu.attendance}" size="20">
                    </td>
                </tr>
   
  
   
          </table>
            <tr>
                    <td colspan="2">
                    <input type="Submit" name="operation" value="Previous" />
                    <input type="Submit" name="operation" value="Next" />
                    <input type="Submit" name="operation" value="Finish" />
                    
                    
                    </td>
                </tr>
            
            
            
            
        
        
        
        </form>
    </body>
</html>
