package com.java.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.beans.Actor;
import com.java.beans.Actress;
import com.java.beans.Category;
import com.java.beans.Director;
import com.java.beans.Movie;
import com.java.beans.Rating;
import com.java.beans.User;

public class Userdao {
	
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
	this.template = template;
	}
	
	public int register(User p){
		String sql="insert into user(username,userpassword,email,address)values('"+p.getUsername()+"','"+p.getUserpassword()+"','"+p.getEmail()+"','"+p.getAddress()+"')";
		new User();
		return template.update(sql);
		}
	
	

	//logivalidation dao
	public int loginvalidation(User p) {
		String sql="select count(*) from user where username= '"+p.getUsername()+"' and userpassword='"+p.getUserpassword()+"'";
		
		return template.queryForObject(sql,Integer.class);
	}
	
	//userlist
		public User getRegister(User register) throws NoSuchAlgorithmException, IOException {
		
		String sql = "select * from user where username='"+register.getUsername()+"' and userpassword='"+register.getUserpassword()+"' ";
		return template.queryForObject(sql, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User m= new User();
				m.setUser(rs.getInt(1));
		        m.setUsername(rs.getString(2));
		        m.setEmail(rs.getString(3));
		        m.setUserpassword(rs.getString(4));
		        m.setAddress(rs.getString(5));
		       
		        
		  		return m;
			}
		});
	}
		
	//search movie title dao
		
		public List<Movie> FindBymovietitle(String movie_title) {
				
				String sql ="select movie_id,movie_title,movie_image,actor_id,actress_id,director_id from movie where movie_title like '%"+movie_title+"%'";
				List<Movie> movies= template.query(sql, new RowMapper<Movie>() {
					
					
					public Movie mapRow(ResultSet rs,int row)throws SQLException{
						Movie m=new Movie();
						m.setMovie_id(rs.getInt("movie_id"));
						m.setMovie_title(rs.getString("movie_title"));
						m.setMovie_image(rs.getBlob("movie_image"));
						m.setActor_id(rs.getInt("actor_id"));
						m.setActress_id(rs.getInt("actress_id"));
						m.setDirector_id(rs.getInt("director_id"));
						return m;
					}
					
				
				
				});
				return movies;
		}
		
		//show search movie
	
		public Blob getAllMovieById(int id) {
			// TODO Auto
			String query="select movie_image from movie where movie_id=?";
			
			Blob photo= template.queryForObject(query, new Object[] { id }, Blob.class);
			return photo;
		}
		
		
		//getactorlist
		public List<Actor> FindByactorname(String actor_name) {
			
			String sql ="select actor_id,actor_image,actor_name,about,birth from actor where actor_name like '%"+actor_name+"%'";
			List<Actor> movies= template.query(sql, new RowMapper<Actor>() {
				
				
				public Actor mapRow(ResultSet rs,int row)throws SQLException{
					Actor m=new Actor();
					m.setActor_id(rs.getInt("actor_id"));
					m.setActor_name(rs.getString("actor_name"));
					m.setActor_image(rs.getBlob("actor_image"));
					m.setBirth(rs.getString("birth"));
					m.setAbout(rs.getString("About"));
					return m;
				}
				
			
			
			});
			return movies;
	}
		public Blob getactorImagebyid(int id) {
			// TODO Auto
			String query="select actor_image from actor where actor_id=?";
			
			Blob photo= template.queryForObject(query, new Object[] { id }, Blob.class);
			return photo;
		}
		
	public List<Actress> FindByactressname(String actress_name) {
			
			String sql ="select actress_id,actress_image,actress_name,about,birth from actress where actress_name like '%"+actress_name+"%'";
			List<Actress> movies= template.query(sql, new RowMapper<Actress>() {
				
				
				public Actress mapRow(ResultSet rs,int row)throws SQLException{
					Actress m=new Actress();
					m.setActress_id(rs.getInt("actress_id"));
					m.setActress_name(rs.getString("actress_name"));
					m.setActress_image(rs.getBlob("actress_image"));
					m.setBirth(rs.getString("birth"));
					m.setAbout(rs.getString("About"));
					return m;
				}
				
			
			
			});
			return movies;
	}
	public Blob getactressImagebyid(int id) {
		// TODO Auto
		String query="select actress_image from actress where actress_id=?";
		
		Blob photo= template.queryForObject(query, new Object[] { id }, Blob.class);
		return photo;
	}
	public Blob getdirectorImagebyid(int id) {
		// TODO Auto
		String query="select director_image from  director where director_id=?";
		
		Blob photo= template.queryForObject(query, new Object[] { id }, Blob.class);
		return photo;
	}
	
	public List<Director> FindBydirectorname(String director_name) {
		
		String sql ="select director_id,director_image,director_name,about,birth from director where director_name like '%"+director_name+"%'";
		List<Director> movies= template.query(sql, new RowMapper<Director>() {
			
			
			public Director mapRow(ResultSet rs,int row)throws SQLException{
				Director m=new Director();
				m.setDirector_id(rs.getInt("director_id"));
				m.setDirector_name(rs.getString("director_name"));
				m.setDirector_image(rs.getBlob("director_image"));
				m.setBirth(rs.getString("birth"));
				m.setAbout(rs.getString("About"));
				return m;
			}
			
		
		
		});
		return movies;
}
		
	/*show all movie by img*/
	public	List<Movie> MovieList() throws  IOException {
		List<Movie> list = template.query("select * from movie", new RowMapper<Movie>() {
			
			@Override
			public Movie mapRow(ResultSet rs, int row) throws SQLException {
				Movie m= new Movie();
				m.setMovie_id(rs.getInt("movie_id"));
		        m.setMovie_title(rs.getString("movie_title"));
		       m.setMovie_image(rs.getBlob("movie_image"));
		        m.setTrailer(rs.getString("trailer"));
		        m.setDescription(rs.getString("description"));
		        m.setCategory_id(rs.getInt("category_id"));
		        m.setAward_id(rs.getInt("award_id"));
		        m.setActor_id(rs.getInt("actor_id"));
		       // m.setActor_img(rs.getBlob("Actor_img"));
		        m.setActress_id(rs.getInt("actress_id"));
		      //  m.setActress_img(rs.getBlob("Actress_img"));
		        m.setDirector_id(rs.getInt("director_id"));
		        m.setReleasedate(rs.getString("releasedate"));
			    
		       // m.setDirector_img(rs.getBlob("Director_img"));
				return m;
			}
			
		});
		return list;
	}
	

	
	
	public Blob getFantasyMovie(int id) {
		// TODO Auto
		String query="select movie_image from movie,category where movie_id=? and category.category_id='1'";
		
		Blob photo= template.queryForObject(query, new Object[] { id }, Blob.class);
		return photo;
	}
	

	public	List<Category> FantasyList() throws  IOException {
		List<Category> list = template.query("select * from movie,category where  movie.category_id=category.category_id and  category.category_id='1'", new RowMapper<Category>() {
			
			@Override
			public Category mapRow(ResultSet rs, int row) throws SQLException {
				Movie m= new Movie();
				Category c= new Category();
				c.setMovie_id(rs.getInt("movie_id"));
		        c.setMovie_title(rs.getString("movie_title"));
		       // m.setMovie_image(rs.getBlob("movie_image"));
		        c.setTrailer(rs.getString("trailer"));
		        c.setDescription(rs.getString("description"));
		        c.setCategory_id(rs.getInt("Category_id"));
		        c.setAward_id(rs.getInt("award_id"));
		        c.setActor_id(rs.getInt("actor_id"));
		        c.setCategory_name(rs.getString("category_name"));
		       // m.setActor_img(rs.getBlob("Actor_img"));
		        c.setActress_id(rs.getInt("actress_id"));
		      //  m.setActress_img(rs.getBlob("Actress_img"));
		        c.setDirector_id(rs.getInt("director_id"));
		      
				return c;
			}
			
		});
		return list;
	}
