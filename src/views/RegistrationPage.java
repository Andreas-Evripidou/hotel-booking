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
import javax.swing.JLabel;
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

public class RegistrationPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		
		JPanel panelRegister = new JPanel();
		panelRegister.setBackground(Color.LIGHT_GRAY);
		
		JButton btnRegister = new JButton("Register");
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
		
		JPanel panelPostcode = new JPanel();
		panelPostcode.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblpostcode = new JLabel("Postcode:");
		lblpostcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPostcode.add(lblpostcode);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		panelPostcode.add(textField);
		
		JPanel panelStreetNumber = new JPanel();
		panelStreetNumber.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblStreetName = new JLabel("Street Name:");
		lblStreetName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelStreetNumber.add(lblStreetName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		panelStreetNumber.add(textField_1);
		
		JPanel panelPlaceName = new JPanel();
		panelPlaceName.setBackground(Color.LIGHT_GRAY);
		
		JLabel lbPlaceName = new JLabel("Place Name:");
		lbPlaceName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPlaceName.add(lbPlaceName);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		panelPlaceName.add(textField_2);
		
		JPanel panelHouse = new JPanel();
		panelHouse.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblHouse = new JLabel("House Number:");
		lblHouse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelHouse.add(lblHouse);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		panelHouse.add(textField_3);
		
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
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setColumns(15);
		panelPassword.add(passwordField);
		
		JPanel panelEmail = new JPanel();
		panelEmail.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelEmail.add(lblEmail);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("");
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(21);
		panelEmail.add(textField_4);
		
		JPanel panelMobileNumber = new JPanel();
		panelMobileNumber.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblContact = new JLabel("Mobile Number:");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelMobileNumber.add(lblContact);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(15);
		panelMobileNumber.add(textField_5);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelTitle.add(lblTitle);
		
		JComboBox comboBoxTitle = new JComboBox();
		comboBoxTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelTitle.add(comboBoxTitle);
		
		JPanel panelForename = new JPanel();
		panelForename.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblForename = new JLabel("Forename:");
		lblForename.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelForename.add(lblForename);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(15);
		panelForename.add(textField_6);
		
		JPanel panelSurname = new JPanel();
		panelSurname.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblSurname = new JLabel("Surname:  ");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelSurname.add(lblSurname);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_7.setColumns(15);
		panelSurname.add(textField_7);
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