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
        ChargeCategory chargeCategory = new ChargeCategory();
        RevenueCategory revenueCategory = new RevenueCategory();
        Revenue revenue;
        Charge charge;
        //Revenue revenue = new Revenue(id,value,addTitle.getText(),date,category);
            //user.add_revenue(revenue);
        chargeCategory.setName("Outro");
        charge = new Charge(7,50.00, "Ee devo ze",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , chargeCategory);
        user.add_charge(charge);
        addListaTest(charge.getTitle(),charge.getCategory().getName(),charge.getDatetime().toString(),String.valueOf(charge.getValue()));
        chargeCategory.setName("Supermercado");
        charge = new Charge(9,25.10, "",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , chargeCategory);
        user.add_charge(charge);
        addListaTest(charge.getTitle(),charge.getCategory().getName(),charge.getDatetime().toString(),String.valueOf(charge.getValue()));
        revenueCategory.setName("Freelance");
        revenue = new Revenue(2,2600, "Freela",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , revenueCategory);
        user.add_revenue(revenue);
        addListaTest(revenue.getTitle(),revenue.getCategory().getName(),revenue.getDatetime().toString(),String.valueOf(revenue.getValue()));
        chargeCategory.setName("Supermercado");
        charge = new Charge(1234,10.99, "",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , chargeCategory);
        user.add_charge(charge);
        addListaTest(charge.getTitle(),charge.getCategory().getName(),charge.getDatetime().toString(),String.valueOf(charge.getValue()));
        revenueCategory.setName("Bolsa");
        revenue = new Revenue(1,200, "Bolsa",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , revenueCategory);
        user.add_revenue(revenue);
        addListaTest(revenue.getTitle(),revenue.getCategory().getName(),revenue.getDatetime().toString(),String.valueOf(revenue.getValue()));
        chargeCategory.setName("Supermercado");
        charge = new Charge(65,11.50, "Bar da esquina",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , chargeCategory);
        user.add_charge(charge);
        addListaTest(charge.getTitle(),charge.getCategory().getName(),charge.getDatetime().toString(),String.valueOf(charge.getValue()));
        chargeCategory.setName("Aluguel");
        charge = new Charge(23,1569.0, "Alugel",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , chargeCategory);
        user.add_charge(charge);
        addListaTest(charge.getTitle(),charge.getCategory().getName(),charge.getDatetime().toString(),String.valueOf(charge.getValue()));
        revenueCategory.setName("Outros");
        revenue = new Revenue(3,100, "Zé me deve",new Date(new Date().getTime() + (1000 * 60 * 60 * 24)) , revenueCategory);
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