public List<Movie> NewaddMovie()  {
		
		List<Movie> list = template.query("select * from movie where releasedate >=DATE_SUB(NOW(),INTERVAL 5 DAY)", new RowMapper<Movie>() {
			
		@Override
		public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
			Movie m = new Movie();
			m.setMovie_id(rs.getInt("movie_id"));
	        m.setMovie_title(rs.getString("movie_title"));
	       // m.setMovie_image(rs.getBlob("movie_image"));
	        m.setTrailer(rs.getString("trailer"));
	        m.setDescription(rs.getString("description"));
	        m.setCategory_id(rs.getInt("Category_id"));
	        m.setAward_id(rs.getInt("award_id"));
	        m.setActor_id(rs.getInt("actor_id"));
	       // m.setActor_img(rs.getBlob("Actor_img"));
	        m.setActress_id(rs.getInt("actress_id"));
	      //  m.setActress_img(rs.getBlob("Actress_img"));
	        m.setDirector_id(rs.getInt("director_id"));
			return m;
		}
	});

	return list;
}



public	List<Category> ComedyList() throws  IOException {
	List<Category> list = template.query("select * from movie,category where  movie.category_id=category.category_id and  category.category_id='3'", new RowMapper<Category>() {
		
		@Override
		public Category mapRow(ResultSet rs, int row) throws SQLException {
			Movie m= new Movie();
			Category c= new Category();
			c.setMovie_id(rs.getInt("movie_id"));
	        c.setMovie_title(rs.getString("movie_title"));
	       // m.setMovie_image(rs.getBlob("movie_image"));
	        c.setTrailer(rs.getString("trailer"));
	        c.setDescription(rs.getString("description"));
	        c.setCategory_id(rs.getInt("Category_id"));
	        c.setAward_id(rs.getInt("award_id"));
	        c.setActor_id(rs.getInt("actor_id"));
	        c.setCategory_name(rs.getString("category_name"));
	       // m.setActor_img(rs.getBlob("Actor_img"));
	        c.setActress_id(rs.getInt("actress_id"));
	      //  m.setActress_img(rs.getBlob("Actress_img"));
	        c.setDirector_id(rs.getInt("director_id"));
	      
			return c;
		}
		
	});
	return list;
}

