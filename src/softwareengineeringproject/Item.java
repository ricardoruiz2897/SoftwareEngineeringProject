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
    boolean isAlcohol = false;
    
    int Discount;
    int Quantity;
    
    
    public Item(){
    }
    
    public Item(String Name){
        this.Name = Name;
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
    
    public Item(String Name, double Price, boolean isAlcohol, int Discount, int Quantity){
        this.Name = Name;
        this.Price = Price;
        this.isAlcohol = isAlcohol;
        this.Discount = Discount;
        this.Quantity = Quantity;
    }
    
    public void setPrice(double Price){
        this.Price = Price;
    }
    
    public void setIsAlcohol(boolean isAlcohol){
        this.isAlcohol = isAlcohol;
    }
    
    public void setDiscount(int Discount){
        this.Discount = Discount;
    }
    
}
