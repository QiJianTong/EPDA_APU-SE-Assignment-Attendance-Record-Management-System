<%-- 
    Document   : login
    Created on : Aug 26, 2018, 3:20:05 PM
    Author     : 91310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>APU Attendace Recording System (ARS) Login Page</title>
        <style>
body
{
	background-color:#d0e4fe;
}
h1
{
	color:orange;
	text-align:center;
}
form
{
	
        position:absolute;
        left:600px;
        top:150px;
}

p
{
	font-family:"Times New Roman";
	font-size:60px;
}
div
{
	margin:15px;
	width:300px; 
	padding:5px;
	height:350px;
	border:2px solid black;
	outline:2px solid red;
	outline-offset:15px;
}
.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 5px 85px;
    cursor: pointer;
}
.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
</style>
    </head>
    <body>
        <h1>Welcome to the APU Attendace Recording System (ARS) Login Page</h1>
        <form action="Login" method="POST">
           
            <div>
            <table>
                <tr>
                    <td>
                        User Name:
                    </td> 
                    <td>
                        <input type="text" name="id" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Password:
                    </td> 
                    <td>
                        <input type="password" name="passport" size="20">
                    </td>
                </tr>
                <tr>
                <select name="usertype" >
                        <option value ="admin">Administrative officer</option>
                        <option value ="student" name ="student">Student</option>
                        <option value ="lecturer">Lecturer</option>
                        <option value ="hos">Head of School</option>
                </select>
                </tr>
            </table>
            <p>
                <input type="submit" value="Login" class="button">
            </p>
            </div>
        </form>
    </body>
</html>
