/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationsapp;

public class RevenueCategory {
    private int id;
    private String name;

    /**
     * Empty constructor for RevenueCategory.
     */
    public RevenueCategory(){
        id = 0;
        name = "";
    }
    
    /**
     * Copy constructor for RevenueCategory.
     * @param r
     */
    
    public RevenueCategory(RevenueCategory r){
        this.name = r.getName();
        this.id = r.getId();
    }
    /**
     * Constructor for RevenueCategory.
     * @param id
     * @param name 
     */
    public RevenueCategory(int id, String name){
        this.name = name;
        this.id = id;
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
