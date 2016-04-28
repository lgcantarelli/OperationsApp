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
    private Date datetime;

    /**
     * Empty constructor for Operation.
     */
    public Operation(){
        id = 0;
        value = 0;
        datetime = null;
    }
    
    /**
     * Constructor for operation.
     * @param id
     * @param value
     * @param datetime 
     */
    public Operation(int id, double value, Date datetime){
        this.id = id;
        this.value = value;
        this.datetime = datetime;
    }
    
    /**
     * Copy constructor for operation.
     * @param o 
     */
    public Operation(Operation o){
        this.id = o.getId();
        this.value = o.getValue();
        this.datetime = o.getDatetime();
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
    public void edit_operation(double v, Date d){
        value = v;
        datetime = d;
    }
    
}
