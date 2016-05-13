/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIv2;

import GUI.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import operationsapp.Charge;
import operationsapp.Operation;
import operationsapp.Revenue;
import operationsapp.User;

/**
 *
 * @author matheus
 */
public class TableMethods {
    
    public void printNewList(String[] add, javax.swing.JTable table){

        DefaultTableModel model = (DefaultTableModel) table.getModel();  
        TableCellRenderer tcr = new Colorir();
        TableColumn column =  table.getColumnModel().getColumn(3);
        column.setCellRenderer(tcr);
        model.addRow(add);
        column.setCellRenderer(tcr);  
    }
    
    public void updateList(User user,javax.swing.JTable table ){
        clearTable(table);
        DateOperations dto = new DateOperations();
        for(int i=0;i<user.getOperations().size();i++){
            String[] add = new String[4];
            add[0]=user.get_operation(i).getTitle();
            if(user.get_operation(i).getType()==1){
                Revenue op = (Revenue) user.get_operation(i);
                add[1]=op.getCategory().getName();}
            else{Charge op=(Charge) user.get_operation(i);
                add[1]=op.getCategory().getName();}
                String dateString = dto.formatDate(user.get_operation(i).getDatetime());
                add[2] = dateString;
                add[3]=String.valueOf(user.get_operation(i).getValue());
                printNewList(add,table);
        }
    }
    
    private void clearTable(javax.swing.JTable table ) {
        while (table.getRowCount() > 0) {
            DefaultTableModel dm = (DefaultTableModel) table.getModel();
            dm.getDataVector().removeAllElements();
        }
    }

    public void filterExtractChargeDate(User user,javax.swing.JTable table, String from, String until){
        clearTable(table);
        DateOperations dto = new DateOperations();
        List<Operation> listFiltred = new ArrayList<>();;
        try {
            listFiltred = user.getFiltredList(from, until, false, true);
        } catch (ParseException ex) {
            Logger.getLogger(TableMethods.class.getName()).log(Level.SEVERE, null, ex);}
        Charge operation;
        clearTable(table);
        add(listFiltred,table);

     }
    
    public void filterExtractCharge(User user, javax.swing.JTable table){
        List<Operation> listFiltred = new ArrayList<>();;
        try {
            listFiltred = user.getFiltredList("01/01/1900", "01/01/2999", false, true);
        } catch (ParseException ex) {
            Logger.getLogger(TableMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        Charge operation;
        clearTable(table);
        add(listFiltred,table);
    }
    
     public void filterExtractRevenue(User user, javax.swing.JTable table){
        //
        List<Operation> listFiltred = new ArrayList<>();
        try {
            listFiltred = user.getFiltredList("01/01/1900", "01/01/2999", true, false);
        } catch (ParseException ex) {
            Logger.getLogger(TableMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        Revenue operation; 
        clearTable(table);
        add(listFiltred,table);
    }
     
     public void filterExtractDate(User user,javax.swing.JTable table, String from, String until){
            clearTable(table);
            List<Operation> listFiltred = new ArrayList<>();;
        try {
            listFiltred = user.getFiltredList(from, until);
        } catch (ParseException ex) {
            Logger.getLogger(TableMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
            add(listFiltred,table);
 }
     
     public void filterExtractRevenueDate(User user,javax.swing.JTable table, String from, String until){
            clearTable(table);
            List<Operation> listFiltred = new ArrayList<>();
        try {
            listFiltred = user.getFiltredList(from, until, true, false);
        } catch (ParseException ex) {
            Logger.getLogger(TableMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
            Charge operation;
            add(listFiltred,table);
    }
    
    public void add(List<Operation> listFiltred,javax.swing.JTable table){
        DateOperations dto = new DateOperations();
        String[] add = new String[4];
        for(int index=0; index<listFiltred.size();index++){
            if(listFiltred.get(index).getType()==1){
                Revenue operation = (Revenue) listFiltred.get(index);
                add[1]=operation.getCategory().getName();
            }
            else{
                Charge operation=(Charge) listFiltred.get(index);
                add[1]=operation.getCategory().getName();
            }
            add[0]=listFiltred.get(index).getTitle();
            String dateString = dto.formatDate(listFiltred.get(index).getDatetime());
            add[2] = dateString;
            add[3]=String.valueOf(listFiltred.get(index).getValue());
            printNewList(add,table);
        }
    }
    

    
}
