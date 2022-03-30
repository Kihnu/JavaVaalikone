<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="content-type"
	content="application/xhtml+xml; charset=UTF-8" />
<link rel="stylesheet" href="CSS/index.css">
</head>
<body>
	<form action="/Edit" method="POST">
	
			<p class="number">${candidatesList.id}/${candidatesList.size()}</p>
			<div class="firstname">${candidatesList.firstname}
				<br>
			</div>
			<div class="surname">${candidatesList.surname}
				<br>
			</div>

			<button type="submit" class="button">Edit</button>

	</form>
</body>
</html>