package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.Address;
import main.Person;
import main.Validation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistrationPage {

	private JFrame frame;
	private JTextField textFieldPostcode;
	private JTextField textFieldStreetName;
	private JTextField textFieldPlaceName;
	private JTextField textFieldHouseNumber;
	private JPasswordField textFieldPassword;
	private JTextField textFieldEmail;
	private JTextField textFieldContact;
	private JTextField textFieldForename;
	private JTextField textFieldSurname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationPage window = new RegistrationPage();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistrationPage() {
		initialize();
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 850);
		frame.setMinimumSize(new Dimension(1200, 850));
		frame.setTitle("Registration Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(panel_1);
		
		JLabel lblPageTitle = new JLabel("Registration Page");
		lblPageTitle.setBackground(Color.LIGHT_GRAY);
		lblPageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPageTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JPanel panelPostcode = new JPanel();
		panelPostcode.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblpostcode = new JLabel("Postcode:");
		lblpostcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPostcode.add(lblpostcode);
		
		textFieldPostcode = new JTextField();
		textFieldPostcode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPostcode.setColumns(10);
		panelPostcode.add(textFieldPostcode);
		
		JPanel panelStreetNumber = new JPanel();
		panelStreetNumber.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblStreetName = new JLabel("Street Name:");
		lblStreetName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelStreetNumber.add(lblStreetName);
		
		textFieldStreetName = new JTextField();
		textFieldStreetName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldStreetName.setColumns(10);
		panelStreetNumber.add(textFieldStreetName);
		
		JPanel panelPlaceName = new JPanel();
		panelPlaceName.setBackground(Color.LIGHT_GRAY);
		
		JLabel lbPlaceName = new JLabel("Place Name:");
		lbPlaceName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPlaceName.add(lbPlaceName);
		
		textFieldPlaceName = new JTextField();
		textFieldPlaceName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPlaceName.setColumns(10);
		panelPlaceName.add(textFieldPlaceName);
		
		JPanel panelHouse = new JPanel();
		panelHouse.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblHouse = new JLabel("House Name or Number:");
		lblHouse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelHouse.add(lblHouse);
		
		textFieldHouseNumber = new JTextField();
		textFieldHouseNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldHouseNumber.setColumns(10);
		panelHouse.add(textFieldHouseNumber);
		
		JPanel panelAddress = new JPanel();
		panelAddress.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelAddress.add(lblAddress);
		
		JPanel panelRole = new JPanel();
		panelRole.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblRole = new JLabel("Role: ");
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelRole.add(lblRole);
		
		JCheckBox chckbxGuest = new JCheckBox("Guest");
		chckbxGuest.setHorizontalAlignment(SwingConstants.TRAILING);
		chckbxGuest.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxGuest.setBackground(Color.LIGHT_GRAY);
		panelRole.add(chckbxGuest);
		
		JCheckBox chckbxHost = new JCheckBox("Host");
		chckbxHost.setHorizontalAlignment(SwingConstants.TRAILING);
		chckbxHost.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxHost.setBackground(Color.LIGHT_GRAY);
		panelRole.add(chckbxHost);
		
		JPanel panelPassword = new JPanel();
		panelPassword.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPassword.add(lblPassword);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPassword.setColumns(15);
		panelPassword.add(textFieldPassword);
		
		JPanel panelEmail = new JPanel();
		panelEmail.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelEmail.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setToolTipText("");
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldEmail.setColumns(21);
		panelEmail.add(textFieldEmail);
		
		JPanel panelMobileNumber = new JPanel();
		panelMobileNumber.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblContact = new JLabel("Mobile Number:");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelMobileNumber.add(lblContact);
		
		textFieldContact = new JTextField();
		textFieldContact.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldContact.setColumns(15);
		panelMobileNumber.add(textFieldContact);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelTitle.add(lblTitle);
		
		JComboBox comboBoxTitle = new JComboBox();
		comboBoxTitle.setModel(new DefaultComboBoxModel(new String[] {"Mr.", "Mrs.", "Ms.", "Prof.", "Sr.", "Dr."}));
		comboBoxTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelTitle.add(comboBoxTitle);
		
		JPanel panelForename = new JPanel();
		panelForename.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblForename = new JLabel("Forename:");
		lblForename.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelForename.add(lblForename);
		
		textFieldForename = new JTextField();
		textFieldForename.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldForename.setColumns(15);
		panelForename.add(textFieldForename);
		
		JPanel panelSurname = new JPanel();
		panelSurname.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblSurname = new JLabel("Surname:  ");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelSurname.add(lblSurname);
		
		textFieldSurname = new JTextField();
		textFieldSurname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldSurname.setColumns(15);
		panelSurname.add(textFieldSurname);
		
		
		JPanel panelRegister = new JPanel();
		panelRegister.setBackground(Color.LIGHT_GRAY);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String title = (String) comboBoxTitle.getSelectedItem();
				String userId = textFieldEmail.getText().toLowerCase();
				String password = textFieldPassword.getText();
				String forename = textFieldForename.getText();
				String surname = textFieldSurname.getText();
				String contact = textFieldContact.getText();
				int isGuest = chckbxGuest.isSelected() ? 1 : 0;
				int isHost = chckbxHost.isSelected() ? 1 : 0;
				String houseNumber = textFieldHouseNumber.getText();
				String placeName = textFieldPlaceName.getText();
				String streetName = textFieldStreetName.getText();
				String postcode = textFieldPostcode.getText();
				
				if( userId.length() != 0 && password.length() != 0 
						&& forename.length() !=0 && surname.length() != 0 
						&& contact.length() != 0 && (isGuest != 0 || isHost != 0)
						&& houseNumber.length() !=0 && placeName.length() != 0 
						&& streetName.length() !=0 && postcode.length() != 0 ) {		
					
					Validation v = new Validation();
//					System.out.println(v.validateUser("malakas@email.com", "123456", "Host"));
//					db.closeAll(db.res, db.stmt, db.pstmt, db.con);
					
					
					Person m = new Person(title, forename, surname, userId, Integer.parseInt(contact), isHost, isGuest, password);
					Address a = new Address( houseNumber, streetName, placeName, postcode);
					
					if ( forename.length()>20 )
						JOptionPane.showMessageDialog(null, "A forename cannot be longer than 20 characters!", "Invalid Forename", JOptionPane.WARNING_MESSAGE);
					
					else if ( surname.length()>20 )
						JOptionPane.showMessageDialog(null, "A surname cannot be longer than 20 characters!", "Invalid Surname", JOptionPane.WARNING_MESSAGE);
					
					else if ( !(contact.length()>=8 && contact.length()<=11) ) 
						JOptionPane.showMessageDialog(null, "Your contact number must be between 8 and 11 numbers long!", "Invalid Contact Number", JOptionPane.WARNING_MESSAGE);
					
					else if (!v.validEmail(userId)) 
						JOptionPane.showMessageDialog(null, "Please enter a valid email!", "Invalid Email", JOptionPane.WARNING_MESSAGE);
					
					else if (v.isValidPassword(password) != "")
						JOptionPane.showMessageDialog(null, v.isValidPassword(password), "Invalid Password", JOptionPane.WARNING_MESSAGE);
					
					else if (houseNumber.length() > 20 )
						JOptionPane.showMessageDialog(null, "The house name or number cannot be longer than 20 characters!", "Invalid House Name or Number", JOptionPane.WARNING_MESSAGE);
						
					else if (postcode.length() > 15 )
						JOptionPane.showMessageDialog(null, "The postcode cannot be longer than 15 digits!", "Invalid Postcode", JOptionPane.WARNING_MESSAGE);
						
					else if (streetName.length() > 20 )
						JOptionPane.showMessageDialog(null, "The steet name cannot be longer than 20 characters!", "Invalid Street Name", JOptionPane.WARNING_MESSAGE);
					
					else if (placeName.length() > 20 )	
						JOptionPane.showMessageDialog(null, "The place name cannot be longer than 20 characters!", "Invalid Place Name", JOptionPane.WARNING_MESSAGE);
						
					else if (!v.alreadyExcistsPerson(m.getEmail()) && !v.alreadyExcistsAddress(a.getHouse(), a.getPostCode())) {
						v.validateUserRegistration(m, a);
						LoginPage window = new LoginPage();
						window.getFrame().setVisible(true);
						window.getFrame().pack();
						window.getFrame().setLocationRelativeTo(null);
						frame.dispose();
					}
					else {
						System.out.println("already excists");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please fill all the fields!", "Empty Fields", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnRegister.setPreferredSize(new Dimension(100, 40));
		btnRegister.setMinimumSize(new Dimension(100, 40));
		btnRegister.setMaximumSize(new Dimension(100, 40));
		panelRegister.add(btnRegister);
		
		JButton btnRedirectToLogin = new JButton("Log in");
		btnRedirectToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage window = new LoginPage();
				window.getFrame().setVisible(true);
				window.getFrame().pack();
				window.getFrame().setLocationRelativeTo(null);
				frame.dispose();
			}
		});
		btnRedirectToLogin.setPreferredSize(new Dimension(100, 40));
		btnRedirectToLogin.setMinimumSize(new Dimension(100, 40));
		btnRedirectToLogin.setMaximumSize(new Dimension(100, 40));
		btnRedirectToLogin.setHideActionText(true);
		panelRegister.add(btnRedirectToLogin);
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPageTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1105, Short.MAX_VALUE)
						.addComponent(panelForename, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
						.addComponent(panelSurname, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
						.addComponent(panelMobileNumber, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
						.addComponent(panelEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
						.addComponent(panelPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
						.addComponent(panelRole, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
						.addComponent(panelAddress, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
						.addComponent(panelHouse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
						.addComponent(panelPlaceName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
						.addComponent(panelStreetNumber, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
						.addComponent(panelPostcode, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
						.addComponent(panelRegister, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
						.addComponent(panelTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPageTitle, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelForename, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panelSurname, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panelMobileNumber, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panelEmail, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panelPassword, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panelRole, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panelAddress, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panelHouse, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panelPlaceName, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panelStreetNumber, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panelPostcode, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panelRegister, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
	}
}