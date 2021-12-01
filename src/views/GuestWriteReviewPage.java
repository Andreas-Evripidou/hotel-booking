package views;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controllers.PersonController;
import main.BookingsController;
import main.Person;
import main.Review;
import main.ReviewsController;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import main.Person;
import controllers.PersonController;
public class GuestWriteReviewPage {

	private JFrame frame;
	private JTextField textFieldCleanliness;
	private JTextField textFieldCommunication;
	private JTextField textFieldCheckIn;
	private JTextField textFieldAccuracy;
	private JTextField textFieldLocation;
	private JTextField textFieldValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestWriteReviewPage window = new GuestWriteReviewPage("amatoli@email.com", 1);
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
	public GuestWriteReviewPage(String userID, int propertyID) {
		initialize(userID,propertyID);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String userID, int propertyID) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1200, 850);
		frame.setMinimumSize(new Dimension(1200, 850));
		frame.setTitle("Write Review");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblReviewTitle = new JLabel("Tell us about your experience");
		lblReviewTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblReviewTitle.setBounds(363, 6, 513, 88);
		panel.add(lblReviewTitle);
		
		JLabel lblCleanliness = new JLabel("Cleanliness:");
		lblCleanliness.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblCleanliness.setBounds(363, 168, 118, 30);
		panel.add(lblCleanliness);
		
		textFieldCleanliness = new JTextField();
		textFieldCleanliness.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		textFieldCleanliness.setBounds(488, 170, 23, 26);
		panel.add(textFieldCleanliness);
		textFieldCleanliness.setColumns(1);
		
		JLabel lblInstructions = new JLabel("Please rate each category with a number between 1 and 5.");
		lblInstructions.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblInstructions.setBounds(340, 86, 561, 53);
		panel.add(lblInstructions);
		
		JLabel lblCommunication = new JLabel("Communication:");
		lblCommunication.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblCommunication.setBounds(665, 168, 158, 30);
		panel.add(lblCommunication);
		
		textFieldCommunication = new JTextField();
		textFieldCommunication.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		textFieldCommunication.setColumns(1);
		textFieldCommunication.setBounds(824, 170, 23, 26);
		panel.add(textFieldCommunication);
		
		JLabel lblCheckIn = new JLabel("Check In:");
		lblCheckIn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblCheckIn.setBounds(363, 224, 94, 30);
		panel.add(lblCheckIn);
		
		textFieldCheckIn = new JTextField();
		textFieldCheckIn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		textFieldCheckIn.setColumns(1);
		textFieldCheckIn.setBounds(488, 226, 23, 26);
		panel.add(textFieldCheckIn);
		
		JLabel lblAccuracy = new JLabel("Accuracy:");
		lblAccuracy.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblAccuracy.setBounds(665, 224, 93, 30);
		panel.add(lblAccuracy);
		
		textFieldAccuracy = new JTextField();
		textFieldAccuracy.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		textFieldAccuracy.setColumns(1);
		textFieldAccuracy.setBounds(824, 226, 23, 26);
		panel.add(textFieldAccuracy);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblLocation.setBounds(363, 280, 87, 30);
		panel.add(lblLocation);
		
		textFieldLocation = new JTextField();
		textFieldLocation.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		textFieldLocation.setColumns(1);
		textFieldLocation.setBounds(488, 282, 23, 26);
		panel.add(textFieldLocation);
		
		JLabel lblValue = new JLabel("Value:");
		lblValue.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblValue.setBounds(665, 280, 59, 30);
		panel.add(lblValue);
		
		textFieldValue = new JTextField();
		textFieldValue.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		textFieldValue.setColumns(1);
		textFieldValue.setBounds(824, 282, 23, 26);
		panel.add(textFieldValue);
		
		JLabel lblComments = new JLabel("Comments:");
		lblComments.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblComments.setBounds(545, 419, 118, 30);
		panel.add(lblComments);
		
		JTextArea textAreaComments = new JTextArea();
		textAreaComments.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		textAreaComments.setBounds(363, 481, 472, 174);
		textAreaComments.setLineWrap(true);
		panel.add(textAreaComments);
		
		PersonController personController = new PersonController(); 
		Person guest = personController.getPersonByUserID(userID);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					int cleanliness = Integer.parseInt(textFieldCleanliness.getText());
				    int communication = Integer.parseInt(textFieldCommunication.getText());
				    int checkIn = Integer.parseInt(textFieldCheckIn.getText());
				    int accuracy = Integer.parseInt(textFieldAccuracy.getText());
				    int location = Integer.parseInt(textFieldLocation.getText());
				    int value = Integer.parseInt(textFieldValue.getText());
				    String comments = textAreaComments.getText();
				    if (cleanliness < 1 || communication < 1 || checkIn < 1 || accuracy < 1 || location < 1 || value < 1 || cleanliness > 5 || communication > 5 || checkIn > 5 || accuracy > 5 || location > 5 || value > 5) {
				    	JOptionPane.showMessageDialog(null, "The scores must be between 1 and 5!", "Errors!", JOptionPane.WARNING_MESSAGE);
				    } else if (comments.length() < 1) {
					    JOptionPane.showMessageDialog(null, "Please add some comments!", "Errors!", JOptionPane.WARNING_MESSAGE);
					} else if (comments.length() > 200) {
					    JOptionPane.showMessageDialog(null, "The comments cannot exceed 200 characters!", "Errors!", JOptionPane.WARNING_MESSAGE);
					} else {
					    Review review = new Review(comments, cleanliness, communication, checkIn, accuracy, location, value);
					    ReviewsController rc = new ReviewsController();
					    if (!rc.alreadyExcistsReview(userID, propertyID)) {
					    	rc.writeReview(userID, propertyID, review);
					    	rc.updateSuperHostStatus(propertyID);
					    	

					    	BookingsController bController = new BookingsController();
							Person p = new Person();
							GuestProfilePage newFrame = new GuestProfilePage(bController.getAllReservations(userID), p);

							newFrame.getFrame().setVisible(true);
							newFrame.getFrame().pack();
							newFrame.getFrame().setLocationRelativeTo(null);
							frame.dispose();
					    } else {
					    	JOptionPane.showMessageDialog(null, "You cannot add a review for the same property more than once!", "Errors!", JOptionPane.WARNING_MESSAGE);
					    }
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "The scores must be a number between 1 and 5!", "Errors!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnSubmit.setBounds(665, 710, 117, 29);
		panel.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				BookingsController bController = new BookingsController();
				Person p = new Person();

				GuestProfilePage newFrame = new GuestProfilePage(guest);

				newFrame.getFrame().setVisible(true);
				newFrame.getFrame().pack();
				newFrame.getFrame().setLocationRelativeTo(null);
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnCancel.setBounds(446, 710, 117, 29);
		panel.add(btnCancel);
	}
}
