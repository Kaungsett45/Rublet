<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
 <title>Create an account</title>
    <link href="<c:url value="/CSS/index.css" />" rel="stylesheet"> 
    <link href="<c:url value="/CSS/home.css" />" rel="stylesheet">
    <link rel="stylesheet" href="  https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  
</head>
<style>
#nav .rghnav{
		margin-left:440px;
	}
#nav .okirghnav{
	margin-left:140px;
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
	left:460px;
	z-index:-2;
	height:200px;
	width:200px;
	border-radius: 50%  20%;
}		

#anothershownewcolor{
postition:relative;
}
.anothernotbadcolor img{
	width:100%;
	height:100%;
	
	z-index:6;
}
.anothernotbadcolor{
	position:absolute;
	right:120px;
	top:120px;
	z-index:6;
	height:460px;
	width:460px;
	
	object-fit:cover;
}	


#newanothershownewcolor{
postition:relative;
}
.newanothernotbadcolor{
	position:absolute;
	background-color:#2B4865;
	margin-top:60px;
	z-index:-2;
	height:160px;
	width:200px;
	border-radius: 50px 50cm  50em  50% ;
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
	.newuploadmoviedesign{
		margin-top:240px;
		
	}
	.newuploadmoviedesign p{
		background-color:none;
		text-align:center;
		font-size:22px;
		font-weight:600;
		
	}
	
	hr{
	display:flex;
	width:200px;
	}
	mark{
		background-color:none;
	}
	#new{
		color:#19A7CE;
		background-color:none;
	}
	#uploaded{
		color:#3E54AC;
		}
		
		#movei{
			color:#557153;
		}
		#thise{
			color:#FFD124;
		}
		
		#pathSelect{
			border:none;
			
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
	
	</style>
<body>
       
    <!-- navigation bar-->

  <%	


String User=(String)session.getAttribute("username");
  System.out.println(User);
	if(User !=null){
		
	
%>     
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
   

     <!--body-->
     <c:forEach var="mov" items="${listStu}">
       <div class="imgcontainershow">
       <img src="getMoviePhoto/<c:out value='${mov.movie_id}'/>" style="width:140px;" style="height:200px;">   
            
            <a href="ViewDetails/${mov.movie_id}"><button id="watchlist">View Details</button></a>
        </div>
	</c:forEach>

	
	
         <%}else if(User ==null){
        	 %>
      <!-- navigation bar-->
	
	     <header>    
        <div id="nav">
              <a href="Login"> <h2>Rublat</h2> </a>
               
              	<a href="movie" class="rghnav" id="navitit"><span>Movies</span></a>
               <a href="Login" id="navitit"><span>Category</span></a>
               <a href="Login" id="navitit"><span>Awards & Others</span></a>
               <a href="Login" id="navitit"><span>About Us</span></a>
              
                    </div>
     
    </header>
       <div id="footer">
         <a href="Login" class="btn" >LogIn /SignIn</a>
   
     </div>
   

     <!--body-->
     <c:forEach var="mov" items="${listStu}">
       <div class="imgcontainershow">
       <img src="getMoviePhoto/<c:out value='${mov.movie_id}'/>" style="width:140px;" style="height:200px;">   
            
            <a href="ViewDetails/${mov.movie_id}"><button id="watchlist">View Details</button></a>
        </div>
	</c:forEach>
	
	
	
	
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