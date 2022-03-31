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
	<form action="/EditCandidate" method="POST">
		<c:forEach var="candidates" items="${requestScope.candidates}">
			<div class="name">${candidates.id} ${candidates.firstname} ${candidates.surname}
			</div>
			<br>
			<div class="extra">Age: ${candidates.age} <br> Party: ${candidates.party} <br>Voting number: ${candidates.vote_nro}</div>
			<button name="edit${candidates.id}" type="submit" class="button">Edit</button>
			<br>
			<hr class="solid">
		</c:forEach>
	</form>
</body>
</html>