/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import helper.DateTimeHelper;
import java.util.Date;

/**
 *
 * @author Long
 */
public class TimeSheet {

    private int tsid;
    private Employee e;
    private Product p;
    private int amount;
    private Date dates;
    private Date cidate;
    
    public int getTsid() {
        return tsid;
    }

    public void setTsid(int tsid) {
        this.tsid = tsid;
    }

    public Employee getE() {
        return e;
    }

    public void setE(Employee e) {
        this.e = e;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Date getCidate() {
        return DateTimeHelper.removeTime(dates);
    }
}
