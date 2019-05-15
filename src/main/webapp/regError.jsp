<%@ page import="java.lang.String" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration Failure</title>
</head>
<body>

    <ul>
    <%
    String [] errors = (String []) request.getAttribute("error");


               for(String error : errors){
                    out.println("<li>" + error + "</li>");
               }

    %>
    </ul>


<h1>${requestScope.data}</h1>
    <a href="/loginproject/main">Return to administrator menu</a>
</body>
<html>