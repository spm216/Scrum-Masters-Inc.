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
class SalesLineItem {
    private ProductDescription item;
    private int qty;
    
    SalesLineItem(String id, int qty) {
        this.qty = qty;
        this.item = new ProductDescription(id);
    }
    
    double getSubtotal() {
        return this.item.getSalePrice() * this.qty;
    }
    
    boolean isValid() {
        return this.item.isValid();
    }
}