public Blob getComedyMovie(int id) {
	// TODO Auto
	String query="select movie_image from movie,category where movie_id=? and category.category_id='3'";
	
	Blob photo= template.queryForObject(query, new Object[] { id }, Blob.class);
	return photo;
}



public	List<Category> HorrorList() throws  IOException {
	List<Category> list = template.query("select * from movie,category where  movie.category_id=category.category_id and  category.category_id='6'", new RowMapper<Category>() {
		
		@Override
		public Category mapRow(ResultSet rs, int row) throws SQLException {
			Movie m= new Movie();
			Category c= new Category();
			c.setMovie_id(rs.getInt("movie_id"));
	        c.setMovie_title(rs.getString("movie_title"));
	       // m.setMovie_image(rs.getBlob("movie_image"));
	        c.setTrailer(rs.getString("trailer"));
	        c.setDescription(rs.getString("description"));
	        c.setCategory_id(rs.getInt("Category_id"));
	        c.setAward_id(rs.getInt("award_id"));
	        c.setActor_id(rs.getInt("actor_id"));
	        c.setCategory_name(rs.getString("category_name"));
	       // m.setActor_img(rs.getBlob("Actor_img"));
	        c.setActress_id(rs.getInt("actress_id"));
	      //  m.setActress_img(rs.getBlob("Actress_img"));
	        c.setDirector_id(rs.getInt("director_id"));
	      
			return c;
		}
		
	});
	return list;
}

public Blob getHorrorMovie(int id) {
	// TODO Auto
	String query="select movie_image from movie,category where movie_id=? and category.category_id='6'";
	
	Blob photo= template.queryForObject(query, new Object[] { id }, Blob.class);
	return photo;
}



public	List<Category> AnimationList() throws  IOException {
	List<Category> list = template.query("select * from movie,category where  movie.category_id=category.category_id and  category.category_id='2'", new RowMapper<Category>() {
		
		@Override
		public Category mapRow(ResultSet rs, int row) throws SQLException {
			Movie m= new Movie();
			Category c= new Category();
			c.setMovie_id(rs.getInt("movie_id"));
	        c.setMovie_title(rs.getString("movie_title"));
	       // m.setMovie_image(rs.getBlob("movie_image"));
	        c.setTrailer(rs.getString("trailer"));
	        c.setDescription(rs.getString("description"));
	        c.setCategory_id(rs.getInt("Category_id"));
	        c.setAward_id(rs.getInt("award_id"));
	        c.setActor_id(rs.getInt("actor_id"));
	        c.setCategory_name(rs.getString("category_name"));
	       // m.setActor_img(rs.getBlob("Actor_img"));
	        c.setActress_id(rs.getInt("actress_id"));
	      //  m.setActress_img(rs.getBlob("Actress_img"));
	        c.setDirector_id(rs.getInt("director_id"));
	      
			return c;
		}
		
	});
	return list;
}

public Blob getAnimationMovie(int id) {
	// TODO Auto
	String query="select movie_image from movie,category where movie_id=? and category.category_id='2'";
	
	Blob photo= template.queryForObject(query, new Object[] { id }, Blob.class);
	return photo;
}


