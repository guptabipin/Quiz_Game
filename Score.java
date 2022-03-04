package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {

    JLabel l2,l3;
    JButton b1;

    Score(String username,int score){
        setBounds(500,50,750,550);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        setLayout(null);

        ImageIcon icon = new ImageIcon("C:\\Users\\Bipin\\Downloads\\sc1.jpg");  //for image set
        //Image img = icon.getImage().getScaledInstance(,250,Image.SCALE_DEFAULT);
        //ImageIcon ic = new ImageIcon(img);
        JLabel l1 = new JLabel(icon);
        l1.setBounds(392,50,357,489);
        add(l1);

        l2 = new JLabel("Thank you "+username+" for Playing Test of Knowledge");
        l2.setBounds(40,10,700,30);
        l2.setFont(new Font("Jokerman",Font.PLAIN,24));
        add(l2);

        l3 = new JLabel("Your Score is "+score+"/40");
        l3.setFont(new Font("Jokerman",Font.PLAIN,26));
        l3.setBounds(100,200,300,30);
        l3.setForeground(Color.magenta);
        add(l3);

        b1 = new JButton("Play Again");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(150,270,120,30);
        add(b1);

        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
        new quiz_project().setVisible(true);
    }
    public static void main(String [] args){
        Score sc = new Score("",0);
    }

}
