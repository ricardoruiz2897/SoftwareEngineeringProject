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
    
    Scanner scan = new Scanner(System.in);
    
    public ArrayList<Item> scanItems(){
        
        //We must take the items from the inventory.
        ArrayList<Item> selectedItems = new ArrayList<Item>();
        int selection;
        double total_price;
        boolean quit = false;
        
        Item item = new Item();
        
        while(true){
            
            System.out.print("1.-Milk\n.2-Sausage\n3.-BudLight\n4.-Exit\nSelect Item: ");
            
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
                    selectedItems.add(new Item("Budlight", 1.25, true));
                    item = selectedItems.get(selectedItems.size()-1);
                    System.out.println(item.Name + " " + item.Price + " is Alcohol: " + item.isAlcohol);
                    break;
                
                case 4:
                    quit = !quit;
                    break;
                
                default:
                    System.out.println("Incorrect input!");
                    break;
                
            }
            
            if(quit){ break; }
            
        }
        
        total_price = GetTotalPrice(selectedItems);
        return selectedItems;
    }
    
    public double GetTotalPrice(ArrayList<Item> scanned){
        
        double total_price = 0;
        
        for(Item item : scanned){ total_price += item.Price; }
        
        return total_price;
    
    }
    
    
}
