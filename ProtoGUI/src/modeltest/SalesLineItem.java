/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltest;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Ian W
 */
public class SalesLineItem {
    private ProductDescription item;
    private int qty;
    private String id;
    
    SalesLineItem(String id, int qty, Connection conn) throws ClassNotFoundException, SQLException {
        this.qty = qty;
        this.id = id;
        this.item = new ProductDescription(id, conn);
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
    
    public String getID() {
        return this.id;
    }
    
    boolean isValid() {
        return this.item.isValid();
    }
}
