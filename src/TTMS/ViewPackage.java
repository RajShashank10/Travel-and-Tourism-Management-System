package TTMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewPackage extends JFrame implements ActionListener{
    JButton back;
    //String user;
    ViewPackage(String user){
        //this.user = user;
        setBounds(450, 200, 900, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setBounds(30, 5, 340, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 25));
        text.setForeground(Color.CYAN);
        add(text);

        JLabel lblusername = new JLabel("USERNAME :");
        lblusername.setBounds(30, 50, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblusername);
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelusername);

        JLabel lblpackage = new JLabel("PACKAGE :");
        lblpackage.setBounds(30, 90, 150, 25);
        lblpackage.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblpackage);
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220, 90, 150, 25);
        labelpackage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelpackage);

        JLabel lblpersons = new JLabel("TOTAL PERSONS :");
        lblpersons.setBounds(30, 130, 150, 25);
        lblpersons.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblpersons);
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220, 130, 150, 25);
        labelpersons.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelpersons);

        JLabel lblid = new JLabel("ID :");
        lblid.setBounds(30, 170, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblid);
        JLabel labelid = new JLabel();
        labelid.setBounds(220, 170, 150, 25);
        labelid.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelid);

        JLabel lblnumber = new JLabel("NUMBER :");
        lblnumber.setBounds(30, 210, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblnumber);
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 210, 150, 25);
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelnumber);

        JLabel lblphone = new JLabel("PHONE NO. :");
        lblphone.setBounds(30, 250, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblphone);
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 250, 150, 25);
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelphone);

        JLabel lblprice = new JLabel("PRICE :");
        lblprice.setBounds(30, 290, 150, 25);
        lblprice.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblprice);
        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 290, 150, 25);
        labelprice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(labelprice);

        back = new JButton("BACK");
        back.setBounds(130, 360, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(460, 345, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 460, 345);
        add(image);
        try{
            Conn c = new Conn();
            String query = "Select * from bookpackage where username = '"+user+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelpackage.setText(rs.getString("package"));
                labelpersons.setText(rs.getString("persons"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        setVisible(false);
    }

    public static void main(String[] args){
        new ViewPackage("Shankar");
    }
}
