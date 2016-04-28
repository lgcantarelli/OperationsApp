/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationsapp;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private List<Operation> operations;
    private int last_id;
    private double balance;
    
    /**
     * Initialize the User with a empty list of operations and call the method to populate it.
     */
    public User(){
        operations = new ArrayList<Operation>();
        populate_initial();
    }
    
    /**
     * @return the operations
     */
    public List<Operation> getOperations() {
        return operations;
    }

    /**
     * @param operations the operations to set
     */
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
    
    /**
     * Open the .csv file and populate the list of operations in the date order.
     */
    private void populate_initial(){
        
    }
    
    /**
     * Add a revenue  in the list of operations in the date order, update the last id.
     * @param r, a Revenue object.
     */
    public void add_revenue(Revenue r){
        
    }
    
    /**
     * Add a revenue  in the list of operations in the date order, update the last id.
     * @param value, the value of the revenue.
     * @param datetime, the date of the revenue.
     */
    public void add_revenue(double value, Date datetime){
        
    }
    
    /**
     * Add a charge  in the list of operations in the date order, update the last id.
     * @param r, a Charge object.
     */
    public void add_charge(Charge c){
        
    }
    
    /**
     * Add a charge  in the list of operations in the date order, update the last id.
     * @param value, the value of the charge.
     * @param datetime, the date of the charge.
     */
    public void add_charge(double value, Date datetime){
        
    }
    
    /**
     * Return the csv file to the user.
     * @return file, a file to be handled by the GUI.
     */
    public File export_file(){
        return new File("");
    }

    /**
     * Returns a Operation by position.
     * @param position, the position in the array.
     * @return Operation object.
     */
    public Operation get_operation(int position){
        return operations.get(position);
    }
    
    /**
     * Returns a Operation by id.
     * @param position, the id of the operation.
     * @return Operation object.
     */
    public Operation get_operation_by_id(int id){
        return operations.get(id);
    }
    
    /**
     * Edit a operation by id.
     * @param id, the id to search.
     * @param value, the new value of the operation.
     * @param datetime, the new date of the operation.
     */
    public void edit_operation(int id, double value, Date datetime){
        
    }
    
    
    /**
     * Delete a Operation by position.
     * @param position, the position in the array.
     */
    public void del_operation(int position){
        operations.remove(position);
    }
    
    /**
     * Delete a Operation by id.
     * @param id, the id of the operation.
     */
    public void del_operation_by_id(int id){
        operations.remove(id);
    }
    
    /**
     * Return the data to populate the report.
     */
    public void return_bar_data(){
        
    }
    
    /**
     * Return the data to populate the report.
     */
    public void return_pizza_data(){
        
    }
    
    /**
     * Return the last_id.
     * @return last_id.
     */
    public int get_last_id(){
        return last_id;
    }
    
    /**
     * Return the actual balance.
     * @return balance.
     */
    public double get_balance(){
        return balance;
    }
    
}
