/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineeringproject;
import java.util.Scanner;
/**
 *
 * @author cmpun
 */
public class CustomerInterface {
    
    Scanner scan = new Scanner(System.in);
    
    ItemScanner itemScanner = new ItemScanner();
    
    public void DisplayWelcome(){
        
        System.out.println("Welcome!");
        
        System.out.print("Press 1 to Start Checkout,\n");
        int input = scan.nextInt();
        
        if(input == 1){
            ScanItems();
        }
      
    }
    
    public void ScanItems(){
       
        System.out.print("Please scan items: ");
                
        itemsScanner.scanItems();
        
    }
   
}
