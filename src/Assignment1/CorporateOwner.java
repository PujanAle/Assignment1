
package Assignment1;

/**
 * @author pujan
 * StudentId 12134829
 * CorporateOwner class extends Owner class and 
 * is used for the corporate motor vehicle owner
 */
public class CorporateOwner extends Owner{
    
    // Australian Business Number of corporate owner
    private int australianBusinessNumber;

    /**
     * constructor
     * @param fName first name of corporate owner
     * @param lName last name of corporate owner
     * @param lNumber license number of corporate owner
     * @param addr address of corporate owner
     * @param number phone number of corporate owner
     * @param abn Australian Business Number of corporate owner
     */
    public CorporateOwner(String fName, String lName, int lNumber, String addr, String number, int abn){
        
        // pass fName, lName, lNumber, addr, number to superclass constructor
        super(fName, lName, lNumber, addr, number);
        
        australianBusinessNumber = abn;
    }
    
    /**
     * setAustralianBusinessNumber mutator method
     * @param abn 
     */
    public void setAustralianBusinessNumber(int abn){
        
        australianBusinessNumber = abn;
    }
    
    /**
     * 
     * @return 
     */
    public int getAustralianBusinessNumber(){
        
        return australianBusinessNumber;
    }
    
    /**
     * toString method
     * @return Details of corporate owner along with their ABN
     */
    @Override
    public String toString(){
        
        return String.format(super.toString() + 
                " Their Australian Business Number is %d.", australianBusinessNumber);
    }
    
 // End of class
}
