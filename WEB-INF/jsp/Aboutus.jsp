<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  <title>About Us</title>

    <link href="<c:url value="/CSS/index.css" />" rel="stylesheet"> 
    <link href="<c:url value="/CSS/home.css" />" rel="stylesheet">
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
	
nav {
    float: left;
    margin-left: 100px;
    text-align:justify;
}
	
	
.bonjur{
    letter-spacing: 1;
    text-align: justify;
    width: 300px;
}
mark{
    color:rgb(34, 0, 255);
    background-color: white;
}
#email span{
    font-size: 18px;
    letter-spacing: 2;
}
#email{
    margin-top: 20px;
    margin-left: 600px;
}
	
	
nav h4 img{
    width: 200px;
    
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
               		<form:input path="movie_title"  name="movie_title" type="text" placeholder="Search with movie_title"  class="search" />
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


     <nav> 

            <h4><img src="image/spiral.jpg"></h4>
            <h2>Aung Kaung Sett</h2>
            <br>
            <h3>Information</h3>
            <p class="bonjur">IP <mark>2022</mark> April &  FE passer <mark>2022</mark> Oct </p>
            <p class="bonjur">Currently Learning my best with my Low IQ
            to understand spring mvc and others framework </p>
            <br>
            <p class="bonjur">if you have anything you don't understand 
            or something to discuss !!  free to ask me anything I will answer your qui  to the best of my ability..</p>


     </nav>

     <div id="email">
             <span>Contact:</span>
             <span><mark>rrocket438@gmail.com</mark></span>
     </div>


     <div id="email">
        <span>Update Notice!!!</span>
        <span><mark>!!!!!!!!!
            !!!!!!!
           Can now search actor,actress,director and their information and movies info
            !!!!!!
        </mark></span>
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