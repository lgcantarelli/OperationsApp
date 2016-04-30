/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationsapp;

import java.util.Date;

public class OperationsApp {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ChargeCategory[] chargeCategories;
        chargeCategories = new ChargeCategory[7];
        chargeCategories[0] = new ChargeCategory("Supermecado");
        chargeCategories[1] = new ChargeCategory("Aluguel");
        chargeCategories[2] = new ChargeCategory("Luz");
        chargeCategories[3] = new ChargeCategory("Água");
        chargeCategories[4] = new ChargeCategory("Telefone");
        chargeCategories[5] = new ChargeCategory("Internet");
        chargeCategories[6] = new ChargeCategory("Celular");
        
        RevenueCategory[] revenueCategories;
        revenueCategories = new RevenueCategory[4];
        revenueCategories[0] = new RevenueCategory("Salário");
        revenueCategories[1] = new RevenueCategory("Bolsa");
        revenueCategories[2] = new RevenueCategory("Freelance");
        revenueCategories[3] = new RevenueCategory("Outros");
        
        User user = new User();
        user.add_revenue(new Revenue(user.get_last_id(), 3, "Teste R", new Date(new Date().getTime() + (1000 * 60 * 60 * 24)), revenueCategories[1]));
        user.add_revenue(new Revenue(user.get_last_id(), 4, "Teste R 1", new Date(new Date().getTime() + (1000 * 60 * 60 * 24)), revenueCategories[2]));
        user.add_revenue(new Revenue(user.get_last_id(), 2, "Teste R 2 ", new Date(), revenueCategories[3]));
        user.add_revenue(new Revenue(user.get_last_id(), 5, "Teste R 3", new Date(new Date().getTime() - (1000 * 60 * 60 * 24)), revenueCategories[1]));
        
        System.out.println(user.get_balance());
        
        user.add_charge(new Charge(user.get_last_id(), 3, "Teste C", new Date(new Date().getTime() + (1000 * 60 * 60 * 24)), chargeCategories[1]));
        user.add_charge(new Charge(user.get_last_id(), 4, "Teste C 1", new Date(new Date().getTime() + (1000 * 60 * 60 * 24)), chargeCategories[2]));
        user.add_charge(new Charge(user.get_last_id(), 2, "Teste C 2 ", new Date(), chargeCategories[3]));
        user.add_charge(new Charge(user.get_last_id(), 5, "Teste C 3", new Date(new Date().getTime() - (1000 * 60 * 60 * 24)), chargeCategories[1]));
        user.print_operations();
        
        System.out.println(user.get_balance());
        
        user.del_operation(2);
        
        user.print_operations();
        System.out.println(user.get_balance());
        
        user.del_operation_by_id(4);
        user.print_operations();
        System.out.println(user.get_balance());
        
        user.edit_operation(3, 10, "Teste R Editada", new Date(new Date().getTime() + (1000 * 60 * 60 * 24)), revenueCategories[3], null);
        user.print_operations();
        System.out.println(user.get_balance());
        
        user.edit_operation(7, 10, "Teste C Editada", new Date(new Date().getTime() + (1000 * 60 * 60 * 24)), null, chargeCategories[1]);
        user.print_operations();
        System.out.println(user.get_balance());
    }
    
}
