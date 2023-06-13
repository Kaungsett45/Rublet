<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
   <%@ page import ="com.java.dao.Userdao" %>
   <%@page import ="org.apache.commons.io.IOUtils" %>
   <%@page import ="java.io.InputStream" %>
   <%@page import ="java.io.ByteArrayInputStream"%>
   <%@page import ="java.sql.Blob" %>
   <%@page import ="org.springframework.beans.factory.annotation.Autowired" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  <title>Create an account</title>
    <link href='<c:url value="/CSS/index.css"/>' rel="stylesheet"> 
    <link href='<c:url value="/CSS/moviedesign.css"/>' rel="stylesheet"> 
    
    <link href='<c:url value="/CSS/comment.css"/>' rel="stylesheet"> 
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  
</head>
<c:if test="${not empty hideButton}">
    <%-- Use CSS to hide the button --%>
    <style>
        #usercomment {
            display: none;
        }
    </style>
</c:if>
<style>
  #commentcontainer{
      position: absolute;
      display: inline-block;
      top:400px;
      left:200px;
      margin-top:-40px;
      overflow-y: scroll;
      height: 340px;
    }
      #newcommentbox{
        
      border: .1px solid rgba(0,0,0,.1);
      box-shadow: 0 .5rem 1rem rgba(0,0,0,.1);
        margin-top: 10px;
        font-size: 15px;
        position: relative;
        display: inline-block;
        margin-left:40px;
        box-shadow: (0,0,0.5,black);
        padding:10px;
        width: 660px;
       
        border-radius: 6px;
        margin-bottom: 0px;
      }
      .uname{
        display: inline-block;
        margin: 0px;
        font-size:16px;
        color:rgb(68, 68, 201);
        font-weight: 480;
        margin-bottom: 10px;
        
      }
      .onecl{
       
        margin-top:0px;
        position: absolute;
        font-size: 15px;
        right: 0px;
        display: inline-block;
        padding:0px 10px 0px 10px;
        margin:0px;
        
      }
      .threecl{
        position: absolute;
       right:300px;
       margin-top:0px;
       font-size: 13px;
       display: inline-block;
       padding:0px 10px 0px 10px;
       margin:0px;
       
     }
    
     .twocl{
      position: absolute;
     
       margin-top:0px;
       right:200px;
       font-size: 13px;
       display: inline-block;
       padding:0px 10px 0px 10px;
       margin:0px;
       
     }
     .cmtgive{
      font-size: 10px;
      color:gray;
      margin: 0px;
     }
     .usercmt{
      margin: 0px;
      margin-top: 6px;
      font-size: 14px;
      text-align: justify;
     }
   
	#nav .rghnav{
		margin-left:440px;
	}
	
	#nav .asrghnavid{
			margin-left:140px;
	}
	.cantgiveratinguser{
		 color:red;
		 position:absolute;
		 right:500px;
		 top:500px;
	}
	
     
    input.star{
      display: none;
    }
     
    label.star {
      float: right;
      padding: 3px;
      font-size: 18px;
      cursor: pointer;
      color: #444;
      transition: all .2s;
    }
     
    input.star:checked ~ label.star:before {
      content:'\f005';
      color: #FD4;
      transition: all .25s;
    }
     
     
    
    input.star-1:checked ~ label.star:before {
      color: #F62;
    }
     
    label.star:hover{
      transform: rotate(-15deg) scale(1.3);
    }
     
    label.star:before{
      content:'\f006';
      font-family: FontAwesome;
    }
     
    .rev-box{
      overflow: hidden;
      height: 0;
      width: 50%;
      transition: all .25s;
    }
     
    textarea.review{
      background: #222;
      border: none;
      width: 100%;
      max-width: 100%;
      height: 40px;
      padding: 10px;
      box-sizing: border-box;
      color: rgb(123, 29, 29);
    }
     
    label.review{
      display: block;
      transition:opacity .25s;
    }
     
    input.star:checked ~ .rev-box{
      height: 125px;
      overflow: visible;
    }
   
   .viewcount{
   		font-weight:600px;
   		color:red;
   }
   .customerviewcount{
   			font-size:16px;
   			font-weight:bold;
   }
</style>
<body>
		
       
    <!-- navigation bar-->
<%	


