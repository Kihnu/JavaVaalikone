<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Questions"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href=questions.css>


<title>Questions</title>
</head>
<body>

	<h2>Questions</h2>

	<br>
	<br>

	<div class="vaihtoehdot">
		<ol>
			<c:forEach var="questions" items="${requestScope.questionlist}">
				<!-- TÄHÄN ALLE CSS ET SAADAAN TOI <p> ja <div> TYHJÄKS -->
				<p id="number" style="font-size: 24px; background-color: orange;"
					align="center">${questions.id}/${questionlist.size()}:</p>
				<div id="question" align="center" style="font-size: 30px;">${questions.question}
					<br>
				</div>
				<div class="radiogrp">
					<input type="radio" name="ans1" value=option1 id="radio_1">
					<label for="radio_1">Strongly Disagree
					</label>

				</div>
				<div class="radiogrp">
					<input type="radio" name="ans1" value=option2 id="radio_2">
					<label for="radio_2">Somewhat Disagree
					</label>
				</div>
				<div class="radiogrp">
					<input type="radio" name="ans1" value=option3 id="radio_3">
					<label for="radio_3" style="transform:translateY(-25%);"><br>Inbetween</label>
				</div>
				<div class="radiogrp">
					<input type="radio" name="ans1" value=option4 id="radio_4">
					<label for="radio_4">Somewhat Agree
					</label>
				</div>
				<div class="radiogrp">
					<input type="radio" name="ans1" value=option5 id="radio_5">
					<label for="radio_5">Strongly<br>Agree
					</label>
				</div>




			</c:forEach>
		</ol>



	</div>

</body>
</html>