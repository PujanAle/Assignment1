
package Assignment1;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author pujan
 * StudentId 12134829
 * SystemGui class is for the GUI of the system to let the user
 * enter owner and vehicle detail and search and edit information.
 */
public class SystemGui extends JFrame{
    
    // size of app
    private final int DEFAULT_WIDTH = 500;
    private final int DEFAULT_HEIGHT = 230;
    
    // private owner object arraylist
    ArrayList<PrivateOwner> privateOwnerArray = new ArrayList<>();
    
    // corporate owner objcet arraylist
    ArrayList<CorporateOwner> corporateOwnerArray = new ArrayList<>();
    
    // motorcycle objcet arraylist
    ArrayList<Motorcycle> motorcycleArray = new ArrayList<>();
    
    // light vehicle objcet arraylist
    ArrayList<LightVehicle> lightVehicleArray = new ArrayList<>();
    
    // heavy vehicle objcet arraylist
    ArrayList<HeavyVehicle> heavyVehicleArray = new ArrayList<>();
    
    // assigning plate number to the vehicle registered
    String plateNumber = "VIC2033";
   
    // current owner position in array
    int currentPrivateOwner = 0;
    int currentCorporateOwner = 0;
    
    // current vehicle position in array
    int currentMotorcycle = 0;
    int currentLight = 0;
    int currentHeavy = 0;
    
    // selection of owner and vehicle
    int ownerSelection = 0;
    int vehicleSelection = 0;    
    
    // licence number of the owner
    int ownerId;
    
    // owner array that the owner search key is in
    int ownerArrayPlace = 0;
    
    // vehicle array that the vehicle search key is in
    int vehicleArrayPlace = 0;
    
    // getting the plate number of the vehicle being edited
    String EditingPlateNumber;    
       
    // variables to find out if the type of vehicle has been changed
    // when the vehicle details is edited
    int vehicleBeforeEdit = 0;
    int vehicleAfterEdit = 0;
    
    // welcome text in the app
    private final JLabel welcomeLabel;
    
    // panels for upper buttons
    private final JPanel panel1;
    private final JPanel panel2;
    
    // panels for exit button
    private final JPanel panel3;
    private final JPanel panel4;
        
    // main panel
    private final JPanel panel5;
    
    // buttons in main menu
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
        
        // welcome text for the main menu
        welcomeLabel = new JLabel("Welcome to the Motor Vehicle Registration System");
        
