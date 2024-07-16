/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoàng Sơn
 */
public class AuthorizationContext extends DBContext.DBContext {

    public String getRole(int id) {
        String result = null;
        try {
            String sql = "SELECT r.role_Name\n"
                    + "  FROM [dbo].[UserAccounts] ua\n"
                    + "  left join [dbo].[UserRole] ur\n"
                    + "  on ua.user_ID=ur.user_ID\n"
                    + "  left join [dbo].[Role] r\n"
                    + "  on r.role_ID=ur.role_ID\n"
                    + "  where ua.user_ID= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                result = rs.getString("role_Name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorizationContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
