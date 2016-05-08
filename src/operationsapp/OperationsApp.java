/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationsapp;

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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        initialize_categories();
        
        // TODO code application logic here
        User user = new User();
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse("05/05/2016");
        Date date1 = formatter.parse("12/05/2016");
        Date date2 = formatter.parse("07/04/2016");
        Date date3 = formatter.parse("12/04/2016");
        Date date4 = formatter.parse("07/03/2016");
        Date date5 = formatter.parse("12/03/2016");
        Date date6 = formatter.parse("07/02/2016");
        Date date7 = formatter.parse("01/02/2016");        
         user.add_revenue(new Revenue(user.get_last_id(), 3, "Teste R", date1, revenueCategories.get(1)));
        /*
        user.add_revenue(new Revenue(user.get_last_id(), 3, "Teste R", date, revenueCategories.get(1)));
        user.add_revenue(new Revenue(user.get_last_id(), 4, "Teste R 1", date1, revenueCategories.get(2)));
        user.add_revenue(new Revenue(user.get_last_id(), 2, "Teste R 2 ", date2, revenueCategories.get(3)));
        user.add_revenue(new Revenue(user.get_last_id(), 5, "Teste R 3", date3, revenueCategories.get(1)));
        
        user.add_charge(new Charge(user.get_last_id(), 3, "Teste C", date4, chargeCategories.get(1)));
        user.add_charge(new Charge(user.get_last_id(), 4, "Teste C 1", date5, chargeCategories.get(2)));
        user.add_charge(new Charge(user.get_last_id(), 2, "Teste C 2 ", date7, chargeCategories.get(3)));
        user.add_charge(new Charge(user.get_last_id(), 5, "Teste C 3", date, chargeCategories.get(1)));
        
        */
        
        //user.del_operation(2);
        
        user.print_operations();
        
        /*double a[][] = user.return_line_date();
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 3; j++){
                System.out.println("Mes: "+i+" Valor: "+j+" "+a[i][j]);
            }
        }
        
 
        List<Operation> list = user.getFiltredList("05/02/2016","01/04/2016",true,true);
        
        for(int i = 0; i < list.size(); i++){
            list.get(i).toString();
        }*/
        
        /*double a[] = user.return_pizza_data("","",false,true);
        for(int i = 0; i < 12; i++){
            System.out.println("idCategoria: "+i+" Valor: "+a[i]);
            
        }
        */
        
        
        double a[][] = user.return_day_data("","", true, true);
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 3; j++){
                System.out.println("Dia: "+i+" Valor: "+j+" "+a[i][j]);
            }
        }
        
        //System.out.println(user.get_balance());
        
        //user.del_operation_by_id(4);
       //user.print_operations();
        //System.out.println(user.get_balance());
        
        //user.edit_operation(3, 10, "Teste R Editada", new Date(new Date().getTime() + (1000 * 60 * 60 * 24)), revenueCategories.get(3), null);
        //user.print_operations();
        //System.out.println(user.get_balance());
        
        //user.edit_operation(7, 10, "Teste C Editada", new Date(new Date().getTime() + (1000 * 60 * 60 * 24)), null, chargeCategories.get(1));
       // user.print_operations();
       // System.out.println(user.get_balance());
    }
    
}
