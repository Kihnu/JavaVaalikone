<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="content-type"
	content="application/xhtml+xml; charset=UTF-8" />
<link rel="stylesheet" href="CSS/index.css">
</head>

<body>

	<h1>WELCOME TO THE ADMIN LAIR</h1>

	<br>

	<form method="get" action="/AdminQuestions">
		<button type="submit" class="button">Edit Questions!</button>
	</form>

	<br>

	<form method="get" action="/AdminCandidates">
		<button type="submit" class="button">Edit Candidates!</button>
	</form>
	
	<br>

	<form method="get" action="/AdminRefresh">
		<button style="background-color:red; color:white;" type="submit" class="button">Restart everything!</button>
	</form>

</body>
</html>