
package Assignment1;

import java.awt.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
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
    private final int DEFAULT_HEIGHT = 215;
    
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
            regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // making app close when X button is clicked
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
            JLabel abnLabel = new JLabel("Australian Business Number");
            JLabel ownerType = new JLabel("Select the which type of owner");
    
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
            JRadioButton hiddenButton = new JRadioButton("Hidden");
    
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
            buttonGroup.add(hiddenButton);
            hiddenButton.isSelected();      
            
            // selecting type of owner
            panela.add(ownerType);
            panelb.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
            panelb.add(privateOwnerButton);
            panelb.add(corporateOwnerButton);
            
            panelc.setLayout(new BorderLayout());
            panelc.add(panela, BorderLayout.NORTH);
            panelc.add(panelb, BorderLayout.CENTER);
                       
            // adding label and text to the nested panel
            paneld.setLayout(new GridLayout(5, 2, 10, 4));
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
            vehicleComboBox.setSelectedIndex(0);
            
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
            
                // for first name
                String fName;
                if(fNameText.getText().equals("")){
                    errorMessageBox("You must enter first name");
                    fNameText.requestFocus();
                    return;
                }
                
                String checkingfName = fNameText.getText();
                boolean checkfNameBool = true;
                checkingfName = checkingfName.toLowerCase();
                char[] charArray = checkingfName.toCharArray();
                for(int i =0; i < charArray.length; i++){
                    char ch = charArray[i];
                    if(!(ch >= 'a' && ch <= 'z')){
                        checkfNameBool = false;
                    }
                }
                if(checkfNameBool = true){
                    fName = fNameText.getText();
                }
                else{
                    errorMessageBox("You must enter first name with alphabets");
                    fNameText.requestFocus();
                    return;
                }
                            
                
                // for last name
                String lName;             
                if(lNameText.getText().equals("")){
                    errorMessageBox("You must enter last name");
                    lNameText.requestFocus();
                    return;
                }
                try{
                    Integer.parseInt(lNameText.getText());
                    errorMessageBox("You should enter words for last name");
                    lNameText.requestFocus();
                    return;
                }
                catch(NumberFormatException c7){
                    lName = lNameText.getText();
                }
                          
                
                // for licence number
                int licenceNumber;
                if(licenceNumberText.getText().equals("")){
                    errorMessageBox("You must enter a licence number");
                    licenceNumberText.requestFocus();
                    return;
                }   
                try{ 
                    Integer.parseInt(licenceNumberText.getText()); 
                    licenceNumber = Integer.parseInt(licenceNumberText.getText());
                }  
                catch(NumberFormatException c1){ 
                     errorMessageBox("You must enter numbers for licence number"); 
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
                else{
                    phoneNo = phoneNoText.getText();
                }
                
                
                // checking if type of owner is chosen or not
                String ownerTypeCheck = "";
                if(hiddenButton.isSelected()){
                    errorMessageBox("You must choose if you are a private owner or a corporate owner");
                    privateOwnerButton.requestFocus();
                    return;
                }
                else if(privateOwnerButton.isSelected()){
                    ownerTypeCheck = "private";
                }
                else{
                    ownerTypeCheck = "corporate";
                }
                
                // for date of birth
                String dateOfBirth;// = dobText.getText();         // date of birth
                if(dobText.getText().equals("")){
                    errorMessageBox("You must enter date of birth");
                    return;
                }
                else{
                    dateOfBirth = dobText.getText(); 
                }
                
                
                // for Australian Business Number
                int abn;
                if(abnText.getText().equals("")){
                    errorMessageBox("You must enter Australian Business Number");
                    abnText.requestFocus();
                    return;
                }
                try{
                    Integer.parseInt(abnText.getText());
                    abn = Integer.parseInt(abnText.getText());
                }
                catch(NumberFormatException c2){
                    errorMessageBox("You must enter only numbers");
                    abnText.requestFocus();
                    return;
                }
                
                
                // checking if the owner is private or corporate
                if(ownerTypeCheck.equals("private")){
                    
                    // adding details of private owner object in arraylist
                    privateOwnerArray.add(new PrivateOwner(fName, lName, licenceNumber, address, phoneNo, dateOfBirth));
                }
                else if(ownerTypeCheck.equals("corporate")){
                    
                    // adding details of corporate owner object in arraylist
                    corporateOwnerArray.add(new CorporateOwner(fName, lName, licenceNumber, address, phoneNo, abn));
                }
                
                
                // assigning plate number to the vehicle registered
                String plateNumber = "AUS2033";
                
                
                // for engine capacity of vehicle
                double engineCapacity;
                if(engineCapacityText.getText().equals("")){
                    errorMessageBox("You must enter the engine capacity");
                    engineCapacityText.requestFocus();
                    return;
                }
                try{
                    Double.parseDouble(engineCapacityText.getText()); 
                    engineCapacity = Double.parseDouble(engineCapacityText.getText());
                }
                catch(NumberFormatException c3){
                    errorMessageBox("You should enter only numbers");
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
                else if(!(makeText.getText() instanceof String)){
                    errorMessageBox("You must brand name with words");
                    makeText.requestFocus();
                    return;
                }
                else{
                    make = makeText.getText();
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
                try{
                    Integer.parseInt(yearText.getText());
                    year = Integer.parseInt(yearText.getText()); 
                }
                catch(NumberFormatException c4){
                    errorMessageBox("You must enter year as number");
                    yearText.requestFocus();
                    return;
                }
                
                
                // for load capacity of heavy vehicle
                double loadCapacity;
                if(loadCapacityText.getText().equals("")){
                    errorMessageBox("You must enter the load capacity");
                    loadCapacityText.requestFocus();
                    return;
                }
                try{
                    Double.parseDouble(loadCapacityText.getText());
                    loadCapacity = Double.parseDouble(loadCapacityText.getText());
                }
                catch(NumberFormatException c5){
                    errorMessageBox("You must enter load capacity as numbers");
                    loadCapacityText.requestFocus();
                    return;
                }
                
                
                // for number of seats of light vehicle
                int seatNumbers;
                if(seatNumbersText.getText().equals("")){
                    errorMessageBox("You must enter the number of seats");
                    seatNumbersText.requestFocus();
                    return;
                }
                try{
                    Integer.parseInt(seatNumbersText.getText());
                    seatNumbers = Integer.parseInt(seatNumbersText.getText());
                }
                catch(NumberFormatException c6){
                    errorMessageBox("You must enter number of seats a number");
                    seatNumbersText.requestFocus();
                    return;
                }
                
                
                // checking the type of vehicle
                if(((String)vehicleComboBox.getSelectedItem()).equals("Motorcycle")){
                    
                    motorcycleArray.add(new Motorcycle(plateNumber, engineCapacity, make, model, year, licenceNumber));
                }
                else if(((String)vehicleComboBox.getSelectedItem()).equals("Light vehicle")){
                    
                    lightVehicleArray.add(new LightVehicle(plateNumber, engineCapacity, make, model, year, licenceNumber, seatNumbers));
                }
                else{
                    
                    heavyVehicleArray.add(new HeavyVehicle(plateNumber, engineCapacity, make, model, year, licenceNumber, loadCapacity));
                }
                
                
                /**
                 * The first plate number assigned is "AUS2033"
                 * changing the four numbers in the plate number for every new vehicle
                 */
                String letter = "";
                String num = "";
                
                // sepearting "AUS" from plate number
                for(int i = 0; i < plateNumber.indexOf("S") + 1; i++){
                    letter += plateNumber.charAt(i);
                }
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
                plateNumber = letter + num3;
                
            
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
                hiddenButton.setSelected(true);
                dobText.setText("");
                abnText.setText("");
                
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
            ownerSearchf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         // making app close when X button is clicked
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
            panela2.setLayout(new BorderLayout());
            
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
            
                // so that the search menu is hidden
                ownerSearchf.hide();
            
                // frame search result of owner registration information
                JFrame searchOwnerFrame = new JFrame();
            
                searchOwnerFrame.setTitle("Owner Search Result");                      // title of frame
                searchOwnerFrame.setSize(500, 310);                                 // size of app
                searchOwnerFrame.setVisible(true);                                  // making app visible
                searchOwnerFrame.setLocationRelativeTo(null);                       // making app appear in center of screen
                searchOwnerFrame.setResizable(true);                                // making app sizable
                searchOwnerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // making app close when X button is clicked
                searchOwnerFrame.setLayout(new BorderLayout());        
            
                // making a titled border for owner details
                TitledBorder searchOwnerLine = BorderFactory.createTitledBorder(" Owenr Information ");
                searchOwnerLine.setTitleColor(Color.BLUE);
            
                // making border 
                Border border1 = BorderFactory.createLineBorder(Color.BLACK, 1);
             
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
                
                // buttons
                JButton ownerSearchEdit = new JButton("Edit");
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
                
                /**
                 * adding functionality to "Back" button
                 */
                ownerSearchBack.addActionListener(l -> {
                    
                    searchOwnerFrame.hide();
                    ownerSearchf.setVisible(true); 
                });
                
                /**
                 * adding functionality to "Exit" button
                 */
                ownerSearchExit.addActionListener(m -> exit());

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
            ownerExitButton.addActionListener(j -> exit());
            
            // adding all nested panel to main panel
            ownerMainPanel.add(panela4, BorderLayout.CENTER);
            
            // adding main panel to the search frame
            ownerSearchf.add(ownerMainPanel);
            
                       
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
            vehicleSearchf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         // making app close when X button is clicked
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
            Border border2 = BorderFactory.createLineBorder(Color.BLACK, 1);
            vehicleSearchArea.setBorder(border2);
            
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
                
                // so that the search menu is hidden
                vehicleSearchf.hide();
            
                // frame search result of vehicle registration information
                JFrame searchVehicleFrame = new JFrame();
            
                searchVehicleFrame.setTitle("Vehicle Search Result");                 // title of frame
                searchVehicleFrame.setSize(500, 260);                                 // size of app
                searchVehicleFrame.setVisible(true);                                  // making app visible
                searchVehicleFrame.setLocationRelativeTo(null);                       // making app appear in center of screen
                searchVehicleFrame.setResizable(true);                                // making app sizable
                searchVehicleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // making app close when X button is clicked
                searchVehicleFrame.setLayout(new BorderLayout());        
            
                // making a titled border for vehicle details
                TitledBorder searchVehicleLine = BorderFactory.createTitledBorder(" Vehicle Information ");
                searchVehicleLine.setTitleColor(Color.BLUE);
            
                // making border
                Border border3 = BorderFactory.createLineBorder(Color.BLACK, 1);
                
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
                
                
                /**
                 * adding functionality to "Back" button
                 */
                vehicleSearchBack.addActionListener(r -> {
                    
                    searchVehicleFrame.hide();
                    vehicleSearchf.setVisible(true);
                });
                
                
                /**
                 * adding functionality to "Exit" button
                 */
                vehicleSearchExit.addActionListener(s -> exit());
                
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
            vehicleExitButton.addActionListener(p -> exit());
            
            
         // end of vehicle info search and edit button action listener    
        });
        
        
        
        /**
         * adding functionality to "Exit" button
         */
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
    
    
    private void errorMessageBox(String errorMessage){                  //method to create an error message window
            
        JFrame frame2 = new JFrame();
        String title = "Error message";
        JOptionPane.showMessageDialog(frame2, errorMessage, title, JOptionPane.ERROR_MESSAGE);
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
