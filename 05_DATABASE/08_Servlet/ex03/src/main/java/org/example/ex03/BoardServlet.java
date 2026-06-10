package org.example.ex03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet("/board")
public class BoardServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
        //MIME 타입 설정
        resp.setContentType("text/html; charset=UTF-8");

		Enumeration<String> enu = req.getParameterNames();

        // 자바 I/O
        PrintWriter out = resp.getWriter();

		// html 작성
		out.println("<html><body>");
		out.println("");

		while(enu.hasMoreElements()){
			// parameter key 목록에서 1개만 꺼냄.
			String name = enu.nextElement();

			// request에서 name에 맞는 value 찾기
			String value = req.getParameter(name);

			out.print(name+" : "+value);
		}

        out.println("</body></html>");
    }

}
