
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package cscorner;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 response.setContentType("text/html;charset=UTF-8");
 
 }
 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 processRequest(request, response);
 }
 
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 processRequest(request, response);
 try {
 PrintWriter out = response.getWriter();
 Class.forName("com.mysql.cj.jdbc.Driver");
 Connection 
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/neha","root","1234");
 String n=request.getParameter("txtName");
 String p=request.getParameter("txtPass");
 PreparedStatement ps=con.prepareStatement("Select uname from Login where uname=? and 
password=?");
 ps.setString(1,n);
 ps.setString(2,p);
 ResultSet rs = ps.executeQuery();
 if(rs.next()){
 RequestDispatcher rd= request.getRequestDispatcher("menu.jsp");
 rd.forward(request,response); 
 }else{
 out.println("<font color=red size=18>Login Failed!<br>");
 out.println("<a href=login.jsp>TRY AGAIN!!</a>"); 
 }
 
 HttpSession session=request.getSession();
 session.setAttribute("uname",request.getParameter("txtName"));
 } catch (ClassNotFoundException ex) {
 Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
 } catch (SQLException ex) {
 Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
 }
 
 }
}