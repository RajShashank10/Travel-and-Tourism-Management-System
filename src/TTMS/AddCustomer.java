package TTMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener{
    JLabel labelusername, labelname;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone;
    JRadioButton radioButtonM, radioButtonF;
    JButton add, back;
    String user;
    AddCustomer(String user){
        this.user = user;
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

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
        comboid = new JComboBox(new String[]{"Aadhar Card", "PAN Card", "Passport", "Driving Licence", "Category Certificate", "Ration Card"});
        comboid.setBackground(new Color(16, 108, 115));
        comboid.setBounds(220, 90, 180, 25);
        comboid.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboid.setForeground(Color.WHITE);
        add(comboid);

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
        radioButtonM = new JRadioButton("MALE");
        radioButtonM.setBounds(220, 210, 85, 27);
        radioButtonM.setBackground(new Color(16, 108, 115));
        radioButtonM.setFont(new Font("Tahoma", Font.BOLD, 14));
        radioButtonM.setForeground(Color.WHITE);
        add(radioButtonM);
        radioButtonF = new JRadioButton("FEMALE");
        radioButtonF.setBounds(310, 210, 85, 27);
        radioButtonF.setBackground(new Color(16, 108, 115));
        radioButtonF.setFont(new Font("Tahoma", Font.BOLD, 14));
        radioButtonF.setForeground(Color.WHITE);
        add(radioButtonF);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonM);
        buttonGroup.add(radioButtonF);

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

        JLabel ACD = new JLabel("ADD CUSTOMER DETAILS");
        ACD.setBounds(430, 24, 445, 35);
        ACD.setFont(new Font("Tahoma", Font.BOLD, 30));
        ACD.setForeground(new Color(250, 86, 147));
        add(ACD);

        add = new JButton("ADD");
        add.setBounds(70, 430, 100, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(220, 430, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420, 50, 400, 500);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from account where username = '"+user+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == add){
            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if(radioButtonM.isSelected()){
                gender = "MALE";
            } else if(radioButtonF.isSelected()){
                gender = "FEMALE";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            try{
                Conn c = new Conn();
                String query = "insert into customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully🎉✨");
                setVisible(false);
            } catch(Exception E){
                E.printStackTrace();
            }
        } else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new AddCustomer("Shankar");
    }
}
