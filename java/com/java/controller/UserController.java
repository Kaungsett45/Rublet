package com.java.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.beans.Actor;
import com.java.beans.Actress;
import com.java.beans.Category;
import com.java.beans.Director;
import com.java.beans.Movie;
import com.java.beans.Rating;
import com.java.beans.User;
import com.java.dao.Userdao;

@Controller
public class UserController {
		
	
	@Autowired
	Userdao userdao;
	
	
	@RequestMapping("/index")
	public ModelAndView index(Model m,ModelAndView model)throws IOException{
		
		model.setViewName("index");
		return model;
	}
	
	 @RequestMapping("/registrationcompletenoti")
	 public String registercomplete(Model m) {
			m.addAttribute("UserLogin",new User());
		 m.addAttribute("search" ,new Movie());
		 return "Login";
	 }
	 
	@RequestMapping("/Home")
	public ModelAndView Home(Model m,ModelAndView model)throws IOException{
		m.addAttribute("search",new Movie());

		List<Movie> Newadd = userdao.NewaddMovie();
		model.addObject("Newaddedmovie", Newadd);
		 m.addAttribute("Newaddedmovie", Newadd);
		    
		model.setViewName("Home");
		return model;
	}
	
	//User Login
	@RequestMapping("/Login")
	 public String  Login(Model m) {
			m.addAttribute("UserLogin",new User());
		  return "Login";
	 }
	
	//Registeraccount
	 @RequestMapping(value="/Register")
	public String Register(Model m) {
		 m.addAttribute("Register",new User());
		 return "Register";
	}
	
	 //fillregisterform
	 @RequestMapping(value="/RegisterForm",method=RequestMethod.POST)
		public String RegisterForm(Model m,@ModelAttribute("user")User user) {
			 m.addAttribute("Register",new User());
			 userdao.register(user);
			 return "Registercompletenoti";
		} 
	 
	 //Login validation and log in controller
	 @RequestMapping(value="/Loginform" )
		public ModelAndView  Login(Model m,@ModelAttribute("UserLogin")User loginval,HttpSession session,HttpServletRequest req,ModelAndView model) throws  NoSuchAlgorithmException, IOException {
			try {
			int result=userdao.loginvalidation(loginval);
			
			User user=userdao.getRegister(loginval);
			session.setAttribute("user", user);
//			
			String name =req.getParameter("username");
			String password =req.getParameter("password");
			
			if(result>0) {
				
				if(userdao.loginvalidation(loginval)==1) {
				
//					HttpSession session= req.getSession(); 
//					

					List<Movie> Newadd = userdao.NewaddMovie();
					
					System.out.println("It is rlly" +Newadd);

					session.setAttribute("username",name);
					  if (Newadd.isEmpty()) {
					        m.addAttribute("message", "No new Uploaded movie this week!!!!.");
					    	m.addAttribute("search" ,new Movie());
					    	model.setViewName("Home");
					    } else {
					    	m.addAttribute("search" ,new Movie());
							model.addObject("Newaddedmovie", Newadd);
							 m.addAttribute("Newaddedmovie", Newadd);
						      
							model.setViewName("Home");
					    }
					  model.addObject("Newaddedmovie", Newadd);
					 m.addAttribute("Newaddedmovie", Newadd);
					session.setAttribute("username",name);
					session.setAttribute("user", user);
//					
					session.setAttribute("password",password);
					m.addAttribute("search" ,new Movie());
					model.setViewName("Home");
					return	model;
				}else {
					m.addAttribute("error","I N V A L I D!!");
				//	m.addAttribute("search" ,new Movie());
					model.setViewName("Login");
					return model;
				}
			
			
			}else {
				m.addAttribute("error", "Something is wrong! PLS TRY AGAIN!!! ");
				//m.addAttribute("search" ,new User());
				model.setViewName("Login");
				return model;
			}
		
				
			}catch(EmptyResultDataAccessException e) {
				m.addAttribute("error", "Something is wrong! PLS TRY AGAIN!!! ");
			//	m.addAttribute("search" ,new User());
				model.setViewName("Login");
				return model;
			}
		
		}
	 
