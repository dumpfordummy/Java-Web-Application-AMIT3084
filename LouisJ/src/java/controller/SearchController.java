/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductService;

/**
 *
 * @author Pua
 */
public class SearchController extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductService productService = new ProductService(em);
        List<String> categories = productService.findAllCategory();
        double maxPrice = productService.findMaxPrice();
        request.setAttribute("categories", categories);
        String searchTerm = request.getParameter("searchTerm");
        searchTerm = searchTerm.trim().toUpperCase();
        List<Product> productList = productService.findByNamePattern(searchTerm);
        request.setAttribute("maxPrice", maxPrice);
        request.setAttribute("priceRangeInput", maxPrice);

        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product.jsp");
        dispatcher.forward(request, response);
    }
}
