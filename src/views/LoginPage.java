package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.PersonController;
import controllers.Validation;
import model.Person;

public class LoginPage extends JPanel {
	

	private JTextField userIDField;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/**
	 * Create the panel.
	 */
	
	public LoginPage(JFrame frame) {
		
		
		this.setBackground(Color.LIGHT_GRAY);
		
		JPanel userIDPanel = new JPanel();
		userIDPanel.setBackground(Color.LIGHT_GRAY);
		userIDPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel userID = new JLabel("UserID:");
		userID.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		userID.setHorizontalAlignment(SwingConstants.LEFT);
		userIDPanel.add(userID);
		
		userIDField = new JTextField();
		userIDField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		userIDPanel.add(userIDField);
		userIDField.setColumns(25);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setBackground(Color.LIGHT_GRAY);
		passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		passwordPanel.add(password);
		
		JPanel chooseUserPanel = new JPanel();
		chooseUserPanel.setBackground(Color.LIGHT_GRAY);
		chooseUserPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel logInButtonPanel = new JPanel();
		logInButtonPanel.setBackground(Color.LIGHT_GRAY);
		logInButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel logInButtonPanel_1 = new JPanel();
		logInButtonPanel_1.setBackground(Color.LIGHT_GRAY);
		logInButtonPanel_1.setLayout(new BoxLayout(logInButtonPanel_1, BoxLayout.X_AXIS));
		
		JButton backToHomeScreen = new JButton("Home");
		backToHomeScreen.setBackground(Color.LIGHT_GRAY);
		backToHomeScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage newFrame = new HomePage(frame, null);
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();
				frame.getContentPane().add(newFrame);
				frame.setLocationRelativeTo(null);
				frame.revalidate();
				frame.repaint();
			}
		});
		backToHomeScreen.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		logInButtonPanel_1.add(backToHomeScreen);
		
		JPanel logInTitlePanel = new JPanel();
		logInTitlePanel.setBackground(Color.LIGHT_GRAY);
		logInTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel titleLabel = new JLabel("Please enter your Log In details");
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		logInTitlePanel.add(titleLabel);
		GroupLayout gl_panel = new GroupLayout(this);
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
		btnLogIn.setBackground(Color.LIGHT_GRAY);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textFielduserID = userIDField.getText().toLowerCase();
				String textFieldpassword = passwordField.getText();
				String userType = null;
				
				try {
					userType = buttonGroup.getSelection().getActionCommand();
				}
				catch (Exception ex) {
				}
				
				if(textFielduserID.length() != 0 && textFieldpassword.length() != 0 && userType != null) {		
					Validation v = new Validation();
					boolean bool = v.validateUser(textFielduserID, textFieldpassword, userType);
					if (!bool) {
						JOptionPane.showMessageDialog(null, "Try again! Something you provided is incorrect!", "Errors", JOptionPane.WARNING_MESSAGE);
					}
					else {
						PersonController pc = new PersonController();
						Person p = pc.getPersonByUserID(textFielduserID);
						if (userType=="Host") {
							HostProfilePage newFrame = new HostProfilePage(frame, p);
							frame.getContentPane().removeAll();
							frame.getContentPane().invalidate();
							frame.getContentPane().add(newFrame);
							frame.setLocationRelativeTo(null);
							frame.revalidate();
							frame.repaint();
							
						}
						else {
							GuestProfilePage newFrame = new GuestProfilePage(frame,p);
							frame.getContentPane().removeAll();
							frame.getContentPane().invalidate();
							frame.getContentPane().add(newFrame);
							frame.revalidate();
							frame.repaint();
							
						}
						
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please fill all the fields!", "Errors", JOptionPane.WARNING_MESSAGE);
				}
			}
				
		});
		btnLogIn.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		logInButtonPanel.add(btnLogIn);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationPage newFrame = new RegistrationPage(frame);
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();
				frame.getContentPane().add(newFrame);
				frame.revalidate();
				frame.repaint();
				
				
			}
		});
		btnSignUp.setBackground(Color.LIGHT_GRAY);
		btnSignUp.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		logInButtonPanel.add(btnSignUp);
		
		JRadioButton radioHost = new JRadioButton("Host");
		radioHost.setBackground(Color.LIGHT_GRAY);
		radioHost.setActionCommand("Host");
		radioHost.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		buttonGroup.add(radioHost);
		chooseUserPanel.add(radioHost);
		
		JRadioButton radioGuest = new JRadioButton("Guest");
		radioGuest.setBackground(Color.LIGHT_GRAY);
		radioGuest.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		radioGuest.setActionCommand("Guest");
		buttonGroup.add(radioGuest);
		chooseUserPanel.add(radioGuest);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		passwordField.setColumns(24);
		passwordPanel.add(passwordField);
		this.setLayout(gl_panel);
	}
}