        // panel for upper buttons
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 1, 10, 5));
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
        
        // buttons
        register = new JButton("Register");                          // button to register owner and vehicle
        sAndEOwner = new JButton("Search and Edit Owner Info");      // button to search and edit owner info
        sAndEVehicle = new JButton("Search and Edit Vehicle Info");  // button to search and edit vehicle info
        exit = new JButton("Exit");      // button to exit system
        
        // adding welcome label and buttons to nested panel
        panel1.add(welcomeLabel);
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
        
        
        /**
         * adding functionality to "Register" button
         */
        register.addActionListener(a -> {
            
            // so that the main menu is hidden
            this.hide();
            
            // frame for registration information
            JFrame regFrame = new JFrame();
            
            regFrame.setTitle("Register");                 // title of frame
            regFrame.setSize(500, 500);                    // size of app
            regFrame.setVisible(true);                     // making app visible
            regFrame.setLocationRelativeTo(null);          // making app appear in center of screen
            regFrame.setResizable(false);                   // making app sizable
            regFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);      // making app close when X button is clicked
            regFrame.setLayout(new BorderLayout());        
            
            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            
            // making a titled border for owner detail entry
            TitledBorder ownerLine = BorderFactory.createTitledBorder(" Owenr Information ");
            ownerLine.setTitleColor(Color.BLUE);
            
            // making a titled border for vehicle detail entry
            TitledBorder vehicleLine = BorderFactory.createTitledBorder(" Vehicle Information ");
            vehicleLine.setTitleColor(Color.BLUE);
                                
            
            /**
             * entering owner information
             */
            JPanel ownerPanel = new JPanel();            // main panel for entering owner details
            ownerPanel.setLayout(new BorderLayout());
            
            // labels for owner details
            JLabel fNameLabel = new JLabel("First Name");
            JLabel lNameLabel = new JLabel("Last Name");
            JLabel licenceNumberLabel = new JLabel("Licence Number");
            JLabel addrLabel = new JLabel("Address");
            JLabel phoneNoLabel = new JLabel("Phone Number");
            JLabel dobLabel = new JLabel("Date Of Birth");
            JLabel abnLabel = new JLabel("Australian Business Number (ABN)");
            JLabel ownerType = new JLabel("Select owner type");
            JLabel ownerInfo = new JLabel("Private needs Date of birth. Corporate needs ABN");
    
            // Test area for entering vehicle details
            JTextField fNameText = new JTextField(15);
            fNameText.setBorder(border);
            
            JTextField lNameText = new JTextField(15);
            lNameText.setBorder(border);
            
            JTextField licenceNumberText = new JTextField(15);
            licenceNumberText.setBorder(border);
            
            JTextField addrText = new JTextField(15);
            addrText.setBorder(border);
            
            JTextField phoneNoText = new JTextField(15);
            phoneNoText.setBorder(border);
            
            JTextField dobText = new JTextField(15);
            dobText.setBorder(border);
            
            JTextField abnText = new JTextField(15);
            abnText.setBorder(border);
    
            // radiobuttons to choose the type of owner
            JRadioButton privateOwnerButton = new JRadioButton("Private");
            JRadioButton corporateOwnerButton = new JRadioButton("Corporate");
            JRadioButton MainOwnerHiddenButton = new JRadioButton("Hidden");
    
            // nested panels for owner details
            JPanel panela = new JPanel();
            JPanel panelb = new JPanel();
            JPanel panelc = new JPanel();
            JPanel paneld = new JPanel();
            JPanel panele = new JPanel();
            JPanel panelf = new JPanel();
            JPanel panelg = new JPanel();
            JPanel panelh = new JPanel();
            
            // button group for the raido buttons
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(privateOwnerButton);
            buttonGroup.add(corporateOwnerButton);
            buttonGroup.add(MainOwnerHiddenButton);
            MainOwnerHiddenButton.setSelected(true);      
            
                                 
            // adding label and text to the nested panel
            panela.setLayout(new GridLayout(5, 2, 10, 4));
            panela.add(fNameLabel);
            panela.add(fNameText);
            
            panela.add(lNameLabel);
            panela.add(lNameText);
            
            panela.add(licenceNumberLabel);
            panela.add(licenceNumberText);
            
            panela.add(addrLabel);
            panela.add(addrText);
            
            panela.add(phoneNoLabel);
            panela.add(phoneNoText);
            
            
             // selecting type of owner
            panelb.setLayout(new BorderLayout());
            panelb.add(ownerType, BorderLayout.NORTH);
            panelb.add(ownerInfo, BorderLayout.CENTER);
            panelc.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
            panelc.add(privateOwnerButton);
            panelc.add(corporateOwnerButton);
            
            paneld.setLayout(new BorderLayout());
            paneld.add(panelb, BorderLayout.NORTH);
            paneld.add(panelc, BorderLayout.CENTER);
            // adding radiobuttons to panele
            panele.add(paneld);     
            
            panelf.setLayout(new GridLayout(2, 2, 10, 5));
            panelf.add(dobLabel);
            panelf.add(dobText);
            panelf.add(abnLabel);
            panelf.add(abnText);
            
            
            // when hiddenButton is selected user cannot
            // enter date of birth or ABN
            if(MainOwnerHiddenButton.isSelected()){
                abnLabel.setForeground(Color.gray);                                            
                abnText.setEnabled(false);
                dobLabel.setForeground(Color.gray);
                dobText.setEnabled(false);
               
            }           
            
            // when private radio button is selected
            privateOwnerButton.addActionListener(event -> {
                
                dobLabel.setForeground(Color.black);                                                  
                dobText.setEnabled(true);
                abnLabel.setForeground(Color.gray);
                abnText.setEnabled(false);
                abnText.setText("");
            });
            
            // when corporate radio button is selected
            corporateOwnerButton.addActionListener(event2 -> {
                
                abnLabel.setForeground(Color.black);                
                abnText.setEnabled(true);
                dobLabel.setForeground(Color.gray);
                dobText.setEnabled(false);
                dobText.setText("");
            });
            
            
            // adding all fields to panelg 
            panelg.setLayout(new BorderLayout());
            panelg.add(panela, BorderLayout.NORTH);
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
            engineCapacityText.setBorder(border);
            
            JTextField makeText = new JTextField(15);
            makeText.setBorder(border);
            
            JTextField modelText = new JTextField(15);
            modelText.setBorder(border);
            
            JTextField yearText = new JTextField(15);
            yearText.setBorder(border);
            
            JTextField loadCapacityText = new JTextField(15);
            loadCapacityText.setBorder(border);
            
            JTextField seatNumbersText = new JTextField(15);
            seatNumbersText.setBorder(border);
            
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
                }
                else if(vh.equals("Light vehicle")){
                    
                    loadCapacityLabel.setForeground(Color.gray);
                    loadCapacityText.setEnabled(false);
                    loadCapacityText.setText("");
                    
                    seatNumbersLabel.setForeground(Color.black);
                    seatNumbersText.setEnabled(true);
                }
                else if(vh.equals("Heavy vehicle")){
                    
                    loadCapacityLabel.setForeground(Color.black);
                    loadCapacityText.setEnabled(true);
                    
                    seatNumbersLabel.setForeground(Color.gray);
                    seatNumbersText.setEnabled(false);
                    seatNumbersText.setText("");
                }                
            });
            
                      
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
            
            
            
            /**
             * adding functionality to "Register" button
             */
            registerButton.addActionListener(a1 -> {
            
                // checking first name
                String fName;
                if(fNameText.getText().equals("")){
                    errorMessageBox("You must enter first name");
                    fNameText.requestFocus();
                    return;
                }
                
                String checkingfName = fNameText.getText();
                boolean checkfNameBool  = true;
                
                // converting string to an array of its characters
                char[] charFArray = checkingfName.toCharArray();
                
                // checking if character is not a string
                for(char ch : charFArray){
                    if(Character.isLetter(ch) == false){
                        checkfNameBool = false;
                        break;
                    }                    
                }
                if(checkfNameBool == true){
                    fName = fNameText.getText();
                }
                else{
                    errorMessageBox("You must enter first name with alphabets");
                    fNameText.setText("");
                    fNameText.requestFocus();
                    return;
                }
                            
                
                
                // checking last name
                String lName;             
                if(lNameText.getText().equals("")){
                    errorMessageBox("You must enter last name");
                    lNameText.requestFocus();
                    return;
                }
                
                String checkinglName = lNameText.getText();
                boolean checklNameBool  = true;
                
                // converting string to an array of its characters
                char[] charLArray = checkinglName.toCharArray();
                
                // checking if character is not a string
                for(char ch: charLArray){
                    if(Character.isLetter(ch) == false){
                        checklNameBool = false;
                        break;
                    }
                    
                }
                if(checklNameBool == true){
                    lName = lNameText.getText();
                }
                else{
                    errorMessageBox("You must enter last name with alphabets");
                    lNameText.setText("");
                    lNameText.requestFocus();
                    return;
                }          
                
                
                
                // for licence number
                int licenceNumber;
                if(licenceNumberText.getText().equals("")){
                    errorMessageBox("You must enter a licence number");
                    licenceNumberText.requestFocus();
                    return;
                }   
                
                // checking if the licence number entered is an integer or not
                try{ 
                    Integer.parseInt(licenceNumberText.getText()); 
                    licenceNumber = Integer.parseInt(licenceNumberText.getText());
                }  
                catch(NumberFormatException c1){ 
                     errorMessageBox("You must enter numbers for licence number");
                     licenceNumberText.setText("");
                     licenceNumberText.requestFocus();
                     return;
                } 
                    
                
                // for address
                String address;
                if(addrText.getText().equals("")){
                    errorMessageBox("You must enter address");
                    addrText.requestFocus();
                    return;
                }
                else{
                    address = addrText.getText();
                }
                
                
                // for phone number
                String phoneNo; 
                if(phoneNoText.getText().equals("")){
                    errorMessageBox("You must enter phone number");
                    phoneNoText.requestFocus();
                    return;
                }
                
                /**
                 * checking if phone number entered is an alphanumeric or not
                 */
                String checkPhoneNo = phoneNoText.getText();
                boolean checkPhoneBool = true;
                
                // converitng the phone number entry to character array
                char[] phoneCharArray = checkPhoneNo.toCharArray();
                for(char ch: phoneCharArray){
                    
                    if(Character.isLetterOrDigit(ch) == false){
                        checkPhoneBool = false;
                                break;
                    }                    
                }
                
                if(checkPhoneBool == true){
                    phoneNo = phoneNoText.getText();
                }
                else{
                    errorMessageBox("You must enter alphabets or digits for phone number");
                    phoneNoText.setText("");
                    phoneNoText.requestFocus();
                    return;
                }
                
                
                
                // checking if type of owner
                if(MainOwnerHiddenButton.isSelected()){
                    errorMessageBox("You must choose whether you are a private owner or a corporate owner");
                    privateOwnerButton.requestFocus();
                    return;
                }
                else if(privateOwnerButton.isSelected()){
                    
                    // for date of birth
                    String dateOfBirth;
                    if(dobText.getText().equals("")){
                        errorMessageBox("You must enter date of birth");
                        return;
                    }
                    
                    // checking if the date of birth is an alphanumeric
                    String checkDob = dobText.getText();
                    boolean checkDobBool = true;
                    
                    char[] dobCharArray = checkDob.toCharArray();
                    for(char ch: dobCharArray){
                        
                        if(Character.isLetterOrDigit(ch) == false){
                            checkDobBool = false;
                            break;
                        }
                    }
                    
                    if(checkDobBool == true){
                        dateOfBirth = dobText.getText(); 
                        // adding details of private owner object in arraylist
                        privateOwnerArray.add(new PrivateOwner(fName, lName, licenceNumber, address, phoneNo, dateOfBirth));
                 
                        // owner selection for private owner
                        ownerSelection = 1;
                        
                        currentPrivateOwner++;
                    }
                    else{
                        errorMessageBox("You must enter alphabets or digits for date of birth");
                        dobText.setText("");
                        dobText.requestFocus();
                        return;
                    }                  
                }
                
                else{
                    // for Australian Business Number
                    int abn;
                    if(abnText.getText().equals("")){
                        errorMessageBox("You must enter Australian Business Number");
                        abnText.requestFocus();
                        return;
                    }
                    
                    // checking whether the entered abn is integer or not
                    try{
                        Integer.parseInt(abnText.getText());
                        abn = Integer.parseInt(abnText.getText());
                    
                        // adding details of corporate owner object in arraylist
                        corporateOwnerArray.add(new CorporateOwner(fName, lName, licenceNumber, address, phoneNo, abn));
                        
                        // owner selection for corporate owner
                        ownerSelection = 2;
                        
                        currentCorporateOwner++;
                    }
                    catch(NumberFormatException c2){
                        errorMessageBox("You must enter numbers for Australian Business Number");
                        abnText.setText("");
                        abnText.requestFocus();
                        return;
                    }                                 
                }                                           
                
                                
                /**
                 * for vehicle registration
                 */ 
                
                // for engine capacity of vehicle
                double engineCapacity;
                if(engineCapacityText.getText().equals("")){
                    errorMessageBox("You must enter the engine capacity");
                    engineCapacityText.requestFocus();
                    return;
                }
                
                // checking whether the entered engine capacity is a double or not
                try{
                    Double.parseDouble(engineCapacityText.getText()); 
                    engineCapacity = Double.parseDouble(engineCapacityText.getText());
                }
                catch(NumberFormatException c3){
                    errorMessageBox("You should enter engine capacity as numbers only");
                    engineCapacityText.setText("");
                    engineCapacityText.requestFocus();
                    return;
                }
                
                
                // for brand of vehicle
                String make; 
                if(makeText.getText().equals("")){
                    errorMessageBox("You must enter the vehicle's brand");
                    makeText.requestFocus();
                    return;
                }
                
                String checkingModel = makeText.getText();
                boolean checkModel  = true;
                
                // converting string to an array of its characters
                char[] charModelArray = checkingModel.toCharArray();
                
                // checking if character is not a string
                for(char ch : charModelArray){
                    if(Character.isLetter(ch) == false){
                        checkModel = false;
                        break;
                    }                    
                }
                if(checkModel == true){
                    make = makeText.getText();
                }
                else{
                    errorMessageBox("You must enter brand name with alphabets");
                    makeText.setText("");
                    makeText.requestFocus();
                    return;
                }
                
                
                // for model of vehicle
                String model;                      // vehicle's model
                if(modelText.getText().equals("")){
                    errorMessageBox("You must enter the model of vehicle");
                    modelText.requestFocus();
                    return;
                }
                else{
                    model = modelText.getText();
                }
                
                
                // for year of manufacture of vehicle
                int year; 
                if(yearText.getText().equals("")){
                    errorMessageBox("You must enter vehicle's year of manufacture");
                    yearText.requestFocus();
                    return;
                }
                
                // checking whether the entered year is an integer or not
                try{
                    Integer.parseInt(yearText.getText());
                    year = Integer.parseInt(yearText.getText()); 
                }
                catch(NumberFormatException c4){
                    errorMessageBox("You must enter year as numbers");
                    yearText.setText("");
                    yearText.requestFocus();
                    return;
                }
                                
                
                // for checking the type of vehicle
                switch ((String)vehicleComboBox.getSelectedItem()) {
                    
                    case "Motorcycle":
                        
                        // adding motorcycle details to object of motorcycleArray
                        motorcycleArray.add(new Motorcycle(plateNumber, engineCapacity, make, model, year, licenceNumber));
                        
                        // vehicle selection for motorcycle
                        vehicleSelection = 1;
                        
                        currentMotorcycle++;
                        
                        break;
                        
                    case "Light vehicle":                        
                        
                        // for number of seats of light vehicle
                        int seatNumbers;
                        if(seatNumbersText.getText().equals("")){
                            errorMessageBox("You must enter the number of seats");
                            seatNumbersText.requestFocus();
                            return;
                        }  
                        
                        // checking whether the entered seat number is an integer or not
                        try{
                            Integer.parseInt(seatNumbersText.getText());
                            seatNumbers = Integer.parseInt(seatNumbersText.getText());
                            
                            // adding light vehicle details to object of lightVehicleArray
                            lightVehicleArray.add(new LightVehicle(plateNumber, engineCapacity, make, model, year, licenceNumber, seatNumbers));
                            
                            // vehicle selection for light vehicle
                            vehicleSelection = 2;
                            
                            currentLight++;
                            
                        }
                        catch(NumberFormatException c6){
                            errorMessageBox("You must enter number of seats a number");
                            seatNumbersText.setText("");
                            seatNumbersText.requestFocus();
                            return;
                        }                       
                        break;
                        
                    case "Heavy vehicle":
                        
                        // for load capacity of heavy vehicle
                        double loadCapacity;
                        if(loadCapacityText.getText().equals("")){
                            errorMessageBox("You must enter the load capacity");
                            loadCapacityText.requestFocus();
                            return;
                        }   
                        
                        // checking whether the entered loac capacity is a a double or not
                        try{
                            Double.parseDouble(loadCapacityText.getText());
                            loadCapacity = Double.parseDouble(loadCapacityText.getText());
               
                            // adding heavy vehicle details to object of heavyVehicleArray
                            heavyVehicleArray.add(new HeavyVehicle(plateNumber, engineCapacity, make, model, year, licenceNumber, loadCapacity));
                            
                            // vehicle selection for heavy vehicle
                            vehicleSelection = 3;
                            
                            currentHeavy++;
                            
                        }
                        catch(NumberFormatException c5){
                            errorMessageBox("You must enter load capacity as numbers");
                            loadCapacityText.setText("");
                            loadCapacityText.requestFocus();
                            return;
                        }                        
                        break;
                }
             
                
                // strings for the cofrimation message
                String OwnerString = "";      
                String vehicleString = "";
                
                // final confirmation message
                String confirmMessage;
                
                // checking the owner type and giving the appropriate confirmation message
                // when the owner is private
                if(ownerSelection == 1){
                    OwnerString = privateOwnerArray.get(currentPrivateOwner - 1).toString();                    
                }
                // when the owner is corporate
                else if(ownerSelection == 2){                   
                    OwnerString = corporateOwnerArray.get(currentCorporateOwner - 1).toString();                    
                }
                
                
                // checking the vehicle type and creating the appropriate confirmation message
                switch(vehicleSelection){
                    
                    // for motorcycle
                    case 1:{                        
                        vehicleString = motorcycleArray.get(currentMotorcycle - 1).toString();                   
                        break;
                    }
                    
                    // for light vehicle
                    case 2:{                        
                        vehicleString = lightVehicleArray.get(currentLight - 1).toString();                        
                        break;
                    }
                    
                    // for heavy vehicle
                    case 3:{                       
                        vehicleString = heavyVehicleArray.get(currentHeavy - 1).toString();                        
                        break;
                    }
                }
                                
                
                // final confirmation message to display
                confirmMessage = OwnerString + vehicleString;
                confirmationMessage(confirmMessage);
                
                
                /**
                 * The first plate number assigned is "AUS2033"
                 * changing the four numbers in the plate number for every new vehicle
                 */
                String num = "";    // initial number of plate number
                
                // seperating the number from plate number
                for(int i = 3; i < plateNumber.length(); i++){
                    num += plateNumber.charAt(i);
                }
                
                // converting the 4-digit number in plate number to integer
                Integer num2 = Integer.parseInt(num);
                
                // adding 13 to the 4-digit integer
                int newNum = num2 + 13;  
                
                // converting the new 4-digit number to string
                String num3 = Integer.toString(newNum);
                
                // appending the new 4-digit number to "AUS"
                plateNumber = "VIC" + num3;
                
                               
                // making all the textareas empty when registerd
                fNameText.setText("");
                lNameText.setText("");
                licenceNumberText.setText("");
                addrText.setText("");
                phoneNoText.setText("");
                dobText.setText("");
                abnText.setText("");
                MainOwnerHiddenButton.setSelected(true);
                abnLabel.setForeground(Color.gray);                                            
                abnText.setEnabled(false);
                dobLabel.setForeground(Color.gray);
                dobText.setEnabled(false);
                
                
                vehicleComboBox.setSelectedIndex(0);
                engineCapacityText.setText("");
                makeText.setText(""); 
                modelText.setText(""); 
                yearText.setText("");     
                loadCapacityText.setText("");  
                seatNumbersText.setText("");
            
                fNameText.requestFocus();
            });
            
                        
            /**
             * adding functionality to "Clear" button
             */
            clearButton.addActionListener(a2 -> {
                
                // making all the textareas empty
                fNameText.setText("");
                lNameText.setText("");
                licenceNumberText.setText("");
                addrText.setText("");
                phoneNoText.setText("");                
                dobText.setText("");
                abnText.setText("");
                MainOwnerHiddenButton.setSelected(true);
                abnLabel.setForeground(Color.gray);                                            
                abnText.setEnabled(false);
                dobLabel.setForeground(Color.gray);
                dobText.setEnabled(false);
                
                vehicleComboBox.setSelectedIndex(0);
                engineCapacityText.setText("");
                makeText.setText(""); 
                modelText.setText(""); 
                yearText.setText("");     
                loadCapacityText.setText("");  
                seatNumbersText.setText(""); 
                        
            });
            
            
            /**
             * adding functionality to back button
             */
            backButton.addActionListener(f -> {
                
                regFrame.hide();
                this.setVisible(true);
            });
            
            
            /**
             * adding functionality to exit button
             */
            exitButton.addActionListener(g -> {
                regFrame.hide();
                exit();
            });
            
            // adding buttons to panel buttons
            buttons.add(registerButton);
            buttons.add(clearButton);
            buttons.add(backButton);
            buttons.add(exitButton);
            
            
            // adding all the major panels to the frame
            regFrame.add(ownerPanel, BorderLayout.NORTH);
            regFrame.add(vehiclePanel, BorderLayout.CENTER);
            regFrame.add(buttons, BorderLayout.SOUTH);
            
            
            /**
             * when the user pushes the system close (X top right corner)
             */
            // override window closing method
            regFrame.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent d2){  // Attempt to exit application
                    exit();				
                }
            });
            
                    
         // end of register button action listener            
        });
        
        
        
        /**
         * adding functionality to "Search and Edit Owner Info" button
         */
        sAndEOwner.addActionListener( h -> {
            
            // so that the main menu is hidden
            this.hide();            
            
            // making frame for searching and editing button
            JFrame ownerSearchf = new JFrame();
            
            ownerSearchf.setTitle("Search and Edit Owner Info");                 // title of frame
            ownerSearchf.setSize(300, 160);                                      // size of app
            ownerSearchf.setVisible(true);                                       // making app visible
            ownerSearchf.setLocationRelativeTo(null);                            // making app appear in center of screen
            ownerSearchf.setResizable(true);                                     // making app sizable
            ownerSearchf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);   // making app close when X button is clicked
            ownerSearchf.setLayout(new BorderLayout());                 
            
            // label for search
            JLabel ownerSearchTitle = new JLabel("   Search for owner with their licence number");
                       
            // text areas
            JTextField ownerSearchArea = new JTextField(15);
                
            // buttons 
            JButton ownerSearchButton = new JButton("Search");
            JButton ownerBackButton = new JButton("Back");
            JButton ownerExitButton = new JButton("Exit");
            
            // main and nested panels
            JPanel ownerMainPanel = new JPanel();
            JPanel panela1 = new JPanel();
            JPanel panela2 = new JPanel();
            JPanel panela3 = new JPanel();
            JPanel panela4 = new JPanel();
            
            ownerMainPanel.setLayout(new BorderLayout());
            panela1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
            panela2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
            
            // making black border 
            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            ownerSearchArea.setBorder(border);
            
            panela1.add(ownerSearchArea);
            panela1.add(ownerSearchButton);
            
            // adding search area 
            panela2.add(ownerSearchTitle, BorderLayout.NORTH);
            panela2.add(panela1, BorderLayout.WEST);
            
            // adding buttons
            panela3.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
            panela3.add(ownerBackButton);
            panela3.add(ownerExitButton);
            
            panela4.setLayout(new GridLayout(2, 1, 1, 1));
            panela4.add(panela2);
            panela4.add(panela3);
            
            
            /**
             * adding functionality to "Search" button for owner
             */
            ownerSearchButton.addActionListener(k -> {
                
                // varirables to store the result of search
                String firstName = "";       // first name
                String lastName = "";        // last name
                int licenceNumber = 0;       // licence number
                String address = "";         // address
                String phoneNumber= "";      // phone number
                String dateOfBirth = "";     // date of birth
                int abn = 0;                 // Australian Business Number
                
                
                // for finding out which type of owner does the licence number belongs to
                int ownerSearchType = 0;
                
                // booleans to represent the search result
                boolean privateSearchResult = false;
                boolean corporateSearchResult = false;
                
                // owner array that the owner search key is in
                // int ownerArrayPlace = 0;
                
                
                // checking the search key entered
                if(ownerSearchArea.getText().equals("")){
                    errorMessageBox("You must enter licence number of owner to search");
                    ownerSearchArea.requestFocus();
                }
                else{                    
                    // checking if registry is empty
                    if(privateOwnerArray.isEmpty() && corporateOwnerArray.isEmpty()){
                        errorMessageBox("There is no owner registered to search");
                        ownerSearchArea.setText("");
                        ownerSearchArea.requestFocus();
                    }
                    else{                        
                        int ownerSearchKey;
                        try{ 
                            Integer.parseInt(ownerSearchArea.getText());
                            ownerSearchKey = Integer.parseInt(ownerSearchArea.getText());
                            
                            // for private owner search
                            for(int i = 0; i < privateOwnerArray.size(); i++){
                                
                                if(ownerSearchKey == privateOwnerArray.get(i).getLicenseNumber()){
                                    
                                    firstName = privateOwnerArray.get(i).getFirstName();
                                    lastName = privateOwnerArray.get(i).getLastName();
                                    licenceNumber = privateOwnerArray.get(i).getLicenseNumber();
                                    address = privateOwnerArray.get(i).getAddress();
                                    phoneNumber = privateOwnerArray.get(i).getPhoneNumber();
                                    dateOfBirth = privateOwnerArray.get(i).getDateOfBirth();   
                                    
                                    // type of owner searched
                                    ownerSearchType = 1;    
                                    
                                    // when there is a match
                                    privateSearchResult = true;
                                    
                                    // private owner position in the array
                                    ownerArrayPlace = i;
                                    break;                                    
                                }                                                               
                            }
                            
                            // for corporate owner search
                            for(int i = 0; i < corporateOwnerArray.size(); i++){
                                
                                if(ownerSearchKey == corporateOwnerArray.get(i).getLicenseNumber()){                                    
                                    
                                    firstName = corporateOwnerArray.get(i).getFirstName();
                                    lastName = corporateOwnerArray.get(i).getLastName();
                                    licenceNumber = corporateOwnerArray.get(i).getLicenseNumber();
                                    address = corporateOwnerArray.get(i).getAddress();
                                    phoneNumber = corporateOwnerArray.get(i).getPhoneNumber();
                                    abn = corporateOwnerArray.get(i).getAustralianBusinessNumber();
                                    
                                    // type of owner searched
                                    ownerSearchType = 2;
                                    
                                    // when there is a match
                                    corporateSearchResult = true;
                                    
                                    // corporate owner position in the array
                                    ownerArrayPlace = i;
                                    break;
                                }                                                             
                            }  
                            
                            
                            // when there is no match
                            if(privateSearchResult == false && corporateSearchResult == false){
                                
                                errorMessageBox("Owner with the provided licence number not found");
                                ownerSearchArea.setText("");
                                ownerSearchArea.requestFocus();
                            }
                            else{      // when there is a match
                                
                                // so that the search menu is hidden
                                ownerSearchf.hide();
                                
                                // frame search result of owner registration information
                                JFrame searchOwnerFrame = new JFrame();

                                searchOwnerFrame.setTitle("Owner Search Result");                      // title of frame
                                searchOwnerFrame.setSize(500, 310);                                    // size of app
                                searchOwnerFrame.setVisible(true);                                     // making app visible
                                searchOwnerFrame.setLocationRelativeTo(null);                          // making app appear in center of screen
                                searchOwnerFrame.setResizable(true);                                   // making app sizable
                                searchOwnerFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // making app close when X button is clicked
                                searchOwnerFrame.setLayout(new BorderLayout());        

                                // making a titled border for owner details
                                TitledBorder searchOwnerLine = BorderFactory.createTitledBorder(" Owenr Information ");
                                searchOwnerLine.setTitleColor(Color.black);

                                // making black border 
                                Border border1 = BorderFactory.createLineBorder(Color.BLACK, 1);
                                
                                // making blue border
                                Border border2 = BorderFactory.createLineBorder(Color.blue, 1);

                                /**
                                 * showing owner information
                                 */
                                JPanel searchOwnerPanel = new JPanel();            // main panel for entering owner details
                                searchOwnerPanel.setLayout(new BorderLayout());

                                JPanel searchOwnerButton = new JPanel();

                                // labels for owner details
                                JLabel searchfNameLabel = new JLabel("First Name");
                                JLabel searchlNameLabel = new JLabel("Last Name");
                                JLabel searchLicenceNumberLabel = new JLabel("Licence Number");
                                JLabel searchAddrLabel = new JLabel("Address: ");
                                JLabel searchPhoneNoLabel = new JLabel("Phone Number");
                                JLabel searchdobLabel = new JLabel("Date Of Birth");
                                JLabel searchabnLabel = new JLabel("Australian Business Number");
                                JLabel searchOwnerType = new JLabel("The type of owner");
                                
                                

                                // Test area for diplaying owner details
                                JTextField searchfNameText = new JTextField(15);
                                searchfNameText.setBorder(border1);

                                JTextField searchlNameText = new JTextField(15);
                                searchlNameText.setBorder(border1);

                                JTextField searchLicenceNumberText = new JTextField(15);
                                searchLicenceNumberText.setBorder(border1);

                                JTextField searchAddrText = new JTextField(15);
                                searchAddrText.setBorder(border1);

                                JTextField searchPhoneNoText = new JTextField(15);
                                searchPhoneNoText.setBorder(border1);

                                JTextField searchdobText = new JTextField(15);
                                searchdobText.setBorder(border1);

                                JTextField searchabnText = new JTextField(15);
                                searchabnText.setBorder(border1);                

                                // radiobuttons to show the type of owner
                                JRadioButton searchPrivateOwner = new JRadioButton("Private");
                                JRadioButton searchCorporateOwner = new JRadioButton("Corporate");
                                JRadioButton searchHiddenButton = new JRadioButton();

                                // buttons
                                JButton ownerSearchEdit = new JButton("Edit");
                                JButton ownerSaveButton = new JButton("Save");
                                JButton ownerClearButton = new JButton("Clear");
                                JButton ownerSearchBack = new JButton("Back");
                                JButton ownerSearchExit = new JButton("Exit");

                                // nested panels for owner details
                                JPanel panelb1 = new JPanel();
                                JPanel panelb2 = new JPanel();
                                JPanel panelb3 = new JPanel();
                                JPanel panelb4 = new JPanel();
                                JPanel panelb5 = new JPanel();
                                JPanel panelb6 = new JPanel();
                                JPanel panelb7 = new JPanel();
                                JPanel panelb8 = new JPanel();

                                // showing the type of owner
                                panelb1.add(searchOwnerType);
                                panelb2.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
                                panelb2.add(searchPrivateOwner);
                                panelb2.add(searchCorporateOwner);

                                // button group for the raido buttons
                                ButtonGroup buttonGroup = new ButtonGroup();
                                buttonGroup.add(searchPrivateOwner);
                                buttonGroup.add(searchCorporateOwner);
                                buttonGroup.add(searchHiddenButton);

                                panelb3.setLayout(new BorderLayout());
                                panelb3.add(panelb1, BorderLayout.NORTH);
                                panelb3.add(panelb2, BorderLayout.CENTER);

                                // adding label and text to the nested panel
                                panelb4.setLayout(new GridLayout(5, 2, 10, 5));

                                panelb4.add(searchfNameLabel);
                                panelb4.add(searchfNameText);

                                panelb4.add(searchlNameLabel);
                                panelb4.add(searchlNameText);

                                panelb4.add(searchLicenceNumberLabel);
                                panelb4.add(searchLicenceNumberText);

                                panelb4.add(searchAddrLabel);
                                panelb4.add(searchAddrText);

                                panelb4.add(searchPhoneNoLabel);
                                panelb4.add(searchPhoneNoText);

                                // adding radiobuttons to panelb5
                                panelb5.add(panelb3);

                                panelb6.setLayout(new GridLayout(2, 2, 10, 5));
                                panelb6.add(searchdobLabel);
                                panelb6.add(searchdobText);
                                panelb6.add(searchabnLabel);
                                panelb6.add(searchabnText);

                                // adding all fields to panelb7 
                                panelb7.setLayout(new BorderLayout());
                                panelb7.add(panelb4, BorderLayout.NORTH);
                                panelb7.add(panelb5, BorderLayout.CENTER);
                                panelb7.add(panelb6, BorderLayout.SOUTH);

                                panelb8.setLayout(new BorderLayout());
                                panelb8.add(panelb7, BorderLayout.WEST);

                                // adding nested panel to the main panel -> searchOwnerPanel
                                searchOwnerPanel.add(panelb8, BorderLayout.CENTER);
                                searchOwnerPanel.setBorder(searchOwnerLine);

                                // adding buttons 
                                searchOwnerButton.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
                                searchOwnerButton.add(ownerSearchEdit);
                                searchOwnerButton.add(ownerSearchBack);
                                searchOwnerButton.add(ownerSearchExit);

                                // adding searchOwnerPanel and searchOwnerButton to main frame -> searchOwnerFrame
                                searchOwnerFrame.add(searchOwnerPanel, BorderLayout.NORTH);
                                searchOwnerFrame.add(searchOwnerButton, BorderLayout.SOUTH);
                                

                                
                                // adding the result of search to their respective places
                                searchfNameText.setText(firstName);
                                searchfNameText.setEditable(false);
                                    
                                searchlNameText.setText(lastName);
                                searchlNameText.setEditable(false);
                                    
                                String lNumber = Integer.toString(licenceNumber);
                                searchLicenceNumberText.setText(lNumber);
                                searchLicenceNumberText.setEditable(false);
                                    
                                searchAddrText.setText(address);
                                searchAddrText.setEditable(false);
                                    
                                searchPhoneNoText.setText(phoneNumber);
                                searchPhoneNoText.setEditable(false);
                                    
                                // if the owner is private
                                if(ownerSearchType == 1){
                                    searchPrivateOwner.setSelected(true);
                                    searchCorporateOwner.setEnabled(false);
                                    
                                    searchdobText.setText(dateOfBirth);
                                    searchdobText.setEditable(false);
                                    
                                    searchabnText.setEnabled(false);
                                    searchabnLabel.setForeground(Color.gray);
                                }
                                // if the owne is corporate
                                else if(ownerSearchType == 2){
                                    searchCorporateOwner.setSelected(true);
                                    searchPrivateOwner.setEnabled(false);
                                    
                                    String aBN = Integer.toString(abn);
                                    searchabnText.setText(aBN);
                                    searchabnText.setEditable(false);   
                                    
                                    searchdobText.setEnabled(false);
                                    searchdobLabel.setForeground(Color.gray);
                                }
                                

                                
                                /**
                                 * adding functionality to "Edit" button
                                 */
                                ownerSearchEdit.addActionListener(o -> {
                                    
                                    // changing the title of the frame
                                    searchOwnerFrame.setTitle("Edit Owner Search Result");  
                                    
                                    // making all the text fields to be editable and changing their border colour
                                    searchfNameText.setEditable(true);
                                    searchfNameText.setBorder(border2);
                                            
                                    searchlNameText.setEditable(true);
                                    searchlNameText.setBorder(border2);
                                            
                                    searchLicenceNumberText.setEditable(true);
                                    searchLicenceNumberText.setBorder(border2);
                                            
                                    searchAddrText.setEditable(true);
                                    searchAddrText.setBorder(border2);
                                            
                                    searchPhoneNoText.setEditable(true);
                                    searchPhoneNoText.setBorder(border2);
                                            
                                    searchdobText.setEditable(true);
                                    searchdobText.setBorder(border2);
                                            
                                    searchabnText.setEditable(true);
                                    searchabnText.setBorder(border2);
                                    
                                    
                                    // enabling the two radio buttons
                                    searchCorporateOwner.setEnabled(true);
                                    searchPrivateOwner.setEnabled(true);   
                                    
                                    // changing the color of radio buttons to blue
                                    searchCorporateOwner.setForeground(Color.blue);
                                    searchPrivateOwner.setForeground(Color.blue);

                                    // when private radio button is selected
                                    searchPrivateOwner.addActionListener(p -> {

                                        searchdobLabel.setForeground(Color.black);                                                  
                                        searchdobText.setEnabled(true);
                                        searchabnLabel.setForeground(Color.gray);
                                        searchabnText.setEnabled(false);
                                        searchabnText.setText("");
                                    });

                                    // when corporate radio button is selected
                                    searchCorporateOwner.addActionListener(p1 -> {

                                        searchabnLabel.setForeground(Color.black);                
                                        searchabnText.setEnabled(true);
                                        searchdobLabel.setForeground(Color.gray);
                                        searchdobText.setEnabled(false);
                                        searchdobText.setText("");
                                    });
                                    
                                    ownerSearchEdit.setVisible(false);
                                    searchOwnerButton.add(ownerSaveButton);
                                    searchOwnerButton.add(ownerClearButton);
                                    searchOwnerButton.add(ownerSearchBack);
                                    searchOwnerButton.add(ownerSearchExit);                             
                                });
                                
                                
                                                                
                                /**
                                 * adding functionality to "Save" button
                                 */
                                ownerSaveButton.addActionListener(o2 -> {
                                    
                                    // checking first name
                                    String ownerFName;
                                    if(searchfNameText.getText().equals("")){
                                        errorMessageBox("You must enter first name");
                                        searchfNameText.requestFocus();
                                        return;
                                    }

                                    String checkingOwnerFName = searchfNameText.getText();
                                    boolean checkOnwerFNameBool  = true;

                                    // converting string to an array of its characters
                                    char[] charFArray = checkingOwnerFName.toCharArray();

                                    // checking if character is not a string
                                    for(char ch : charFArray){
                                        if(Character.isLetter(ch) == false){
                                            checkOnwerFNameBool = false;
                                            break;
                                        }
                                    }
                                    if(checkOnwerFNameBool == true){
                                        ownerFName = searchfNameText.getText();
                                    }
                                    else{
                                        errorMessageBox("You must enter first name with alphabets");
                                        searchfNameText.setText("");
                                        searchfNameText.requestFocus();
                                        return;
                                    }


                                    // checking last name
                                    String ownerLName;             
                                    if(searchlNameText.getText().equals("")){
                                        errorMessageBox("You must enter last name");
                                        searchlNameText.requestFocus();
                                        return;
                                    }

                                    String checkingOwnerLName = searchlNameText.getText();
                                    boolean checkOwnerLNameBool  = true;

                                    // converting string to an array of its characters
                                    char[] charLArray = checkingOwnerLName.toCharArray();

                                    // checking if character is not a string
                                    for(char ch: charLArray){
                                        if(Character.isLetter(ch) == false){
                                            checkOwnerLNameBool = false;
                                            break;
                                        }
                                    }
                                    if(checkOwnerLNameBool == true){
                                        ownerLName = searchlNameText.getText();
                                    }
                                    else{
                                        errorMessageBox("You must enter last name with alphabets");
                                        searchlNameText.setText("");
                                        searchlNameText.requestFocus();
                                        return;
                                    }


                                    // for licence number
                                    int ownerLicenceNumber;
                                    if(searchLicenceNumberText.getText().equals("")){
                                        errorMessageBox("You must enter a licence number");
                                        searchLicenceNumberText.requestFocus();
                                        return;
                                    } 
                                    
                                    // checking whether the entered licence number is an integer or not
                                    try{ 
                                        Integer.parseInt(searchLicenceNumberText.getText()); 
                                        ownerLicenceNumber = Integer.parseInt(searchLicenceNumberText.getText());
                                    }  
                                    catch(NumberFormatException g1){ 
                                        errorMessageBox("You must enter numbers for licence number");
                                        searchLicenceNumberText.setText("");
                                        searchLicenceNumberText.requestFocus();
                                        return;
                                    } 


                                    // for address
                                    String ownerAddress;
                                    if(searchAddrText.getText().equals("")){
                                        errorMessageBox("You must enter address");
                                        searchAddrText.requestFocus();
                                        return;
                                    }
                                    else{
                                        ownerAddress = searchAddrText.getText();
                                    }


                                    // for phone number
                                    String ownerPhoneNo; 
                                    if(searchPhoneNoText.getText().equals("")){
                                        errorMessageBox("You must enter phone number");
                                        searchPhoneNoText.requestFocus();
                                        return;
                                    }

                                    String checkOwnerPhoneNo = searchPhoneNoText.getText();
                                    boolean checkOwnerPhoneBool = true;

                                    // converitng the phone number entry to character array
                                    char[] phoneCharArray = checkOwnerPhoneNo.toCharArray();
                                    for(char ch: phoneCharArray){

                                        if(Character.isLetterOrDigit(ch) == false){
                                            checkOwnerPhoneBool = false;
                                            break;
                                        }                    
                                    }

                                    if(checkOwnerPhoneBool == true){
                                        ownerPhoneNo = searchPhoneNoText.getText();
                                    }
                                    else{
                                        errorMessageBox("You must enter alphabets or digits for phone number");
                                        searchPhoneNoText.setText("");
                                        searchPhoneNoText.requestFocus();
                                        return;
                                    }



                                    // checking if type of owner                                    
                                    if(searchPrivateOwner.isSelected()){

                                        // for date of birth
                                        String ownerDateOfBirth;
                                        if(searchdobText.getText().equals("")){
                                            errorMessageBox("You must enter date of birth");
                                            return;
                                        }

                                        String checkOwnerDob = searchdobText.getText();
                                        boolean checkOwnerDobBool = true;

                                        char[] dobCharArray = checkOwnerDob.toCharArray();
                                        for(char ch: dobCharArray){

                                            if(Character.isLetterOrDigit(ch) == false){
                                                checkOwnerDobBool = false;
                                                break;
                                            }
                                        }

                                        if(checkOwnerDobBool == true){
                                            ownerDateOfBirth = searchdobText.getText();
                                            
                                            // adding details of private owner object in arraylist
                                            privateOwnerArray.add(ownerArrayPlace, new PrivateOwner(ownerFName, ownerLName, ownerLicenceNumber, ownerAddress, ownerPhoneNo, ownerDateOfBirth));
                                            
                                            // making confirmation message
                                            confirmationMessage(String.format("%s %s's details has been updated with the following details: \n"
                                                    + "Licence Number: %d\n"
                                                    + "Address: %s\n"
                                                    + "Phone number: %s\n"
                                                    + "Date of Birth: %s\n", ownerFName, ownerLName, ownerLicenceNumber, ownerAddress, ownerPhoneNo, ownerDateOfBirth));                                                                                       
                                        }
                                        else{
                                            errorMessageBox("You must enter alphabets or digits for date of birth");
                                            searchdobText.setText("");
                                            searchdobText.requestFocus();
                                        }                  
                                    }

                                    else{
                                        // for Australian Business Number
                                        int onwerAbn;
                                        if(searchabnText.getText().equals("")){
                                            errorMessageBox("You must enter Australian Business Number");
                                            searchabnText.requestFocus();
                                            return;
                                        }
                                        
                                        // checking whether the entered abn is an integer or not
                                        try{
                                            Integer.parseInt(searchabnText.getText());
                                            onwerAbn = Integer.parseInt(searchabnText.getText());

                                            // adding details of corporate owner object in arraylist
                                            corporateOwnerArray.add(ownerArrayPlace, new CorporateOwner(ownerFName, ownerLName, ownerLicenceNumber, ownerAddress, ownerPhoneNo, onwerAbn));

                                            // making confirmation message
                                            confirmationMessage(String.format("%s %s's details has been updated with the following details: \n"
                                                    + "Licence Number: %d\n"
                                                    + "Address: %s\n"
                                                    + "Phone Number: %s\n"
                                                    + "Australian Business Number: %d\n", ownerFName, ownerLName, ownerLicenceNumber, ownerAddress, ownerPhoneNo, onwerAbn));
                                        }
                                        catch(NumberFormatException h1){
                                            errorMessageBox("You must enter numbers for Australian Business Number");
                                            searchabnText.setText("");
                                            searchabnText.requestFocus();
                                        }                                 
                                    }   
                                    
                                    
                                    // after saving the details the frame is closed and the user is taken back to the search bar
                                    searchOwnerFrame.hide();
                                    ownerSearchArea.setText("");
                                    ownerSearchf.setVisible(true);
                                    ownerSearchArea.requestFocus();
                                    
                                });                                
                                
                                
                                /**
                                 * adding  functionality to the "Clear" button
                                 */
                                ownerClearButton.addActionListener(o3 -> {
                                    
                                    // clearing all the textField and deselecting the radio buttons
                                    searchfNameText.setText("");
                                    searchlNameText.setText("");
                                    searchLicenceNumberText.setText("");
                                    searchAddrText.setText("");
                                    searchPhoneNoText.setText("");
                                    searchHiddenButton.setSelected(true);
                                    
                                    searchabnLabel.setForeground(Color.gray);                
                                    searchabnText.setEnabled(false);
                                    searchdobLabel.setForeground(Color.gray);
                                    searchdobText.setEnabled(false);
                                    
                                    searchdobText.setText("");
                                    searchabnText.setText("");
                                    
                                });                                
                                
                                
                                /**
                                * adding functionality to "Back" button
                                */
                               ownerSearchBack.addActionListener(l -> {

                                   searchOwnerFrame.hide();
                                   ownerSearchArea.setText("");
                                   ownerSearchf.setVisible(true);
                                   ownerSearchArea.requestFocus();
                               });

                               /**
                                * adding functionality to "Exit" button
                                */
                               ownerSearchExit.addActionListener(m -> {
                                   searchOwnerFrame.hide();
                                   exit();
                                   });


                               /**
                                * when the user pushes the system close (X top right corner)
                                */
                               // override window closing method
                                searchOwnerFrame.addWindowListener(new WindowAdapter(){
                                   @Override
                                   public void windowClosing(WindowEvent d3){  // Attempt to exit application
                                        exit();				
                                   }
                               }); 
                            }                   
                            
                         // try condition   
                        }
                        catch(NumberFormatException g1){
                            errorMessageBox("You must enter numbers in the search area");
                            ownerSearchArea.setText("");
                            ownerSearchArea.requestFocus();
                        }           
                    }    
                }                  
            });
                
          
            /**
             * adding functionality to "Back" button
             */
            ownerBackButton.addActionListener(i -> {
                
                ownerSearchf.hide();
                this.setVisible(true);                     
            });
            
            /**
             * adding functionality to "Exit" button
             */
            ownerExitButton.addActionListener(j -> {
                ownerSearchf.hide();
                exit();
                });
            
            // adding all nested panel to main panel
            ownerMainPanel.add(panela4, BorderLayout.CENTER);
            
            // adding main panel to the search frame
            ownerSearchf.add(ownerMainPanel);
            
            
            /**
             * when the user pushes the system close (X top right corner)
             */
            // override window closing method
            ownerSearchf.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent d4){  // Attempt to exit application
                    exit();				
                }
            });
            
                       
         // end of owner info search and edit button action listener
        });
        
        
        
        /**
         * adding functionality to "Search and Edit Vehicle Info" button
         */
        sAndEVehicle.addActionListener(n -> {
            
            // so that the main menu is hidden
            this.hide();            
            
            // making frame for searching and editing button
            JFrame vehicleSearchf = new JFrame();
            
            vehicleSearchf.setTitle("Search and Edit Vehicle Info");                // title of frame
            vehicleSearchf.setSize(300, 160);                                      // size of app
            vehicleSearchf.setVisible(true);                                       // making app visible
            vehicleSearchf.setLocationRelativeTo(null);                            // making app appear in center of screen
            vehicleSearchf.setResizable(true);                                     // making app sizable
            vehicleSearchf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);         // making app close when X button is clicked
            vehicleSearchf.setLayout(new BorderLayout());                 
            
            // label for search
            JLabel vehicleSearchTitle = new JLabel("   Search for vehicle with their plate number");
                       
            // text areas
            JTextField vehicleSearchArea = new JTextField(15);
                
            // buttons 
            JButton vehicleSearchButton = new JButton("Search");
            JButton vehicleBackButton = new JButton("Back");
            JButton vehicleExitButton = new JButton("Exit");
            
            // main and nested panels
            JPanel vehicleMainPanel = new JPanel();
            JPanel panelc1 = new JPanel();
            JPanel panelc2 = new JPanel();
            JPanel panelc3 = new JPanel();
            JPanel panelc4 = new JPanel();
            
            vehicleMainPanel.setLayout(new BorderLayout());
            panelc1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
            panelc2.setLayout(new BorderLayout());
            
            // making black border 
            Border border3 = BorderFactory.createLineBorder(Color.BLACK, 1);
            vehicleSearchArea.setBorder(border3);
            
            panelc1.add(vehicleSearchArea);
            panelc1.add(vehicleSearchButton);
            
            // adding search area 
            panelc2.add(vehicleSearchTitle, BorderLayout.NORTH);
            panelc2.add(panelc1, BorderLayout.WEST);
            
            // adding buttons
            panelc3.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
            panelc3.add(vehicleBackButton);
            panelc3.add(vehicleExitButton);
            
            panelc4.setLayout(new GridLayout(2, 1, 1, 1));
            panelc4.add(panelc2);
            panelc4.add(panelc3);       
            
            // adding all nested panel to main panel
            vehicleMainPanel.add(panelc4, BorderLayout.CENTER);
            
            // adding maing panel to the search frame
            vehicleSearchf.add(vehicleMainPanel);        
            
            
            /**
             * adding functionality to "Search" button for vehicles
             */
            vehicleSearchButton.addActionListener(q -> {
                
                // variables to store the result of search
                double engineC = 0;
                String vehicleMake = "";
                String vehicleModel = "";
                int vehicleYear = 0;
                double loadC = 0;
                int seatN = 0;               
                
                // vehicle search type 
                int vehicleSearchType = 0;
                
                // booleans to represent the search result
                boolean motorcycleResult = false;
                boolean lightResult = false;
                boolean heavyResult = false;
                         
                
                // checking if search area is empty
                if(vehicleSearchArea.getText().equals("")){
                    errorMessageBox("You must enter plate number of vehicle");
                    vehicleSearchArea.requestFocus();
                }
                else{                 
                    // checking if there are no vehicles registered
                    if(motorcycleArray.isEmpty() && lightVehicleArray.isEmpty() && heavyVehicleArray.isEmpty()){
                        
                        errorMessageBox("There is no vehicle registered to search");
                        vehicleSearchArea.setText("");
                        vehicleSearchArea.requestFocus();                        
                    }
                    else{
                        // checking if the search key is alphanumeric or not
                        String vehicleSearchKey = vehicleSearchArea.getText();
                        boolean checkVehicle = true;
                        
                        char[] vehicleSearch = vehicleSearchKey.toCharArray();
                        
                        for(char ch: vehicleSearch){
                            if(Character.isLetterOrDigit(ch) == false){
                                checkVehicle = false;
                                break;
                            }
                        }
                        // when the search key is alphanumeric
                        if(checkVehicle == false){
                            errorMessageBox("You must enter plate number with numbers and alphabets only");
                            vehicleSearchArea.setText("");
                            vehicleSearchArea.requestFocus();
                        }
                        else{
                            
                            // checking array of motorcycle for the plate number similar search key
                            for(int i = 0; i < motorcycleArray.size(); i++){
                                
                                if(vehicleSearchKey.equalsIgnoreCase(motorcycleArray.get(i).getPlateNumber())){
                                    
                                    engineC = motorcycleArray.get(i).getEngineCapacity();
                                    vehicleMake = motorcycleArray.get(i).getMake();
                                    vehicleModel = motorcycleArray.get(i).getModel();
                                    vehicleYear = motorcycleArray.get(i).getYear();
                                    ownerId = motorcycleArray.get(i).getOwnerId();
                                    
                                    // type of vehicle
                                    vehicleSearchType = 1;
                                    
                                    // when there is a match
                                    motorcycleResult = true;
                                    
                                    // position of the vehicle in the array
                                    vehicleArrayPlace = i;
                                    
                                    // vehicle is a motorcycle before editing details
                                    vehicleBeforeEdit = 1;
                                    break;
                                }
                            }
                            
                            // checking array of motorcycle for the plate number similar search key
                            for(int i = 0; i < lightVehicleArray.size(); i++){
                                
                                if(vehicleSearchKey.equalsIgnoreCase(lightVehicleArray.get(i).getPlateNumber())){
                                    
                                    engineC = lightVehicleArray.get(i).getEngineCapacity();
                                    vehicleMake = lightVehicleArray.get(i).getMake();
                                    vehicleModel = lightVehicleArray.get(i).getModel();
                                    vehicleYear = lightVehicleArray.get(i).getYear();
                                    seatN = lightVehicleArray.get(i).getSeatNumber();
                                    ownerId = lightVehicleArray.get(i).getOwnerId();
                                    
                                    // type of vehicle
                                    vehicleSearchType = 2;
                                    
                                    // when there is a match
                                    lightResult = true;
                                    
                                    // position of vehicle in the array
                                    vehicleArrayPlace = i;
                                    
                                    // vehicle is a light vehicle before editing
                                    vehicleBeforeEdit = 2;
                                    break;
                                }
                            }
                            
                            // checking array of motorcycle for the plate number similar search key
                            for(int i = 0; i < heavyVehicleArray.size(); i++){
                                
                                if(vehicleSearchKey.equalsIgnoreCase(heavyVehicleArray.get(i).getPlateNumber())){
                                    
                                    engineC = heavyVehicleArray.get(i).getEngineCapacity();
                                    vehicleMake = heavyVehicleArray.get(i).getMake();
                                    vehicleModel = heavyVehicleArray.get(i).getModel();
                                    vehicleYear = heavyVehicleArray.get(i).getYear();
                                    loadC = heavyVehicleArray.get(i).getLoadCapacity();
                                    ownerId = heavyVehicleArray.get(i).getOwnerId();
                                    
                                    // type of vehicle
                                    vehicleSearchType = 3;
                                    
                                    // when there is a match
                                    heavyResult = true;
                                    
                                    // position of the vehicle in the array
                                    vehicleArrayPlace = i;
                                    
                                    // vehicle is a heavy vehicle before editing
                                    vehicleBeforeEdit = 3;
                                    break;
                                }
                            }
                                
                            
                            // when the search key is no match in any array
                            if(motorcycleResult == false && lightResult == false && heavyResult == false){
                                
                                errorMessageBox("Vehicle with the provided plate number not found");
                                vehicleSearchArea.setText("");
                                vehicleSearchArea.requestFocus();
                            }
                            else{      // when there is a match
                                                
                                // getting the plate number of the vehicle for editing later on
                                EditingPlateNumber = vehicleSearchKey;
                                
                                // so that the search menu is hidden
                                vehicleSearchf.hide();

                                // frame search result of vehicle registration information
                                JFrame searchVehicleFrame = new JFrame();

                                searchVehicleFrame.setTitle("Vehicle Search Result");                 // title of frame
                                searchVehicleFrame.setSize(500, 310);                                 // size of app
                                searchVehicleFrame.setVisible(true);                                  // making app visible
                                searchVehicleFrame.setLocationRelativeTo(null);                       // making app appear in center of screen
                                searchVehicleFrame.setResizable(true);                                // making app sizable
                                searchVehicleFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);    // making app close when X button is clicked
                                searchVehicleFrame.setLayout(new BorderLayout());        

                                // making a titled border for vehicle details
                                TitledBorder searchVehicleLine = BorderFactory.createTitledBorder(" Vehicle Information ");
                                searchVehicleLine.setTitleColor(Color.BLUE);

                                // making black border
                                Border border5 = BorderFactory.createLineBorder(Color.BLACK, 1);
                                
                                // making blue border
                                Border border6 = BorderFactory.createLineBorder(Color.blue, 1);

                                // main panel for vehicle info
                                JPanel vehicleSearchPanel = new JPanel();           
                                vehicleSearchPanel.setLayout(new BorderLayout());

                                // main and nested panels
                                JPanel searchVehicleButton = new JPanel();
                                JPanel paneld1 = new JPanel();
                                JPanel paneld2 = new JPanel();
                                JPanel paneld3 = new JPanel();

                                // buttons
                                JButton vehicleSearchEdit = new JButton("Edit");
                                JButton vehicleSave = new JButton("Save");
                                JButton vehicleClear = new JButton("Clear");
                                JButton vehicleSearchBack = new JButton("Back");
                                JButton vehicleSearchExit = new JButton("Exit");                

                                // label for vehicle details
                                JLabel vehicleSearchTypeLabel = new JLabel("Type of vehicle");
                                JLabel searchEngineCapacityLabel = new JLabel("Engine Capacity");
                                JLabel searchMakeLabel = new JLabel("Make");
                                JLabel searchModelLabel = new JLabel("Model");
                                JLabel searchYearLabel = new JLabel("Year");
                                JLabel searchLoadCapacityLabel = new JLabel("Load Capacity (tonnes)");
                                JLabel searchSeatNumbersLabel = new JLabel("Seat Number");

                                // making combobox for type of vehicles
                                String[] searchVehicleTypeArray = {"Motorcycle", "Light vehicle", "Heavy vehicle"};
                                JComboBox searchVehicleComboBox = new JComboBox(searchVehicleTypeArray);
                                searchVehicleComboBox.setSelectedIndex(0);

                                // textarea for dispalying vehicle details
                                JTextField searchEngineCapacityText = new JTextField(15);
                                searchEngineCapacityText.setBorder(border3);

                                JTextField searchMakeText = new JTextField(15);
                                searchMakeText.setBorder(border3);

                                JTextField searchModelText = new JTextField(15);
                                searchModelText.setBorder(border3);

                                JTextField searchYearText = new JTextField(15);
                                searchYearText.setBorder(border3);

                                JTextField searchLoadCapacityText = new JTextField(15);
                                searchLoadCapacityText.setBorder(border3);

                                JTextField searchSeatNumbersText = new JTextField(15);
                                searchSeatNumbersText.setBorder(border3);

                                // nested panels
                                paneld1.setLayout(new FlowLayout());
                                paneld3.setLayout(new BorderLayout());

                                paneld1.add(vehicleSearchTypeLabel);
                                paneld1.add(searchVehicleComboBox);
                                paneld3.add(paneld1, BorderLayout.NORTH);

                                // adding detail label and field to a nested panel
                                paneld2.setLayout(new GridLayout(6, 2, 10, 4));
                                paneld2.add(searchEngineCapacityLabel);
                                paneld2.add(searchEngineCapacityText);
                                paneld2.add(searchMakeLabel);
                                paneld2.add(searchMakeText);
                                paneld2.add(searchModelLabel);
                                paneld2.add(searchModelText);
                                paneld2.add(searchYearLabel);
                                paneld2.add(searchYearText);
                                paneld2.add(searchLoadCapacityLabel);
                                paneld2.add(searchLoadCapacityText);
                                paneld2.add(searchSeatNumbersLabel);
                                paneld2.add(searchSeatNumbersText);            
                                paneld3.add(paneld2, BorderLayout.CENTER);

                                // adding all nested panels to main search vehicle panel
                                vehicleSearchPanel.add(paneld3, BorderLayout.WEST);
                                vehicleSearchPanel.setBorder(searchVehicleLine);             

                                // adding buttons 
                                searchVehicleButton.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
                                searchVehicleButton.add(vehicleSearchEdit);
                                searchVehicleButton.add(vehicleSearchBack);
                                searchVehicleButton.add(vehicleSearchExit);

                                // adding main panel and buttons to searchVehicleFrame
                                searchVehicleFrame.add(vehicleSearchPanel, BorderLayout.NORTH);
                                searchVehicleFrame.add(searchVehicleButton, BorderLayout.SOUTH);
                                                     
                                
                                // adding details to the result frame according to the vehicle type
                                String engineCap = Double.toString(engineC);
                                searchEngineCapacityText.setText(engineCap);
                                searchEngineCapacityText.setEditable(false);
                                
                                searchMakeText.setText(vehicleMake);
                                searchMakeText.setEditable(false);
                                
                                searchModelText.setText(vehicleModel);
                                searchModelText.setEditable(false);
                                
                                String vYear = Integer.toString(vehicleYear);
                                searchYearText.setText(vYear);
                                searchYearText.setEditable(false);
                                                               
                                searchVehicleComboBox.setEnabled(false);
                                searchVehicleComboBox.setForeground(Color.black);
                                
                                // checking vehicle type and performing related tasks
                                switch(vehicleSearchType){
                                    
                                    // motorcycle
                                    case 1: {
                                        searchVehicleComboBox.setSelectedItem("Motorcycle");
                                    
                                        searchLoadCapacityLabel.setForeground(Color.gray);
                                        searchLoadCapacityText.setEnabled(false);

                                        searchSeatNumbersLabel.setForeground(Color.gray);
                                        searchSeatNumbersText.setEnabled(false);
                                        break;
                                    }
                                    
                                    // light vehicle
                                    case 2: {
                                        searchVehicleComboBox.setSelectedItem("Light vehicle");
                                    
                                        searchLoadCapacityLabel.setForeground(Color.gray);
                                        searchLoadCapacityText.setEnabled(false);
                                            
                                        String numberSeat = Integer.toString(seatN);
                                        searchSeatNumbersText.setText(numberSeat);
                                        searchSeatNumbersText.setEditable(false);
                                        break;
                                    }
                                    
                                    // heavy vehicle
                                    case 3: {
                                        searchVehicleComboBox.setSelectedItem("Heavy vehicle");
                                    
                                        String capacityLoad = Double.toString(loadC);
                                        searchLoadCapacityText.setText(capacityLoad);
                                        searchLoadCapacityText.setEditable(false);

                                        searchSeatNumbersLabel.setForeground(Color.gray);
                                        searchSeatNumbersText.setEnabled(false);
                                        break;
                                    }                                    
                                }                                               
                                
                                
                                /**
                                 * adding functionality to edit button
                                 */
                                vehicleSearchEdit.addActionListener(r1 -> {
                                    
                                    // modifying buttons and their location
                                    vehicleSearchEdit.setVisible(false);
                                    searchVehicleButton.add(vehicleSave);
                                    searchVehicleButton.add(vehicleClear);
                                    searchVehicleButton.add(vehicleSearchBack);
                                    searchVehicleButton.add(vehicleSearchExit);
                                    
                                    // changing the frame title
                                    searchVehicleFrame.setTitle("Edit Vehicle Search Result");
                                    
                                    // enabling the combo box
                                    searchVehicleComboBox.setEnabled(true);
                                    
                                    // making everything editable
                                    searchEngineCapacityText.setEditable(true);
                                    searchEngineCapacityText.setBorder(border6);
                                    
                                    searchMakeText.setEditable(true);
                                    searchMakeText.setBorder(border6);
                                    
                                    searchModelText.setEditable(true);
                                    searchModelText.setBorder(border6);
                                    
                                    searchYearText.setEditable(true);
                                    searchYearText.setBorder(border6);
                                    
                                    searchLoadCapacityText.setEditable(true);
                                    searchLoadCapacityText.setBorder(border6);
                                    
                                    searchSeatNumbersText.setEditable(true);
                                    searchSeatNumbersText.setBorder(border6);
                                    
                                    
                                    // for the type of vehicle chosen
                                    searchVehicleComboBox.addItemListener(r2 -> {
                                    
                                        Object vs = searchVehicleComboBox.getSelectedItem();
                                        
                                        // for motorcycle
                                        if(vs.equals("Motorcycle")){
                                            
                                            searchLoadCapacityLabel.setForeground(Color.gray);
                                            searchLoadCapacityText.setEnabled(false);
                                            searchLoadCapacityText.setText("");
                                            
                                            searchSeatNumbersLabel.setForeground(Color.gray);
                                            searchSeatNumbersText.setEnabled(false);
                                            searchSeatNumbersText.setText("");
                                            
                                            // vehicle is a motorcycle if edited
                                            vehicleAfterEdit = 1;
                                        }
                                        // for light vehicle
                                        else if(vs.equals("Light vehicle")){
                                            
                                            searchLoadCapacityLabel.setForeground(Color.gray);
                                            searchLoadCapacityText.setEnabled(false);
                                            searchLoadCapacityText.setText("");
                                            
                                            searchSeatNumbersLabel.setForeground(Color.black);
                                            searchSeatNumbersText.setEnabled(true);
                                            
                                            // vehicle is light vehicle if edited
                                            vehicleAfterEdit = 2;
                                        }
                                        // for heavy vehicle
                                        else{
                                            
                                            searchLoadCapacityLabel.setForeground(Color.black);
                                            searchLoadCapacityText.setEnabled(true);
                                            
                                            searchSeatNumbersLabel.setForeground(Color.gray);
                                            searchSeatNumbersText.setEnabled(false);
                                            searchSeatNumbersText.setText("");
                                            
                                            // vehicle is a heavy vehicle if edited
                                            vehicleAfterEdit = 3;
                                        }                                        
                                    });                                            
                                });
                                
                                                                
                                /**
                                 * adding functionality to "Save" button 
                                 */
                                vehicleSave.addActionListener(r5 ->{
                                    
                                    // for engine capacity of vehicle
                                    double vehicleEngine;
                                    if(searchEngineCapacityText.getText().equals("")){
                                        errorMessageBox("You must enter the engine capacity");
                                        searchEngineCapacityText.requestFocus();
                                        return;
                                    }
                                    
                                    //checking whether the entered engine capacity is a double or not
                                    try{
                                        Double.parseDouble(searchEngineCapacityText.getText()); 
                                        vehicleEngine = Double.parseDouble(searchEngineCapacityText.getText());
                                    }
                                    catch(NumberFormatException c3){
                                        errorMessageBox("You should enter engine capacity as numbers only");
                                        searchEngineCapacityText.setText("");
                                        searchEngineCapacityText.requestFocus();
                                        return;
                                    }


                                    // for brand of vehicle
                                    String vehicleMake1; 
                                    if(searchMakeText.getText().equals("")){
                                        errorMessageBox("You must enter the vehicle's brand");
                                        searchMakeText.requestFocus();
                                        return;
                                    }

                                    String checkingSearchModel = searchMakeText.getText();
                                    boolean checkSearchModel  = true;

                                    // converting string to an array of its characters
                                    char[] charSearchModelArray = checkingSearchModel.toCharArray();

                                    // checking if character is not a string
                                    for(char ch : charSearchModelArray){
                                        if(Character.isLetter(ch) == false){
                                            checkSearchModel = false;
                                            break;
                                        }                    
                                    }
                                    if(checkSearchModel == true){
                                        vehicleMake1 = searchMakeText.getText();
                                    }
                                    else{
                                        errorMessageBox("You must enter brand name with alphabets");
                                        searchMakeText.setText("");
                                        searchMakeText.requestFocus();
                                        return;
                                    }

                                    

                                    // for model of vehicle
                                    String vehicleModel1;                      // vehicle's model
                                    if(searchModelText.getText().equals("")){
                                        errorMessageBox("You must enter the model of vehicle");
                                        searchModelText.requestFocus();
                                        return;
                                    }
                                    else{
                                        vehicleModel1 = searchModelText.getText();
                                    }


                                    // for year of manufacture of vehicle
                                    int vehicleYear1; 
                                    if(searchYearText.getText().equals("")){
                                        errorMessageBox("You must enter vehicle's year of manufacture");
                                        searchYearText.requestFocus();
                                        return;
                                    }
                                    
                                    // checking whether the year entered is an integer or not
                                    try{
                                        Integer.parseInt(searchYearText.getText());
                                        vehicleYear1 = Integer.parseInt(searchYearText.getText()); 
                                    }
                                    catch(NumberFormatException c4){
                                        errorMessageBox("You must enter year as numbers");
                                        searchYearText.setText("");
                                        searchYearText.requestFocus();
                                        return;
                                    }
                                    
                                    // temporary variable to store plate number
                                    String plateAfterEdit;
                                    
                                    /**
                                     * when the vehicle type of the owner is not changed
                                     * only the details is updated and not the vehicle type
                                     */
                                    if(vehicleBeforeEdit == vehicleAfterEdit){
                                        
                                        plateAfterEdit = EditingPlateNumber;
                                        
                                        // for checking the type of vehicle
                                        switch ((String)searchVehicleComboBox.getSelectedItem()) {

                                            // for motorcycle
                                            case "Motorcycle":

                                                // adding motorcycle details to object of motorcycleArray
                                                motorcycleArray.add(vehicleArrayPlace, new Motorcycle(plateAfterEdit, vehicleEngine, vehicleMake1, vehicleModel1, vehicleYear1, ownerId));

                                                // confirmation message
                                                confirmationMessage(String.format("The motorcycle has been updated with the following details: \n"
                                                        + "Plate Number: %s\n"
                                                        + "Engine Capacity: %.1f Litre\n"
                                                        + "Make: %s\n"
                                                        + "Model: %s\n"
                                                        + "Year: %d", plateAfterEdit, vehicleEngine, vehicleMake1, vehicleModel1, vehicleYear1));

                                                break;

                                            // for light vehicle    
                                            case "Light vehicle":                        

                                                // for number of seats of light vehicle
                                                int vehicleSeatNumbers;
                                                if(searchSeatNumbersText.getText().equals("")){
                                                    errorMessageBox("You must enter the number of seats");
                                                    searchSeatNumbersText.requestFocus();
                                                    return;
                                                }  
                                                
                                                // checking whether the entered seat number is an integer or not
                                                try{
                                                    Integer.parseInt(searchSeatNumbersText.getText());
                                                    vehicleSeatNumbers = Integer.parseInt(searchSeatNumbersText.getText());

                                                    // adding light vehicle details to object of lightVehicleArray
                                                    lightVehicleArray.add(vehicleArrayPlace, new LightVehicle(plateAfterEdit, vehicleEngine, vehicleMake1, vehicleModel1, vehicleYear1, ownerId, vehicleSeatNumbers));

                                                    // confiramtion message
                                                    confirmationMessage(String.format("The light vehicle is registered with the following details: \n"
                                                                + "Plate Number: %s\n"
                                                                + "Engine Capacity: %.1f Litre\n"
                                                                + "Make: %s\n"
                                                                + "Model: %s\n"
                                                                + "Year: %d\n"
                                                                + "Seat number: %d", plateAfterEdit, vehicleEngine, vehicleMake1, vehicleModel1, vehicleYear1, vehicleSeatNumbers));


                                                }
                                                catch(NumberFormatException c6){
                                                    errorMessageBox("You must enter number of seats a number");
                                                    searchSeatNumbersText.setText("");
                                                    searchSeatNumbersText.requestFocus();
                                                }                       
                                                break;

                                            // for heavy vehicle    
                                            case "Heavy vehicle":

                                                // for load capacity of heavy vehicle
                                                double vehicleLoadCapacity;
                                                if(searchLoadCapacityText.getText().equals("")){
                                                    errorMessageBox("You must enter the load capacity");
                                                    searchLoadCapacityText.requestFocus();
                                                    return;
                                                }  
                                                
                                                // checking whether the entered load capacity is a double or not
                                                try{
                                                    Double.parseDouble(searchLoadCapacityText.getText());
                                                    vehicleLoadCapacity = Double.parseDouble(searchLoadCapacityText.getText());

                                                    // adding heavy vehicle details to object of heavyVehicleArray
                                                    heavyVehicleArray.add(new HeavyVehicle(plateAfterEdit, vehicleEngine, vehicleMake1, vehicleModel1, vehicleYear1, ownerId, vehicleLoadCapacity));

                                                    // confirmation message
                                                    confirmationMessage(String.format("The heavy vehicle has been updated with the following details: \n"
                                                            + "Plate Number: %s\n"
                                                            + "Engine Capacity: %.1f Litre\n"
                                                            + "Make: %s\n"
                                                            + "Model: %s\n"
                                                            + "Year: %d\n"
                                                            + "Load Capacity: %.1f Tonne", plateAfterEdit, vehicleEngine, vehicleMake1, vehicleModel1, vehicleYear1, vehicleLoadCapacity));

                                                }
                                                catch(NumberFormatException c5){
                                                    errorMessageBox("You must enter load capacity as numbers");
                                                    searchLoadCapacityText.setText("");
                                                    searchLoadCapacityText.requestFocus();
                                                }                        
                                                break;
                                        }                                        
                                    }
                                    
                                    
                                    /**
                                     * when the type of vehicle of owner is updated
                                     * the previous vehicle's details is deleted and
                                     * the new type of vehicle is given a new plate number.
                                     * This is because one owner cannot have multiple vehicles
                                     */
                                    else if(vehicleBeforeEdit != vehicleAfterEdit){                                       
                                        plateAfterEdit = plateNumber;                                        
                                        
                                        // removing the previous vehicle form their respective arraylist
                                        switch(vehicleBeforeEdit){
                                            
                                            // removing previously owned motorcycle
                                            case 1: motorcycleArray.remove(vehicleArrayPlace);
                                                break;
                                                
                                            // removing previously owned light vehicle
                                            case 2: lightVehicleArray.remove(vehicleArrayPlace);
                                                break;
                                                
                                            // removing previously owned heavy vehicle    
                                            case 3: heavyVehicleArray.remove(vehicleArrayPlace);
                                                break;
                                        }
                                        
                                        // for checking the new type of type of vehicle
                                        switch ((String)searchVehicleComboBox.getSelectedItem()) {

                                            // for motorcycle
                                            case "Motorcycle":

                                                // adding motorcycle details to object of motorcycleArray
                                                motorcycleArray.add(new Motorcycle(plateAfterEdit, vehicleEngine, vehicleMake1, vehicleModel1, vehicleYear1, ownerId));

                                                currentMotorcycle++;
                                                
                                                // confirmation message
                                                confirmationMessage(String.format("The new motorcycle has been added with the following details: \n"
                                                        + "New Plate Number: %s\n"
                                                        + "Engine Capacity: %.1f Litre\n"
                                                        + "Make: %s\n"
                                                        + "Model: %s\n"
                                                        + "Year: %d", plateAfterEdit, vehicleEngine, vehicleMake1, vehicleModel1, vehicleYear1));
                                                break;

                                                
                                            // for light vehicle    
                                            case "Light vehicle":                        

                                                // for number of seats of light vehicle
                                                int vehicleSeatNumbers;
                                                if(searchSeatNumbersText.getText().equals("")){
                                                    errorMessageBox("You must enter the number of seats");
                                                    searchSeatNumbersText.requestFocus();
                                                    return;
                                                }   
                                                
                                                // checking whether the entered seat number is an integer or not
                                                try{
                                                    Integer.parseInt(searchSeatNumbersText.getText());
                                                    vehicleSeatNumbers = Integer.parseInt(searchSeatNumbersText.getText());

                                                    // adding light vehicle details to object of lightVehicleArray
                                                    lightVehicleArray.add(new LightVehicle(plateAfterEdit, vehicleEngine, vehicleMake1, vehicleModel1, vehicleYear1, ownerId, vehicleSeatNumbers));

                                                    // confiramtion message
                                                    confirmationMessage(String.format("The new light vehicle is registered with the following details: \n"
                                                                + "New Plate Number: %s\n"
                                                                + "Engine Capacity: %.1f Litre\n"
                                                                + "Make: %s\n"
                                                                + "Model: %s\n"
                                                                + "Year: %d\n"
                                                                + "Seat number: %d", plateAfterEdit, vehicleEngine, vehicleMake1, vehicleModel1, vehicleYear1, vehicleSeatNumbers));


                                                }
                                                catch(NumberFormatException c6){
                                                    errorMessageBox("You must enter number of seats a number");
                                                    searchSeatNumbersText.setText("");
                                                    searchSeatNumbersText.requestFocus();
                                                }                       
                                                break;

                                            // for heavy vehicle    
                                            case "Heavy vehicle":

                                                // for load capacity of heavy vehicle
                                                double vehicleLoadCapacity;
                                                if(searchLoadCapacityText.getText().equals("")){
                                                    errorMessageBox("You must enter the load capacity");
                                                    searchLoadCapacityText.requestFocus();
                                                    return;
                                                } 
                                                
                                                // checking whether the entered load capacity is a double or not
                                                try{
                                                    Double.parseDouble(searchLoadCapacityText.getText());
                                                    vehicleLoadCapacity = Double.parseDouble(searchLoadCapacityText.getText());

                                                    // adding heavy vehicle details to object of heavyVehicleArray
                                                    heavyVehicleArray.add(new HeavyVehicle(plateAfterEdit, vehicleEngine, vehicleMake1, vehicleModel1, vehicleYear1, ownerId, vehicleLoadCapacity));

                                                    // confirmation message
                                                    confirmationMessage(String.format("The new heavy vehicle has been updated with the following details: \n"
                                                            + "Plate Number: %s\n"
                                                            + "Engine Capacity: %.1f Litre\n"
                                                            + "Make: %s\n"
                                                            + "Model: %s\n"
                                                            + "Year: %d\n"
                                                            + "Load Capacity: %.1f Tonne", plateAfterEdit, vehicleEngine, vehicleMake1, vehicleModel1, vehicleYear1, vehicleLoadCapacity));

                                                }
                                                catch(NumberFormatException c5){
                                                    errorMessageBox("You must enter load capacity as numbers");
                                                    searchLoadCapacityText.setText("");
                                                    searchLoadCapacityText.requestFocus();
                                                }                        
                                                break;
                                        }  
                                        
                                        
                                        /**
                                         * changing the global variable plateNumber so that 
                                         * it can be used for the new vehicle registered
                                         */
                                        String num = "";    // initial number of plate number

                                        // seperating the number from plate number
                                        for(int i = 3; i < plateNumber.length(); i++){
                                            num += plateNumber.charAt(i);
                                        }

                                        // converting the 4-digit number in plate number to integer
                                        Integer num2 = Integer.parseInt(num);

                                        // adding 13 to the 4-digit integer
                                        int newNum = num2 + 13;  

                                        // converting the new 4-digit number to string
                                        String num3 = Integer.toString(newNum);

                                        // appending the new 4-digit number to "AUS"
                                        plateNumber = "VIC" + num3;
                                    }
                                              
                                    
                                    // hiding the search result frame and showing the search frame
                                    searchVehicleFrame.hide();
                                    vehicleSearchArea.setText("");
                                    vehicleSearchf.setVisible(true);
                                    vehicleSearchArea.requestFocus();
                                    
                                });
                                
                                
                                
                                /**
                                 * adding functionality to "Clear" button
                                 */
                                vehicleClear.addActionListener(r4 -> {
                                    
                                    // clearing all the text fields
                                    searchEngineCapacityText.setText("");
                                    searchMakeText.setText("");
                                    searchModelText.setText("");
                                    searchYearText.setText("");                                    
                                    searchLoadCapacityText.setText("");
                                    searchSeatNumbersText.setText("");
                                    
                                    // changing the default choice to motorcycle
                                    searchVehicleComboBox.setSelectedItem("Motorcycle"); 
                                });                                                          
                                
                                
                                /**
                                 * adding functionality to "Back" button
                                 */
                                vehicleSearchBack.addActionListener(r -> {

                                    searchVehicleFrame.hide();
                                    vehicleSearchArea.setText("");
                                    vehicleSearchf.setVisible(true);
                                    vehicleSearchArea.requestFocus();
                                });


                                /**
                                 * adding functionality to "Exit" button
                                 */
                                vehicleSearchExit.addActionListener(s -> {
                                    searchVehicleFrame.hide();
                                    exit();
                                    });


                                /**
                                 * when the user pushes the system close (X top right corner)
                                 */
                                // override window closing method
                                searchVehicleFrame.addWindowListener(new WindowAdapter(){
                                    @Override
                                    public void windowClosing(WindowEvent d5){  // Attempt to exit application
                                        exit();				
                                    }
                                });
                            }                            
                        }                            
                    }
                }             
            });
            
            
            
            /**
             * adding functionality to "Back" button
             */
            vehicleBackButton.addActionListener(o -> {
                
                vehicleSearchf.hide();
                this.setVisible(true);
            });
            
                        
            /**
             * adding functionality to "Exit" button
             */
            vehicleExitButton.addActionListener(p -> {
                vehicleSearchf.hide();
                exit();
                });
            
            
            /**
             * when the user pushes the system close (X top right corner)
             */
            // override window closing method
            vehicleSearchf.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent d6){  // Attempt to exit application
                    exit();				
                }
            });
            
            
         // end of vehicle info search and edit button action listener    
        });
        
        
        
        /**
         * adding functionality to "Exit" button
         */
        exit.addActionListener(d -> {
            this.hide();
            exit();           
            });
        
        
        /**
         * when the user pushes the system close (X top right corner)
         */
        // override window closing method
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent d1){  // Attempt to exit application      
               exit();				
            }
	});
        
                      
     // end of constructor   
    }
    

    /**
     * exit() method
     * to exit the application
     */
    public void exit(){
        JFrame frame6 = new JFrame();
        String title = "Motor Vehicle Registration (MVR)";
                
        int n = JOptionPane.showConfirmDialog(frame6, "Do you want to exit the system?", title,
                            JOptionPane.YES_NO_OPTION);
        
        // for "Yes" button
        if(n == JOptionPane.YES_OPTION){
            System.exit(0);
        } 
        // for "No" button
        else if (n == JOptionPane.NO_OPTION) {
            frame6.hide();
        }
    }
    
    
    /**
     * errorMessageBox method
     * @param errorMessage 
     * frame for all the error messages
     */
    private void errorMessageBox(String errorMessage){                  //method to create an error message window
            
        JFrame frame2 = new JFrame();
        String title = "Error message";
        JOptionPane.showMessageDialog(frame2, errorMessage, title, JOptionPane.ERROR_MESSAGE);
    }
    
    
    /**
     * confirmation message
     * @param confirm 
     * frame for confirmation of registration
     */
    private void confirmationMessage(String confirm){
        
        JFrame frame5 = new JFrame();
        String title = "Confirmation message";
        JOptionPane.showMessageDialog(frame5, confirm, title, JOptionPane.PLAIN_MESSAGE);
    }
    
    
    /**
     * main method 
     * @param args 
     * contains the frame for the main menu
     */
    public static void main(String[] args){
        
        EventQueue.invokeLater(() -> {
            
            // making a new frame
            JFrame frame = new SystemGui();        
            
            frame.setTitle("Motor Vehicle Registration(MVR)");      // title of app 
            frame.setLocationRelativeTo(null);                      // placing app at center of screen
            frame.setVisible(true);                                 // making app visible
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);   // making app close when the X button is clicked
            frame.setResizable(true);                               // making app resizable
        });
        
     // end of main method   
    }
    
 // End of class
}
