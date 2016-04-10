/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ian W
 */
public class Register {
    private int regNum;
    private Sale sale;
    private String user;
    
    Register() {
        this.regNum = 0;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    
    public String getUser() {
        return this.user;
    }
    
    //creates new sale instance
    public Sale makeNewSale(Date time) {
        this.sale = new Sale(time);
        return this.sale;
    }
    
    public SalesLineItem enterItem(String id, int qty) throws SQLException, ClassNotFoundException {
        return this.sale.makeLineItem(id, qty);
    }
    
    public double getTotal() {
        return sale.getTotal();
    }
    
    public void endSale() {
        sale.becomeComplete();
    }
    
    public double makePayment(double amount) {
        return this.sale.makePayment(amount);
    }
    
    public void printReceipt() {
        int transNum = 1; //TODO: generate actual transaction number earlier
        ArrayList<SalesLineItem> salesLine = sale.getList();
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("receipt" + transNum + ".txt"), "utf-8"))) {
            writer.write("\tSCRUM-MASTERS-INC.\n");
            writer.write("\t" + transNum + "\n");
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
            writer.write(dateFormat.format(sale.getTime()) + "\n");
            writer.write("\t" + user.toUpperCase() + "\n\n");
            for(int i = 0; i < salesLine.size(); i++) {
                SalesLineItem temp = salesLine.get(i);
                writer.write(String.format(temp.getDesc() + "(x" + temp.getQty() + ")" + "\t%5.2f\n", temp.getSubtotal())); 
            }
            writer.write(String.format("Subtotal\t\t%5.2f\n", this.getTotal()));
            writer.write(String.format("Sales Tax\t\t%5.2f\n", this.getTotal()*.07));
            writer.write(String.format("Balance Due\t\t%5.2f\n", this.getTotal()*1.07));
        } catch (IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
