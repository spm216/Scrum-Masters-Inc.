/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltest;

import java.sql.SQLException;

/**
 *
 * @author Ian W
 */
public class SalesLineItem {
    private ProductDescription item;
    private int qty;
    
    SalesLineItem(String id, int qty) throws ClassNotFoundException, SQLException {
        this.qty = qty;
        this.item = new ProductDescription(id);
    }
    
    public double getSubtotal() {
        return this.item.getSalePrice() * this.qty;
    }
    
    public String getDesc() {
        return this.item.getDesc();
    }
    
    public int getQty() {
        return qty;
    }
    
    boolean isValid() {
        return this.item.isValid();
    }
}
