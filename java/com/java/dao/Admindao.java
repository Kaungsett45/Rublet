package com.java.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

import com.java.beans.Actor;
import com.java.beans.Actress;
import com.java.beans.Admin;
import com.java.beans.Director;
import com.java.beans.Movie;
import com.java.beans.User;

public class Admindao {

	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
	this.template = template;
	}
	
	//adminvalidation
	public  int adminvalidation(Admin p) {
		String sql="select count(*)from admin where admin_username= '"+p.getAdmin_username()+"' and admin_password='"+p.getAdmin_password()+"'";
		return template.queryForObject(sql,Integer.class);
	}
	//upload movie
		public void moviesave(MultipartFile image,Movie p)throws DataAccessException,IOException{
			
			byte[] photoBytes = image.getBytes();
			
			String sql ="insert into movie(movie_title,movie_image,trailer,description,category_id,award_id,actor_id,actress_id,director_id)  values('"+p.getMovie_title()+"',?,'"+p.getTrailer()+"','"+p.getDescription()+"','"+p.getCategory_id()+"','"+p.getAward_id()+"','"+p.getActor_id()+"','"+p.getActress_id()+"','"+p.getDirector_id()+"')";
			template.update(sql ,new Object[] {photoBytes});
		}
	
		
		
		
		
		//insert actor
		public void insertactor(MultipartFile actimg,Actor ac)throws DataAccessException,IOException{
				byte[] actorbytes = actimg.getBytes();
		
				String sql="insert into actor(actor_image,actor_name,about,birth) values (?,'"+ac.getActor_name()+"','"+ac.getAbout()+"','"+ac.getBirth()+"')";
				template.update(sql ,new Object[] {actorbytes});
		}
		
		//insert actress
		public void insertactress(MultipartFile actimg,Actress ac)throws DataAccessException,IOException{
				byte[] actorbytes = actimg.getBytes();
		
				String sql="insert into actress(actress_image,actress_name,about,birth) values (?,'"+ac.getActress_name()+"','"+ac.getAbout()+"','"+ac.getBirth()+"')";
				template.update(sql ,new Object[] {actorbytes});
		}
		
		//insert director
		public void insertdirector(MultipartFile actimg,Director ac)throws DataAccessException,IOException{
				byte[] actorbytes = actimg.getBytes();
		
				String sql="insert into director(director_image,director_name,about,birth) values (?,'"+ac.getDirector_name()+"','"+ac.getAbout()+"','"+ac.getBirth()+"')";
				template.update(sql ,new Object[] {actorbytes});
		}
		
		//insert movie
		public void insertmovie(MultipartFile actimg,Movie ac)throws DataAccessException,IOException{
				byte[] actorbytes = actimg.getBytes();
				System.out.println("Category_id "+ac.getCategory_id());
				String sql="insert into movie(movie_title,description,trailer,movie_image,category_id,award_id,actor_id,actress_id,director_id) values ('"+ac.getMovie_title()+"','"+ac.getDescription()+"','"+ac.getTrailer()+"',?,'"+ac.getCategory_id()+"','"+ac.getAward_id()+"','"+ac.getActor_id()+"','"+ac.getActress_id()+"','"+ac.getDirector_id()+"',)";
				template.update(sql ,new Object[] {actorbytes});
		}
		
		
		//actorlist
		public List<Actor> actorlist() {
			
			String sql ="select * from actor";
			List<Actor> movies= template.query(sql, new RowMapper<Actor>() {
				
				
				public Actor mapRow(ResultSet rs,int row)throws SQLException{
					Actor m=new Actor();
				m.setActor_id(rs.getInt("actor_id"));
				m.setActor_name(rs.getString("actor_name"));
				m.setActor_image(rs.getBlob("actor_image"));
				m.setAbout(rs.getString("about"));
				m.setBirth(rs.getString("birth"));
					return m;
				}
				
			
			
			});
			return movies;
	}
		
	public List<Actress> actresslist() {
			
			String sql ="select * from actress";
			List<Actress> movies= template.query(sql, new RowMapper<Actress>() {
				
				
				public Actress mapRow(ResultSet rs,int row)throws SQLException{
					Actress m=new Actress();
				m.setActress_id(rs.getInt("actress_id"));
				m.setActress_name(rs.getString("actress_name"));
				m.setActress_image(rs.getBlob("actress_image"));
				m.setAbout(rs.getString("about"));
				m.setBirth(rs.getString("birth"));
					return m;
				}
				
			
			
			});
			return movies;
	}

	public List<Director> directorlist() {
		
		String sql ="select * from director";
		List<Director> movies= template.query(sql, new RowMapper<Director>() {
			
			
			public Director mapRow(ResultSet rs,int row)throws SQLException{
				Director m=new Director();
			m.setDirector_id(rs.getInt("director_id"));
			m.setDirector_name(rs.getString("director_name"));
			m.setDirector_image(rs.getBlob("director_image"));
			m.setAbout(rs.getString("about"));
			m.setBirth(rs.getString("birth"));
				return m;
			}
			
		
		
		});
		return movies;
}

	public List<Movie> Listingmovie()  {
		
		List<Movie> list = template.query("select movie_id,movie_title,actor_name,actress_name,director_name,category_name from movie,actor,actress,director,category where movie.actor_id=actor.actor_id and movie.category_id=category.category_id and movie.actress_id=actress.actress_id and movie.director_id=director.director_id", new RowMapper<Movie>() {
			
		@Override
		public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
			Movie m = new Movie();
			Actor a = new Actor();
			Actress as = new Actress();
			Director d = new Director();
			m.setMovie_id(rs.getInt("movie_id"));
	        m.setMovie_title(rs.getString("movie_title"));
	        m.setActor_name(rs.getString("actor_name"));
	        m.setActress_name(rs.getString("actress_name"));
	        m.setDirector_name(rs.getString("director_name"));
	        m.setCategory_name(rs.getString("category_name"));
	       
	        
			return m;
		}
	});

	return list;
}
	public int ttmovie() {
		//String sql = "UPDATE movie SET view_count = view_count+1  WHERE movei_id = '"+movie_id+"'";
		String sql="select count(movie_title)from movie;"; 
		return template.queryForObject(sql,Integer.class);
	}
	
	//delete movie
	public int delete(int movie_id) {
		String sql="delete from movie where movie_id= "+movie_id+"";
		return template.update(sql);
	}
	

