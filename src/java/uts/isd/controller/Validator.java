/**
 * Author:  John
 * Created: 18 May 2023
 */
package uts.isd.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator implements Serializable{ 
 
   private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z0-9]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)"; 
   private String staffEmailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)(iotbay)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
   private String namePattern = "([A-Za-z]+)"; 
   private String passwordPattern = "[a-zA-Z0-9.@&%$#!*]{4,}";
   private String phonePattern = "([0-9]{10})";   
   private String staffNoPattern = "(S[0-9]+)";

   
   private String IDPattern = "[0-9]+";
   private String datePattern = "^([0-9]{4}-[0-9]{2}-[0-9]{2})$";

   private String productNamePattern = "([A-Za-z0-9\\- ]+)";
   private String descriptionPattern = "([A-Za-z0-9\\- .:,()@&%$#!*\"'?<>^%]+)";
   private String pricePattern = "^([0-9]+(\\.[0-9]{1,2})?)$";
   private String stockPattern = "([0-9]+)";
   private String categoryPattern = "([A-Za-z/\\ ]+)"; 
   
   private String cardNoPattern = "[0-9]{16}";
   private String cardTypePattern = "^(Mastercard|Visa|AMEX)$";
   private String expiryDatePattern = "^([0-9]{4}-[0-9]{2})$";
   private String cvvPattern = "[0-9]{3,4}";
   
   private String addressNoPattern = "([a-zA-Z0-9]+)";
   private String streetPattern = "([a-zA-Z .]+)";
   private String statePattern = "^(ACT|NSW|NT|QLD|SA|TAS|VIC|WA)$";
   private String postCodePattern = "([0-9]+)";
   private String deliveryMethodPattern = "^(express|standard)$";
   private String deliveryInstructionsPattern = "[a-zA-Z0-9.@&%$#!* \"'?<>;:^()-+=_]+";
              
   public Validator(){    }       

   public boolean validate(String pattern, String input){       
      Pattern regEx = Pattern.compile(pattern);       
      Matcher match = regEx.matcher(input);       
      return match.matches(); 
   }       

   public boolean checkEmpty(String email, String password){       
      return  email.isEmpty() || password.isEmpty();   
   }

   public boolean validateEmail(String email){                       
      return validate(emailPattern,email);   
   }
   
   public boolean validateStaffEmail(String email){                       
      return validate(staffEmailPattern,email);   
   }
       
   public boolean validateName(String name){
      return validate(namePattern,name); 
   }       
   
   public boolean validatePassword(String password){
      return validate(passwordPattern,password); 
   }          
   
    public boolean validatePhone(String phoneNumber) {
     return validate(phonePattern, phoneNumber);
   }
    
   public boolean validateStaffNo(String staffNo) {
       return validate(staffNoPattern, staffNo);
   }
   

   public boolean validateID(String ID) {
       return validate(IDPattern, ID);
   }
   
   public boolean validateDate(String date) {
       return validate(datePattern, date);
   }
       
   public boolean validateProductName(String productName){
       return validate(productNamePattern,productName);
   }
   
   public boolean validateDescription(String description){
       return validate(descriptionPattern,description);
   }
   
   public boolean validatePrice(String price){
       return validate(pricePattern,price);
   }
   
   public boolean validateStock(String stock){
       return validate(stockPattern,stock);
   }
   
   public boolean validateCategory(String category){
       return validate(categoryPattern,category);
   }
   
   public boolean validateCardNo(String cardNo){
       return validate(cardNoPattern,cardNo);
   }
   
   public boolean validateCardType(String cardType){
       return validate(cardTypePattern,cardType);
   }
   
   public boolean validateExpiryDate(String expiryDate){
       return validate(expiryDatePattern,expiryDate);
   }
   
   public boolean validateCVV(String cvv){
       return validate(cvvPattern,cvv);
   }           
   
   public boolean validateAddressNo(String addressNo){
       return validate(addressNoPattern,addressNo);
   }
   
   public boolean validateStreet(String street){
       return validate(streetPattern,street);
   }
   
   public boolean validateState(String state){
       return validate(statePattern,state);
   }
   
   public boolean validatePostcode(String postcode){
       return validate(postCodePattern,postcode);
   }
   
   public boolean validateDeliveryMethod(String deliveryMethod){
       return validate(deliveryMethodPattern,deliveryMethod);
   }
   
   public boolean validateDeliveryInstructions(String deliveryInstructions){
       return validate(deliveryInstructionsPattern,deliveryInstructions);
   }
   
}