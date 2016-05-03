/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationsapp;

import java.util.Date;

public class Operation {
    private int id;
    private double value;
    private String title;
    private Date datetime;
    private int type; //1 - Revenue, 2 - Charge

    /**
     * Empty constructor for Operation.
     */
    public Operation(){
        id = 0;
        value = 0;
        datetime = null;
        type = 1;
    }
    
    /**
     * Constructor for operation.
     * @param id
     * @param value
     * @param datetime 
     * @param title
     */
    public Operation(int id, double value, String title, Date datetime, int type){
        this.id = id;
        this.value = value;
        this.datetime = datetime;
        this.title = title;
        this.type = type;
    }
    
    /**
     * Copy constructor for operation.
     * @param o 
     */
    public Operation(Operation o){
        this.id = o.getId();
        this.value = o.getValue();
        this.datetime = o.getDatetime();
        this.title = o.getTitle();
        this.type = o.getType();
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

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }
    
    /**
     * @return the title
     */
    public String getTitle(){
        return title;
    }
    
    /**
     * @param value the value to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return the date
     */
    public Date getDatetime() {
        return datetime;
    }

    /**
     * @param date the date to set
     */
    public void setDatetime(Date date) {
        this.datetime = date;
    }
    
    /**
     * Edit the entire operation.
     * @param v
     * @param d 
     */
    public void edit_operation(double v, String de, Date d){
        value = v;
        datetime = d;
        title = de;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }
    
    public String toString(){
        System.out.print("Id: "+id+" value: "+value+" title: "+title+" data: "+datetime+" type: "+type);
        if(this instanceof Revenue){
            Revenue r = (Revenue) this;
            System.out.println(" category: "+r.getCategory().getName());
        }else{
            Charge c = (Charge) this;
            System.out.println(" category: "+c.getCategory().getName());
        }
        return "";
    }
    
}
