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
import model.DayOffType;
import model.Employee;

/**
 *
 * @author Long
 */
public class DayOffDAO extends DBContext {

    PreparedStatement st;
    ResultSet rs;

    public ArrayList<DayOffType> getListDOT() {
        ArrayList<DayOffType> list = new ArrayList<>();

        String sql = "select * from DayOffType";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                DayOffType dot = new DayOffType();
                dot.setDotid(rs.getInt("dotid"));
                dot.setDottitle(rs.getString("dottitle"));
                dot.setDotnotation(rs.getString("dotnotation"));
                list.add(dot);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DayOffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public ArrayList<Employee> getListDOTEmployee() {
        ArrayList<Employee> list = new ArrayList<>();
        String sql = "select e.eid, e.ename, ISNULL(do.doid, -1) as doid, do.fromdate, do.todate, dot.dottitle, dot.dotnotation "
                + "from Employee e left join (select * from DayOff where fromdate >= ? and todate <= ?) do "
                + "on e.eid = do.eid left join DayOffType dot on dot.dotid = do.dotid";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DayOffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        DayOffDAO dod = new DayOffDAO();
        ArrayList<DayOffType> list = dod.getListDOT();
        System.out.println(list.get(8).getDottitle());
        System.out.println(list.size());
    }
}