	 //search movie,actor,actress,director
	 @RequestMapping("/search")
		public String searchmovie(@ModelAttribute("search")Movie movie,Model m) {
			List<Movie> movieList=userdao.FindBymovietitle(movie.getMovie_title());
			System.out.println("is  that worth??");
			
		//	List<Actor> actorList=userdao.FindByactorname(actor.getActor_name());
			  if (movieList.isEmpty()) {
			        m.addAttribute("message", "No movies were found based on your search query.");
			        return "Searchmovieview";
			    } else {
			        m.addAttribute("movies", movieList);
			        return "Searchmovieview";
			    }
		}
	 @RequestMapping("/dbmsactorsearch")
		public String searchactor(@ModelAttribute("searchactor")Actor actor,Model m) {
			List<Actor> actorList=userdao.FindByactorname(actor.getActor_name());
			System.out.println("is  that worth??");
			
		//	List<Actor> actorList=userdao.FindByactorname(actor.getActor_name());
			  if (actorList.isEmpty()) {
			        m.addAttribute("message", "No actor were found based on your search query.");
			        return "Searchactorview";
			    } else {
			    	
			        m.addAttribute("actors", actorList);
			        return "Searchactorview";
			    }
		}
	 
	 //search movie,actor,actress,director

	 @RequestMapping("/searchactress")
		public String Actresssearch(@ModelAttribute("searchactress")Actress actress,Model m) {
			List<Actress> actressList=userdao.FindByactressname(actress.getActress_name());
			System.out.println("is  that worth??");
			
		//	List<Actor> actorList=userdao.FindByactorname(actor.getActor_name());
			  if (actressList.isEmpty()) {
			        m.addAttribute("message", "No actress were found based on your search query.");
			        return "Searchactressview";
			    } else {
			      m.addAttribute("actress", actressList);
			        return "Searchactressview";
			    }
		}
	 
	 @RequestMapping("/searchdirector")
		public String Directorsearch(@ModelAttribute("searchdirector")Director dir,Model m) {
			List<Director> actressList=userdao.FindBydirectorname(dir.getDirector_name());
			System.out.println("is  that worth??");
			
		//	List<Actor> actorList=userdao.FindByactorname(actor.getActor_name());
			  if (actressList.isEmpty()) {
			        m.addAttribute("message", "No director were found based on your search query.");
			        return "Searchdirectorview";
			    } else {
			        m.addAttribute("director", actressList);
			        return "Searchdirectorview";
			    }
		}
	 
		@RequestMapping(value = "/getMoviePhoto/{id}" )
		public void getMoviePhoto(Model m,HttpServletResponse response, @PathVariable("id") int id) throws Exception {
			response.setContentType("image/jpeg");
			System.out.println(id);
			Blob ph = userdao.getAllMovieById(id);

			byte[] bytes = ph.getBytes(1, (int) ph.length());

			InputStream inputStream = new ByteArrayInputStream(bytes);
			IOUtils.copy(inputStream, response.getOutputStream());
				
		}
		
		
		@RequestMapping(value = "/getActorPhoto/{id}" )
		public void getActorphoto(Model m,HttpServletResponse response, @PathVariable("id") int id) throws Exception {
			response.setContentType("image/jpeg");
			System.out.println(id);
			Blob ph = userdao.getactorImagebyid(id);

			byte[] bytes = ph.getBytes(1, (int) ph.length());

			InputStream inputStream = new ByteArrayInputStream(bytes);
			IOUtils.copy(inputStream, response.getOutputStream());
				
		}
		
		@RequestMapping(value = "/getActressPhoto/{id}" )
		public void getActressPhoto(Model m,HttpServletResponse response, @PathVariable("id") int id) throws Exception {
			response.setContentType("image/jpeg");
			System.out.println(id);
			Blob ph = userdao.getactressImagebyid(id);

			byte[] bytes = ph.getBytes(1, (int) ph.length());

			InputStream inputStream = new ByteArrayInputStream(bytes);
			IOUtils.copy(inputStream, response.getOutputStream());
				
		}
		
