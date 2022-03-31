<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="content-type"
	content="application/xhtml+xml; charset=UTF-8" />
<link rel="stylesheet" href="CSS/index.css">
</head>
<body>
	<form action="/EditCandidate" method="POST">
		<c:forEach var="candidates" items="${requestScope.candidates}">
			<div class="firstname">${candidates.firstname}
				<br>
			</div>
			<div class="surname">${candidates.surname}
				<br>
			</div>

			<button type="submit" class="button">Edit</button>
		</c:forEach>
	</form>
</body>
</html>