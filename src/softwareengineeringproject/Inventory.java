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
public class Inventory {
    
    private ArrayList<Item> Items = new ArrayList<Item>(); 
    
     public Inventory(){
         
         Items.add(new Item("Milk", 3.25));
         Items.add(new Item("Sausage", 2.25));
         Items.add(new Item("BudLight", 1.25, true));
         
         
     }
     
     public ArrayList<Item> getInventory(){
         return Items;
     }
     
}
