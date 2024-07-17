/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllerr;

import Model.UserAccount;
import data.AuthorizationContext;
import data.ProductContext;
import data.SettingContext;
import entity.product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Hoàng Sơn
 */
public class HomePage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AuthorizationContext AuthorizationDB = new AuthorizationContext();

        UserAccount account = (UserAccount) request.getSession().getAttribute("CRRAccount");
        if (account != null) {
            if ("admin".equals(AuthorizationDB.getRole(account.getUse_ID()))) {
                response.sendRedirect("manageruseraccount");
            }
            if ("user".equals(AuthorizationDB.getRole(account.getUse_ID()))) {
                request.getRequestDispatcher("view/HomePage/homePage.jsp").forward(request, response);
            }
            if (AuthorizationDB.getRole(account.getUse_ID()).contains("nhan_vien")) {
                response.sendRedirect("HomeStaff");
            }
        }
        if (account == null) {
            request.getRequestDispatcher("view/HomePage/homePage.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
