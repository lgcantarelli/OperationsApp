/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationsapp;

public class RevenueCategory {
    private String name;

    /**
     * Empty constructor for RevenueCategory.
     */
    public RevenueCategory(){
        name = "";
    }
    
    /**
     * Copy constructor for RevenueCategory.
     * @param r
     */
    
    public RevenueCategory(RevenueCategory r){
        this.name = r.getName();
    }
    /**
     * Constructor for RevenueCategory.
     * @param name 
     */
    public RevenueCategory(String name){
        this.name = name;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
