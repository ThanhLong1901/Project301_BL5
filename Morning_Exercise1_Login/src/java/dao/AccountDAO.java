/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

//Lỗi khi sử dụng DBContext1
//DBContext và DBContext1 khác nhau ở "throws SQLException"   

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Long
 */
public class AccountDAO extends DBContext {

    PreparedStatement st;
    ResultSet rs;
    
    public Account getAccount(String username, String password) {
        String sql = "select * from Account where username = ? and password = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();
            if (rs.next()) {
                Account acc = new Account();
                acc.setUsername(username);
                return acc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    public Account getAccount(String username, String password) {
//        try {
//            String sql = "SELECT [username]\n"
//                    + "      ,[password]\n"
//                    + "      ,[qid]\n"
//                    + "      ,[answer]\n"
//                    + "  FROM [Account]\n"
//                    + "  WHERE [username] = ?\n"
//                    + "  AND [password] = ?";
//
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setString(1, username);
//            stm.setString(2, password);
//            ResultSet rs = stm.executeQuery();
//            if (rs.next()) {
//                Account account = new Account();
//                account.setUsername(username);
//                return account;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    
    public String getPassword(String username, int qid, String answer) {
        try {
            String sql = "select * from Account"
                    + "  where username = ?"
                    + "  and qid = ?"
                    + "  and answer = ?";
            st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setInt(2, qid);
            st.setString(3, answer);
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("password");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        AccountDAO ad = new AccountDAO();
        String password = ad.getPassword("mra", 1, "light blue");
        System.out.println(password);
    }
}
