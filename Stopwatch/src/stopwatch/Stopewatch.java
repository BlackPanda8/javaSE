package stopwatch;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Stopewatch extends JFrame implements ActionListener{

    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);
    
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           elapsedTime+=1000;
           hours = (elapsedTime/3600000);
           minutes = (elapsedTime/60000) % 60;
           seconds = (elapsedTime/1000) % 60;
           
           String seconds_string = String.format("%02d", seconds);
           String minutes_string = String.format("%02d", minutes);
           String hours_string = String.format("%02d", hours);
           timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
           
        }
    });
    
    public Stopewatch() {
        
        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        timeLabel.setBounds(100,100,200,100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN,35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        
        startButton.setBounds(100,200,100,50);
        startButton.setFont(new Font("Ink Free", Font.PLAIN,20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        
        resetButton.setBounds(200,200,100,50);
        resetButton.setFont(new Font("Ink Free", Font.PLAIN,20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        
        this.add(startButton);
        this.add(resetButton);
        this.add(timeLabel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,420);
        this.setLayout(null);
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == startButton){
           if(started==false){
               started = true;
               startButton.setText("STOP");
               start();
           }else{
               started = false;
               startButton.setText("START");
               stop();
           }
       }
       if(e.getSource() == resetButton){
           started = false;
           startButton.setText("START");
           reset();
       }
    }
    
    void start(){
        timer.start();
    }
    void stop(){
        timer.stop();
    }
    void reset(){
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0; 
        hours = 0;
        String seconds_string = String.format("%02d", seconds);
        String minutes_string = String.format("%02d", minutes);
        String hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
           
    }
}
