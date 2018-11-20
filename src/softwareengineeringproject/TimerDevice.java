/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineeringproject;

/**
 *
 * @author cmpun
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.HashMap; 
import java.util.Map; 

public class TimerDevice {
    
    Timer timer;
    
    class MakeTask extends TimerTask{

        SupermarketPrinter sprinter = new SupermarketPrinter();

        public void run(){
            
            //Only print is we are past 12:00:00 am and before 12:00:04am
            
            String DailyReport = BuildDailyReport();
            String InventoryReport = BuildInventoryReport();
            
            sprinter.PrintDailyReport(DailyReport);
            sprinter.PrintInventoryReport(InventoryReport);
            
            //Cancel current.
            timer.cancel();
            
            //Start a newone.
            TimerDevice t = new TimerDevice();
        
        }        
    }
    
    
    public TimerDevice(){
       
        int seconds = 5;
        
        timer = new Timer();
        timer.schedule(new MakeTask(), seconds);
        
    }
    
    private String BuildDailyReport(){
        
        String report =  "\n=============\n";
        
        TransactionManager transaction_manager = new TransactionManager();
        
        //Get the current date in a string.
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();  
        
        String formatted_date = formatter.format((date)); 
        
        //Get todays transactions
        ArrayList<Transaction> transactions = transaction_manager.RetriveTransactionsByDate(formatted_date);
        
        //Hashmap to store items and the amount of times they were sold for a day.
        HashMap<String, Integer> map = new HashMap<>();
        
        //Total revenue.
        double total_revenue = 0;
        
        //Get each transaction info.
        for(Transaction transaction : transactions){
            
            String[] items = transaction.processed_items.split("-");
            
            //Get the items into the hashmap, with key name of item and value the amount of times it repeats.
            for(String s : items){
                
                if(map.containsKey(s)){
                    map.put(s, map.get(s)+1);
                }else{
                    map.put(s, 1);
                }
                
            }
            
            //Update the total revenue.
             total_revenue += transaction.Total;       
            
        }
        
        
        //Make report string.
        for(String item : map.keySet()){
            
            report = "\n" +  report + item + " " + map.get(item) + "\n";
      
        }
        
        report = report + "\n  TOTAL REVENUE FOR " + formatted_date + " WAS: " + total_revenue + "\n=============\n";
        
        return report;
        
    }
    
    private String BuildInventoryReport(){
    
        String report = "";
        
        return report;
        
    }
    
}
