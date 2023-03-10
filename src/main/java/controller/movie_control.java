package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.movie_model;
import model.movie_update;

@WebServlet("/one")
public class movie_control extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String movie = req.getParameter("movie");
		String number = req.getParameter("number");
		int num = Integer.parseInt(number);
      
		
		
		
		movie_model m1 = new movie_model();
		
		movie_update m2 = new movie_update();
		
		double bill = m1.Price(movie , num);
		
		boolean status = m2.update(num , movie);
		{
			if(status==true)
			{
				
			}
		}

		RequestDispatcher rd = req.getRequestDispatcher("view.jsp");
		req.setAttribute("movie", movie);
		req.setAttribute("bill", bill);
		req.setAttribute("number", number);
		req.setAttribute("status", status);

		rd.forward(req, resp);

	}

}
