
package Assignment1;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * @author pujan
 * StudentId 12134829
 * SystemGui class is for the GUI of the system to let the user
 * enter owner and vehicle detail and search and edit information.
 */
public class SystemGui extends JFrame{
    
    // size of app
    private final int DEFAULT_WIDTH = 360;
    private final int DEFAULT_HEIGHT = 180;
    
    // panels for upper buttons
    private final JPanel panel1;
    private final JPanel panel2;
    
    // panels for exit button
    private final JPanel panel3;
    private final JPanel panel4;
        
    // main panel
    private final JPanel panel5;
    
    private final JButton register;        // button to register owenr and vehicle
    private final JButton sAndEOwner;      // button to search a owner and edit info
    private final JButton sAndEVehicle;    // button to search a vehicle and edit info
    private final JButton exit;            // button to exit system
       
    
    /**
     * constructor
     */
    public SystemGui(){
        
        // size of app
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        // panel for upper buttons
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1, 10, 5));
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
               
        // panel for exit button
        panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0)); 
              
        // panel for all the nested panel
        panel5 = new JPanel();
        panel5.setLayout(new BorderLayout());
        
        register = new JButton("Register");                          // button to register owner and vehicle
        sAndEOwner = new JButton("Search and Edit Owner Info");      // button to search and edit owner info
        sAndEVehicle = new JButton("Search and Edit Vehicle Info");  // button to search and edit vehicle info
        exit = new JButton("Exit");      // button to exit system
        
        // adding buttons to nested panel
        panel1.add(register);
        panel1.add(sAndEOwner);
        panel1.add(sAndEVehicle);
        panel2.add(panel1);
                
        // adding exit button 
        panel3.add(exit);
        panel4.add(panel3);
               
        // adding all buttons to main panel
        panel5.add(panel2, BorderLayout.CENTER);
        panel5.add(panel4, BorderLayout.SOUTH);
        
        // adding  main panel to app
        this.add(panel5);
 
        // adding functionality to "Register" button
        register.addActionListener(a -> {
            
            // so that the main menu is hidden
            this.hide();
            
            // frame for registration information
            JFrame regFrame = new JFrame();
            
            regFrame.setTitle("Register");                 // title of frame
            regFrame.setSize(600, 475);                    // size of app
            regFrame.setVisible(true);                     // making app visible
            regFrame.setLocationRelativeTo(null);          // making app appear in center of screen
            regFrame.setResizable(true);                   // making app sizable
            regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // making app close when X button is clicked
            regFrame.setLayout(new BorderLayout());        
            
            // making a titled border for owner detail entry
            TitledBorder ownerLine = BorderFactory.createTitledBorder("Owenr Information");
            ownerLine.setTitleColor(Color.BLUE);
            
            // making a titled border for vehicle detail entry
            TitledBorder vehicleLine = BorderFactory.createTitledBorder("Vehicle Information");
            vehicleLine.setTitleColor(Color.BLUE);
                                
            
            /**
             * entering owner information
            */
            JPanel ownerPanel = new JPanel();            // main panel for entering owner details
            ownerPanel.setLayout(new BorderLayout());
            
            // labels for owner details
            JLabel fNameLabel = new JLabel("First Name: ");
            JLabel lNameLabel = new JLabel("Last Name: ");
            JLabel licenceNumberLabel = new JLabel("Licence Number: ");
            JLabel addrLabel = new JLabel("Address: ");
            JLabel phoneNoLabel = new JLabel("Phone Number: ");
            JLabel dobLabel = new JLabel("Date Of Birth: ");
            JLabel abnLabel = new JLabel("Australian Business Number: ");
            JLabel ownerType = new JLabel("Select the which type of owner.");
    
            // Test area for entering vehicle details
            JTextArea fNameText = new JTextArea();
            JTextArea lNameText = new JTextArea();
            JTextArea licenceNumberText = new JTextArea();
            JTextArea addrText = new JTextArea();
            JTextArea phoneNoText = new JTextArea();
            JTextArea dobText = new JTextArea();
            JTextArea abnText = new JTextArea();
    
            // radiobuttons to choose the type of owner
            JRadioButton privateOwner = new JRadioButton("Private");
            JRadioButton corporateOwner = new JRadioButton("Corporate");
    
            // nested panels for owner details
            JPanel panela = new JPanel();
            JPanel panelb = new JPanel();
            JPanel panelc = new JPanel();
            JPanel paneld = new JPanel();
            JPanel panele = new JPanel();
            JPanel panelf = new JPanel();
            JPanel panelg = new JPanel();
            JPanel panelh = new JPanel();
                              
            // selecting type of owner
            panela.add(ownerType);
            panelb.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
            panelb.add(privateOwner);
            panelb.add(corporateOwner);
            
            // button group for the raido buttons
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(privateOwner);
            buttonGroup.add(corporateOwner);
            
            panelc.setLayout(new BorderLayout());
            panelc.add(panela, BorderLayout.NORTH);
            panelc.add(panelb, BorderLayout.CENTER);
                       
            // adding label and text to the nested panel
            paneld.setLayout(new GridLayout(5, 2, 10, 5));
            paneld.add(fNameLabel);
            paneld.add(fNameText);
            
            paneld.add(lNameLabel);
            paneld.add(lNameText);
            
            paneld.add(licenceNumberLabel);
            paneld.add(licenceNumberText);
            
            paneld.add(addrLabel);
            paneld.add(addrText);
            
            paneld.add(phoneNoLabel);
            paneld.add(phoneNoText);
            
            // adding radiobuttons to panele
            panele.add(panelc);
            
            panelf.setLayout(new GridLayout(2, 2, 10, 5));
            panelf.add(dobLabel);
            panelf.add(dobText);
            panelf.add(abnLabel);
            panelf.add(abnText);
            
            // adding all fields to panelg 
            panelg.setLayout(new BorderLayout());
            panelg.add(paneld, BorderLayout.NORTH);
            panelg.add(panele, BorderLayout.CENTER);
            panelg.add(panelf, BorderLayout.SOUTH);
            
            panelh.setLayout(new BorderLayout());
            panelh.add(panelg, BorderLayout.WEST);
            
            // adding nested panel to the main panel -> ownerPanel
            ownerPanel.add(panelh, BorderLayout.CENTER);
            ownerPanel.setBorder(ownerLine);
            
            
            /**
             * entering vehicle information
            */
            JPanel vehiclePanel = new JPanel();           // main panel for vehicle info entry
            vehiclePanel.setLayout(new BorderLayout());
            
            // nested panels
            JPanel panelx = new JPanel();
            JPanel panely = new JPanel();
            JPanel panelz = new JPanel();
            
            // label for vehicle details
            JLabel vehicleTypeLabel = new JLabel("Type of vehicle: ");
            JLabel engineCapacityLabel = new JLabel("Engine Capacity: ");
            JLabel makeLabel = new JLabel("Make: ");
            JLabel modelLabel = new JLabel("Model: ");
            JLabel yearLabel = new JLabel("Year: ");
            JLabel loadCapacityLabel = new JLabel("Load Capacity (tonnes): ");
            JLabel seatNumbersLabel = new JLabel("Seat Number: ");
            
            // making combobox for type of vehicle
            String[] vehicleTypeArray = {"Motorcycle", "Light vehicle", "Heavy vehicle"};
            JComboBox vehicleComboBox = new JComboBox(vehicleTypeArray);
            vehicleComboBox.setSelectedIndex(0);
            
            // textarea for entering vehicle details
            JTextArea engineCapacityText = new JTextArea();
            JTextArea makeText = new JTextArea();
            JTextArea modelText = new JTextArea();
            JTextArea yearText = new JTextArea();
            JTextArea loadCapacityText = new JTextArea();
            JTextArea seatNumbersText = new JTextArea();
            
            // nested panels
            panelx.setLayout(new FlowLayout());
            panelz.setLayout(new BorderLayout());
                        
            panelx.add(vehicleTypeLabel);
            panelx.add(vehicleComboBox);
            panelz.add(panelx, BorderLayout.NORTH);
            
            // adding detail label and field to a nested panel
            panely.setLayout(new GridLayout(6, 2, 15, 5));
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
            
                      
            /**
             * exit and clear buttons
            */
            JPanel buttons = new JPanel();          // panel for buttons
            buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
            
            // making buttons
            JButton registerButton = new JButton("Register");    // to register the owner and vehicle
            JButton clearButton = new JButton("Clear");          // to clear every textarea
            JButton backButton = new JButton("Back");            // to go back to main menu
            JButton exitButton = new JButton("Exit");
            
            // adding functionality to back button
            backButton.addActionListener(f -> {
                
                regFrame.hide();
                this.setVisible(true);
            });
            
            // adding functionality to exit button
            exitButton.addActionListener(g -> exit());
            
            // adding buttons to panel buttons
            buttons.add(registerButton);
            buttons.add(clearButton);
            buttons.add(backButton);
            buttons.add(exitButton);
            
            
            // adding all the major panels to the frame
            regFrame.add(ownerPanel, BorderLayout.NORTH);
            regFrame.add(vehiclePanel, BorderLayout.CENTER);
            regFrame.add(buttons, BorderLayout.SOUTH);
            
                    
         // end of register button action listener            
        });
        
        // adding functionality to "Exit" button
        exit.addActionListener(d -> exit());
        
                      
     // end of constructor   
    }
    

    /**
     * exit() method
     * to exit the application
     */
    public void exit(){
        
        System.exit(0);
    }
    
    
    public static void main(String[] args){
        
        EventQueue.invokeLater(() -> {
            
            // making a new frame
            JFrame frame = new SystemGui();        
            
            frame.setTitle("Motor Vehicle Registration(MVR)");      // title of app 
            frame.setLocationRelativeTo(null);                      // placing app at center of screen
            frame.setVisible(true);                                 // making app visible
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // making app close when the X button is clicked
            frame.setResizable(true);                               // making app resizable
        });
        
     // end of main method   
    }
    
 // End of class
}
