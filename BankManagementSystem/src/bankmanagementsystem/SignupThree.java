package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;     //for font
import java.awt.Image;
import javax.swing.*;    // for jframe
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {   //class name

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    public SignupThree(String formno) {     // constructer
        this.formno = formno;
        setLayout(null);    // for use setbounds

        JLabel l1 = new JLabel("Page 3: Account Details");   // for make label
        l1.setFont(new Font("Railway", Font.BOLD, 22));
        l1.setBounds(260, 20, 400, 40);    // for set label boundries on frame (left , up ,length , hight)
        add(l1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(870, 40, 250, 500);

        add(label);  //for add label on the frame

        JLabel type = new JLabel("Account Type");   // for make label
        type.setFont(new Font("Railway", Font.BOLD, 22));
        type.setBounds(100, 100, 200, 30);    // for set label boundries on frame (left , up ,length , hight)
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Railway", Font.BOLD, 16));
        r1.setBackground(Color.white);
        r1.setBounds(100, 150, 150, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("Railway", Font.BOLD, 16));
        r2.setBackground(Color.white);
        r2.setBounds(350, 150, 250, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Railway", Font.BOLD, 16));
        r3.setBackground(Color.white);
        r3.setBounds(100, 180, 150, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setFont(new Font("Railway", Font.BOLD, 16));
        r4.setBackground(Color.white);
        r4.setBounds(350, 180, 250, 20);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();   // use for select One in single time.
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number");   // for make label
        card.setFont(new Font("Railway", Font.BOLD, 22));
        card.setBounds(100, 240, 200, 30);    // for set label boundries on frame (left , up ,length , hight)
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXX-4534");   // for make label
        number.setFont(new Font("Railway", Font.BOLD, 22));
        number.setBounds(330, 240, 300, 30);    // for set label boundries on frame (left , up ,length , hight)
        add(number);

        JLabel cdetail = new JLabel(" Your 16 Digit Card Number");   // for make label
        cdetail.setFont(new Font("Railway", Font.BOLD, 12));
        cdetail.setBounds(100, 270, 300, 15);    // for set label boundries on frame (left , up ,length , hight)
        add(cdetail);

        JLabel pin = new JLabel("PIN");   // for make label
        pin.setFont(new Font("Railway", Font.BOLD, 22));
        pin.setBounds(100, 300, 200, 30);    // for set label boundries on frame (left , up ,length , hight)
        add(pin);

        JLabel pdetail = new JLabel(" Your 4 Digit Password");   // for make label
        pdetail.setFont(new Font("Railway", Font.BOLD, 12));
        pdetail.setBounds(100, 330, 300, 15);    // for set label boundries on frame (left , up ,length , hight)
        add(pdetail);

        JLabel pnumber = new JLabel("XXXX");   // for make label
        pnumber.setFont(new Font("Railway", Font.BOLD, 22));
        pnumber.setBounds(330, 300, 300, 30);    // for set label boundries on frame (left , up ,length , hight)
        add(pnumber);

        JLabel services = new JLabel("Services Required");   // for make label
        services.setFont(new Font("Railway", Font.BOLD, 22));
        services.setBounds(100, 400, 200, 30);    // for set label boundries on frame (left , up ,length , hight)
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setBounds(100, 440, 150, 30);
        c1.setFont(new Font("Railway", Font.BOLD, 16));
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setBounds(350, 440, 200, 30);
        c2.setFont(new Font("Railway", Font.BOLD, 16));
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setBounds(100, 480, 200, 30);
        c3.setFont(new Font("Railway", Font.BOLD, 16));
        add(c3);

        c4 = new JCheckBox("Email & SMS Alert ");
        c4.setBackground(Color.white);
        c4.setBounds(350, 480, 200, 30);
        c4.setFont(new Font("Railway", Font.BOLD, 16));
        add(c4);

        c5 = new JCheckBox("Cheque Book ");
        c5.setBackground(Color.white);
        c5.setBounds(100, 520, 200, 30);
        c5.setFont(new Font("Railway", Font.BOLD, 16));
        add(c5);

        c6 = new JCheckBox("E-Statement ");
        c6.setBackground(Color.white);
        c6.setBounds(350, 520, 150, 30);
        c6.setFont(new Font("Railway", Font.BOLD, 16));
        add(c6);

        c7 = new JCheckBox("I Hereby declares that the above entered details are correct to the best of my knowedge.");
        c7.setBackground(Color.white);
        c7.setBounds(100, 560, 600, 030);
        c7.setFont(new Font("Railway", Font.BOLD, 12));
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Railway", Font.BOLD, 14));
        submit.setBounds(250, 620, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Railway", Font.BOLD, 14));
        cancel.setBounds(420, 620, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);    //for white frame
        setSize(1500, 1000);
//        setLocation(200,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposite Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Reccuring Deposit Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5045647900000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (c1.isSelected()) {

                facility = facility + "ATM Card";

            } else if (c2.isSelected()) {

                facility = facility + " Internet Banking";

            } else if (c3.isSelected()) {

                facility = facility + " Mobile Banking";

            } else if (c4.isSelected()) {

                facility = facility + " Email & SMS Alert ";

            } else if (c5.isSelected()) {

                facility = facility + " Cheque Book";

            } else if (c6.isSelected()) {

                facility = facility + " E- Statement";
            }

            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "AccountType is Required");
                } else {

                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('" + formno + "' , '" + accountType + "', '" + cardnumber + "' ,'" + pinnumber + "' , '" + facility + "')";
                    String query2 = "insert into login values('" + formno + "' , '" + cardnumber + "' ,'" + pinnumber + "')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "(Card Number):-  " + cardnumber + " (Pin):-  " + pinnumber);
                    new Deposite(pinnumber).setVisible(true);
                    setVisible(false);
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);

        }

    }

    public static void main(String args[]) {
        new SignupThree("").setVisible(true);
    }
}
