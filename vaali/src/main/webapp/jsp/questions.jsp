<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Questions" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Questions</title>

<link rel="stylesheet" type="text/css" href="mycssfilesomewhere.css">
<script src="myscriptfile.js"></script>

</head>
<body>
<h2 style="color:red">Kyssäri</h2>
<ol>
<c:forEach var="questions" items="${requestScope.questions}" >
<li>${questions.id}: ${questions.question} <a href='/delete?id=${questions.id}'>delete</a> <a href='/readtoupdate?id=${questions.id}'>update</a>
</c:forEach>
</ol>

<%
ArrayList<Questions> questions=(ArrayList<Questions>)request.getAttribute("questions");

for (int i=0;questions!=null && i<questions.size();i++){
	Questions q=questions.get(i);
	out.println(q.getId()+": "+q.getQuestion()+"<a href='/delete?id="+q.getId()+"'>delete</a> <a href='/readtoupdate?id="+q.getId()+"'>update</a>");
}
%>

<%-- comment <%@ include file="../html/somehtml.html" %>--%>



</body>
</html>