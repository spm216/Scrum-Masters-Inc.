/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltest;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.*;
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
    private Rental rental;
    private Connection conn;
    
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
    
    public Rental makeNewRental(Date time)
    {
        this.rental = new Rental(time);
        return this.rental;
    }
    
    public SalesLineItem enterItem(String id, int qty, Connection conn) throws SQLException, ClassNotFoundException {
        this.conn = conn;
        return this.sale.makeLineItem(id, qty, conn);
    }
    
    public RentalLineItem enterRItem(String id, int qty, int days, Connection conn) throws SQLException, ClassNotFoundException {
        return this.rental.makeLineItem(id, qty, days, conn);
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
    
    public void printReceipt() {
        if(sale != null)
        {
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
        }else
        {
        int transNum = 1; //TODO: generate actual transaction number earlier
        ArrayList<RentalLineItem> rentalLine = rental.getRentalLine();
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("receipt" + transNum + ".txt"), "utf-8"))) {
            writer.write("\tSCRUM-MASTERS-INC.\n");
            writer.write("\tRENTAL\n");
            writer.write("\t" + transNum + "\n");
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
            writer.write(dateFormat.format(rental.getTime()) + "\n");
            writer.write("\t" + user.toUpperCase() + "\n\n");
            for(int i = 0; i < rentalLine.size(); i++) {
                RentalLineItem temp = rentalLine.get(i);  
                writer.write(String.format(temp.getDesc() + "(x" + temp.getQuantity() + ")"+ "\t%5.2f\n", temp.getSubtotal())+ "\tReturn Due: "+ dateFormat.format(temp.dueDate())+"\n"); 
            }
            writer.write(String.format("Subtotal\t\t%5.2f\n", this.getRTotal()));
            writer.write(String.format("Sales Tax\t\t%5.2f\n", this.getRTotal()*.07));
            writer.write(String.format("Balance Due\t\t%5.2f\n", this.getRTotal()*1.07));
        } catch (IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
    public void returnItems() throws ClassNotFoundException, SQLException
    {
       Statement s = conn.createStatement();
       if(sale != null)
        {
        for(int i = 0; i < sale.getList().size(); i++)
        {
        String id = sale.getList().get(i).getID();
        int q = sale.getList().get(i).getQty();
        String sql = "UPDATE test.items SET quantity = quantity - "+q+" WHERE id = " + id;
        int rs = s.executeUpdate(sql);
        }
        }else
        {
        for(int i = 0; i < rental.getRentalLine().size(); i++)
        {
        String id = rental.getRentalLine().get(i).getID();
        int q = rental.getRentalLine().get(i).getQuantity();
        String sql = "UPDATE test.items SET quantity = quantity - "+q+" WHERE id = " + id;
        int rs = s.executeUpdate(sql);
        }
        } 
    }
    
    public void purchaseItems() throws ClassNotFoundException, SQLException
    {
       Statement s = conn.createStatement();
       if(sale != null)
        {
        for(int i = 0; i < sale.getList().size(); i++)
        {
        String id = sale.getList().get(i).getID();
        int q = sale.getList().get(i).getQty();
        String sql = "UPDATE test.items SET quantity = quantity - "+q+" WHERE id = " + id;
        int rs = s.executeUpdate(sql);
        }
        }else
        {
        for(int i = 0; i < rental.getRentalLine().size(); i++)
        {
        String id = rental.getRentalLine().get(i).getID();
        int q = rental.getRentalLine().get(i).getQuantity();
        String sql = "UPDATE test.items SET quantity = quantity - "+q+" WHERE id = " + id;
        int rs = s.executeUpdate(sql);
        }
        }      
    }
}
