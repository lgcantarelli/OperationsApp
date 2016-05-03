/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationsapp;

import java.util.Date;
import java.util.List;

public class OperationsApp {
    private static List<ChargeCategory> chargeCategories;
    private static List<RevenueCategory> revenueCategories;
    
    private void initialize_categories(){
        chargeCategories.add(new ChargeCategory(1,"Supermecado"));
        chargeCategories.add(new ChargeCategory(2,"Aluguel"));
        chargeCategories.add(new ChargeCategory(3,"Luz"));
        chargeCategories.add(new ChargeCategory(4,"Água"));
        chargeCategories.add(new ChargeCategory(5,"Telefone"));
        chargeCategories.add(new ChargeCategory(6,"Internet"));
        chargeCategories.add(new ChargeCategory(7,"Celular"));
        
        revenueCategories.add(new RevenueCategory(8,"Salário"));
        revenueCategories.add(new RevenueCategory(9,"Bolsa"));
        revenueCategories.add(new RevenueCategory(10,"Freelance"));
        revenueCategories.add(new RevenueCategory(11,"Outros"));
    }
    
    private ChargeCategory getChargeCategory(int id){
        for(int i = 0; i < chargeCategories.size(); i++){
            if(chargeCategories.get(i).getId() == id){
                return chargeCategories.get(i);
            }
        }
        return null;
    }
    
    private ChargeCategory getChargeCategory(String name){
        for(int i = 0; i < chargeCategories.size(); i++){
            if(chargeCategories.get(i).getName().equals(name)){
                return chargeCategories.get(i);
            }
        }
        return null;
    }
    
    private RevenueCategory getRevenueCategory(int id){
        for(int i = 0; i < revenueCategories.size(); i++){
            if(revenueCategories.get(i).getId() == id){
                return revenueCategories.get(i);
            }
        }
        return null;
    }
    
    private RevenueCategory getRevenueCategory(String name){
        for(int i = 0; i < revenueCategories.size(); i++){
            if(revenueCategories.get(i).getName().equals(name)){
                return revenueCategories.get(i);
            }
        }
        return null;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        User user = new User();
        user.add_revenue(new Revenue(user.get_last_id(), 3, "Teste R", new Date(new Date().getTime() + (1000 * 60 * 60 * 24)), revenueCategories.get(1)));
        user.add_revenue(new Revenue(user.get_last_id(), 4, "Teste R 1", new Date(new Date().getTime() + (1000 * 60 * 60 * 24)), revenueCategories.get(2)));
        user.add_revenue(new Revenue(user.get_last_id(), 2, "Teste R 2 ", new Date(), revenueCategories.get(3)));
        user.add_revenue(new Revenue(user.get_last_id(), 5, "Teste R 3", new Date(new Date().getTime() - (1000 * 60 * 60 * 24)), revenueCategories.get(1)));
        
        System.out.println(user.get_balance());
        
        user.add_charge(new Charge(user.get_last_id(), 3, "Teste C", new Date(new Date().getTime() + (1000 * 60 * 60 * 24)), chargeCategories.get(1)));
        user.add_charge(new Charge(user.get_last_id(), 4, "Teste C 1", new Date(new Date().getTime() + (1000 * 60 * 60 * 24)), chargeCategories.get(2)));
        user.add_charge(new Charge(user.get_last_id(), 2, "Teste C 2 ", new Date(), chargeCategories.get(3)));
        user.add_charge(new Charge(user.get_last_id(), 5, "Teste C 3", new Date(new Date().getTime() - (1000 * 60 * 60 * 24)), chargeCategories.get(1)));
        user.print_operations();
        
        System.out.println(user.get_balance());
        
        user.del_operation(2);
        
        user.print_operations();
        System.out.println(user.get_balance());
        
        user.del_operation_by_id(4);
        user.print_operations();
        System.out.println(user.get_balance());
        
        user.edit_operation(3, 10, "Teste R Editada", new Date(new Date().getTime() + (1000 * 60 * 60 * 24)), revenueCategories.get(3), null);
        user.print_operations();
        System.out.println(user.get_balance());
        
        user.edit_operation(7, 10, "Teste C Editada", new Date(new Date().getTime() + (1000 * 60 * 60 * 24)), null, chargeCategories.get(1));
        user.print_operations();
        System.out.println(user.get_balance());
    }
    
}
