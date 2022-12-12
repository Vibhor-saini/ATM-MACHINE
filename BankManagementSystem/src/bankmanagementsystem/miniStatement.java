package BMJ;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

public class miniStatement extends JFrame implements ActionListener {

    JButton b1, b2;

    miniStatement(String pinnumber) {

        setTitle("Mini Statement");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(10, 20, 200, 30);

        add(label);  //for add label on the frame

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 25, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 100, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 350, 300, 20);
        add(balance);

        JLabel mini = new JLabel();
        mini.setBounds(20, 120, 400, 200);
        add(mini);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            while (rs.next()) {
                card.setText("Card Number:  " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12) + "\n\n\n");
            }
        } catch (Exception e) {

            System.out.println(e);
        }

        try {
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }

            balance.setText("Your current account balance is Rs  " + bal);

        } catch (Exception e) {
            System.out.println(e);
        }

        b1 = new JButton("Exit");
        add(b1);
        b1.addActionListener(this);
        b1.setBounds(20, 500, 100, 25);

        setSize(400, 600);
        setLocation(20, 20);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String args[]) {
        new miniStatement("").setVisible(true);

    }
}
