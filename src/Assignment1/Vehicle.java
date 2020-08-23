
package Assignment1;

/**
 * @author pujan
 * StudentId 12134829
 * Abstract Vehicle superclass 
 */
public abstract class Vehicle{
    
    private String plateNumber;      // vehicle's plate number
    private double engineCapacity;   // vehicle's engine capacity
    private String make;             // vehicle brand
    private String model;            // vehicle's model
    private int year;                // year in which the vehicle was made
    private int ownerId;             // vehicle's owner id
    
    /**
     * constructor
     * @param plateNumber     // vehicle's plate number
     * @param engineCapacity  // vehicle's engine capacity
     * @param make            // vehicle brand
     * @param model           // vehicle's model
     * @param year            // year in which the vehicle was made
     * @param ownerId         // vehicle's owner id
     */
    public Vehicle(String plateNumber, double engineCapacity, String make, String model, int year, int ownerId){
        
        this.plateNumber = plateNumber;
        this.engineCapacity = engineCapacity;
        this.make = make;
        this.model = model;
        this.year = year;
        this.ownerId = ownerId;
        
     // end of constructor   
    }

    /**
     * setPlateNumber mutator method
     * @param plateNumber 
     */
    public void setPlateNumber(String plateNumber){
        
        this.plateNumber = plateNumber;
    }
    
    /**
     * setEngineCapacity mutator method
     * @param engineCapacity 
     */
    public void setEngingCapacity(double engineCapacity){
        
        this.engineCapacity = engineCapacity;
    }
    
    /**
     * setMake mutator method
     * @param make 
     */
    public void setMake(String make){
        
        this.make = make;
    }
    
    /**
     * setModel mutator method
     * @param model 
     */
    public void setModel(String model){
        
        this.model = model;
    }
    
    /**
     * setYear mutator method
     * @param year 
     */
    public void setYear(int year){
        
        this.year = year;
    }
    
    /**
     * setOwnerId mutator method
     * @param ownerId 
     */
    public void setOwnerId(int ownerId){
        
        this.ownerId = ownerId;
    }
    
    /**
     * getPlateNumber accessor method
     * @return plate number of vehicle
     */
    public String getPlateNumber(){
        
        return plateNumber;
    }
    
    /**
     * getEngingCapacity accessor method
     * @return engine capacity of vehicle
     */
    public double getEngineCapacity(){
        
        return engineCapacity;
    }
    
    /**
     * getMake accessor method
     * @return make or brand of vehicle
     */
    public String getMake(){
        
        return make;
    }
    
    /**
     * getModel accessor method
     * @return model of vehicle
     */
    public String getModel(){
        
        return model;
    }
    
    /**
     * getYear accessor method
     * @return year the vehicle was built
     */
    public int getYear(){
        
        return year;
    }
    
    /**
     * getOwnerId accessor method
     * @return Id of the owner of the vehicle
     */
    public int getOwnerId(){
        
        return ownerId;
    }
    
    /**
     * toString method
     * @return details of the vehicle
     */
    @Override
    public String toString(){
          
        return String.format("is registered with the following details: \n"
                                + "Plate Number: %s\n"
                                + "Engine Capacity: %.1f Litre\n"
                                + "Make: %s\n"
                                + "Model: %s\n"
                                + "Year: %d\n", plateNumber, engineCapacity, make, model, year);
    }
    
 // End of class
}
