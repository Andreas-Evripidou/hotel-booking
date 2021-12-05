package views;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controllers.DatabaseCommunication;
import controllers.RequestController;
import model.Host;

import model.Person;
import model.Property;
import model.Reservation;


import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import java.awt.Color;

public class ViewPropertyPage extends JPanel {
	private Property property; //property to be viewed
	private Person person; //current user of the system
	private Host host; //host of the property
	private int propertyID;
	private boolean accepted;

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
	
	private JLabel lblPropertyName;
	private JTextArea lblDescription;
	private JLabel lblHostName;
	private JLabel lblBreakfastOffered;
	private JLabel lblSuperHost;
	private JTextField textFieldHouse;
	private JTextField textFieldStreet;
	private JTextField textFieldPlace;
	private JTextField textFieldPostcode;
	
	JButton btnNewButton; //the request button
	JLabel lblRequestInfo; //label to inform user to log in as guest
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblBathroomCount;
	private JLabel lblBedroomCount;
	private JLabel lblMaxGuests;
	/**
	 * @wbp.nonvisual location=290,29
	 */
	private final JPanel panel = new JPanel();
	

	/**
	 * Create the application.
	 */
	public ViewPropertyPage(JFrame frame, JPanel previousPanel , Property property, Person person, Host host, int propertyID, boolean accepted) {
		this.property = property;
		this.person = person;
		this.host = host;
		this.propertyID = propertyID;
		this.accepted = accepted;
		initialize(frame, previousPanel);
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frame, JPanel previousPanel) {
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		lblPropertyName = new JLabel("(Property Name)");
		lblPropertyName.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPropertyName.setBounds(10, 10, 316, 72);
		panel.add(lblPropertyName);
		
		lblDescription = new JTextArea("(Property Description)");
		lblDescription.setEditable(false);
		lblDescription.setLineWrap(true);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescription.setBounds(10, 66, 336, 128);
		panel.add(lblDescription);
		
		JLabel lblNewLabel = new JLabel("Hosted By:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 189, 104, 48);
		panel.add(lblNewLabel);
		
		lblHostName = new JLabel("(Host Name)");
		lblHostName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHostName.setBounds(124, 189, 233, 48);
		panel.add(lblHostName);
		
		lblBreakfastOffered = new JLabel("Breakfast is offered by this property host");
		lblBreakfastOffered.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBreakfastOffered.setBounds(10, 505, 363, 48);
		panel.add(lblBreakfastOffered);
		
		JLabel lblNewLabel_1 = new JLabel("Facilities:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(523, 10, 147, 43);
		panel.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Request to book property");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequestPropertyPanel r = new RequestPropertyPanel(property);
				r.setVisible(true);
				r.setSize(new Dimension(350, 300));
				r.setPreferredSize(new Dimension(350, r.getPreferredSize().height));
				int result = JOptionPane.showConfirmDialog(null, r, "Request " + property.getName(),
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(result == JOptionPane.OK_OPTION) {
					DatabaseCommunication dc = new DatabaseCommunication();
					Reservation reservation = new Reservation(person.getEmail(), dc.getPropertyID(property.getPostCode()), 
							Date.valueOf(r.txtbxStartDate.getText()), Date.valueOf(r.txtbxEndDate.getText()), false);
					RequestController req = new RequestController(reservation);
					req.makeRequest();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(40, 735, 286, 44);
		panel.add(btnNewButton);
		
		JPanel sleepingPanel = new JPanel();
		sleepingPanel.setLayout(null);
		sleepingPanel.setBounds(477, 64, 207, 152);
		panel.add(sleepingPanel);
		
		JLabel sleepingLabel = new JLabel("Sleeping");
		sleepingLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		sleepingLabel.setBounds(52, 0, 120, 40);
		sleepingPanel.add(sleepingLabel);
		
		chckbxBedLinen = new JCheckBox("Bed Linen");
		chckbxBedLinen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxBedLinen.setBounds(38, 41, 109, 21);
		chckbxBedLinen.setEnabled(false);
		sleepingPanel.add(chckbxBedLinen);
		
		chckbxTowels = new JCheckBox("Towels");
		chckbxTowels.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxTowels.setBounds(38, 79, 109, 21);
		chckbxTowels.setEnabled(false);
		sleepingPanel.add(chckbxTowels);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(477, 226, 209, 152);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Bathing");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(54, 0, 91, 40);
		panel_1.add(lblNewLabel_1_1);
		
		chckbxHairDryer = new JCheckBox("Hair Dryer");
		chckbxHairDryer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxHairDryer.setBounds(36, 46, 109, 21);
		chckbxHairDryer.setEnabled(false);
		panel_1.add(chckbxHairDryer);
		
		chckbxShampoo = new JCheckBox("Shampoo");
		chckbxShampoo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxShampoo.setBounds(36, 78, 109, 21);
		chckbxShampoo.setEnabled(false);
		panel_1.add(chckbxShampoo);
		
		chckbxToiletPaper = new JCheckBox("Toilet Paper");
		chckbxToiletPaper.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxToiletPaper.setBounds(36, 114, 127, 21);
		chckbxToiletPaper.setEnabled(false);
		panel_1.add(chckbxToiletPaper);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(476, 388, 209, 320);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Kitchen");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(54, 10, 88, 21);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		chckbxRefrigerator = new JCheckBox("Refrigerator");
		chckbxRefrigerator.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxRefrigerator.setBounds(33, 48, 139, 21);
		chckbxRefrigerator.setEnabled(false);
		panel_1_1.add(chckbxRefrigerator);
		
		 chckbxMicrowave = new JCheckBox("Microwave");
		chckbxMicrowave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxMicrowave.setBounds(33, 82, 130, 21);
		chckbxMicrowave.setEnabled(false);
		panel_1_1.add(chckbxMicrowave);
		
		chckbxOven = new JCheckBox("Oven");
		chckbxOven.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxOven.setBounds(33, 117, 109, 21);
		chckbxOven.setEnabled(false);
		panel_1_1.add(chckbxOven);
		
		chckbxStove = new JCheckBox("Stove");
		chckbxStove.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxStove.setBounds(33, 149, 109, 21);
		chckbxStove.setEnabled(false);
		panel_1_1.add(chckbxStove);
		
		chckbxDishwasher = new JCheckBox("Dishwasher");
		chckbxDishwasher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxDishwasher.setBounds(33, 182, 139, 21);
		chckbxDishwasher.setEnabled(false);
		panel_1_1.add(chckbxDishwasher);
		
		chckbxTableware = new JCheckBox("Tableware");
		chckbxTableware.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxTableware.setBounds(33, 218, 109, 21);
		chckbxTableware.setEnabled(false);
		panel_1_1.add(chckbxTableware);
		
		chckbxCookware = new JCheckBox("Cookware");
		chckbxCookware.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxCookware.setBounds(33, 252, 109, 21);
		chckbxCookware.setEnabled(false);
		panel_1_1.add(chckbxCookware);
		
		chckbxProvisions = new JCheckBox("Provisions");
		chckbxProvisions.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxProvisions.setBounds(33, 283, 109, 21);
		chckbxProvisions.setEnabled(false);
		panel_1_1.add(chckbxProvisions);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(701, 66, 207, 270);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Living");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(73, 0, 66, 31);
		panel_1_2.add(lblNewLabel_1_2);
		
		chckbxWifi = new JCheckBox("Wifi");
		chckbxWifi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxWifi.setBounds(50, 37, 91, 21);
		chckbxWifi.setEnabled(false);
		panel_1_2.add(chckbxWifi);
		
		chckbxTelevision = new JCheckBox("Television");
		chckbxTelevision.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxTelevision.setBounds(50, 72, 109, 21);
		chckbxTelevision.setEnabled(false);
		panel_1_2.add(chckbxTelevision);
		
		chckbxSatellite = new JCheckBox("Satellite");
		chckbxSatellite.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxSatellite.setBounds(50, 109, 109, 21);
		chckbxSatellite.setEnabled(false);
		panel_1_2.add(chckbxSatellite);
		
		chckbxStreaming = new JCheckBox("Streaming");
		chckbxStreaming.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxStreaming.setBounds(50, 144, 109, 21);
		chckbxStreaming.setEnabled(false);
		panel_1_2.add(chckbxStreaming);
		
		chckbxDvdPlayer = new JCheckBox("DVD Player");
		chckbxDvdPlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxDvdPlayer.setBounds(50, 180, 129, 21);
		chckbxDvdPlayer.setEnabled(false);
		panel_1_2.add(chckbxDvdPlayer);
		
		chckbxBoardGames = new JCheckBox("Board Games");
		chckbxBoardGames.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxBoardGames.setBounds(50, 213, 151, 21);
		chckbxBoardGames.setEnabled(false);
		panel_1_2.add(chckbxBoardGames);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(918, 272, 212, 224);
		panel.add(panel_1_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Outdoor");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(70, 10, 94, 21);
		panel_1_3.add(lblNewLabel_1_3);
		
		chckbxFreeOnsiteParking = new JCheckBox("Free On-Site Parking");
		chckbxFreeOnsiteParking.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxFreeOnsiteParking.setBounds(23, 37, 200, 21);
		chckbxFreeOnsiteParking.setEnabled(false);
		panel_1_3.add(chckbxFreeOnsiteParking);
		
		chckbxOnroadParking = new JCheckBox("On-Road Parking");
		chckbxOnroadParking.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxOnroadParking.setBounds(23, 73, 178, 21);
		chckbxOnroadParking.setEnabled(false);
		panel_1_3.add(chckbxOnroadParking);
		
		chckbxPaidParking = new JCheckBox("Paid Parking");
		chckbxPaidParking.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxPaidParking.setBounds(23, 108, 132, 21);
		chckbxPaidParking.setEnabled(false);
		panel_1_3.add(chckbxPaidParking);
		
		chckbxPatio = new JCheckBox("Patio");
		chckbxPatio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxPatio.setBounds(23, 141, 109, 21);
		chckbxPatio.setEnabled(false);
		panel_1_3.add(chckbxPatio);
		
		chckbxBarbecue = new JCheckBox("Barbecue");
		chckbxBarbecue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxBarbecue.setBounds(23, 174, 109, 21);
		chckbxBarbecue.setEnabled(false);
		panel_1_3.add(chckbxBarbecue);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBounds(696, 422, 212, 286);
		panel.add(panel_1_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Utility");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(75, 10, 69, 31);
		panel_1_2_1.add(lblNewLabel_1_2_1);
		
		chckbxHeating = new JCheckBox("Heating");
		chckbxHeating.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxHeating.setBounds(40, 47, 109, 21);
		chckbxHeating.setEnabled(false);
		panel_1_2_1.add(chckbxHeating);
		
		chckbxWashingMachine = new JCheckBox("Washing Machine");
		chckbxWashingMachine.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxWashingMachine.setBounds(40, 78, 174, 21);
		chckbxWashingMachine.setEnabled(false);
		panel_1_2_1.add(chckbxWashingMachine);
		
		chckbxDryingMachine = new JCheckBox("Drying Machine");
		chckbxDryingMachine.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxDryingMachine.setBounds(40, 114, 154, 21);
		chckbxDryingMachine.setEnabled(false);
		panel_1_2_1.add(chckbxDryingMachine);
		
		chckbxFireExtinguisher = new JCheckBox("Fire Extinguisher");
		chckbxFireExtinguisher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxFireExtinguisher.setBounds(40, 150, 174, 21);
		chckbxFireExtinguisher.setEnabled(false);
		panel_1_2_1.add(chckbxFireExtinguisher);
		
		chckbxSmokeAlarm = new JCheckBox("Smoke Alarm");
		chckbxSmokeAlarm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxSmokeAlarm.setBounds(40, 186, 135, 21);
		chckbxSmokeAlarm.setEnabled(false);
		panel_1_2_1.add(chckbxSmokeAlarm);
		
		chckbxFirstAidKit = new JCheckBox("First Aid Kit");
		chckbxFirstAidKit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxFirstAidKit.setBounds(40, 221, 123, 21);
		chckbxFirstAidKit.setEnabled(false);
		panel_1_2_1.add(chckbxFirstAidKit);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//return to last page
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();
				frame.getContentPane().add(previousPanel);
				frame.revalidate();
				frame.repaint();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(1101, 742, 75, 31);
		panel.add(btnNewButton_1);
		
		lblSuperHost = new JLabel("This host is a Super Host.");
		lblSuperHost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSuperHost.setBounds(10, 230, 195, 13);
		panel.add(lblSuperHost);
		
		JButton btnReviews = new JButton("See Reviews");
		btnReviews.setBackground(Color.LIGHT_GRAY);
		btnReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				ReviewPanels newFrame = new ReviewPanels(propertyID);
				newFrame.getFrame().setVisible(true);
				newFrame.getFrame().pack();
				newFrame.getFrame().setLocationRelativeTo(null);
//				frmViewProperty.dispose();
				
			}
		});
		btnReviews.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReviews.setBounds(354, 735, 156, 44);
		panel.add(btnReviews);
		
		lblRequestInfo = new JLabel("Log in as a guest to request this property.");
		lblRequestInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRequestInfo.setBounds(36, 704, 290, 31);
		panel.add(lblRequestInfo);
		
		lblNewLabel_2 = new JLabel("Number of bathrooms:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 563, 195, 24);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Number of bedrooms:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 604, 195, 20);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Max. Guests:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(79, 645, 104, 20);
		panel.add(lblNewLabel_4);
		
		lblBathroomCount = new JLabel("");
		lblBathroomCount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBathroomCount.setBounds(181, 566, 53, 21);
		panel.add(lblBathroomCount);
		
		lblBedroomCount = new JLabel("");
		lblBedroomCount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBedroomCount.setBounds(181, 603, 53, 21);
		panel.add(lblBedroomCount);
		
		lblMaxGuests = new JLabel("");
		lblMaxGuests.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMaxGuests.setBounds(181, 644, 53, 21);
		panel.add(lblMaxGuests);
		
		JPanel panelAddress = new JPanel();
		panelAddress.setBounds(9, 272, 325, 205);
		if(accepted)
			panel.add(panelAddress);
		panelAddress.setLayout(null);
		
		JLabel lblHouseNumber = new JLabel("House:");
		lblHouseNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblHouseNumber.setBounds(11, 10, 61, 16);
		panelAddress.add(lblHouseNumber);
		
		JLabel lblStreetName = new JLabel("Street Name:");
		lblStreetName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblStreetName.setBounds(11, 59, 101, 16);
		panelAddress.add(lblStreetName);
		
		JLabel lblPlaceName = new JLabel("Place Name:");
		lblPlaceName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPlaceName.setBounds(11, 110, 101, 16);
		panelAddress.add(lblPlaceName);
		
		JLabel lblPostCode = new JLabel("Postcode:");
		lblPostCode.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPostCode.setBounds(11, 161, 83, 16);
		panelAddress.add(lblPostCode);
		
		textFieldHouse = new JTextField(property.getAddress().getHouse());
		textFieldHouse.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textFieldHouse.setEditable(false);
		textFieldHouse.setBounds(116, 6, 203, 26);
		panelAddress.add(textFieldHouse);
		textFieldHouse.setColumns(10);
		
		textFieldStreet = new JTextField(property.getAddress().getStreetName());
		textFieldStreet.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textFieldStreet.setEditable(false);
		textFieldStreet.setColumns(10);
		textFieldStreet.setBounds(116, 54, 203, 26);
		panelAddress.add(textFieldStreet);
		
		textFieldPlace = new JTextField(property.getAddress().getPlaceName());
		textFieldPlace.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textFieldPlace.setEditable(false);
		textFieldPlace.setColumns(10);
		textFieldPlace.setBounds(116, 105, 203, 26);
		panelAddress.add(textFieldPlace);
		
		textFieldPostcode = new JTextField(property.getAddress().getPostCode());
		textFieldPostcode.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textFieldPostcode.setEditable(false);
		textFieldPostcode.setColumns(10);
		textFieldPostcode.setBounds(116, 156, 203, 26);
		panelAddress.add(textFieldPostcode);
		
		checkBoxes();
		setLabels();
		setTextAreas();
		setButtonVisibility();
		setLayout(new BorderLayout(0, 0));
		add(panel);
	}
	
	
	
	private void checkBoxes() {
		checkBathingBoxes();
		checkKitchenBoxes();
		checkLivingBoxes();
		checkOutdoorBoxes();
		checkSleepingBoxes();
		checkUtilityBoxes();
	}
	
	private void checkBathingBoxes() {
		if(property.getBathing().getHairDryer() == 1) chckbxHairDryer.setSelected(true);
		if(property.getBathing().getShampoo() == 1) chckbxShampoo.setSelected(true);
		if(property.getBathing().getToiletPaper() == 1) chckbxToiletPaper.setSelected(true);
	}
	private void checkKitchenBoxes() {
		if(property.getKitchen().getCookware() == 1) chckbxCookware.setSelected(true);
		if(property.getKitchen().getDishwasher() == 1) chckbxDishwasher.setSelected(true);
		if(property.getKitchen().getMicrowave() == 1) chckbxMicrowave.setSelected(true);
		if(property.getKitchen().getOven() == 1) chckbxOven.setSelected(true);
		if(property.getKitchen().getProvisions() == 1) chckbxProvisions.setSelected(true);
		if(property.getKitchen().getRefrigerator() == 1) chckbxRefrigerator.setSelected(true);
		if(property.getKitchen().getStove() == 1) chckbxStove.setSelected(true);
		if(property.getKitchen().getTableware() == 1) chckbxTableware.setSelected(true);
	}
	private void checkLivingBoxes() {
		if(property.getLiving().getBoardGames() == 1) chckbxBoardGames.setSelected(true);
		if(property.getLiving().getDVDPlayer() == 1) chckbxDvdPlayer.setSelected(true);
		if(property.getLiving().getSatellite() == 1) chckbxSatellite.setSelected(true);
		if(property.getLiving().getStreaming() == 1) chckbxStreaming.setSelected(true);
		if(property.getLiving().getTV() == 1) chckbxTelevision.setSelected(true);
		if(property.getLiving().getWifi() == 1) chckbxWifi.setSelected(true);
	}
	private void checkOutdoorBoxes() {
		if(property.getOutdoor().getBarbecue() == 1) chckbxBarbecue.setSelected(true);
		if(property.getOutdoor().getFreeOnsiteParking() == 1) chckbxFreeOnsiteParking.setSelected(true);
		if(property.getOutdoor().getOnRoadParking() == 1) chckbxOnroadParking.setSelected(true);
		if(property.getOutdoor().getPaidParking() == 1) chckbxPaidParking.setSelected(true);
		if(property.getOutdoor().getPatio() == 1) chckbxPatio.setSelected(true);
	}
	private void checkSleepingBoxes() {
		if(property.getSleeping().getBedLinen() == 1) chckbxBedLinen.setSelected(true);
		if(property.getSleeping().getTowels() == 1) chckbxTowels.setSelected(true);
	}
	private void checkUtilityBoxes() {
		if(property.getUtility().getCentralHeating()== 1) chckbxHeating.setSelected(true);
		if(property.getUtility().getDryingMachine() == 1) chckbxDryingMachine.setSelected(true);
		if(property.getUtility().getFireExtinguisher() == 1) chckbxFireExtinguisher.setSelected(true);
		if(property.getUtility().getFirstAidKit() == 1) chckbxFirstAidKit.setSelected(true);
		if(property.getUtility().getSmokeAlarm() == 1) chckbxSmokeAlarm.setSelected(true);
		if(property.getUtility().getWashingMachine() == 1) chckbxWashingMachine.setSelected(true);
	}
	
	private void setLabels() {
		lblPropertyName.setText(property.getName() + ", " + property.getAddress().getPlaceName());
		lblHostName.setText(host.getHostName());
		if(!(property.getBreakfastOffered())) lblBreakfastOffered.setText("");
		if(!(host.getIsSuperHost())) lblSuperHost.setText("");
		lblBathroomCount.setText(String.valueOf(property.getBathroomCount()));
		lblBedroomCount.setText(String.valueOf(property.getBedroomCount()));
		lblMaxGuests.setText(String.valueOf(property.getSleeping().getTotalSleepers()));
	}
	
	private void setButtonVisibility() {
		if(person == null) {
			//disable request button if user is not a guest
			btnNewButton.setEnabled(false);
			//display text to inform user
		}
		else {
			lblRequestInfo.setVisible(false);
		}
	}
	
	private void setTextAreas() {
		lblDescription.setText(property.getDescription());
	}
}
