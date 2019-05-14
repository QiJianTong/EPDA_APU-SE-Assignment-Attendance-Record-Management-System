<%-- 
    Document   : testlist
    Created on : Aug 29, 2018, 3:08:13 PM
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
        <form action="SaveAtt" method="POST>"
        <c:forEach var="file" items="${cla.slist}">
			
            <tr>
                <td> <a href="showfiles.do?level=${model.level+1}&filename=${file.fileName}">${file.fileName}</td>
                <td> ${stu.id}1</td>
                <td> ${stu.attendance}2</td>
                <td> <a href="MarkAtt.do?cid=2">下载</a></td>
            </tr>
            
        </c:forEach>
                 <input type="Submit" name="all" value="All Students" />
        </form>
            
    </body>
</html>
