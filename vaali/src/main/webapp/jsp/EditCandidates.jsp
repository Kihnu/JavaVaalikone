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
	<h1>Edit candidates</h1>
	<div>
		<form method="get" action="/AdminMain">
			<button type="submit" class=exitbutton>To admin page</button>
		</form>
		<form method="get" action="/AddCandidate">
			<button type="submit" class=add>Add candidate</button>
		</form>
	</div>
	<br>
	<br>
	<br>
	<hr class="solid">
	<c:forEach var="candidates" items="${requestScope.candidates}">
		<div class="id" hidden=hidden>${candidates.id}</div>
		<div class="firstname">${candidates.firstname}
			${candidates.surname}</div>
		<div class="surname" hidden=hidden>${candidates.surname}</div>
		<br>
		<div class="info"><b>Age:</b> ${candidates.age} <b>Party:</b>
			${candidates.party} <b>Profession:</b> ${candidates.profession} <b>Voting
			number:</b> ${candidates.vote_nro}</div>
		<div class="party" hidden=hidden>Party: ${candidates.party}</div>
		<div class="profession" hidden=hidden>Profession:
			${candidates.profession}</div>
		<div class="number" hidden=hidden>Voting number:
			${candidates.vote_nro}</div>

		<a href="/EditCandidate?id=${candidates.id}">Edit candidate</a>

		<br>
		<hr class="solid">
	</c:forEach>
</body>
</html>