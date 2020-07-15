package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.Blog;

 public interface BlogDaoInterface
{
	public void insertBlog(Blog blog) throws SQLException, ClassNotFoundException, IOException;
	
	public List selectAllBlogs() throws SQLException, ClassNotFoundException, IOException;
	
}