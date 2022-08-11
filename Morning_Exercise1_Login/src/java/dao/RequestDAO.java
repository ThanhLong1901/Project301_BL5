/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.oracle.wls.shaded.org.apache.bcel.generic.LSTORE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Request;

/**
 *
 * @author Long
 */
public class RequestDAO extends DBContext {

    PreparedStatement st;
    ResultSet rs;

    public List<Request> getListRequestByUser(String username) {
        List<Request> list = new ArrayList<>();
        String sql = "select * from Request where createdBy = ?";

        try {
            st = connection.prepareStatement(sql);
            st.setString(1, username);
            rs = st.executeQuery();
            while (rs.next()) {
                Request r = new Request();
                r.setId(rs.getInt("rid"));
                r.setContent(rs.getString("content"));
                r.setFromDate(rs.getString("fromDate"));
                r.setToDate(rs.getString("toDate"));
                Account acc = new Account();
//                acc.setUsername(rs.getString("username"));
                acc.setUsername(rs.getString("createdBy"));

                r.setCreatedBy(acc);
                list.add(r);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        RequestDAO rd = new RequestDAO();
        List<Request> list = rd.getListRequestByUser("mra");
        System.out.println(list.get(1).getCreatedBy().getUsername());
    }
}
