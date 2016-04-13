/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ian W
 */
public class Store {
    private String address;
    private String name;
    private ArrayList<Sale> saleList;
    private ArrayList<Rental> rentalList;
    private ArrayList<Return> returnList;
    private Register reg;
    private Connection conn;
    
    public Store(String add, String n) {
        this.address = add;
        this.name = n;
        this.saleList = new ArrayList<Sale>();
        this.rentalList = new ArrayList<Rental>();
        this.returnList = new ArrayList<Return>();
        this.reg = new Register();
        this.openDB();
    }
    
    //getters for class properties
    public String getAddress() {
        return this.address;
    }
    
    public String getName() {
        return this.name;
    }
    
    public ArrayList<Sale> getSales() {
        return this.saleList;
    }
    
    public Register getReg() {
        return this.reg;
    }
    
    public Connection getConn() {
        return conn;
    }
    
    public void closeConn() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //adds new sale to list of sales
    public void addSale() {
        Sale sale = this.reg.makeNewSale(new Date());
        this.saleList.add(sale);
    }
    
    public void openDB()
    {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/scrumDB", "scrum", "scrum");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Rental> getRentals() {
        return this.rentalList;
    }
        
    //adds new sale to list of sales
    public void addRental() {
        Rental rental = this.reg.makeNewRental(new Date());
        this.rentalList.add(rental);
    }
    
    public void addReturn() {
        Return ret = this.reg.makeNewReturn(new Date());
        this.returnList.add(ret);
    }
}
