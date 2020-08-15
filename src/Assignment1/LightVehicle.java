
package Assignment1;

/**
 * @author pujan
 * StudentId 12134829
 * LightVehicle class extends Vehicle superclass and
 * is used for light type of vehicles
 */
public class LightVehicle extends Vehicle{
    
    // number of seats in light vehicle
    private int seatNumber;
    
    /**
     * constructor
     * @param plateNumber     // light vehicle's plate number
     * @param engineCapacity  // light vehicle's engine capacity
     * @param make            // light vehicle's brand
     * @param model           // light vehicle's model
     * @param year            // year the light vehicle was made in
     * @param ownerId         // Id of owner of light vehicle
     * @param seatNumber      // number of seats in light vehicle
     */
    public LightVehicle(String plateNumber, double engineCapacity, String make, String model, int year, int ownerId, int seatNumber){
        
        // pass plateNumber, engineCapacity, make, model, year, ownerId to superclass constructor
        super(plateNumber, engineCapacity, make, model, year, ownerId);
        
        this.seatNumber = seatNumber;
    }
    
    /**
     * setSeatNumber mutator method
     * @param seatNumber 
     */
    public void setSeatNumber(int seatNumber){
        
        this.seatNumber = seatNumber;
    }
    
    /**
     * getSeatNumber accessor method
     * @return number of seats in light vehicle
     */
    public int getSeatNumber(){
        
        return seatNumber;
    }
    
    /**
     * toString method
     * @return details of the light vehicle along with seat capacity
     */
    @Override
    public String toString(){
        
        return String.format(super.toString() + " It has %d seats.", seatNumber);
    }

 // End of class
}
