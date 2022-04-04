<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Comparison"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/Results.css">
<title>Results</title>
</head>
<body>
	<h1>

		<br> BEST CANDIDATE FOR YOU IS...

	</h1>

	<c:forEach var="candidates" items="${requestScope.candidates}">
		<div>
			<!-- Tietokannan taulun id  -->
			<div class="id">${comparison.comparisonID}</div>
			<!-- Kandidaatin ID -->
			<div class="firstname">${comparison.id}</div>
			<!-- Kandidaatin prosentti samaa mielt�, "average" -->
			<div class="surname">${comparison.Comp}</div>
			<br>
			

			<hr class="solid">
		</div>

	</c:forEach>
	<div>


		<br> <br> <br>




	</div>

</body>
</html>