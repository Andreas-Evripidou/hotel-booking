package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.util.ArrayList;
import java.util.Arrays;

import controllers.DatabaseCommunication;
import controllers.PersonController;
import model.Person;
import model.Property;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class HomePage extends JPanel {

	/**
	 * @wbp.nonvisual location=91,-31
	 */
	private final JTable table = new JTable();
	private JTextField startDayField;
	private JTextField startMonthField;
	private JTextField startYearField;
	private JTextField endDayField;
	private JTextField endMonthField;
	private JTextField endYearField;
	public Person personToUse;


	/**
	 * Create the application.
	 */
	public HomePage(JFrame frame, Person person) {
		setBackground(Color.LIGHT_GRAY);
		this.setPerson(person);
		initialize(frame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void setPerson(Person person) {
		this.personToUse = person;
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}
	public Person getPerson() {
		return(this.personToUse);
	}
	
	private void initialize(JFrame frame) {

		JLabel lblNewLabel = new JLabel("Location");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 29));
		lblNewLabel.setBounds(109, 204, 151, 65);
		this.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Check in");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(435, 217, 113, 38);
		this.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Check out");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 29));
		lblNewLabel_1_1.setBounds(738, 217, 141, 38);
		this.add(lblNewLabel_1_1);

		startDayField = new JTextField();
		startDayField.setColumns(10);
		startDayField.setBounds(556, 225, 45, 30);
		this.add(startDayField);

		JLabel lblNewLabel_2 = new JLabel("Find a Property");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(462, 128, 241, 86);
		this.add(lblNewLabel_2);

		if(personToUse == null) {
			JButton btnNewButton = new JButton("LOGIN");
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(personToUse == null) {
						LoginPage newPanel = new LoginPage(frame);
						frame.getContentPane().removeAll();
						frame.getContentPane().invalidate();
						frame.getContentPane().add(newPanel);
						frame.revalidate();
						frame.repaint();
					}
				}
				});
			
			btnNewButton.setBounds(908, 21, 89, 23);
			this.add(btnNewButton);
		}
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setBackground(Color.LIGHT_GRAY);
		
		if (personToUse != null)
			btnRegister.setText("Back");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(personToUse == null) {
					RegistrationPage newFrame = new RegistrationPage(frame);
					frame.getContentPane().removeAll();
					frame.getContentPane().invalidate();
					frame.getContentPane().add(newFrame);
					frame.revalidate();
					frame.repaint();
				}else {
					GuestProfilePage newFrame = new GuestProfilePage(frame, personToUse);
					frame.getContentPane().removeAll();
					frame.getContentPane().invalidate();
					frame.getContentPane().add(newFrame);
					frame.revalidate();
					frame.repaint();;
				}
			}
			});
		btnRegister.setBounds(1002, 21, 124, 23);
		this.add(btnRegister);

		// database stuff

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
		comboBox.setBounds(231, 224, 179, 30);
		this.add(comboBox);

		JButton btnSearchProperties = new JButton("Search Properties");
		btnSearchProperties.setBackground(Color.LIGHT_GRAY);
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
					System.out.println(personToUse);

					SearchPage newFrame = new SearchPage(frame,locationToUse, startDateToUse, endDateToUse, personToUse);
					frame.getContentPane().removeAll();
					frame.getContentPane().invalidate();
					frame.getContentPane().add(newFrame);
					frame.revalidate();
					frame.repaint();
				} else {
					JOptionPane.showMessageDialog(frame,
							"Ensure a date in the future formatted DD/MM/YYYY is entered in both sections");
					validDates = true;
				}

			}
		});

		this.add(btnSearchProperties);
		btnSearchProperties.setBounds(462, 269, 241, 75);
		this.add(btnSearchProperties);

		startMonthField = new JTextField();
		startMonthField.setColumns(10);
		startMonthField.setBounds(611, 225, 45, 30);
		this.add(startMonthField);

		startYearField = new JTextField();
		startYearField.setColumns(10);
		startYearField.setBounds(666, 225, 62, 30);
		this.add(startYearField);

		endDayField = new JTextField();
		endDayField.setColumns(10);
		endDayField.setBounds(889, 225, 45, 30);
		this.add(endDayField);

		endMonthField = new JTextField();
		endMonthField.setColumns(10);
		endMonthField.setBounds(944, 225, 45, 30);
		this.add(endMonthField);

		endYearField = new JTextField();
		endYearField.setColumns(10);
		endYearField.setBounds(1002, 225, 62, 30);
		this.add(endYearField);
		JLabel lblNewLabel_3 = new JLabel("DD");
		lblNewLabel_3.setBounds(555, 210, 46, 14);
		this.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("MM");
		lblNewLabel_4.setBounds(610, 210, 46, 14);
		this.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("YYYY");
		lblNewLabel_5.setBounds(670, 210, 46, 14);
		this.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("DD");
		lblNewLabel_6.setBounds(888, 210, 46, 14);
		this.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("MM");
		lblNewLabel_7.setBounds(944, 210, 46, 14);
		this.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("YYYY");
		lblNewLabel_8.setBounds(1002, 210, 46, 14);
		this.add(lblNewLabel_8);

	}
}
