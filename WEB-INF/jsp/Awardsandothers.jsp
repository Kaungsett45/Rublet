<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
 <title>Award and other</title>
    <link href="<c:url value="/CSS/index.css" />" rel="stylesheet"> 
    <link href="<c:url value="/CSS/home.css" />" rel="stylesheet">
    <link rel="stylesheet" href="  https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  
</head>
<style>
.container{
	display:inline-block;
   width: 30px;
 }
   .search-bar{
    margin-top:-10px;
      background: white;
      width: 20px;
      height: 0px;
      display: flex;
      border-radius: 4px;
   }
   .searchinput{
      margin-top: 8px;
      text-align: center;
      justify-content: center;
      height: 20px;
   }
   #select{
      background: #000000;
      display: flex;
      align-items: center;
      justify-content: space-between;
      color:white;
      width:300px;
      padding:25px 20px;
      cursor: pointer;
      position: relative;
      border-radius: 4px;
   }
   #select i{
      width:15px;
   }
   #select ul{
      position: absolute;
      top:120%;
      left:0;
      margin:0px;
      padding:0px;
      list-style: none;
      color: white;
      width: 112px;
      border-radius: 4px;
      background: #fff;
      max-height: 0;
      overflow: hidden;
      transition: max-height 0.5s;
   }
   #select ul li{
   		margin:0px;
   		padding:0px;
      cursor: pointer;
   }
   .search-bar input{
   	display:block;
      padding: 10px 25px;
      width: 200px;
      border: none;
      outline: none;
      font-size: 16px;
   }
   #select ul.open{
      max-height: 300px;
   }
.container .search-bar #select	#list .options #nthsr{
		margin:0px;
		padding:4px 2px 4px 2px;
		font-size:16px;
		
	}
	
	
#nav .rghnav{
		margin-left:440px;
	}
	
	
	#nav2{
	margin-left:-140px;
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
              <a href="Home"> <h2>Rublat</h2> </a>
                 	<div class="container">
      <div class="search-bar">
         <div id="select">
            <p id="selectText">Movie</p>
            <i class="fa-solid fa-angle-down"></i>
            <ul id="list">
               <li  class="options"><a id="nthsr" href="actorsearch">Actor</a></li>
               <li class="options"><a  id="nthsr" href="actresssearch">Actress</a></li>
               <li class="options"><a  id="nthsr" href="directorsearch">Director</a></li>
            </ul>
         </div>
       			 <form:form action="search" class="formsearch" modelAttribute="search">
               		<form:input path="movie_title"  name="movie_title" type="text" placeholder="search with movie_title"  class="search" />
               		 	</form:form>  </div>
   </div>
      				
               <a href="movie" class="rghnav" id="navitit"><span>Movies</span></a>
               <a href="Fantasy" id="navitit"><span>Category</span></a>
               <a href="Awardsandothers" id="navitit"><span>Awards & Others</span></a>
               <a href="Aboutus" id="navitit"><span>About Us</span></a>
              
                    </div>
     
    </header>
       <div id="footer">
         <a href="Logout" class="btn" >Log Out</a>
   
     </div>
   		
   		
   		<div id="nav2">
   			<a href="OscarAwardMovie" class="rghnav" id="navitit"><span>Oscar Award Movies</span></a>
            <a href="GrammyAwardMovie" id="navitit"><span>Grammy Award Movies</span></a>
         	
         
         
              
   		</div>
   		
   		
           

   	</body>
   	</html>