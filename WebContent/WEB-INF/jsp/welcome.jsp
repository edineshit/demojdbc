<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-1.8.0.min.js"></script>
</head>
<script type="text/javascript">
/* $("#searchVal").keyup(function(){
	var url = "getProduct.html?val="+$("#searchVal").val();
	alert("---"+url);
	top.location=url
	
});
function search_func(){
	var val =  document.getElementById("searchVal");
	alert(val);
	var url = "getProduct.html?val="+val;
	alert("---"+url);
	top.location=url;
} */
</script>

<body>
hello
<%
/*  String aa = (String)session.getAttribute("userDtl");
out.println(aa);  */
%>

${sessObj.name}
<br>
<br>
<form:form action="seacrhVal.html" method="post" modelAttribute="brand">
	<label>Search:</label> 
	<form:input path="brandname" />
	<!-- <input type="text" id="searchVal"  size="25" onkeyup="search_func(this.value);"> -->
	<input type="submit" value="search">	
</form:form>



</body>
</html>