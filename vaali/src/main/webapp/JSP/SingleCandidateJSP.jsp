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


	<form method="get" action="/AllCandidatesServlet">
		<button type="submit" class=exitbutton>Back</button>
	</form>

	<!-- Kuva tietystä ehdokkaasta -->
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
