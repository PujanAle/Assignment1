
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
    
    int selectedVehicleType = 0;    // which vehicle is selected
    
    JTextField engineCapacityText;
    JTextField makeText;
    JTextField modelText;
    JTextField yearText;
    JTextField loadCapacityText;
    JTextField seatNumbersText;
    
    JComboBox vehicleComboBox;
    
    
    /**
     * constructor
     */
    public VehicleInfoPanel(){
        
        setLayout(new BorderLayout());
           
        // making a titled border for vehicle detail entry
        TitledBorder vehicleLine = BorderFactory.createTitledBorder(" Vehicle Information ");
        vehicleLine.setTitleColor(Color.BLUE);
        
        // making border
        Border border5 = BorderFactory.createLineBorder(Color.black, 1);
        
       
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
        vehicleComboBox = new JComboBox(vehicleTypeArray);
        vehicleComboBox.setSelectedItem("Motorcycle");
            
        // textarea for entering vehicle details
        engineCapacityText = new JTextField(15);
        engineCapacityText.setBorder(border5);
            
        makeText = new JTextField(15);
        makeText.setBorder(border5);
           
        modelText = new JTextField(15);
        modelText.setBorder(border5);
            
        yearText = new JTextField(15);
        yearText.setBorder(border5);
            
        loadCapacityText = new JTextField(15);
        loadCapacityText.setBorder(border5);
            
        seatNumbersText = new JTextField(15);
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
        add(panelz, BorderLayout.WEST);
        setBorder(vehicleLine);            
                                
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
    public void setEngineCapacity(String engineCapacity){
        engineCapacityText.setText(engineCapacity);
    }
    
    
    /**
     * setMake mutator method
     * @param make 
     */
    public void setMake(String make){
        makeText.setText(make);
    }
    
    
    /**
     * setModel mutator method
     * @param model 
     */
    public void setModel(String model){
        modelText.setText(model);
    }
    
    
    /**
     * setYear mutator method
     * @param year 
     */
    public void setYear(String year){
        yearText.setText(year);
    }
    
    
    /**
     * setSeatNumber mutator method
     * @param seatNumber 
     */
    public void setSeatNumber(String seatNumber){
        seatNumbersText.setText(seatNumber);
    }
    
    
    /**
     * setLoadCapacity mutator method
     * @param loadCapacity 
     */
    public void setLoadCapacity(String loadCapacity){
        loadCapacityText.setText(loadCapacity);
    }
    
    
    /**
     * getEngineCapacity accessor method
     * @return engine capacity
     */
    public String getEngineCapacity(){
        return engineCapacityText.getText();
    }
    
    
    /**
     * getMake accessor method
     * @return brand of vehicle
     */
    public String getMake(){
        return makeText.getText();
    }
    
    
    /**
     * getModel accessor method
     * @return model
     */
    public String getModel(){
        return modelText.getText();
    }
    
    
    /**
     * getYear accessor method
     * @return year of manufacture
     */
    public String getYear(){
        return yearText.getText();
    }
    
    
    /**
     * getSeatNumber accessor method
     * @return number of seats
     */
    public String getSeatNumber(){
        return seatNumbersText.getText();
    }
    
    
    /**
     * getLoadCapacity accessor method
     * @return load capacity
     */
    public String getLoadCapacity(){
        return loadCapacityText.getText();
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
