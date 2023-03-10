package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class movie_model {

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

	public double Price(String movie, int number)

	{
		double price = 0 ;
		String query = "select price from movie where movie_name= '" + movie + "'";

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				double price1 = rs.getDouble(1);
				double amt = price1 * number ;
				price = amt + amt * 0.18;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return price;

	}

}
