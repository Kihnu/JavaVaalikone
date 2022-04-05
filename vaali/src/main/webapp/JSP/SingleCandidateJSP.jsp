<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Candidates"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href=CSS/Allcandidates.css>
<title>Candidates name</title>
</head>
<body>
	<form method="get" action="/AllCandidatesServlet">
		<button type="submit" class=exitbutton>Back</button>
	</form>

	<!-- Kuva tietystä ehdokkaasta -->
	<h1>More Information on Candidate</h1>
	<label>Candidate number: <%
		System.out.println("Tietokannasta");
	%></label>
	<label>Party: <%
		System.out.println("Tietokannasta");
	%>
	</label>
	<label>Profession: <%
		System.out.println("Tietokannasta");
	%>
	</label>

	<c:forEach var="candidates" items="${requestScope.Candidates}">
		<tr>
			<td>


				<div>
					<h2>${candidates.firstname}${candidates.surname}</h2>
					<Br> Election number: ${candidates.vote_nro} <Br> Party: ${candidates.party} <Br>
					<Br>
				</div>

			</td>

		</tr>

	</c:forEach>


	<b>Extra information</b>
	<%
		System.out.println("Tietokannasta infoa ehdokkaalle 1");
	%>


</body>
</html>
