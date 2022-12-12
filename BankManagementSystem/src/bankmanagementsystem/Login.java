package BMJ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear, exit;
    JTextField cardTextField;
    JPasswordField pinTextField;

    public Login() {

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/black.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(280, 40, 300, 200);

        add(label);  //for add label on the frame

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 45));
        text.setForeground(Color.white);
        text.setBounds(560, 140, 500, 60);  // left , up(40)  , length(width) , text-height(40)
        add(text);

        JLabel cardno = new JLabel("Card Number");

        cardno.setFont(new Font("Raieway", Font.BOLD, 28));
        cardno.setBounds(410, 250, 250, 30);
        cardno.setForeground(Color.white);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(630, 250, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        login = new JButton("SIGN IN");
        login.setBounds(550, 520, 100, 30);
        login.setForeground(Color.black);
        login.setBackground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setForeground(Color.black);
        clear.setBackground(Color.white);
        clear.setBounds(550, 450, 100, 30);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setForeground(Color.black);
        signup.setBackground(Color.white);
        signup.addActionListener(this);
        signup.setBounds(700, 450, 110, 30);
        add(signup);

        JLabel pin = new JLabel("User PIN");
        pin.setBounds(410, 300, 400, 40);
        pin.setForeground(Color.white);
        pin.setFont(new Font("Raieway", Font.BOLD, 28));
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(630, 310, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        exit = new JButton("Exit");
        exit.setBounds(700, 520, 110, 30);
        exit.setForeground(Color.white);
        exit.setBackground(Color.black);
        exit.addActionListener(this);
        add(exit);

        setSize(1500, 1000);

        getContentPane().setBackground(Color.black);
        setUndecorated(true);
        setVisible(true);

        while (true) {

            text.setVisible(false);
            try {

                Thread.sleep(400);

            } catch (Exception e) {

            }

            text.setVisible(true);
            try {

                Thread.sleep(500);

            } catch (Exception e) {

            }

        }
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == exit) {
            System.exit(0);
            
        } else if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");

                   
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();

            String query = "select * from login where cardnumber = '" + cardnumber + "' and pin = '" + pinnumber + "'";

            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == signup) {

            setVisible(false);
            new SignupOne().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

}
