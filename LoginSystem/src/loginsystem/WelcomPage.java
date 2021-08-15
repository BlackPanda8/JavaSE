package loginsystem;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class WelcomPage {

        JFrame frame = new JFrame("Welcom Page");
	JLabel welcomeLabel = new JLabel("Hello!");
	
	WelcomPage(String userID){
		
		welcomeLabel.setBounds(0,0,200,35);
		welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
		welcomeLabel.setText("Hello "+userID);
		
		frame.add(welcomeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
    }
}
