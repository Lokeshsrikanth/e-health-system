
package cscorner;
import cscorner.LoginServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {
 
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
 String query="insert into Login(uname,password) values(?,?)";
 PreparedStatement ps=con.prepareStatement(query);
 ps.setString(1,request.getParameter("t5"));
 ps.setString(2,request.getParameter("t6"));
 int i=ps.executeUpdate();
 
 if(i>=1){
 out.println("<h1>Signup Successful");
 RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
 rd.forward(request,response);
 }else{
 out.println("<h1>Signup Unsuccessful");
 RequestDispatcher r=request.getRequestDispatcher("signup.jsp");
 r.forward(request,response);
 }
 } catch (ClassNotFoundException ex) {
 Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
 } catch (SQLException ex) {
 Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
 }
 
 }
}
