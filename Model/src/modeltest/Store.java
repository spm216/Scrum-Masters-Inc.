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
class Store {
    private String address;
    private String name;
    private ArrayList<Sale> saleList;
    private Register reg;
    
    Store(String add, String n) {
        address = add;
        name = n;
        saleList = new ArrayList<Sale>();
        reg = new Register();
    }
    
    //getters for class properties
    String getAddress() {
        return address;
    }
    
    String getName() {
        return name;
    }
    
    //adds new sale to list of sales
    void addSale() {
        Sale sale = reg.makeNewSale(new Date());
        saleList.add(sale);
    }
}
