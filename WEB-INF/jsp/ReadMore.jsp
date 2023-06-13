
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@page import ="com.java.beans.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="<c:url value="/CSS/index.css" />" rel="stylesheet"> 
<link href="<c:url value="/CSS/home.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  
</head>
<style>
#shownewcolor{
postition:relative;

	width:200px;
}

#nextcolor{
background-color:white;
border:none;
}
.notbadcolor{
	position:absolute;
	background-color:#0B2447;
	margin-top:20px;
	left:0px;
	z-index:-2;
	height:200px;
	width:200px;
	border-radius: 50em  50px 50cm  50%;
	
}		

#anothershownewcolor{
postition:relative;
}
anothershownewcolor{
width: 100%;
  height: 100vh;
postition:relative;
}

.anothernotbadcolor{
	position:absolute;
	background-color:#C9B6E4;
	margin-top:-400px;
	left:0px;
	z-index:-2;
	height:300px;
	width:400px;
	border-radius: 50px 50% 50cm 50em;
	
  overflow: hidden;
}	



#nav .rghnav{
	margin-left:440px;
}
#nav .adrghnav{
	margin-left:140px;
}		

.head,.reason{
text-align:center;
}

.paragraph{
	margin-left:360px;
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
      width:200px;
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
	
	
	</style>
<body>
	<%	

String User=(String)session.getAttribute("username");
	if(User ==null){
		
	
%>

  
	<!-- navigation bar-->

    <header>    
        <div id="nav">
              <a href="Login"> <h2>Rublat</h2> </a>
                <a href="movie" class="rghnav" id="navitit"><span>Movies</span></a>
               <a href=Login id="navitit"><span>Category</span></a>
               <a href="Login" id="navitit"><span>Awards & Others</span></a>
               <a href="Login" id="navitit"><span>About Us</span></a>
              
                    </div>
     
    </header>


     <!--body-->
      <!-- drop Down Menu -->
       
          <div id="footer">
         <a href="Login" class="btn" >Log In/Sign In</a>
   
     </div>
   
            
         
           
            <h1 class="head">Everything you need to know</h1>
            
            <h4 class="reason">Reason</h4>
            <p class="paragraph">-Customer having to deal with Bad services.</p>
            <p class="paragraph">-Sometimes they can't find what they want in one place</p>

            <h4 class="reason">Objective</h4>
            <p class="paragraph">-Can save Our Customer time and money</p>
            <p class="paragraph">-Can get a lot of information based on our Website rating.</p>

            <h4 class="reason">How to USE</h4>
            <p class="paragraph">-Those who don't have an account can  only see rating and movie information apart from that can do nothing.</p>
            <p class="paragraph">-Those who have register an account can give rating and see other information that can't be seen without registering.</p>
     
    
         
             <div id="shownewcolor">
           
           	<div class="notbadcolor">
           	 
           	</div>
           </div>
           
           <div id="anothershownewcolor">
           
           	<div class="anothernotbadcolor">
           	 
           	</div>
           </div>

           
           
          
      
          <!-- color home page -->
  
	
         <%}else if(User !=null){
        	 %>
      <!-- navigation bar-->

      <header>    
        <div id="nav">
              <a href="Home"> <h2>Rublat</h2> </a>
                	<div class="container">
      <div class="search-bar">
         <div id="select">
            <p id="selectText">Options</p>
            <i class="fa-solid fa-angle-down"></i>
            <ul id="list">
               <li  class="options"><a id="nthsr" href="moviesearch">Movie</a></li>
               <li  class="options"><a id="nthsr" href="actorsearch">Actor</a></li>
               <li class="options"><a  id="nthsr" href="actresssearch">Actress</a></li>
               <li class="options"><a  id="nthsr" href="directorsearch">Director</a></li>
            </ul>
         </div>
       			 <form:form action="search" class="formsearch" modelAttribute="search">
               		<form:input path="movie_title"  name="movie_title" type="text" placeholder="choose options"  class="search" />
               		 	</form:form>  </div>
   </div>
      			
                <a href="movie" class="rghnav" id="naviti"><span>Movies</span></a>
               <a href="Fantasy" id="navitit"><span>Category</span></a>
               <a href="Awardsansothers" id="navitit"><span>Awards & Others</span></a>
               <a href="Aboutus" id="navitit"><span>About Us</span></a>
              
                    </div>
     
    </header>
       <div id="footer">
         <a href="Logout" class="btn" >Log Out</a>
   
     </div>
   			
         
            <h1 class="head">Everything you need to know</h1>
            
            <h4 class="reason">Reason</h4>
            <p class="paragraph">-to provide a platform where users can share their opinions about the movies they have watched. 
            This system allows users to rate movies based on their personal preferences and experiences and provide comments
             that can help other users decide whether or not to watch a particular movie.</p>
            <h4 class="reason">Objective</h4>
           <p class="paragraph">-To provide valuable  feedback to the movie industry.</p>​

			<p class="paragraph">-To help users make informed decisions.</p>
            <h4 class="reason">How to USE</h4>
            <p class="paragraph">-Those who don't have an account can  only see overview rating and movie information apart from that,nothing can be done.</p>
            <p class="paragraph">-Those who registered an account can give rating and see other information which can't be seen without registering.</p>
      	
      	
      		

         
           
     <div id="anothershownewcolor">
           
           	<div class="anothernotbadcolor">
           	 
           	</div>
           </div>
          <!-- color home page -->
      
        
		
	
	<%}%>
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