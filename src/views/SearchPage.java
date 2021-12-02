package views;

import java.awt.EventQueue;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

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
import main.ButtonColumn;
import main.ChargeBand;
import main.DatabaseCommunication;
import main.Host;

import controllers.PropertyController;
import controllers.RequestController;

import main.Person;
import main.Property;
import main.Reservation;
import main.ReviewsController;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JScrollBar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import main.Person;
import main.Property;
import controllers.AddressController;
import controllers.ChargeBandController;
import controllers.FacilitiesController;
import controllers.PersonController;
import controllers.PropertyController;



public class SearchPage {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=91,-31
	 */
	private final JTable table = new JTable();
	private JTextField textField;
	private JTable table_1;
	public String locationToUse;
	public String startDateToUse;
	public String endDateToUse;
	private JTextField startDayField;
	private JTextField startMonthField;
	private JTextField startYearField;
	private JTextField endDayField;
	private JTextField endMonthField;
	private JTextField endYearField;
	public Person personToUse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPage window = new SearchPage(null, null, null, null);
					window.frame.setVisible(true);
					window.getFrame().pack();
					window.getFrame().setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchPage(String locationToUse, String startDateToUse, String endDateToUse, Person person) {
		this.setPropertyLocation(locationToUse);
		this.setStartDate(startDateToUse);
		this.setEndDate(endDateToUse);
		this.setPerson(person);
		initialize();
	}

	public JFrame getFrame() {
		frame.setBounds(100, 100, 1200, 850);
		return frame;
	}

	public void setPropertyLocation(String propertyLocation) {
		this.locationToUse = propertyLocation;
	}

	public String getPropertyLocation() {
		return locationToUse;
	}

	public void setStartDate(String startDate) {
		this.startDateToUse = startDate;
	}

	public String getStartDate() {
		return startDateToUse;
	}

	public void setEndDate(String endDate) {
		this.endDateToUse = endDate;
	}

	public String getEndDate() {
		return endDateToUse;
	}
	
	
	public void setPerson(Person person) {
		this.personToUse = person;
	}
	public Person getPerson() {
		return(this.personToUse);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setSize(1200, 850);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("Location");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 29));
		lblNewLabel.setBounds(86, 137, 151, 65);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Check in");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(407, 150, 133, 38);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Check out");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 29));
		lblNewLabel_1_1.setBounds(735, 150, 193, 38);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_2 = new JLabel("Find a Property");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(463, 68, 241, 86);
		frame.getContentPane().add(lblNewLabel_2);

		if(personToUse == null) {
			JButton btnNewButton = new JButton("LOGIN");
		
			btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage newFrame = new LoginPage();
				newFrame.getFrame().setVisible(true);
				newFrame.getFrame().pack();
				newFrame.getFrame().setLocationRelativeTo(null);
				frame.dispose();					
			}
			});
			btnNewButton.setBounds(908, 21, 89, 23);
			frame.getContentPane().add(btnNewButton);
		}


		JButton btnNewButton_1 = new JButton("REGISTER");
		if (personToUse != null)
			btnNewButton_1.setText("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(personToUse == null) {
					RegistrationPage newFrame = new RegistrationPage();
					newFrame.getFrame().setVisible(true);
					newFrame.getFrame().pack();
					newFrame.getFrame().setLocationRelativeTo(null);
					frame.dispose();
				} else {
					GuestProfilePage newFrame = new GuestProfilePage(personToUse);
					newFrame.getFrame().setVisible(true);
					newFrame.getFrame().pack();
					newFrame.getFrame().setLocationRelativeTo(null);
					frame.dispose();
				}
			}
			});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(1002, 21, 109, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 307, 983, 420);
		frame.getContentPane().add(scrollPane);

		frame.setBounds(100, 100, 1200, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String query = "SELECT generalLocation FROM team023.Property";
		DatabaseCommunication db = new DatabaseCommunication();
		ArrayList<String> locations = new ArrayList<String>();
		int locationCounter = 0;
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {

				locations.add(results.getString(1));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
		}
		//
		ArrayList<String> noDuplicatesLocations = new ArrayList<String>();
		for (int counter = 0; counter < locations.size(); counter++) {
			if (noDuplicatesLocations.contains(locations.get(counter).toString())) {
				noDuplicatesLocations = noDuplicatesLocations;
			} else {
				noDuplicatesLocations.add(locations.get(counter));
			}
		}
		JComboBox comboBox = new JComboBox(noDuplicatesLocations.toArray());
		comboBox.setBounds(204, 161, 193, 30);
		frame.getContentPane().add(comboBox);

		JButton btnSearchProperties = new JButton("Search Properties");
		btnSearchProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String locationToUse = (String) comboBox.getSelectedItem();
				String startDay = (String) startDayField.getText();
				String startMonth = (String) startMonthField.getText();
				String startYear = (String) startYearField.getText();
				Boolean validDates = true;
				String startDateToUse = "";
				if (startDay.matches("\\d{2}") && (Integer.valueOf(startDay) <= 31)) {
					if (startMonth.matches("\\d{2}") && (Integer.valueOf(startMonth) <= 12)) {
						if (startYear.matches("\\d{4}")) {
							startDateToUse = startDay + " " + startMonth + " " + startYear;
						} else {
							validDates = false;
						}
					} else {
						validDates = false;
					}
				} else {
					validDates = false;
				}
				String endDay = (String) endDayField.getText();
				String endMonth = (String) endMonthField.getText();
				String endYear = (String) endYearField.getText();
				String endDateToUse = "";

				if (endDay.matches("\\d{2}") && (Integer.valueOf(endDay) <= 31)) {
					if (endMonth.matches("\\d{2}") && (Integer.valueOf(endMonth) <= 12)) {
						if (endYear.matches("\\d{4}")) {
							endDateToUse = endDay + " " + endMonth + " " + endYear;
						} else {

							validDates = false;
						}
					} else {

						validDates = false;
					}
				} else {

					validDates = false;
				}
				if (validDates) {
					SearchPage newFrame = new SearchPage(locationToUse, startDateToUse, endDateToUse, personToUse);
					newFrame.getFrame().setVisible(true);
					newFrame.getFrame().pack();
					newFrame.getFrame().setLocationRelativeTo(null);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame,
							"Ensure a date formatted DD/MM/YYYY is entered in both sections");
					validDates = true;
				}

			}
		});

		frame.getContentPane().add(btnSearchProperties);

		btnSearchProperties.setBackground(Color.LIGHT_GRAY);
		btnSearchProperties.setBounds(463, 199, 241, 75);
		frame.getContentPane().add(btnSearchProperties);
		String nameQuery = "SELECT shortName FROM team023.Property WHERE generalLocation='" + this.getPropertyLocation()
				+ "'";
		DatabaseCommunication db1 = new DatabaseCommunication();
		ArrayList<String> propertyNames = new ArrayList<String>();
		int numberOfProperties = 0;
		try {
			ResultSet results = db1.queryExecute(nameQuery);
			while (results.next()) {
				propertyNames.add(results.getString(1));
				numberOfProperties += 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db1.closeAll(db1.getResultSet(), db1.getStatement(), db1.getPreparedStatement(), db1.getConnection());
		}

		String guestQuery = "SELECT maximumGuests FROM team023.Property WHERE generalLocation='"
				+ this.getPropertyLocation() + "'";
		DatabaseCommunication db2 = new DatabaseCommunication();
		ArrayList<String> propertyGuests = new ArrayList<String>();

		try {
			ResultSet results = db2.queryExecute(guestQuery);
			while (results.next()) {
				propertyGuests.add(results.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db2.closeAll(db2.getResultSet(), db2.getStatement(), db2.getPreparedStatement(), db2.getConnection());
		}

		String datesQuery = "SELECT propertyID FROM team023.Property WHERE generalLocation='"
				+ this.getPropertyLocation() + "'";
		DatabaseCommunication db3 = new DatabaseCommunication();
		ArrayList<String> propertyIDS = new ArrayList<String>();

		try {
			ResultSet results = db3.queryExecute(datesQuery);
			while (results.next()) {
				propertyIDS.add(results.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db3.closeAll(db3.getResultSet(), db3.getStatement(), db3.getPreparedStatement(), db3.getConnection());
		}

		ArrayList<String> propertyOccupation = new ArrayList<String>();
		for (int i = 0; i < numberOfProperties; i++) {
			boolean isOccupied = false;
			String startDatesQuery = "SELECT startDate FROM team023.Reservation WHERE propertyID='" + propertyIDS.get(i)
					+ "'";
			DatabaseCommunication db4 = new DatabaseCommunication();
			ArrayList<String> startDates = new ArrayList<String>();

			try {
				ResultSet results = db4.queryExecute(startDatesQuery);
				while (results.next()) {
					startDates.add(results.getString(1).substring(8, 10) + " " + results.getString(1).substring(5, 7)
							+ " " + results.getString(1).substring(0, 4));
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db4.closeAll(db4.getResultSet(), db4.getStatement(), db4.getPreparedStatement(), db4.getConnection());
			}
			String endDatesQuery = "SELECT endDate FROM team023.Reservation WHERE propertyID='" + propertyIDS.get(i)
					+ "'";
			DatabaseCommunication db5 = new DatabaseCommunication();
			ArrayList<String> endDates = new ArrayList<String>();

			try {
				ResultSet results = db5.queryExecute(endDatesQuery);
				while (results.next()) {
					endDates.add(results.getString(1).substring(8, 10) + " " + results.getString(1).substring(5, 7)
							+ " " + results.getString(1).substring(0, 4));
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db5.closeAll(db5.getResultSet(), db5.getStatement(), db5.getPreparedStatement(), db5.getConnection());
			}
			for (int booking = 0; booking < startDates.size(); booking++) {
				DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("dd MM yyyy");

				try {
					LocalDate date1 = LocalDate.parse(startDateToUse, datetimeformat);
					LocalDate date2 = LocalDate.parse(endDateToUse, datetimeformat);
					LocalDate bookedDate1 = LocalDate.parse(startDates.get(booking), datetimeformat);
					LocalDate bookedDate2 = LocalDate.parse(endDates.get(booking), datetimeformat);
					if ((date1.isBefore(bookedDate2)) & (date2.isAfter(bookedDate1)) == true) {
						if ((date1 != bookedDate1) && (date2 != bookedDate2)) {
							isOccupied = true;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (isOccupied == true) {
				propertyOccupation.add("Unavailable");

			} else {
				propertyOccupation.add("Available");
			}
		}

		ArrayList<ArrayList<String>> allRows = new ArrayList<ArrayList<String>>(numberOfProperties);

		for (int counter = 0; counter < numberOfProperties; counter++) {
			ArrayList<String> currentRow = new ArrayList<String>();
			currentRow.add(propertyNames.get(counter));
			currentRow.add(propertyGuests.get(counter));
			currentRow.add(propertyOccupation.get(counter));

			currentRow.add("More Details");

			allRows.add(currentRow);

		}

		Object[][] rowData = new Object[numberOfProperties][];

		for (int i = 0; i < numberOfProperties; i++) {
			ArrayList<String> row = allRows.get(i);
			rowData[i] = row.toArray(new String[row.size()]);
		}
		String[] tableHeaderList = { "Property Name", "Maximum Guest Number", "Availability", "Details" };

		DefaultTableModel model = new DefaultTableModel(rowData, tableHeaderList);
		table_1 = new JTable(model);
		table_1.setRowHeight(table_1.getRowHeight() + 20);
		Action moreDetails = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int modelRow = Integer.valueOf(e.getActionCommand());

				try {
					if ( personToUse != null) {
				        int tableRow = Integer.valueOf( e.getActionCommand() );
				        String propertyIDClickedOn = propertyIDS.get(tableRow);
				        FacilitiesController fController = new FacilitiesController();
						Bathing bathing = fController.getBathingFacByPropertyID(propertyIDClickedOn);
						Sleeping sleeping = fController.getSleepingFacByPropertyID(propertyIDClickedOn);
						Kitchen kitchen = fController.getKitchenFacByPropertyID(propertyIDClickedOn);
						Living living = fController.getLivingFacByPropertyID(propertyIDClickedOn);
						Outdoor outdoor = fController.getOutdoorFacByPropertyID(propertyIDClickedOn);
						Utility utility = fController.getUtilityFacByPropertyID(propertyIDClickedOn);
						
						ChargeBandController cbController = new ChargeBandController();
						List<ChargeBand> chargeBand = cbController.getChargeBandsByPropertyID(propertyIDClickedOn);
						
						AddressController aController = new AddressController();
						Address address = aController.getAddressByPropertyID(propertyIDClickedOn);
						PropertyController pController = new PropertyController(); 

						boolean breakfast = pController.offersBreakfast(propertyIDClickedOn);

						String query = "SELECT userID FROM team023.Property WHERE propertyID =" + propertyIDClickedOn + ";";
						DatabaseCommunication db = new DatabaseCommunication();
						String hostID = "";
						try {
							ResultSet results = db.queryExecute(query);
							while (results.next()) {
								hostID = results.getString(1);
							}

						} catch (Exception e1) {
							e1.printStackTrace();
						} finally {
							db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
						}
						
						PersonController personController = new PersonController(); 

						Host hostToUse = personController.getHostByPropertyID(propertyIDClickedOn);
						Property property = new Property(chargeBand, address, pController.getPropertyNameByPropertyID(Integer.parseInt(propertyIDClickedOn)), pController.getPropertyDescriptionByPropertyID(Integer.parseInt(propertyIDClickedOn)), breakfast, bathing, kitchen, living, outdoor, sleeping, utility);

						ViewPropertyPage propertyPageFrame = new ViewPropertyPage(property, personToUse, hostToUse, Integer.parseInt(propertyIDClickedOn), false);
						propertyPageFrame.getFrame().setVisible(true);
						propertyPageFrame.getFrame().pack();
						propertyPageFrame.getFrame().setLocationRelativeTo(null);
//						frame.dispose();
					} else {
						int tableRow = Integer.valueOf( e.getActionCommand() );
				        String propertyIDClickedOn = propertyIDS.get(tableRow);
				        PropertyController pController = new PropertyController();
				        Pair<Property, Pair<Person, Host>> propertyAndHost =  pController.getPropertyAndHost(propertyIDClickedOn);
				        Property property = propertyAndHost.left;
				        Host hostToUse = propertyAndHost.right.right;
						
						
						ViewPropertyPage propertyPageFrame = new ViewPropertyPage(property, null, hostToUse, Integer.parseInt(propertyIDClickedOn), false);
						propertyPageFrame.getFrame().setVisible(true);
						propertyPageFrame.getFrame().pack();
						propertyPageFrame.getFrame().setLocationRelativeTo(null);
//						JOptionPane.showMessageDialog(null, "You must be logged in to see more details!", "Errors",
//								JOptionPane.WARNING_MESSAGE);
					}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "You must be logged in to see more details!", "Errors",
							JOptionPane.WARNING_MESSAGE);

				}
			}
		};

		ButtonColumn buttonColumnAccept = new ButtonColumn(table_1, moreDetails, 3);

		scrollPane.setViewportView(table_1);

		JLabel lblNewLabel_3 = new JLabel("Location searched: " + this.getPropertyLocation());
		lblNewLabel_3.setBounds(86, 273, 221, 23);
		frame.getContentPane().add(lblNewLabel_3);

		frame.setBounds(100, 100, 1200, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		startDayField = new JTextField();
		startDayField.setColumns(10);
		startDayField.setBounds(538, 154, 45, 30);
		frame.getContentPane().add(startDayField);

		startMonthField = new JTextField();
		startMonthField.setColumns(10);
		startMonthField.setBounds(611, 154, 45, 30);
		frame.getContentPane().add(startMonthField);

		startYearField = new JTextField();
		startYearField.setColumns(10);
		startYearField.setBounds(666, 154, 62, 30);
		frame.getContentPane().add(startYearField);

		endDayField = new JTextField();
		endDayField.setColumns(10);
		endDayField.setBounds(889, 154, 45, 30);
		frame.getContentPane().add(endDayField);

		endMonthField = new JTextField();
		endMonthField.setColumns(10);
		endMonthField.setBounds(944, 154, 45, 30);
		frame.getContentPane().add(endMonthField);

		endYearField = new JTextField();
		endYearField.setColumns(10);
		endYearField.setBounds(1002, 154, 62, 30);
		frame.getContentPane().add(endYearField);

		JLabel lblNewLabel_10 = new JLabel("DD");
		lblNewLabel_10.setBounds(555, 135, 46, 14);
		frame.getContentPane().add(lblNewLabel_10);

		JLabel lblNewLabel_4 = new JLabel("MM");
		lblNewLabel_4.setBounds(610, 135, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("YYYY");
		lblNewLabel_5.setBounds(670, 135, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("DD");
		lblNewLabel_6.setBounds(888, 135, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("MM");
		lblNewLabel_7.setBounds(944, 135, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("YYYY");
		lblNewLabel_8.setBounds(1002, 135, 46, 14);
		frame.getContentPane().add(lblNewLabel_8);
		frame.setBounds(100, 100, 1200, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
