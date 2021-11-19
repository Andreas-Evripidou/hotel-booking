package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.TableModel;

import controllers.HostProfileController;
import controllers.PersonController;
import controllers.PropertyController;
import controllers.ReservationController;
import main.Person;
import main.Property;
import main.Reservation;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTable;

public class HostProfilePage {

	private JFrame frmHostProfile;
	private JTable reservationRequestTable;
	private JTable acceptRequestTable;


	/**
	 * Create the application.
	 */
	public HostProfilePage(Person p) {
		initialize(p);
	}
	
	public JFrame getFrame() {
		return frmHostProfile;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Person p) {
		frmHostProfile = new JFrame();
		frmHostProfile.setTitle("Host Profile ");
		frmHostProfile.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmHostProfile.setResizable(false);
		frmHostProfile.setMaximumSize(new Dimension(1200, 850));
		frmHostProfile.setMinimumSize(new Dimension(1200, 850));
		frmHostProfile.setFont(new Font("Calibri", Font.PLAIN, 14));
		frmHostProfile.setBounds(100, 100, 1200, 850);
		frmHostProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHostProfile.getContentPane().setLayout(new BorderLayout(1200, 800));
		
		PropertyController pc = new PropertyController();
		ReservationController rc = new ReservationController();
		PersonController personContr = new PersonController();
		
		JPanel hostProfilePanel = new JPanel();
		hostProfilePanel.setBackground(Color.LIGHT_GRAY);
		frmHostProfile.getContentPane().add(hostProfilePanel, BorderLayout.CENTER);
		
		JPanel reservationRequestPanel = new JPanel();
		
		JPanel acceptedReservationsPanel = new JPanel();
		
		JLabel lblReservationRequest = new JLabel("Reservation Requests");
		lblReservationRequest.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblAcceptedReservations = new JLabel("Accepted Reservations");
		lblAcceptedReservations.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnAddProperty = new JButton("Add Property");
		btnAddProperty.setBackground(Color.LIGHT_GRAY);
		btnAddProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPropertyPage window = new AddPropertyPage(p);
				window.setVisible(true);
				window.pack();
				window.setLocationRelativeTo(null);
				frmHostProfile.dispose();
			}
		});
		btnAddProperty.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton btnMyProperties = new JButton("My Properties");
		btnMyProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Property> properties = pc.getPropertiesByHostID(p.getEmail());
				PropertiesPage window = new PropertiesPage(properties, frmHostProfile);
				window.getFrame().setVisible(true);
				window.getFrame().setLocationRelativeTo(null);
				frmHostProfile.setVisible(false);
				
				
			}
		});
		btnMyProperties.setBackground(Color.LIGHT_GRAY);
		btnMyProperties.setFont(new Font("Tahoma", Font.PLAIN, 22));
		acceptedReservationsPanel.setLayout(new BoxLayout(acceptedReservationsPanel, BoxLayout.X_AXIS));
		
		JScrollPane acceptedReservationsScrollPane = new JScrollPane();
		acceptedReservationsPanel.add(acceptedReservationsScrollPane);
		
		
		ArrayList<Reservation> requestedReservations = rc.getNotAcceptedReservationsByHostID(p.getEmail());
		ArrayList<Reservation> acceptedReservations = rc.getAcceptedReservationsByHostID(p.getEmail());
		
		String[] requestColumnNames = {"Proeprty Name", "Guest Name", "Start Date", "End Date", "Accept", "Reject"};
		Object[][] requestColumnData = new Object[requestedReservations.size()][6];
		
		String[] reservationColumnNames = {"Proeprty Name","Guest Name","Start Date","End Date","Contact Details"};
		Object[][] acceptedColumnData = new Object[acceptedReservations.size()][6];

		
			
		for (int i=0; i< requestedReservations.size() ; i++) {
			requestColumnData[i][0] = pc.getPropertyNameByPropertyID(requestedReservations.get(i).getPropertyID());
			requestColumnData[i][1] = personContr.getNameByUserID(requestedReservations.get(i).getUserID());
			requestColumnData[i][2] = requestedReservations.get(i).getStartDate();
			requestColumnData[i][3] = requestedReservations.get(i).getEndDate();
			requestColumnData[i][4] = "Button";
			requestColumnData[i][5] = "Button";	
		}
		
		for (int i=0; i< acceptedReservations.size() ; i++) {
			acceptedColumnData[i][0] = pc.getPropertyNameByPropertyID(acceptedReservations.get(i).getPropertyID());
			acceptedColumnData[i][1] = personContr.getNameByUserID(acceptedReservations.get(i).getUserID());
			acceptedColumnData[i][2] = acceptedReservations.get(i).getStartDate();
			acceptedColumnData[i][3] = acceptedReservations.get(i).getEndDate();
			acceptedColumnData[i][4] = personContr.getContactNumberByUserID(acceptedReservations.get(i).getUserID());
		}
	
		
		acceptRequestTable = new JTable(acceptedColumnData,reservationColumnNames);
		acceptedReservationsScrollPane.setViewportView(acceptRequestTable);
		reservationRequestPanel.setLayout(new BoxLayout(reservationRequestPanel, BoxLayout.X_AXIS));
		
		JScrollPane reservationRequestsScrollPanel = new JScrollPane();
		reservationRequestPanel.add(reservationRequestsScrollPanel);
		
		
		
		
		reservationRequestTable = new JTable(requestColumnData,requestColumnNames);
		reservationRequestTable.setEnabled(true);
		
		reservationRequestsScrollPanel.setViewportView(reservationRequestTable);
		
		JButton btnLogOut = new JButton("LOGOUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage newFrame = new LoginPage();
				newFrame.getFrame().setVisible(true);
				newFrame.getFrame().pack();
				newFrame.getFrame().setLocationRelativeTo(null);
				frmHostProfile.dispose();
				
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnLogOut.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_hostProfilePanel = new GroupLayout(hostProfilePanel);
		gl_hostProfilePanel.setHorizontalGroup(
			gl_hostProfilePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hostProfilePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_hostProfilePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(reservationRequestPanel, GroupLayout.PREFERRED_SIZE, 1164, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_hostProfilePanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_hostProfilePanel.createSequentialGroup()
								.addComponent(btnAddProperty, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
								.addGap(6)
								.addComponent(btnMyProperties, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
								.addGap(663)
								.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
							.addComponent(acceptedReservationsPanel, GroupLayout.PREFERRED_SIZE, 1164, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_hostProfilePanel.createSequentialGroup()
								.addComponent(lblAcceptedReservations, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(988))
							.addGroup(gl_hostProfilePanel.createSequentialGroup()
								.addComponent(lblReservationRequest, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(996))))
					.addGap(20))
		);
		gl_hostProfilePanel.setVerticalGroup(
			gl_hostProfilePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_hostProfilePanel.createSequentialGroup()
					.addContainerGap(58, Short.MAX_VALUE)
					.addComponent(lblReservationRequest)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reservationRequestPanel, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblAcceptedReservations)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(acceptedReservationsPanel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_hostProfilePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddProperty, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMyProperties, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addGap(34))
		);
		hostProfilePanel.setLayout(gl_hostProfilePanel);
		
		
	}
}
