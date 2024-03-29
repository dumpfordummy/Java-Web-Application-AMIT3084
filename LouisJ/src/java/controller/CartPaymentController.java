/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import interfaces.User;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import model.Cart;
import model.CartPK;
import model.CartService;
import model.Customer;
import model.CustomerService;
import model.Payment;
import model.PaymentService;
import model.Product;
import model.ProductService;
import model.Voucher;
import model.VoucherService;
import util.UserSessionUtil;

/**
 *
 * @author Asus
 */
public class CartPaymentController extends HttpServlet {
    
    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            UserSessionUtil userSession = new UserSessionUtil(session);
            User user = userSession.getCurrentLoginUser(request.getCookies());
            if (user == null || !user.getUsertype().equals(User.CUSTOMER)) {
                response.sendRedirect("/login");
                return;
            }
            user = (Customer) user;
            String customerid = user.getId();

            CartService cartService = new CartService(em);
            List<Cart> customerCartList = cartService.findByCustomerid(customerid);
            List<CartPK> cartPKList = new ArrayList<>();
            CustomerService customerService = new CustomerService(em);
            ProductService productService = new ProductService(em);
            Customer customer;
            Product product;
            for (Cart cart : customerCartList) {
                if (cart.getPaymentid() == null) {
                    customer = customerService.findCustomerById(cart.getCustomerid());
                    product = productService.findProductByProductid(cart.getProductid());
                    cartPKList.add(new CartPK(cart.getCartid(), customer, product, cart.getQty()));
                }
            }
            
            VoucherService voucherService = new VoucherService(em);
            List<Voucher> voucherAllList = voucherService.findAllVoucher();
            if(!voucherAllList.isEmpty()){
                List<Voucher> voucherList = new ArrayList<>();
                for(Voucher voucher : voucherAllList){
                    if(voucher.getVoucherExpiryDate().isAfter(LocalDate.now())){
                        voucherList.add(voucher);
                    }
                }
                request.setAttribute("voucherList", voucherList);
            } else {
                request.setAttribute("voucherList", null);
            }
            
            
            request.setAttribute("cartPKList", cartPKList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/cartPayment.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect(request.getContextPath() + "/product");
        }
    }
}
