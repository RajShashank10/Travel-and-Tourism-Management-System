package TTMS;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
    JTextField tf1, tf2;
    JButton login, signup, password;
    Login(){
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel lb1 = new JLabel("Username");
        lb1.setBounds(60, 20, 100, 25);
        lb1.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lb1);
        tf1 = new JTextField();
        tf1.setBounds(60, 60, 300, 30);
        tf1.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tf1);

        JLabel lb2 = new JLabel("Password");
        lb2.setBounds(60, 110, 100, 25);
        lb2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lb2);
        tf2 = new JTextField();
        tf2.setBounds(60, 150, 300, 30);
        tf2.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tf2);

        login = new JButton("Login");
        login.setBounds(60, 210, 130, 30);
        login.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Sign Up");
        signup.setBounds(230, 210, 130, 30);
        signup.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);

        password = new JButton("Forget Password");
        password.setBounds(130, 260, 180, 30);
        password.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        password.setBackground(new Color(133, 193, 233));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(133, 193, 233)));
        password.addActionListener(this);
        p2.add(password);

        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(320, 260, 150, 20);
        text.setForeground(Color.RED);
        p2.add(text);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent E){
        if(E.getSource() == login){
            try{
                String user = tf1.getText();
                String pass = tf2.getText();

                String query = "Select * from account where username = '"+user+"' AND password = '"+pass+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(user);
                } else{
                    JOptionPane.showMessageDialog(null, "Incorrect!! Username or Password...🚨🚨");
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(E.getSource() == signup){
            setVisible(false);
            new Signup();
        } else{
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static  void  main(String[] args){
        new Login();
    }
}
