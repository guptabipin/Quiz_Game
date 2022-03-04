package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quiz_project extends JFrame implements ActionListener {

    JButton button1,button2;
    JTextField t1;

    quiz_project(){
        setBounds(300,100,1200,555);  //dLeft , dTop , width,height
        setTitle("Quiz");
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.white); //for frame colour
        setResizable(false);

        ImageIcon icon = new ImageIcon("C:\\Users\\Bipin\\Downloads\\quiz.jpg");  //for image set
        JLabel l1 = new JLabel(icon);
        l1.setBounds(0,0,600,522);
        add(l1);

        JLabel l2 = new JLabel("Test of knowledge");
        l2.setFont(new Font("Viner Hand ITC",Font.BOLD,40)); //set properties for text
        l2.setForeground(Color.pink);  //change text colour
        l2.setBounds(720,50,350,80);
        add(l2);

        JLabel l3 = new JLabel("Enter your name :");
        l3.setFont(new Font("Mongolian Baiti",Font.BOLD,18)); //set properties for text
        l3.setForeground(Color.blue);  //change text colour
        l3.setBounds(800,150,400,50);
        add(l3);

        t1 = new JTextField();
        t1.setFont(new Font("Mongolian Baiti",Font.BOLD,15));
        t1.setBounds(720,210,300,30);
        add(t1);

        button1 = new JButton("Rules");
        button1.setBounds(750,290,100,30);
        button1.setForeground(Color.WHITE);   //text colour
        button1.setBackground(Color.BLUE);   //background colour
        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(button1);

        button2 = new JButton("Exit");
        button2.setBounds(900,290,100,30);
        button2.setForeground(Color.WHITE);   //text colour
        button2.setBackground(Color.BLUE);   //background colour
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(button2);

        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == button1){
            String name = t1.getText();
            this.setVisible(false);   //closing old frame
            rules rl = new  rules(name);
        }
        else {
            System.exit(0);
        }
    }

    public static void main(String [] args) {
        quiz_project qz = new quiz_project();

    }
}
