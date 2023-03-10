package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class display extends HttpServlet {
	 Connection con ;
	 @Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Statement stmt = null;
		ResultSet rs = null;
		PrintWriter pw = resp.getWriter();
		
		String query ="select * from movie";
		
		try {
			stmt = con.createStatement();
			rs=stmt.executeQuery(query);
			pw.print("<table border='2'>");
			pw.print("<tr>");
			pw.print("<th> MOVIE ID </th>");
			pw.print("<th> MOVIE NAME </th>");
			pw.print("<th> MOVIE THEATRE</th>");
			pw.print("<th> TICKETS AVAILABLE</th>");
			pw.print("<th> TICKET PRICE</th>");
			pw.print("</tr>");
			
			while(rs.next())
			{
				int movie_id = rs.getInt(1);
				String movie_name = rs.getString(2);
				String movie_theatre = rs.getString(3);
				int no_of_tickets= rs.getInt(4);
				double ticket_fare = rs.getDouble(5);
				pw.print("<tr>");
				pw.print("<td> "+movie_id+"</td>");
				pw.print("<td> "+movie_name+"</td>");
				pw.print("<td> "+movie_theatre+"</td>");
				pw.print("<td> "+no_of_tickets+"</td>");
				pw.print("<td> "+ticket_fare+"</td>");
				pw.print("</tr>");
				
			}
			
			pw.print("</table");
			
		
			
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		pw.print("<table border='2'>");
		
		pw.print("<tr>");
		pw.print("<tr>");
		pw.print("<tr>");
		pw.print("<tr>");
		pw.print("<tr>");
		pw.print("<tr>");
		pw.print("<tr>");
		pw.print("<tr>");
		pw.print("<td> </td>");
		pw.print("<th> GO BACK TO HOME PAGE FOR TICKET BOOKING </th>");
		pw.print("</tr>");
		pw.print("</tr>");
		pw.print("</tr>");
		pw.print("</tr>");
		pw.print("</tr>");
		pw.print("</tr>");
		pw.print("</tr>");
		pw.print("</tr>");
		
		pw.print("</table");
		
		
		 
	}
	
	
}
