package TTMS;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    Thread thread;
    JProgressBar bar;
    String user;
    public void run(){
        try{
            for(int i = 1; i <= 101; i++){
                int max = bar.getMaximum(); //100
                int value = bar.getValue();
                if(value < max){
                    bar.setValue(bar.getValue() + 1);
                } else{
                    setVisible(false);
                    new Dashboard(user);
                }
                Thread.sleep(50);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    Loading(String user){
        this.user = user;
        thread = new Thread(this);

        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(Color.CYAN);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(165, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(240, 130, 200, 30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loading);

        JLabel username = new JLabel("Welcome " +user+ "!!!");
        username.setBounds(20, 310, 400, 40);
        username.setForeground(Color.GREEN);
        username.setFont(new Font("Raleway", Font.BOLD, 20));
        add(username);

        thread.start();
        setVisible(true);
    }
    public static void main(String[] args){
        new Loading("");
    }
}
