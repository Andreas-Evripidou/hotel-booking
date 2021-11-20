package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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

import main.BookingsController;
import main.Reservation;
import main.ReviewsController;

public class GuestProfilePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					BookingsController bController = new BookingsController();
					
					GuestProfilePage window = new GuestProfilePage(bController.getAllReservations("amatoli@email.com"));
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getFrame() {
		return frame;
	}
	/**
	 * Create the application.
	 */
	public GuestProfilePage(Pair<ArrayList<Reservation>, ArrayList<ArrayList<String>>> allResrvations) {
		initialize(allResrvations);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Pair<ArrayList<Reservation>, ArrayList<ArrayList<String>>> allResrvations) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1200, 850);
		frame.setMinimumSize(new Dimension(1200, 850));
		frame.setTitle("Guest Profile Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAutoscrolls(true);
        frame.getContentPane().add(panel,BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 79, 1100, 751);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(900, 900));
        contentPane.add(scrollPane);
        

        showAllReservations(panel, allResrvations);

        frame.getContentPane().add(contentPane, BorderLayout.CENTER);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(450, 0, 299, 67);
        contentPane.add(panel_1);
        
        JLabel lblPReview = new JLabel("My Reservations");
        lblPReview.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
        panel_1.add(lblPReview);
        
        JButton btnLogOut = new JButton("LOGOUT");
        btnLogOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoginPage newFrame = new LoginPage();
				newFrame.getFrame().setVisible(true);
				newFrame.getFrame().pack();
				newFrame.getFrame().setLocationRelativeTo(null);
				frame.dispose();
        	}
        });
        btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnLogOut.setBackground(Color.LIGHT_GRAY);
        btnLogOut.setBounds(985, 832, 165, 57);
        contentPane.add(btnLogOut);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
		
		
	}

	private void showAllReservations(JPanel panel, Pair<ArrayList<Reservation>, ArrayList<ArrayList<String>>> allResrvations) {
		
		int numOfReservations = allResrvations.left.size();
		ArrayList<Reservation> reservations = allResrvations.left;
		 ArrayList<ArrayList<String>> reservationInfo = allResrvations.right;
		
		for(int i = 0; i < numOfReservations; i++) {
			
            JPanel allReservationsPanel = new JPanel();
            allReservationsPanel.setLayout(new FlowLayout());
            allReservationsPanel.setBackground(Color.WHITE);
            allReservationsPanel.setPreferredSize(new Dimension(900, 270));

            JPanel singleReservationPanel = new JPanel();
            singleReservationPanel.setLayout(new FlowLayout());
            singleReservationPanel.setBackground(Color.LIGHT_GRAY);
            singleReservationPanel.setPreferredSize(new Dimension(500, 270));
            
            JLabel lblShortName = new JLabel("Short Name: ");
            lblShortName.setForeground(Color.BLACK);
            lblShortName.setPreferredSize(new Dimension(110, 20));
            JTextField textFieldShortName = new JTextField(reservationInfo.get(i).get(0));
            textFieldShortName.setPreferredSize(new Dimension(320, 20));
            textFieldShortName.setEditable(false);

            JLabel lblGeneralLocation = new JLabel("General Location: ");
            lblGeneralLocation.setForeground(Color.BLACK);
            lblGeneralLocation.setPreferredSize(new Dimension(110, 20));
            JTextField textFieldGeneralLocation = new JTextField(reservationInfo.get(i).get(2));
            textFieldGeneralLocation.setPreferredSize(new Dimension(320, 20));
            textFieldGeneralLocation.setEditable(false);
            
            JLabel lblDescription = new JLabel("Description: ");
            lblDescription.setForeground(Color.BLACK);
            lblDescription.setPreferredSize(new Dimension(110, 20));
            JTextArea textAreaDescription = new JTextArea(reservationInfo.get(i).get(1));
            textAreaDescription.setPreferredSize(new Dimension(320, 100));
            textAreaDescription.setLineWrap(true);
            textAreaDescription.setEditable(false);
            
            JLabel lblStartDate = new JLabel("Start Date: ");
            lblStartDate.setForeground(Color.BLACK);
            lblStartDate.setPreferredSize(new Dimension(110, 20));
            JTextField textFieldStartDate = new JTextField(reservations.get(i).getStartDate().toString());
            textFieldStartDate.setPreferredSize(new Dimension(320, 20));
            textFieldStartDate.setEditable(false);

            JLabel lblEndDate = new JLabel("End Date: ");
            lblEndDate.setForeground(Color.BLACK);
            lblEndDate.setPreferredSize(new Dimension(110, 20));
            JTextField textFieldEndDate = new JTextField(reservations.get(i).getEndDate().toString());
            textFieldEndDate.setPreferredSize(new Dimension(320, 20));
            textFieldEndDate.setEditable(false);
            
            JLabel lblAccepted = new JLabel("Accepted: ");
            lblAccepted.setForeground(Color.BLACK);
            lblAccepted.setPreferredSize(new Dimension(110, 20));
            JTextField textFieldAccepted = new JTextField(reservations.get(i).getAccepted().toString());
            textFieldAccepted.setPreferredSize(new Dimension(320, 20));
            textFieldAccepted.setEditable(false);
            
            JButton btnViewProperty = new JButton("More Details");
            btnViewProperty.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				//Do action
    				//make it view the property profile page
    				
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
            singleReservationPanel.add(btnViewProperty);

            
            
            ReviewsController rController = new ReviewsController();
            Boolean allowedToWriteReview = rController.allowedToWriteReview(reservations.get(i).getUserID(), Integer.parseInt(reservations.get(i).getPropertyID()), reservations.get(i).getEndDate().toString());
            
            if (allowedToWriteReview) {
            	JButton btnAddReview = new JButton("Add Review");
                btnAddReview.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				GuestWriteReviewPage newFrame = new GuestWriteReviewPage(reservations.get(0).getUserID(), Integer.parseInt(reservations.get(0).getPropertyID()));
        				newFrame.getFrame().setVisible(true);
        				newFrame.getFrame().pack();
        				newFrame.getFrame().setLocationRelativeTo(null);
        				frame.dispose();
        				//Do action
        				//redirect to add review page
        				
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
