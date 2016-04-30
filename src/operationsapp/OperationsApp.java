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
        user.add_revenue(new Revenue(1, 2, "Teste", new Date(), revenueCategories[1]));
    }
    
}
