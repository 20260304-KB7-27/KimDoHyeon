package org.example.ex05;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        // request scope
        request.setAttribute("username", name);

        if (name != null && !name.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/helloView.jsp");
            rd.forward(request,response);
        } else {
            response.sendRedirect("http://localhost:8080/WEB-INF/view/hellowView.jsp");
        }


    }
}