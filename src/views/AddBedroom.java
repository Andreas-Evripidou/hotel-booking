package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddBedroom extends JPanel {
	public JComboBox cmbBed1;
	public JComboBox cmbBed2;
	

	/**
	 * Create the panel.
	 */
	public AddBedroom() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bed 1:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 59, 45, 13);
		add(lblNewLabel);
		
		JLabel lblBed = new JLabel("Bed 2:");
		lblBed.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBed.setBounds(10, 111, 45, 13);
		add(lblBed);
		
		cmbBed1 = new JComboBox();
		cmbBed1.setModel(new DefaultComboBoxModel(new String[] {"Single Bed", "Double Bed", "King Sized Bed", "Bunk Bed"}));
		cmbBed1.setBounds(67, 56, 158, 21);
		add(cmbBed1);
		
		cmbBed2 = new JComboBox();
		cmbBed2.setModel(new DefaultComboBoxModel(new String[] {"", "Single Bed", "Double Bed", "King Sized Bed", "Bunk Bed"}));
		cmbBed2.setBounds(67, 108, 158, 21);
		add(cmbBed2);
		
		JComboBox cmbBed2 = new JComboBox();
		cmbBed2.setModel(new DefaultComboBoxModel(new String[] {"Single Bed", "Double Bed", "King Sized Bed", "Bunk Bed"}));
		cmbBed2.setBounds(83, 108, 111, 21);
		add(cmbBed2);

	}

}
