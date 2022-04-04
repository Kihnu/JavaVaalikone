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
			<div class="id">${comparison.comparisonID}</div>
			<div class="firstname">${comparison.id}</div>
			<div class="surname">${comparison.Comp}</div>
			<br>
			<!-- Candidaatin prosentti samaa mieltä, comparison % tulos -->

			<!-- <div class="comparison">${comparison.size()}</div>  -->

			<hr class="solid">
		</div>

	</c:forEach>
	<div>


		<br> <br> <br>




	</div>

</body>
</html>