package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Facilities.*;
import main.Address;
import main.ChargeBand;
import main.Property;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPropertyPage extends JFrame {

	private JPanel contentPane;
	private JTextField descriptionTxt;
	private JTextField txtbxHouse;
	private JTextField txtbxStreetName;
	private JTextField txtbxPostCode;
	private JTextField txtbxCity;
	private JCheckBox chckbxBedLinen;
	private JCheckBox chckbxTowels;
	private JCheckBox chckbxHairDryer;
	private JCheckBox chckbxShampoo;
	private JCheckBox chckbxRefrigerator;
	private JCheckBox chckbxMicrowave;
	private JCheckBox chckbxCookware;
	private JCheckBox chckbxProvisions;
	private JCheckBox chckbxSatellite;
	private JCheckBox chckbxStreaming;
	private JCheckBox chckbxDvdPlayer;
	private JCheckBox chckbxBoardGames;
	private JCheckBox chckbxOven;
	private JCheckBox chckbxStove;
	private JCheckBox chckbxWifi;
	private JCheckBox chckbxTelevision;
	private JCheckBox chckbxToiletPaper;
	private JCheckBox chckbxDishwasher;
	private JCheckBox chckbxTableware;
	private JCheckBox chckbxHeating;
	private JCheckBox chckbxWashingMachine;
	private JCheckBox chckbxDryingMachine;
	private JCheckBox chckbxFireExtinguisher;
	private JCheckBox chckbxSmokeAlarm;
	private JCheckBox chckbxFirstAidKit;
	private JCheckBox chckbxFreeOnsiteParking;
	private JCheckBox chckbxOnroadParking;
	private JCheckBox chckbxPaidParking;
	private JCheckBox chckbxPatio;
	private JCheckBox chckbxBarbecue;
	private JCheckBox breakfastChk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPropertyPage frame = new AddPropertyPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddPropertyPage() {
		setTitle("Add Property");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 621, 537);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel descriptionLabel = new JLabel("Description:");
		descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descriptionLabel.setBounds(10, 46, 207, 25);
		panel.add(descriptionLabel);
		
		JLabel locationLabel = new JLabel("Address");
		locationLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		locationLabel.setBounds(10, 6, 121, 13);
		panel.add(locationLabel);
		
		breakfastChk = new JCheckBox("Breakfast Offered");
		breakfastChk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		breakfastChk.setBounds(10, 87, 144, 21);
		panel.add(breakfastChk);
		
		descriptionTxt = new JTextField();
		descriptionTxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		descriptionTxt.setBounds(104, 49, 266, 20);
		panel.add(descriptionTxt);
		descriptionTxt.setColumns(10);
		
		JButton CancelBtn = new JButton("Cancel");
		CancelBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CancelBtn.setBounds(377, 506, 85, 21);
		panel.add(CancelBtn);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check for filled in form
				if(!(txtbxHouse.getText().length() == 0) && !(txtbxStreetName.getText().length() == 0) 
						&& !(txtbxCity.getText().length() == 0) && !(txtbxPostCode.getText().length() == 0)) {
					Address address = new Address(txtbxHouse.getText(),
							txtbxStreetName.getText(), txtbxCity.getText(), 
							txtbxPostCode.getText());
					Sleeping sleeping = new Sleeping(new ArrayList<Bedroom>(),
							chckbxBedLinen.isSelected(),
							chckbxTowels.isSelected());
					Bathing bathing = new Bathing(new ArrayList<Bathroom>(), chckbxHairDryer.isSelected(),
							chckbxShampoo.isSelected(), chckbxToiletPaper.isSelected());
					Outdoor outdoor = new Outdoor(chckbxFreeOnsiteParking.isSelected(),
							chckbxOnroadParking.isSelected(), 
							chckbxPaidParking.isSelected(),
							chckbxPatio.isSelected(),
							chckbxBarbecue.isSelected());
					Kitchen kitchen = new Kitchen(chckbxRefrigerator.isSelected(),
							chckbxMicrowave.isSelected(), chckbxOven.isSelected(),
							chckbxStove.isSelected(), chckbxDishwasher.isSelected(),
							chckbxTableware.isSelected(), chckbxCookware.isSelected(),
							chckbxProvisions.isSelected());
					Living living = new Living(chckbxWifi.isSelected(),
							chckbxTelevision.isSelected(), chckbxSatellite.isSelected(),
							chckbxFireExtinguisher.isSelected(), chckbxSmokeAlarm.isSelected(),
							chckbxFirstAidKit.isSelected());
					Utility utility = new Utility(chckbxHeating.isSelected(), chckbxWashingMachine.isSelected(),
							chckbxDryingMachine.isSelected(), chckbxFireExtinguisher.isSelected(),
							chckbxSmokeAlarm.isSelected(), chckbxFirstAidKit.isSelected());
					
					Property property = new Property(new ArrayList<ChargeBand>(), address,
							descriptionTxt.getText(), breakfastChk.isSelected(), bathing,
							kitchen, living, outdoor, sleeping, utility);
				} else {
					JOptionPane.showMessageDialog(null, "Please fill in all fields!", "Empty fields", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(299, 506, 61, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Facilities");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(260, 108, 78, 13);
		panel.add(lblNewLabel);
		
		JPanel sleepingPanel = new JPanel();
		sleepingPanel.setBounds(10, 130, 144, 152);
		panel.add(sleepingPanel);
		sleepingPanel.setLayout(null);
		
		JLabel sleepingLabel = new JLabel("Sleeping");
		sleepingLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		sleepingLabel.setBounds(48, 10, 61, 13);
		sleepingPanel.add(sleepingLabel);
		
		chckbxBedLinen = new JCheckBox("Bed Linen");
		chckbxBedLinen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxBedLinen.setBounds(0, 29, 109, 21);
		sleepingPanel.add(chckbxBedLinen);
		
		chckbxTowels = new JCheckBox("Towels");
		chckbxTowels.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxTowels.setBounds(0, 52, 109, 21);
		sleepingPanel.add(chckbxTowels);
		
		JButton btnAddBedroom = new JButton("Add Bedroom Info");
		btnAddBedroom.setBounds(10, 79, 124, 21);
		sleepingPanel.add(btnAddBedroom);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(164, 131, 144, 152);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Bathing");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(49, 5, 55, 13);
		panel_1.add(lblNewLabel_1);
		
		chckbxHairDryer = new JCheckBox("Hair Dryer");
		chckbxHairDryer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxHairDryer.setBounds(6, 24, 109, 21);
		panel_1.add(chckbxHairDryer);
		
		chckbxShampoo = new JCheckBox("Shampoo");
		chckbxShampoo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxShampoo.setBounds(6, 47, 109, 21);
		panel_1.add(chckbxShampoo);
		
		chckbxToiletPaper = new JCheckBox("Toilet Paper");
		chckbxToiletPaper.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxToiletPaper.setBounds(6, 70, 109, 21);
		panel_1.add(chckbxToiletPaper);
		
		JButton btnAddBathroom = new JButton("Add Bathroom Info");
		btnAddBathroom.setBounds(6, 97, 128, 21);
		panel_1.add(btnAddBathroom);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 292, 144, 208);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Kitchen");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(49, 5, 66, 13);
		panel_1_1.add(lblNewLabel_1_1);
		
		chckbxRefrigerator = new JCheckBox("Refrigerator");
		chckbxRefrigerator.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxRefrigerator.setBounds(6, 24, 109, 21);
		panel_1_1.add(chckbxRefrigerator);
		
		chckbxMicrowave = new JCheckBox("Microwave");
		chckbxMicrowave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxMicrowave.setBounds(6, 47, 109, 21);
		panel_1_1.add(chckbxMicrowave);
		
		chckbxOven = new JCheckBox("Oven");
		chckbxOven.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxOven.setBounds(6, 70, 109, 21);
		panel_1_1.add(chckbxOven);
		
		chckbxStove = new JCheckBox("Stove");
		chckbxStove.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxStove.setBounds(6, 93, 109, 21);
		panel_1_1.add(chckbxStove);
		
	    chckbxDishwasher = new JCheckBox("Dishwasher");
		chckbxDishwasher.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxDishwasher.setBounds(6, 116, 109, 21);
		panel_1_1.add(chckbxDishwasher);
		
		chckbxTableware = new JCheckBox("Tableware");
		chckbxTableware.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxTableware.setBounds(6, 139, 109, 21);
		panel_1_1.add(chckbxTableware);
		
		chckbxCookware = new JCheckBox("Cookware");
		chckbxCookware.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxCookware.setBounds(6, 162, 109, 21);
		panel_1_1.add(chckbxCookware);
		
		chckbxProvisions = new JCheckBox("Provisions");
		chckbxProvisions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxProvisions.setBounds(6, 185, 109, 21);
		panel_1_1.add(chckbxProvisions);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(164, 293, 144, 207);
		panel.add(panel_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Living");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(49, 5, 45, 13);
		panel_1_2.add(lblNewLabel_1_2);
		
		chckbxWifi = new JCheckBox("Wifi");
		chckbxWifi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxWifi.setBounds(6, 24, 109, 21);
		panel_1_2.add(chckbxWifi);
		
		chckbxTelevision = new JCheckBox("Television");
		chckbxTelevision.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxTelevision.setBounds(6, 47, 109, 21);
		panel_1_2.add(chckbxTelevision);
		
		chckbxSatellite = new JCheckBox("Satellite");
		chckbxSatellite.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxSatellite.setBounds(6, 70, 109, 21);
		panel_1_2.add(chckbxSatellite);
		
		chckbxStreaming = new JCheckBox("Streaming");
		chckbxStreaming.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxStreaming.setBounds(6, 93, 109, 21);
		panel_1_2.add(chckbxStreaming);
		
		chckbxDvdPlayer = new JCheckBox("DVD Player");
		chckbxDvdPlayer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxDvdPlayer.setBounds(6, 116, 109, 21);
		panel_1_2.add(chckbxDvdPlayer);
		
		chckbxBoardGames = new JCheckBox("Board Games");
		chckbxBoardGames.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxBoardGames.setBounds(6, 139, 109, 21);
		panel_1_2.add(chckbxBoardGames);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBounds(318, 292, 144, 207);
		panel.add(panel_1_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Utility");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_1.setBounds(49, 5, 45, 13);
		panel_1_2_1.add(lblNewLabel_1_2_1);
		
		chckbxHeating = new JCheckBox("Heating");
		chckbxHeating.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxHeating.setBounds(6, 24, 109, 21);
		panel_1_2_1.add(chckbxHeating);
		
		chckbxWashingMachine = new JCheckBox("Washing Machine");
		chckbxWashingMachine.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxWashingMachine.setBounds(6, 47, 132, 21);
		panel_1_2_1.add(chckbxWashingMachine);
		
		chckbxDryingMachine = new JCheckBox("Drying Machine");
		chckbxDryingMachine.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxDryingMachine.setBounds(6, 70, 109, 21);
		panel_1_2_1.add(chckbxDryingMachine);
		
		chckbxFireExtinguisher = new JCheckBox("Fire Extinguisher");
		chckbxFireExtinguisher.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxFireExtinguisher.setBounds(6, 93, 119, 21);
		panel_1_2_1.add(chckbxFireExtinguisher);
		
		chckbxSmokeAlarm = new JCheckBox("Smoke Alarm");
		chckbxSmokeAlarm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxSmokeAlarm.setBounds(6, 116, 109, 21);
		panel_1_2_1.add(chckbxSmokeAlarm);
		
		chckbxFirstAidKit = new JCheckBox("First Aid Kit");
		chckbxFirstAidKit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxFirstAidKit.setBounds(6, 139, 109, 21);
		panel_1_2_1.add(chckbxFirstAidKit);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(318, 130, 144, 152);
		panel.add(panel_1_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Outdoor");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(49, 5, 55, 13);
		panel_1_3.add(lblNewLabel_1_3);
		
		chckbxFreeOnsiteParking = new JCheckBox("Free On-Site Parking");
		chckbxFreeOnsiteParking.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxFreeOnsiteParking.setBounds(6, 24, 132, 21);
		panel_1_3.add(chckbxFreeOnsiteParking);
		
		chckbxOnroadParking = new JCheckBox("On-Road Parking");
		chckbxOnroadParking.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxOnroadParking.setBounds(6, 47, 132, 21);
		panel_1_3.add(chckbxOnroadParking);
		
		chckbxPaidParking = new JCheckBox("Paid Parking");
		chckbxPaidParking.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxPaidParking.setBounds(6, 70, 109, 21);
		panel_1_3.add(chckbxPaidParking);
		
		chckbxPatio = new JCheckBox("Patio");
		chckbxPatio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxPatio.setBounds(6, 93, 109, 21);
		panel_1_3.add(chckbxPatio);
		
		chckbxBarbecue = new JCheckBox("Barbecue");
		chckbxBarbecue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxBarbecue.setBounds(6, 116, 109, 21);
		panel_1_3.add(chckbxBarbecue);
		
		JLabel lblNewLabel_2 = new JLabel("House Name/Number:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(104, 8, 138, 13);
		panel.add(lblNewLabel_2);
		
		txtbxHouse = new JTextField();
		txtbxHouse.setBounds(242, 5, 96, 19);
		panel.add(txtbxHouse);
		txtbxHouse.setColumns(10);
		
		JLabel cityLabel = new JLabel("City:");
		cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cityLabel.setBounds(200, 29, 138, 13);
		panel.add(cityLabel);
		
		JLabel lblNewLabel_2_2 = new JLabel("Street Name:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2.setBounds(363, 7, 138, 13);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Post Code:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_3.setBounds(363, 29, 138, 13);
		panel.add(lblNewLabel_2_3);
		
		txtbxStreetName = new JTextField();
		txtbxStreetName.setColumns(10);
		txtbxStreetName.setBounds(457, 5, 96, 19);
		panel.add(txtbxStreetName);
		
		txtbxPostCode = new JTextField();
		txtbxPostCode.setColumns(10);
		txtbxPostCode.setBounds(457, 27, 96, 19);
		panel.add(txtbxPostCode);
		
		txtbxCity = new JTextField();
		txtbxCity.setColumns(10);
		txtbxCity.setBounds(242, 27, 96, 19);
		panel.add(txtbxCity);
	}
}
