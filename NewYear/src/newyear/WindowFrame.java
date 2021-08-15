package newyear;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class WindowFrame extends JFrame{

    Random random;
    int width; 
    int height;
    String urlImage = "C:\\Users\\Саша\\Documents\\NetBeansProjects\\NewYear\\src\\resources\\1.jpg";
    JLabel label;
    JLabel textLabel;
    
    WindowFrame(){
   
    random = new Random();
    width = random.nextInt(1920)+1;
    height = random.nextInt(1080)+1;
    

    ImageIcon img = new ImageIcon(urlImage);
    label = new JLabel("", img,JLabel.CENTER);
   
    textLabel = new JLabel();
    textLabel.setText("Happy New Year");
    textLabel.setFont(new Font("Ink Free", Font.PLAIN,35));
    textLabel.setBounds(20,330,300,100);
    
    this.add(textLabel);
    this.add(label);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setSize(300, 450);
    this.setLocation(width, height);
    this.setVisible(true);
}
 
}
