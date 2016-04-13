/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modeltest;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ian W
 */
class Sale {
    private boolean isComplete;
    private Date time;
    private ArrayList<SalesLineItem> salesLine;
    private double total;
    private int transID;
    
    Sale(Date t) {
        this.isComplete = false;
        this.time = t;
        this.salesLine = new ArrayList<SalesLineItem>();
        this.total = 0;
    }
    
    SalesLineItem makeLineItem(String id, int qty, Connection conn) throws ClassNotFoundException, SQLException {
        SalesLineItem item = new SalesLineItem(id, qty, conn);
        if(item.isValid()) {
            this.salesLine.add(item);
            this.total += item.getSubtotal();
        }
        return item;
    }
    
    public void setTransID(int transID) {
        this.transID = transID;
    }
    
    public int getTransID() {
        return transID;
    }
    
    double getTotal() {
        return this.total;
    }
    
    double makePayment(double amount) {
        return amount - this.total;
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
