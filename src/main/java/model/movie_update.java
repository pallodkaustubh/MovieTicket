package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class movie_update {

	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;

    
	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root", "sql123");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public boolean update  (int number , String movie)
	{
	
		
		boolean status = false ;
		
		String query = "select no_of_tickets from movie where movie_name = '"+movie+"' ";
		
		try {
			stmt = con.createStatement();
			rs =  stmt.executeQuery(query);
			
			
			while(rs.next())
			{
				int count = rs.getInt(1);
				
				int avail = count - number ;
				
				String query1 = "update movie set no_of_tickets = "+avail+" where movie_name= '" + movie+ "'" ;	
				stmt = con.createStatement();
				stmt.executeUpdate(query1);
				if(number<=count)
				{
					return status = true ; 
				}
				
				else 
				{
					return  status = false ;	
				}
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return status ;
	}
	
	
	
	
	

}
