/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Minh Hoàng
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginConTroller";
    private static final String SEARCH = "SearchConTroller";
    private static final String LOGOUT = "LogoutConTroller";
    private static final String DELETE_CONTROLLER = "DeleteConTroller";
    private static final String UPDATE_CONTROLLER = "UpdateConTroller";
    private static final String CREATE_CONTROLLER = "CreateConTroller";
    private static final String ADD_TO_CART = "AddToCardConTroller";
    private static final String VIEW_CART = "ViewCart.jsp";
    private static final String UPDATE_CART = "UpdateCardConTroller";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if ("Login".equals(action)){
                url = LOGIN;
            }else if("Search".equals(action)){
                url = SEARCH;
            }else if("Logout".equals(action)){
                url = LOGOUT;
            }else if("Delete".equals(action)){
                url = DELETE_CONTROLLER;
            }else if("Update".equals(action)){
                url = UPDATE_CONTROLLER;
            }else if("Create".equals(action)){
                url = CREATE_CONTROLLER;
            }else if("Add to cart".equals(action)){
                url = ADD_TO_CART;
            }else if("View cart".equals(action)){
                url = VIEW_CART;
            }else if("Update Cart".equals(action)){
                url = UPDATE_CART;
            }else{
                HttpSession session = request.getSession();
                session.setAttribute("ERROR_MESSAGE", "Function is not avaible!");
            }
        } catch (Exception e) {
            log("Error at MainController:" +e.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