		@RequestMapping(value = "/getDirectorPhoto/{id}" )
		public void getDirectorPhoto(Model m,HttpServletResponse response, @PathVariable("id") int id) throws Exception {
			response.setContentType("image/jpeg");
			System.out.println(id);
			Blob ph = userdao.getdirectorImagebyid(id);

			byte[] bytes = ph.getBytes(1, (int) ph.length());

			InputStream inputStream = new ByteArrayInputStream(bytes);
			IOUtils.copy(inputStream, response.getOutputStream());
				
		}
		
		
		//movie search
		 @RequestMapping(value="/moviesearch")
			public String Moviesearch(Model m,ModelAndView model) {
				 m.addAttribute("search",new Movie());

					List<Movie> Newadd = userdao.NewaddMovie();
					model.addObject("Newaddedmovie", Newadd);
					 m.addAttribute("Newaddedmovie", Newadd);
				 return "moviesearch";
			}
		
		 
		 //actorsearch
		 @RequestMapping(value="/actorsearch")
			public String Actorsearch(Model m) {
				List<Movie> Newadd = userdao.NewaddMovie();
				 m.addAttribute("Newaddedmovie", Newadd);
				
				 m.addAttribute("searchactor",new Actor());
				 return "actorsearch";
			}
		 
		 @RequestMapping(value="/actresssearch")
			public String Actresssearch(Model m) {

				List<Movie> Newadd = userdao.NewaddMovie();
				 m.addAttribute("Newaddedmovie", Newadd);
				 m.addAttribute("searchactress",new Actress());
				 return "actresssearch";
			}
		 
		 @RequestMapping(value="/directorsearch")
			public String Directorsearch(Model m) {

				List<Movie> Newadd = userdao.NewaddMovie();
				 m.addAttribute("Newaddedmovie", Newadd);
				
				 m.addAttribute("searchdirector",new Director());
				 return "directorsearch";
			}
	 //logoutcontroller
	 
	 
		@RequestMapping("/Logout")
		public String Logout(Model m,HttpServletRequest request) {
			m.addAttribute("search",new Movie());
		     HttpSession session=request.getSession();  
	         session.invalidate(); 
	         return "Logout";
		}
		@RequestMapping("/Logoutcompletenoti")
		public String Logoutnoti() {
			return "../../index";
		}
		
		 
		 
			/*all movie show*/
			@RequestMapping(value ="/movie")
			public ModelAndView AlllistMovie(Model m ,ModelAndView model) throws IOException {
			 m.addAttribute("search" ,new Movie());		
				List<Movie> listStu = userdao.MovieList();
				System.out.println("It is rlly" +listStu);
			
				model.addObject("listStu", listStu);
				model.setViewName("movie");

				return model;
			}
			
			//fantasy list
			@RequestMapping(value ="/Fantasy")
			public ModelAndView FantasyMovie(Model m ,ModelAndView model) throws IOException {
			 m.addAttribute("search" ,new Movie());		
				List<Category> Fantasy = userdao.FantasyList();
				System.out.println("It is rlly" +Fantasy);
			
				model.addObject("Fantasy", Fantasy);
				model.setViewName("Fantasy");

				return model;
			}
			
			@RequestMapping(value = "/getFantasyPhoto/{id}" )
			public void getFantasyPhoto(Model m,HttpServletResponse response, @PathVariable("id") int id) throws Exception {
				response.setContentType("image/jpeg");
				System.out.println(id);
				Blob ph = userdao.getFantasyMovie(id);

				byte[] bytes = ph.getBytes(1, (int) ph.length());

				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
					
			}
			
			
			//fantasy list
			@RequestMapping(value ="/Comedy")
			public ModelAndView ComedyMovie(Model m ,ModelAndView model) throws IOException {
			 m.addAttribute("search" ,new Movie());		
				List<Category> Comedy = userdao.ComedyList();
				System.out.println("It is rlly" +Comedy);
			
				model.addObject("Comedy", Comedy);
				model.setViewName("Comedy");

				return model;
			}
			
			@RequestMapping(value = "/getComedyPhoto/{id}" )
			public void getComedyPhoto(Model m,HttpServletResponse response, @PathVariable("id") int id) throws Exception {
				response.setContentType("image/jpeg");
				System.out.println(id);
				Blob ph = userdao.getComedyMovie(id);

				byte[] bytes = ph.getBytes(1, (int) ph.length());

				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
					
			}
			
			
			//fantasy list
			@RequestMapping(value ="/Horror")
			public ModelAndView HorrorMovie(Model m ,ModelAndView model) throws IOException {
			 m.addAttribute("search" ,new Movie());		
				List<Category> Horror = userdao.HorrorList();
				System.out.println("It is rlly" +Horror);
			
				model.addObject("Horror", Horror);
				model.setViewName("Horror");

				return model;
			}
			
