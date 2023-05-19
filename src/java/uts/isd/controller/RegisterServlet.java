package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.*;
import uts.isd.model.*;

/**
 * Author:  John
 * Created: 18 May 2023
 */

public class RegisterServlet extends HttpServlet {
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {               
        //1- retrieve the current session
        HttpSession session = request.getSession();        
        
        //2- create an instance of the Validator class
        Validator validator = new Validator();
        //Get fname
        String fName = request.getParameter("fname");
        //Get lname
        String lName = request.getParameter("lname");
        //3- capture the posted email      
        String email = request.getParameter("email");
        //Get phone
        String phoneNo = request.getParameter("phone");
        //4- capture the posted password  
        String password = request.getParameter("password");
        //Get TOS
        String tos = request.getParameter("tos");
        // validate user details
        if (!validator.validateName(fName)) {
            //set the session attribute to first name error
            request.setAttribute("registerError", "Please enter a first name (must contain only letters)");
            //Sending user back to register page
            request.getRequestDispatcher("register.jsp").include(request, response);
            return;
        }
        
        if (!validator.validateName(lName)) {
            //set the session attribute to last name error
            request.setAttribute("registerError", "Please enter a last name (must contain only letters)");
            //Sending user back to register page
            request.getRequestDispatcher("register.jsp").include(request, response);
            return;
        }
        
        if (!validator.validateEmail(email)) {
            //set the session attribute to email error
            request.setAttribute("registerError", "Incorrect email format");
            //Sending user back to register page
            request.getRequestDispatcher("register.jsp").include(request, response);
            return;
        }
        
        if (!validator.validatePhone(phoneNo)) {
            //set the session attribute to phone error
            request.setAttribute("registerError", "Enter a mobile phone number e.g. 0478418342");
            //Sending user back to register page
            request.getRequestDispatcher("register.jsp").include(request, response);
            return;
        }
        if (!validator.validatePassword(password)) {
            //set the session attribute to password error
            request.setAttribute("registerError", "Incorrect password format (must be longer than 4 characters)");
            //Sending user back to register page
            request.getRequestDispatcher("register.jsp").include(request, response);
            return;
        }
        
        //Test is they acceoted TOS
        if (tos == null) {
            //set the session attribute to tos error
            request.setAttribute("registerError", "You cannot proceed without accepting TOS");
             //Sending user back to register page
            request.getRequestDispatcher("register.jsp").include(request, response);
            return;
        }
        
        //5- retrieve the manager instance from session      
        DBCustomerManager customerManager = (DBCustomerManager) session.getAttribute("customerManager");
        DBAccessLogManager accessLogManager = (DBAccessLogManager) session.getAttribute("accessLogManager");
        // check customer isn't already in the database
        try {
            customerManager.findCustomerByEmail(email);
            //set the session attribute to account already exists error
            request.setAttribute("registerError", "Account already exists please login");
             //Sending user back to register page
            request.getRequestDispatcher("register.jsp").include(request, response);
            return;
        }   catch (SQLException ex) {    
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            // if customer isn't found proceed to next try block to add them
        }
        
        try {                
            //add new customer to database
            customerManager.addCustomer(email, fName, lName, phoneNo, password, true);
            //6- find user by email
            Customer customer = customerManager.findCustomerByEmail(email);
            // add customer to session
            session.setAttribute("user", customer);
            session.setAttribute("requestType", "register");
            session.setAttribute("userType", "customer");
            //add log to access logs for customer
            accessLogManager.addAccessLog(customer.getCustomerID(), new Timestamp(System.currentTimeMillis()), "Login");
            
            request.getRequestDispatcher("welcome.jsp").include(request, response);
            return;
        } catch (SQLException ex) {    
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("registerError", "Customer not found");
            //Sending user back to register page
            request.getRequestDispatcher("register.jsp").include(request, response);
            return;
        }
    }
}
