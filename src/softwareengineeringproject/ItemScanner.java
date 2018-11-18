/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineeringproject;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author cmpun
 */
public class ItemScanner {
        
    ArrayList<Item> selectedItems = new ArrayList<Item>();   

    public ArrayList<Item> scanItems(){
        
        Scanner scan = new Scanner(System.in);
        CashierInterface cashier = new CashierInterface();
        
        //We must take the items from the inventory.
        int selection;
        boolean quit = false;
        
        Item item;
        
        while(true){
                 
            System.out.print("1.-Milk\n2-Sausage\n3.-BudLight\n4.-Subtotal\n5.-Total\n6.-Cancel CheckOut\nSelect Item: ");
            
            selection = scan.nextInt();
            
            switch(selection){
                
                case 1:  
                    selectedItems.add(new Item("Milk", 3.25));
                    item = selectedItems.get(selectedItems.size()-1);
                    System.out.println(item.Name + " " + item.Price);
                    break;
                
                case 2:
                    selectedItems.add(new Item("Sausage", 2.25));
                    item = selectedItems.get(selectedItems.size()-1);
                    System.out.println(item.Name + " " + item.Price);
                    break;
                    
                case 3:
                    
                    //Get the confirmation from the cashier.
                    if(cashier.Confirmation()){
                        
                        selectedItems.add(new Item("Budlight", 1.25, true));
                        item = selectedItems.get(selectedItems.size()-1);
                        System.out.println(item.Name + " " + item.Price + " is Alcohol: " + item.isAlcohol);
                    
                    }
                    
                    break;
                
                case 4:
                    GetSubtotalPrice(selectedItems);
                    break;
                    
                case 5:
                    quit = !quit;
                    break;
                
                case 6:
                    System.out.println("Transaction terminated...");
                    return null;
                
                default:
                    System.out.println("Incorrect input!");
                    break;
                
            }
            
            if(quit){ break; }
            
        }
                
        return selectedItems;
        
    }
    
    public void GetSubtotalPrice(ArrayList<Item> scanned){
        
        double total_price = 0;
        
        for(Item item : scanned){ 
            
            System.out.println(item.Name);
            
            total_price += item.Price; 
        }
        

        
        System.out.println("\nThe subtotal is: " + total_price + "\n");
    
    }
    
    
    //This method return name of items that we are going to restock.
    public ArrayList<String> ScanInventoryItems(ArrayList<Item> inventoryItems){
        
        Scanner scan = new Scanner(System.in);
        
        //Item to be restocked.
        ArrayList<String> names = new ArrayList<String>();
        String restockedItemName;
        int exit;
        
        while(true){
            
            //Show the items of the inventory.. Name - Quantity.
            for(Item item : inventoryItems){
                System.out.println(item.Name + " " + item.Quantity);
            }
        
            System.out.print("Enter Name of item to be restocked: ");
            restockedItemName = scan.next();
            names.add(restockedItemName);
            
            System.out.print("Enter 1 to exit, 2 to continue");
            exit = scan.nextInt();
            
            if(exit == 1){
                break;
            }
            
        }
        
        return names;
        
    }
    
}
