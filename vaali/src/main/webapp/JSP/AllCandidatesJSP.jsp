<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %> 
 <%@ page import="data.Candidates" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Candidates</title>
</head>
<body>
<h1>All Candidates</h1>

<%
ArrayList<Candidates> Candidates=(ArrayList<Candidates>)request.getAttribute("Candidates");

for (int i=0;Candidates!=null && i<Candidates.size();i++){
	Candidates c=Candidates.get(i);
	
	
	out.println(c.getId()+c.getId()+c.getfirstname()+ c.getsurname());
}
%>
</body>
</html>