//actor_id
public	 Actor getActorId(int id) throws  IOException {
	
	String sql = "select * from actor where actor_id="+id+"";
	return template.queryForObject(sql, new RowMapper<Actor>() {
		public Actor mapRow(ResultSet rs, int row) throws SQLException {
			Actor m= new Actor();
			m.setActor_id(rs.getInt("actor_id"));
	        m.setActor_name(rs.getString("actor_name"));
	        m.setActor_image(rs.getBlob("actor_image"));
	        m.setAbout(rs.getString("about"));
	        m.setBirth(rs.getString("birth"));
			return m;
		}
		
	});
}
public Blob getActorimage(int id) {
// TODO Auto
String query="select actor_image from actor where actor_id=?";

Blob photo= template.queryForObject(query, new Object[]{id}, Blob.class);

return photo;
}	


public	List<Movie> getActormovielist(int id) throws  IOException {
	List<Movie> list = template.query("select * from movie,actor where actor.actor_id=movie.actor_id  and actor.actor_id="+id+"", new RowMapper<Movie>() {
		
		@Override
		public Movie mapRow(ResultSet rs, int row) throws SQLException {
			Movie m= new Movie();
			
			m.setMovie_id(rs.getInt("movie_id"));
	        m.setMovie_title(rs.getString("movie_title"));
	        m.setMovie_image(rs.getBlob("movie_image"));
	        m.setTrailer(rs.getString("trailer"));
	        m.setDescription(rs.getString("description"));
	        m.setCategory_id(rs.getInt("category_id"));
	        m.setAward_id(rs.getInt("award_id"));
	        m.setActor_id(rs.getInt("actor_id"));
	        // m.setActor_img(rs.getBlob("Actor_img"));
	        m.setActress_id(rs.getInt("actress_id"));
	      //  m.setActress_img(rs.getBlob("Actress_img"));
	        m.setDirector_id(rs.getInt("director_id"));
	      
			return m;
		}
		
	});
	return list;
}


public	List<Movie> getActressmovielist(int id) throws  IOException {
	List<Movie> list = template.query("select * from movie,actress where actress.actress_id=movie.actress_id and actress.actress_id="+id+"", new RowMapper<Movie>() {
		
		@Override
		public Movie mapRow(ResultSet rs, int row) throws SQLException {
			Movie m= new Movie();
			
			m.setMovie_id(rs.getInt("movie_id"));
	        m.setMovie_title(rs.getString("movie_title"));
	        m.setMovie_image(rs.getBlob("movie_image"));
	        m.setTrailer(rs.getString("trailer"));
	        m.setDescription(rs.getString("description"));
	        m.setCategory_id(rs.getInt("category_id"));
	        m.setAward_id(rs.getInt("award_id"));
	        m.setActor_id(rs.getInt("actor_id"));
	        // m.setActor_img(rs.getBlob("Actor_img"));
	        m.setActress_id(rs.getInt("actress_id"));
	      //  m.setActress_img(rs.getBlob("Actress_img"));
	        m.setDirector_id(rs.getInt("director_id"));
	      
			return m;
		}
		
	});
	return list;
}

public	 Actress getActressId(int id) throws  IOException {
	
	String sql = "select * from actress where actress_id="+id+"";
	return template.queryForObject(sql, new RowMapper<Actress>() {
		public Actress mapRow(ResultSet rs, int row) throws SQLException {
			Actress m= new Actress();
			m.setActress_id(rs.getInt("actress_id"));
	        m.setActress_name(rs.getString("actress_name"));
	        m.setActress_image(rs.getBlob("actress_image"));
	        m.setAbout(rs.getString("about"));
	        m.setBirth(rs.getString("birth"));
			return m;
		}
		
	});
}
public Blob getActressimage(int id) {
	// TODO Auto
	String query="select actress_image from actress where actress_id=?";

	Blob photo= template.queryForObject(query, new Object[]{id}, Blob.class);

	return photo;
	}	



public	 Director  getDirectorId(int id) throws  IOException {
	
	String sql = "select * from director where director_id="+id+"";
	return template.queryForObject(sql, new RowMapper<Director>() {
		public Director mapRow(ResultSet rs, int row) throws SQLException {
			Director m= new Director();
			m.setDirector_id(rs.getInt("director_id"));
	        m.setDirector_name(rs.getString("director_name"));
	        m.setDirector_image(rs.getBlob("director_image"));
	        m.setAbout(rs.getString("about"));
	        m.setBirth(rs.getString("birth"));
			return m;
		}
		
	});
}

