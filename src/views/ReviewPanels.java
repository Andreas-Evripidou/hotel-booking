package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.JScrollPane;

import controllers.ReviewsController;
import model.Review;

import javax.swing.BoxLayout;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ReviewPanels {

	private JFrame frame;
	private JPanel panel;
	private JTextField textFieldCleanliness;
	private JTextField textFieldCommunication;
	private JTextField textFieldCheckIn;
	private JTextField textFieldAccuracy;
	private JTextField textFieldLocation;
	private JTextField textFieldValue;
	private JTextField textFieldOverall;
	private ReviewsController rController = new ReviewsController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					ReviewsController rc = new ReviewsController();
					ReviewPanels window = new ReviewPanels(1);
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
	public ReviewPanels(int propertyID) {
		initialize(propertyID);
		ArrayList<Review> allReviews = rController.getAllReviewsOfProperty(propertyID);
		showAllReviews(panel, allReviews);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int propertyID) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1200, 850);
		frame.setMinimumSize(new Dimension(1200, 850));
		frame.setTitle("Property Reviews");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	        panel = new JPanel();
	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	        panel.setAutoscrolls(true);
	        frame.getContentPane().add(panel,BorderLayout.NORTH);

	        JScrollPane scrollPane = new JScrollPane(panel);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setBounds(50, 79, 1100, 548);
	        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

	        JPanel contentPane = new JPanel(null);
	        contentPane.setPreferredSize(new Dimension(900, 900));
	        contentPane.add(scrollPane);

	        frame.getContentPane().add(contentPane, BorderLayout.CENTER);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBounds(450, 0, 299, 67);
	        contentPane.add(panel_1);
	        
	        JLabel lblPReview = new JLabel("Property Reviews");
	        lblPReview.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	        panel_1.add(lblPReview);
	        
	        JButton btnBack = new JButton("Go Back");
	        btnBack.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		frame.dispose();
	        	}
	        });
	        btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        btnBack.setBounds(1033, 842, 117, 29);
	        contentPane.add(btnBack);
	        
	        JLabel lblAvgCleanliness = new JLabel("Cleanliness:");
	        lblAvgCleanliness.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        lblAvgCleanliness.setBounds(267, 680, 117, 29);
	        contentPane.add(lblAvgCleanliness);
	        
	        JLabel lblAvgScores = new JLabel("Average Scores");
	        lblAvgScores.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        lblAvgScores.setBounds(527, 639, 145, 29);
	        contentPane.add(lblAvgScores);
	        
	        JLabel lblAvgCommunication = new JLabel("Communication:");
	        lblAvgCommunication.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        lblAvgCommunication.setBounds(226, 736, 158, 29);
	        contentPane.add(lblAvgCommunication);
	        
	        JLabel lblAvgCheckin = new JLabel("Check In:");
	        lblAvgCheckin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        lblAvgCheckin.setBounds(295, 788, 89, 29);
	        contentPane.add(lblAvgCheckin);
	        
	        JLabel lblAvgAccuracy = new JLabel("Accuracy:");
	        lblAvgAccuracy.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        lblAvgAccuracy.setBounds(679, 679, 91, 29);
	        contentPane.add(lblAvgAccuracy);
	        
	        JLabel lblAvgLocation = new JLabel("Location:");
	        lblAvgLocation.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        lblAvgLocation.setBounds(681, 735, 89, 29);
	        contentPane.add(lblAvgLocation);
	        
	        JLabel lblAvgValue = new JLabel("Value:");
	        lblAvgValue.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        lblAvgValue.setBounds(711, 787, 59, 29);
	        contentPane.add(lblAvgValue);
	        
	        HashMap<String, Double> avgScoresHashMap = rController.getAverageReviewScores(propertyID);
	        
	        textFieldCleanliness = new JTextField();
	        textFieldCleanliness.setEditable(false);
	        textFieldCleanliness.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        textFieldCleanliness.setBounds(396, 684, 130, 26);
	        textFieldCleanliness.setText(String.format("%.2f",avgScoresHashMap.get("cleanliness")));
	        contentPane.add(textFieldCleanliness);
	        textFieldCleanliness.setColumns(10);
	        
	        textFieldCommunication = new JTextField();
	        textFieldCommunication.setEditable(false);
	        textFieldCommunication.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        textFieldCommunication.setColumns(10);
	        textFieldCommunication.setBounds(396, 740, 130, 26);
	        textFieldCommunication.setText(String.format("%.2f",avgScoresHashMap.get("communication")));
	        contentPane.add(textFieldCommunication);
	        
	        textFieldCheckIn = new JTextField();
	        textFieldCheckIn.setEditable(false);
	        textFieldCheckIn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        textFieldCheckIn.setColumns(10);
	        textFieldCheckIn.setBounds(396, 792, 130, 26);
	        textFieldCheckIn.setText(String.format("%.2f",avgScoresHashMap.get("checkIn")));
	        contentPane.add(textFieldCheckIn);
	        
	        textFieldAccuracy = new JTextField();
	        textFieldAccuracy.setEditable(false);
	        textFieldAccuracy.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        textFieldAccuracy.setColumns(10);
	        textFieldAccuracy.setBounds(781, 683, 130, 26);
	        textFieldAccuracy.setText(String.format("%.2f",avgScoresHashMap.get("accuracy")));
	        contentPane.add(textFieldAccuracy);
	        
	        textFieldLocation = new JTextField();
	        textFieldLocation.setEditable(false);
	        textFieldLocation.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        textFieldLocation.setColumns(10);
	        textFieldLocation.setBounds(782, 739, 130, 26);
	        textFieldLocation.setText(String.format("%.2f",avgScoresHashMap.get("location")));
	        contentPane.add(textFieldLocation);
	        
	        textFieldValue = new JTextField();
	        textFieldValue.setEditable(false);
	        textFieldValue.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        textFieldValue.setColumns(10);
	        textFieldValue.setBounds(781, 791, 130, 26);
	        textFieldValue.setText(String.format("%.2f",avgScoresHashMap.get("value")));
	        contentPane.add(textFieldValue);
	        
	        JLabel lblAvgOverall = new JLabel("Overall:");
	        lblAvgOverall.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        lblAvgOverall.setBounds(505, 841, 74, 29);
	        contentPane.add(lblAvgOverall);
	        
	        textFieldOverall = new JTextField();
	        textFieldOverall.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        textFieldOverall.setEditable(false);
	        textFieldOverall.setColumns(10);
	        textFieldOverall.setBounds(591, 842, 130, 26);
	        textFieldOverall.setText(String.format("%.2f",avgScoresHashMap.get("total")));
	        contentPane.add(textFieldOverall);
	        frame.pack();
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setVisible(true);

	}
	
	public void showAllReviews(JPanel panel, ArrayList<Review> allReviews) {
		
		int numOfReviews = allReviews.size();
		
		for(int i = 0; i < numOfReviews; i++) {
			
            JPanel allReviewsPanel = new JPanel();
            allReviewsPanel.setLayout(new FlowLayout());
            allReviewsPanel.setBackground(Color.WHITE);
            allReviewsPanel.setPreferredSize(new Dimension(900, 270));

            JPanel singleReviewPanel = new JPanel();
            singleReviewPanel.setLayout(new FlowLayout());
            singleReviewPanel.setBackground(Color.LIGHT_GRAY);
            singleReviewPanel.setPreferredSize(new Dimension(500, 270));
            
            JLabel lblCleanliness = new JLabel("Cleanliness: ");
            lblCleanliness.setForeground(Color.BLACK);
            lblCleanliness.setPreferredSize(new Dimension(110, 20));
            JTextField textFieldCleanliness = new JTextField(String.valueOf(allReviews.get(i).getCleanlinessScore()));
            textFieldCleanliness.setPreferredSize(new Dimension(320, 20));
            textFieldCleanliness.setEditable(false);

            JLabel lblCommunication = new JLabel("Communication: ");
            lblCommunication.setForeground(Color.BLACK);
            lblCommunication.setPreferredSize(new Dimension(110, 20));
            JTextField textFieldCommunication = new JTextField(String.valueOf(allReviews.get(i).getCommunicationScore()));
            textFieldCommunication.setPreferredSize(new Dimension(320, 20));
            textFieldCommunication.setEditable(false);

            JLabel lblCheckIn = new JLabel("CheckIn: ");
            lblCheckIn.setForeground(Color.BLACK);
            lblCheckIn.setPreferredSize(new Dimension(110, 20));
            JTextField textFieldCheckIn = new JTextField(String.valueOf(allReviews.get(i).getCheckInScore()));
            textFieldCheckIn.setPreferredSize(new Dimension(320, 20));
            textFieldCheckIn.setEditable(false);

            JLabel lblAccuracy = new JLabel("Accuracy: ");
            lblAccuracy.setForeground(Color.BLACK);
            lblAccuracy.setPreferredSize(new Dimension(110, 20));
            JTextField textFieldAccuracy = new JTextField(String.valueOf(allReviews.get(i).getAccuracyScore()));
            textFieldAccuracy.setPreferredSize(new Dimension(320, 20));
            textFieldAccuracy.setEditable(false);

            JLabel lblLocation = new JLabel("Location: ");
            lblLocation.setForeground(Color.BLACK);
            lblLocation.setPreferredSize(new Dimension(110, 20));
            JTextField textFieldLocation = new JTextField(String.valueOf(allReviews.get(i).getLocationScore()));
            textFieldLocation.setPreferredSize(new Dimension(320, 20));
            textFieldLocation.setEditable(false);

            JLabel lblValue = new JLabel("Value: ");
            lblValue.setForeground(Color.BLACK);
            lblValue.setPreferredSize(new Dimension(110, 20));
            JTextField textFieldValue = new JTextField(String.valueOf(allReviews.get(i).getValueScore()));
            textFieldValue.setPreferredSize(new Dimension(320, 20));
            textFieldValue.setEditable(false);
            
            JLabel lblComments = new JLabel("Comments: ");
            lblComments.setForeground(Color.BLACK);
            lblComments.setPreferredSize(new Dimension(110, 20));
            JTextArea textFieldComments = new JTextArea(allReviews.get(i).getComments());
            textFieldComments.setPreferredSize(new Dimension(320, 100));
            textFieldComments.setLineWrap(true);
            textFieldComments.setEditable(false);
    
            
            singleReviewPanel.add(lblCleanliness);
            singleReviewPanel.add(textFieldCleanliness);
            singleReviewPanel.add(lblCommunication);
            singleReviewPanel.add(textFieldCommunication);
            singleReviewPanel.add(lblCheckIn);
            singleReviewPanel.add(textFieldCheckIn);
            singleReviewPanel.add(lblAccuracy);
            singleReviewPanel.add(textFieldAccuracy);
            singleReviewPanel.add(lblLocation);
            singleReviewPanel.add(textFieldLocation);
            singleReviewPanel.add(lblValue);
            singleReviewPanel.add(textFieldValue);
            singleReviewPanel.add(lblComments);
            singleReviewPanel.add(textFieldComments);

            
            allReviewsPanel.add(singleReviewPanel);
            panel.add(allReviewsPanel); 
		}
	
	}
}
