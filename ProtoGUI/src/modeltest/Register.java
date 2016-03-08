/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltest;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ian W
 */
public class Register {
    private int regNum;
    private Sale sale;
    
    Register() {
        this.regNum = 0;
    }
    
    //creates new sale instance
    Sale makeNewSale(Date time) {
        this.sale = new Sale(time);
        return this.sale;
    }
    
    void enterItem(String id, int qty) {
        this.sale.makeLineItem(id, qty);
    }
    
    double endSale() {
        return this.sale.getTotal();
    }
    
    double makePayment(double amount) {
        return this.sale.makePayment(amount);
    }
}
