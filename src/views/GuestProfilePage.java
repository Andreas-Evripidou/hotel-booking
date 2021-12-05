package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import controllers.BookingsController;
import controllers.PropertyController;
import controllers.ReviewsController;
import model.Host;
import model.Person;
import model.Property;
import model.Reservation;


public class GuestProfilePage extends JPanel {
	
	public Person personLoggedIn;;
	private JPanel panel;

	public GuestProfilePage(JFrame frame, Person p) {
		this.setPerson(p);
		initialize(frame);
		BookingsController bController = new BookingsController();
		Pair<ArrayList<Reservation>, ArrayList<ArrayList<String>>> allResrvations = bController.getAllReservations(p.getEmail());
		showAllReservations(frame ,allResrvations, p);
	}

	
	public void setPerson(Person person) {
		this.personLoggedIn = person;
		
		
	}
	public JPanel getPanel() {
		return this;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frame) {
		
		
		panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAutoscrolls(true);
        
        this.add(panel,BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(25, 105, 800, 600);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(870, 900));
        contentPane.add(scrollPane);

        this.add(contentPane, BorderLayout.CENTER);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(25, 0, 804, 93);
        contentPane.add(panel_1);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblPReview = new JLabel("My Reservations");
        lblPReview.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
        panel_1.add(lblPReview);
        
        JLabel lblIfYouCannot = new JLabel("If you cannot find your request below it means it was rejected by the host!");
        lblIfYouCannot.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        panel_1.add(lblIfYouCannot);
        
        JButton btnLogOut = new JButton("LOGOUT");
        btnLogOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoginPage newFrame = new LoginPage(frame);
        		frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();
				frame.getContentPane().add(newFrame);
				frame.setLocationRelativeTo(null);
				frame.revalidate();
				frame.repaint();
        	}
        });
        btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnLogOut.setBackground(Color.LIGHT_GRAY);
        btnLogOut.setBounds(690, 716, 180, 57);
        contentPane.add(btnLogOut);
        
        JButton btnSearch = new JButton("SEARCH PROPERTIES");
        btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage newFrame = new HomePage(frame,personLoggedIn);
				frame.getContentPane().removeAll();
				frame.getContentPane().invalidate();
				frame.getContentPane().add(newFrame);
				frame.setLocationRelativeTo(null);
				frame.revalidate();
				frame.repaint();
			}
        });
        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSearch.setBackground(Color.LIGHT_GRAY);
        btnSearch.setBounds(0, 716, 180, 57);
        contentPane.add(btnSearch);

        frame.revalidate();
        frame.repaint();
      

        
	}
	

	private void showAllReservations(JFrame frame,Pair<ArrayList<Reservation>, ArrayList<ArrayList<String>>> allResrvations, Person p) {
		
		int numOfReservations = allResrvations.left.size();
		ArrayList<Reservation> reservations = allResrvations.left;
		 ArrayList<ArrayList<String>> reservationInfo = allResrvations.right;
		
		for(int i = 0; i < numOfReservations; i++) {
			Reservation reservation = reservations.get(i);
			ArrayList<String> rInfo = reservationInfo.get(i);
			
			ReviewsController rController = new ReviewsController(); 
			Boolean allowedToWriteReview = rController.allowedToWriteReview(reservation.getUserID(), reservation.getPropertyID(), reservation.getEndDate().toString());
			if (!rController.alreadyExcistsReview(reservation.getUserID(), reservation.getPropertyID()) || !allowedToWriteReview) {
				JPanel allReservationsPanel = new JPanel();
				allReservationsPanel.setLayout(new FlowLayout());
				allReservationsPanel.setBackground(Color.WHITE);
				allReservationsPanel.setPreferredSize(new Dimension(700, 320));

				JPanel singleReservationPanel = new JPanel();
				singleReservationPanel.setLayout(new FlowLayout());
				singleReservationPanel.setBackground(Color.LIGHT_GRAY);
				singleReservationPanel.setPreferredSize(new Dimension(500, 320));
            
				JLabel lblShortName = new JLabel("Short Name: ");
				lblShortName.setForeground(Color.BLACK);
				lblShortName.setPreferredSize(new Dimension(120, 20));
				JTextField textFieldShortName = new JTextField(rInfo.get(0));
				textFieldShortName.setPreferredSize(new Dimension(320, 20));
				textFieldShortName.setEditable(false);

				JLabel lblGeneralLocation = new JLabel("General Location: ");
				lblGeneralLocation.setForeground(Color.BLACK);
				lblGeneralLocation.setPreferredSize(new Dimension(120, 20));
				JTextField textFieldGeneralLocation = new JTextField(rInfo.get(2));
				textFieldGeneralLocation.setPreferredSize(new Dimension(320, 20));
				textFieldGeneralLocation.setEditable(false);
            
				JLabel lblDescription = new JLabel("Description: ");
				lblDescription.setForeground(Color.BLACK);
				lblDescription.setPreferredSize(new Dimension(120, 20));
				JTextArea textAreaDescription = new JTextArea(rInfo.get(1));
				textAreaDescription.setPreferredSize(new Dimension(320, 100));
				textAreaDescription.setLineWrap(true);
				textAreaDescription.setEditable(false);
            
				JLabel lblStartDate = new JLabel("Start Date: ");
				lblStartDate.setForeground(Color.BLACK);
				lblStartDate.setPreferredSize(new Dimension(120, 20));
				JTextField textFieldStartDate = new JTextField(reservation.getStartDate().toString());
				textFieldStartDate.setPreferredSize(new Dimension(320, 20));
				textFieldStartDate.setEditable(false);

				JLabel lblEndDate = new JLabel("End Date: ");
				lblEndDate.setForeground(Color.BLACK);
				lblEndDate.setPreferredSize(new Dimension(120, 20));
				JTextField textFieldEndDate = new JTextField(reservation.getEndDate().toString());
				textFieldEndDate.setPreferredSize(new Dimension(320, 20));
				textFieldEndDate.setEditable(false);
            
				JLabel lblAccepted = new JLabel("Accepted: ");
				lblAccepted.setForeground(Color.BLACK);
				lblAccepted.setPreferredSize(new Dimension(120, 20));
				JTextField textFieldAccepted = new JTextField(reservation.getAccepted().toString());
				textFieldAccepted.setPreferredSize(new Dimension(320, 20));
				textFieldAccepted.setEditable(false);
				
				PropertyController pc = new  PropertyController();
				int propertyID = reservation.getPropertyID();
				Pair<Property, Pair<Person, Host>> pch = pc.getPropertyAndHost(String.valueOf(propertyID));
				Property property = pch.left;
				Person person = pch.right.left;
				Host host = pch.right.right;
				
				JLabel lblHostEmail = new JLabel("Host's Email: ");
				lblHostEmail.setForeground(Color.BLACK);
				lblHostEmail.setPreferredSize(new Dimension(120, 20));
				JTextField textFieldHostEmail = new JTextField();
				textFieldHostEmail.setPreferredSize(new Dimension(320, 20));
				if (reservation.getAccepted()) {
					textFieldHostEmail.setText(person.getEmail());
				} else {
					textFieldHostEmail.setText("Request needs to be accepted to see this field");
				}
				
				textFieldHostEmail.setEditable(false);
				
				JLabel lblHostContact = new JLabel("Host's Number: ");
				lblHostContact.setForeground(Color.BLACK);
				lblHostContact.setPreferredSize(new Dimension(120, 20));
				JTextField textFieldContact = new JTextField();
				textFieldContact.setPreferredSize(new Dimension(320, 20));
				if (reservation.getAccepted()) {
					textFieldContact.setText(person.getPhoneNumber());
				} else {
					textFieldContact.setText("Request needs to be accepted to see this field");
				}
				textFieldContact.setEditable(false);
            
				JButton btnViewProperty = new JButton("More Details");
				btnViewProperty.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ViewPropertyPage newFrame = new ViewPropertyPage(frame, getPanel(), property, p, host, propertyID, reservation.getAccepted());
						frame.getContentPane().removeAll();
						frame.getContentPane().invalidate();
						frame.getContentPane().add(newFrame);
						frame.revalidate();
						frame.repaint();
					}
				});
				btnViewProperty.setBackground(Color.LIGHT_GRAY);
				btnViewProperty.setFont(new Font("Lucida Grande", Font.PLAIN, 14)); 
            
				singleReservationPanel.add(lblShortName);
				singleReservationPanel.add(textFieldShortName);
				singleReservationPanel.add(lblGeneralLocation);
				singleReservationPanel.add(textFieldGeneralLocation);
				singleReservationPanel.add(lblDescription);
				singleReservationPanel.add(textAreaDescription);
				singleReservationPanel.add(lblStartDate);
				singleReservationPanel.add(textFieldStartDate);
				singleReservationPanel.add(lblEndDate);
				singleReservationPanel.add(textFieldEndDate);
				singleReservationPanel.add(lblAccepted);
				singleReservationPanel.add(textFieldAccepted);
				singleReservationPanel.add(lblHostEmail);
				singleReservationPanel.add(textFieldHostEmail);
				singleReservationPanel.add(lblHostContact);
				singleReservationPanel.add(textFieldContact);
				singleReservationPanel.add(btnViewProperty);
				
				int index = i;
            
				if (allowedToWriteReview) {
					JButton btnAddReview = new JButton("Add Review");
					btnAddReview.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							GuestWriteReviewPage newFrame = new GuestWriteReviewPage(reservations.get(0).getUserID(), reservations.get(index).getPropertyID());
							newFrame.getFrame().setVisible(true);
							newFrame.getFrame().pack();
							newFrame.getFrame().setLocationRelativeTo(null);   				
						}
					});
					btnAddReview.setBackground(Color.LIGHT_GRAY);
					btnAddReview.setFont(new Font("Lucida Grande", Font.PLAIN, 14)); 
                
					singleReservationPanel.add(btnAddReview);
				}
                       
				allReservationsPanel.add(singleReservationPanel);
				panel.add(allReservationsPanel); 
			}
		}
	}
}
