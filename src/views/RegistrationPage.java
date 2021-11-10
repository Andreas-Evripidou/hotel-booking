package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrationPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textFieldForename;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationPage frame = new RegistrationPage();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationPage() {
		setMaximumSize(new Dimension(1150, 950));
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		
		JLabel lblPageTitle = new JLabel("Registration Page");
		lblPageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPageTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JPanel panelTitle = new JPanel();
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelTitle.add(lblTitle);
		
		JPanel panelForename = new JPanel();
		
		JLabel lblForename = new JLabel("Forename:");
		lblForename.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelForename.add(lblForename);
		
		textFieldForename = new JTextField();
		textFieldForename.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldForename.setColumns(15);
		panelForename.add(textFieldForename);
		
		JPanel panelSurname = new JPanel();
		
		JLabel lblSurname = new JLabel("Surname:  ");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelSurname.add(lblSurname);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(15);
		panelSurname.add(textField_2);
		
		JPanel panelMobileNumber = new JPanel();
		
		JLabel lblContact = new JLabel("Mobile Number:");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelMobileNumber.add(lblContact);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(15);
		panelMobileNumber.add(textField_1);
		
		JPanel panelEmail = new JPanel();
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelEmail.add(lblEmail);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(21);
		panelEmail.add(textField);
		
		JPanel panelPassword = new JPanel();
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPassword.add(lblPassword);
		

		JComboBox comboBoxTitle = new JComboBox();
		comboBoxTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelTitle.add(comboBoxTitle);
		
		JPanel panelRole = new JPanel();
		
		JLabel lblRole = new JLabel("Role: ");
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelRole.add(lblRole);
		
		JCheckBox chckbxGuest = new JCheckBox("Guest");
		chckbxGuest.setHorizontalAlignment(SwingConstants.TRAILING);
		chckbxGuest.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelRole.add(chckbxGuest);
		
		JCheckBox chckbxHost = new JCheckBox("Host");
		chckbxHost.setHorizontalAlignment(SwingConstants.TRAILING);
		chckbxHost.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelRole.add(chckbxHost);
		
		JPanel panelAddress = new JPanel();
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelAddress.add(lblAddress);
		
		JPanel panelHouse = new JPanel();
		
		JLabel lblHouse = new JLabel("House Number:");
		lblHouse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelHouse.add(lblHouse);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(10);
		panelHouse.add(textField_6);
		
		JPanel panelPlaceName = new JPanel();
		
		JLabel lbPlaceName = new JLabel("Place Name:");
		lbPlaceName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPlaceName.add(lbPlaceName);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		panelPlaceName.add(textField_5);
		
		JPanel panelStreetNumber = new JPanel();
		
		JLabel lblStreetName = new JLabel("Street Name:");
		lblStreetName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelStreetNumber.add(lblStreetName);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		panelStreetNumber.add(textField_4);
		
		JPanel panelPostcode = new JPanel();
		
		JLabel lblpostcode = new JLabel("Postcode:");
		lblpostcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPostcode.add(lblpostcode);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		panelPostcode.add(textField_3);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setColumns(15);
		panelPassword.add(passwordField);
		
		JPanel panelRegister = new JPanel();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(99)
					.addComponent(lblPageTitle, GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
					.addGap(99))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelRegister, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
						.addComponent(panelEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
						.addComponent(panelMobileNumber, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
						.addComponent(panelSurname, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
						.addComponent(panelTitle, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
						.addComponent(panelForename, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
						.addComponent(panelPassword, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
						.addComponent(panelRole, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
						.addComponent(panelAddress, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
						.addComponent(panelHouse, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
						.addComponent(panelPlaceName, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
						.addComponent(panelStreetNumber, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
						.addComponent(panelPostcode, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE))
					.addGap(55))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(16)
					.addComponent(lblPageTitle, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelForename, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelSurname, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelMobileNumber, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelEmail, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelPassword, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelRole, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelAddress, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelHouse, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelPlaceName, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelStreetNumber, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelPostcode, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelRegister, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setPreferredSize(new Dimension(100, 40));
		btnRegister.setMaximumSize(new Dimension(100, 40));
		btnRegister.setMinimumSize(new Dimension(100, 40));
		panelRegister.add(btnRegister);
		
		JButton btnRedirectToLogin = new JButton("Log in");
		btnRedirectToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LoginPage window = new LoginPage();
							window.getFrame().setVisible(true);
							window.getFrame().pack();
							window.getFrame().setLocationRelativeTo(null);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});	
			}
		});
		btnRedirectToLogin.setHideActionText(true);
		btnRedirectToLogin.setPreferredSize(new Dimension(100, 40));
		btnRedirectToLogin.setMinimumSize(new Dimension(100, 40));
		btnRedirectToLogin.setMaximumSize(new Dimension(100, 40));
		panelRegister.add(btnRedirectToLogin);
		panel_1.setLayout(gl_panel_1);
	}
}

