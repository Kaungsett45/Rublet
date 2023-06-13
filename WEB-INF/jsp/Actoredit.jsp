<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  <title>Edit</title>
    <link href="<c:url value="/CSS/index.css" />" rel="stylesheet"> 
    <link href="<c:url value="/CSS/upload.css" />" rel="stylesheet"> 
    <link href="<c:url value="/CSS/movieform.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="  https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  
</head>
<style>
	#nav .rghnav{
		margin-left:440px;
	}
	
.login-form-container-admin{
	display:inline-block;
	}
	#Castupload .btn{
	background-color:black;
	color:white;
	}
	
	.acdbtn{
		text-decoration:none;
		text-align:center;
		color:black;
		margin-left:50px;
	
	}
</style>
<body>


       <header>    
        <div id="nav">
              <a href="/ReworkRatingandComment/Home"> <h2>Rublat</h2> </a>
             
                    </div>
     
    </header>
    
    
     
    <div class="login-form-container-admin">
    
    	
 
    
      
         <div class="container">
        <div class="tab_box">
            <button class="tab_btn active">Actor</button>
            <div class="line"></div>
        </div>
        <div class="content_box">
            <div class="content active">
         
         			
        <form:form   action="actoruploadedit"  modelAttribute="actor" method="POST"  enctype="multipart/form-data">
        	
        	
         		<form:hidden path="actor_id" value="${actor_id}" />

                <span >Actor Name </span>
                <form:input type="text" path="actor_name" class="box" placeholder="enter name" required="true" />
                
                <span >Actor image</span>
                <input   type="file"  name="file" class="box"  >
               
               
                <span >birth_date</span>
                 <form:input path="birth" type="text" class="box" placeholder="enter birth date" />
               
                <span>About</span>
                <form:input path="about" type="text" class="box" placeholder="enter about" />
           		  <button type="submit" value="Upload" class="btn3" name="Upload" >Edit</button>
        </form:form>
       </div>
     
      
    </div>
    </div>
      </div>
      
      
      <script>
            const tabs=document.querySelectorAll('.tab_btn');
            const all_content=document.querySelectorAll('.content');


            tabs.forEach((tab, index)=>{
                tab.addEventListener('click',(e)=>{
                    tabs.forEach(tab=> {tab.classList.remove('active')});
                    tab.classList.add('active');
                    var line=document.querySelector('.line');
                line.style.width =e.target.offsetWidth +"px";
                line.style.left =e.target.offsetLeft+ "px";

                all_content.forEach(content =>{ content.classList.remove('active')});
                all_content[index].classList.add('active');
                })

              
            })
        </script>
        
          <div id="Castupload">
         <a href="/ReworkRatingandComment/Castupload" class="btn" >Cast Upload</a>
   
     </div>
       <div id="footer">
         <a href="/ReworkRatingandComment/Logout" class="btn" >Log Out</a>
   
     </div>
    
       <div id="uploadfooter">
         <a href="/ReworkRatingandComment/movieupload" class="btn" >Upload Movie</a>
   
     </div>
     
       <div id="customerfooter">
         <a href="/ReworkRatingandComment/Customerlist" class="btn" >Customer List</a>
   
     </div>
      <div id="moviefooter">
         <a href="/ReworkRatingandComment/movielist" class="btn" >Movie List</a>
   
     </div>
     
</body>
</html>