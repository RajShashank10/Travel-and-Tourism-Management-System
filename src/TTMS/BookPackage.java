package TTMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener{
    Choice cpackage;
    JTextField tfpersons;
    String user;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookpackage, back;
    BookPackage(String user){
        this.user = user;
        setBounds(350, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("USERNAME :");
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);
        labelusername = new JLabel();
        labelusername.setBounds(250, 70, 200, 20);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelusername);

        JLabel lblpackage = new JLabel("SELECT PACKAGE :");
        lblpackage.setBounds(40, 110, 140, 20);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpackage);
        cpackage = new Choice();
        cpackage.add("GOLD PACKAGE");
        cpackage.add("SILVER PACKAGE");
        cpackage.add("BRONZE PACKAGE");
        cpackage.setBounds(250, 110, 200, 20);
        cpackage.setFont(new Font("Tahoma", Font.BOLD, 14));
        cpackage.setBackground(Color.pink);
        add(cpackage);

        JLabel lblpersons = new JLabel("TOTAL NUMBERS :");
        lblpersons.setBounds(40, 150, 150, 25);
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpersons);
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        tfpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfpersons);

        JLabel lblid = new JLabel("ID :");
        lblid.setBounds(40, 190, 140, 20);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);
        labelid = new JLabel();
        labelid.setBounds(250, 190, 200, 25);
        labelid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelid);

        JLabel lblnumber = new JLabel("NUMBER :");
        lblnumber.setBounds(40, 230, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 200, 25);
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelnumber);

        JLabel lblphone = new JLabel("PHONE :");
        lblphone.setBounds(40, 270, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);
        labelphone = new JLabel();
        labelphone.setBounds(250, 270, 200, 25);
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelphone);

        JLabel lbltotal = new JLabel("TOTAL PRICE :");
        lbltotal.setBounds(40, 310, 150, 25);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);
        labelprice = new JLabel();
        labelprice.setBounds(250, 310, 200, 25);
        labelprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelprice);

        try{
            Conn c = new Conn();
            String query = "Select * from customer where username = '"+user+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        checkprice = new JButton("CHECK PRICE");
        checkprice.setBounds(60, 380, 140, 25);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("BOOK PACKAGE");
        bookpackage.setBounds(240, 380, 140, 25);
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("BACK");
        back.setBounds(150, 420, 140, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 20, 500, 460);
        add(l12);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent E){
        if(E.getSource() == checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("GOLD PACKAGE")){
                cost += 55000;
            } else if(pack.equals("SILVER PACKAGE")){
                cost += 48000;
            } else{
                cost += 45000;
            }
            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labelprice.setText("Rs" +cost);
        } else if(E.getSource() == bookpackage){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");

                JOptionPane.showMessageDialog(null, "Package Booked Successfully🎉✨");
                setVisible(false);
            } catch(Exception ae){
                ae.printStackTrace();
            }
        } else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new BookPackage("Shankar");
    }
}
