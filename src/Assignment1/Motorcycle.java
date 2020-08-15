
package Assignment1;

/**
 * @author pujan
 * StudentId 12134829
 * Motorcycle class inherits Vehicle class and is used for motorcycle
 */
public class Motorcycle extends Vehicle{
    
    /**
     * constructor
     * @param plateNumber     // plate number of motorcycle
     * @param engineCapacity  // engine capacity of motorcycle
     * @param make            // motorcycle's brand
     * @param model           // motorcycle's model
     * @param year            // year the motorcycle was made in
     * @param ownerId         // Id of the motorcycle owner
     */
    public Motorcycle(String plateNumber, double engineCapacity, String make, String model, int year, int ownerId){
        
        // pass plateNumber, engineCapacity, make, model, year, ownerId to superclass constructor
        super(plateNumber, engineCapacity, make, model, year, ownerId);
        
     // end of constructor   
    }
    
    /**
     * toString method 
     * @return details of the motorcycle
     */
    @Override
    public String toString(){
        
        return String.format(super.toString());
    }

 // End of class
}
