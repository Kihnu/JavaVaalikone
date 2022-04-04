<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

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

	<form method="get" action="/index.html">
		<button type="submit" class=exitbutton>To main page</button>
	</form>

	<form>
		<button type="button" class=backbutton onclick="history.back()">Edit answers</button>
	</form>
	<br>
	<br>
	<h1>The results are in:</h1>

	<c:forEach var="candidates" items="${requestScope.candidates}"
		varStatus="status">
		<div class="cand">
			<!-- Kandidaatin koko nimi -->
			<div class="name">${candidates.firstname} ${candidates.surname}</div>
			<!-- Kandidaatin puolue -->
			<div class="party">${candidates.party}</div>
			<!-- Kandidaatin numero -->
			<div class="candidateNum">Candidate #${candidates.vote_nro}</div>
			<div>
				<br>
				<%!String color;%>
				<c:choose>
					<c:when test="${comparison[status.index].comparisonPercent <= 80}">
						<%
							color = "#86BF5E";
						%>
					</c:when>
					<c:when test="${comparison[status.index].comparisonPercent <= 60}">
						<%
							color = "#FFFB00";
						%>
					</c:when>
					<c:when test="${comparison[status.index].comparisonPercent <= 40}">
						<%
							color = "#FFA200";
						%>
					</c:when>
					<c:when test="${comparison[status.index].comparisonPercent <= 20}">
						<%
							color = "#FF0000";
						%>
					</c:when>
					<c:otherwise>
						<%
							color = "#00FF00";
						%>
					</c:otherwise>
				</c:choose>
				<div style="color:<%=color%>;" class="average">
					<c:out value="${comparison[status.index].comparisonPercent}" />
					%
				</div>

			</div>
			<hr class="solid">
		</div>
	</c:forEach>

</body>
</html>