<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.SingleCandidateAnswers"%>

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
	<label>Candidate number: </label>
	<label>${requestScope.candidate.vote_nro}</label>
	<label>Name: </label>
	<label>${requestScope.candidate.firstname}
		${requestScope.candidate.surname}</label>
	<br>
	<label>Party: </label>
	<label>${requestScope.candidate.party}</label>

	<!-- IKÄ -->

	
	<label>Profession: </label>
	<label>${requestScope.candidate.profession}</label>

	<b>Extra information</b>
	<label>${requestScope.candidate.why}</label>
	<label>${requestScope.candidate.what}</label>

	
	<h1>More Information on Candidates answers to questions</h1>

	<%
		int i = 1;
	%>
	<c:forEach var="candi" items="${requestScope.singleCandidate}">

		<h3>
			Question
			<%=i%>: ${candi.question}
 		</h3>
		<br>
		
		<div>${candi.answer_int}</div>
		<br>
		
		
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

	</c:forEach>



</body>
</html>
