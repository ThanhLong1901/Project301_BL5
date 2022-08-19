/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Long
 */
public class DayOff {
    private int doid;
    private Employee e;
    private Date fromdate;
    private Date todate;
    private DayOffType dot;

    public int getDoid() {
        return doid;
    }

    public void setDoid(int doid) {
        this.doid = doid;
    }

    public Employee getE() {
        return e;
    }

    public void setE(Employee e) {
        this.e = e;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }

    public DayOffType getDot() {
        return dot;
    }

    public void setDot(DayOffType dot) {
        this.dot = dot;
    }
    
    
}
