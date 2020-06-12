import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

public class SERVLET_LOGIN_DATABASE extends HttpServlet
{
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
pw.println("<html>");
pw.println("<body background=\"\" />");
pw.println("<title>www.itjobsforu.com</title>");
String user=request.getParameter("email");
String password=request.getParameter("pwd");
try
{
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/masterdb","root","");
PreparedStatement ps=con.prepareStatement("select email,pwd from MasterDB where email=? and pwd=?");
ps.setString(1,user);
ps.setString(2,password);
ResultSet rs=ps.executeQuery();
if(rs.next())
{
pw.println("<font color=green>");
pw.println("UserName  available");
response.sendRedirect("http://localhost:17930/MiniProject/HTML_COURSE_SELECTION_PAGE.html");
pw.println("</font>");
}
else
{
pw.println("<font size=5> <center>");
pw.println("<center><img src=oops.png><center>");
pw.println("<br>"+"Wrong Email ID and Password entered!!!!"+"<br>"+"<br>");
pw.println("Please enter a valid Email ID and Password!!!!"+"<br>"+"<br>");
pw.println("Please click here to go back to the Login page..."+"<br><br>");
pw.println("<a href=\"http://localhost:17930/MiniProject/HTML_LOGIN_PAGE.html\"> <input type=\"image\" src=\"go back to login.jpg\" alt=\"Submit\" width=\"100\" height=\"148\">");
pw.println("</font></center>");
}
pw.println("</body></html>");
rs.close();
ps.close();
con.close();
}
catch (ClassNotFoundException e) 
{
e.printStackTrace();
}
catch (SQLException e)
{
e.printStackTrace();
}
catch (InstantiationException ex) 
{
Logger.getLogger(SERVLET_LOGIN_DATABASE.class.getName()).log(Level.SEVERE, null, ex);
}
catch (IllegalAccessException ex) 
{
Logger.getLogger(SERVLET_LOGIN_DATABASE.class.getName()).log(Level.SEVERE, null, ex);
}
}
}




