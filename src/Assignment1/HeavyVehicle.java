
package Assignment1;

/**
 * @author pujan
 * StudentId 12134829
 * HeavyVehicle class inherits Vehicle superclass and
 * is used for heavy category of vehicle
 */
public class HeavyVehicle extends Vehicle{
    
    // load capacity of heavy vehicle
    private double loadCapacity;
    
    /**
     * constructor
     * @param plateNumber      // heavy vehicle's plate number 
     * @param engineCapacity   // heavy vehicle's engine capacity
     * @param make             // heavy vehicle's brand
     * @param model            // heavy vehicle's model
     * @param year             // year the heavy vehicle was made in
     * @param ownerId          // Id of owner of heavy vehicle
     * @param loadCapacity     // heavy vehicle's load capacity
     */
    public HeavyVehicle(String plateNumber, double engineCapacity, String make, String model, int year, int ownerId, double loadCapacity){
        
        // pass plateNumber, engineCapacity, make, model, year, ownerId to superclass constructor
        super(plateNumber, engineCapacity, make, model, year, ownerId);
        
        this.loadCapacity = loadCapacity;
        
     // end of constructor   
    }
    
    /**
     * setLoadCapacity mutator method
     * @param loadCapacity 
     */
    public void setLoadCapacity(double loadCapacity){
        
        this.loadCapacity = loadCapacity;
    }
    
    /**
     * getLoadCapacity accessor method
     * @return heavy vehicle's load capacity
     */
    public double getLoadCapacity(){
        
        return loadCapacity;
    }
    
    /**
     * toString method
     * @return details of the heavy vehicle with it's loading capacity
     */
    @Override
    public String toString(){
        
        return String.format("The heavy vehicle " + super.toString() + "Load capacity: %.1f", loadCapacity);
    }
    
 // End of class
}
