import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class Welcome extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String title = "Student Information System";
        String welcome = "Hello ";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

		//for Student Portal title and welcome message
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<center><body bgcolor = \"#f0f0f0\">\n");
        
        boolean login=false;
        Connection con=null;
	    Statement statement=null;
	    
	    String id=request.getParameter("id");  
	    String password=request.getParameter("password");
	      
	    try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?useSSL=false","root","1234");
          PreparedStatement stmt=con.prepareStatement("select * from student where id=? and password=?");
          stmt.setString(1, id);
          stmt.setString(2, password);
          System.out.println(stmt);
          ResultSet rs=stmt.executeQuery();
          	if(rs.next()){
          		login=true;
          	}
        } catch(Exception e){
      	  out.println(e.getMessage());
        }
        if(login){
        	out.println("<h1 align = \"center\">" + title + "</h1>\n" + "<center><b>"
    				+ welcome + "</b>" + "<b>" + request.getParameter("id") + " ! </b>\n" + "</center>");
       
        	
        try{
        	statement=con.createStatement();
        	ResultSet rs=statement.executeQuery("select id, name, department,science,math,english from student");
        
        	
        	 out.println(docType +
   		    		"<table border=\"1\">\n" +
   		    		  "<tr>" +
   		  	  	        "<th>StudentID</th>" + 
   		  	  	        "<th>Name</th>" +
   		  	  	        "<th>Department</th>" +
   		  	  	        "<th>Science</th>" +
   		  	  	        "<th>Math</th>" +
   		  	        	"<th>English</th>" +
   		  	  	        "<th>Average Marks</th>" +
   		  	  	      "</tr>" 	);
        	 
        while(rs.next()){
        	
            int average=(rs.getInt("science") + rs.getInt("math") + rs.getInt("english"))/3;
            
            out.println(docType +
           		 "<tr>" + 
             	    "<td>" + rs.getString("id") +"</td>" +
             	    "<td>" + rs.getString("name") + "</td>" + 
             	    "<td>" + rs.getString("department") + "</td>" + 
             	    "<td>" + rs.getString("science") + "</td>" +
             	    "<td>" + rs.getString("math") + "</td>" +
             	    "<td>" + rs.getString("english") +"</td>" + 
             	    "<td>" + average + "</td>" +
             	    "</tr>"  
             	    );
        }
		  
 		 out.println(docType +
 				"</table>" +
 	             "<form action=\"addStudent.jsp\">" +
 	             "<input type=\"submit\" value=\"Add New Student\">" +
 	             "</form>" 
       		 );
   	  
     }
        catch(Exception e) {
  	    	out.println(e.getMessage());
  	    }
      
   }
      else {
    	  System.out.println("login failed!!");
      }
} 

    
      }  
