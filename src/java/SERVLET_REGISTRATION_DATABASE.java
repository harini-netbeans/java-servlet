/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SHANKKAR
 */
public class SERVLET_REGISTRATION_DATABASE extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String gender = request.getParameter("gender");
        String qualification = request.getParameter("qualification");
        String bday = request.getParameter("bday");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        
        try {
        
            // loading drivers for mysql
            
            Class.forName("com.mysql.jdbc.Driver");
            
            //creating connection with the database 
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/masterdb","root","");

            PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into MasterDB values(?,?,?,?,?,?,?,?)");

            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, gender);
            ps.setString(4, qualification);
            ps.setString(5, bday);
            ps.setString(6,mobile);
            ps.setString(7, email );
            ps.setString(8, pwd);
            int i = ps.executeUpdate();
            
            if(i > 0) {
               RequestDispatcher rs=request.getRequestDispatcher("HTML_HOME_PAGE.html");
               rs.forward(request,response);
                
            }
            else
            {
                RequestDispatcher rs=request.getRequestDispatcher("HTML_LOGIN_PAGE.html");
               rs.forward(request,response);
            }
        
        }
        catch(Exception se) {
            se.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
