/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationsapp;

import java.util.Date;

public class Charge extends Operation {
    private ChargeCategory category;
    /**
     * Empty constructor for Charge.
     */
    public Charge(){
        super();
        category = null;
    }
    
    /**
     * Constructor for Charge.
     * @param category
     */
    public Charge(ChargeCategory category){
        this.category = category;
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
    public Charge(int id, double value,String description, Date datetime, ChargeCategory category){
        super(id,value,description,datetime, 2);
        this.category = category;
    }

    /**
     * @return the category
     */
    public ChargeCategory getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(ChargeCategory category) {
        this.category = category;
    }
    
    
}

