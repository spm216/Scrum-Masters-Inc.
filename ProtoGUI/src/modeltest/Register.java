/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ian W
 */
public class Register {
    private int regNum;
    private Sale sale;
    private Rental rental;
    
    Register() {
        this.regNum = 0;
    }
    
    //creates new sale instance
    public Sale makeNewSale(Date time) {
        this.sale = new Sale(time);
        return this.sale;
    }
    
    public Rental makeNewRental(Date time)
    {
        this.rental = new Rental(time);
        return this.rental;
    }
    
    public SalesLineItem enterItem(String id, int qty) throws SQLException, ClassNotFoundException {
        return this.sale.makeLineItem(id, qty);
    }
    
    public RentalLineItem enterRItem(String id, int qty, int days) throws SQLException, ClassNotFoundException {
        return this.rental.makeLineItem(id, qty, days);
    }
    
    public double getTotal() {
        return sale.getTotal();
    }
    
    public double getRTotal()
    {
     return rental.getTotal();
    }
    
    public void endSale() {
        if(sale != null)
        {
        sale.becomeComplete();
        }else
        {
        rental.becomeComplete();
        }
    }
    
    public double makePayment(double amount) {
        if(sale != null)
        {
        return this.sale.makePayment(amount);
        }else
        {
        return this.rental.makePayment(amount);
        }
    }
}
