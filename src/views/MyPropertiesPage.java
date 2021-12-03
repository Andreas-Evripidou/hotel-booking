package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.PropertyController;

import javax.swing.JLabel;

public class MyPropertiesPage extends JPanel {
	
	/**
	 * Create the this.
	 */
	public MyPropertiesPage(JFrame frame,JPanel previousPanel, String hostID) {
		this.setBounds(100, 100, 1200, 800);
		this.setBackground(Color.LIGHT_GRAY);
		
		
		JPanel titelPanel = new JPanel();
		titelPanel.setBackground(Color.LIGHT_GRAY);
		
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
			
		
		JTable table = new JTable(requestColumnData, requestColumnNames);
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();
				frame.getContentPane().add(previousPanel);
				frame.revalidate();
				frame.repaint();
				
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_this = new GroupLayout(this);
		this.setLayout(gl_this);
		gl_this.setHorizontalGroup(
			gl_this.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_this.createSequentialGroup()
					.addGroup(gl_this.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_this.createSequentialGroup()
							.addGap(17)
							.addGroup(gl_this.createParallelGroup(Alignment.LEADING)
								.addComponent(titelPanel, GroupLayout.PREFERRED_SIZE, 1151, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1149, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_this.createSequentialGroup()
							.addGap(533)
							.addComponent(btnNewButton)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_this.setVerticalGroup(
			gl_this.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_this.createSequentialGroup()
					.addContainerGap()
					.addComponent(titelPanel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		JLabel lblMyProperties = new JLabel("My Properties");
		lblMyProperties.setFont(new Font("Tahoma", Font.BOLD, 24));
		titelPanel.add(lblMyProperties);

	}
}
