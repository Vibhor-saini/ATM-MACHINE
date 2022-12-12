package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField NameTextField, fnameTextField, emailTextField, AddressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;

    SignupOne() {

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(870, 40, 250, 500);

        add(label);  //for add label on the frame

        Random ran = new Random();
        random = (Math.abs(ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        JLabel Name = new JLabel("Name:");
        Name.setFont(new Font("Raleway", Font.BOLD, 20));
        Name.setBounds(100, 140, 100, 30);

        add(Name);

        NameTextField = new JTextField();
        NameTextField.setBounds(300, 140, 400, 30);
        NameTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(NameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 190, 400, 30);
        fnameTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setFont(new Font("Arial", Font.BOLD, 15));
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 90, 30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(300, 340, 400, 30);
        emailTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel Address = new JLabel("Address:");
        Address.setFont(new Font("Raleway", Font.BOLD, 20));
        Address.setBounds(100, 440, 200, 30);
        add(Address);

        AddressTextField = new JTextField();
        AddressTextField.setBounds(300, 440, 400, 30);
        AddressTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(AddressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setBounds(300, 490, 400, 30);
        cityTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(300, 540, 400, 30);
        stateTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(stateTextField);

        JLabel pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 590, 200, 30);

        add(pin);

        pinTextField = new JTextField();
        pinTextField.setBounds(300, 590, 400, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(pinTextField);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);

        add(next);

        getContentPane().setBackground(Color.white);

        setSize(1500, 1000);
//        setLocation(200,0);

        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;   //long
        String name = NameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String address = AddressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";

        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailTextField.getText();
        String marital = "null";
        if (married.isSelected()) {
            marital = "Married";

        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }

        try {

            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");

            } else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");

            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");

            } else if (gender.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");

            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");

            } else if (marital.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");

            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");

            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");

            } else if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");

            } else if (pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('" + formno + "' , '" + name + "' , '" + fname + "' , '" + dob + "' , '" + gender + "' , '" + email + "' ,'" + marital + "' , '" + address + "' , '" + city + "' , '" + state + "' , '" + pin + "' )";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signuptwo(formno).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void main(String args[]) {

        new SignupOne().setVisible(true);
    }
}
