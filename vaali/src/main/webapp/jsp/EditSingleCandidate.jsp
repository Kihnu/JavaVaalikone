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
<form action="update" method="post">
First name: <input type="text" name="firstname" value="${requestScope.candidate.firstname}" /><br>

</form>
	
</body>
</html>