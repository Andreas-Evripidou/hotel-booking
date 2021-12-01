package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Facilities.*;
import controllers.ChargeBandController;
import main.Address;
import main.ChargeBand;
import main.Person;
import main.Property;
import main.Validation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class AddPropertyPage extends JFrame {
	
	private List<Bedroom> bedrooms = new ArrayList<Bedroom>();
	private List<Bathroom> bathrooms = new ArrayList<Bathroom>();
	private List<ChargeBand> chargeBands = new ArrayList<ChargeBand>();

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
	private JTextField txtbxName;
	private JLabel lblChargeBandStatus;
	private JLabel lblOKButtonStatus;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPropertyPage frame = new AddPropertyPage(new Person("a", "a", "a", "ed", "a", "122345", 1, 1, "a"));
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
	public AddPropertyPage(Person p) {
		setResizable(false);
		setTitle("Add Property");
		setBounds(100, 100, 1200, 850);
		setMinimumSize(new Dimension(1200, 850));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 1166, 793);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel descriptionLabel = new JLabel("Description:");
		descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		descriptionLabel.setBounds(273, 63, 207, 25);
		panel.add(descriptionLabel);
		
		JLabel locationLabel = new JLabel("Address");
		locationLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locationLabel.setBounds(10, 6, 121, 13);
		panel.add(locationLabel);
		
		breakfastChk = new JCheckBox("Breakfast Offered");
		breakfastChk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		breakfastChk.setBounds(10, 87, 161, 21);
		panel.add(breakfastChk);
		
		descriptionTxt = new JTextField();
		descriptionTxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		descriptionTxt.setBounds(381, 66, 466, 20);
		panel.add(descriptionTxt);
		descriptionTxt.setColumns(10);
		
		JButton CancelBtn = new JButton("Cancel");
		CancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HostProfilePage window = new HostProfilePage(p);
				window.getFrame().setVisible(true);
				window.getFrame().pack();
				window.getFrame().setLocationRelativeTo(null);
				dispose();
			}
		});
		CancelBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CancelBtn.setBounds(1065, 741, 96, 21);
		panel.add(CancelBtn);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check for filled in form
				ChargeBandController cbc = new ChargeBandController();
				if(!(txtbxHouse.getText().length() == 0) && !(txtbxStreetName.getText().length() == 0) 
						&& !(txtbxCity.getText().length() == 0) && !(txtbxPostCode.getText().length() == 0)
						&& !(bedrooms.isEmpty()) && !(bathrooms.isEmpty()) && !(chargeBands.isEmpty())
						&& !(txtbxName.getText().length() == 0)) {
					if(txtbxPostCode.getText().length() > 15) {
						JOptionPane.showMessageDialog(null, "A postcode cannot be longer than 15 characters!", "Invalid Postcode", JOptionPane.WARNING_MESSAGE);
					}else if(txtbxHouse.getText().length() > 20) { 
						JOptionPane.showMessageDialog(null, "A House Name/Number cannot be longer than 20 characters!", "Invalid House Name/Number", JOptionPane.WARNING_MESSAGE);
					}else if(txtbxStreetName.getText().length() > 20) { 
						JOptionPane.showMessageDialog(null, "A Street Name cannot be longer than 20 characters!", "Invalid Street Name", JOptionPane.WARNING_MESSAGE);
					}else if(txtbxCity.getText().length() > 20) { 
						JOptionPane.showMessageDialog(null, "A City name cannot be longer than 20 characters!", "Invalid City", JOptionPane.WARNING_MESSAGE);
					}else if(descriptionTxt.getText().length() > 200) { 
						JOptionPane.showMessageDialog(null, "The description cannot be longer than 200 characters!", "Invalid Description", JOptionPane.WARNING_MESSAGE);
					}else if(cbc.allDatesCovered(chargeBands) == false){
						JOptionPane.showMessageDialog(null, "Charge bands incomplete.", "Invalid Charge Bands", JOptionPane.WARNING_MESSAGE);
					}else {
						
						
						Sleeping sleeping = new Sleeping(bedrooms,
								chckbxBedLinen.isSelected(),
								chckbxTowels.isSelected());
						Bathing bathing = new Bathing(bathrooms, chckbxHairDryer.isSelected(),
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
						
						Address address = new Address(txtbxHouse.getText(),
								txtbxStreetName.getText(), txtbxCity.getText(), 
								txtbxPostCode.getText());
						
						Property property = new Property(chargeBands, address, txtbxName.getText(),
								descriptionTxt.getText(), breakfastChk.isSelected(), bathing,
								kitchen, living, outdoor, sleeping, utility);
						
						Validation v = new Validation();
						v.validateProperty(p, property);
						
						HostProfilePage window = new HostProfilePage(p);
						window.getFrame().setVisible(true);
						window.getFrame().pack();
						window.getFrame().setLocationRelativeTo(null);
						dispose();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please fill in all fields!", "Empty fields", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(994, 741, 61, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Facilities");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(618, 91, 121, 13);
		panel.add(lblNewLabel);
		
		JPanel sleepingPanel = new JPanel();
		sleepingPanel.setBounds(273, 130, 207, 152);
		panel.add(sleepingPanel);
		sleepingPanel.setLayout(null);
		
		JLabel sleepingLabel = new JLabel("Sleeping");
		sleepingLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		sleepingLabel.setBounds(51, 0, 75, 40);
		sleepingPanel.add(sleepingLabel);
		
		chckbxBedLinen = new JCheckBox("Bed Linen");
		chckbxBedLinen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxBedLinen.setBounds(0, 29, 109, 21);
		sleepingPanel.add(chckbxBedLinen);
		
		chckbxTowels = new JCheckBox("Towels");
		chckbxTowels.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxTowels.setBounds(0, 52, 109, 21);
		sleepingPanel.add(chckbxTowels);
		
		JButton btnAddBedroom = new JButton("Add Bedroom Info");
		btnAddBedroom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddBedroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBedroom addBedroom = new AddBedroom();
				addBedroom.setVisible(true);
				addBedroom.setSize(new Dimension(50, 200));
				addBedroom.setPreferredSize(new Dimension(50, addBedroom.getPreferredSize().height));
				int result = JOptionPane.showConfirmDialog(null, addBedroom,
						"Add Bedroom", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE);
				if(result == JOptionPane.OK_OPTION) {
					Bedroom bedroom = new Bedroom(Bed.stringToBed(addBedroom.cmbBed1.getSelectedItem().toString()), 
							Bed.stringToBed(addBedroom.cmbBed2.getSelectedItem().toString()));
					bedrooms.add(bedroom);
				}
			}
		});
		
		btnAddBedroom.setBounds(10, 121, 187, 21);
		sleepingPanel.add(btnAddBedroom);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(544, 130, 246, 152);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Bathing");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(85, -11, 78, 40);
		panel_1.add(lblNewLabel_1);
		
		chckbxHairDryer = new JCheckBox("Hair Dryer");
		chckbxHairDryer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxHairDryer.setBounds(6, 24, 109, 21);
		panel_1.add(chckbxHairDryer);
		
		chckbxShampoo = new JCheckBox("Shampoo");
		chckbxShampoo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxShampoo.setBounds(6, 47, 109, 21);
		panel_1.add(chckbxShampoo);
		
		chckbxToiletPaper = new JCheckBox("Toilet Paper");
		chckbxToiletPaper.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxToiletPaper.setBounds(6, 70, 127, 21);
		panel_1.add(chckbxToiletPaper);
		
		JButton btnAddBathroom = new JButton("Add Bathroom Info");
		btnAddBathroom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddBathroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBathroom addBathroom = new AddBathroom();
				addBathroom.setVisible(true);
				addBathroom.setSize(new Dimension(350, 200));
				addBathroom.setPreferredSize(new Dimension(350, addBathroom.getPreferredSize().height));
				int result = JOptionPane.showConfirmDialog(null, addBathroom,  "Add Bathroom",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(result == JOptionPane.OK_OPTION) {
					Bathroom bathroom = new Bathroom(addBathroom.chckbxToilet.isSelected(),
							addBathroom.chckbxBath.isSelected(), 
							addBathroom.chckbxShower.isSelected(),
							addBathroom.chckbxSharedWithHost.isSelected());
					bathrooms.add(bathroom);
				}
			}
		});
		btnAddBathroom.setBounds(35, 121, 186, 21);
		panel_1.add(btnAddBathroom);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(273, 341, 207, 256);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Kitchen");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(79, 5, 66, 13);
		panel_1_1.add(lblNewLabel_1_1);
		
		chckbxRefrigerator = new JCheckBox("Refrigerator");
		chckbxRefrigerator.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxRefrigerator.setBounds(6, 24, 139, 21);
		panel_1_1.add(chckbxRefrigerator);
		
		chckbxMicrowave = new JCheckBox("Microwave");
		chckbxMicrowave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxMicrowave.setBounds(6, 47, 109, 21);
		panel_1_1.add(chckbxMicrowave);
		
		chckbxOven = new JCheckBox("Oven");
		chckbxOven.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxOven.setBounds(6, 70, 109, 21);
		panel_1_1.add(chckbxOven);
		
		chckbxStove = new JCheckBox("Stove");
		chckbxStove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxStove.setBounds(6, 93, 109, 21);
		panel_1_1.add(chckbxStove);
		
	    chckbxDishwasher = new JCheckBox("Dishwasher");
		chckbxDishwasher.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxDishwasher.setBounds(6, 116, 109, 21);
		panel_1_1.add(chckbxDishwasher);
		
		chckbxTableware = new JCheckBox("Tableware");
		chckbxTableware.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxTableware.setBounds(6, 139, 109, 21);
		panel_1_1.add(chckbxTableware);
		
		chckbxCookware = new JCheckBox("Cookware");
		chckbxCookware.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxCookware.setBounds(6, 162, 109, 21);
		panel_1_1.add(chckbxCookware);
		
		chckbxProvisions = new JCheckBox("Provisions");
		chckbxProvisions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxProvisions.setBounds(6, 185, 109, 21);
		panel_1_1.add(chckbxProvisions);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(544, 341, 246, 207);
		panel.add(panel_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Living");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(93, 0, 66, 31);
		panel_1_2.add(lblNewLabel_1_2);
		
		chckbxWifi = new JCheckBox("Wifi");
		chckbxWifi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxWifi.setBounds(6, 24, 109, 21);
		panel_1_2.add(chckbxWifi);
		
		chckbxTelevision = new JCheckBox("Television");
		chckbxTelevision.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxTelevision.setBounds(6, 47, 109, 21);
		panel_1_2.add(chckbxTelevision);
		
		chckbxSatellite = new JCheckBox("Satellite");
		chckbxSatellite.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxSatellite.setBounds(6, 70, 109, 21);
		panel_1_2.add(chckbxSatellite);
		
		chckbxStreaming = new JCheckBox("Streaming");
		chckbxStreaming.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxStreaming.setBounds(6, 93, 109, 21);
		panel_1_2.add(chckbxStreaming);
		
		chckbxDvdPlayer = new JCheckBox("DVD Player");
		chckbxDvdPlayer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxDvdPlayer.setBounds(6, 116, 109, 21);
		panel_1_2.add(chckbxDvdPlayer);
		
		chckbxBoardGames = new JCheckBox("Board Games");
		chckbxBoardGames.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxBoardGames.setBounds(6, 139, 131, 21);
		panel_1_2.add(chckbxBoardGames);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBounds(851, 341, 220, 207);
		panel.add(panel_1_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Utility");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(95, 5, 66, 13);
		panel_1_2_1.add(lblNewLabel_1_2_1);
		
		chckbxHeating = new JCheckBox("Heating");
		chckbxHeating.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxHeating.setBounds(6, 24, 109, 21);
		panel_1_2_1.add(chckbxHeating);
		
		chckbxWashingMachine = new JCheckBox("Washing Machine");
		chckbxWashingMachine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxWashingMachine.setBounds(6, 47, 155, 21);
		panel_1_2_1.add(chckbxWashingMachine);
		
		chckbxDryingMachine = new JCheckBox("Drying Machine");
		chckbxDryingMachine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxDryingMachine.setBounds(6, 70, 135, 21);
		panel_1_2_1.add(chckbxDryingMachine);
		
		chckbxFireExtinguisher = new JCheckBox("Fire Extinguisher");
		chckbxFireExtinguisher.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxFireExtinguisher.setBounds(6, 93, 155, 21);
		panel_1_2_1.add(chckbxFireExtinguisher);
		
		chckbxSmokeAlarm = new JCheckBox("Smoke Alarm");
		chckbxSmokeAlarm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxSmokeAlarm.setBounds(6, 116, 135, 21);
		panel_1_2_1.add(chckbxSmokeAlarm);
		
		chckbxFirstAidKit = new JCheckBox("First Aid Kit");
		chckbxFirstAidKit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxFirstAidKit.setBounds(6, 139, 109, 21);
		panel_1_2_1.add(chckbxFirstAidKit);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(851, 130, 220, 152);
		panel.add(panel_1_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Outdoor");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(49, 5, 89, 13);
		panel_1_3.add(lblNewLabel_1_3);
		
		chckbxFreeOnsiteParking = new JCheckBox("Free On-Site Parking");
		chckbxFreeOnsiteParking.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxFreeOnsiteParking.setBounds(6, 24, 188, 21);
		panel_1_3.add(chckbxFreeOnsiteParking);
		
		chckbxOnroadParking = new JCheckBox("On-Road Parking");
		chckbxOnroadParking.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxOnroadParking.setBounds(6, 47, 158, 21);
		panel_1_3.add(chckbxOnroadParking);
		
		chckbxPaidParking = new JCheckBox("Paid Parking");
		chckbxPaidParking.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxPaidParking.setBounds(6, 70, 132, 21);
		panel_1_3.add(chckbxPaidParking);
		
		chckbxPatio = new JCheckBox("Patio");
		chckbxPatio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxPatio.setBounds(6, 93, 109, 21);
		panel_1_3.add(chckbxPatio);
		
		chckbxBarbecue = new JCheckBox("Barbecue");
		chckbxBarbecue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxBarbecue.setBounds(6, 116, 109, 21);
		panel_1_3.add(chckbxBarbecue);
		
		JLabel lblNewLabel_2 = new JLabel("House Name/Number:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(104, 8, 220, 18);
		panel.add(lblNewLabel_2);
		
		txtbxHouse = new JTextField();
		txtbxHouse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtbxHouse.setBounds(268, 3, 136, 25);
		panel.add(txtbxHouse);
		txtbxHouse.setColumns(10);
		
		JLabel cityLabel = new JLabel("City:");
		cityLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cityLabel.setBounds(226, 38, 136, 20);
		panel.add(cityLabel);
		
		JLabel lblNewLabel_2_2 = new JLabel("Street Name:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(588, 7, 138, 13);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Post Code:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(601, 42, 138, 13);
		panel.add(lblNewLabel_2_3);
		
		txtbxStreetName = new JTextField();
		txtbxStreetName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtbxStreetName.setColumns(10);
		txtbxStreetName.setBounds(686, 3, 161, 25);
		panel.add(txtbxStreetName);
		
		txtbxPostCode = new JTextField();
		txtbxPostCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtbxPostCode.setColumns(10);
		txtbxPostCode.setBounds(726, 35, 121, 25);
		panel.add(txtbxPostCode);
		
		txtbxCity = new JTextField();
		txtbxCity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtbxCity.setColumns(10);
		txtbxCity.setBounds(260, 33, 144, 25);
		panel.add(txtbxCity);
		
		JButton btnNewButton_1 = new JButton("Add Charge Band");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddChargeBand a = new AddChargeBand(chargeBands);
				a.setVisible(true);
				a.setSize(new Dimension(450, 200));
				a.setPreferredSize(new Dimension(450, a.getPreferredSize().height));
				int result = JOptionPane.showConfirmDialog(null, a, "Add Charge Band", 
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(result == JOptionPane.OK_OPTION) {
					ChargeBandController cbc = new ChargeBandController();
					if(a.serviceChargeTxt.getText().length() <= 1) {
						JOptionPane.showMessageDialog(null, "Invalid inputs. Please try again.", "Error", JOptionPane.WARNING_MESSAGE);
					}
					else if(a.cleaningChargeTxt.getText().length() <= 1) {
						JOptionPane.showMessageDialog(null, "Invalid inputs. Please try again.", "Error", JOptionPane.WARNING_MESSAGE);
					}
					else if(a.pppTxt.getText().length() <= 1) {
						JOptionPane.showMessageDialog(null, "Invalid inputs. Please try again.", "Error", JOptionPane.WARNING_MESSAGE);
					}
					else if(LocalDate.parse(a.startDateTxt.getText()).isAfter(LocalDate.parse(a.endDateTxt.getText()))){
						JOptionPane.showMessageDialog(null, "Invalid inputs. Please try again.", "Error", JOptionPane.WARNING_MESSAGE);
					} else {
						ChargeBand cb = new ChargeBand(a.startDateTxt.getText(),
								a.endDateTxt.getText(), 
								Double.parseDouble(a.serviceChargeTxt.getText().substring(1)),
								Double.parseDouble(a.cleaningChargeTxt.getText().substring(1)),
								Double.parseDouble(a.pppTxt.getText().substring(1)));
						if(cbc.chargeBandsOverlap(chargeBands, cb)) {
							JOptionPane.showMessageDialog(null, "Charge band overlaps with"
									+ "existing charge bands. Please try again.", "Error", JOptionPane.WARNING_MESSAGE);
						} else {
							chargeBands.add(cb);
							if(cbc.allDatesCovered(chargeBands)) {
								lblChargeBandStatus.setText("Charge bands complete.");
								btnNewButton_1.setEnabled(false);
								btnNewButton.setEnabled(true);
								lblOKButtonStatus.setVisible(false);
							}
						}
					}
				}
			}
		});
		btnNewButton_1.setBounds(33, 724, 184, 25);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 54, 61, 13);
		panel.add(lblNewLabel_3);
		
		txtbxName = new JTextField();
		txtbxName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtbxName.setBounds(59, 50, 121, 25);
		panel.add(txtbxName);
		txtbxName.setColumns(10);
		
		lblChargeBandStatus = new JLabel("Charge bands are incomplete");
		lblChargeBandStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChargeBandStatus.setBounds(33, 689, 207, 25);
		panel.add(lblChargeBandStatus);
		
		lblOKButtonStatus = new JLabel("Complete charge bands to add property");
		lblOKButtonStatus.setBounds(728, 741, 256, 20);
		panel.add(lblOKButtonStatus);
	}
}
