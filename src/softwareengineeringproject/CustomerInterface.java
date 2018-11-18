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

import java.util.Scanner;
import java.util.ArrayList;

public class CustomerInterface {
    
    CheckOutManager checkout_manager = new CheckOutManager();
    
    public void DisplayWelcome(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        
        System.out.print("Press 1 to Start Checkout: \n");
        int input = scan.nextInt();
        
        if(input == 1){
            ScanItems();
        }
      
    }
    
    public void ScanItems(){
       
        System.out.println("Please scan items: ");       
        checkout_manager.RequestScanItems();
        
    }
    
    public void DisplayScannedItems(ArrayList<Item> items){
        
        for(Item i : items){ System.out.println(i.Name + " " + i.Price); }
           
    }
    
    public void DisplayTotal(double total_price){
        System.out.println("The total price is: " + total_price);
    }
    
    public int Request_Payment(){
        
        System.out.print("Select Payment Method:\n"
                + "1.-Credit\n2.-Debit\n3.-Cash\nSelect: ");
        
        int input = scan.nextInt();
        
        return input;
    }
   
}
