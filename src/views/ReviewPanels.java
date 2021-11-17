package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.JScrollPane;

import main.Review;
import main.ReviewsController;

import javax.swing.BoxLayout;
import java.awt.*;
import java.util.ArrayList;


public class ReviewPanels {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewsController rc = new ReviewsController();
					ReviewPanels window = new ReviewPanels(rc.getAllReviewsOfProperty(1));
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
	public ReviewPanels( ArrayList<Review> allReviews) {
		initialize(allReviews);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Review> allReviews) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1200, 850);
		frame.setMinimumSize(new Dimension(1200, 850));
		frame.setTitle("Property Reviews");
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
	        

	        showAllReviews(panel, allReviews);

	        frame.getContentPane().add(contentPane, BorderLayout.CENTER);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBounds(450, 0, 299, 67);
	        contentPane.add(panel_1);
	        
	        JLabel lblPReview = new JLabel("Property Reviews");
	        lblPReview.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	        panel_1.add(lblPReview);
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
