<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
        <li><a href="viewBrand.html" class="nav">view Brand</a></li>
        <li class="divider"></li>
        <li><a href="addProd.html" class="nav">uplod prod</a></li>
        <li class="divider"></li>
      </ul>
    </div>
    <!-- end of menu tab -->
   
   
     <div class="left_content"style="margin-left:80px; margin-bottom: -300px"  >
     <br></br>
     <br></br>
     <br></br>
     <br></br>
    
      <div class="border_box">
        <div class="product_img"><a href="#">
        <div style="margin-top:-50px;"><img src="images/register.gif" alt="" border="0" /></div></a></div>
      </div>
     </div>
     <br></br>
	<br></br>     
   <!--   end of the left content -->
    
        
    <div class="center_content" style="margin-left:380px">
    
   <form:form action="addBrandController.html" method="post" modelAttribute="addprod">        
      <table cellpadding="10px">
						 <div id="error" style="color: red">
     						<%-- ${admin.error} --%>	
     					</div>  					
	  					<tr><td colspan="2" align="center"><font size="3" color="#FF0000"><b>Add New Brand</b></font></td></tr>
            					
     					<tr><td><form:label path="brandname"><font size="3" color="#000000">Brand Name</font></form:label></td>
						<td><form:input path="brandname" /></td></tr>
						
						<tr><td><form:label path="discription"><font size="3" color="#000000">Description</font></form:label></td>
						<td><form:textarea path="discription" cols="20" rows="5" /></td>
						</tr>
						
						
						<tr><td><form:label path="status"><font size="3" color="#000000">Status</font></form:label></td>
            			<td><form:select path="status">
                  		<form:option value="Select" label="Select" />
                 		 <form:option value="yes" label="Yes" />
                 		 <form:option value="no" label="No" />
                		</form:select>
           				 </td>
          				 </tr>
									
						<tr><td></td><td align="center"><input type="submit" value="Add">
						</td></tr>
						
																
						</table>
						
						</form:form> 
      
        <br></br>
   <br></br>
    </div>
    
 
    <!-- end of center content -->
   
  </div>
  <!-- end of main content -->
  <div class="footer">
    <br></br>
    <div style="text-align: center"> Copyright © 2016</div>
  </div>
</div>
<!-- end of main_container -->
</body>
</html>
