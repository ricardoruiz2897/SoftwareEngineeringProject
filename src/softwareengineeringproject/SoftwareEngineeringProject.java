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

public class SoftwareEngineeringProject {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //CustomerInterface customer_interface = new CustomerInterface();
        
        //customer_interface.DisplayWelcome();
        
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.ScanItems();
        
        
        
    }
    
}