String Name=(String)session.getAttribute("username");
	if(Name ==null){
		
	
%>
		    <header>    
        <div id="nav">
              <a href="/ReworkRatingandComment/Login"> <h2>Rublat</h2> </a>
              	<a href="/ReworkRatingandComment/movie" class="rghnav" id="navitit"><span>Movies</span></a>
               <a href="/ReworkRatingandComment/Login" id="navitit"><span>Category</span></a>
               <a href="/ReworkRatingandComment/Login" id="navitit"><span>Awards & Others</span></a>
               <a href="/ReworkRatingandComment/Login" id="navitit"><span>About Us</span></a>
              
                    </div>
     
    </header>
       <div id="footer">
         <a href="/ReworkRatingandComment/Login" class="btn" >LogIn /SignIn</a>
   
     </div>

     <div id="moviecontainer">
            <h2>${movielist.movie_title}</h2>
        <div id="imgcontainer">
            <img id="movieimage"  src="getimgMovie/<c:out value='${movielist.movie_id}'/>">
            <a href="${movielist.trailer}"><button  id="trailer">Trailer</button></a>
            <h5>Lead Cast/Director</h5>
         </div>
                
                
        
      <!-- Next and previous buttons -->
          
          
        
          
        


     
    </div>
    

        <div id="aboutmovie">
        <div id="description">
            <h5>Description/Plot</h5>
            <p>${movielist.description}</p>
        </div>
        
         <div id="category">
            <h5 id="cateh">Genres:</h5>
            <span>${movielist.category_name}</span>
        </div>

        <div id="category">
          <h5 id="cateh">Review:</h5>
          <span><mark><c:out value='${reviewcount.star_rating}'/></mark>points </span>
       </div>
   
       
        <hr>
        
      </div>
   			<div class="cantgiveratinguser">
   			
   				
                <p>You must LogIn/SignIn to the website to give review & see other details</p>
   			</div>
   			
   			  <%}else if(Name !=null){
   				  
   				  
        	 %>
      <!-- navigation bar-->
   			
   			
   			
		    <header>    
        <div id="nav">
              <a href="/ReworkRatingandComment/Home"> <h2>Rublat</h2> </a>
             	<div class="container">
      <div class="search-bar">
         <div id="select">
            <p id="selectText">Movie</p>
            <ul id="list">
               <li  class="options"><a id="nthsr" href="/ReworkRatingandComment/actorsearch">Actor</a></li>
               <li class="options"><a  id="nthsr" href="/ReworkRatingandComment/actresssearch">Actress</a></li>
               <li class="options"><a  id="nthsr" href="/ReworkRatingandComment/directorsearch">Director</a></li>
            </ul>
         </div>
       			 <form:form action="/ReworkRatingandComment/search" class="formsearch" modelAttribute="search">
               		<form:input path="movie_title"  name="movie_title" type="text" placeholder="search with movie_title"  class="search" />
               		 	</form:form>  </div>
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

     <div id="moviecontainer">
            <h2>${movielist.movie_title}</h2>
        <div id="imgcontainer">
            <img id="movieimage"  src="getimgMovie/<c:out value='${movielist.movie_id}'/>">
            <a href="${movielist.trailer}"><button  id="trailer">Trailer</button></a>
            <h5>Lead Cast/Director</h5>
         </div>
                
        

        <div class="slideshow-container">

            <!-- Full-width images with number and caption text -->
            <div class="mySlides fade">
              <div class="numbertext">1 /3</div>
              
              <img  src="getActoridimg/<c:out value='${movielist.movie_id}'/> "  style="width:140px;" style="height:180px;"> 
              <div class="text">${movielist.actor_name}</div>
            </div>
            
          <!-- style='width:140px;' id='imgcasast'"> -->

            <div class="mySlides fade">
              <div class="numbertext">2/3</div>
               <img id="movieimage"   src="getActressidimg/<c:out value='${movielist.movie_id}'/> ">
                    <div class="text">${movielist.actress_name}</div>
            </div>
          
            


              <div class="mySlides fade">
                <div class="numbertext">3/3</div>
                <img id="movieimage"  src="getDirectoridimg/<c:out value='${movielist.movie_id}'/> ">
                <div class="text">${movielist.director_name}</div>
              </div>
          
            <!-- Next and previous buttons -->
            <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
            <a class="next" onclick="plusSlides(1)">&#10095;</a>
          </div>
          <br>
          
        
          
        


     
    </div>
  

        <div id="aboutmovie">
        <div id="description">
            <h5>Description/Plot</h5>
            <p>${movielist.description}</p>
        </div>
        
         <div id="category">
            <h5 id="cateh">Genres:</h5>
            <span>${movielist.category_name}</span>
        </div>

        <div id="category">
          <h5 id="cateh">Review:</h5>
          <span><mark><c:out value='${reviewcount.star_rating}'/>/5</mark>points voting for this show</span>
       </div>
   
		
        <hr>
          
  
 
<div class="giverating">
  <form:form action="/ReworkRatingandComment/giveRating/${movielist.movie_id}" modelAttribute="review" class="formcomment" method="post" name="myform" id="myform" onsubmit="return disableButton()" >
    <form:radiobutton path="star_rating" class="star star-5" id="star-5" name="star" value="5" required="true"/>
    <label class="star star-5" for="star-5"></label>	
    <form:radiobutton path="star_rating" class="star star-4" id="star-4" name="star" value="4" required="true" />
    <label class="star star-4" for="star-4"></label>
    <form:radiobutton path="star_rating" class="star star-3" id="star-3" name="star" value="3" required="true"/>
    <label class="star star-3" for="star-3"></label>
    <form:radiobutton path="star_rating" class="star star-2" id="star-2" name="star" value="2" required="true"/>
    <label class="star star-2" for="star-2"></label>
    <form:radiobutton path="star_rating" class="star star-1" id="star-1" name="star" value="1" required="true"/>
    <label class="star star-1" for="star-1"></label>

  <input type="submit" name="myButton" id="usercomment" value="submit" />
  
    <form:input path="comment_review" name="comment_review" id="comment_review" class="box" placeholder="Give Comment.." />
  </form:form> 
</div>

        
        
        <!-- comment -->
       
       
      
       
       
      </div>
       <div id="commentcontainer">
<c:forEach var="review" items="${listreview}">
      <div id="newcommentbox">
          
          <div id="commenttitle">
            <p class="uname"><c:out value='${review.username}'/> </p>
            <p class="onecl"><i class="fa-solid fa-star" style="color: #e5d257;"></i><c:out value='${review.star_rating}'/></p>
            <p class="twocl"><c:out value='${review.user_day}'/></p>
            <p class="threecl"><c:out value='${review.user_time}'/></p>
          </div>
          <div id ="titleusercomment">
              <p class="cmtgive">Comment</p>
              <p class="usercmt"><c:out value='${review.comment_review}'/></p>
          </div>
          
          </div>
           </c:forEach>
          
          </div>
     
      <!-- comment end -->
    
    <div class="award">
         <h4>Awards</h4>
         <button id="trailer">${movielist.award_name}</button>
         
    </div>
  
	<%}%>

<script>

let slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  let dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}

//Get the submit button element


</script>
	
        </body>
        
</html>