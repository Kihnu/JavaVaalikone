<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %> 
<%@ page import="data.Candidates" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href=CSS/Allcandidates.css>
<title>All Candidates</title>
</head>
<body>
<h1>All Candidates</h1>

<form method ="get" action= "/SingleCandidate" >


<%int i = 0; %>


<table class="allcandidates" >


<c:forEach var="candidates" items="${requestScope.Candidates}">
<tr>
<td>

${candidates.firstname} ${candidates.surname}
 <Br>
 <button name="info<%=i%>" type="submit">
      More information 
    </button>
<br>
<br>
</td>
</tr>

<%i++;%>
</c:forEach>


</table>

</form>
</body>
</html>
