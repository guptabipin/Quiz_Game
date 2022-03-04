package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class start extends JFrame implements ActionListener {

    JButton next,lifeline,submit;
    JLabel qno,question;
    JRadioButton op1,op2,op3,op4;
    ButtonGroup options;

    public static int score=0;

    public static int count=0;
    public static int timer =15;
    public static int ans_given=0;

    String qa[][]= new String[4][2];

    String per[][]= new String[4][1];

    String que [][]= new String[4][5];       // 6 = no of question,  5 = 1 question + 4 options

    String username;
    start(String username){
        this.username= username;
        setBounds(200,50,780,700);
        setVisible(true);
        setLayout(null);
       // setResizable(false);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ImageIcon icon = new ImageIcon("C:\\Users\\Bipin\\Downloads\\680.jpeg");  //for image set
        JLabel l1 = new JLabel(icon);
        l1.setBounds(50,20,680,300);
        add(l1);

        qno = new JLabel("");
        qno.setFont(new Font("Tahoma",Font.BOLD,18));
        qno.setBounds(50,340,30,40);
        add(qno);

        question = new JLabel("");
        question.setFont(new Font("Tahoma",Font.BOLD,16));
        question.setBounds(70,340,600,40);
        add(question);

        que[0][0]="Which is used to find and fix bugs in the Java Program ..?";
        que[0][1]="JVM";
        que[0][2]="JDB";
        que[0][3]="JDK";
        que[0][4]="JRE";

        que[1][0]="Number of primitive data types in Java are ?";
        que[1][1]="6";
        que[1][2]="7";
        que[1][3]="8";
        que[1][4]="9";

        que[2][0]="Select the valid statement ";
        que[2][1]="char[] ch = new char(5)";
        que[2][2]="char[] ch = new char[5]";
        que[2][3]="char[] ch = new char()";
        que[2][4]="char[] ch = new char[]";

        que[3][0]=" Output of Math.floor(3.6) ?";
        que[3][1]="3";
        que[3][2]="3.0";
        que[3][3]="4";
        que[3][4]="4.0";

        qa[0][1]="JDB";
        qa[1][1]="8";
        qa[2][1]="char[] ch = new char[5]";
        qa[3][1]="3.0";

        op1 = new JRadioButton("");
        op1.setBounds(75,390,300,20);
        op1.setBackground(Color.WHITE);
        add(op1);

        op2 = new JRadioButton("");
        op2.setBounds(75,418,300,20);
        op2.setBackground(Color.WHITE);
        add(op2);

        op3 = new JRadioButton("");
        op3.setBounds(75,450,300,20);
        op3.setBackground(Color.WHITE);
        add(op3);

        op4 = new JRadioButton("");
        op4.setBounds(75,485,300,20);
        op4.setBackground(Color.WHITE);
        add(op4);

        options = new ButtonGroup();
        options.add(op1);
        options.add(op2);
        options.add(op3);
        options.add(op4);

        next = new JButton("Next");
        next.setFont(new Font("Tahoma",Font.PLAIN,18));
        next.setBackground(Color.BLUE);
        next.setBounds(500,420,180,35);
        next.setForeground(Color.WHITE);
        add(next);

        lifeline = new JButton("50-50 LifeLine");
        lifeline.setFont(new Font("Tahoma",Font.PLAIN,18));
        lifeline.setBackground(Color.BLUE);
        lifeline.setBounds(500,470,180,35);
        lifeline.setForeground(Color.WHITE);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setFont(new Font("Tahoma",Font.PLAIN,18));
        submit.setBackground(Color.BLUE);
        submit.setEnabled(false);
        submit.setBounds(500,520,180,35);
        submit.setForeground(Color.WHITE);
        add(submit);

        next.addActionListener(this);
        submit.addActionListener(this);
        lifeline.addActionListener(this);

        start(0);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==next){
            repaint();
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);
            ans_given=1;

            if(options.getSelection()==null){
                per[count][0]= "";
            }
            else{
                per[count][0]=options.getSelection().getActionCommand();
            }
            if (count==2){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }

        else if (ae.getSource()==submit){
            ans_given=1;
            if(options.getSelection()==null){
                per[count][0]= "";
            }
            else{
                per[count][0]=options.getSelection().getActionCommand();
            }

            for (int i=0;i<per.length;i++){
                if (per[i][0].equals(qa[i][1])){
                    score+=10;
                }
                else {
                    score+=0;
                }
            }
            this.setVisible(false);
            new Score(username,score).setVisible(true);
        }
        else if(ae.getSource()==lifeline){
            if (count==0 || count == 1 || count==2|| count==3){
                op1.setEnabled(false);
                op4.setEnabled(false);
            }
            else {
                op2.setEnabled(false);
                op3.setEnabled(false);
            }
            lifeline.setEnabled(false);

        }

    }

    public void paint(Graphics g){
        super.paint(g);
        String time =  "Time Left - "+timer+" sec";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,15));
        if (timer>0){
            g.drawString(time,620,400);
        }
        else {
            g.drawString("Times up!!",620,400);
        }
        timer--;

        try{
            Thread.sleep(1000);
            repaint();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(ans_given==1) {
            ans_given=0;
            timer = 15;
        }
        else if (timer<0){
            timer=15;
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);
            if (count==2){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count==3){
                if(options.getSelection()==null){
                    per[count][0]= "";
                }
                else{
                    per[count][0]=options.getSelection().getActionCommand();
                }

                for (int i=0;i<per.length;i++){
                    if (per[i][0].equals(qa[i][1])){
                        score+=10;
                    }
                    else {
                        score+=0;
                    }
                }
                this.setVisible(false);
                new Score(username,score).setVisible(true);
            }
            else {
                if(options.getSelection()==null){
                    per[count][0]= "";
                }
                else{
                    per[count][0]=options.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
        
    }

    public void start (int count){
        qno.setText(""+(count+1) + ". " );   //to set question number
        question.setText(que[count][0]);  //to set a question

        op1.setActionCommand(que[count][1]);
        op2.setActionCommand(que[count][2]);
        op3.setActionCommand(que[count][3]);
        op4.setActionCommand(que[count][4]);

        op1.setLabel(que[count][1]); //to set options
        op2.setLabel(que[count][2]); //to set options
        op3.setLabel(que[count][3]); //to set options
        op4.setLabel(que[count][4]); //to set options

        options.clearSelection();
    }
    public static void main(String art []){
        new start("").setVisible(true);
    }
}
