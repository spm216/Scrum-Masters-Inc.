/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltest;

/**
 *
 * @author Ian W
 */
class ProductDescription {
    private String desc;
    private double salePrice;
    private String id;
    private boolean validItem;
    
    ProductDescription(String id) {
        this.id = id;
        this.desc = ""; //placeholder for db interaction
        this.salePrice = 0; //placeholder for db interaction
        this.validItem = true; //true or false if it exists in db
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
