/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package admin;

import DBContext.AdminDAO;
import Model.Feature;
import Model.Role;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class UpdateRole extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateRole</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateRole at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        AdminDAO dao = new AdminDAO();
        try {
            int rID = Integer.parseInt(request.getParameter("rID"));
            ArrayList<Feature> list = dao.getAllFeature();
            ArrayList<Feature> roleFeatures = dao.getAllFeatureOfRole(rID);
            String nameRole = dao.getRoleNameByID(rID);
            request.setAttribute("list", list);
            request.setAttribute("roleFeatures", roleFeatures);
            request.setAttribute("nameRole", nameRole);
            request.getRequestDispatcher("admin/UpdateRole.jsp").forward(request, response);

        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/managerrole");
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
        try {
        String roleName = request.getParameter("nameRole");
        String[] selectedFeatures = request.getParameterValues("features");
        AdminDAO dao = new AdminDAO();
        Role role = dao.getRoleByName(roleName);  
        dao.deleteRoleFeatureByID(role.getRoleID());
        if(selectedFeatures !=null){
            
             for (int i = 0; i < selectedFeatures.length; i++) {
                int feID = Integer.parseInt(selectedFeatures[i]);
                 
                dao.insertRoleFeature(feID, role.getRoleID());
            }
           
        }
        response.sendRedirect(request.getContextPath() + "/managerrole");
        } catch (Exception e) {
            System.out.println(e);
        }
        
                
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
