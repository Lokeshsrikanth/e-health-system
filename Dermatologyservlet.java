
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package cscorner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
*
* @author Neha Grandhe
*/
@WebServlet(name = "DermatologyServlet", urlPatterns = {"/DermatologyServlet"})
public class DermatologyServlet extends HttpServlet {
 
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
 response.setContentType("text/html");
 response.setContentType("text/html");
 try (PrintWriter pw = response.getWriter()) {
 String fname = request.getParameter("firstname");
 String lname = request.getParameter("lastname");
 String age = request.getParameter("age");
 String email = request.getParameter("email");
 String contact = request.getParameter("contact");
 String gender = request.getParameter("gender");
 
 String time = request.getParameter("time");
 String doa = request.getParameter("dob");
 String problem = request.getParameter("problem");
 String doctor = request.getParameter("type");
 
 pw.println("<html><head><title></title></head><body>");
 pw.println("<h1>Registered Appointment </h1>");
 pw.println("<h2>Personal Details:</h2>");
 pw.println("<p>Name: " + fname + " " + lname + "</p>");
 pw.println("<p>Age: " + age+ "</p>");
 pw.println("<p>Gender: " + gender + "</p>");
 pw.println("<p>Email: " + email + "</p>");
 pw.println("<p>Contact: " + contact + "</p>");
 
 pw.println("<h2>Appointment Details:</h2>");
 pw.println("<p>Date of Appointment: " + doa + "</p>");
 pw.println("<p>Time: " + time + "</p>");
 pw.println("<p>Doctor Name: " + doctor + "</p>");
 pw.println("<p>Problem: " + problem + "</p>");
 
 pw.println("</body></html>");
 }
}
}
