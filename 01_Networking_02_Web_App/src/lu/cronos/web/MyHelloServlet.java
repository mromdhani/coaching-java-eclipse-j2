package lu.cronos.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloservlet")
public class MyHelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyHelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	  response.setContentType("text/html");
	  PrintWriter out = response.getWriter();
	  out.println("<h1> Hello from the Servlet </h1>");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	 doGet(request, response);
	}

}
