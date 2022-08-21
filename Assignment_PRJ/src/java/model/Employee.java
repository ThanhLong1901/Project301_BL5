/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Long
 */
public class Employee {

    private int eid;
    private String ename;
    private ArrayList<TimeSheet> timesheets = new ArrayList<>();
    private ArrayList<DayOff> dayoff = new ArrayList<>();

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public ArrayList<TimeSheet> getTimesheets() {
        return timesheets;
    }

    public void setTimesheets(ArrayList<TimeSheet> timesheets) {
        this.timesheets = timesheets;
    }

    public ArrayList<DayOff> getDayoff() {
        return dayoff;
    }

    public void setDayoff(ArrayList<DayOff> dayoff) {
        this.dayoff = dayoff;
    }
   
    //Tổng số lượng tất cả sản phẩm mà 1 nhân viên làm trong tất cả các ngày
    public int getSumAmoutAllProductWorking() {
        int sum = 0;
        for (TimeSheet timesheet : timesheets) {
            sum += timesheet.getAmount();
        }
        return sum;
    }
    
    //Tổng số lượng của 1 sản phẩm mà 1 nhân viên làm trong tất cả các ngày
    public int getSumAmoutProductWorking(int pid) {
        int sum = 0;
        for (TimeSheet timesheet : timesheets) {
            if(timesheet.getP().getPid() == pid){
                sum += timesheet.getAmount();
            }
        }
        return sum;
    }
    
    //Tổng Lương cả Tháng của Nhân Viên
    public int getSumSalaryProductWorking(int pid){
        int sum = 0;
        for (TimeSheet timesheet : timesheets) {
            if(timesheet.getP().getPid() == pid){
                sum += (timesheet.getP().getPprice()* timesheet.getAmount());
            }   
        }
        return sum;
    }
    
    //Tổng Lương cả Tháng của Nhân Viên
    public int getSumSalaryWorking(){
        int sum = 0;
        for (TimeSheet timesheet : timesheets) {
                sum += (timesheet.getP().getPprice()* timesheet.getAmount());
        }
        return sum;
    }
        
    //Tổng số lượng ngày đi làm của nhân viên
    public int getAllDayWorking(){
        int sum = 0;
        for (TimeSheet timesheet : timesheets) {
            if(timesheet.getDates().toString() != ""){
                sum++;
            }
        }
        return sum;
    }
    
    //Tổng số ngày nghỉ của từng nhân viên theo từng loại ngày nghỉ
    public int getSumDayOff(int dotid){
        int sum =  0;
        for (DayOff dayoff : dayoff) {
            if(dayoff.getDot().getDotid() == dotid){
                sum += dayoff.getDays();
            }
        }
        return sum;
    }
    
}
