/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationsapp;

import java.util.Date;

public class Charge extends Operation {
    
    /**
     * Empty constructor for Charge.
     */
    public Charge(){
        super();
    }
    
    /**
     * Copy constructor for Charge.
     * @param o, a Operation object.
     */
    public Charge(Operation o){
        super(o);
    }
    
    /**
     * Constructor for Charge.
     * @param id
     * @param value
     * @param datetime 
     */
    public Charge(int id, double value, Date datetime){
        super(id,value,datetime);
    }
}

