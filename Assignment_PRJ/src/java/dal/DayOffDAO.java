/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import helper.DateTimeHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DayOff;
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

    public ArrayList<Employee> getListDOTEmployee(Date from, Date end) {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            String sql = "select e.eid, e.ename, ISNULL(do.doid, -1) as doid, do.fromdate, do.todate, dot.dotid, dot.dottitle, dot.dotnotation"
                    + " from Employee e left join (select * from DayOff where fromdate >= ? and todate <= ?) do"
                    + " on e.eid = do.eid left join DayOffType dot on dot.dotid = do.dotid";
            st = connection.prepareStatement(sql);
            st.setTimestamp(1, DateTimeHelper.getTimeStamp(from));
            st.setTimestamp(2, DateTimeHelper.getTimeStamp(end));
            rs = st.executeQuery();
            Employee currentE = new Employee();
            currentE.setEid(-1);
            while (rs.next()) {
                int eid = rs.getInt("eid");
                if (eid != currentE.getEid()) {
                    currentE = new Employee();
                    currentE.setEid(eid);
                    currentE.setEname(rs.getString("ename"));
                    list.add(currentE);
                }
                int doid = rs.getInt("doid");
                if (doid != -1) {
                    DayOffType dot = new DayOffType();
                    dot.setDotid(rs.getInt("dotid"));
                    dot.setDottitle(rs.getString("dottitle"));
                    dot.setDotnotation(rs.getString("dotnotation"));

                    DayOff dof = new DayOff();
                    dof.setDoid(doid);
                    dof.setFromdate(rs.getTimestamp("fromdate"));
                    dof.setTodate(rs.getTimestamp("todate"));
                    dof.setDot(dot);
                    dof.setE(currentE);
                    currentE.getDayoff().add(dof);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DayOffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        DayOffDAO nvd = new DayOffDAO();
        Date today = new Date();
        today = DateTimeHelper.removeTime(today);
        int dayOfMonth = DateTimeHelper.getDayOfMonth(today);
        Date begin = DateTimeHelper.addDays(today, (dayOfMonth - 1) * -1);  //Lấy ngày đầu tiên trong tháng hiện tại
        Date end = DateTimeHelper.addDays(DateTimeHelper.addMonths(begin, 1), -1);   //Lấy ngày cuối cùng trong tháng hiện tại

        ArrayList<Employee> list = nvd.getListDOTEmployee(begin, end);

    }
}
