<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Candidates"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href=CSS/Allcandidates.css>
<title>All Candidates</title>
</head>
<body>


<form method="get" action="/index.html">
	<button type="submit" class= exitbutton>To main page </button>
	</form>
	<Br>
	<Br>
	
	<h1>All Candidates</h1>
	
	
	

	<form method="get" action="/SingleCandidate">


		<%
			int i = 0; int j = 1;
		%>


		<table class="allcandidates">


			<c:forEach var="candidates" items="${requestScope.Candidates}">
				<tr>
					<td>
					
				
				
				<h2>${candidates.firstname} ${candidates.surname} </h2>
				
					<img src="/images/kuva<%=j%>.png"> <Br>
					
					Election number: ${candidates.vote_nro} <Br>
					Party: ${candidates.party}
				
				
					<Br>
					<Br>
						<button class= infobutton name="info<%=i%>" type="submit">More information
						</button> <br> <br> <br> 
					</td>
				
				</tr>

				<%
					i++; j++;
				%>
			</c:forEach>


		</table>

	</form>
</body>
</html>
