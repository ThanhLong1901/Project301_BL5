/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.ViewDate;

/**
 *
 * @author Long
 */
public class DateTimeHelper {
    
    //Format lại Tue Aug 16 22:20:16 ICT 2022   =>  Tue Aug 16 00:00:00 ICT 2022
    public static Date removeTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    
    //Lấy thứ tự ngày hiện tại trong tháng với bắt đầu = 1
    public static int getDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }
    
    //Lấy ngày hiện tại + giá trị "days"
    public static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        Date d = c.getTime();
        return d;
    }
    
    //Lấy tháng trước + giá trị "days"
    public static Date addMonths(Date date, int months) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, months);  //Calendar.MONTH: Lấy tháng trước vì bắt đầu T1 = 0 => Tháng hiện tại = Calendar.MONTH + 1
        Date d = c.getTime();
        return d;
    }
    
    //Lấy ngày trong tuần với CN=0, T2=1, T3=2,...,T7=6
    public static int getDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK);
    }
    
    //Lấy ngày từ from => to
    public static ArrayList<ViewDate> getDates(Date from, Date to) {
        ArrayList<ViewDate> dates = new ArrayList<>();
        int day = 0;
        while (true) {
            Date d = addDays(from, day);
            ViewDate item = new ViewDate();
            item.setValue(d);
            day++;
            dates.add(item);
            if (item.getValue().getTime() - to.getTime() == 0) {
                break;
            }
        }
        return dates;
    }
    
    public static Timestamp getTimeStamp(Date data) {
        return new Timestamp(data.getTime());
    }
    
    public static void main(String[] args) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        System.out.println(c.getTime());
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        System.out.println(c.getTime());
    }
}
