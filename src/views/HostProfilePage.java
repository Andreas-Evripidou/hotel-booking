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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controllers.*;
import model.Address;
import model.Person;
import model.Property;
import model.Reservation;

import javax.swing.JScrollPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTable;

public class HostProfilePage extends JPanel{

	private JTable reservationRequestTable;
	private JTable acceptRequestTable;
	private JPanel acceptedReservationsPanel = new JPanel();
	private JPanel reservationRequestPanel = new JPanel();
	private PropertyController pc = new PropertyController();
	private ReservationController rc = new ReservationController();
	private PersonController personContr = new PersonController();
	private BookingsController bc = new BookingsController();
	private AddressController ac= new AddressController();
	
	/**
	 * Create the application.
	 */
	public HostProfilePage(JFrame frame,Person p) {
		initialize(frame, p);
		showRequestedReservations(frame,p);
		showAcceptedReservations(frame,p);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frame, Person p) {
		setLayout(new BorderLayout(0, 0));
				
		JPanel hostProfilePanel = new JPanel();
		hostProfilePanel.setBackground(Color.LIGHT_GRAY);
		this.add(hostProfilePanel);
		
		JLabel lblReservationRequest = new JLabel("Reservation Requests");
		lblReservationRequest.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblAcceptedReservations = new JLabel("Accepted Reservations");
		lblAcceptedReservations.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnAddProperty = new JButton("Add Property");
		btnAddProperty.setBackground(Color.LIGHT_GRAY);
		btnAddProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPropertyPage newFrame = new AddPropertyPage(frame, p);
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();
				frame.getContentPane().add(newFrame);
				frame.revalidate();
				frame.repaint();
			}
		});
		btnAddProperty.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton btnMyProperties = new JButton("My Properties");
		btnMyProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyPropertiesPage newFrame = new MyPropertiesPage(frame, hostProfilePanel,p.getEmail());
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();
				frame.getContentPane().add(newFrame);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		btnMyProperties.setBackground(Color.LIGHT_GRAY);
		btnMyProperties.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton btnLogOut = new JButton("LOGOUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage newFrame = new LoginPage(frame);
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();
				frame.getContentPane().add(newFrame);
				frame.revalidate();
				frame.repaint();
				
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnLogOut.setBackground(Color.LIGHT_GRAY);
		
		reservationRequestPanel.setLayout(new BoxLayout(reservationRequestPanel, BoxLayout.X_AXIS));
		acceptedReservationsPanel.setLayout(new BoxLayout(acceptedReservationsPanel, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Host Console");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		
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
				.addGroup(gl_hostProfilePanel.createSequentialGroup()
					.addGap(511)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(511, Short.MAX_VALUE))
		);
		gl_hostProfilePanel.setVerticalGroup(
			gl_hostProfilePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_hostProfilePanel.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
					.addGap(11)
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
	
	private void showRequestedReservations(JFrame frame ,Person p) {
		ArrayList<Reservation> requestedReservations = rc.getNotAcceptedReservationsByHostID(p.getEmail());
		
		String[] requestColumnNames = {"Proeprty Name", "Guest Username", "Start Date", "End Date", "Accept", "Reject"};
		Object[][] requestColumnData = new Object[0][0];
		
		if(requestedReservations != null){
			requestColumnData = new Object[requestedReservations.size()][6];
			
			for (int i=0; i< requestedReservations.size() ; i++) {
				Person guest = personContr.getPersonByUserID(requestedReservations.get(i).getUserID());
				requestColumnData[i][0] = pc.getPropertyNameByPropertyID(requestedReservations.get(i).getPropertyID());
				requestColumnData[i][1] = guest.getUsername();
				requestColumnData[i][2] = requestedReservations.get(i).getStartDate();
				requestColumnData[i][3] = requestedReservations.get(i).getEndDate();
				requestColumnData[i][4] = "Accept";
				requestColumnData[i][5] = "Reject";	
			}
		} 
		
		DefaultTableModel model = new DefaultTableModel(requestColumnData,requestColumnNames);
		reservationRequestTable = new JTable(model);
		
		Action accept = new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        int acceptPropertyID = requestedReservations.get(modelRow).getPropertyID();
		        String acceptUserID = requestedReservations.get(modelRow).getUserID();
		        String acceptStartDate = requestedReservations.get(modelRow).getStartDate().toString();
		        String acceptEndDate = requestedReservations.get(modelRow).getEndDate().toString();
		        bc.acceptBooking(acceptUserID, acceptPropertyID, acceptStartDate, acceptEndDate); 
		        
		        showAcceptedReservations(frame ,p);
		        showRequestedReservations(frame,p);
		        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
		        
		    }
		};
		
		Action reject = new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        int deletePropertyID = requestedReservations.get(modelRow).getPropertyID();
		        String deleteUserID = requestedReservations.get(modelRow).getUserID();
		        String deleteStartDate = requestedReservations.get(modelRow).getStartDate().toString();
		        String deleteEndDate = requestedReservations.get(modelRow).getEndDate().toString();
		        bc.rejectBooking(deleteUserID, deletePropertyID, deleteStartDate, deleteEndDate);
		        showRequestedReservations(frame,p);
		        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
		       
		    }
		};
		
		ButtonColumn buttonColumnAccept = new ButtonColumn(reservationRequestTable, accept, 4);
		ButtonColumn buttonColumnReject = new ButtonColumn(reservationRequestTable, reject, 5);
		
		
		
		JScrollPane reservationRequestsScrollPanel = new JScrollPane();
		reservationRequestsScrollPanel.setViewportView(reservationRequestTable);
		
		reservationRequestPanel.removeAll();
		reservationRequestPanel.add(reservationRequestsScrollPanel);
		
		frame.revalidate();
        frame.repaint();
	}
	
	
	private void showAcceptedReservations(JFrame frame, Person p) {
		ArrayList<Reservation> acceptedReservations = rc.getAcceptedReservationsByHostID(p.getEmail());
		
		String[] reservationColumnNames = {"Proeprty Name","Guest Name", "Email", "Contact Details", "Location", "Street", "Postcode", "Start Date","End Date"};
		Object[][] acceptedColumnData = new Object[0][0];
		
		if(acceptedReservations != null){
			
			acceptedColumnData = new Object[acceptedReservations.size()][10];
			
			for (int i=0; i< acceptedReservations.size() ; i++) {
				
				Person guest = personContr.getPersonByUserID(acceptedReservations.get(i).getUserID());
				
				acceptedColumnData[i][0] = pc.getPropertyNameByPropertyID(acceptedReservations.get(i).getPropertyID());
				acceptedColumnData[i][1] = guest.getTitle() + " " +guest.getForename()+ " " + guest.getSurname(); //add Surname
				acceptedColumnData[i][2] = guest.getEmail();//address.getHouse();
				acceptedColumnData[i][3] = guest.getPhoneNumber();
				
				Address address  = ac.getAddressByUserID(guest.getEmail());
				
				acceptedColumnData[i][4] =address.getPlaceName(); //address.getPostCode();
				acceptedColumnData[i][5] = address.getStreetName(); //address.getStreetName();
				acceptedColumnData[i][6] = address.getPostCode(); //address.getStreetName();
				acceptedColumnData[i][7] = acceptedReservations.get(i).getStartDate();
				acceptedColumnData[i][8] = acceptedReservations.get(i).getEndDate();
				
			}
		}		
		
		
		acceptRequestTable = new JTable(acceptedColumnData,reservationColumnNames);
		
		
		JScrollPane acceptedReservationsScrollPane = new JScrollPane();
		
		acceptedReservationsScrollPane.setViewportView(acceptRequestTable);
		
		acceptedReservationsPanel.removeAll();
		acceptedReservationsPanel.add(acceptedReservationsScrollPane);
		
		frame.revalidate();
        frame.repaint();
	}
}
