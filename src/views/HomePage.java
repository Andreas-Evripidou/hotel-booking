package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import main.DatabaseCommunication;

import javax.swing.JMenuBar;
import java.awt.Color;
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
public class HomePage {

	private JFrame frame;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Location");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 29));
		lblNewLabel.setBounds(109, 204, 151, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Check in");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(435, 217, 113, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Check out");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 29));
		lblNewLabel_1_1.setBounds(738, 217, 141, 38);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		startDayField = new JTextField();
		startDayField.setColumns(10);
		startDayField.setBounds(556, 225, 45, 30);
		frame.getContentPane().add(startDayField);
		
		JLabel lblNewLabel_2 = new JLabel("Find a Property");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(462, 128, 241, 86);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(908, 21, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REGISTER");
		btnNewButton_1.setBounds(1002, 21, 124, 23);
		frame.getContentPane().add(btnNewButton_1);
		//database stuff
		
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
		for(int counter = 0; counter < locations.size(); counter++) { 		      
	          if (noDuplicatesLocations.contains(locations.get(counter).toString())) {
	        	  noDuplicatesLocations = noDuplicatesLocations;
	          } else {
	        	  noDuplicatesLocations.add(locations.get(counter));
	          }
	      }   				
		JComboBox comboBox = new JComboBox(noDuplicatesLocations.toArray());
		comboBox.setBounds(231, 224, 179, 30);
		frame.getContentPane().add(comboBox);

		
        JButton btnSearchProperties = new JButton("Search Properties");
        btnSearchProperties.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String locationToUse = (String)comboBox.getSelectedItem();
        		String startDay = (String)startDayField.getText();
        		String startMonth = (String)startMonthField.getText();
        		String startYear = (String)startYearField.getText();
        		String startDateToUse = startDay + " " + startMonth + " " +startYear;
        		
        		String endDay = (String)endDayField.getText();
        		String endMonth = (String)endMonthField.getText();
        		String endYear = (String)endYearField.getText();
        		String endDateToUse = endDay + " " + endMonth + " " +endYear;

        		SearchPage newFrame = new SearchPage(locationToUse, startDateToUse, endDateToUse);
				newFrame.getFrame().setVisible(true);
				newFrame.getFrame().pack();
				newFrame.getFrame().setLocationRelativeTo(null);
				frame.dispose();
        	}
        });

        frame.getContentPane().add(btnSearchProperties);
        btnSearchProperties.setBounds(462, 269, 241, 75);
		frame.getContentPane().add(btnSearchProperties);
		
		startMonthField = new JTextField();
		startMonthField.setColumns(10);
		startMonthField.setBounds(611, 225, 45, 30);
		frame.getContentPane().add(startMonthField);
		
		startYearField = new JTextField();
		startYearField.setColumns(10);
		startYearField.setBounds(666, 225, 62, 30);
		frame.getContentPane().add(startYearField);
		
		endDayField = new JTextField();
		endDayField.setColumns(10);
		endDayField.setBounds(889, 225, 45, 30);
		frame.getContentPane().add(endDayField);
		
		endMonthField = new JTextField();
		endMonthField.setColumns(10);
		endMonthField.setBounds(944, 225, 45, 30);
		frame.getContentPane().add(endMonthField);
		
		endYearField = new JTextField();
		endYearField.setColumns(10);
		endYearField.setBounds(1002, 225, 62, 30);
		frame.getContentPane().add(endYearField);
		JLabel lblNewLabel_3 = new JLabel("DD");
		lblNewLabel_3.setBounds(555, 210, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("MM");
		lblNewLabel_4.setBounds(610, 210, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("YYYY");
		lblNewLabel_5.setBounds(670, 210, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("DD");
		lblNewLabel_6.setBounds(888, 210, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("MM");
		lblNewLabel_7.setBounds(944, 210, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("YYYY");
		lblNewLabel_8.setBounds(1002, 210, 46, 14);
		frame.getContentPane().add(lblNewLabel_8);
		frame.setBounds(100, 100, 1200, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}
}
