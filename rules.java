package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rules extends JFrame implements ActionListener {

    JButton b1,b2;
    String username;

    rules(String username){
        this.username= username;
        setBounds(500,100,800,650);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);

        JLabel l1 = new JLabel("Welcome "+username+" to Test of knowledge");
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Viner Hand ITC",Font.BOLD,30));
        l1.setBounds(50,20,700,30);
        add(l1);

        JLabel l2 = new JLabel("");
        l2.setText(
                "<html>1. You are trained to be a programmer and not a story teller, answer point to point<br><br>" +
                        "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer<br><br>" +
                        "3. You may have lot of options in life but here all the questions are compulsory<br><br>" +
                        "4. Crying is allowed but please do so quietly.<br><br>" +
                        "5. Only a fool asks and a wise answers (Be wise, not otherwise)<br><br>" +
                        "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di<br><br>" +
                        "7. Brace yourself, this paper is not for the faint hearted<br><br>" +
                        "8. May you know more than what John Snow knows, Good Luck<br><br>" +
                        "<html> "
        );
        l2.setFont(new Font("Tahoma",Font.PLAIN,15));
        l2.setBounds(20,90,600,400);
        add(l2);

        b1= new JButton("Back");
        b1.setBounds(280,500,80,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLUE);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(b1);

        b2= new JButton("Start");
        b2.setBounds(480,500,80,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLUE);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
            this.setVisible(false);
            new quiz_project().setVisible(true);
        }
        else {
            this.setVisible(false);
           // new start().setVisible(true);
            new start(username).setVisible(true);
        }
    }

    public static void main(String [] args){
        rules rl = new rules("");

    }
}
