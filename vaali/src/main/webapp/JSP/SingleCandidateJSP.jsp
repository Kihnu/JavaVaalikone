<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>       
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidates name</title>
</head>
<body>
<!-- Kuva tietystä ehdokkaasta -->
<h1><% System.out.println("Ehdokas 1"); %></h1>
<text>Candidate number: <% System.out.println("Tietokannasta"); %></text>
<text>Party: <% System.out.println("Tietokannasta"); %> </text>
<text>Profession: <% System.out.println("Tietokannasta"); %> </text>

<b>Extra information</b>
<% System.out.println("Tietokannasta infoa ehdokkaalle 1"); %>
</body>
</html>
