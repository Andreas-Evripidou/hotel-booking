package views;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.Font;

public class AddBathroom extends JPanel {
	public JCheckBox chckbxToilet;
	public JCheckBox chckbxBath;
	public JCheckBox chckbxShower;
	public JCheckBox chckbxSharedWithHost;
	
	/**
	 * Create the panel.
	 */
	public AddBathroom() {
		setLayout(null);
		
		chckbxToilet = new JCheckBox("Toilet");
		chckbxToilet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxToilet.setBounds(39, 27, 93, 21);
		add(chckbxToilet);
		
		chckbxBath = new JCheckBox("Bath");
		chckbxBath.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxBath.setBounds(39, 82, 93, 21);
		add(chckbxBath);
		
		chckbxShower = new JCheckBox("Shower");
		chckbxShower.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxShower.setBounds(160, 27, 93, 21);
		add(chckbxShower);
		
		chckbxSharedWithHost = new JCheckBox("Shared with Host");
		chckbxSharedWithHost.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxSharedWithHost.setBounds(160, 83, 129, 21);
		add(chckbxSharedWithHost);

	}

}
