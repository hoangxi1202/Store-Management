/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sendmail.SendMail;
import sendmail.mailBody;
import shopping.Cart;
import shopping.Item;
import shopping.Oder;
import shopping.OderDetail;
import shopping.Product;
import user.OderDAO;
import user.UserDAO;
import user.UserDTO;

/**
 *
 * @author Minh Hoàng
 */
public class CheckoutController extends HttpServlet {

    private static final String ERROR = "cart.jsp";
    private static final String SUCCESS = "checkout.jsp";
    private static final String LOGIN = "loginjsp.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("CART");
        UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
        String url="";
        try {
        if (session.getAttribute("LOGIN_USER")==null){
            url = LOGIN;
        }else{
        long total = 0;
        url = ERROR;
        String mess = (String)session.getAttribute("MESSAGE");
        mess ="";
        
            if (cart != null) {
                for (Item i : cart.getCart().values()) {
                    UserDAO dao = new UserDAO();
                    Product p = dao.searchProductByID(i.getId());
                    // k đủ hàng 
                    if (i.getQuatity() > p.getQuantity()) {
                        mess += p.getProductName() + " chi con " + p.getQuantity() + " trong kho "
                                + "\n";
                    }
                }
                if (mess.equals("")) {
                    for (Item i : cart.getCart().values()) {
                        UserDAO dao = new UserDAO();
                        Product p = dao.searchProductByID(i.getId());
                        total += i.getQuatity() * i.getPrice();
                        // đủ hàng 
                        if (i.getQuatity() <= p.getQuantity()) {
                            int newQuantity = p.getQuantity() - i.getQuatity();
                            dao.updateQuantityProduct(i.getId(), newQuantity);
                        }                   
                        mess = "don hang cua ban da dc them!";
                        url=SUCCESS;
                    }
                    total = total * 11 / 10 ;
                    int oderID = (int) System.currentTimeMillis();
                    Oder oder = new Oder(oderID, loginUser.getUserID(), total, phone, address, 1, name);
                    OderDetail oderDetail = new OderDetail();
                    OderDAO daos = new OderDAO();
                    daos.insertOder(oder);
                    int detailID = (int)(oderID/10);
                    for (Item i : cart.getCart().values()){
                        detailID +=1;
                        oderDetail = new OderDetail(detailID, i.getId(), (long)i.getPrice(), i.getQuatity(), oderID);
                        daos.insertOderDetail(oderDetail);
                    }
                    SendMail sendMail = new SendMail();
                    String emailBody = mailBody.MAIL_BODY;
                    sendMail.send(email, oderID, emailBody);
                    session.setAttribute("CART", null);
                    session.setAttribute("ODERID", oderID);
                }else {                   
                    url=ERROR;
                }
                session.setAttribute("MESSAGE", mess);
            }}
        }catch (Exception e) {
            log("Error at CheckoutCOntroller" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