			@RequestMapping(value = "/getHorrorPhoto/{id}" )
			public void getHorrorPhoto(Model m,HttpServletResponse response, @PathVariable("id") int id) throws Exception {
				response.setContentType("image/jpeg");
				System.out.println(id);
				Blob ph = userdao.getHorrorMovie(id);

				byte[] bytes = ph.getBytes(1, (int) ph.length());

				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
					
			}
			
		
			
			//fantasy list
			@RequestMapping(value ="/Animation")
			public ModelAndView AnimationMovie(Model m ,ModelAndView model) throws IOException {
			 m.addAttribute("search" ,new Movie());		
				List<Category> Animation = userdao.AnimationList();
				System.out.println("It is rlly" +Animation);
			
				model.addObject("Animation", Animation);
				model.setViewName("Animation");

				return model;
			}
			
			@RequestMapping(value = "/getAnimationPhoto/{id}" )
			public void getAnimationPhoto(Model m,HttpServletResponse response, @PathVariable("id") int id) throws Exception {
				response.setContentType("image/jpeg");
				System.out.println(id);
				Blob ph = userdao.getAnimationMovie(id);

				byte[] bytes = ph.getBytes(1, (int) ph.length());

				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
					
			}
			
			@RequestMapping("/Aboutus")
			public String aboutus(Model m) {
				m.addAttribute("search",new Movie());

				return "Aboutus";
			}
			 
			
			//actor view detail list
			@RequestMapping("/actorviewdetail/{actor_id}")
			public ModelAndView ActorView(@ModelAttribute("searchactor")Actor actor,ModelAndView model,@PathVariable("actor_id")int id,Model m) throws IOException {
				
				Actor listStu = userdao.getActorId(id);

				List<Movie> actormovie = userdao.getActormovielist(id);
				List<Actor> actorList=userdao.FindByactorname(actor.getActor_name());
				
				  if (actormovie.isEmpty()) {
				        m.addAttribute("message", "No movie related with this actor is still not updated!");
				        
				    }
		        m.addAttribute("actors", actorList);
				 m.addAttribute("searchactor",new Actor());
				m.addAttribute("search" ,new Movie());
				System.out.print(id);
				m.addAttribute("searchactor",new Actor());
				model.addObject("actorview", listStu);
				model.addObject("actormovie", actormovie);
				model.setViewName("actorviewdetail");
				return model;
			}
			
			@RequestMapping(value ="actorviewdetail/getimgActor/{actor_id}" , method=RequestMethod.GET )
			public void getimgMovie(Model m,HttpServletResponse response, @PathVariable("actor_id") int id) throws Exception {
				response.setContentType("image/jpeg");
				Blob ph = userdao.getActorimage(id);
				byte[] bytes = ph.getBytes(1, (int) ph.length());
				System.out.println("actor_image id wgere "+ id);
				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
					
			}
			@RequestMapping(value ="actorviewdetail/getimgMovie/{movie_id}" , method=RequestMethod.GET )
			public void getimgMovieactor(Model m,HttpServletResponse response, @PathVariable("movie_id") int id) throws Exception {
				response.setContentType("image/jpeg");
				Blob ph = userdao.getAllMovieById(id);
				byte[] bytes = ph.getBytes(1, (int) ph.length());
				System.out.println("actor_image id wgere "+ id);
				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
					
			}
			
			//actress view detail list
			@RequestMapping("/actressviewdetail/{actress_id}")
			public ModelAndView ActressView(@ModelAttribute("searchactress")Actress actress,ModelAndView model,@PathVariable("actress_id")int id,Model m) throws IOException {
				
				Actress listStu = userdao.getActressId(id);

				List<Movie> actressmovie = userdao.getActressmovielist(id);
				List<Actress> actressList=userdao.FindByactressname(actress.getActress_name());
			     m.addAttribute("actress", actressList);
				 
				 m.addAttribute("searchactor",new Actor());
				m.addAttribute("search" ,new Movie());
				System.out.print(id);
				m.addAttribute("searchactress",new Actress());
				model.addObject("actressview", listStu);
				model.addObject("actressmovie", actressmovie);
				model.setViewName("actressviewdetail");
				return model;
			}
			
