package TTMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener{
    JLabel labelusername, labelname;
    JTextField tfid, tfnumber, tfcountry, tfaddress, tfemail, tfphone, tfgender;
    JButton update, back;
    String user;
    UpdateCustomer(String user){
        this.user = user;

        JLabel UCD = new JLabel("UPDATE CUSTOMER DETAILS");
        UCD.setBounds(20, 10, 600, 25);
        UCD.setFont(new Font("Tahoma", Font.BOLD, 30));
        UCD.setForeground(new Color(250, 86, 147));
        add(UCD);

        JLabel lblusername = new JLabel("USERNAME");
        lblusername.setBounds(30, 50, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblusername);
        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 90, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblid);
        tfid = new JTextField();
        tfid.setBounds(220, 90, 180, 25);
        add(tfid);

        JLabel lblnumber = new JLabel("NUMBER");
        lblnumber.setBounds(30, 130, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblnumber);
        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 180, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(30, 170, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblname);
        labelname = new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(30, 210, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblgender);
        tfgender = new JTextField();
        tfgender.setBounds(220, 210, 180, 25);
        add(tfgender);

        JLabel lblcountry = new JLabel("COUNTRY");
        lblcountry.setBounds(30, 250, 150, 25);
        lblcountry.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblcountry);
        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 180, 25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("ADDRESS");
        lbladdress.setBounds(30, 290, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbladdress);
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 180, 25);
        add(tfaddress);

        JLabel lblphone = new JLabel("PHONE NO.");
        lblphone.setBounds(30, 330, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblphone);
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 180, 25);
        add(tfphone);

        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(30, 370, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblemail);
        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 180, 25);
        add(tfemail);

        update = new JButton("UPDATE");
        update.setBounds(70, 430, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBounds(220, 430, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(270, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420, 60, 380, 400);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer where username = '"+user+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        setBounds(500, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == update){
            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            try{
                Conn c = new Conn();
                String query = "update customer set username = '"+username+"', id = '"+id+"', number = '"+number+"', name = '"+name+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully🎉✨");
                setVisible(false);
            } catch(Exception E){
                E.printStackTrace();
            }
        } else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new UpdateCustomer("Shankar");
    }
}
