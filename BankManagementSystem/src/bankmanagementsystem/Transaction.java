package BMJ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, withdraw, ministatement, pinchange, fastcash, balanceenquiry, exit ;
    String pinnumber;

    public Transaction(String pinnumber) {
        this.pinnumber = pinnumber;
//        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1450, 820, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
//        image.setBounds(0, 0, 1500, 1000);  
        add(image);  //for add label on the frame

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(350, 230, 700, 55);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 20));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(350, 300, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Cash Withdraw");
        withdraw.setBounds(550, 300, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(350, 340, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(550, 340, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(350, 380, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Check Balance");
        balanceenquiry.setBounds(550, 380, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Exit");
        exit.setBounds(550, 420, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        

        setSize(1500, 1000);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        setVisible(false);
        new Login().setVisible(true);

        if (ae.getSource() == exit) {
            System.exit(0);

        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposite(pinnumber).setVisible(true);

        } else if (ae.getSource() == withdraw) {
            setVisible(false);
            new withdrawl(pinnumber).setVisible(true);

        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);

        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);

        } else if (ae.getSource() == balanceenquiry) {
            setVisible(false);
            new balanceEnquiry(pinnumber).setVisible(true);

        } else if (ae.getSource() == ministatement) {
            new miniStatement(pinnumber).setVisible(true);
            
        }
    }

    public static void main(String args[]) {
        new Transaction("").setVisible(true);
    }
}
