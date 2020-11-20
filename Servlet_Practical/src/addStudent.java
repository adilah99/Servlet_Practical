import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class addStudent extends HttpServlet {
 
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String id=request.getParameter("id");  
	    String password=request.getParameter("password");
	    String name=request.getParameter("name");
	    String department=request.getParameter("department");
	    String science=request.getParameter("science");
		String math=request.getParameter("math");
		String english=request.getParameter("english");
	    
	    try {
	    	//loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","1234");
            PreparedStatement stmt = con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
            stmt.setString(1,id);
			stmt.setString(2,password);
			stmt.setString(3,name);
			stmt.setString(4,department);
			stmt.setString(5,science);
			stmt.setString(6,math);
			stmt.setString(7,english);
			
           
        	int row=stmt.executeUpdate();
			if(row>0){
				RequestDispatcher rd=request.getRequestDispatcher("Welcome");  
		        rd.forward(request,response);
		        out.println("successfully add new student");
		        
			}else{
				out.println("Failed to add new student");
			}
		  
	    }catch(Exception e){
	    	out.println(e.getMessage());
	    }
	}
}