<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.mvmWeb.demoTest.EmployeeDao"  %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <jsp:useBean id="obj" class="com.mvmWeb.demoTest.Employee"></jsp:useBean>
       <jsp:setProperty property="*" name="obj"/>
        
        <% session.invalidate(); %>
        
       <%
            int i = EmployeeDao.register(obj);
           
       
       %>
    </body>
</html>
