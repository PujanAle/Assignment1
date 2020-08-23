
package Assignment1;

/**
 * @author pujan
 * StudentId 12134829
 * PrivateOwner class inherits Owner class and
 * is used for private owner of motor vehicles
 */
public class PrivateOwner extends Owner{
    
    // date of birth of owner
    private String dateOfBirth;    
    
    /**
     * constructor
     * @param fName first name of private owner
     * @param lName last name of private owner
     * @param lNumber license number of private owner
     * @param addr address of private owner
     * @param number phone number of private owner
     * @param dateOfBirth date of birth of private owner
     */
    public PrivateOwner(String fName, String lName, int lNumber, String addr, String number,String dateOfBirth){
        
        // pass fName, lName, lNumber, addr, number to the superclass constructor
        super(fName, lName, lNumber, addr, number);
        
        this.dateOfBirth = dateOfBirth;
     
     // end of constructor   
    }

    /**
     * setDateOfBirth mutator method
     * @param dateOfBirth 
     */
    public void setDateOfBirth(String dateOfBirth){
        
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     * getDateOfBirth accessor method
     * @return date of birth of private owner
     */
    public String getDateOfBirth(){
        
        return dateOfBirth;
    }
    
    /**
     * toStirng method
     * @return date of birth of private owner and other details
     */
    @Override
    public String toString(){
        
        return String.format(super.toString() + "Date of birth: %s\n\n", dateOfBirth);
    }
    
 // End of class
}
