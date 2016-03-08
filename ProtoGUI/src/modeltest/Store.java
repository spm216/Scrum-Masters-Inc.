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
public class Store {
    private String address;
    private String name;
    private ArrayList<Sale> saleList;
    private Register reg;
    
    public Store(String add, String n) {
        this.address = add;
        this.name = n;
        this.saleList = new ArrayList<Sale>();
        this.reg = new Register();
    }
    
    //getters for class properties
    String getAddress() {
        return this.address;
    }
    
    String getName() {
        return this.name;
    }
    
    public ArrayList<Sale> getSales() {
        return this.saleList;
    }
    
    public Register getReg() {
        return this.reg;
    }
    
    //adds new sale to list of sales
    public void addSale() {
        Sale sale = this.reg.makeNewSale(new Date());
        this.saleList.add(sale);
    }
}
