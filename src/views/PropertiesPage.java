package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import controllers.PropertyController;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.Person;
import main.Property;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PropertiesPage {

	private JFrame frame;
	private JTable table;

	/**
	 * Create the application.
	 */
	public PropertiesPage(String hostID, JFrame previousFrame) {
		initialize();
		showProperties(hostID,previousFrame);
	}
	public JFrame getFrame() {
		return frame;
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
	}
	
	private void showProperties(String hostID,JFrame previousFrame){

	
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		PropertyController pc = new PropertyController();
		ArrayList<String> properties = pc.getAllPropertIDByHostID(hostID);
		
		String[] requestColumnNames = {"Proeprty Name"};
		Object[][] requestColumnData = new Object[0][0];
		
		
		if(properties != null){
			requestColumnData = new Object[properties.size()][1];
			
			for (int i = 0; i < properties.size() ; i++) {
				requestColumnData[i][0] = pc.getPropertyNameByPropertyID(Integer.parseInt(properties.get(i)));
			}
		}
			
		
		table = new JTable(requestColumnData, requestColumnNames);
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				previousFrame.setVisible(true);
				
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		panel.setLayout(gl_panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(17)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1151, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1149, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(533)
							.addComponent(btnNewButton)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		JLabel lblMyProperties = new JLabel("My Properties");
		lblMyProperties.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lblMyProperties);
	}
}
