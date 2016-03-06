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
    
    Register() {
        this.regNum = 0;
    }
    
    //creates new sale instance
    Sale makeNewSale(Date time) {
        return new Sale(time);
    }
    
    void enterItem(Sale sale, String id, int qty) {
        sale.makeLineItem(id, qty);
    }
    
    int endSale(Sale sale) {
        return sale.getTotal();
    }
    
    int makePayment(Sale sale, int amount) {
        return sale.makePayment(amount);
    }
}
