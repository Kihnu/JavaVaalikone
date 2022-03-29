<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
 
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

<p> Question here <br> </p>

 <input type="radio" name="ans1"value=option1 >Strongly disagree
 <input type="radio" name="ans1"value=option2>Somewhat Disagree
 <input type="radio" name="ans1"value=option3 checked>Inbetween
 <input type="radio" name="ans1"value=option4 >Somewhat agree
 <input type="radio" name="ans1"value=option5>Strongly agree
 

</div>

<%
@SuppressWarnings("unchecked")
ArrayList<Questions> questionList=(ArrayList<Questions>)request.getAttribute("questionlist");

for (int i=0;QuestionList!=null && i<questionList.size();i++){
	
	ffff
	
}
%>

	 






</body>
</html>