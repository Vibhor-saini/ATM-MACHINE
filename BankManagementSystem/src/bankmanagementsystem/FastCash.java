package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdraw, ministatement, pinchange, fastcash, balanceenquiry, exit;
    String pinnumber;

    public FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
//        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
//        image.setBounds(0, 0, 1500, 1000);  
        add(image);  //for add label on the frame

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(360, 220, 700, 55);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 20));
        image.add(text);

        deposit = new JButton("RS 100");
        deposit.setBounds(270, 300, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("RS 500");
        withdraw.setBounds(530, 300, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(270, 340, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(530, 340, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(270, 380, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(530, 380, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("BACK");
        exit.setBounds(530, 420, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(1500, 1000);
//        setLocation(200,0);
//setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);

            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select*from bank where pin = '" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {

                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('" + pinnumber + "' , '" + date + "' , 'withdraw' , '" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs" + amount + "Debited Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void main(String args[]) {
        new FastCash("").setVisible(true);
    }
}
