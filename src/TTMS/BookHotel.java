package TTMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener{
    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    String user;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookhotel, back;
    BookHotel(String user){
        this.user = user;
        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK HOTEL");
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

        JLabel lblpackage = new JLabel("SELECT HOTEL :");
        lblpackage.setBounds(40, 110, 140, 20);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpackage);
        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 20);
        chotel.setFont(new Font("Tahoma", Font.BOLD, 14));
        chotel.setBackground(Color.pink);
        add(chotel);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from hotel");
            while (rs.next()){
                chotel.add(rs.getString("name"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        JLabel lblpersons = new JLabel("TOTAL NUMBERS :");
        lblpersons.setBounds(40, 150, 150, 25);
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpersons);
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        tfpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfpersons);

        JLabel lbldays = new JLabel("NO. OF DAYS :");
        lbldays.setBounds(40, 190, 150, 25);
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldays);
        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 25);
        tfdays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfdays);

        JLabel lblac = new JLabel("AC / NON-AC :");
        lblac.setBounds(40, 230, 150, 25);
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblac);
        cac = new Choice();
        cac.add("AC");
        cac.add("NON-AC");
        cac.setBounds(250, 230, 200, 20);
        cac.setFont(new Font("Tahoma", Font.BOLD, 14));
        cac.setBackground(Color.pink);
        add(cac);

        JLabel lblfood = new JLabel("FOOD INCLUDED :");
        lblfood.setBounds(40, 270, 150, 25);
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfood);
        cfood = new Choice();
        cfood.add("YES");
        cfood.add("NO");
        cfood.setBounds(250, 270, 200, 20);
        cfood.setFont(new Font("Tahoma", Font.BOLD, 14));
        cfood.setBackground(Color.pink);
        add(cfood);

        JLabel lblid = new JLabel("ID :");
        lblid.setBounds(40, 310, 140, 20);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);
        labelid = new JLabel();
        labelid.setBounds(250, 310, 200, 25);
        labelid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelid);

        JLabel lblnumber = new JLabel("NUMBER :");
        lblnumber.setBounds(40, 350, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 200, 25);
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelnumber);

        JLabel lblphone = new JLabel("PHONE :");
        lblphone.setBounds(40, 390, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);
        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 200, 25);
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelphone);

        JLabel lbltotal = new JLabel("TOTAL PRICE :");
        lbltotal.setBounds(40, 430, 150, 25);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);
        labelprice = new JLabel();
        labelprice.setBounds(250, 430, 200, 25);
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
        checkprice.setBounds(60, 470, 140, 25);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.addActionListener(this);
        add(checkprice);

        bookhotel = new JButton("BOOK HOTEL");
        bookhotel.setBounds(240, 470, 140, 25);
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.addActionListener(this);
        add(bookhotel);

        back = new JButton("BACK");
        back.setBounds(150, 510, 140, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 50, 550, 450);
        add(l12);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent E){
        if(E.getSource() == checkprice){
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("Select * from hotel where name = '"+chotel.getSelectedItem()+"'");
                while(rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));

                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();
                    if(persons * days > 0){
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("YES") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labelprice.setText("Rs" +total);
                    } else{
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }
            } catch(Exception ex){
                ex.printStackTrace();
            }
        } else if(E.getSource() == bookhotel){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully🎉✨");
                setVisible(false);
            } catch(Exception ae){
                ae.printStackTrace();
            }
        } else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new BookHotel("Shankar");
    }
}
