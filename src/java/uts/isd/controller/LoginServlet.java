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

public class LoginServlet extends HttpServlet {
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {               
        //1- retrieve the current session
        HttpSession session = request.getSession();
        
        //2- create an instance of the Validator class    
        Validator validator = new Validator();
        //3- capture the posted email      
        String email = request.getParameter("email");
        //4- capture the posted password   
        String password = request.getParameter("password");
        if (!validator.validateEmail(email)) {
            //set the session attribute to email error
            request.setAttribute("loginError", "Incorrect email format");
            //Sending user back to login page
            request.getRequestDispatcher("login.jsp").include(request, response);
            return;
        }
        if (!validator.validatePassword(password)) {
            //set the session attribute to email error
            request.setAttribute("loginError", "Incorrect password format");
            //Sending user back to login page
            request.getRequestDispatcher("login.jsp").include(request, response);
            return;
        }
        
        if (email.equals("sys.admin@iotbay.com.au") && password.equals("admin")) {
            session.setAttribute("userType", "admin");
            session.setAttribute("requestType", "login");
            request.getRequestDispatcher("welcome.jsp").include(request, response);
            return;
        }
       if (!email.contains("@iotbay.com.au")) {
            //5- retrieve the manager instance from session      
            DBCustomerManager customerManager = (DBCustomerManager) session.getAttribute("customerManager");
            DBAccessLogManager accessLogManager = (DBAccessLogManager) session.getAttribute("accessLogManager");
            try {       
                //6- find user by email
                Customer customer = customerManager.findCustomerByEmail(email);
                // check if their account is active
                if (!customer.isIsActivated()) {
                    request.setAttribute("loginError", "Account is no longer active");
                    //Sending user back to login page
                    request.getRequestDispatcher("login.jsp").include(request, response);
                    return;
                }
                // validate password
                if (customer.getPassword().equals(password)) {
                    session.setAttribute("user", customer);
                    session.setAttribute("requestType", "login");
                    session.setAttribute("userType", "customer");
                    //add log to access logs for customer
                    accessLogManager.addAccessLog(customer.getCustomerID(), new Timestamp(System.currentTimeMillis()), "Login");
                    request.getRequestDispatcher("welcome.jsp").include(request, response);
                    return;
                } else {
                    request.setAttribute("loginError", "Incorrect password");
                    //Sending user back to login page
                    request.getRequestDispatcher("login.jsp").include(request, response);
                    return;
                }
            } catch (SQLException ex) {    
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("loginError", "Customer not found");
                //Sending user back to login page
                request.getRequestDispatcher("login.jsp").include(request, response);
                return;
            }
       } else {
           //5- retrieve the manager instance from session      
            DBStaffManager staffManager = (DBStaffManager) session.getAttribute("staffManager");
            DBAccessLogManager accessLogManager = (DBAccessLogManager) session.getAttribute("accessLogManager");
            try {       
            //6- find user by email
            Staff staff = staffManager.findStaff(email);
            // check if their account is active
                if (!staff.isIsActivated()) {
                    request.setAttribute("loginError", "Account is no longer active");
                    //Sending user back to login page
                    request.getRequestDispatcher("login.jsp").include(request, response);
                    return;
                }
            // validate password
            if (staff.getPassword().equals(password)) {
                session.setAttribute("user", staff);
                session.setAttribute("requestType", "login");
                session.setAttribute("userType", "staff");
                //add log to access logs for staff
                accessLogManager.addAccessLog(staff.getStaffID(), new Timestamp(System.currentTimeMillis()), "Login");
                request.getRequestDispatcher("welcome.jsp").include(request, response);
                return;
            } else {
                request.setAttribute("loginError", "Incorrect password");
                //Sending user back to login page
                request.getRequestDispatcher("login.jsp").include(request, response);
                return;
            }
        } catch (SQLException ex) {    
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("loginError", "Staff not found");
            //Sending user back to login page
            request.getRequestDispatcher("login.jsp").include(request, response);
            return;
        }
       }
    }
}
