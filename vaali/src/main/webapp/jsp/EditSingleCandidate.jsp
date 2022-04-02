<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href=CSS/Allcandidates.css>
<title>Edit</title>
</head>
<body>
	<form action="/UpdateCandidate" method="post">
		<input type="text" name="id" value="${requestScope.candidate.id}" readonly /><br>
		First name: <input type="text" name="firstname"
			value="${requestScope.candidate.firstname}" /><br> Surname: <input
			type="text" name="surname" value="${requestScope.candidate.surname}" /><br>
		Voting number: <input type="number" name="vote"
			value="${requestScope.candidate.vote_nro}" /><br> Age: <input
			type="number" name="age" value="${requestScope.candidate.age}" /><br>
		Party: <input type="text" name="party"
			value="${requestScope.candidate.party}" /><br> Profession: <input
			type="text" name="pro" value="${requestScope.candidate.profession}" /><br>
		Why are you running?
		<textarea rows="4" cols="60" name="why">${requestScope.candidate.why}</textarea>
		<br> What do you want when elected?
		<textarea rows="4" cols="60" name="what">${requestScope.candidate.what}</textarea>
		<br>
		<button type="submit" class="button">Edit</button>

	</form>

</body>
</html>