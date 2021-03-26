import javax.swing.*;
import java.awt.*;

public class Executeable {
    JFrame window;
    Container con;
    JLabel titleNameLabel;
    JButton startButton;

    public Executeable(){
        Font titleFont = new Font("Times New Roman",Font.PLAIN,90);
        Font normalFont = new Font("Times New Roman",Font.PLAIN, 28);

        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        titleNameLabel = new JLabel("TO THE TOP");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);
        titleNameLabel.setBounds(100,100,600,150);

        startButton = new JButton("Start");
        startButton.setBounds(300,400,200,50);
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(normalFont);

        con.add(startButton);
        con.add(titleNameLabel);
    }

    public static void main(String[] args) {
        new Executeable();
    }
}
