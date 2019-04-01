<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="edu.aritra.web.db.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
    List<Student> studentList = (List<Student>)request.getAttribute("result");
    Student student = studentList.get(0);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet Example</title>
</head>
<body>
    This is data page served @: <%= request.getContextPath() %><br/>
    <%= student.getName() %> : <%= student.getBranch() %>
</body>
</html>