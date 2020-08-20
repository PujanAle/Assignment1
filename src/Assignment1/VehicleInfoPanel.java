
package Assignment1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * @author pujan
 * StudentId 12134829
 * VehicleInfoPanel class for panel related to vehicle
 */
public class VehicleInfoPanel extends JPanel{    
    
    private double engineCapacity;          // engine capacity
    private String make;                    // brand of vehicle
    private String model;                   // model
    private int year;                       // year of manufacture
    private int seatNumber;                 // number of seats
    private double loadCapacity;            // load capacity
    private int selectedVehicleType = 0;    // which vehicle is selected
    
    
    /**
     * constructor
     * @param engineCapacity    // engine capacity
     * @param make              // brand of vehicle
     * @param model             // model
     * @param year              // year of manufacture
     * @param seatNumber        // number of seats
     * @param loadCapacity      // load capacity
     */
    public VehicleInfoPanel(double engineCapacity, String make, String model, int year, int seatNumber, double loadCapacity){
        
        this.engineCapacity = engineCapacity;
        this.make = make;
        this.model = model;
        this.year = year;
        this.seatNumber = seatNumber;
        this.loadCapacity = loadCapacity;
        
        // making a titled border for vehicle detail entry
        TitledBorder vehicleLine = BorderFactory.createTitledBorder(" Vehicle Information ");
        vehicleLine.setTitleColor(Color.BLUE);
        
        // making border
        Border border5 = BorderFactory.createLineBorder(Color.blue, 1);
        
        // main panel for vehicle info entry
        JPanel vehiclePanel = new JPanel();           
        vehiclePanel.setLayout(new BorderLayout());
            
        // nested panels
        JPanel panelx = new JPanel();
        JPanel panely = new JPanel();
        JPanel panelz = new JPanel();
            
        // label for vehicle details
        JLabel vehicleTypeLabel = new JLabel("Type of vehicle");
        JLabel engineCapacityLabel = new JLabel("Engine Capacity");
        JLabel makeLabel = new JLabel("Make");
        JLabel modelLabel = new JLabel("Model");
        JLabel yearLabel = new JLabel("Year");
        JLabel loadCapacityLabel = new JLabel("Load Capacity (tonnes)");
        JLabel seatNumbersLabel = new JLabel("Seat Number");
            
        // making combobox for type of vehicle
        String[] vehicleTypeArray = {"Motorcycle", "Light vehicle", "Heavy vehicle"};
        JComboBox vehicleComboBox = new JComboBox(vehicleTypeArray);
        vehicleComboBox.setSelectedItem("Motorcycle");
            
        // textarea for entering vehicle details
        JTextField engineCapacityText = new JTextField(15);
        String engineInt = Double.toString(engineCapacity);
        engineCapacityText.setText(engineInt);
        engineCapacityText.setBorder(border5);
            
        JTextField makeText = new JTextField(15);
        makeText.setText(make);
        makeText.setBorder(border5);
           
        JTextField modelText = new JTextField(15);
        modelText.setText(model);
        modelText.setBorder(border5);
            
        JTextField yearText = new JTextField(15);
        String yearInt = Integer.toString(year);
        yearText.setText(yearInt);
        yearText.setBorder(border5);
            
        JTextField loadCapacityText = new JTextField(15);
        String loadInt = Double.toString(loadCapacity);
        loadCapacityText.setText(loadInt);
        loadCapacityText.setBorder(border5);
            
        JTextField seatNumbersText = new JTextField(15);
        String seatInt = Integer.toString(seatNumber);
        seatNumbersText.setText(seatInt);
        seatNumbersText.setBorder(border5);
            
        // nested panels
        panelx.setLayout(new FlowLayout());
        panelz.setLayout(new BorderLayout());
                        
        panelx.add(vehicleTypeLabel);
        panelx.add(vehicleComboBox);
        panelz.add(panelx, BorderLayout.NORTH);
            
        // adding detail label and field to a nested panel
        panely.setLayout(new GridLayout(6, 2, 10, 4));
        panely.add(engineCapacityLabel);
        panely.add(engineCapacityText);
        panely.add(makeLabel);
        panely.add(makeText);
        panely.add(modelLabel);
        panely.add(modelText);
        panely.add(yearLabel);
        panely.add(yearText);
        panely.add(loadCapacityLabel);
        panely.add(loadCapacityText);
        panely.add(seatNumbersLabel);
        panely.add(seatNumbersText);            
        panelz.add(panely, BorderLayout.CENTER);
            
        // adding all nested panels to main vehicle panel
        vehiclePanel.add(panelz, BorderLayout.WEST);
        vehiclePanel.setBorder(vehicleLine);            
                                
        // can be changed according to the vehicle type selected
        loadCapacityLabel.setForeground(Color.gray);
        seatNumbersLabel.setForeground(Color.gray);
        loadCapacityText.setEnabled(false);
        seatNumbersText.setEnabled(false);
            
            
        // letting user enter data according to the vehicle chosen
        vehicleComboBox.addItemListener(event5 -> {
               
            Object vh = vehicleComboBox.getSelectedItem();
            if(vh.equals("Motorcycle")){
                    
                loadCapacityLabel.setForeground(Color.gray);
                loadCapacityText.setEnabled(false);  
                loadCapacityText.setText("");
                    
                seatNumbersLabel.setForeground(Color.gray);
                seatNumbersText.setEnabled(false);   
                loadCapacityText.setText("");
                
                // when motorcycle is selected
                selectedVehicleType = 1;
            }
            else if(vh.equals("Light vehicle")){
                    
                loadCapacityLabel.setForeground(Color.gray);
                loadCapacityText.setEnabled(false);
                loadCapacityText.setText("");
                    
                seatNumbersLabel.setForeground(Color.black);
                seatNumbersText.setEnabled(true);
                
                // when light vehicle is selected
                selectedVehicleType = 2;
            }
            else if(vh.equals("Heavy vehicle")){
                    
                loadCapacityLabel.setForeground(Color.black);
                loadCapacityText.setEnabled(true);
                   
                seatNumbersLabel.setForeground(Color.gray);
                seatNumbersText.setEnabled(false);
                seatNumbersText.setText("");
                
                // when heavy vehicle is selected
                selectedVehicleType = 3;
            }                
        });  
        
     // end of constructor   
    }
    
    
    /**
     * setEngineCapacity mutator method
     * @param engineCapacity 
     */
    public void setEngineCapacity(double engineCapacity){
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
     * setSeatNumber mutator method
     * @param seatNumber 
     */
    public void setSeatNumber(int seatNumber){
        this.seatNumber = seatNumber;
    }
    
    
    /**
     * setLoadCapacity mutator method
     * @param loadCapacity 
     */
    public void setLoadCapacity(double loadCapacity){
        this.loadCapacity = loadCapacity;
    }
    
    
    /**
     * getEngineCapacity accessor method
     * @return engine capacity
     */
    public double getEngineCapacity(){
        return engineCapacity;
    }
    
    
    /**
     * getMake accessor method
     * @return brand of vehicle
     */
    public String getMake(){
        return make;
    }
    
    
    /**
     * getModel accessor method
     * @return model
     */
    public String getModel(){
        return model;
    }
    
    
    /**
     * getYear accessor method
     * @return year of manufacture
     */
    public int getYear(){
        return year;
    }
    
    
    /**
     * getSeatNumber accessor method
     * @return number of seats
     */
    public int getSeatNumber(){
        return seatNumber;
    }
    
    
    /**
     * getLoadCapacity accessor method
     * @return load capacity
     */
    public double getLoadCapacity(){
        return loadCapacity;
    }
    
    
    /**
     * getSelectedVehicleType accessor method
     * @return the vehicle type selected
     */
    public int getSelectedVehicleType(){
        return selectedVehicleType;
    }
    

 // End of class
}
