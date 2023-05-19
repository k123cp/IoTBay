public class Payment{
    private String name;
    private String phoneNumber;
    private String cardNumber;
    private String expirationDate;
    private String securityCode;
    private String postalCode;
    
    public Payment(String name, String phoneNumber, String cardNumber, String expirationDate, String securityCode, String postalCode){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        this.postalCode = postalCode;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public String getCardNumber(){
        return cardNumber;
    }
    
    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }
    
    public String getExpirationDate(){
        return expirationDate;
    }
    
    public void setExpirationDate(String expirationDate){
        this.expirationDate = expirationDate;
    }
    
    public String getSecurityCode(){
        return securityCode;
    }
    
    public void setSecurityCode(String securityCode){
        this.securityCode = securityCode;
    }
    
    public String getPostalCode(){
        return postalCode;
    }
    
    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
}