public	 Movie getMovieId(int id) throws  IOException {
	
	String sql = "select * from movie where movie_id="+id+"";
	return template.queryForObject(sql, new RowMapper<Movie>() {
		public Movie mapRow(ResultSet rs, int row) throws SQLException {
			Movie m= new Movie();
			m.setMovie_id(rs.getInt("movie_id"));
	        m.setMovie_title(rs.getString("movie_title"));
	        m.setMovie_image(rs.getBlob("movie_image"));
	        m.setTrailer(rs.getString("trailer"));
	        m.setDescription(rs.getString("description"));
	        m.setCategory_id(rs.getInt("category_id"));
	        m.setAward_id(rs.getInt("award_id"));
	        m.setActress_id(rs.getInt("actor_id"));
	        m.setActress_id(rs.getInt("actress_id"));
	        m.setDirector_id(rs.getInt("director_id"));
	        return m;
		}
		
	});
}
public int edit(MultipartFile image,Movie m) throws DataAccessException,IOException {


	byte[] photoBytes = image.getBytes();
	System.out.println(m.getMovie_image()+"Is the image working");
	String sql="update movie  set movie_title='"+m.getMovie_title()+"',movie_image=?,trailer='"+m.getTrailer()+"',description='"+m.getDescription()+"',category_id='"+m.getCategory_id()+"',Award_id ='"+m.getAward_id()+"',Actor_id='"+m.getActor_id()+"',Actress_id='"+m.getActress_id()+"',Director_id='"+m.getDirector_id()+"' where movie_id= '"+m.getMovie_id()+"'";
	return template.update(sql,new Object[] {photoBytes});
}




public int regaccount() {
	//String sql = "UPDATE movie SET view_count = view_count+1  WHERE movei_id = '"+movie_id+"'";
	String sql="select count(username)from user;"; 
	return template.queryForObject(sql,Integer.class);
}


public List<User> UserList(){
		List<User> list =template.query("select * from user" ,new RowMapper<User>() {
			
	

		@Override
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			
			
			User reg = new User();
			reg.setUser(rs.getInt("user_id"));
			reg.setUsername(rs.getString("username"));
			reg.setEmail(rs.getString("email"));
			reg.setAddress(rs.getString("address"));
						return reg;
		}
		});
		return list;
}


public List<User> Searchuser(String username) {
	
	String sql ="select movie_title,username,email,address,star_rating from movie,user,rating where movie.movie_id=rating.movie_id and user.user_id=rating.user_id and username='"+username+"' group by movie_title";
	List<User> movies= template.query(sql, new RowMapper<User>() {
		
		
		public User mapRow(ResultSet rs,int row)throws SQLException{
			User m=new User();
			m.setMovie_title(rs.getString("movie_title"));
			m.setUsername(rs.getString("username"));
			m.setEmail(rs.getString("email"));
			m.setAddress(rs.getString("address"));
			m.setStar_rating(rs.getInt("star_rating"));
		
			return m;
		}
		
	
	
	});
	return movies;
}

