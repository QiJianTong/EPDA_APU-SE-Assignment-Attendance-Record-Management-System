<%-- 
    Document   : searchclass
    Created on : Aug 28, 2018, 11:55:17 AM
    Author     : 91310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
       <form action="SearchClass" method="POST">
            <table>
                <tr>
                    <td>
                        Class ID:
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
                        <input type="text" name="lecid" value="${c.lecid}" size="20">
                    </td>
                </tr>
                
            </table>
              <tr>
                    
                    <input type="Submit" name="s" value="Search" />
                </tr>  
        </form>
                    
                     <form action="LectClass" method="POST">  
                     <input type="Submit" name="all" value="Classes" />
        </form>
    </body>
</html>
