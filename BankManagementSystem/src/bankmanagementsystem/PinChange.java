package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton back, change;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
//        image.setBounds(0, 0, 1500, 1000);  
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(380, 220, 700, 55);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 20));
        image.add(text);

        JLabel pintext = new JLabel(" New PIN");
        pintext.setBounds(280, 300, 180, 25);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System", Font.BOLD, 20));
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Railway", Font.BOLD, 25));
        pin.setBounds(460, 300, 180, 25);
        image.add(pin);

        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setBounds(280, 330, 180, 25);
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System", Font.BOLD, 20));
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Railway", Font.BOLD, 25));
        repin.setBounds(460, 330, 180, 25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(290, 400, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(470, 400, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(1500, 1000);
//        setLocation(200,0);
//setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter New Pin");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re- Enter New Pin");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '" + rpin + "' where pin = '" + pinnumber + "'";
                String query2 = "update login set pin = '" + rpin + "' where pin = '" + pinnumber + "'";
                String query3 = "update signupthree set pin = '" + rpin + "' where pin = '" + pinnumber + "'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Change Successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);

            } catch (Exception e) {
                System.err.println(e);
            }
        } else {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
