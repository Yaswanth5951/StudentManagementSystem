package com.um.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import com.um.model.User;

public class UserDao {
	private static String url="jdbc:mysql://localhost:3306/yash";
	private static String username="root";
	private static String password="yash";
	private static String insert="insert into student(Name,Email,City)value(?,?,?)";
	private static String delete="delete from student where id=?";
	private static String selectUserById="select * from student where id=?";
	private static Connection con = null;
	private static PreparedStatement ps=null;
	private static Statement s=null;
	private static String display="select * from student";
	
	public static  void insert(User u)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			ps=con.prepareStatement(insert);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3,u.getCity());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		//display details
		public static ArrayList<User> display()
		{
			ArrayList<User> a1=new ArrayList<User>();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url, username, password);
				s=con.createStatement();
				ResultSet rs=s.executeQuery(display);
				while(rs.next())
				{
					int id=rs.getInt("id");
					String name=rs.getString("name");
					String email=rs.getString("email");
					String city=rs.getString("city");
					User u=new User(id,name,email,city);
					a1.add(u);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try {
					s.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return a1;
			
			
		}
		//delete user
		public static void delete(int id)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url, username, password);
				ps=con.prepareStatement(delete);
				ps.setInt(1,id);
				ps.executeUpdate();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try {
					ps.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//select user id
		public static User selectUserById(int id) 
		{
			User u=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url, username, password);
				ps=con.prepareStatement("select * from student where id=?");
				ps.setInt(1,id);
			    ResultSet rs=ps.executeQuery();
			    rs.next();
			    int id1=rs.getInt("id");
			    String name=rs.getString("name");
			    String email=rs.getString("email");
			    String city=rs.getString("city");
			    u=new User(id1, name, email, city);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try {
					ps.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return u;
		}
		
}

