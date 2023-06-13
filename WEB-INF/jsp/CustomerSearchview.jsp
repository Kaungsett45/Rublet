<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  
<title>CustomerSearchView</title>
    <link href="<c:url value="/CSS/index.css" />" rel="stylesheet"> 
   
	<link href="<c:url value="/CSS/upload.css" />" rel="stylesheet">
    <link rel="stylesheet" href="  https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  
</head>
<style>
	#nav .rghnav{
		margin-left:440px;
	}
	#customerfooter .btn{
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
     
    <h4>Customer Rating List</h4>
     <form:form action="customersearch" class="formsearch" modelAttribute="customersearch">
               		<form:input path="username"  name="username" type="text" placeholder="  Search user.."  class="search" />
               		<i class="fa-solid fa-magnifying-glass" id="search" ></i>
      	</form:form>
    <table  class="cuslist">
       
        <tr id="tt">
       		<td>Username</td>
            <td>Movie_title</td>
            <td>Email</td>
            <td>Address</td>
            <td>Star_rating</td>
             
        </tr>
        
       
         <c:forEach var="m" items="${userlist}">
        <tr class="movietitle"> 
       		 <td>${m.username}</td>
            <td>${m.movie_title}</td>
            <td>${m.email}</td>
            <td>${m.address}</td>
            <td>${m.star_rating}</td>
           
        </tr>
        </c:forEach>
    </table>
      


   
</body>
</html>