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
public class PaymentManager {
    
    CardReader card_reader = new CardReader();
    BillCoinReader cash_reader = new BillCoinReader();
    
    AuthorizationCenterInterface auth_center = new AuthorizationCenterInterface();
    
    public String[] CardPayment(double Total){
        
        //Get the card info.
        String[] cardInfo = card_reader.GetCardInfo();
        
        //Payment info.
        String[] paymentInfo = new String[2];
        
        if(cardInfo[0] == "Debit"){
        
            int PIN = card_reader.Debit();
            
            String auth_number = auth_center.Verify(cardInfo[1], PIN, Total);
            
            if(auth_number != "-1"){
                
               paymentInfo[0] = auth_number;
               paymentInfo[1] = cardInfo[1];
               
               return paymentInfo;
                
            }else{
              
                //Payment was denied
                paymentInfo[0] = "-1";
                return paymentInfo;

            }
            
        } else if(cardInfo[0] == "Credit"){
            
           return paymentInfo;
           
        }else{
            return paymentInfo;
        }
        
    }
    
    public boolean CashPayment(double Total){
    
       return cash_reader.GetPayment(Total);
        
    }
    
}
