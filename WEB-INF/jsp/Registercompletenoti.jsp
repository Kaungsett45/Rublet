<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Complete noti</title>
<link href="<c:url value="/CSS/index.css" />" rel="stylesheet"> 
<link href="<c:url value="/CSS/home.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  
</head>
<body>
	
	<!-- navigation bar-->

     <header>
       
           
         <div id="nav2">
               <h2><a href="Login">Rublat</a></h2> 
              <div id="nav3">
               <a href="Login"><span>Movies</span></a>
               <a href="Login"><span>Category</span></a>
               <a href="Login"><span>Admin</span></a>
               
               <a href="Login" ><span>About Us</span></a>
               </div>
               <input type="text" placeholder="  Search movies.." name="search" class="search" ><i class="fa-solid fa-magnifying-glass" id="search"></i>
               
               <a href="Login" class="btn" >Log In/Register</a>
        </div>
         
     </header>


   		  <div class="login-form-container">

        <form id="regForm" action="registrationcompletenoti" >
          		 <center><h2>Registration Complete</h2></center>
         
            <button id="Register"  class="btn3" name="You can Log in now">  
            	You can Now Log in to the system
             </button>
           
        </form>
         
      </div>
</body>
</html>