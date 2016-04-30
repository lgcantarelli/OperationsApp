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
import java.io.FileWriter;
import java.io.IOException;


public class User {
    private List<Operation> operations;
    private int last_id;
    private double balance;
    
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,type,value,category,description";
    private static final String fileName = System.getProperty("user.home")+"/operations.csv";
    
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
        operations.add(r);
        rewrite_csv();
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
    
    private void rewrite_csv(){
        FileWriter fileWriter = null;
        
        try {
            fileWriter = new FileWriter(fileName);

            fileWriter.append(FILE_HEADER.toString());

            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Operation operation : operations) {
                String category = "";
                String type = "";
                if(operation.getType() == 1){
                    Revenue op = (Revenue) operation;
                    category = op.getCategory().getName();
                    type = "Revenue";
                }else{
                    Charge op = (Charge) operation;
                    category = op.getCategory().getName();
                    type = "Charge";
                }
                fileWriter.append(String.valueOf(operation.getId()));

                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(type);

                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(String.valueOf(operation.getValue()));

                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(category);

                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(String.valueOf(operation.getDescription()));

                fileWriter.append(NEW_LINE_SEPARATOR);

            }

               System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {

                fileWriter.flush();

                fileWriter.close();

            } catch (IOException e) {

                System.out.println("Error while flushing/closing fileWriter !!!");

                e.printStackTrace();

            }
        }

    }
    
}
