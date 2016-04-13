/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Joe G
 */
public class RentalLineItem {
    private ProductDescription item;
    private int qty;
    private int days;
    private String id;
    
    RentalLineItem(String id, int qty, int days, Connection conn) throws ClassNotFoundException, SQLException {
        this.qty = qty;
        this.item = new ProductDescription(id, conn);
        this.days = days;
        this.id = id;
    }
    
    public double getSubtotal() {
        return this.item.getRentPrice() * this.qty;
    }
    
    public String getDesc() {
        return this.item.getDesc();
    }
    
    boolean isValid() {
        return this.item.isValid();
    }
    
    public int getDays()
    {
      return this.days;
    }
    
    public String getID()
    {
        return this.id;
    }
    
    public int getQuantity()
    {
        return this.qty;
    }
        
    Date dueDate()
    {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());
        c.add(Calendar.DATE, days);              
        return c.getTime();
    }
    
}
