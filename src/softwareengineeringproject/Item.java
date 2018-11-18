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
public class Item {
    
    String Name;
    double Price;
    
    //Is alcohol if true.
    public static boolean isAlcohol = false;
    
    public Item(){
    }
    
    public Item(String Name, double Price){
        this.Name = Name;
        this.Price = Price;
    }
    
    public Item(String Name, double Price, boolean isAlcohol){
        this.Name = Name;
        this.Price = Price;
        this.isAlcohol = isAlcohol;
        
    }
}
