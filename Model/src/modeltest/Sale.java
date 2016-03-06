/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modeltest;

import java.util.Date;

/**
 *
 * @author Ian W
 */
class Sale {
    private boolean isComplete;
    private Date time;
    
    Sale(Date t) {
        isComplete = false;
        time = t;
    }
}
