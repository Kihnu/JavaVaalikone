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
<c:forEach var="question" items="${requestScope.questions}" >
<li>${question.id}: ${question.question} <a href='/delete?id=${question.id}'>delete</a> <a href='/readtoupdate?id=${question.id}'>update</a>
</c:forEach>
</ol>

<%
ArrayList<Questions> fishList=(ArrayList<Questions>)request.getAttribute("questions");

for (int i=0;fishList!=null && i<fishList.size();i++){
	Questions f=fishList.get(i);
	out.println(f.getId()+": "+f.getQuestion()+"<a href='/delete?id="+f.getId()+"'>delete</a> <a href='/readtoupdate?id="+f.getId()+"'>update</a>");
}
%>

<%-- comment <%@ include file="../html/somehtml.html" %>--%>



</body>
</html>