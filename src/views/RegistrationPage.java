import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

public class RegistrationPage {

	private JFrame frmLoginPage;
	private JTextField textFieldForename;
	private JTextField textFieldSurname;
	private JTextField textFieldContact;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private JTextField textFieldHouse;
	private JTextField textFieldPlaceName;
	private JTextField textFieldStreetName;
	private JTextField textFieldPostcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationPage window = new RegistrationPage();
					window.frmLoginPage.setVisible(true);
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.setMinimumSize(new Dimension(1100, 700));
		frmLoginPage.getContentPane().setBackground(new Color(153, 204, 255));
		frmLoginPage.setTitle("Login Page");
		frmLoginPage.setBounds(100, 100, 1313, 950);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(new BoxLayout(frmLoginPage.getContentPane(), BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		frmLoginPage.getContentPane().add(scrollPane);
		
		JPanel evreme = new JPanel();
		scrollPane.setViewportView(evreme);
		
		JPanel panelForename = new JPanel();
		
		JPanel panelSurname = new JPanel();
		
		JPanel panelMobileNumber = new JPanel();
		
		JPanel panelEmail = new JPanel();
		
		JPanel panelPassword = new JPanel();
		
		JPanel panelRole = new JPanel();
		
		JPanel panelAddress = new JPanel();
		
		JPanel panelHouse = new JPanel();
		
		JPanel panelPlaceName = new JPanel();
		
		JPanel panelStreetNumber = new JPanel();
		
		JPanel panelPostcode = new JPanel();
		
		JPanel panelPageTitle = new JPanel();
		
		JPanel panelTitle = new JPanel();
		
		JLabel lblTitle = new JLabel("Title:");
		panelTitle.add(lblTitle);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JComboBox comboBoxTitle = new JComboBox();
		panelTitle.add(comboBoxTitle);
		comboBoxTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxTitle.setModel(new DefaultComboBoxModel(new String[] {"Mr", "Ms", "Mrs", "Other"}));
		
		JLabel lblpostcode = new JLabel("Postcode:");
		panelPostcode.add(lblpostcode);
		lblpostcode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblStreetName = new JLabel("Street Name:");
		panelStreetNumber.add(lblStreetName);
		lblStreetName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lbPlaceName = new JLabel("Place Name:");
		panelPlaceName.add(lbPlaceName);
		lbPlaceName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblHouse = new JLabel("House Number:");
		panelHouse.add(lblHouse);
		lblHouse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textFieldHouse = new JTextField();
		textFieldHouse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelHouse.add(textFieldHouse);
		textFieldHouse.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		panelAddress.add(lblAddress);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblRole = new JLabel("Role: ");
		panelRole.add(lblRole);
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox chckbxGuest = new JCheckBox("Guest");
		chckbxGuest.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxGuest.setHorizontalAlignment(SwingConstants.TRAILING);
		panelRole.add(chckbxGuest);
		
		JCheckBox chckbxHost = new JCheckBox("Host");
		chckbxHost.setHorizontalAlignment(SwingConstants.TRAILING);
		chckbxHost.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelRole.add(chckbxHost);
		
		JLabel lblPassword = new JLabel("Password:");
		panelPassword.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		passwordField = new JPasswordField();
		passwordField.setColumns(15);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPassword.add(passwordField);
		
		JLabel lblEmail = new JLabel("Email:");
		panelEmail.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textFieldEmail = new JTextField();
		textFieldEmail.setToolTipText("");
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelEmail.add(textFieldEmail);
		textFieldEmail.setColumns(21);
		
		JLabel lblContact = new JLabel("Mobile Number:");
		panelMobileNumber.add(lblContact);
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textFieldContact = new JTextField();
		textFieldContact.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldContact.setColumns(15);
		panelMobileNumber.add(textFieldContact);
		
		JLabel lblSurname = new JLabel("Surname:  ");
		panelSurname.add(lblSurname);
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textFieldSurname = new JTextField();
		textFieldSurname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldSurname.setColumns(15);
		panelSurname.add(textFieldSurname);
		
		JLabel lblForename = new JLabel("Forename:");
		panelForename.add(lblForename);
		lblForename.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textFieldForename = new JTextField();
		textFieldForename.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelForename.add(textFieldForename);
		textFieldForename.setColumns(15);
		
		JLabel lblPageTitle = new JLabel("Registration Page");
		lblPageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPageTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		GroupLayout gl_evreme = new GroupLayout(evreme);
		gl_evreme.setHorizontalGroup(
			gl_evreme.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_evreme.createSequentialGroup()
					.addGroup(gl_evreme.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_evreme.createSequentialGroup()
							.addGap(16)
							.addComponent(panelPageTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_evreme.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelSurname, GroupLayout.DEFAULT_SIZE, 1267, Short.MAX_VALUE)
							.addGap(15))
						.addGroup(gl_evreme.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelEmail, GroupLayout.DEFAULT_SIZE, 1267, Short.MAX_VALUE)
							.addGap(15))
						.addGroup(gl_evreme.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelPassword, GroupLayout.DEFAULT_SIZE, 1267, Short.MAX_VALUE)
							.addGap(15))
						.addGroup(gl_evreme.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelRole, GroupLayout.DEFAULT_SIZE, 1266, Short.MAX_VALUE)
							.addGap(16))
						.addGroup(gl_evreme.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelForename, GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(gl_evreme.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelMobileNumber, GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(gl_evreme.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelAddress, GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(gl_evreme.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelHouse, GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(gl_evreme.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelPlaceName, GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(gl_evreme.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelStreetNumber, GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(gl_evreme.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelPostcode, GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(Alignment.TRAILING, gl_evreme.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelTitle, GroupLayout.DEFAULT_SIZE, 1266, Short.MAX_VALUE)
							.addGap(16)))
					.addGap(10))
				.addGroup(gl_evreme.createSequentialGroup()
					.addComponent(lblPageTitle, GroupLayout.DEFAULT_SIZE, 1295, Short.MAX_VALUE)
					.addGap(36))
		);
		gl_evreme.setVerticalGroup(
			gl_evreme.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_evreme.createSequentialGroup()
					.addGap(6)
					.addComponent(panelPageTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPageTitle)
					.addGap(83)
					.addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
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
					.addGap(21))
		);
		
		textFieldPostcode = new JTextField();
		textFieldPostcode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPostcode.setColumns(10);
		panelPostcode.add(textFieldPostcode);
		
		textFieldStreetName = new JTextField();
		textFieldStreetName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldStreetName.setColumns(10);
		panelStreetNumber.add(textFieldStreetName);
		
		textFieldPlaceName = new JTextField();
		textFieldPlaceName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPlaceName.add(textFieldPlaceName);
		textFieldPlaceName.setColumns(10);
		evreme.setLayout(gl_evreme);
	}
}
