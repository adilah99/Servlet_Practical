import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class Login extends HttpServlet {

    boolean login=false;
    Connection con=null;
    Statement statement=null;
 
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String id=request.getParameter("id");  
	    String password=request.getParameter("password");  
	          
	    if(LoginValidate.checkUser(id,password)){  
	        RequestDispatcher rd=request.getRequestDispatcher("Welcome");  
	        rd.forward(request,response);  
	    }  
	    else{  
	        out.print("Id or Password incorrect");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request,response);  
	    }
	    out.close();
	}

}      