public	List<Movie> getDirectormovielist(int id) throws  IOException {
	List<Movie> list = template.query("select * from movie,director where director.director_id=movie.director_id and director.director_id="+id+"", new RowMapper<Movie>() {
		
		@Override
		public Movie mapRow(ResultSet rs, int row) throws SQLException {
			Movie m= new Movie();
			
			m.setMovie_id(rs.getInt("movie_id"));
	        m.setMovie_title(rs.getString("movie_title"));
	        m.setMovie_image(rs.getBlob("movie_image"));
	        m.setTrailer(rs.getString("trailer"));
	        m.setDescription(rs.getString("description"));
	        m.setCategory_id(rs.getInt("category_id"));
	        m.setAward_id(rs.getInt("award_id"));
	        m.setActor_id(rs.getInt("actor_id"));
	        // m.setActor_img(rs.getBlob("Actor_img"));
	        m.setActress_id(rs.getInt("actress_id"));
	      //  m.setActress_img(rs.getBlob("Actress_img"));
	        m.setDirector_id(rs.getInt("director_id"));
	      
			return m;
		}
		
	});
	return list;
}
public Blob getDirectorimage(int id) {
	// TODO Auto
	String query="select director_image from director where director_id=?";

	Blob photo= template.queryForObject(query, new Object[]{id}, Blob.class);

	return photo;
	}	


public	 Movie getMovieId(int id) throws  IOException {
	
	String sql = "select * from movie,category,actor,actress,director,award where movie.award_id=award.award_id and movie.category_id=category.category_id and movie.actor_id=actor.actor_id and movie.actress_id=actress.actress_id and movie.director_id=director.director_id and movie.movie_id="+id+"";
	return template.queryForObject(sql, new RowMapper<Movie>() {
		public Movie mapRow(ResultSet rs, int row) throws SQLException {
			Movie m= new Movie();
			m.setMovie_id(rs.getInt("movie_id"));
	        m.setMovie_title(rs.getString("movie_title"));
	        m.setMovie_image(rs.getBlob("movie_image"));
	        m.setTrailer(rs.getString("trailer"));
	        m.setDescription(rs.getString("description"));
	        m.setCategory_id(rs.getInt("category_id"));

	        m.setCategory_name(rs.getString("category_name"));
	         m.setAward_id(rs.getInt("award_id"));
	         m.setAward_name(rs.getString("award_name"));
	        m.setActor_id(rs.getInt("actor_id"));
	        m.setActress_id(rs.getInt("actress_id"));
	        m.setDirector_id(rs.getInt("director_id"));
	        m.setActor_name(rs.getString("actor_name"));
	        m.setActress_name(rs.getString("actress_name"));
	        m.setDirector_name(rs.getString("director_name"));

	        m.setActor_image(rs.getBlob("actor_image"));
	        m.setActress_image(rs.getBlob("actress_image"));
	        m.setDirector_image(rs.getBlob("director_image"));
			return m;
		}
		
	});
}


public List<Rating> ReviewList(int id){
	String sql="select user.username,star_rating,comment_review,user_time,user_day from rating,user,movie  where rating.user_id = user.user_id and movie.movie_id=rating.movie_id and movie.movie_id='"+id+"' group by user.username having user.username<=1 order by star_rating desc";
	//String sql="select register.username,user_review,comment_review,user_time,user_day from review,movie,register where register.user_id=review.user_id and movie.movei_id=review.movei_id and movie.movei_id='"+id+"' order by user_review desc";
	List<Rating> list =template.query(sql ,new RowMapper<Rating>() {
		

		@Override
	public Rating mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Rating reg = new Rating();
		reg.setUsername(rs.getString("username"));
		reg.setStar_rating(rs.getInt("star_rating"));
		reg.setComment_review(rs.getString("comment_review"));
		reg.setUser_time(rs.getString("user_time"));
		reg.setUser_day(rs.getString("user_day"));
		
		return reg;
	}
	});
	return list;
}

public	Rating  ReviewCount(int id) throws  IOException {
	
	//String sql = "select sum(user_review)as user_review from review where review.movei_id='"+id+"'";
	String sql="SELECT ROUND(avg(star_rating), 2) as star_rating  FROM (SELECT star_rating  FROM rating JOIN user ON rating.user_id = user.user_id JOIN movie ON movie.movie_id = rating.movie_id WHERE movie.movie_id ='"+id+"' GROUP BY user.username) derived_table ";
	
	return template.queryForObject(sql, new RowMapper<Rating>() {
		public Rating mapRow(ResultSet rs, int row) throws SQLException {
			Rating reg = new Rating();
			reg.setStar_rating(rs.getInt("star_rating"));
		
		
			return reg;
		}
		
	});
}

