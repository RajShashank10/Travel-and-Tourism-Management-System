package TTMS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener{
    JButton back;
    Paytm(){
        //setBounds(500, 200, 800, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        try{
            pane.setPage("https://paytm.com/");
        } catch(Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, ERROR 504!!</html>");
        }

        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);

        back = new JButton("BACK");
        back.setBounds(610, 20, 80, 40);
        back.addActionListener(this);
        pane.add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Payment();
    }

    public static void main(String[] args){
        new Paytm();
    }
}
