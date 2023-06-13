package com.java.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.java.beans.Actor;
import com.java.beans.Actress;
import com.java.beans.Admin;
import com.java.beans.Category;
import com.java.beans.Director;
import com.java.beans.Movie;
import com.java.beans.User;
import com.java.dao.Admindao;
import com.java.dao.Userdao;

@Controller
public class AdminController {
	
	@Autowired
	Admindao admindao;
	
	@Autowired
	Userdao userdao;
	
	@RequestMapping("/AdminLogin")
	public String admin(Model m) {
		m.addAttribute("adminlogin",new Admin());
		
		
		return "AdminLogin";
		
	}
	
	//adminformvalidation
	@RequestMapping(value="/adminform" )
	public String  Login(Model m, @ModelAttribute("adminlogin")Admin loginval,@ModelAttribute("movie") Movie movie,@ModelAttribute("category") Category category) {
		int result=admindao.adminvalidation(loginval);
		System.out.println(result);
		
		if(result>0) {
			
			if(admindao.adminvalidation(loginval)==1) {
				m.addAttribute("movie", new Movie());
				m.addAttribute("category",new Category());
				 m.addAttribute("actor",new Actor());
				 m.addAttribute("actress",new Actress());
				 m.addAttribute("director",new Director());
					return "Castupload";
			}else {
				m.addAttribute("error","I N V A L I D!!");
				return "AdminLogin";
			}
		
		
		}else {
			m.addAttribute("error", "Something is wrong! PLS TRY AGAIN!!! ");
			return "AdminLogin";
		}
	}
	
	
	 @RequestMapping("/movieupload")
	 public ModelAndView MovieUpload(ModelAndView model,Model m,@ModelAttribute("movie")Movie review)throws IOException{
		 m.addAttribute("movie",new Movie());
		 Actor user=new Actor();
		 List<Actor> actorlist = admindao.actorlist();

		 List<Actress> actresslist = admindao.actresslist();

		 List<Director> directorlist= admindao.directorlist();
		 m.addAttribute("actorlist",actorlist);
		 m.addAttribute("actresslist",actresslist);
		 m.addAttribute("directorlist",directorlist);
	//	Actress actress=new Actress();
		//Director director = new Director();
		//Category category = new Category();
		//Award award =new Award();
		 //review.setActor_id(user.getActor_id());
		 //review.setActress_id(actress.getActress_id());
		 //review.setDirector_id(director.getDirector_id());
		 //review.setCategory_id(category.getCategory_id());
		 //review.setAward_id(award.getAward_id());
		 
			model.setViewName("movieupload");
			return model;
		}
	 
	 @RequestMapping(value = "/actorupload", method=RequestMethod.POST)
		public String moviesave(Model m,@RequestParam("file") MultipartFile file,@ModelAttribute("actor")Actor actor) throws DataAccessException, IOException {
		 m.addAttribute("movie",new Movie());
		 m.addAttribute("search" ,new Movie());
		 m.addAttribute("actor",new Actor());
		 m.addAttribute("actress",new Actress());
		 m.addAttribute("director",new Director());
			
			admindao.insertactor(file,actor);
			return "Castupload";
		
		}
	 
	 @RequestMapping(value = "/actressupload", method=RequestMethod.POST)
		public String moviesave(Model m,@RequestParam("file") MultipartFile file,@ModelAttribute("actress")Actress actor) throws DataAccessException, IOException {
		 m.addAttribute("movie",new Movie());
		 m.addAttribute("search" ,new Movie());
		 m.addAttribute("actor",new Actor());
		 m.addAttribute("actress",new Actress());
		 m.addAttribute("director",new Director());
			
			admindao.insertactress(file,actor);
			return "Castupload";
		
		}
	 
