/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoàng Sơn
 */
public class SettingContext extends DBContext.DBContext {

    public String getLogo() {
        String result = "";
        try {
            String sql = "SELECT [img]\n"
                    + "  FROM [dbo].[ImgSetting]\n"
                    + "  where [type]='logo'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                result = rs.getString("img");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettingContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList< String> getSilde(String slide) {
        ArrayList<String> listImg = new ArrayList<>();
        try {
            String sql = "SELECT img\n"
                    + "  FROM [dbo].[ImgSetting]\n"
                    + "  where [type]=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, slide);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listImg.add(rs.getString("img"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettingContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listImg;
    }

    public void deleteImg(String type, String img) {

        try {
            String sql = "DELETE FROM [dbo].[ImgSetting]\n"
                    + "      WHERE type=? and img=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, type);
            stm.setString(2, img);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SettingContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addImg(String type, String img) {

        try {
            String sql = "DELETE FROM [dbo].[ImgSetting]\n"
                    + "      WHERE type=? and img=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, type);
            stm.setString(2, img);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SettingContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }