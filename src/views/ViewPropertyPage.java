package views;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import Facilities.Bathing;
import Facilities.Bathroom;
import Facilities.Bed;
import Facilities.Bedroom;
import Facilities.Kitchen;
import Facilities.Living;
import Facilities.Outdoor;
import Facilities.Sleeping;
import Facilities.Utility;
import main.Address;
import main.ChargeBand;
import main.Host;
import main.Person;
import main.Property;

import javax.swing.JCheckBox;

public class ViewPropertyPage extends JFrame {
	private Property property;
	private Person person;
	private Host host;

	public JFrame frmViewProperty;
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
	private JLabel lblDescription;
	private JLabel lblHostName;
	private JLabel lblBreakfastOffered;
	private JLabel lblSuperHost;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Person m = new Person("a", "a", "d", "a", 12343, 1, 1, "a");
					Address a = new Address("1", "s", "a", "i");
					
					
					ArrayList<Bathroom> baths = new ArrayList<>();
					baths.add(new Bathroom(true, true, true, true));
					
					ArrayList<Bedroom> bedding = new ArrayList<>();
					bedding.add(new Bedroom(Bed.stringToBed("Single Bed")));
					
					Sleeping sleeping = new Sleeping(bedding, true, true);
					Bathing bathing = new Bathing(baths, true, true, true);
					Kitchen k = new Kitchen(true, true, true, true, true, true, true, true);
					Living l = new Living(true, true, true, true, true, true);
					Outdoor o = new Outdoor(true, true, true, true, true);
					Utility u = new Utility(true, true, true, true, true, true);
					
					ArrayList<ChargeBand> cb = new ArrayList<>();
					cb.add(new ChargeBand("2021-01-01","2022-01-01", 122.0, 112.0, 111.0));
							
					Property property = new Property(cb, a, "Property2", "pellares", true, bathing, k, l, o, sleeping, u);
					
					Host host = new Host("Mr", "A", "Host", "a@a.com", 77, 1, 0, "password", "A Host", false);
					
					ViewPropertyPage frame = new ViewPropertyPage(property, m, host);
					frame.frmViewProperty.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewPropertyPage(Property property, Person person, Host host) {
		this.property = property;
		this.person = person;
		this.host = host;
		initialize();
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
		lblPropertyName.setText(property.getName());
		lblDescription.setText(property.getDescription());
		lblHostName.setText(host.getHostName());
		if(!(property.getBreakfastOffered())) lblBreakfastOffered.setText("");
		if(!(host.getIsSuperHost())) lblSuperHost.setText("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("Initialising...");
		frmViewProperty = new JFrame();
		frmViewProperty.setMinimumSize(new Dimension(1200, 850));
		frmViewProperty.setTitle("View Property");
		frmViewProperty.setResizable(false);
		frmViewProperty.setBounds(100, 100, 1200, 850);
		frmViewProperty.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewProperty.getContentPane().setLayout(null);
		
		lblPropertyName = new JLabel("(Property Name)");
		lblPropertyName.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPropertyName.setBounds(10, 10, 316, 72);
		frmViewProperty.getContentPane().add(lblPropertyName);
		
		lblDescription = new JLabel("(Property Description)");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescription.setBounds(10, 66, 336, 103);
		frmViewProperty.getContentPane().add(lblDescription);
		
		JLabel lblNewLabel = new JLabel("Hosted By:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 179, 104, 48);
		frmViewProperty.getContentPane().add(lblNewLabel);
		
		lblHostName = new JLabel("(Host Name)");
		lblHostName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHostName.setBounds(124, 179, 233, 48);
		frmViewProperty.getContentPane().add(lblHostName);
		
		lblBreakfastOffered = new JLabel("Breakfast is offered by this property host");
		lblBreakfastOffered.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBreakfastOffered.setBounds(10, 505, 363, 48);
		frmViewProperty.getContentPane().add(lblBreakfastOffered);
		
		JLabel lblNewLabel_1 = new JLabel("Facilities:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(523, 10, 147, 43);
		frmViewProperty.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Request to book property");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(40, 735, 286, 44);
		frmViewProperty.getContentPane().add(btnNewButton);
		
		JPanel sleepingPanel = new JPanel();
		sleepingPanel.setLayout(null);
		sleepingPanel.setBounds(477, 64, 207, 152);
		frmViewProperty.getContentPane().add(sleepingPanel);
		
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
		frmViewProperty.getContentPane().add(panel_1);
		
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
		frmViewProperty.getContentPane().add(panel_1_1);
		
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
		frmViewProperty.getContentPane().add(panel_1_2);
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
		frmViewProperty.getContentPane().add(panel_1_3);
		
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
		frmViewProperty.getContentPane().add(panel_1_2_1);
		
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(1101, 742, 75, 31);
		frmViewProperty.getContentPane().add(btnNewButton_1);
		
		lblSuperHost = new JLabel("This host is a Super Host.");
		lblSuperHost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSuperHost.setBounds(54, 237, 195, 13);
		frmViewProperty.getContentPane().add(lblSuperHost);
		
		checkBoxes();
		setLabels();
	}
}