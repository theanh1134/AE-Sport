/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllerr;

import data.SettingContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Hoàng Sơn
 */
public class Setting extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SettingContext settingDB = new SettingContext();

        String slide1 = req.getParameter("slide1");
        String slide2 = req.getParameter("slide2");

        if (slide1 != null) {
            settingDB.deleteImg("slide1", slide1);
        }

        if (slide2 != null) {
            settingDB.deleteImg("slide2", slide2);
        }
        resp.sendRedirect("Setting");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SettingContext settingDB = new SettingContext();
        String logo = settingDB.getLogo();
        req.setAttribute("logo", logo);
        ArrayList<String> slide1 = settingDB.getSilde("slide1");
        System.out.println(slide1);
        req.setAttribute("slide1", slide1);
        ArrayList<String> slide2 = settingDB.getSilde("slide2");
        req.setAttribute("slide2", slide2);
        ArrayList<String> slide3 = settingDB.getSilde("slide3");
        req.setAttribute("slide3", slide3);
        ArrayList<String> slide4 = settingDB.getSilde("slide4");
        req.setAttribute("slide4", slide4);

        req.getRequestDispatcher("view/HomePage/Setting.jsp").forward(req, resp);
    }

}
