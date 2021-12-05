package views;
import javax.swing.JPanel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.Format;
import java.text.NumberFormat;

import javax.swing.JTextField;

import controllers.ChargeBandController;
import model.ChargeBand;

import java.awt.Color;

public class AddChargeBand extends JPanel {
	public JFormattedTextField startDateTxt;
	public JFormattedTextField endDateTxt;
	public JTextField pppTxt;
	public JTextField serviceChargeTxt;
	public JTextField cleaningChargeTxt;

	/**
	 * Create the panel.
	 */
	public AddChargeBand(List<ChargeBand> existingChargeBands) {
		Format currency = NumberFormat.getCurrencyInstance(Locale.UK);
		setLayout(null);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		startDateTxt = new JFormattedTextField(df);
		startDateTxt.setEditable(false);
		startDateTxt.setBounds(107, 52, 103, 19);
		add(startDateTxt);
		
		JLabel lblNewLabel = new JLabel("Start Date:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(37, 54, 64, 13);
		add(lblNewLabel);
		
		endDateTxt = new JFormattedTextField(df);
		endDateTxt.setText("2022-12-31");
		endDateTxt.setBounds(107, 83, 105, 19);
		add(endDateTxt);
		
		JLabel lblNewLabel_1 = new JLabel("End Date:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(37, 85, 64, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price per Night: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(130, 151, 110, 13);
		add(lblNewLabel_2);
		
		pppTxt = new JFormattedTextField(currency);
		pppTxt.setText("\u00A3");
		pppTxt.setBounds(224, 149, 64, 19);
		add(pppTxt);
		pppTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Service Charge:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(223, 54, 104, 13);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Cleaning Charge:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(223, 85, 110, 13);
		add(lblNewLabel_3_1);
		
		serviceChargeTxt = new JFormattedTextField(currency);
		serviceChargeTxt.setText("\u00A3");
		serviceChargeTxt.setColumns(10);
		serviceChargeTxt.setBounds(327, 52, 64, 19);
		add(serviceChargeTxt);
		
		cleaningChargeTxt = new JFormattedTextField(currency);
		cleaningChargeTxt.setText("\u00A3");
		cleaningChargeTxt.setColumns(10);
		cleaningChargeTxt.setBounds(327, 83, 64, 19);
		add(cleaningChargeTxt);
		
		JLabel lblNewLabel_4 = new JLabel("(YYYY-MM-DD)");
		lblNewLabel_4.setForeground(Color.GRAY);
		lblNewLabel_4.setBounds(107, 35, 100, 13);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("(\u00A30.00)");
		lblNewLabel_4_1.setForeground(Color.GRAY);
		lblNewLabel_4_1.setBounds(327, 31, 75, 13);
		add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("(\u00A30.00)");
		lblNewLabel_4_1_1.setForeground(Color.GRAY);
		lblNewLabel_4_1_1.setBounds(224, 128, 75, 13);
		add(lblNewLabel_4_1_1);
		
		ChargeBandController cbc = new ChargeBandController();
		if(existingChargeBands.size() == 0) {
			startDateTxt.setText(LocalDate.now().toString());
		} else {
			LocalDate lastDateAdded = existingChargeBands.get(existingChargeBands.size() - 1).getEndDate().plusDays(1);
			startDateTxt.setText(lastDateAdded.toString());
		}
	}
}
