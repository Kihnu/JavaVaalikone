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

	<c:forEach var="comparison" items="${requestScope.comparison}">
		<div>
			<!-- Tietokannan taulun id  -->
			<!-- <div class="TableId">${comparison.id}</div> -->
			<!-- Kandidaatin ID -->
			<div class="ComparisonID">Candidate ${comparison.comparisonID}#</div>
			<!-- Kandidaatin prosentti samaa mieltä, "average" -->
			<div class="Average%">${comparison.comparisonPercent} %</div> 
			<br>
			

			<hr class="solid">
		</div>

	</c:forEach>
	<div>


		<br> <br> <br>




	</div>

</body>
</html>