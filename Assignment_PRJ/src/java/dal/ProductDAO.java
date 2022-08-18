/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author Long
 */
public class ProductDAO extends DBContext{
    
    PreparedStatement st;
    ResultSet rs;
    
    public ArrayList<Product> getListSP(){
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Product";
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                Product sp = new Product();
                sp.setPid(rs.getInt("pid"));
                sp.setPname(rs.getString("pname"));
                sp.setPprice(rs.getDouble("pprice"));
                list.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static void main(String[] args) {
        ProductDAO pd = new ProductDAO();
        ArrayList<Product> list = pd.getListSP();
        System.out.println(list.get(2).getPname());
    }
}
