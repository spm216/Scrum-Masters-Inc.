/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltest;

import java.util.ArrayList;

/**
 *
 * @author Ian W
 */
public class ModelTestMain {
    public static void main(String[] args) {
        Store store = new Store("Home", "Here");
        store.addSale();
        Register reg = store.getReg();
        reg.enterItem("11111", 1);
        double total = reg.endSale();
        double change = reg.makePayment(total);
    }
}
