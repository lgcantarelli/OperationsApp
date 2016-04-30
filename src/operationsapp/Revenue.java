/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationsapp;

import java.util.Date;

public class Revenue extends Operation {
    
    /**
     * Empty constructor for revenue.
     */
    public Revenue(){
        super();
    }
    
    /**
     * Copy constructor for Revenue.
     * @param o, a Operation object.
     */
    public Revenue(Operation o){
        super(o);
    }
    
    /**
     * Constructor for Revenue.
     * @param id
     * @param value
     * @param datetime 
     */
    public Revenue(int id, double value, Date datetime){
        super(id,value,datetime);
    }
}
