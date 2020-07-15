package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface {

	static List<Blog> blogList= new ArrayList<Blog>(); 
	@Override
	public void insertBlog(Blog blog) throws SQLException, ClassNotFoundException, IOException {
		
		String sql="INSERT INTO BLOG(blogId,blogTitle ,blogDescription,postedOn)VALUES(?,?,?,?)";
//		PreparedStatement st=null;
//		st = con.prepareStatement(sql);
		PreparedStatement st= ConnectionManager.getConnection().prepareStatement(sql);
		
		st.setLong(1, blog.getBlogId());
		st.setString(2,blog.getBlogTitle());
		st.setString(3,blog.getBlogDescription());
//		st.setDate(4, blog.getPostedOn());
		st.setDate(4, java.sql.Date.valueOf(blog.getPostedOn()));
		st.executeUpdate();	
		ConnectionManager.getConnection().close();
	}

	@Override
	public List<Blog> selectAllBlogs() throws SQLException, ClassNotFoundException, IOException {
		
        Blog blog = new Blog();
		PreparedStatement ps=ConnectionManager.getConnection().prepareStatement("SELECT * FROM BLOG");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			long blogId = rs.getLong(1);
			String blogTitle = rs.getString(2);
			String BlogDescription = rs.getString(3);
			LocalDate postedOn = rs.getDate(4).toLocalDate();
			System.out.println(blogId);
			System.out.println(blogTitle);
			System.out.println(BlogDescription);
			System.out.println(postedOn);
			
			blog.setBlogId(blogId);
			blog.setBlogTitle(blogTitle);
			blog.setBlogDescription(BlogDescription);
			blog.setPostedOn(postedOn);
			
			blogList.add(blog);
		}
		return blogList;

	}
	
}