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

    public ArrayList<Employee> getListEmployee(Date from, Date end) {
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

    public ArrayList<DayOff> getListDOTEmployee(Date from, Date end, int eid) {
        ArrayList<DayOff> list = new ArrayList<>();
        try {
            String sql = "select e.eid, e.ename, ISNULL(do.doid, -1) as doid, do.fromdate, do.todate, dot.dotid, dot.dottitle, dot.dotnotation"
                    + " from Employee e left join (select * from DayOff where fromdate >= ? and todate <= ?) do"
                    + " on e.eid = do.eid left join DayOffType dot on dot.dotid = do.dotid where e.eid = ?";
            st = connection.prepareStatement(sql);
            st.setTimestamp(1, DateTimeHelper.getTimeStamp(from));
            st.setTimestamp(2, DateTimeHelper.getTimeStamp(end));
            st.setInt(3, eid);
            rs = st.executeQuery();

//            Employee currentE = new Employee();
//            currentE.setEid(-1);
            while (rs.next()) {
                Employee e = new Employee();
                e.setEid(eid);
                e.setEname(rs.getString("ename"));
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
                    dof.setE(e);
                    list.add(dof);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DayOffDAO.class.getName()).log(Level.SEVERE, null, ex);
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

        ArrayList<Employee> list = nvd.getListEmployee(begin, end);
        System.out.println(list.get(0).getSumAmoutProductWorking(0));
//        for (int i = 0; i < list.size(); i++) {
//            list.get(i).setDayoff(nvd.getListDOTEmployee1(begin, end, i));
//        }
//        //Tổng tất cả sản phẩm của nhân viên thứ 1       
//        System.out.print("Tổng tất cả sản phẩm trong tháng của NV1: ");
//        System.out.println(list.get(4).getSumAmoutAllProductWorking());
//
//        //Tổng tất cả sản phẩm T-skirt của nhân viên thứ 1
//        System.out.print("Tổng tất cả sản phẩm T-skirt trong tháng của NV1: ");
//        System.out.println(list.get(0).getSumAmoutProductWorking(1));
//
//        ArrayList<ViewDate> dates = DateTimeHelper.getDates(begin, end);
//        System.out.println("================Date================");
//        System.out.println(dates.get(0).getValue());
//        System.out.println("================cidate================");
//        System.out.println(list.get(0).getTimesheets().get(1).getCidate());
//        System.out.println("================pname================");
//        System.out.println(list.get(0).getTimesheets().get(1).getP().getPname());
//
//        System.out.println("================Salary================");
//        System.out.println(list.get(1).getSumSalaryWorking());

//            System.out.println(list.get(1).getDayoff().get(1).getFromdate());
    

//        long diff = end.getTime() - begin.getTime();
//       float hours = ((diff/1000)*(1.0f))/3600;
//        System.out.println(hours/24 + 1);
    }
}
