<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="data.Questions"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href=CSS/questions.css>


<title>Questions</title>
</head>
<body>


<form method="get" action="/index.html">
	<button type="submit" class= exitbutton>To main page </button>
	</form>


	<h2>Questions</h2>

	<br>
	<br>
	<form action="/Comparison" method="POST">
		<div class="vaihtoehdot">
			<!--<ol>
			<c:forEach var="questions" items="${requestScope.questionlist}"> -->
			<p class="number">${questions.id}/${questionlist.size()}</p>
			<div class="question">${questions.question}
				<br>
			</div>

			<div class="radiogrp">
				<input type="radio" name="answer${questions.id}" value="option1"
					id="radio_1" required><label for="radio_1">Strongly
					Disagree </label>

			</div>
			<div class="radiogrp">
				<input type="radio" name="answer${questions.id}" value="option2"
					id="radio_2" required><label for="radio_2">Somewhat
					Disagree </label>
			</div>
			<div class="radiogrp">
				<input type="radio" name="answer${questions.id}" value="option3"
					id="radio_3" required><label for="radio_3"
					style="transform: translateY(-25%);"><br>In between</label>
			</div>
			<div class="radiogrp">
				<input type="radio" name="answer${questions.id}" value="option4"
					id="radio_4" required><label for="radio_4">Somewhat
					Agree </label>
			</div>
			<div class="radiogrp">
				<input type="radio" name="answer${questions.id}" value="option5"
					id="radio_5" required><label for="radio_5">Strongly<br>Agree
				</label>
			</div>

			<!--</c:forEach>
		</ol>-->

			<button type="submit" class="button">Submit your answers</button>

		</div>
	</form>
	<%
		@SuppressWarnings("unchecked")
	ArrayList<Questions> questionlist = (ArrayList<Questions>) request.getAttribute("questionlist");
	for (int i = 0; i < questionlist.size(); i++) {
	%>




	<%
		}
	%>
</body>
</html>