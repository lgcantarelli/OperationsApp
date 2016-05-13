/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIv2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import operationsapp.Charge;
import operationsapp.ChargeCategory;
import operationsapp.Operation;
import operationsapp.OperationsApp;
import operationsapp.Revenue;
import operationsapp.RevenueCategory;
import operationsapp.User;

/**
 *
 * @author matheus
 */
public class FileManager {

    private String fileName = "operations.csv";
    
    public void newFile(){
        File file = new File(fileName);
        file.delete();
    }
    public User openFile(File file) throws FileNotFoundException, IOException, ParseException{
        newFile();
        File openFile = new File(fileName);
        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;
        try {
            sourceChannel = new FileInputStream(file).getChannel();
            destinationChannel = new FileOutputStream(openFile).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen())
                sourceChannel.close();
            if (destinationChannel != null && destinationChannel.isOpen())
                destinationChannel.close();
        }
        User user = new User();
        return user;
    }
    
    public void saveAsFile(File file) throws FileNotFoundException, IOException{
        File systemFile = new File(fileName);
        
        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;
        try {
            sourceChannel = new FileInputStream(systemFile).getChannel();
            destinationChannel = new FileOutputStream(file+".csv").getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen())
                sourceChannel.close();
            if (destinationChannel != null && destinationChannel.isOpen())
                destinationChannel.close();
        }
    }
    
    
}
