/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationsapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import operationsapp.*;

public class User {
    private List<Operation> operations;
    private int last_id;
    private double balance;
    
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,type,value,category,title,datetime";
    private static final String fileName = "operations.csv";
    
    /**
     * Initialize the User with a empty list of operations and call the method to populate it.
     */
    public User(){
       operations = new ArrayList<Operation>();
        try {
            populate_initial();
        } catch (ParseException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private void populate_initial() throws ParseException{
        Scanner scanner;
        try {
            scanner = new Scanner(new File(fileName));
            scanner.nextLine();
            String line;
            String[] fields;
            SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy",new Locale("BRT,BRST"));
            
            int i;
            int id, category;
            String type, title;
            double value;
            Date datetime;
            while(scanner.hasNextLine()){
                line = scanner.nextLine();
                fields = line.split(",");
                
                id = Integer.parseInt(fields[0]);
                type = fields[1];
                value = Double.parseDouble(fields[2]);
                category = Integer.parseInt(fields[3]);
                title = fields[4];
                datetime = formatter.parse(fields[5]);
                
                if(type.equals("Revenue")){
                    RevenueCategory c = OperationsApp.getRevenueCategory(category);
                    Revenue r = new Revenue(id,value,title,datetime,c);
                    add_revenue(r);
                }else{
                    ChargeCategory c1 = OperationsApp.getChargeCategory(category);
                    Charge c = new Charge(id,value,title,datetime,c1);
                    add_charge(c);
                }
                    
                
                
            }
            
            
            
            
            scanner.close();
        } catch (FileNotFoundException ex) {
            
        }
        
    }
    
    /**
     * Add a revenue  in the list of operations in the date order, update the last id.
     * @param r, a Revenue object.
     */
    public void add_revenue(Revenue r){
        int i = 0;
                
        if(operations.size() == 0){
           operations.add(r);
        }else{
            for(; i < operations.size(); i++){
                if(r.getDatetime().before(operations.get(i).getDatetime())){
                    break;
                }
            }
            if(i == operations.size()){
                operations.add(r);
            }else{
                Operation aux;
                Operation aux1;
                aux = operations.get(i);
                operations.set(i, r);
                i++;

                for(; i < operations.size(); i++){
                   aux1 = operations.get(i);
                   operations.set(i,aux);
                   aux = aux1;
                }

                operations.add(aux);
            }
           
        }
        balance = balance + r.getValue();
        last_id++;
        rewrite_csv();
    }
    
    /**
     * Add a revenue  in the list of operations in the date order, update the last id.
     * @param value, the value of the revenue.
     * @param datetime, the date of the revenue.
     */
    public void add_revenue(double value,String description, Date datetime,RevenueCategory category){
        Revenue revenue=new Revenue(last_id,value,description,datetime,category);
        add_revenue(revenue);
    }
    
    /**
     * Add a charge  in the list of operations in the date order, update the last id.
     * @param r, a Charge object.
     */
    public void add_charge(Charge c){
        int i = 0;
                
        if(operations.size() == 0){
           operations.add(c);
        }else{
            for(; i < operations.size(); i++){
                if(c.getDatetime().before(operations.get(i).getDatetime())){
                    //System.out.println(i);
                    break;
                }
            }
            if(i == operations.size()){
                operations.add(c);
            }else{
                Operation aux;
                Operation aux1;
                aux = operations.get(i);
                operations.set(i, c);
                i++;

                for(; i < operations.size(); i++){
                   aux1 = operations.get(i);
                   operations.set(i,aux);
                   aux = aux1;
                }

                operations.add(aux);
            }
           
        }
        balance = balance - c.getValue();
        last_id++;
        rewrite_csv();
    }
    
    /**
     * Add a charge  in the list of operations in the date order, update the last id.
     * @param value, the value of the charge.
     * @param datetime, the date of the charge.
     */
    public void add_charge(double value, String description, Date datetime,ChargeCategory category){
        Charge charge=new Charge(last_id,value,description,datetime,category);
        add_charge(charge);
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
        for(int i=0;i<operations.size();i++){
           if (id==operations.get(i).getId()){
               return operations.get(i);
                
            }
            
        }
        return null;
    }
    
    /**
     * Edit a operation by id.
     * @param id, the id to search.
     * @param value, the new value of the operation.
     * @param datetime, the new date of the operation.
     */
     public void edit_operation(int id, double value, String description, Date datetime, RevenueCategory category, ChargeCategory category1){
        for(int i=0;i<operations.size();i++){
            if(id==operations.get(i).getId()){
                if(operations.get(i) instanceof Revenue){
                    Revenue r = (Revenue) operations.get(i);
                    r.setCategory(category);
                    balance = balance - operations.get(i).getValue() + value;
                }else{
                    Charge c = (Charge) operations.get(i);
                    c.setCategory(category1);
                    balance = balance + operations.get(i).getValue() - value;
                }
                operations.get(i).edit_operation(value, description, datetime);
                
                rewrite_csv();
                
            }
            
        }
    }
    
    
    /**
     * Delete a Operation by position.
     * @param position, the position in the array.
     */
    public void del_operation(int position){
        if(operations.get(position) instanceof Revenue){
            Revenue r = (Revenue) operations.get(position);
            balance = balance - operations.get(position).getValue();
        }else{
            Charge c = (Charge) operations.get(position);
            balance = balance + operations.get(position).getValue();
        }
        operations.remove(position);
        rewrite_csv();
    }
    
    /**
     * Delete a Operation by id.
     * @param id, the id of the operation.
     */
    public void del_operation_by_id(int id){
        for(int i=0;i<operations.size();i++){
            if(id==operations.get(i).getId()){
                del_operation(i);
            }
        }
    }
    
    /**
     * Return the data to populate the report.
     */
    public double[][] return_day_data(String from, String to, boolean revenue, boolean charge) throws ParseException{
        
        List<Operation> list = new ArrayList<Operation>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        
        Calendar c= Calendar.getInstance();
        c.add(Calendar.DATE, 10);
        Date date1 = c.getTime();
    
        if(from.length()>0){
            date  = formatter.parse(from);
        }
        if(to.length()>0){
            date1 = formatter.parse(to);
        }
        
        int diffInDays = (int)( (date1.getTime() - date.getTime()) / (1000 * 60 * 60 * 24));
        
        double data[][] = new double[diffInDays][3];
        
        for(int z = 0; z < diffInDays; z++){
            for(int v =0; v < 3; v++){
                data[z][v] = 0;
            }
        }
        
        for(int j = 0; j < diffInDays; j++){
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, j);
            Date d = cal.getTime();
            for(int i = 0; i < operations.size();i++){
                if(operations.get(i).getDatetime().getDay() == d.getDay() && operations.get(i).getDatetime().getMonth() == d.getMonth() 
                        && operations.get(i).getDatetime().getYear() == d.getYear()){
                    if(operations.get(i).getType() == 1 && revenue == true){
                       data[j][0] = data[j][0] + operations.get(i).getValue();
                       data[j][2] = data[j][2] + operations.get(i).getValue();
                    }

                    if(operations.get(i).getType() == 2 && charge == true){
                       data[j][1] = data[j][1] + operations.get(i).getValue();
                       data[j][2] = data[j][2] - operations.get(i).getValue();
                    }
                }
            
            }
        }
        
         
        return data; 
        
    }
    
    /**
     * Return the data to populate the report.
     */
    public double[] return_pizza_data(String from, String to, boolean revenue, boolean charge) throws ParseException{
        double data[] = new double[20];
        List<Operation> list = new ArrayList<Operation>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("01/01/1900");
        Date date1 = formatter.parse("01/01/2999");
        if(from.length()>0){
            date  = formatter.parse(from);
        }
        if(to.length()>0){
            date1 = formatter.parse(to);
        }
        
        for(int z = 0; z < 20; z++){
            data[z] = 0;
        }
        for(int i = 0; i < operations.size();i++){
            if(operations.get(i).getDatetime().after(date) && operations.get(i).getDatetime().before(date1)){
                if(operations.get(i).getType() == 1 && revenue == true){
                   Revenue r = (Revenue) operations.get(i);
                   data[r.getCategory().getId()] = data[r.getCategory().getId()] + operations.get(i).getValue();
                }
                
                if(operations.get(i).getType() == 2 && charge == true){
                   Charge c = (Charge) operations.get(i);
                   data[c.getCategory().getId()] = data[c.getCategory().getId()] + operations.get(i).getValue();
                }
            }
            
        }
         
        return data; 
    }
    
    public double[][] return_line_data(){
        double data[][] = new double[12][3];
        double revenue = 0;
        double charge = 0;
        int month = 1;
        Calendar cal1 = Calendar.getInstance();
        
        for(int z = 0; z < 12; z++){
            for(int v =0; v < 3; v++){
                data[z][v] = 0;
            }
        }
        
        for(int i = 0; i < operations.size();i++){
            cal1.setTime(operations.get(i).getDatetime());
            
            if(operations.get(i).getType() == 1){
                data[cal1.get(Calendar.MONTH)][0] = data[cal1.get(Calendar.MONTH)][0] + operations.get(i).getValue();
                data[cal1.get(Calendar.MONTH)][2] = data[cal1.get(Calendar.MONTH)][2] + operations.get(i).getValue();
            }else{
                data[cal1.get(Calendar.MONTH)][1] = data[cal1.get(Calendar.MONTH)][1] + operations.get(i).getValue(); 
                data[cal1.get(Calendar.MONTH)][2] = data[cal1.get(Calendar.MONTH)][2] - operations.get(i).getValue();
            }
        }
        
        return data;
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
                int category = 0;
                String type = "";
                if(operation.getType() == 1){
                    Revenue op = (Revenue) operation;
                    category = op.getCategory().getId();
                    type = "Revenue";
                }else{
                    Charge op = (Charge) operation;
                    category = op.getCategory().getId();
                    type = "Charge";
                }
                fileWriter.append(String.valueOf(operation.getId()));

                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(type);

                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(String.valueOf(operation.getValue()));

                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(String.valueOf(category));

                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(String.valueOf(operation.getTitle()));
                
                fileWriter.append(COMMA_DELIMITER);

                fileWriter.append(String.valueOf(operation.getDatetime()));

                fileWriter.append(NEW_LINE_SEPARATOR);

            }

        } catch (Exception e) {
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
    
    public void print_operations(){
        for(int i = 0; i < operations.size(); i++){
            operations.get(i).toString();
        }
    }
    
    public List<Operation> getFiltredList(String from, String to, boolean revenue, boolean charge) throws ParseException{
        List<Operation> list = new ArrayList<Operation>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("01/01/1900");
        Date date1 = formatter.parse("01/01/2999");
        if(from.length()>0){
            date  = formatter.parse(from);
        }
        if(to.length()>0){
            date1 = formatter.parse(to);
        }
        
        for(int i = 0; i < operations.size();i++){
            if(operations.get(i).getDatetime().after(date) && operations.get(i).getDatetime().before(date1)){
                if(operations.get(i).getType() == 1 && revenue == true){
                   list.add(operations.get(i));
                }
                
                if(operations.get(i).getType() == 2 && charge == true){
                   list.add(operations.get(i));
                }
            }
            
        }
        return list;
        
    }
    
     public List<Operation> getFiltredList(String from, String to) throws ParseException{
        List<Operation> list = new ArrayList<Operation>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("01/01/1900");
        Date date1 = formatter.parse("01/01/2999");
        if(from.length()>0){
            date  = formatter.parse(from);
        }
        if(to.length()>0){
            date1 = formatter.parse(to);
        }
        
        for(int i = 0; i < operations.size();i++){
            if(operations.get(i).getDatetime().after(date) && operations.get(i).getDatetime().before(date1)){
                   list.add(operations.get(i));
                }
            }
        return list;
     }
}
