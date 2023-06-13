<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/CSS/index.css" />" rel="stylesheet"> 
<link href="<c:url value="/CSS/home.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  
</head>
<style>
	#nav .rghnav{
		margin-left:440px;
	}
</style>
<body>
	
	<!-- navigation bar-->

    	    <header>    
        <div id="nav">
              <a href="Home"> <h2>Rublat</h2> </a>
              <a href="movie" class="rghnav" id="navitit"><span>Movies</span></a>
               <a href="Fantasy" id="navitit"><span>Category</span></a>
               <a href="Awardsandothers" id="navitit"><span>Awards & Others</span></a>
               <a href="Aboutus" id="navitit"><span>About Us</span></a>
              
                    </div>
     
    </header>
       

   		  <div class="login-form-container">

        <form id="regForm" action="uploadcomplete" >
          		 <center><h2>MovieUpload Completed</h2></center>
         
            <button id="Register"  class="btn3" name="You can Log in now">  
            	Upload Again
             </button>
           
        </form>
         
      </div>
</body>
</html>