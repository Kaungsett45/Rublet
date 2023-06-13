<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!-- 
            <td>Delete</td> -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  <title>Movie List</title>
    <link href="<c:url value="/CSS/index.css" />" rel="stylesheet"> 
   
	<link href="<c:url value="/CSS/upload.css" />" rel="stylesheet">
    <link rel="stylesheet" href="  https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  
</head>
<style>
	#nav .rghnav{
		margin-left:440px;
	}
	#moviefooter .btn{
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
	 <p style="font-size:18px;">Total Movies: <span style="color:blue;">${ttmovie}</span></p>
  	 <p style="font-size:18px;">${deletesuccess}</p>
    <h4>Movie List</h4>
   
    <table  class="cuslist">
       
        <tr id="tt">
            <td>Movie_title</td>
            <td>Category</td>
            <td>Actor_name</td>
            <td>Actress_name</td>
            <td>Director_name</td>
             <td>Edit</td>
             <td>Delete</td>
        </tr>
        
       
         <c:forEach var="m" items="${listmovie}">
        <tr class="movietitle"> 
            <td>${m.movie_title}</td>
            <td>${m.category_name}</td>
            <td>${m.actor_name}</td>
            <td>${m.actress_name}</td>
            <td>${m.director_name}</td>
             <td class="edit"><a href="edit/${m.movie_id}">Edit</a></td>
              <td class="delete"><a href="delete/${m.movie_id}">Delete</a></td>
            
        </tr>
        </c:forEach>
    </table>
      


   
</body>
</html>