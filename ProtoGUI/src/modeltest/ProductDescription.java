/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltest;
import java.sql.*;

/**
 *
 * @author Ian W
 */
class ProductDescription {
    private String desc;
    private double salePrice;
    private double rentPrice;
    private String id;
    private boolean validItem;
    String sql;
    ResultSet rs = null;
    
    ProductDescription(String id, Connection conn) throws ClassNotFoundException, SQLException {
        Statement s = conn.createStatement();
        int select = Integer.parseInt(id); 
        sql = "SELECT name, price FROM scrum.inventory where itemid = " + select;
        rs = s.executeQuery(sql);
        while (rs.next()) {
           this.desc = rs.getString("name");
           this.salePrice = rs.getDouble("price");
        }
        if (desc == null){
            this.validItem = false;
        }else{
            this.validItem = true; //true or false if it exists in db
        }
        sql = "SELECT name, rentprice FROM scrum.inventory where itemid = " + select;
        rs = s.executeQuery(sql);
        while (rs.next()) {
           this.desc = rs.getString("name");
           this.rentPrice = rs.getDouble("price");
        }
        if (desc == null){
            this.validItem = false;
        }else{
            this.validItem = true; //true or false if it exists in db
        }
        s.close();
    }
    
    String getDesc() {
        return this.desc;
    }
    
    double getSalePrice() {
        return this.salePrice;
    }
    
    double getRentPrice(){
        return this.rentPrice;
    }
    
    boolean isValid() {
        return this.validItem;
    }
}
