/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIv2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus
 */
public class DateOperations {
    
    public Date formatDate(String dateString){
 
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String textDate = dateString;
        Date date = null ;
        try {  
            date = format.parse(textDate);
        } catch (ParseException ex) {
           JOptionPane.showMessageDialog(null, "Informe um data no fomato DD/MM/AA");
        }
        return date;
    }
    
    public String formatDate(Date date){
        String dateString;
        String year;
        String day;
        String month;
        if(date.getYear()>=100)year = String.valueOf((date.getYear())-100);
        else year = String.valueOf(date.getYear());
        
        if(date.getDate()<10)day = "0"+String.valueOf(date.getDate());
        else day = String.valueOf(date.getDate());
        
        if(date.getMonth()<9)month = "0"+String.valueOf(date.getMonth()+1);
        else month = String.valueOf(date.getMonth()+1);
        
        dateString=day+"/"+month+"/"+year;
        
        return dateString;
    }
    
}
