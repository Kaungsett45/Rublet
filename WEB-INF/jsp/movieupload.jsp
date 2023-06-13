<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  <title>movie upload</title>
    <link href="<c:url value="/CSS/index.css" />" rel="stylesheet"> 
    <link href="<c:url value="/CSS/upload.css" />" rel="stylesheet"> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  
</head>
<style>
	#nav .rghnav{
		margin-left:440px;
	}
	
	.login-form-container-admin{
	margin-left:-120px;
	}
	#uploadfooter .btn{
	background-color:black;
	color:white;
	}
</style>
<body>


       <header>    
        <div id="nav">
              <a href="Home"> <h2>Rublat</h2> </a>
             
                    </div>
     
    </header>
       <div id="footer">
         <a href="Logout" class="btn" >Log Out</a>
   
     </div>
       <div id="Castupload">
         <a href="Castupload" class="btn" >Cast Upload</a>
   
     </div>
      <div id="customerfooter">
         <a href="Customerlist" class="btn" >Customer List</a>
   
     </div>
       <div id="uploadfooter">
         <a href="movieupload" class="btn" >Upload Movie</a>
   
     </div>
      <div id="moviefooter">
         <a href="movielist" class="btn" >Movie List</a>
   
     </div>
     
    <div class="login-form-container-admin">

        <form:form action="uploadmovie"  modelAttribute="movie"  enctype="multipart/form-data">
            <h3>Upload Movie</h3>
         <div id="movieupload">
                <span id="IT">Movie Title</span>
                <form:input type="text" path="movie_title" class="box" placeholder="enter title" required="true" />
                <span id="IT">Movie image</span>
                <input  type="file" name="file" class="box" >
                <span id="IT">Trailer link</span>
                <form:input path="trailer" type="text" class="box" placeholder="enter link" />
                <span id="IT">Description</span>
                <form:input type="text" path="description" class="box" placeholder="enter movie description" />
                
                <div id="genresdiv">
                <span id="IT">Genres</span>
                <form:radiobutton path="category_id" name="genres" class="box" value="1" />Fantasy
                 <form:radiobutton  path="category_id"   name="genres" class="box"  value="3"/>Comedy
                  <form:radiobutton path="category_id"  name="genres" class="box" value="6" />Horror
                     <form:radiobutton path="category_id"  name="genres" class="box" value="2" />Animation
               
                </div>
                <div id="awarddiv">
                <span id="IT">Award</span>
                <form:radiobutton path="award_id" class="box" name="award"  value="1" />Oscar
                <form:radiobutton path="award_id"  class="box" name="award"  value="2" />Grammy
                <form:radiobutton path="award_id"  class="box" name="award"  value="3" />None
                </div>
           
                </div>
                <div id="directorup">
                
                <span id="At">Actor_name</span>
                 <form:select path ="actor_id" class="box" placeholder="enter actor_name">
                 	<form:option value ="1" label = "Select"/>
                 	 <c:forEach var="m" items="${actorlist}">
                     <form:option value="${m.actor_id}" label="${m.actor_name}" /> 
                  		
                      </c:forEach>
                  </form:select> 
         
       
                <span id="At">Actress_name</span>
                 <form:select path = "actress_id" class="box" placeholder="enter actress_name">
                 	 <form:option  value="2" label = "Select"/>
                 	 <c:forEach var="m" items="${actresslist}">
                      <form:option value="${m.actress_id}" label="${m.actress_name}" /> 
                  		
                      </c:forEach>
                  </form:select> 
                <span id="At">Director_name</span>
                <form:select path = "director_id" class="box" placeholder="enter director_name">
                 	 <form:option value="3" label = "Select"/>
                 	 <c:forEach var="m" items="${directorlist}">
                      <form:option value="${m.director_id}" label="${m.director_name}" /> 
                  		
                      </c:forEach>
                  </form:select> 
				<button type="submit" value="Upload" class="btn3" name="Upload" >Upload</button>
               
            </div>
        
      
        </form:form>
         
      </div>
      
      
</body>
</html>