
package Assignment1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * @author pujan
 * StudentId 12134829
 * OwnerInfoPanel class for the panel related to owner 
 */
public class OwnerInfoPanel extends JPanel{
     
    private String firstName;             // first name
    private String lastName;              // last name
    private int lNumber;                  // licence number
    private String addr;                  // address
    private String pNumber;               // phone number
    private String DateOB;                // date of birth
    private int australianBN;             // Australian Business Number
    private int selectedOwnerType;        // which owner type is selected
    
    
    /**
     * constructor
     * @param fName              // first name
     * @param lName              // last name
     * @param licenceNumber      // license number
     * @param address            // address
     * @param phoneNumber        // phone number
     * @param dob                // date of birth
     * @param abn                // Australian Business Number
     */
    public OwnerInfoPanel(String fName, String lName, int licenceNumber, String address, String phoneNumber, String dob, int abn){
        
        firstName = fName;
        lastName = lName;
        lNumber = licenceNumber;
        addr = address;
        pNumber = phoneNumber;
        DateOB = dob;
        australianBN = abn; 
        
        // making a titled border for owner detail entry
        TitledBorder ownerLine = BorderFactory.createTitledBorder(" Owenr Information ");
        ownerLine.setTitleColor(Color.BLUE);
        
        // making border
        Border border6 = BorderFactory.createLineBorder(Color.black, 1);        
        
        // main panel for entering owner details
        JPanel ownerPanel = new JPanel();            
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
        fNameText.setText(fName);
        fNameText.setBorder(border6);
            
        JTextField lNameText = new JTextField(15);
        lNameText.setText(lName);
        lNameText.setBorder(border6);
            
        JTextField licenceNumberText = new JTextField(15);
        String licenceNumberInt = Integer.toString(licenceNumber);
        licenceNumberText.setText(licenceNumberInt);
        licenceNumberText.setBorder(border6);
            
        JTextField addrText = new JTextField(15);
        addrText.setText(address);
        addrText.setBorder(border6);
            
        JTextField phoneNoText = new JTextField(15);
        phoneNoText.setText(phoneNumber);
        phoneNoText.setBorder(border6);
            
        JTextField dobText = new JTextField(15);
        dobText.setText(dob);
        dobText.setBorder(border6);
            
        JTextField abnText = new JTextField(15);
        String abnInt = Integer.toString(abn);
        abnText.setText(abnInt);
        abnText.setBorder(border6);
    
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
        hiddenButton.setSelected(true);      
            
                         
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
        if(hiddenButton.isSelected()){
            abnLabel.setForeground(Color.gray);                                            
            abnText.setEnabled(false);
            dobLabel.setForeground(Color.gray);
            dobText.setEnabled(false);
               
            selectedOwnerType = 0;
        }           
            
        // when private radio button is selected
        privateOwnerButton.addActionListener(event -> {
                
            dobLabel.setForeground(Color.black);                                                  
            dobText.setEnabled(true);
            abnLabel.setForeground(Color.gray);
            abnText.setEnabled(false);
            abnText.setText("");
            
            selectedOwnerType = 1;
        });
            
        // when corporate radio button is selected
        corporateOwnerButton.addActionListener(event2 -> {
               
            abnLabel.setForeground(Color.black);                
            abnText.setEnabled(true);
            dobLabel.setForeground(Color.gray);
            dobText.setEnabled(false);
            dobText.setText("");
            
            selectedOwnerType = 2;
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
        
        
     // end of constructor   
    }
    
    
    /**
     * setFirstName mutator method
     * @param firstName 
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    
    /**
     * setLastName mutator method
     * @param lastName 
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    
    /**
     * setLicenceNumber mutator method
     * @param lNumber 
     */
    public void setLicenceNumber(int lNumber){
        this.lNumber = lNumber;
    }
    
    
    /**
     * setAddress mutator method
     * @param addr 
     */
    public void setAddress(String addr){
        this.addr = addr;
    }
    
    
    /**
     * setPhoneNumber mutator method
     * @param pNumber 
     */
    public void setPhoneNumber(String pNumber){
        this.pNumber = pNumber;
    }
    
    
    /**
     * setDateOfBirth mutator method
     * @param DateOB 
     */
    public void setDateOfBirth(String DateOB){
        this.DateOB = DateOB;
    }
    
    
    /**
     * setAustralianBusinessNumber mutator method
     * @param australianBN 
     */
    public void setAustralianBusinessNumber(int australianBN){
        this.australianBN = australianBN;
    }
    
    
    /**
     * getFirstName accessor method
     * @return first name
     */
    public String getFirstName(){
        return firstName;
    }
    
    
    /**
     * getLastName accessor method
     * @return last name
     */
    public String getLastName(){
        return lastName;
    }
    
    
    /**
     * getLicenceNumber accessor method
     * @return licence method
     */
    public int getLicenceNumber(){
        return lNumber;
    }
    
    
    /**
     * getAddress accessor method
     * @return address
     */
    public String getAddress(){
        return addr;
    }
    
    
    /**
     * getPhoneNumber accessor method
     * @return phone number
     */
    public String getPhoneNumber(){
        return pNumber;
    }
    
    
    /**
     * getDateOfBirth accessor method
     * @return date of birth
     */
    public String getDateOfBirth(){
        return DateOB;
    }
    
    
    /**
     * getAustralianBusinessNumber accessor method
     * @return Australian Business Number
     */
    public int getAustralianBusinessNumber(){
        return australianBN;
    }
    
    
    /**
     * getSelectedOwner accessor method
     * @return the selected owner type
     */
    public int getSelectedOwner(){
        return selectedOwnerType;
    }
    

 // End of class
}
