/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modeltest;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Ian W
 */
class Sale {
    private boolean isComplete;
    private Date time;
    private ArrayList<SalesLineItem> salesLine;
    private double total;
    
    Sale(Date t) {
        this.isComplete = false;
        this.time = t;
        this.salesLine = new ArrayList<SalesLineItem>();
        this.total = 0;
    }
    
    SalesLineItem makeLineItem(String id, int qty) {
        SalesLineItem item = new SalesLineItem(id, qty);
        if(item.isValid()) {
            this.salesLine.add(item);
            this.total += item.getSubtotal();
        }
        return item;
    }
    
    double getTotal() {
        return this.total;
    }
    
    double makePayment(double amount) {
        this.becomeComplete();
        return amount - this.total;
    }
    
    void becomeComplete() {
        this.isComplete = true;
    }
}
