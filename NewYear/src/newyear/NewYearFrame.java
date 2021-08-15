package newyear;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class NewYearFrame extends JFrame implements ActionListener{
    
    JButton button = new JButton("Press a buttom");

    
    public NewYearFrame() {
        this.setSize(190,80);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        button.addActionListener(this);
        this.add(button);
        this.setVisible(true);
    
    }

  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            (new Thread((Runnable) new ThreadRun())).start();
        }
    }

    
}
