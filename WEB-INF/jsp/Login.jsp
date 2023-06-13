<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Login</title>
    <link rel="stylesheet" href="<c:url value ="/CSS/index.css" />" >
    <link rel="stylesheet" href="  https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  
</head>
<style>
	#nav .rghnav{
		margin-left:440px;
	}
	
#newanothershownewcolor{
postition:relative;
}
.newanothernotbadcolor{
	position:absolute;
	background-color:#C9DBB2;
	margin-top:-10px;
	z-index:-2;
	height:260px;
	width:300px;
	border-radius: 50cm 50cm  50em  50% ;
	
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
              <a href="Login"><h2>Rublat</h2></a>
                <a href="movie" class="rghnav" id="navitit"><span>Movies</span></a>
               <a href="Login" id="navitit"><span>Category</span></a>
               <a href="Login" id="navitit"><span>Awards & Others</span></a>
               <a href="Login" id="navitit"><span>About Us</span></a>
              
                    </div>
     
    </header>


     <!--body-->
      <!-- drop Down Menu -->
       
          <div id="footer">
         <a href="AdminLogin" class="btn" >Admin LogIn</a>
   
     </div>
   

    <div class="login-form-container">

        <form:form action="Loginform" modelAttribute="UserLogin">
            <h3>USER Log In</h3>
            
           
            <span><label for="username">UserName</label></span>
            <form:input path="username" id="username" name="username" class="box" placeholder="enter your username" required="true" />
          
           
            <span><label for="password">Password</label></span>
            <form:input type="password" path="userpassword" name="password" id="password" class="box" placeholder="enter your password" />
          
            <input type="submit" value="Confirm" class="btn3">
           	<span id ="errorcheck" style="color:red;" style="font-size:14px;">${error}</span>
            <p class="reg">Not Register yet? <a href="Register">Create an account</a></p>
        </form:form>
         
      </div>
	
	<div id="newanothershownewcolor">
           
           	<div class="newanothernotbadcolor">
           	 
           	</div>
           </div>
           
           
           
        

</body>
</html>