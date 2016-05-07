/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import operationsapp.*;
/**
 *
 * @author matheus
 */
public class AddTestes {
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
        RevenueCategory revenueCategory1 = new RevenueCategory(0,"Freelance");
        RevenueCategory revenueCategory2 = new RevenueCategory(0,"Salário");
        RevenueCategory revenueCategory3 = new RevenueCategory(0,"Outros");
        
        charge = new Charge(7,50.00, "Ee devo ze",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , chargeCategory7);
        user.add_charge(charge);
        addListaTest(charge.getTitle(),charge.getCategory().getName(),charge.getDatetime().toString(),String.valueOf(charge.getValue()));
        
        
        charge = new Charge(9,25.10, "",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , chargeCategory0);
        user.add_charge(charge);
        addListaTest(charge.getTitle(),charge.getCategory().getName(),charge.getDatetime().toString(),String.valueOf(charge.getValue()));
        

        revenue = new Revenue(2,2600, "Freela",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , revenueCategory1);
        user.add_revenue(revenue);
        addListaTest(revenue.getTitle(),revenue.getCategory().getName(),revenue.getDatetime().toString(),String.valueOf(revenue.getValue()));
        
        charge = new Charge(1234,10.99, "",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , chargeCategory0);
        user.add_charge(charge);
        addListaTest(charge.getTitle(),charge.getCategory().getName(),charge.getDatetime().toString(),String.valueOf(charge.getValue()));
        

        revenue = new Revenue(1,200, "Bolsa",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , revenueCategory0);
        user.add_revenue(revenue);
        addListaTest(revenue.getTitle(),revenue.getCategory().getName(),revenue.getDatetime().toString(),String.valueOf(revenue.getValue()));
        
        charge = new Charge(65,11.50, "Bar da esquina",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , chargeCategory0);
        user.add_charge(charge);
        addListaTest(charge.getTitle(),charge.getCategory().getName(),charge.getDatetime().toString(),String.valueOf(charge.getValue()));
        
        charge = new Charge(23,1569.0, "Alugel",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , chargeCategory1);
        user.add_charge(charge);
        addListaTest(charge.getTitle(),charge.getCategory().getName(),charge.getDatetime().toString(),String.valueOf(charge.getValue()));
        

        revenue = new Revenue(3,100, "Zé me deve",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , revenueCategory3);
        user.add_revenue(revenue);
        addListaTest(revenue.getTitle(),revenue.getCategory().getName(),revenue.getDatetime().toString(),String.valueOf(revenue.getValue()));
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
    
    public static void main(String[] args){
        User user = new User();
        AddTestes teste = new AddTestes(user);
    }
    
    List<String[]> listaTeste;
}
