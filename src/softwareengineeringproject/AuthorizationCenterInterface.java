/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareengineeringproject;

/**
 *
 * Ricardo Ruiz R11476487
 * Arusha Herath R11473911
 * Sterling Collin R11334958
 * Merrell Reed R00894900
 *
 */

import java.util.Scanner;
public class AuthorizationCenterInterface {
    
    
    public String Verify(String cardNumber, int PIN, double Total){
        
        Scanner scan = new Scanner(System.in);
        int approval;
        String auth_number = new String();

        if(PIN != 0){
            System.out.print("\nIs this info correct?\n"
                + "Debit Cardnumber: " + cardNumber + "\n"
                    + "PIN: " + PIN + "\n"
                            + "Total: " + (Total + (Total * 0.08f)));
        }else{
            System.out.print("\nIs this info correct?\n"
                + "Credit Cardnumber: " + cardNumber + "\n"
                            + "Total: " + (Total + (Total * 0.08f)));
        }
        
        System.out.print("\n1.Approve\n2.Deny\nSelect an option: ");
       
        approval = scan.nextInt();
        
        if(approval == 1){
            
            System.out.print("Enter authorization number: ");
            auth_number = scan.next();
            
            return auth_number;
            
        }else{
            
            return "-1";
            
        }
        
    }
    
}
