<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Actress list</title>
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
	
	
	
 .actorlist #tt td {
 	font-size:20px;
 	font-weight:400px;
 	border:solid 2px;
 	background-color:black;
 	text-align:center;
 	color:white;
    width: 160px;
 }
 
 .actorlist #tt .acbout{
 	width:760px;
 }
  .actorlist #tt .edit{
  	width:80px;
 }
  .actorlist #tt .delete{
  	
 	width:80px;
 }
 .cuslist .movietitle td {
    text-align: center;
    width: 140px;
 }
.movietitle  .delete a{
 	text-decoration:none;
 	text-align:center;
 	color:red;
 	}
 .actortitle td{
     border: solid 2px;
     height: 30px;
 }
 
 /*custoemerliststyle*/
.customerinline{
	display:inline-block;
}
.actortitle .edit a{
	text-decoration:none;
 	text-align:center;
	color:blue;
}
.actortitle .delete a{
	text-decoration:none;
 	text-align:center;
	color:red;
}
.actortitle td{
	text-align:center;
}
.actorlist .actortitle .aboutcustomer{
	text-align:justify;
	padding:4px 6px 4px 6px; 
}
	
	#categorycontainer a .fantasy{
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
     
     
        <div id="categorycontainer">
     <a href="ActorList"><button id="category" class="comedy">Actor List</button></a>
     <a href="ActressList"><button id="category" class="fantasy">Actress List</button></a>
     <a href="DirectorList"><button id="category" class="Horror">Director List</button></a>
    </div>
     
     
     <p style="font-size:18px;">Total Actress Lists: <span style="color:blue;">${Actresscount}</span></p>
    <h4 class="customerinline">Actor List</h4>
     
    <table  class="actorlist">
       
        <tr id="tt">
            <td>Actress_name</td>
            <td >Birth</td>
            <td class="acbout">About</td>
            <td  class="edit">Edit</td>
        </tr>
        <c:forEach var="actor" items="${actresslist}">
        <tr class="actortitle"> 
            <td class="customerliststyle">${actor.actress_name}</td>
            <td class="customerliststyle" >${actor.birth}</td>
            <td class="aboutcustomer">${actor.about}</td>
             <td class="edit"><a href="actressedit/${actor.actress_id}">Edit</a></td>
        </tr>
        </c:forEach>
    </table>
      


</body>
</html>