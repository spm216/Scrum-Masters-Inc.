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
    private int total;
    
    Sale(Date t) {
        isComplete = false;
        time = t;
        salesLine = new ArrayList<SalesLineItem>();
        total = 0;
    }
    
    void makeLineItem(String id, int qty) {
        SalesLineItem item = new SalesLineItem(id, qty);
        if(item.isValid()) {
            salesLine.add(item);
            total += item.getSubtotal();
        }
    }
    
    int getTotal() {
        return total;
    }
    
    int makePayment(int amount) {
        becomeComplete();
        return amount - total;
    }
    
    void becomeComplete() {
        isComplete = true;
    }
}
