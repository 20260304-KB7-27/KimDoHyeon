package org.example.ex05;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/jstl")
public class ConditionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String scoreStr = req.getParameter("score");

		int score = 0;
		if(scoreStr != null && !scoreStr.trim().isEmpty()){
			score = Integer.parseInt(scoreStr);
		}

		req.setAttribute("score",score);

		RequestDispatcher rd = req.getRequestDispatcher("jstl/condition.jsp");
		rd.forward(req, resp);
    }

}
