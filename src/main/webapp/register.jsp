<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.lang.String" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<link href="resources/styles.css" type="text/css" rel="stylesheet">
</head>
<body>
<div align="center">
<h2><b><U>Registration Form</U></b></h2>

<h3>
        <ul style="list-style: none;">
        <%
        ArrayList<String> errors = (ArrayList)  request.getAttribute("errors");

            if(!errors.isEmpty()){
                   for(String error : errors){
                        out.println("<li>" + error + "</li>");
                   }
            }

        %>
        </ul>
</h3>

<div align="left">
    <form action="regapp" method="POST">
        Login: <input name="login" />
        Password: <input name="password1" />
        Password Again: <input name="password2" />
        First Name: <input name="firstname" />
        First Name: <input name="lastname" />
        <br><br>
        <input type="submit" value="Register" />
    </form>
</div>
<h1>${requestScope.data}</h1>
    <a href="/loginproject/main">Return to administrator menu</a>
</body>
</html>