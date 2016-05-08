/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import operationsapp.*;
/**
 *
 * @author matheus
 */
public class AddTestes {
    //teste//
    public AddTestes(User user){
        population(user);   
    }
    
    public AddTestes(){
        population();
    }
    
    public void population(){
        User user = new User();
        population(user);
    }
    
    public void population(User user){
        listaTeste = new ArrayList();
       // ChargeCategory chargeCategory = new ChargeCategory();
        
        Revenue revenue;
        Charge charge;
        String date;
        //Revenue revenue = new Revenue(id,value,addTitle.getText(),date,category);
            //user.add_revenue(revenue);
        ChargeCategory chargeCategory0=new ChargeCategory(0,"Supermercado");
        ChargeCategory chargeCategory1=new ChargeCategory(1,"Aluguel");
        ChargeCategory chargeCategory2=new ChargeCategory(2,"Luz");
        ChargeCategory chargeCategory3=new ChargeCategory(3,"Água");
        ChargeCategory chargeCategory4=new ChargeCategory(4,"Telefone");
        ChargeCategory chargeCategory5=new ChargeCategory(5,"Internet");
        ChargeCategory chargeCategory6=new ChargeCategory(6,"Celular");
        ChargeCategory chargeCategory7 = new ChargeCategory(7,"Outro");
        
        RevenueCategory revenueCategory0 = new RevenueCategory(0,"Bolsa");
        RevenueCategory revenueCategory1 = new RevenueCategory(1,"Freelance");
        RevenueCategory revenueCategory2 = new RevenueCategory(2,"Salário");
        RevenueCategory revenueCategory3 = new RevenueCategory(3,"Outros");
        

        date = "02/02/2016";
        charge = new Charge(1,50.00, "Divida",formatDate(date) , chargeCategory7);
        user.add_charge(charge);
        addListaTest(charge.getTitle(),charge.getCategory().getName(),dateString(charge.getDatetime()),String.valueOf(charge.getValue()));
        
        date = "23/03/2016";
        charge = new Charge(2,77.10, "",formatDate(date) , chargeCategory2);
        user.add_charge(charge);
        addListaTest(charge.getTitle(),charge.getCategory().getName(),dateString(charge.getDatetime()),String.valueOf(charge.getValue()));
        
        date = "25/01/2016";
        revenue = new Revenue(1,2600, "Freela",formatDate(date) , revenueCategory1);
        user.add_revenue(revenue);
        addListaTest(revenue.getTitle(),revenue.getCategory().getName(),dateString(revenue.getDatetime()),String.valueOf(revenue.getValue()));
        
        date = "08/05/2016";
        charge = new Charge(0,50, "",formatDate(date) , chargeCategory6);
        user.add_charge(charge);
        addListaTest(charge.getTitle(),charge.getCategory().getName(),dateString(charge.getDatetime()),String.valueOf(charge.getValue()));
        
        date = "05/04/2016";
        revenue = new Revenue(0,400, "Bolsa",formatDate(date), revenueCategory0);
        user.add_revenue(revenue);
        addListaTest(revenue.getTitle(),revenue.getCategory().getName(),dateString(revenue.getDatetime()),String.valueOf(revenue.getValue()));
        
        date = "10/04/2016";
        charge = new Charge(4,11.50, "Janta",formatDate(date) , chargeCategory0);
        user.add_charge(charge);
        addListaTest(charge.getTitle(),charge.getCategory().getName(),dateString(charge.getDatetime()),String.valueOf(charge.getValue()));
        
        date = "15/04/2016";
        charge = new Charge(5,1569.0, "Alugel atrasado",formatDate(date) , chargeCategory1);
        user.add_charge(charge);
        addListaTest(charge.getTitle(),charge.getCategory().getName(),dateString(charge.getDatetime()),String.valueOf(charge.getValue()));
        
        date = "05/05/2016";
        revenue = new Revenue(2,100, "",formatDate(date) , revenueCategory3);
        user.add_revenue(revenue);
        addListaTest(revenue.getTitle(),revenue.getCategory().getName(),dateString(revenue.getDatetime()),String.valueOf(revenue.getValue()));
    }
    
    public void addListaTest(String titulo,String categoria,String data, String valor){
        String[]lista = new String[4];
        lista[0] = titulo;
        lista[1] = categoria;
        lista[2] = data;
        lista[3] = valor;
        this.listaTeste.add(lista);
    }
    
    public List<String[]> getStrings(){
        return this.listaTeste;
   
    }
    
    public String[] getStrings(int index){
        return this.listaTeste.get(index);
    }
    
    public String dateString(Date date){
        String dateString;
        String year;
        String day;
        String month;
        if(date.getYear()>=100)year = String.valueOf((date.getYear()-100));
        else year = String.valueOf(date.getYear());
        
        if(date.getDate()<10)day = "0"+String.valueOf(date.getDate());
        else day = String.valueOf(date.getDate());
        
        if(date.getMonth()<10)month = "0"+String.valueOf(date.getMonth());
        else month = String.valueOf(date.getMonth());
        
        dateString=day+"/"+month+"/"+year;
        
        return dateString;
    }
    
    public Date formatDate(String textDate){
        Date date = null;
        DateFormat format = DateFormat.getDateInstance();
        try {  
            date = format.parse(textDate);
        } catch (ParseException ex) {
           JOptionPane.showMessageDialog(null, "Informe um data no fomato DD/MM/AAAA");
        }
        return date;
    }
    
    public static void main(String[] args){
        User user = new User();
        AddTestes teste = new AddTestes(user);
    }
    
    List<String[]> listaTeste;
}
