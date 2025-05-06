package TTMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener{
    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton search, retrieve, back;
    ForgetPassword(){
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setBounds(40, 20, 500, 280);
        p1.setLayout(null);
        add(p1);

        JLabel lb1 = new JLabel("Username :");
        lb1.setBounds(40, 20, 100, 25);
        lb1.setFont(new Font("Tahoma", Font.BOLD, 15));
        p1.add(lb1);
        tfusername = new JTextField();
        tfusername.setBounds(220, 20, 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        search = new JButton("SEARCH");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380, 20, 100, 25);
        search.addActionListener(this);
        p1.add(search);

        JLabel lb2 = new JLabel("Name :");
        lb2.setBounds(40, 60, 100, 25);
        lb2.setFont(new Font("Tahoma", Font.BOLD, 15));
        p1.add(lb2);
        tfname = new JTextField();
        tfname.setBounds(220, 60, 150, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lb3 = new JLabel("Security Question :");
        lb3.setBounds(40, 100, 150, 25);
        lb3.setFont(new Font("Tahoma", Font.BOLD, 15));
        p1.add(lb3);
        tfquestion = new JTextField();
        tfquestion.setBounds(220, 100, 150, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        JLabel lb4 = new JLabel("Answer :");
        lb4.setBounds(40, 140, 170, 25);
        lb4.setFont(new Font("Tahoma", Font.BOLD, 15));
        p1.add(lb4);
        tfanswer = new JTextField();
        tfanswer.setBounds(220, 140, 150, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        retrieve = new JButton("RETRIEVE");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(380, 140, 100, 25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel lb5 = new JLabel("Password :");
        lb5.setBounds(40, 180, 170, 25);
        lb5.setFont(new Font("Tahoma", Font.BOLD, 15));
        p1.add(lb5);
        tfpassword = new JTextField();
        tfpassword.setBounds(220, 180, 150, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        back = new JButton("BACK");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150, 230, 100, 25);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent E){
        if(E.getSource() == search){
            try{
                String query = "Select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(E.getSource() == retrieve){
            try{
                String query = "Select * from account where answer = '"+tfanswer.getText()+"' and username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfpassword.setText(rs.getString("password"));
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else{
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args){
        new ForgetPassword();
    }
}
