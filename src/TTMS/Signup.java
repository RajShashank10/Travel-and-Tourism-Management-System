package TTMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener{
    JButton create, back;
    JTextField tfname, tfusername, tfpassword, tfanswer;
    Choice security;
    Signup(){
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.WHITE);
        setLocation(350, 200);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        JLabel lb1 = new JLabel("USERNAME :");
        lb1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb1.setBounds(15, 20, 125, 25);
        p1.add(lb1);
        tfusername = new JTextField();
        tfusername.setBounds(220, 20, 190, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel lb2 = new JLabel("NAME :");
        lb2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb2.setBounds(15, 60, 125, 25);
        p1.add(lb2);
        tfname = new JTextField();
        tfname.setBounds(220, 60, 190, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lb3 = new JLabel("PASSWORD :");
        lb3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb3.setBounds(15, 100, 125, 25);
        p1.add(lb3);
        tfpassword = new JTextField();
        tfpassword.setBounds(220, 100, 190, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        JLabel lb4 = new JLabel("SECURITY QUESTION :");
        lb4.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb4.setBounds(15, 140, 180, 25);
        p1.add(lb4);
        security = new Choice();
        security.add("Fav Character from the Anime");
        security.add("Fav Marvel Super-Hero");
        security.add("Your Lucky Number");
        security.add("Your Childhood Super-Hero");
        security.setFont(new Font("Tahoma", Font.ITALIC, 12));
        security.setBounds(220, 140, 190, 25);
        p1.add(security);

        JLabel lb5 = new JLabel("ANSWER :");
        lb5.setFont(new Font("Tahoma", Font.BOLD, 15));
        lb5.setBounds(15, 180, 125, 25);
        p1.add(lb5);
        tfanswer = new JTextField();
        tfanswer.setBounds(220, 180, 190, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setFont(new Font("Tahoma", Font.BOLD, 15));
        create.setBounds(80, 250, 100, 30);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.setBounds(250, 250, 100, 30);
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent E){
        if(E.getSource() == create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();

            String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created Successfully🎉✨");
                setVisible(false);
                new Login();
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(E.getSource() == back){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args){
        new Signup();
    }
}
