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
import model.Employee;
import model.Product;
import model.TimeSheet;
import model.ViewDate;

/**
 *
 * @author Long
 */
public class EmployeeDAO extends DBContext {

    PreparedStatement st;
    ResultSet rs;
//
//    public ArrayList<Employee> getListNV(Date from, Date end) {
//        ArrayList<Employee> list = new ArrayList<>();
//        try {
//            String sql = "select e.eid, e.ename, ISNULL(ts.tsid, -1) as tsid, ts.eid, ts.pid, ts.amount, ts.dates from Employee e left join\n"
//                    + "                     (select * from TimeSheet where dates >= ? and dates <= ?) ts on e.eid = ts.eid";
//            st = connection.prepareStatement(sql);
//            st.setTimestamp(1, DateTimeHelper.getTimeStamp(from));
//            st.setTimestamp(2, DateTimeHelper.getTimeStamp(end));
//            rs = st.executeQuery();
//            Employee currentE = new Employee();
//            currentE.setEid(-1);
//            while (rs.next()) {
//                int nvid = rs.getInt("eid");
//                if (nvid != currentE.getEid()) {
//                    currentE = new Employee();
//                    currentE.setEid(nvid);
//                    currentE.setEname(rs.getString("ename"));
//                    list.add(currentE);
//                }
//                int tsid = rs.getInt("tsid");
//                if (tsid != -1) {
//                    TimeSheet ts = new TimeSheet();
//                    ts.setTsid(tsid);
//                    ts.setDates(rs.getTimestamp("dates"));
//                    ts.setAmount(rs.getInt("amount"));
//                    ts.setE(currentE);
//                    currentE.getTimesheets().add(ts);
//
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
//
//    public ArrayList<Employee> getListNV1(Date from, Date end, int spid) {
//        ArrayList<Employee> list = new ArrayList<>();
//        try {
//            String sql = "select e.eid, e.ename, ISNULL(ts.tsid, -1) as tsid, ts.eid, ts.pid, ts.amount, ts.dates from Employee e left join\n"
//                    + "                     (select * from TimeSheet where dates >= ? and dates <= ? and pid = ?) ts on e.eid = ts.eid\n"
//                    + "					 left join Product p on ts.pid = p.pid";
//            st = connection.prepareStatement(sql);
//            st.setTimestamp(1, DateTimeHelper.getTimeStamp(from));
//            st.setTimestamp(2, DateTimeHelper.getTimeStamp(end));
//            st.setInt(3, spid);
//            rs = st.executeQuery();
//            Employee currentE = new Employee();
//            currentE.setEid(-1);
//            while (rs.next()) {
//                int nvid = rs.getInt("eid");
//                if (nvid != currentE.getEid()) {
//                    currentE = new Employee();
//                    currentE.setEid(nvid);
//                    currentE.setEname(rs.getString("ename"));
//                    list.add(currentE);
//                }
//
//                int tsid = rs.getInt("tsid");
//                if (tsid != -1) {
//                    Product sp = new Product();
//                    sp.setPid(rs.getInt("pid"));
//                    sp.setPname(rs.getString("pname"));
//                    sp.setPprice(rs.getDouble("pprice"));
//
//                    TimeSheet ts = new TimeSheet();
//                    ts.setTsid(tsid);
//                    ts.setDates(rs.getTimestamp("dates"));
//                    ts.setAmount(rs.getInt("amount"));
//                    ts.setP(sp);
//                    ts.setE(currentE);
//                    currentE.getTimesheets().add(ts);
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }

    public ArrayList<Employee> getListNV2(Date from, Date end) {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            String sql = "select e.eid, e.ename, ISNULL(ts.tsid, -1) as tsid, p.pname, p.pprice, ts.eid, ts.pid, ts.amount, ts.dates from Employee e left join\n"
                    + "                     (select * from TimeSheet where dates >= ? and dates <= ?) ts on e.eid = ts.eid\n"
                    + "					 left join Product p on ts.pid = p.pid";
            st = connection.prepareStatement(sql);
            st.setTimestamp(1, DateTimeHelper.getTimeStamp(from));
            st.setTimestamp(2, DateTimeHelper.getTimeStamp(end));
            rs = st.executeQuery();
            Employee currentE = new Employee();
            currentE.setEid(-1);
            while (rs.next()) {
                int nvid = rs.getInt("eid");
                if (nvid != currentE.getEid()) {
                    currentE = new Employee();
                    currentE.setEid(nvid);
                    currentE.setEname(rs.getString("ename"));
                    list.add(currentE);
                }

                int tsid = rs.getInt("tsid");
                if (tsid != -1) {
                    Product sp = new Product();
                    sp.setPid(rs.getInt("pid"));
//                    sp.setSpid(spid);
                    sp.setPname(rs.getString("pname"));
                    sp.setPprice(rs.getDouble("pprice"));

                    TimeSheet ts = new TimeSheet();
                    ts.setTsid(tsid);
                    ts.setDates(rs.getTimestamp("dates"));
                    ts.setAmount(rs.getInt("amount"));
                    ts.setP(sp);
                    ts.setE(currentE);
                    currentE.getTimesheets().add(ts);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        EmployeeDAO nvd = new EmployeeDAO();
        Date today = new Date();
        today = DateTimeHelper.removeTime(today);
        int dayOfMonth = DateTimeHelper.getDayOfMonth(today);
        Date begin = DateTimeHelper.addDays(today, (dayOfMonth - 1) * -1);  //Lấy ngày đầu tiên trong tháng hiện tại
        Date end = DateTimeHelper.addDays(DateTimeHelper.addMonths(begin, 1), -1);   //Lấy ngày cuối cùng trong tháng hiện tại

        //Tổng tất cả sản phẩm của nhân viên thứ 1
        ArrayList<Employee> list = nvd.getListNV2(begin, end);
        System.out.print("Tổng tất cả sản phẩm trong tháng của NV1: ");
        System.out.println(list.get(4).getSumAmoutAllProductWorking());

        //Tổng tất cả sản phẩm T-skirt của nhân viên thứ 1
        System.out.print("Tổng tất cả sản phẩm T-skirt trong tháng của NV1: ");
        System.out.println(list.get(0).getSumAmoutProductWorking(1));

        ArrayList<ViewDate> dates = DateTimeHelper.getDates(begin, end);
        System.out.println("================Date================");
        System.out.println(dates.get(0).getValue());
        System.out.println("================cidate================");
        System.out.println(list.get(0).getTimesheets().get(1).getCidate());
        System.out.println("================pname================");
        System.out.println(list.get(0).getTimesheets().get(1).getP().getPname());

        System.out.println("================Salary================");
        System.out.println(list.get(1).getSumSalaryWorking());

    }
}
