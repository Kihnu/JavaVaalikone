<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.SingleCandidateAnswers"%>
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


	<form method="get" action="http://localhost:8080/AllCandidatesServlet">
		<button type="submit" class=exitbutton>Back</button>
	</form>
	<br>

	<!-- Kuva tietystä ehdokkaasta -->

	<h1>More Information on Candidate</h1>
	<div class="allCandidatesEdit">
		<label><b>Candidate number:</b>
			${requestScope.candidate.vote_nro}</label> <label><b>Name:</b>
			${requestScope.candidate.firstname} ${requestScope.candidate.surname}</label>
		<label><b>Party:</b> ${requestScope.candidate.party}</label>

		<!-- IKÄ -->


		<label><b>Profession:</b> ${requestScope.candidate.profession}</label>
		<label><b>Extra information:</b> ${requestScope.candidate.why}</label>
		<label><b>What more:</b>${requestScope.candidate.what}</label>
	</div>
	<h1>More Information on Candidates answers to questions</h1>

	<%
		int i = 1;
	%>

	<c:forEach var="candi" items="${requestScope.singleCandidate}">
		<div class="allCandidatesEdit">
			<h3>
				Question
				<%=i%>: ${candi.question}
			</h3>
			<br>

			<div>${candi.answer_int}</div>
			<br>
			<!--  -->
			<c:choose>
				<c:when test="${candi[status.index].answer_int == 1}">
						yksi
						<%
					
				%>
				</c:when>
				<c:when test="${candi[status.index].answer_int == 2}">
					kaksi
						<%
					
				%>
				</c:when>
				<c:when test="${candi[status.index].answer_int == 3}">
					kolme
					<%
						
					%>
				</c:when>
				<c:when test="${comparison[status.index].comparisonPercent == 4}">
					neljä
					<%
						
					%>
				</c:when>
				<c:otherwise>
					ei ole
					<%
						
					%>
				</c:otherwise>
			</c:choose>
			<!--  -->
			<%--  		<!-- Answer 2 -->
		<c:if test=" ${candi.answer_int} = 2">
			<p>Option 2</p>
		</c:if>

		<!-- Answer 3 -->
		<c:if test=" ${candi.answer_int} = 3">
			<p>Option 3</p>
		</c:if>

		<!-- Answer 4 -->
		<c:if test=" ${candi.answer_int} = 4">
			<p>Option 4</p>
		</c:if>  --%>

			<%
				i++;
			%>
		</div>

	</c:forEach>


</body>
</html>
