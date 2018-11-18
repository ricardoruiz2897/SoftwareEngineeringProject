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

public class CheckOutManager {
    
    ItemScanner itemScanner = new ItemScanner();
    CustomerInterface customer_interface;
    PaymentManager paymentManager = new PaymentManager();
    ReceiptPrinter receiptPrinter = new ReceiptPrinter();
 
    
    ArrayList<Item> scanned_items = new ArrayList<Item>();
    //1-credit, 2-debit, 3-cash
    int payment_method;
    
    public void RequestScanItems(){
        
        double Total;
        
        //Get scanned items.
        scanned_items = itemScanner.scanItems();
        
        //Show the scanned items in the customer interface.
        customer_interface.DisplayScannedItems(scanned_items);
        
        //Get total price.
        Total = Get_Total(scanned_items);
        
        //Display the total.
        customer_interface.DisplayTotal(Total);
        
        //Request Payment
        payment_method = customer_interface.Request_Payment();
        
        //Print receipt.
        receiptPrinter.PrintReceipt(scanned_items, Total);
        
    }
    
    public double Get_Total(ArrayList<Item> items){
        
        double total_price= 0;
        
        for(Item i : items){ total_price += i.Price; }
        
        return total_price;
        
    }
    
    
}
