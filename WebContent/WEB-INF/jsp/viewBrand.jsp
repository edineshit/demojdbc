<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>FiDoop</title>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript" src="js/boxOver.js"></script>

</head>
<body>
<div id="main_container">
  <div id="header">
    <div class="top_right">
      <div class="languages">
        <div class="lang_text"></div>
         </div>
      <div class="big_banner"><img src="images/t1.gif" style="width:950px;margin-left:105px;"><img src="images/t3.gif" style="width:700px;margin-left:200px;height:40px;padding-top:10px;" ><!--<a href="http://all-free-download.com/free-website-templates/"><img src="images/banner728.jpg" alt="" border="0" /></a> --></div>
    </div>
  </div>
  <div id="main_content">
    <div id="menu_tab">
      <ul class="menu">
        <li><a href="index.html" class="nav"> Home </a></li>
        <li class="divider"></li>
        <li><a href="reg.jsp" class="nav">Register</a></li>
        <li class="divider"></li>
        <li><a href="user.jsp" class="nav">User</a></li>
        <li class="divider"></li>
      </ul>
    </div>
    <!-- end of menu tab -->
          
    <div class="center_content">
    
        <table cellpadding="10px" align="center" width="920px" border="1px solid gray">
						   					
	  					<tr><td colspan="5" align="center"><font size="3" color="#FF0000"><b>View Upload Brand Details</b></font></td></tr>
            					
     					<tr><th><font size="3" color="#000000">S.no</font></th>
						<th><font size="3" color="#000000">Brand Name</font></th>
						<th><font size="3" color="#000000">Discription</font></th>
						<th><font size="3" color="#000000">Status</font></th>
						<th><font size="3" color="#000000">Action</font></th>
						</tr>
						<c:forEach var="brand" items="${brandname}">
					
						<tr>
						<td><font size="3" color="#000000"><c:out value="${brand.id }"></c:out></font></td>
						<td><font size="3" color="#000000"><c:out value="${brand.brandname }"></c:out></font></td>
						<td><font size="3" color="#000000"><c:out value="${brand.discription }"></c:out></font></td>
						<td><font size="3" color="#000000"><c:out value="${brand.status }"></c:out></font></td>
						<td><a href="editbrand.html?${brand.id }"><font size="2" color="green">Edit</font></a> | <a href="deletebrand.html?${brand.id }"><font size="2" color="green">Delete</font></a>
						</tr>
						</c:forEach>
																
						</table>
						
						
      
        <br></br>
   <br></br>
    </div>
    
 
    <!-- end of center content -->
   
  </div>
  <!-- end of main content -->
  <div class="footer">
    <br></br>
    <div style="text-align: center"> Copyright � 2016</div>
  </div>
</div>
<!-- end of main_container -->
</body>
</html>
