/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import interfaces.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;
import model.CartService;
import util.UserSessionUtil;

/**
 *
 * @author Wai Loc
 */
@WebServlet(urlPatterns = {"/salesReport"})
public class SalesReportController extends HttpServlet {
    @PersistenceContext EntityManager em;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService cartService = new CartService(em);
        List<Cart> tempCartList = cartService.findAll();
        List<Cart> cartList = new ArrayList<>();
        for (Cart cart : tempCartList){
            if(cart.getPaymentid() != null){
                cartList.add(cart);
            }
        }
        request.setAttribute("cartList", cartList);
        
        UserSessionUtil userSession = new UserSessionUtil(request.getSession());
        User user = userSession.getCurrentLoginUser(request.getCookies());
        if (user != null){
            if (user.getUsertype().equals(User.MANAGER)){ 
                RequestDispatcher dispatcher = request.getRequestDispatcher("/salesReport.jsp");
                dispatcher.forward(request, response);
            }
            else {
                request.setAttribute("errorTitle", "Forbidden Access");
                request.setAttribute("errorMessage", "You are logged in as " + user.getUsertype() + ", hence you do not have access to this page.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
        }
        else {
            request.setAttribute("errorTitle", "Forbidden Access");
            request.setAttribute("errorMessage", "You are not logged in, hence you do not have access to this page.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
