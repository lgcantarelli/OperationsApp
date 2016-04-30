/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationsapp;

import java.util.Date;

public class Revenue extends Operation {
     private RevenueCategory category;
    /**
     * Empty constructor for revenue.
     */
    public Revenue(){
        super();
        category = null;
    }
    
    /**
     * Constructor for Revenue.
     * @param category
     */
    public Revenue(RevenueCategory category){
        this.category = category;
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
    public Revenue(int id, double value, String description, Date datetime, RevenueCategory category){
        super(id,value,description,datetime, 1);
        this.category = category;
    }

    /**
     * @return the category
     */
    public RevenueCategory getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(RevenueCategory category) {
        this.category = category;
    }

    
}
