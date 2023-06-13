<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

<title>Home</title>

   <link href="<c:url value="/CSS/home.css" />" rel="stylesheet"> 
   <link href="<c:url value="/CSS/index.css" />" rel="stylesheet"> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  
</head>
<style>
.actorvvv{
	color:red;
	font-size:20px;
	letter-spacing:1px;
}


</style>
<body>

	
	    <header>    
        <div id="nav">
              <a href="/ReworkRatingandComment/Home"> <h2>Rublat</h2> </a>
          
    	<div class="container">
      <div class="search-bar">
         <div id="select">
            <p id="selectText">Actor</p>
            <i class="fa-solid fa-angle-down"></i>
            <ul id="list">
               <li  class="options"><a id="nthsr" href="/ReworkRatingandComment/moviesearch">Movie</a></li>
               <li class="options"><a  id="nthsr" href="/ReworkRatingandComment/actresssearch">Actress</a></li>
               <li class="options"><a  id="nthsr" href="/ReworkRatingandComment/directorsearch">Director</a></li>
            </ul>
         </div>
       				 <form:form action="/ReworkRatingandComment/dbmsactorsearch" class="formsearch" modelAttribute="searchactor">
               		<form:input path="actor_name"  name="movie_title" type="text" placeholder="Search with actor_name"  class="search" />
               		 	</form:form> 
               		 	 </div>
   </div>
      				
               <a href="/ReworkRatingandComment/movie" class="rghnav" id="navitit"><span>Movies</span></a>
               <a href="/ReworkRatingandComment/Fantasy" id="navitit"><span>Category</span></a>
               <a href="/ReworkRatingandComment/Awardsandothers" id="navitit"><span>Awards & Others</span></a>
               <a href="/ReworkRatingandComment/Aboutus" id="navitit"><span>About Us</span></a>
              
                    </div>
     
    </header>
       <div id="footer">
         <a href="/ReworkRatingandComment/Logout" class="btn" >Log Out</a>
   
     </div>

     <!--body about actor-->
        <div id="leftcontainerdesign">

            <div class="castcontainer">
               <img src="getimgActor/<c:out value='${actorview.actor_id}'/>">
        
            </div>

            <div id="castabout">
                <p class="name">${actorview.actor_name}</p>
                <p class="birth">Birth :: ${actorview.birth}</p>

                <p class="abtitle">About</p>
                <p class="cabout">
                	${actorview.about}
                   </p>
            </div>
        </div>
           
<div class="anther">
       	<p class="actorvvv">${message}</p>
          <c:forEach var="mov" items="${actormovie}">
       <div class="imgcontainershow">
       <img src="getimgMovie/<c:out value='${mov.movie_id}'/>" style="width:140px;" style="height:200px;">   
            
            <a href="/ReworkRatingandComment/ViewDetails/${mov.movie_id}"><button id="watchlist">View Details</button></a>
        </div>
	</c:forEach>
        </div>
    
           
          
</div>

      
      	
  
	 <script>
	   let select= document.getElementById("select");
	      let list=document.getElementById("list");
	      let selecttext=document.getElementById("selectText");
	      let options=document.getElementsByClassName("options");
	      let inputField=document.getElementById("inputfield");
	     
	         select.onclick=function(){
	         list.classList.toggle("open");
	      }

	    
</script>
   
	
</body>
</html>