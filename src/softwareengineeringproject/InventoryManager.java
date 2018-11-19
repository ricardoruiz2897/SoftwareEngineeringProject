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

public class InventoryManager {
    
    
    ArrayList<Item> Items = new ArrayList<Item>();
    
    ItemScanner itemScanner = new ItemScanner();
    
    RestockerInterface restockerInterface = new RestockerInterface();
    
    //This is the class that talks to the "database file."
    public void StockItem(String itemName, int quantity){
        

    }
    
    public void ScanItems(){
        
        ArrayList<String> scannedItems = new ArrayList<String>();
        ArrayList<String> itemNames = new ArrayList<String>();
       
        try{
            
            //Pull the list of Items from the database, by creating an instance of Inventory.
            Inventory inventory = new Inventory("create");
            Items = inventory.getInventory();
            
            //Get the names of the items that we have in inventory.
            for(Item item : Items){
                itemNames.add(item.Name);
            }
            
            //Get the items to scan from the scanner (we receive the name of the items.)
            scannedItems = itemScanner.ScanInventoryItems(Items);
            
            for(String name : scannedItems){
                
                //Name is in the list of items that we have in inventory.
                if(itemNames.contains(name)){
                    
                    //Go to the item with that name, and get the new quantity.
                    for(Item item : Items){
                        if(item.Name.equals(name)){
                            item.Quantity += restockerInterface.getQuantity(name);
                        }
                    }
                    
                    
                }else{
                    
                    //Get the new item information.
                    String[] info = restockerInterface.getNewItemInfo(name);
                    
                    //String Name, double Price, boolean isAlcohol, int Discount, int Quantity
                    
                    double P = Double.parseDouble(info[0]);
                    int Q = Integer.parseInt(info[1]);
                    boolean Des = Boolean.parseBoolean(info[2]);
                    int Dis = Integer.parseInt(info[3]);
                    
                    Items.add(new Item(name, P, Des, Dis, Q));
                    
                    
                }
                
            }
            
            UpdateDatabase(Items);
            
        }catch(Exception E){
            System.out.println("Exception " + E.getMessage());
        }
        
    }
    
    public void UpdateDatabase(ArrayList<Item> items){
        
        Inventory inventory = new Inventory();
        inventory.UpdateInventory(items);
        
    }    
    
}
