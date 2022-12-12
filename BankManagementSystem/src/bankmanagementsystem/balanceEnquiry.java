package BMJ;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class balanceEnquiry extends JFrame implements ActionListener {

    String pinnumber;
    JButton back;

    balanceEnquiry(String pinnumber) {

        this.pinnumber = pinnumber;
//         setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
//        image.setBounds(0, 0, 1500, 1000);  
        add(image);

        back = new JButton("Back");
        back.setBounds(400, 400, 150, 30);

        image.add(back);

        setSize(1500, 1000);
        setVisible(true);
//         setUndecorated(true);

        int balance = 0;
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

            while (rs.next()) {

                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Account balance is " + balance);
        back.addActionListener(this);
        text.setForeground(Color.white);
        text.setBounds(310, 300, 400, 55);
        text.setFont(new Font("System", Font.BOLD, 20));
        image.add(text);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);

    }

    public static void main(String args[]) {
        new balanceEnquiry("").setVisible(true);
    }
}
