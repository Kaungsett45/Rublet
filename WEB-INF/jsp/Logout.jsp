<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
<link href="<c:url value="/CSS/index.css" />" rel="stylesheet"> 
<link href="<c:url value="/CSS/home.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  
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
	
	<!-- navigation bar-->
   <div id="rightanothershownewcolor">
           
           	<div class="rightanothernotbadcolor">
           	 
           	</div>
           </div>
	<header>    
        <div id="nav">
              <a href="Login"><h2>Rublat</h2></a>
                <a href="Login" class="rghnav" id="navitit"><span>Movies</span></a>
               <a href="Login" id="navitit"><span>Category</span></a>
               <a href="Login" id="navitit"><span>Awards & Others</span></a>
               <a href="Login" id="navitit"><span>About Us</span></a>
              
                    </div>
     
    </header>


   		  <div class="login-form-container">

        <form id="regForm" action="Logoutcompletenoti" >
          		 <center><h2>Successfully Log out from the system</h2></center>
         
            <button id="Register"  class="btn3" name="You can Log in now">  
            		Go back to home page
             </button>
           
        </form>
         
      </div>
</body>
</html>