	 @RequestMapping(value = "/directorupload", method=RequestMethod.POST)
		public String moviesave(Model m,@RequestParam("file") MultipartFile file,@ModelAttribute("director")Director actor) throws DataAccessException, IOException {
		 m.addAttribute("movie",new Movie());
		 m.addAttribute("search" ,new Movie());
		 m.addAttribute("actor",new Actor());
		 m.addAttribute("actress",new Actress());
		 m.addAttribute("director",new Director());
			
			admindao.insertdirector(file,actor);
			return "Castupload";
		
		}
	 
	 
	 @RequestMapping(value = "/uploadmovie", method=RequestMethod.POST)
		public String uploadmovie(Model m,@RequestParam("file") MultipartFile file,@ModelAttribute("movie")Movie movie) throws DataAccessException, IOException {
		 m.addAttribute("movie",new Movie());
		 m.addAttribute("search" ,new Movie());
		 m.addAttribute("actor",new Actor());
		 m.addAttribute("actress",new Actress());
		 m.addAttribute("director",new Director());
			System.out.println("This is here..");
			admindao.moviesave(file,movie);
			return "uploadfinish";
		
		}
	 
	 @RequestMapping("/Castupload")
	 public String CastUpload(Model m) {
		 m.addAttribute("actor",new Actor());
		 m.addAttribute("actress",new Actress());
		 m.addAttribute("director",new Director());
		 
		 m.addAttribute("search" ,new Movie());
		 return "Castupload";
	 }
	 
	 
	
	
/*	@RequestMapping(value = "/movieupload", method=RequestMethod.GET)
	public String moviesave(@RequestParam("file") MultipartFile file,@RequestParam("file2") MultipartFile file2,@RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4,@ModelAttribute("movie")Movie movie) throws DataAccessException, IOException {
		
		
		admindao.moviesave(file,file2,file3,file4,movie);
		return "uploadfinish";
	
	}*/
	 
	 
	 //movielist
	//MovieList
			@RequestMapping(value="/movielist")
			public ModelAndView listMovie(ModelAndView model,Model m)throws IOException{
				
				List<Movie> listmovie= admindao.Listingmovie();
				model.addObject("listmovie", listmovie);
				m.addAttribute("ttmovie",admindao.ttmovie());
				model.setViewName("movielist");
				return model;
			}
			
			@RequestMapping(value="/delete/{movie_id}", method= RequestMethod.GET)
			public String delete(@PathVariable("movie_id") int movie_id,Model m) {
				ModelAndView model = new ModelAndView();
				
				model.addObject("listmovie",movie_id);
				System.out.println("delete" +movie_id);

				m.addAttribute("deletesuccess","Movie was deleted successfully");
				admindao.delete(movie_id);
				return "redirect:/movielist";
			}
			
			@RequestMapping(value="/edit/{movie_id}", method= RequestMethod.GET)
			public String edit(@PathVariable("movie_id") int movie_id,Movie m,Model mo)  throws IOException{
				ModelAndView model = new ModelAndView();
				model.addObject("listmovie",movie_id);
				System.out.println("edit" +movie_id);

				Movie movie = admindao.getMovieId(movie_id);
				
				 List<Actor> actorlist = admindao.actorlist();

				 List<Actress> actresslist = admindao.actresslist();

				 List<Director> directorlist= admindao.directorlist();
				 mo.addAttribute("actorlist",actorlist);
				 mo.addAttribute("actresslist",actresslist);
				 mo.addAttribute("directorlist",directorlist);
				return "Editmovie";
			}
			@RequestMapping(value="/edit/Editsave",method = RequestMethod.POST)
			public String Editsave(@RequestParam("file") MultipartFile file,@ModelAttribute("movie")Movie m,Model model)  throws IOException{
				
				System.out.println("This edit is not working" +m.getMovie_id());
				admindao.edit(file,m);
				return "redirect:/movielist";
			}

			//Register
			@RequestMapping(value="/Customerlist")
			public ModelAndView listcustomer(ModelAndView model,Model m)throws IOException{
				
				List<User> listcus= admindao.UserList();
				model.addObject("listcus", listcus);
				m.addAttribute("countacc",admindao.regaccount());
				System.out.println(admindao.regaccount());
				User  usersearch = new User();
				m.addAttribute("customersearch" ,usersearch);
				model.setViewName("Customerlist");
				return model;
			}
			
