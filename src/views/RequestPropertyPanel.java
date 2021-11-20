package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class RequestPropertyPanel extends JPanel {
	public JFormattedTextField txtbxStartDate;
	public JFormattedTextField txtbxEndDate;
	
	/**
	 * Create the panel.
	 */
	public RequestPropertyPanel() {
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
	}
}
