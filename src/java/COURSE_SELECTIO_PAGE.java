import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
public class COURSE_SELECTIO_PAGE extends HttpServlet
{

    //private String qualification;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
String qualification,stream;
    response.setContentType("text/html");
PrintWriter pw = response.getWriter();
pw.println("<html>");
pw.println("<body background=\"\" />");
pw.println("<title>www.itjobsforu.com</title>");
pw.println("<center> <caption> <h1> <b> SELECTION FORM");
pw.println("</b></h1></caption></center>");

pw.println("QUALIFICATION:");
pw.println("<select name=qualification>");
pw.println("<option value=postgraduate>" +"Post Graduate" +"<option value=undergraduate>" +"Under Graduate" +"</option></select><br><br>");
//qualification=request.getParameter(qualification);
pw.println("STREAM:");
pw.println("<select name=stream>");
pw.println("<option value=engineering>" +"Engineering" +"<option value=artsandscience>" +"Arts And Science" +"</option></select><br><br>");
qualification=request.getParameter("qualification");
pw.println(qualification);
pw.println("Course:");
pw.println("<select name=course>");
pw.println("<option value=engineering>" +"Engineering" +"<option value=artsandscience>" +"Arts And Science" +"</option></select><br><br>");

}}
