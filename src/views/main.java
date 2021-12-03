package views;

import java.awt.Dimension;

import javax.swing.JFrame;

public class main {
	public static void main (String[] args) {
		
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1203, 850);
		frame.setMinimumSize(new Dimension(1200, 800));
		frame.setTitle("Team 23");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		HomePage startFrame = new HomePage(frame,null);
		
		frame.getContentPane().add(startFrame);
		frame.revalidate();
		frame.repaint();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}