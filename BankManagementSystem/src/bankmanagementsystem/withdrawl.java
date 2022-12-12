package BMJ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw, back;
    String pinnumber;

    public withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;

//        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JLabel text = new JLabel("MAXIMUM LIMIT IS 10000 Rs ");
        text.setBounds(340, 210, 700, 55);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 20));
        image.add(text);

        JLabel text1 = new JLabel("PLEASE ENER YOUR AMOUNT ");
        text1.setBounds(320, 270, 700, 55);
        text1.setForeground(Color.white);
        text1.setFont(new Font("System", Font.BOLD, 20));
        image.add(text1);

        amount = new JTextField();
        amount.setFont(new Font("Arial", Font.BOLD, 22));
        amount.setBounds(270, 340, 420, 25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(520, 400, 100, 30);
        withdraw.setBackground(Color.white);
        withdraw.setForeground(Color.black);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(320, 400, 100, 30);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        image.add(back);

        setSize(1500, 1000);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == withdraw) {
                String number = amount.getText();
                Date date = new Date();

                if (number.equals("")) {
                    JOptionPane.showConfirmDialog(null, "Please enter the amount you want to withdraw");
                } else {

                    Conn c = new Conn();

                    ResultSet rs = c.s.executeQuery("select*from bank where pin = '" + pinnumber + "'");
                    int balance = 0;
                    while (rs.next()) {

                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (balance < Integer.parseInt(number)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    String query = " insert into bank values ('" + pinnumber + "' , '" + date + "', 'withdraw' , '" + number + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdraw Successfully");

                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }

            } else if (ae.getSource() == back) {
                setVisible(false);

                new Transaction(pinnumber).setVisible(true);
            }

        } catch (Exception e) {

            System.out.println(e);

        }
    }

    public static void main(String args[]) {
        new withdrawl("").setVisible(true);

    }
}
