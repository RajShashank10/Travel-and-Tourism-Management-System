package TTMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener{
    JButton addPersonalDetails, updatePersonalDetails, viewPersonalDetails, deletePersonalDetails, checkpackages, bookpackage, viewpackage, viewhotels, bookhotel, viewBookedHotel, destination, payments, calculator, notepad, about;
    String user;
    Dashboard(String user){
        this.user = user;
        //setBounds(0, 0, 1600, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 1600, 65);
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setBounds(0, 65, 300, 900);
        p2.setLayout(null);
        p2.setBackground(new Color(103, 103, 244));
        add(p2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0, 300, 50);
        addPersonalDetails.setBackground(new Color(131, 131, 251));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma", Font.ITALIC, 20));
        addPersonalDetails.setMargin(new Insets(0, 0, 0, 82));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 48, 300, 50);
        updatePersonalDetails.setBackground(new Color(131, 131, 251));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.ITALIC, 20));
        updatePersonalDetails.setMargin(new Insets(0, 0, 0, 60));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0, 96, 300, 50);
        viewPersonalDetails.setBackground(new Color(131, 131, 251));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.ITALIC, 20));
        viewPersonalDetails.setMargin(new Insets(0, 0, 0, 80));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 144, 300, 50);
        deletePersonalDetails.setBackground(new Color(131, 131, 251));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.ITALIC, 20));
        deletePersonalDetails.setMargin(new Insets(0, 0, 0, 65));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkpackages = new JButton("Check Package");
        checkpackages.setBounds(0, 192, 300, 50);
        checkpackages.setBackground(new Color(131, 131, 251));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahoma", Font.ITALIC, 20));
        checkpackages.setMargin(new Insets(0, 0, 0, 140));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);

        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(0, 240, 300, 50);
        bookpackage.setBackground(new Color(131, 131, 251));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma", Font.ITALIC, 20));
        bookpackage.setMargin(new Insets(0, 0, 0, 150));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);

        viewpackage = new JButton("View Package");
        viewpackage.setBounds(0, 288, 300, 50);
        viewpackage.setBackground(new Color(131, 131, 251));
        viewpackage.setForeground(Color.WHITE);
        viewpackage.setFont(new Font("Tahoma", Font.ITALIC, 20));
        viewpackage.setMargin(new Insets(0, 0, 0, 150));
        viewpackage.addActionListener(this);
        p2.add(viewpackage);

        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0, 336, 300, 50);
        viewhotels.setBackground(new Color(131, 131, 251));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma", Font.ITALIC, 20));
        viewhotels.setMargin(new Insets(0, 0, 0, 170));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);

        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(0, 384, 300, 50);
        bookhotel.setBackground(new Color(131, 131, 251));
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setFont(new Font("Tahoma", Font.ITALIC, 20));
        bookhotel.setMargin(new Insets(0, 0, 0, 170));
        bookhotel.addActionListener(this);
        p2.add(bookhotel);

        viewBookedHotel = new JButton("View Booked Hotels");
        viewBookedHotel.setBounds(0, 432, 300, 50);
        viewBookedHotel.setBackground(new Color(131, 131, 251));
        viewBookedHotel.setForeground(Color.WHITE);
        viewBookedHotel.setFont(new Font("Tahoma", Font.ITALIC, 20));
        viewBookedHotel.setMargin(new Insets(0, 0, 0, 95));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);

        destination = new JButton("Destination");
        destination.setBounds(0, 480, 300, 50);
        destination.setBackground(new Color(131, 131, 251));
        destination.setForeground(Color.WHITE);
        destination.setFont(new Font("Tahoma", Font.ITALIC, 20));
        destination.setMargin(new Insets(0, 0, 0, 170));
        destination.addActionListener(this);
        p2.add(destination);

        payments = new JButton("Payments");
        payments.setBounds(0, 528, 300, 50);
        payments.setBackground(new Color(131, 131, 251));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma", Font.ITALIC, 20));
        payments.setMargin(new Insets(0, 0, 0, 180));
        payments.addActionListener(this);
        p2.add(payments);

        calculator = new JButton("Calculator");
        calculator.setBounds(0, 576, 300, 50);
        calculator.setBackground(new Color(131, 131, 251));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma", Font.ITALIC, 20));
        calculator.setMargin(new Insets(0, 0, 0, 180));
        calculator.addActionListener(this);
        p2.add(calculator);

        notepad = new JButton("Notepad");
        notepad.setBounds(0, 624, 300, 50);
        notepad.setBackground(new Color(131, 131, 251));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma", Font.ITALIC, 20));
        notepad.setMargin(new Insets(0, 0, 0, 190));
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0, 672, 300, 50);
        about.setBackground(new Color(131, 131, 251));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma", Font.ITALIC, 20));
        about.setMargin(new Insets(0, 0, 0, 200));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(480, 70, 1000, 70);
        text.setFont(new Font("Tahoma", Font.BOLD, 45));
        image.add(text);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addPersonalDetails){
            new AddCustomer(user);
        } else if(e.getSource() == updatePersonalDetails){
            new UpdateCustomer(user);
        } else if(e.getSource() == viewPersonalDetails){
            new ViewCustomer(user);
        } else if(e.getSource() == deletePersonalDetails){
            new DeleteDetails(user);
        } else if(e.getSource() == checkpackages){
            new CheckPackage();
        } else if(e.getSource() == bookpackage){
            new BookPackage(user);
        } else if(e.getSource() == viewpackage){
            new ViewPackage(user);
        } else if(e.getSource() == viewhotels){
            new CheckHotels();
        } else if(e.getSource() == bookhotel){
            new BookHotel(user);
        } else if(e.getSource() == viewBookedHotel){
            new ViewBookedHotel(user);
        } else if(e.getSource() == destination){
            new Destinations();
        } else if(e.getSource() == payments){
            new Payment();
        } else if(e.getSource() == calculator){
            try{
                Runtime.getRuntime().exec("calc.exe");
            } catch(Exception ex){
                ex.printStackTrace();
            }
        } else if(e.getSource() == notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch(Exception Ex){
                Ex.printStackTrace();
            }
        } else if(e.getSource() == about){
            new About();
        }
    }

    public static void main(String[] args){
        new Dashboard("");
    }
}
