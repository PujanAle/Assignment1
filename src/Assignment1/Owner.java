
package Assignment1;

/**
 * @author pujan
 * StudentId 12134829
 * Abstract Owner class 
 */
public abstract class Owner{
    
    private String firstName;       // first name of owner
    private String lastName;        // last name of owner
    private int licenseNumber;     // license number which is the ID
    private String address;         // address of owner
    private String phoneNumber;        // phone no. of owner
    
    /**
     * constructor
     * @param fName first name of owner
     * @param lName last name of owner
     * @param lNumber license number which is the ID
     * @param addr address of owner
     * @param number phone no. of owner
     */
    public Owner(String fName, String lName, int lNumber, String addr, String number){
        
        firstName = fName;
        lastName = lName;
        licenseNumber = lNumber;
        address = addr;
        phoneNumber = number;

     // End of constructor
    }
    
    /**
     * setFirstName method
     * @param firstName 
     */
    public void setFirstName(String firstName){
        
        this.firstName = firstName;
    }
    
    /**
     * setLastName method
     * @param lastName 
     */
    public void setLastName(String lastName){
        
        this.lastName = lastName;
    }
    
    /**
     * setLicenseNumber method
     * @param licenseNumber 
     */
    public void setLicenseNumber(int licenseNumber){
        
        this.licenseNumber = licenseNumber;
    }
     
    /**
     * setAddress method
     * @param address 
     */
    public void setAddress(String address){
        
        this.address = address;
    }
    
    /**
     * setPhoneNumber method
     * @param phoneNumber 
     */
    public void setPhoneNumber(String phoneNumber){
        
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * getFirstName method
     * @return first name of owner
     */
    public String getFirstName(){
        
        return firstName;
    }
    
    /**
     * getLastName method
     * @return last name of owner
     */
    public String getLastName(){
        
        return lastName;
    }
    
    /**
     * getLicenseNumber method
     * @return license number of owner
     */
    public int getLicenseNumber(){
        
        return licenseNumber;
    }
    
    /**
     * getAddress method
     * @return address of owner
     */
    public String getAddress(){
        
        return address;
    }
    
    /**
     * getPhoneNumber method
     * @return phone number of owner
     */
    public String getPhoneNumber(){
        
        return phoneNumber;
    }
        
    /**
     * toString method
     * @return details of the owner
     */
    @Override
    public String toString(){
        
        return String.format("%s %s's license number is %d, address is %s and phone number is %s.", 
                firstName, lastName, licenseNumber, address, phoneNumber);
    }
    
 // End of abstract class   
}
