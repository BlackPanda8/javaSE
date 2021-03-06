package javaapplication1;

import java.awt.*;
import javax.swing.*;

public class ProgressBarDemo {

    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar();
    
    public ProgressBarDemo() {
       
        bar.setValue(0);
        bar.setBounds(0, 0, 450, 50);
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli", Font.BOLD,25));
        bar.setForeground(Color.red);
        bar.setBackground(Color.black);
        
        frame.add(bar);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,150);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        fill();
    }
    
    public void fill(){
         int counter = 0;
         
         while(counter<=100){
             bar.setValue(counter);
             try{
             Thread.sleep(50);
         }
         catch(InterruptedException e){
                 e.printStackTrace();
                 }
             counter += 1;
             
         }
         bar.setString("Done");
    }
    
}
