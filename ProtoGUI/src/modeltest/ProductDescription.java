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
    private String id;
    private boolean validItem;
    Statement s;
    String sql;
    ResultSet rs = null;
    
    ProductDescription(String id) throws ClassNotFoundException, SQLException {
        Connection con=null;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        DriverManager.getConnection("jdbc:derby://localhost:1527/orbdb", "root", "root");
        Statement s=con.createStatement();
        String q;
        ResultSet result;
        sql = "SELECT name, price FROM items where id = " + id;
        rs = s.executeQuery(sql);
        this.desc = rs.getString("name");
        this.salePrice = rs.getDouble("price");
        this.salePrice = 3; //placeholder for db interaction
        if (desc == null){
            this.validItem = false;
        }else{
            this.validItem = true; //true or false if it exists in db
        }
        s.close();
        con.close();
    }
    
    String getDesc() {
        return this.desc;
    }
    
    double getSalePrice() {
        return this.salePrice;
    }
    
    boolean isValid() {
        return this.validItem;
    }
}
