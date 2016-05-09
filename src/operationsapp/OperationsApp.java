/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationsapp;

import GUI.GUIHome;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationsApp {
    public static List<ChargeCategory> chargeCategories;
    public static List<RevenueCategory> revenueCategories;
    
    public static void initialize_categories(){
        chargeCategories = new ArrayList<ChargeCategory>();
        revenueCategories = new ArrayList<RevenueCategory>();
        
        chargeCategories.add(new ChargeCategory(1,"Supermercado"));
        chargeCategories.add(new ChargeCategory(2,"Aluguel"));
        chargeCategories.add(new ChargeCategory(3,"Luz"));
        chargeCategories.add(new ChargeCategory(4,"Água"));
        chargeCategories.add(new ChargeCategory(5,"Telefone"));
        chargeCategories.add(new ChargeCategory(6,"Internet"));
        chargeCategories.add(new ChargeCategory(7,"Celular"));
        chargeCategories.add(new ChargeCategory(12,"Outros"));
        
        revenueCategories.add(new RevenueCategory(8,"Salário"));
        revenueCategories.add(new RevenueCategory(9,"Bolsa"));
        revenueCategories.add(new RevenueCategory(10,"Freelance"));
        revenueCategories.add(new RevenueCategory(11,"Outros"));
    }
    
    public static ChargeCategory getChargeCategory(int id){
        for(int i = 0; i < chargeCategories.size(); i++){
            if(chargeCategories.get(i).getId() == id){
                return chargeCategories.get(i);
            }
        }
        return null;
    }
    
    public static ChargeCategory getChargeCategory(String name){
        for(int i = 0; i < chargeCategories.size(); i++){
            if(chargeCategories.get(i).getName().equals(name)){
                return chargeCategories.get(i);
            }
        }
        return null;
    }
    
    public static RevenueCategory getRevenueCategory(int id){
        for(int i = 0; i < revenueCategories.size(); i++){
            if(revenueCategories.get(i).getId() == id){
                return revenueCategories.get(i);
            }
        }
        return null;
    }
    
    public static RevenueCategory getRevenueCategory(String name){
        for(int i = 0; i < revenueCategories.size(); i++){
            if(revenueCategories.get(i).getName().equals(name)){
                return revenueCategories.get(i);
            }
        }
        return null;
    }
    
    public static RevenueCategory getRevenueCategory1(int id){
        for(int i = 0; i < revenueCategories.size(); i++){
            if(revenueCategories.get(i).getId() == id){
                return revenueCategories.get(i);
            }
        }
        return null;
    }
    public List<RevenueCategory> getRevenueCategory(){
        List<RevenueCategory> listRevenueCategories = new ArrayList();
        for(int i = 0; i < revenueCategories.size(); i++){
            listRevenueCategories.add(revenueCategories.get(i));
          }
        return listRevenueCategories;
    }
        
    public List<ChargeCategory> getChargeCategory(){
        List<ChargeCategory> listChargeCategory = new ArrayList();
        for(int i = 0; i < chargeCategories.size(); i++){
            listChargeCategory.add(chargeCategories.get(i));
          }
        return listChargeCategory;
    }
    public List<String> getlistRevenueCategory(){
        List<String> listRevenueCategory = new ArrayList();
        for(int i=0;i<revenueCategories.size();i++){
            listRevenueCategory.add(revenueCategories.get(i).getName());
        }
        return listRevenueCategory;
    }
    
     public List<String> getlistChargeCategory(){
        List<String> listChargeCategory = new ArrayList();
        for(int i=0;i<chargeCategories.size();i++){
            listChargeCategory.add(chargeCategories.get(i).getName());
        }
        return listChargeCategory;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        OperationsApp op = new OperationsApp();
        op.initialize_categories();
        
        // TODO code application logic here
        User user = new User();
     //   List<String>getlistChargeCategory =op.getlistChargeCategory();
                
     //   GUIHome gui = new GUIHome(user,op.getlistChargeCategory(),op.getlistRevenueCategory());
        GUIHome gui = new GUIHome(user,op);
        gui.setVisible(true);
    }
    
}
