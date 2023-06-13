<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  <title>Register an account</title>
   <link href="<c:url value="/CSS/index.css" />" rel="stylesheet"> 
    <link rel="stylesheet" href="  https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  
</head>
<style>
	#nav .rghnav{
		margin-left:440px;
	}
	
#rightanothershownewcolor{
postition:relative;
}
.rightanothernotbadcolor{
	position:absolute;
	background-color:#E5BEEC;
	margin-top:-10px;
	z-index:-2;
	top:0;
	height:260px;
	width:300px;
	right:0;
	border-radius:50%  50cm 50cm  50cm ;
	
	}	
</style>
<body>
    <div id="rightanothershownewcolor">
           
           	<div class="rightanothernotbadcolor">
           	 
           	</div>
           </div>
	
	
	<header>    
        <div id="nav">
              <a href="Create"> <h2>Rublat</h2> </a>
          
              <a href="movie" class="rghnav" id="navitit"><span>Movies</span></a>
               <a href="Create" id="navitit"><span>Category</span></a>
               <a href="Create" id="navitit"><span>Awards & Others</span></a>
               <a href="Create" id="navitit"><span>About Us</span></a>
              
                    </div>
     
    </header>
       <div id="footer">
         <a href="Login" class="btn" >USER LogIn</a>
   
     </div>
    <div class="login-form-container">

        <form:form id="regForm"  action="RegisterForm" modelAttribute="Register" >
            <h3>Registration</h3>
            
           
            <span><label for="username">UserName</label></span>
            <form:input path="username" id="username" class="box" placeholder="enter your username" required="true" />
          
           
            <span><label for="password">Password</label></span>
            <form:input type="password" path="userpassword"  id="password" class="box" placeholder="enter your password" />
          
          	 <span><label for="email">Email</label></span>
            <form:input  path="email" id="email" class="box" placeholder="enter your email" required="true" />
          
          
            <span><form:label path="address" >Address</form:label></span>
            <form:input path="address"  id="address" class="box" placeholder="enter your address" />
          	
          	
          
            <input type="checkbox"  required>Terms and Conditions<br>
            <input type="checkbox"  required>Privacy Policy
          
            <form:button id="Register" value="Register" class="btn3" name="Register">Register</form:button>
           
		        </form:form>
         
      </div>
</body>
</html>