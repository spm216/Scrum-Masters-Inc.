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
    private Return ret;
    private Connection conn;
    
    Register() {
        this.regNum = 0;
        sale = null;
        rental = null;
        ret = null;
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
    
    public Return makeNewReturn(Date time) {
        ret = new Return(time);
        return ret;
    }
    
    public SalesLineItem enterItem(String id, int qty, Connection conn) throws SQLException, ClassNotFoundException {
        this.conn = conn;
        return this.sale.makeLineItem(id, qty, conn);
    }
    
    public RentalLineItem enterRItem(String id, int qty, int days, Connection conn) throws SQLException, ClassNotFoundException {
        this.conn = conn;
        return this.rental.makeLineItem(id, qty, days, conn);
    }
    
    public SalesLineItem enterReturnItem(String id, int qty, Connection conn) throws ClassNotFoundException, SQLException {
        this.conn = conn;
        return ret.makeLineItem(id, qty, conn);
    }
    
    public double getTotal() {
        return sale.getTotal();
    }
    
    public double getRTotal()
    {
     return rental.getTotal();
    }
    
    public double getReturnTotal() {
        return ret.getTotal();
    }
    
    public void endSale() {
        if(sale != null)
        {
            sale.becomeComplete();
            sale = null;
        }
        else if(rental != null)
        {
            rental.becomeComplete();
            rental = null;
        }
        else
        {
            ret.becomeComplete();
            ret = null;
        }
    }
    
    public double makePayment(double amount) {
        if(sale != null)
        {
            return this.sale.makePayment(amount);
        }
        else if(rental != null)
        {
            return this.rental.makePayment(amount);
        }
        else
        {
            return this.ret.makePayment();
        }
    }
    
    public void printReceipt() {
        if(sale != null)
        {
            int transNum = 1; //TODO: generate actual transaction number earlier
            String trans = String.format("%06d", transNum);
            ArrayList<SalesLineItem> salesLine = sale.getList();
            try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("receipt" + trans + ".txt"), "utf-8"))) {
                writer.write(center("SCRUM-MASTERS-INC.") + "\r\n");
                writer.write(center(trans + "") + "\r\n");
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
                writer.write(center(dateFormat.format(sale.getTime())) + "\r\n");
                writer.write(center(user.toUpperCase()) + "\r\n\r\n");
                for(int i = 0; i < salesLine.size(); i++) {
                    SalesLineItem temp = salesLine.get(i);
                    writer.write(center(String.format(temp.getDesc() + "(x" + temp.getQty() + ")" + "\t%5.2f", temp.getSubtotal())) + "\r\n"); 
                }
                writer.write(center(String.format("Subtotal\t%5.2f", this.getTotal())) + "\r\n");
                writer.write(center(String.format("Sales Tax\t%5.2f", this.getTotal()*.07)) + "\r\n");
                writer.write(center(String.format("Balance Due\t%5.2f", this.getTotal()*1.07)));
            } catch (IOException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(rental != null)
        {
            int transNum = 1; //TODO: generate actual transaction number earlier
            String trans = String.format("%06d", transNum);
            ArrayList<RentalLineItem> rentalLine = rental.getRentalLine();
            try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("receipt" + trans + ".txt"), "utf-8"))) {
                writer.write("\tSCRUM-MASTERS-INC.\r\n");
                writer.write("\tRENTAL\r\n");
                writer.write("\t" + trans + "\r\n");
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
                writer.write(dateFormat.format(rental.getTime()) + "\r\n");
                writer.write("\t" + user.toUpperCase() + "\r\n\r\n");
                for(int i = 0; i < rentalLine.size(); i++) {
                    RentalLineItem temp = rentalLine.get(i);  
                    writer.write(String.format(temp.getDesc() + "(x" + temp.getQuantity() + ")"+ "\t%5.2f\r\n", temp.getSubtotal())+ "\tReturn Due: "+ dateFormat.format(temp.dueDate())+"\r\n"); 
                }
                writer.write(String.format("Subtotal\t\t%5.2f\r\n", this.getRTotal()));
                writer.write(String.format("Sales Tax\t\t%5.2f\r\n", this.getRTotal()*.07));
                writer.write(String.format("Balance Due\t\t%5.2f\r\n", this.getRTotal()*1.07));
            } catch (IOException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            int transNum = ret.getTransNum(); //TODO: generate actual transaction number earlier
            String trans = String.format("%06d", transNum);
            ArrayList<SalesLineItem> salesLine = ret.getList();
            try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("receipt" + trans + ".txt"), "utf-8"))) {
                writer.write(center("SCRUM-MASTERS-INC.") + "\r\n");
                writer.write(center(trans + "") + "\r\n");
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
                writer.write(center(dateFormat.format(ret.getTime())) + "\r\n");
                writer.write(center(user.toUpperCase()) + "\r\n\r\n");
                for(int i = 0; i < salesLine.size(); i++) {
                    SalesLineItem temp = salesLine.get(i);
                    writer.write(center(String.format(temp.getDesc() + "(x" + temp.getQty() + ")" + "\t-%5.2f", temp.getSubtotal())) + "\r\n"); 
                }
                writer.write(center(String.format("Subtotal\t%5.2f", this.getReturnTotal())) + "\r\n");
                writer.write(center(String.format("Sales Tax\t%5.2f", this.getReturnTotal()*.07)) + "\r\n");
                writer.write(center(String.format("Balance Due\t%5.2f", this.getReturnTotal()*1.07)));
            } catch (IOException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void returnItems() throws ClassNotFoundException, SQLException
    {
       Statement s = conn.createStatement();
       if(ret != null)
       {
            for(int i = 0; i < ret.getList().size(); i++)
            {
                String id = ret.getList().get(i).getID();
                int q = ret.getList().get(i).getQty();
                String sql = "INSERT INTO scrum.returns VALUES (" + ret.getTransNum() + ", " + id + ", " + q + ")";
                int rs = s.executeUpdate(sql);
            }
       }
       else
       {
            for(int i = 0; i < rental.getRentalLine().size(); i++)
            {
                String id = rental.getRentalLine().get(i).getID();
                int q = rental.getRentalLine().get(i).getQuantity();
                String sql = "UPDATE scrum.rentals SET qty = qty + "+q+" WHERE itemid = " + id;
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
        String sql = "UPDATE scrum.lines SET qty = qty - "+q+" WHERE itemid = " + id;
        int rs = s.executeUpdate(sql);
        }
        }else
        {
        for(int i = 0; i < rental.getRentalLine().size(); i++)
        {
        String id = rental.getRentalLine().get(i).getID();
        int q = rental.getRentalLine().get(i).getQuantity();
        String sql = "UPDATE scrum.rentals SET qty = qty - "+q+" WHERE itemid = " + id;
        int rs = s.executeUpdate(sql);
        }
        }      
    }
    
    private String center (String s) {
        int length = 30;
        if (s.length() > length) {
            return s.substring(0, length);
        } 
        else if (s.length() == length) {
            return s;
        } 
        else {
            int leftPadding = (length - s.length()) / 2; 
            StringBuilder leftBuilder = new StringBuilder();
            for (int i = 0; i < leftPadding; i++) {
                leftBuilder.append(" ");
            }

            int rightPadding = length - s.length() - leftPadding;
            StringBuilder rightBuilder = new StringBuilder();
            for (int i = 0; i < rightPadding; i++) 
                rightBuilder.append(" ");

            return leftBuilder.toString() + s 
                    + rightBuilder.toString();
        }
    }
}
