
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
     * setFirstName mutator method
     * @param firstName 
     */
    public void setFirstName(String firstName){
        
        this.firstName = firstName;
    }
    
    /**
     * setLastName mutator method
     * @param lastName 
     */
    public void setLastName(String lastName){
        
        this.lastName = lastName;
    }
    
    /**
     * setLicenseNumber mutator method
     * @param licenseNumber 
     */
    public void setLicenseNumber(int licenseNumber){
        
        this.licenseNumber = licenseNumber;
    }
     
    /**
     * setAddress mutator method
     * @param address 
     */
    public void setAddress(String address){
        
        this.address = address;
    }
    
    /**
     * setPhoneNumber mutator method
     * @param phoneNumber 
     */
    public void setPhoneNumber(String phoneNumber){
        
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * getFirstName accessor method
     * @return first name of owner
     */
    public String getFirstName(){
        
        return firstName;
    }
    
    /**
     * getLastName accessor method
     * @return last name of owner
     */
    public String getLastName(){
        
        return lastName;
    }
    
    /**
     * getLicenseNumber accessor method
     * @return license number of owner
     */
    public int getLicenseNumber(){
        
        return licenseNumber;
    }
    
    /**
     * getAddress accessor method
     * @return address of owner
     */
    public String getAddress(){
        
        return address;
    }
    
    /**
     * getPhoneNumber accessor method
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
        
        return String.format("%s %s has been registered with the following details: \n"
                            + "Licence Number: %d\n"
                            + "Address: %s\n"
                            + "Phone number: %s\n", firstName, lastName, licenseNumber, address, phoneNumber);
        
    }
    
 // End of abstract class   
}
