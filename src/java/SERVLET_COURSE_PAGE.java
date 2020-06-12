import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

public class SERVLET_COURSE_PAGE extends HttpServlet
{
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
response.setContentType("text/html");
PrintWriter pw = response.getWriter();
pw.println("<html>");
pw.println("<body background=\"\" />");
pw.println("<title>www.itjobsforu.com</title>");
String qualification=request.getParameter("qualification");
String stream=request.getParameter("stream");
if(qualification.equals("postgraduate"))
{
if( stream.equals("engineering"))
{
 response.sendRedirect("http://localhost:17930/MiniProject/html_pgcs_eng.html");
}
else
{
response.sendRedirect("");
}
}
else
{
if( stream.equals("engineering"))
{
response.sendRedirect("");
}

else
{
response.sendRedirect("");
}
}
}
}