public List<Actor> ActorList() {
	
	String sql ="select * from actor";
	List<Actor> movies= template.query(sql, new RowMapper<Actor>() {
		
		
		public Actor mapRow(ResultSet rs,int row)throws SQLException{
			Actor  m=new Actor();
			m.setActor_id(rs.getInt("actor_id"));
			m.setActor_name(rs.getString("actor_name"));
			m.setActor_image(rs.getBlob("actor_image"));
			m.setBirth(rs.getString("birth"));
			m.setAbout(rs.getString("about"));
		
			return m;
		}
		
	
	
	});
	return movies;
}

public int Actorcount() {
	//String sql = "UPDATE movie SET view_count = view_count+1  WHERE movei_id = '"+movie_id+"'";
	String sql="select count(*)from actor"; 
	return template.queryForObject(sql,Integer.class);
}


public int actoredit(MultipartFile image,Actor m) throws DataAccessException,IOException {


	byte[] photoBytes = image.getBytes();
	System.out.println(m.getActor_id()+"Is the image working");
	String sql="update actor  set actor_name='"+m.getActor_name()+"',actor_image=?,birth='"+m.getBirth()+"',about='"+m.getAbout()+"'where actor_id='"+m.getActor_id()+"'";
	return template.update(sql,new Object[] {photoBytes});
}


public	 Actor getActorid(int actor_id) throws  IOException {
	
	String sql = "select * from actor where actor_id="+actor_id+"";
	return template.queryForObject(sql, new RowMapper<Actor>() {
		public Actor mapRow(ResultSet rs, int row) throws SQLException {
			Actor m= new Actor();
			m.setActor_id(rs.getInt("actor_id"));
	        m.setActor_name(rs.getString("actor_name"));
	        m.setActor_image(rs.getBlob("actor_image"));
	        m.setBirth(rs.getString("birth"));
	        m.setAbout(rs.getString("about"));
	        return m;
		}
		
	});
}

public List<Actress> ActressList() {
	
	String sql ="select * from actress";
	List<Actress> movies= template.query(sql, new RowMapper<Actress>() {
		
		
		public Actress mapRow(ResultSet rs,int row)throws SQLException{
			Actress  m=new Actress();
			m.setActress_id(rs.getInt("actress_id"));
			m.setActress_name(rs.getString("actress_name"));
			m.setActress_image(rs.getBlob("actress_image"));
			m.setBirth(rs.getString("birth"));
			m.setAbout(rs.getString("about"));
		
			return m;
		}
		
	
	
	});
	return movies;
}

public int Actresscount() {
	//String sql = "UPDATE movie SET view_count = view_count+1  WHERE movei_id = '"+movie_id+"'";
	String sql="select count(*)from actress"; 
	return template.queryForObject(sql,Integer.class);
}

public int actressedit(MultipartFile image,Actress m) throws DataAccessException,IOException {


	byte[] photoBytes = image.getBytes();
	System.out.println(m.getActress_id()+"Is the image working");
	String sql="update actress set actress_name='"+m.getActress_name()+"',actress_image=?,birth='"+m.getBirth()+"',about='"+m.getAbout()+"'where actress_id='"+m.getActress_id()+"'";
	return template.update(sql,new Object[] {photoBytes});
}




public List<Director> DirectorList() {
	
	String sql ="select * from director";
	List<Director> movies= template.query(sql, new RowMapper<Director>() {
		
		
		public Director mapRow(ResultSet rs,int row)throws SQLException{
			Director  m=new Director();
			m.setDirector_id(rs.getInt("director_id"));
			m.setDirector_name(rs.getString("director_name"));
			m.setDirector_image(rs.getBlob("director_image"));
			m.setBirth(rs.getString("birth"));
			m.setAbout(rs.getString("about"));
		
			return m;
		}
		
	
	
	});
	return movies;
}

public int Directorcount() {
	//String sql = "UPDATE movie SET view_count = view_count+1  WHERE movei_id = '"+movie_id+"'";
	String sql="select count(*)from director"; 
	return template.queryForObject(sql,Integer.class);
}


public int directoredit(MultipartFile image,Director m) throws DataAccessException,IOException {


	byte[] photoBytes = image.getBytes();
	System.out.println(m.getDirector_id()+"Is the image working");
	String sql="update director set director_name='"+m.getDirector_name()+"',director_image=?,birth='"+m.getBirth()+"',about='"+m.getAbout()+"'where director_id='"+m.getDirector_id()+"'";
	return template.update(sql,new Object[] {photoBytes});
}

}
