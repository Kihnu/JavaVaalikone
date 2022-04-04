<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Comparison"%>
<%@ page import="data.Candidates"%>
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

		<br> The BEST CANDIDATE FOR YOU IS

	</h1>


	<c:forEach var="candidates" items="${requestScope.candidates}">
		<div>
			<!-- Kandidaatin koko nimi -->
			<div class="name">${candidates.firstname}${candidates.surname}</div>
			<!-- Kandidaatin puolue -->
			<div class="party">${candidates.party}</div>
			<!-- Kandidaatin numero -->
			<div class="candidateNum">Candidate number:
				${candidates.vote_nro}#</div>
			<br>
			<hr class="solid">
		</div>
	</c:forEach>

	<c:forEach var="comparison" items="${requestScope.comparison}">
		<div>
			<!-- Tietokannan taulun id  -->
			<!-- <div class="TableId">${comparison.id}</div> -->
			<!-- Kandidaatin ID -->
			<!--  <div class="ComparisonID">Candidate ${comparison.comparisonID}#</div> -->

			<!-- Kandidaatin prosentti samaa mieltä, "average" -->
		<div class="Average%">${comparison.comparisonPercent}%</div>
		<br>
		<hr class="solid">
		</div>
	</c:forEach>
	<div>

		<br> <br>

	</div>

</body>
</html>