package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Signuptwo extends JFrame implements ActionListener {

    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, income, education;
    String formno;

    public Signuptwo(String formno) {

        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(870, 40, 250, 500);

        add(label);  //for add label on the frame

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        additionalDetails.setBounds(330, 80, 400, 30);
        add(additionalDetails);

        JLabel Name = new JLabel("Religion:");
        Name.setFont(new Font("Raleway", Font.BOLD, 20));
        Name.setBounds(100, 140, 100, 30);
        add(Name);

        String valreligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valreligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String valcategory[] = {"General", "OBC", "Sikh", "SC", "ST", "Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String incomecategory[] = {"Null", "< 1.5L", "< 2.5L", "< 5L", "< 10L", "Upto 10L"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);

        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 315, 200, 30);
        add(email);

        String educationvalues[] = {"Non-Graduate", "Graduate", "Post-Graduation", "Doctrate", "Diploma", "Others"};
        education = new JComboBox(educationvalues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);

        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        String occupationvalue[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationvalue);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel panno = new JLabel("PAN Number:");
        panno.setFont(new Font("Raleway", Font.BOLD, 20));
        panno.setBounds(100, 440, 200, 30);
        add(panno);

        pan = new JTextField();
        pan.setBounds(300, 440, 400, 30);
        pan.setFont(new Font("Arial", Font.BOLD, 20));
        add(pan);

        JLabel aadharno = new JLabel("Aadhar Number:");
        aadharno.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharno.setBounds(100, 490, 200, 30);
        add(aadharno);

        aadhar = new JTextField();
        aadhar.setBounds(300, 490, 400, 30);
        aadhar.setFont(new Font("Arial", Font.BOLD, 20));
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup smaritalGroup = new ButtonGroup();
        smaritalGroup.add(syes);
        smaritalGroup.add(sno);

        JLabel pin = new JLabel("Existing Account:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 590, 200, 30);
        add(pin);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup emaritalGroup = new ButtonGroup();
        emaritalGroup.add(syes);
        emaritalGroup.add(sno);

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
        setVisible(true);
//         setUndecorated(true);

    }

    public void actionPerformed(ActionEvent ae) {

        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";

        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String existingaccount = "null";
        if (eyes.isSelected()) {
            existingaccount = "Yes";

        } else if (eno.isSelected()) {
            existingaccount = "No";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {
            if (pan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");

            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "' , '" + sreligion + "' , '" + scategory + "' , '" + sincome + "' , '" + seducation + "' , '" + soccupation + "' ,'" + span + "' , '" + saadhar + "' , '" + seniorcitizen + "' , '" + existingaccount + "')";
                c.s.executeUpdate(query);

                //signup3 object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void main(String args[]) {

        new Signuptwo("").setVisible(true);
    }
}
