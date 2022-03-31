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
<title>Edit Candidates</title>
</head>
<body>

		<c:forEach var="candidates" items="${requestScope.candidates}">
			<div class="id">${candidates.id}</div>
			<div class="firstname">${candidates.firstname}</div>
			<div class="surname">${candidates.surname}</div>
			<br>
			<div class="age">Age: ${candidates.age}</div>
			<br>
			<div class="party">Party: ${candidates.party}</div>
			<br>
			<div class="number">Voting number: ${candidates.vote_nro}</div>

			<a href="/EditCandidate?id=${candidates.id}">Edit candidate</a>
			<br>
			<hr class="solid">
		</c:forEach>
</body>
</html>