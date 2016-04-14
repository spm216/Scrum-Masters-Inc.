/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ian W
 */
public class Return {
    private boolean isComplete;
    private Date time;
    private ArrayList<SalesLineItem> salesLine;
    private double total;
    private int transID;
    
    Return(Date t) {
        this.isComplete = false;
        this.time = t;
        this.salesLine = new ArrayList<SalesLineItem>();
        this.total = 0;
    }
    
    SalesLineItem makeLineItem(String id, int qty, Connection conn) throws ClassNotFoundException, SQLException {
        SalesLineItem item = new SalesLineItem(id, qty, conn);
        if(item.isValid()) {
            this.salesLine.add(item);
            this.total -= item.getSubtotal();
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
    
    double makePayment() {
        return this.total*-1;
    }
    
    void becomeComplete() {
        this.isComplete = true;
    }
    
    Date getTime() {
        return time;
    }
    
    ArrayList<SalesLineItem> getList() {
        return salesLine;
    }
}
