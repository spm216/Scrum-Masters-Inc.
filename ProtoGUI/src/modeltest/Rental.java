/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modeltest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Joe G
 */
class Rental {
    private boolean isComplete;
    private Date time;
    private ArrayList<RentalLineItem> rentalLine;
    private double total;
    private boolean returned;
    private int dueTime;
    private int transID;
    
    Rental(Date t) {
        this.isComplete = false;
        this.time = t;
        this.rentalLine = new ArrayList<RentalLineItem>();
        this.total = 0;
        this.returned = false;
        this.dueTime = 30;
    }
    
    RentalLineItem makeLineItem(String id, int qty, int days, Connection conn) throws ClassNotFoundException, SQLException {
        RentalLineItem item = new RentalLineItem(id, qty, days, conn);
        if(item.isValid()) {
            this.rentalLine.add(item);
            this.total += (item.getSubtotal()*days);
        }
        return item;
    }
    
    double getTotal() {
        return this.total;
    }
    
    void setTransID(int transID) {
        this.transID = transID;
    }
    
    int getTransID() {
        return transID;
    }
    
    double makePayment(double amount) {
        return amount - this.total;
    }
    
    void becomeComplete() {
        this.isComplete = true;
    }
    
    void setReturned()
    {
        this.returned = true;
    }
    
    boolean isReturned()
    {
        return this.returned;
    }

    ArrayList<RentalLineItem> getRentalLine()
    {
        return this.rentalLine;
    }
    
    Date getTime() {
        return time;
    }
}