			@RequestMapping(value ="actressviewdetail/getimgActress/{actress_id}" , method=RequestMethod.GET )
			public void getimgActress(Model m,HttpServletResponse response, @PathVariable("actress_id") int id) throws Exception {
				response.setContentType("image/jpeg");
				Blob ph = userdao.getActressimage(id);
				byte[] bytes = ph.getBytes(1, (int) ph.length());
				System.out.println("actor_image id wgere "+ id);
				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
					
			}
			@RequestMapping(value ="actressviewdetail/getimgMovie/{movie_id}" , method=RequestMethod.GET )
			public void getimgMovieactress(Model m,HttpServletResponse response, @PathVariable("movie_id") int id) throws Exception {
				response.setContentType("image/jpeg");
				Blob ph = userdao.getAllMovieById(id);
				byte[] bytes = ph.getBytes(1, (int) ph.length());
				System.out.println("actor_image id wgere "+ id);
				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
					
			}
			
		
			//director view detail list
			@RequestMapping("/directorviewdetail/{director_id}")
			public ModelAndView DirectorView(@ModelAttribute("searchdirector")Director director,ModelAndView model,@PathVariable("director_id")int id,Model m) throws IOException {
				
				Director listStu = userdao.getDirectorId(id);

				List<Movie> directormovie = userdao.getDirectormovielist(id);
				List<Director> actressList=userdao.FindBydirectorname(director.getDirector_name());

		        m.addAttribute("director", actressList);

				m.addAttribute("search" ,new Movie());
				System.out.print(id);
				m.addAttribute("searchactress",new Actress());
				model.addObject("directorview", listStu);
				model.addObject("directormovie", directormovie);
				model.setViewName("directorviewdetail");
				return model;
			}
			
			@RequestMapping(value ="directorviewdetail/getimgDirector/{director_id}" , method=RequestMethod.GET )
			public void getimgDirector(Model m,HttpServletResponse response, @PathVariable("director_id") int id) throws Exception {
				response.setContentType("image/jpeg");
				Blob ph = userdao.getDirectorimage(id);
				byte[] bytes = ph.getBytes(1, (int) ph.length());
				System.out.println("actor_image id wgere "+ id);
				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
					
			}
			@RequestMapping(value ="directorviewdetail/getimgMovie/{movie_id}" , method=RequestMethod.GET )
			public void getimgMoviedirector(Model m,HttpServletResponse response, @PathVariable("movie_id") int id) throws Exception {
				response.setContentType("image/jpeg");
				Blob ph = userdao.getAllMovieById(id);
				byte[] bytes = ph.getBytes(1, (int) ph.length());
				System.out.println("actor_image id wgere "+ id);
				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
					
			}
		
			
			
			
			//movie view detail and give rating comment
			
			@RequestMapping("/ViewDetails/{movie_id}")
			public ModelAndView listMovie(ModelAndView model,@PathVariable("movie_id")int id,Model m) throws IOException {
				
				Movie listStu = userdao.getMovieId(id);
				List<Rating> listreview= userdao.ReviewList(id);
				Rating reviewcount= userdao.ReviewCount(id);
				
				m.addAttribute("search" ,new Movie());
				System.out.print(id);
				for(Rating r: listreview) {
					System.out.println(r.getUsername());
				}
				
				
				model.addObject("movielist", listStu);
				model.addObject("listreview",listreview);
				model.addObject("reviewcount",reviewcount);
				model.addObject("review", new Rating());
				model.setViewName("ViewDetails");
				System.out.println("got username" + listreview);
				return model;
			}

		
			
