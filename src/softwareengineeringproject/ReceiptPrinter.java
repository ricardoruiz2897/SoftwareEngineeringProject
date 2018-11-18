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

import java.util.ArrayList;

public class ReceiptPrinter {
    
    public void PrintReceipt(ArrayList<Item> scannedItems, double Total){
        
        //Total with tax
        double tax_total = Total + (Total * 0.08f);
        
        System.out.println("--------------------");
        
        //First print the items
        for(Item i : scannedItems){ System.out.println(i.Name + " " + i.Price); }
        
        //---------
        System.out.println("=====================");
        
        System.out.println("Subtotal: " + Total);
        System.out.println("Tax: " + (Total * 0.08f));
        System.out.println("Total: " + tax_total);
        
    }
    
}