			 @RequestMapping("/uploadcomplete")
			 public String uploadcomplete(Model m) {
					
				 List<Actor> actorlist = admindao.actorlist();

				 List<Actress> actresslist = admindao.actresslist();

				 List<Director> directorlist= admindao.directorlist();
				 m.addAttribute("actorlist",actorlist);
				 m.addAttribute("actresslist",actresslist);
				 m.addAttribute("directorlist",directorlist);
				 m.addAttribute("movie",new Movie());
				 m.addAttribute("search" ,new Movie());
				 return "movieupload";
			 }
			 
				@RequestMapping("/customersearch")
				public String searchuser(@ModelAttribute("customersearch")User reg,Model m) {
					List<User> userList=admindao.Searchuser(reg.getUsername());
					
					m.addAttribute("userlist",userList);
					
					return "CustomerSearchview";
				}
				
				@RequestMapping("/ActorList")
				public String ActorList(ModelAndView model,Model m) {
					List<Actor> userList=admindao.ActorList();
					m.addAttribute("Actorcount",admindao.Actorcount());
					m.addAttribute("actorlist",userList);
					
					return "ActorList";
				}
				
				
				@RequestMapping(value="/actoredit/{actor_id}", method= RequestMethod.GET)
				public String actoredit(@PathVariable("actor_id") int actor_id,Model m)  throws IOException{
					ModelAndView model = new ModelAndView();
					model.addObject("actorlist",actor_id);
					System.out.println("edit" +actor_id);
					Actor movie = admindao.getActorid(actor_id);
					
					
					 m.addAttribute("actor_id", actor_id);
					 m.addAttribute("actor", new Actor());

					return "Actoredit";
				}
				
				@RequestMapping(value="/actoredit/actoruploadedit",method = RequestMethod.POST)
				public String actoruploadedit(@RequestParam("file")MultipartFile file,@ModelAttribute("actor")Actor actor)  throws IOException{
					
					System.out.println("This edit is not working" +actor.getActor_id());
					admindao.actoredit(file,actor);
					return "redirect:/ActorList";
				}

				
				@RequestMapping("/ActressList")
				public String ActressList(ModelAndView model,Model m) {
					List<Actress> userList=admindao.ActressList();
					m.addAttribute("Actresscount",admindao.Actresscount());
					m.addAttribute("actresslist",userList);
					
					return "ActressList";
				}
				
				
				@RequestMapping(value="/actressedit/{actress_id}", method= RequestMethod.GET)
				public String actressedit(@PathVariable("actress_id") int actress_id,Model m)  throws IOException{
					ModelAndView model = new ModelAndView();
					model.addObject("actresslist",actress_id);
					
					 m.addAttribute("actress_id", actress_id);
					 m.addAttribute("actress", new Actress());

					return "Actressedit";
				}
				
				@RequestMapping(value="/actressedit/actressuploadedit",method = RequestMethod.POST)
				public String actressuploadedit(@RequestParam("file")MultipartFile file,@ModelAttribute("actress")Actress actor)  throws IOException{
					
					System.out.println("This edit is not working" +actor.getActress_id());
					admindao.actressedit(file,actor);
					return "redirect:/ActressList";
				}
				
				
				
				
				
				

				@RequestMapping("/DirectorList")
				public String DirectorList(ModelAndView model,Model m) {
					List<Director> userList=admindao.DirectorList();
					m.addAttribute("directorcount",admindao.Directorcount());
					m.addAttribute("directorlist",userList);
					
					return "DirectorList";
				}
				
				
				@RequestMapping(value="/directoredit/{director_id}", method= RequestMethod.GET)
				public String directoredit(@PathVariable("director_id") int director_id,Model m)  throws IOException{
					ModelAndView model = new ModelAndView();
					model.addObject("directorlist",director_id);
					
					 m.addAttribute("actress_id", director_id);
					 m.addAttribute("director", new Director());

					return "Directoredit";
				}
				
				@RequestMapping(value="/directoredit/directoruploadedit",method = RequestMethod.POST)
				public String directoruploadedit(@RequestParam("file")MultipartFile file,@ModelAttribute("director")Director actor)  throws IOException{
					
					System.out.println("This edit is not working" +actor.getDirector_id());
					admindao.directoredit(file,actor);
					return "redirect:/DirectorList";
				}


				



}
				
		

		
			 

