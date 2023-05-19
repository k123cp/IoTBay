package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 - Retrieve the current session
        HttpSession session = request.getSession();
        // Get request parameters
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String category = request.getParameter("category");

        Validator validator = new Validator();
        // 2 - Checking if user entered valid field for the product, if not displaying an error message
        if (productName.length() ==0 || !validator.validateProductName(productName)) {
            request.setAttribute("productError", "Please enter a valid product name");
            // Redirect to page
            request.getRequestDispatcher("products.jsp").include(request, response);
            return;
        } else if (description.length() == 0 ||  !validator.validateDescription(description)) {
            request.setAttribute("productError", "Please enter a valid description");
            // Redirect to page
            request.getRequestDispatcher("products.jsp").include(request, response);
            return;
        } else if (price.length() ==0 ||  !validator.validatePrice(price)) {
            request.setAttribute("productError", "Please enter a valid price");
            // Redirect to page
            request.getRequestDispatcher("products.jsp").include(request, response);
            return;
        } else if (stock.length() ==0 ||  !validator.validateStock(stock)) {
            request.setAttribute("productError", "Please enter a valid stock");
            // Redirect to page
            request.getRequestDispatcher("products.jsp").include(request, response);
            return;
        } else if (category.length() ==0 ||  !validator.validateCategory(category)) {
            request.setAttribute("productError", "Please enter a valid category");
            // Redirect to page
            request.getRequestDispatcher("products.jsp").include(request, response);
            return;
        }

        // 3 - Retrieve the manager instance from session      
        DBProductManager productManager = (DBProductManager) session.getAttribute("productManager");
        try {
            double convertedPrice = Double.parseDouble(price);
            int convertedStock = Integer.parseInt(stock);
            productManager.addProduct(productName, description, convertedPrice, convertedStock, category, true);
            // Getting all products from database
            ArrayList<Product> product = productManager.findAllProduct();
            session.setAttribute("products", product);
            // set no product error to say no products available
            session.removeAttribute("noProductsError");
            //redirect to page
            request.getRequestDispatcher("products.jsp").include(request, response);
            return;
        } catch (SQLException ex) {
            Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("productError", ex.getMessage());
            // Redirect to page
            request.getRequestDispatcher("products.jsp").include(request, response);
            return;
        }
    }
}
