package views;

import javax.swing.JPanel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.Format;
import javax.swing.JTextField;

public class AddChargeBand extends JPanel {
	public JFormattedTextField startDateTxt;
	public JFormattedTextField endDateTxt;
	public JTextField pppTxt;
	public JTextField serviceChargeTxt;
	public JTextField cleaningChargeTxt;

	/**
	 * Create the panel.
	 */
	public AddChargeBand() {
		setLayout(null);
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		startDateTxt = new JFormattedTextField(df);
		startDateTxt.setBounds(107, 52, 87, 19);
		add(startDateTxt);
		
		JLabel lblNewLabel = new JLabel("Start Date:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(37, 54, 64, 13);
		add(lblNewLabel);
		
		endDateTxt = new JFormattedTextField(df);
		endDateTxt.setBounds(107, 83, 87, 19);
		add(endDateTxt);
		
		JLabel lblNewLabel_1 = new JLabel("End Date:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(37, 85, 64, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price per Night:   \u00A3");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(130, 151, 110, 13);
		add(lblNewLabel_2);
		
		pppTxt = new JTextField();
		pppTxt.setBounds(240, 149, 64, 19);
		add(pppTxt);
		pppTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Service Charge:  \u00A3");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(223, 54, 104, 13);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Cleaning Charge:  \u00A3");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(223, 85, 110, 13);
		add(lblNewLabel_3_1);
		
		serviceChargeTxt = new JTextField();
		serviceChargeTxt.setColumns(10);
		serviceChargeTxt.setBounds(327, 52, 64, 19);
		add(serviceChargeTxt);
		
		cleaningChargeTxt = new JTextField();
		cleaningChargeTxt.setColumns(10);
		cleaningChargeTxt.setBounds(337, 83, 64, 19);
		add(cleaningChargeTxt);
		
	}
}
