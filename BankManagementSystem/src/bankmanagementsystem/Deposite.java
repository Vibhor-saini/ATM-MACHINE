package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposite extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit, back;
    String pinnumber;
    JLabel text;

    public Deposite(String pinnumber) {
        this.pinnumber = pinnumber;

//        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(320, 220, 700, 55);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 20));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Arial", Font.BOLD, 22));
        amount.setBounds(270, 300, 420, 25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(520, 380, 100, 30);
        deposit.setBackground(Color.white);
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(320, 380, 100, 30);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        image.add(back);

        setSize(1500, 1000);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = amount.getText();  //t1
            Date date = new Date();

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {

                try {
                    Conn conn = new Conn();
                    String query = " insert into bank values ('" + pinnumber + "' , '" + date + "', 'Deposit' , '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);

            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Deposite("");

    }
}
