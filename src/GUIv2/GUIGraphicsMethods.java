/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIv2;

import GUI.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import operationsapp.User;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author matheus
 */
public class GUIGraphicsMethods {
    
    public void initiateGraphics(User user, javax.swing.JPanel panelAnualGraphics,javax.swing.JPanel panelCategoryGraphics, javax.swing.JPanel panelDailyGraphics){
        buildAnualChart(user,panelAnualGraphics);
        updateGraphics(user,panelCategoryGraphics,panelDailyGraphics);
    
    }
    
    public void buildDailyChart(double data[][], javax.swing.JPanel panel) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (int i = 0; i < data.length; i++) {      
            dataset.addValue(data[i][0], "Receita", Integer.toString(i+1));
            dataset.addValue(data[i][1], "Custo", Integer.toString(i+1));
            dataset.addValue(data[i][2], "Saldo", Integer.toString(i+1));   
        }      
        
        JFreeChart dailychart = ChartFactory.createLineChart(
            "Gráfico diário",
            "Dia",
            "R$",
            dataset,
            PlotOrientation.VERTICAL,
            true, // legend?
            true, // tooltips?
            false // URLs?
        );

        ChartFrame frame = new ChartFrame("DailyChart", dailychart);
        frame.pack();
        frame.setSize(panel.getSize()); 
        
        panel.removeAll();
        panel.add(frame.getChartPanel(), BorderLayout.CENTER);
        panel.validate();
   }
    
    public void buildAnualChart(User user,javax.swing.JPanel panel) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        double [][] operationsData = user.return_line_data();
         
       for (int i = -11; i <= 0; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.MONTH, i);
            
            String month = new SimpleDateFormat("MMM").format(calendar.getTime());
            int monthNumber = Math.abs(i);
            
            data.addValue(operationsData[monthNumber][0], "Receita", month);
            data.addValue(operationsData[monthNumber][1], "Custo", month);
            data.addValue(operationsData[monthNumber][2], "Saldo", month);
        }

        JFreeChart chart = ChartFactory.createLineChart(
            "Últimos 12 meses",
            "Meses",
            "R$",
            data,
            PlotOrientation.VERTICAL,
            true, // legend?
            true, // tooltips?
            false // URLs?
        );

        ChartFrame frame = new ChartFrame("My chart", chart);
        frame.pack();
        frame.setSize(panel.getSize());
        panel.removeAll();
        panel.add(frame.getChartPanel(), BorderLayout.CENTER);
        panel.validate();
   }
    
    
    public void buildPieChart(double data[],javax.swing.JPanel panel) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        if(data[1]!=0){
            dataset.setValue("Supermercado",data[1]);
        }
        if(data[2]!=0){
            dataset.setValue("Aluguel",data[2]);
        }
        if(data[3]!=0){
            dataset.setValue("Luz",data[3]);
        }
        if(data[4]!=0){
            dataset.setValue("Agua",data[4]);
        }
        if(data[5]!=0){
            dataset.setValue("Telefone",data[5]);
        }
        if(data[6]!=0){
            dataset.setValue("Internet",data[6]);
        }
        if(data[7]!=0){
            dataset.setValue("Celular",data[7]);
        }
        if(data[8]!=0){
            dataset.setValue("Salario",data[8]);
        }
        if(data[9]!=0){
            dataset.setValue("Bolsa",data[9]);
        }
        if(data[10]!=0){
            dataset.setValue("Freelance",data[10]);
        }
        if(data[11]!=0){
            dataset.setValue("Outro",data[11]);
        }
        if(data[12]!=0){
            dataset.setValue("Outro",data[12]);
        }
    
        JFreeChart chart = ChartFactory.createPieChart(
            "Custos por categoria",  // chart title
            dataset,            // data
            false,              // no legend
            true,               // tooltips
            false               // no URL generation
        );
        
        ChartFrame frame = new ChartFrame("Pie Chart", chart);
        frame.pack();
        frame.setSize(panel.getSize());
        
        panel.removeAll();
        //panelPieGraph.setPreferredSize(new Dimension(350,350));
        panel.add(frame.getChartPanel(), BorderLayout.CENTER);
        panel.validate();
    }
    
    public void updateGraphics(User user,javax.swing.JPanel panelCategory, javax.swing.JPanel panelDaily){
        try {
            double data[]= user.return_pizza_data("", "", true, true);
            buildPieChart(data,panelCategory);
            double daydata[][]= user.return_day_data("", "", false, true);
            buildDailyChart(daydata,panelDaily); 
        } catch (ParseException ex) {
            Logger.getLogger(GUIGraphicsMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void filterGraphicsChargeDate(User user,javax.swing.JPanel panelCategory, javax.swing.JPanel panelDaily, String from, String until){
        double[] data = null;
        try {
            data = user.return_pizza_data(from, until, false, true);
        } catch (ParseException ex) {
            Logger.getLogger(GUIGraphicsMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        double[][] daydata = null;
        try {
            daydata = user.return_day_data(from, until, false, true);
        } catch (ParseException ex) {
            Logger.getLogger(GUIGraphicsMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        buildDailyChart(daydata,panelDaily);
        buildPieChart(data,panelCategory);
    }
    
    public void filterGraphicsCharge(User user,javax.swing.JPanel panelCategory, javax.swing.JPanel panelDaily, String from, String until){
        
        try {
            double data[]= user.return_pizza_data("", "", false, true);
            buildPieChart(data,panelCategory);
            double daydata[][]= user.return_day_data("", "", false, true);
            buildDailyChart(daydata,panelDaily);
            
        } catch (ParseException ex) {
            Logger.getLogger(GUIHome.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    public void filterGraphicsRevenueDate(User user,javax.swing.JPanel panelCategory, javax.swing.JPanel panelDaily, String from, String until){
        double[] data = null;
        try {
            data = user.return_pizza_data(from, until, true, false);
        } catch (ParseException ex) {
            Logger.getLogger(GUIGraphicsMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        buildPieChart(data,panelCategory);
        double daydata[][] = null;
        try {
            daydata = user.return_day_data(from, until, true, false);
        } catch (ParseException ex) {
            Logger.getLogger(GUIGraphicsMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        buildDailyChart(daydata,panelDaily);
    }
    
    public void filterGraphicsRevenue(User user,javax.swing.JPanel panelCategory, javax.swing.JPanel panelDaily, String from, String until){
        double data[] = null;
        try {
            data = user.return_pizza_data("", "",true, false);
        } catch (ParseException ex) {
            Logger.getLogger(GUIGraphicsMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        buildPieChart(data,panelCategory);
        double daydata[][] = null;
        try {
            daydata = user.return_day_data("", "",true, false);
        } catch (ParseException ex) {
            Logger.getLogger(GUIGraphicsMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        buildDailyChart(daydata,panelDaily);
    }
    
    public void filterGraphicsDate(User user,javax.swing.JPanel panelCategory, javax.swing.JPanel panelDaily, String from, String until){
        double[] data = null;
        try {
            data = user.return_pizza_data(from,until, true, true);
        } catch (ParseException ex) {
            Logger.getLogger(GUIGraphicsMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        double[][] daydata = null;
        try {
            daydata = user.return_day_data(from, until, true, true);
        } catch (ParseException ex) {
            Logger.getLogger(GUIGraphicsMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        buildPieChart(data,panelCategory);
        buildDailyChart(daydata,panelDaily);
    }
}