			 @RequestMapping(value ="/giveRating/{movie_id}" ,method=RequestMethod.POST)
			public String giveRating(ModelAndView model,@ModelAttribute("review")Rating review,Model m,@PathVariable("movie_id")int id, @ModelAttribute("reg") User reg,HttpServletRequest req,RedirectAttributes attributes,HttpSession session,RedirectAttributes redirectAttributes)throws IOException {
				m.addAttribute("search" ,new Movie());
				
//				session.setAttribute("user_id", user.getUser_id());
//				session.setAttribute("username",name);
//				session.setAttribute("password",password);
				User user=(User) session.getAttribute("user");
				
				//String user_id1=(String) session.getAttribute("user_id");
				//int userid=Integer.parseInt(user_id1);
				
				review.setUser_id(user.getUser());
				review.setMovie_id(id);
			
				userdao.giveReview(review);
					
				
				System.out.println("User Id"+ user.getUser());
				System.out.println("Movie ID"+ id);
				//List<Review> listreview= reviewdao.ReviewList();
				//m.addAttribute("disableSubmitButton", true);
				
				attributes.addAttribute("attribute", "/ViewDetails/{movie_id}");
				attributes.addFlashAttribute("flashAttribute", "/ViewDetails/{movie_id}");
				 redirectAttributes.addFlashAttribute("hideButton", true);
			    return "redirect:/ViewDetails/{movie_id}";
			//
			}


			
			
			@RequestMapping(value = "ViewDetails/getimgMovie/{movie_id}" , method=RequestMethod.GET )
			public void getimgMovie2(Model m,HttpServletResponse response, @PathVariable("movie_id") int id) throws Exception {
				response.setContentType("image/jpeg");
				Blob ph = userdao.getMovieimage(id);
				System.out.println("got movie_image");
				byte[] bytes = ph.getBytes(1, (int) ph.length());

				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
					
			}
			
			@RequestMapping(value = "ViewDetails/getActoridimg/{movie_id}",method = RequestMethod.GET)
			public void getActorimg(Model m,HttpServletResponse response, @PathVariable("movie_id") int id) throws Exception {
				response.setContentType("image/jpeg");
				
				Blob ph = userdao.getActoridimg(id);

				byte[] bytes = ph.getBytes(1, (int) ph.length());

				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
					
			}
			@RequestMapping(value = "ViewDetails/getActressidimg/{movie_id}" ,method = RequestMethod.GET)
			public void getActressimg(Model m,HttpServletResponse response, @PathVariable("movie_id") int id) throws Exception {
				response.setContentType("image/jpeg");
				
				Blob ph = userdao.getActressidimg(id);

				byte[] bytes = ph.getBytes(1, (int) ph.length());

				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
					
			}
			@RequestMapping(value = "ViewDetails/getDirectoridimg/{movie_id}" ,method = RequestMethod.GET)
			public void getDirectorimg(Model m,HttpServletResponse response, @PathVariable("movie_id") int id) throws Exception {
				response.setContentType("image/jpeg");
				
				Blob ph = userdao.getDirectoridimg(id);

				byte[] bytes = ph.getBytes(1, (int) ph.length());

				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
					
			}
			 @RequestMapping("/Awardsandothers")
			 public String awardandother(Model m) {
				 m.addAttribute("movie",new Movie());
				 m.addAttribute("search" ,new Movie());
				 return "Awardsandothers";
			 }
			 
				//OscarawardMovie
				@RequestMapping(value ="/OscarAwardMovie")
				public ModelAndView OscarMovie(Model m ,ModelAndView model) throws IOException {
				 m.addAttribute("search" ,new Movie());		
					List<Movie> Oscarlist = userdao.OscarList();
					System.out.println("It is rlly" +Oscarlist);
				
					model.addObject("Oscarlist", Oscarlist);
					model.setViewName("OscarAwardMovie");

					return model;
				}
				
				
				
				//GrammyawardMovie
				@RequestMapping(value ="/GrammyAwardMovie")
				public ModelAndView GrammyMovie(Model m ,ModelAndView model) throws IOException {
				 m.addAttribute("search" ,new Movie());		
					List<Movie> GrammyList = userdao.GrammyList();
					System.out.println("It is rlly" +GrammyList);
				
					model.addObject("Grammylist", GrammyList);
					model.setViewName("GrammyAwardMovie");

					return model;
				}
			
				
				@RequestMapping("/ReadMore")
				public String ReadMore(Model m) {
					m.addAttribute("search" ,new Movie());
					return "ReadMore";
				}

}
