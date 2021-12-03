package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JTextField;

import controllers.ChargeBandController;
import model.Property;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RequestPropertyPanel extends JPanel {
	public JFormattedTextField txtbxStartDate;
	public JFormattedTextField txtbxEndDate;
	JLabel lblTotalCost;
	
	/**
	 * Create the panel.
	 */
	public RequestPropertyPanel(Property property) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Start Date (YYYY-mm-dd):");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 47, 202, 14);
		add(lblNewLabel);
		
		JLabel lblEndDateyyyymmdd = new JLabel("End Date (YYYY-mm-dd):");
		lblEndDateyyyymmdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEndDateyyyymmdd.setBounds(10, 101, 189, 14);
		add(lblEndDateyyyymmdd);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		txtbxStartDate = new JFormattedTextField(df);
		txtbxStartDate.setBounds(208, 46, 113, 20);
		add(txtbxStartDate);
		
		txtbxEndDate = new JFormattedTextField(df);
		txtbxEndDate.setBounds(209, 100, 113, 20);
		add(txtbxEndDate);
		
		JLabel lblNewLabel_1 = new JLabel("Total cost:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(112, 189, 85, 28);
		add(lblNewLabel_1);
		
		lblTotalCost = new JLabel("");
		lblTotalCost.setBounds(200, 188, 164, 35);
		add(lblTotalCost);
		
		JButton btnUpdateTotalCost = new JButton("Update");
		btnUpdateTotalCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtbxStartDate.getText().length() <= 1 || txtbxEndDate.getText().length() <= 1) {
					JOptionPane.showMessageDialog(null, "Please enter start and end dates for property.", "Error", JOptionPane.WARNING_MESSAGE);
				} else {
					try {
					ChargeBandController cbc = new ChargeBandController();
					double totalCost = cbc.getTotalCost(property.getChargeBands(),
							LocalDate.parse(txtbxStartDate.getText()),
							LocalDate.parse(txtbxEndDate.getText()));
					lblTotalCost.setText(String.valueOf(totalCost));
					} catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Dates out of range for property charge bands", "Error", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnUpdateTotalCost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdateTotalCost.setBounds(10, 193, 92, 21);
		add(btnUpdateTotalCost);
	}
}
