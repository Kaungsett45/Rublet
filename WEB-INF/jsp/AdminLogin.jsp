<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Admin Login</title>
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
	margin-top:30px;
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
              <a href="Home"> <h2>Rublat</h2> </a>
              <a href="movie" class="rghnav" id="navitit"><span>Movies</span></a>
               <a href="Login" id="navitit"><span>Category</span></a>
               <a href="Login" id="navitit"><span>Awards & Others</span></a>
               <a href="Login" id="navitit"><span>About Us</span></a>
              
                    </div>
     
    </header>
       <div id="footer">
         <a href="Login" class="btn" >USER LogIn</a>
   
     </div>


    <div class="login-form-container">

        <form:form action="adminform" modelAttribute="adminlogin">
            <h3>Admin </h3>
            <span><label for="username">Admin UserName</label></span>
            <form:input path="admin_username" id="admin_username" class="box" placeholder="enter your username" required="true" />
          
           
            <span><label for="password">Password</label></span>
            <form:input type="password" path="admin_password"  id="password" class="box" placeholder="enter your password" />
          	<span id ="errorcheck" style="color:red;" style="font-size:14px;">${error}</span>
           
            <input type="submit" value="Confirm" class="btn3">
             </form:form>
         
      </div>


           
           
          
</body>
</html>