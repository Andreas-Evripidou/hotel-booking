package views;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DropMode;
import java.awt.Frame;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Rectangle;

public class loginPage {

	private JFrame frmLogInPage;
	private JTextField textField;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPage window = new loginPage();
					window.frmLogInPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogInPage = new JFrame();
		frmLogInPage.setMinimumSize(new Dimension(1100, 700));
		frmLogInPage.setMaximizedBounds(new Rectangle(0, 0, 0, 0));
		frmLogInPage.setTitle("Log In Page");
		frmLogInPage.setBounds(100, 100, 1191, 712);
		frmLogInPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		frmLogInPage.getContentPane().add(panel, BorderLayout.CENTER);
		
		JPanel userIDPanel = new JPanel();
		userIDPanel.setBackground(Color.CYAN);
		userIDPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel userID = new JLabel("UserID:");
		userID.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		userID.setHorizontalAlignment(SwingConstants.LEFT);
		userIDPanel.add(userID);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		userIDPanel.add(textField);
		textField.setColumns(25);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setBackground(Color.CYAN);
		passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		passwordPanel.add(password);
		
		JPanel chooseUserPanel = new JPanel();
		chooseUserPanel.setBackground(Color.CYAN);
		chooseUserPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel logInButtonPanel = new JPanel();
		logInButtonPanel.setBackground(Color.CYAN);
		logInButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel logInButtonPanel_1 = new JPanel();
		logInButtonPanel_1.setBackground(Color.CYAN);
		logInButtonPanel_1.setLayout(new BoxLayout(logInButtonPanel_1, BoxLayout.X_AXIS));
		
		JButton backToHomeScreen = new JButton("Home");
		backToHomeScreen.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		logInButtonPanel_1.add(backToHomeScreen);
		
		JPanel logInTitlePanel = new JPanel();
		logInTitlePanel.setBackground(Color.CYAN);
		logInTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel titleLabel = new JLabel("Please enter your Log In details");
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		logInTitlePanel.add(titleLabel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addComponent(logInButtonPanel_1, GroupLayout.PREFERRED_SIZE, 1155, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(1)
					.addComponent(logInButtonPanel, GroupLayout.DEFAULT_SIZE, 1192, Short.MAX_VALUE)
					.addGap(4))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(2)
					.addComponent(chooseUserPanel, GroupLayout.DEFAULT_SIZE, 1194, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(1)
					.addComponent(passwordPanel, GroupLayout.DEFAULT_SIZE, 1197, Short.MAX_VALUE)
					.addGap(2))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(logInTitlePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE)
						.addComponent(userIDPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1190, Short.MAX_VALUE))
					.addGap(4))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(70)
					.addComponent(logInTitlePanel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(userIDPanel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(passwordPanel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(chooseUserPanel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(logInButtonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
					.addComponent(logInButtonPanel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		logInButtonPanel.add(btnLogIn);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		logInButtonPanel.add(btnSignUp);
		
		JRadioButton radioHost = new JRadioButton("Host");
		radioHost.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		buttonGroup.add(radioHost);
		chooseUserPanel.add(radioHost);
		
		JRadioButton radioGuest = new JRadioButton("Guest");
		radioGuest.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		buttonGroup.add(radioGuest);
		chooseUserPanel.add(radioGuest);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		passwordField.setColumns(24);
		passwordPanel.add(passwordField);
		panel.setLayout(gl_panel);
		
		JMenuBar menuBar = new JMenuBar();
		frmLogInPage.setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem homePage = new JMenuItem("Home Page");
		mnMenu.add(homePage);
		
		JMenuItem logInPage = new JMenuItem("Log In Page");
		mnMenu.add(logInPage);
	}
}
