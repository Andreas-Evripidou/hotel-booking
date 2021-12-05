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

import controllers.PasswordHash;
import controllers.Validation;
import model.Address;
import model.Person;

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
import java.awt.FlowLayout;

public class RegistrationPage extends JPanel{

	private JFrame frame;
	private JTextField textFieldForename;
	private JTextField textFieldSurname;
	private JTextField textFieldUsername;
	private JTextField textFieldContact;
	private JTextField textFieldEmail;
	private JPasswordField textFieldPassword;
	private JTextField textFieldPostcode;
	private JTextField textFieldStreetName;
	private JTextField textFieldPlaceName;
	private JTextField textFieldHouseNumber;
	


	/**
	 * Create the application.
	 */
	public RegistrationPage(JFrame frame) {
		initialize(frame);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frame) {
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setMaximumSize(new Dimension(1200, 850));
		titlePanel.setBackground(Color.LIGHT_GRAY);
		this.add(titlePanel);
		
		JLabel lblPageTitle = new JLabel("Registration Page");
		lblPageTitle.setBackground(Color.LIGHT_GRAY);
		lblPageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPageTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JPanel PersonalInforamtionPanel = new JPanel();
		PersonalInforamtionPanel.setBackground(Color.LIGHT_GRAY);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		JPanel panelRegister = new JPanel();
		panelRegister.setBackground(Color.LIGHT_GRAY);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setPreferredSize(new Dimension(100, 40));
		btnRegister.setMinimumSize(new Dimension(100, 40));
		btnRegister.setMaximumSize(new Dimension(100, 40));
		btnRegister.setBackground(Color.LIGHT_GRAY);
		panelRegister.add(btnRegister);
		
		JButton btnRedirectToLogin = new JButton("Log in");
		btnRedirectToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage newFrame = new LoginPage(frame);
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();
				frame.getContentPane().add(newFrame);
				frame.revalidate();
				frame.repaint();

			}
		});
		btnRedirectToLogin.setPreferredSize(new Dimension(100, 40));
		btnRedirectToLogin.setMinimumSize(new Dimension(100, 40));
		btnRedirectToLogin.setMaximumSize(new Dimension(100, 40));
		btnRedirectToLogin.setHideActionText(true);
		btnRedirectToLogin.setBackground(Color.LIGHT_GRAY);
		panelRegister.add(btnRedirectToLogin);
		
		JButton btnRedirectToHome = new JButton("Home");
		btnRedirectToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage newFrame = new HomePage(frame, null);
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();
				frame.getContentPane().add(newFrame);
				frame.revalidate();
				frame.repaint();

			}
		});
		btnRedirectToHome.setPreferredSize(new Dimension(100, 40));
		btnRedirectToHome.setMinimumSize(new Dimension(100, 40));
		btnRedirectToHome.setMaximumSize(new Dimension(100, 40));
		btnRedirectToHome.setHideActionText(true);
		btnRedirectToHome.setBackground(Color.LIGHT_GRAY);
		panelRegister.add(btnRedirectToHome);
		
		
		GroupLayout gl_titlePanel = new GroupLayout(titlePanel);
		gl_titlePanel.setHorizontalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblPageTitle, GroupLayout.DEFAULT_SIZE, 1159, Short.MAX_VALUE)
					.addGap(20))
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addGap(63)
					.addComponent(PersonalInforamtionPanel, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
					.addGap(74))
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addGap(404)
					.addComponent(panelRegister, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(476, Short.MAX_VALUE))
		);
		gl_titlePanel.setVerticalGroup(
			gl_titlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_titlePanel.createSequentialGroup()
					.addGap(9)
					.addComponent(lblPageTitle, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_titlePanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(PersonalInforamtionPanel, GroupLayout.PREFERRED_SIZE, 608, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(58)
					.addComponent(panelRegister, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		
		JPanel panelAddress = new JPanel();
		panelAddress.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		panelAddress.add(lblAddress);
		
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelAddress, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelHouse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelPlaceName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelStreetNumber, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelPostcode, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(panelHouse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelPlaceName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelStreetNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(panelPostcode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(335, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panelPersonTitle = new JPanel();
		panelPersonTitle.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPersonTitle.add(lblTitle);
		
		JComboBox comboBoxTitle = new JComboBox();
		comboBoxTitle.setModel(new DefaultComboBoxModel(new String[] {"Mr.", "Mrs.", "Ms.", "Prof.", "Sr.", "Dr."}));
		comboBoxTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPersonTitle.add(comboBoxTitle);
		
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
		
		JPanel panelUsername = new JPanel();
		panelUsername.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelUsername.add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldUsername.setColumns(15);
		panelUsername.add(textFieldUsername);
		
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
		
		JPanel panelMobileNumber = new JPanel();
		panelMobileNumber.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblContact = new JLabel("Mobile Number:");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelMobileNumber.add(lblContact);
		
		textFieldContact = new JTextField();
		textFieldContact.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldContact.setColumns(15);
		panelMobileNumber.add(textFieldContact);
		
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
		
		JPanel panelPassword = new JPanel();
		panelPassword.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPassword.add(lblPassword);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPassword.setColumns(15);
		panelPassword.add(textFieldPassword);
		
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String title = (String) comboBoxTitle.getSelectedItem();
				String userId = textFieldEmail.getText().toLowerCase();
				String password = textFieldPassword.getText();
				String forename = textFieldForename.getText();
				String surname = textFieldSurname.getText();
				String username = textFieldUsername.getText();
				String contact = textFieldContact.getText();
				int isGuest = chckbxGuest.isSelected() ? 1 : 0;
				int isHost = chckbxHost.isSelected() ? 1 : 0;
				String houseNumber = textFieldHouseNumber.getText();
				String placeName = textFieldPlaceName.getText();
				String streetName = textFieldStreetName.getText();
				String postcode = textFieldPostcode.getText();
				
				if( userId.length() != 0 && password.length() != 0 
						&& forename.length() !=0 && surname.length() != 0 && username.length() != 0
						&& contact.length() != 0 && (isGuest != 0 || isHost != 0)
						&& houseNumber.length() !=0 && placeName.length() != 0 
						&& streetName.length() !=0 && postcode.length() != 0 ) {		
					
					Validation v = new Validation();
					PasswordHash ph = new PasswordHash();
					
					
					Person m = new Person(title, forename, surname, username, userId, contact, isHost, isGuest, ph.hashPassword(password));
					Address a = new Address( houseNumber, streetName, placeName, postcode);
					
					if ( forename.length()>20 )
						JOptionPane.showMessageDialog(null, "A forename cannot be longer than 20 characters!", "Invalid Forename", JOptionPane.WARNING_MESSAGE);
					
					else if ( surname.length()>20 )
						JOptionPane.showMessageDialog(null, "A surname cannot be longer than 20 characters!", "Invalid Surname", JOptionPane.WARNING_MESSAGE);
					
					else if ( username.length()>20 )
						JOptionPane.showMessageDialog(null, "A username cannot be longer than 20 characters!", "Invalid Username", JOptionPane.WARNING_MESSAGE);
					
					else if (v.isValidPhoneNumber(contact) != "" ) 
						JOptionPane.showMessageDialog(null, v.isValidPhoneNumber(contact), "Invalid Contact Number", JOptionPane.WARNING_MESSAGE);
					
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
						LoginPage newFrame = new LoginPage(frame);
						frame.getContentPane().removeAll();
						frame.getContentPane().invalidate();
						frame.getContentPane().add(newFrame);
						frame.revalidate();
						frame.repaint();
					}
					else {
						JOptionPane.showMessageDialog(null, "There is a user already exist, change your email or address!", "Already Exist", JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please fill all the fields!", "Empty Fields", JOptionPane.WARNING_MESSAGE);
				}
				
			}

		});
		
		JPanel panelPersonalInforation = new JPanel();
		panelPersonalInforation.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblPersonalInforation = new JLabel("Personal Inforation");
		lblPersonalInforation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		panelPersonalInforation.add(lblPersonalInforation);
		GroupLayout gl_PersonalInforamtionPanel = new GroupLayout(PersonalInforamtionPanel);
		gl_PersonalInforamtionPanel.setHorizontalGroup(
			gl_PersonalInforamtionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PersonalInforamtionPanel.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_PersonalInforamtionPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelPersonalInforation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelRole, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelForename, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelPersonTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
						.addComponent(panelUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
						.addComponent(panelSurname, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelMobileNumber, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_PersonalInforamtionPanel.setVerticalGroup(
			gl_PersonalInforamtionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PersonalInforamtionPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelPersonalInforation, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(panelPersonTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelForename, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelMobileNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelRole, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(151, Short.MAX_VALUE))
		);
		PersonalInforamtionPanel.setLayout(gl_PersonalInforamtionPanel);
		titlePanel.setLayout(gl_titlePanel);
	}
}