public int giveReview(Rating p){
	
	LocalDateTime oki =LocalDateTime.now();
	DateTimeFormatter DateFormat =  DateTimeFormatter.ofPattern("MM/dd/yyyy");
	DateTimeFormatter DateFormat2 =  DateTimeFormatter.ofPattern("HH:mm");
	String date =oki.format(DateFormat);
	String time =oki.format(DateFormat2);

	//ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
	//HttpSession session = requestAttributes.getRequest().getSession();
	//String user_id =session.getAttribute("user_id").toString();
	//int plsgot =Integer.parseInt(user_id);
	//System.out.println("gottttttt"+ user_id);
	String sql="insert into rating(movie_id,user_id,star_rating,user_time,user_day,comment_review)values('"+p.getMovie_id()+"','"+p.getUser_id()+"','"+p.getStar_rating()+"','"+time+"','"+date+"','"+p.getComment_review()+"')";
	
	
	return template.update(sql);
	}


public Blob getMovieimage(int id) {
// TODO Auto
String query="select movie_image from movie where movie_id= ?";

Blob photo= template.queryForObject(query, new Object[]{id}, Blob.class);

return photo;
}	

public Blob getDirectoridimg(int id) {
	// TODO Auto
	String query="select director_image from director,movie where  director.director_id=movie.director_id and movie.movie_id=?";

	Blob photo= template.queryForObject(query, new Object[]{id}, Blob.class);

	return photo;
	}

public Blob getActoridimg(int id) {
	// TODO Auto
	String query="select actor_image from actor,movie where  actor.actor_id=movie.actor_id and movie.movie_id=?";

	Blob photo= template.queryForObject(query, new Object[]{id}, Blob.class);

	return photo;
	}	

public Blob getActressidimg(int id) {
	// TODO Auto
	String query="select actress_image from actress,movie where  actress.actress_id=movie.actress_id and movie.movie_id=?";

	Blob photo= template.queryForObject(query, new Object[]{id}, Blob.class);

	return photo;
	}	


//Oscarlist
public	List<Movie> OscarList() throws  IOException {
	List<Movie> list = template.query("select * from movie,award where movie.award_id=award.award_id and movie.Award_id='1'", new RowMapper<Movie>() {
		
		@Override
		public Movie mapRow(ResultSet rs, int row) throws SQLException {
			Movie m= new Movie();
			m.setMovie_id(rs.getInt("movie_id"));
	        m.setMovie_title(rs.getString("movie_title"));
	       // m.setMovie_image(rs.getBlob("movie_image"));
	        m.setTrailer(rs.getString("trailer"));
	        m.setDescription(rs.getString("description"));
	        m.setCategory_id(rs.getInt("Category_id"));
	        m.setAward_id(rs.getInt("award_id"));
	        m.setActor_id(rs.getInt("actor_id"));
	       // m.setActor_img(rs.getBlob("Actor_img"));
	        m.setActress_id(rs.getInt("actress_id"));
	      //  m.setActress_img(rs.getBlob("Actress_img"));
	        m.setDirector_id(rs.getInt("director_id"));
		    
	       // m.setDirector_img(rs.getBlob("Director_img"));
			return m;
		}
		
	});
	return list;
}


//Grammylsit
public	List<Movie> GrammyList() throws  IOException {
	List<Movie> list = template.query("select * from movie,award  where movie.award_id=award.award_id and movie.award_id='2'", new RowMapper<Movie>() {
		
		@Override
		public Movie mapRow(ResultSet rs, int row) throws SQLException {
			Movie m= new Movie();
			m.setMovie_id(rs.getInt("movie_id"));
	        m.setMovie_title(rs.getString("movie_title"));
	       // m.setMovie_image(rs.getBlob("movie_image"));
	        m.setTrailer(rs.getString("trailer"));
	        m.setDescription(rs.getString("description"));
	        m.setCategory_id(rs.getInt("category_id"));
	        m.setAward_id(rs.getInt("award_id"));
	        m.setActor_id(rs.getInt("actor_id"));
	       // m.setActor_img(rs.getBlob("Actor_img"));
	        m.setActress_id(rs.getInt("actress_id"));
	      //  m.setActress_img(rs.getBlob("Actress_img"));
	        m.setDirector_id(rs.getInt("director_id"));
	       // m.setDirector_img(rs.getBlob("Director_img"));
		    
			return m;
		}
		
	});
	return list;
}

}
