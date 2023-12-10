package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno ;
    JComboBox religion, occupation, category, income, education;
    String formno;




        SignupTwo(String formno) {
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            }catch(Exception e){
                e.printStackTrace();
            }
            this.formno = formno;
            setLayout(null);
            setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2 ");


            JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
            additionalDetails.setFont(new Font("Railway", Font.BOLD, 22));
            additionalDetails.setBounds(290,80,400,30);
            add(additionalDetails);

            JLabel name = new JLabel("Religion : ");
            name.setFont(new Font("Railway", Font.BOLD, 20));
            name.setBounds(100,140,120,30);
            add(name);
            String valReligion[] = {"Hindu","Muslim", "Sikh", "Christian", "Other"};
            religion = new JComboBox(valReligion);
            religion.setFont(new Font("Railway", Font.BOLD, 14));
            religion.setBounds(300, 140 , 400, 30);
            religion.setBackground(Color.WHITE);
            religion.setOpaque(true);
            add(religion);


            JLabel fname = new JLabel("Category : ");
            fname.setFont(new Font("Railway", Font.BOLD, 20));
            fname.setBounds(100,190,200,30);
            add(fname);
            String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
            category = new JComboBox(valCategory);
            category.setFont(new Font("Railway", Font.BOLD, 14));
            category.setBounds(300, 190 , 400, 30);
            category.setBackground(Color.WHITE);
            category.setOpaque(true);
            add(category);

            JLabel dob = new JLabel("Income : ");
            dob.setFont(new Font("Railway", Font.BOLD, 20));
            dob.setBounds(100,240,200,30);
            add(dob);
            String incomecategory[] = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
            income = new JComboBox(incomecategory);
            income.setFont(new Font("Railway", Font.BOLD, 14));
            income.setBounds(300, 240 , 400, 30);
            income.setBackground(Color.WHITE);
            income.setOpaque(true);
            add(income);


            JLabel gender = new JLabel("Educational ");
            gender.setFont(new Font("Railway", Font.BOLD, 20));
            gender.setBounds(100,300,200,30);
            add(gender);


            JLabel email = new JLabel("Qualification : ");
            email.setFont(new Font("Railway", Font.BOLD, 20));
            email.setBounds(100,335,200,30);
            add(email);
            String educationValues[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other"};
            education = new JComboBox(educationValues);
            education.setFont(new Font("Railway", Font.BOLD, 14));
            education.setBounds(300, 340 , 400, 30);
            education.setBackground(Color.WHITE);
            education.setOpaque(true);
            add(education);

            JLabel marital = new JLabel("Occupation : ");
            marital.setFont(new Font("Railway", Font.BOLD, 20));
            marital.setBounds(100,390,200,30);
            add(marital);
            String occupationValues[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired","Other"};
            occupation = new JComboBox(occupationValues);
            occupation.setFont(new Font("Railway", Font.BOLD, 14));
            occupation.setBounds(300, 390 , 400, 30);
            occupation.setBackground(Color.WHITE);
            occupation.setOpaque(true);
            add(occupation);


            JLabel address = new JLabel("PAN Number : ");
            address.setFont(new Font("Railway", Font.BOLD, 20));
            address.setBounds(100,440,200,30);
            add(address);
            pan = new JTextField();
            pan.setFont(new Font("Railway", Font.BOLD, 14));
            pan.setBounds(300, 440 , 400, 30);
            add(pan);

            JLabel city = new JLabel("Aadhar Number : ");
            city.setFont(new Font("Railway", Font.BOLD, 20));
            city.setBounds(100,490,200,30);
            add(city);
            aadhar = new JTextField();
            aadhar.setFont(new Font("Railway", Font.BOLD, 14));
            aadhar.setBounds(300, 490 , 400, 30);
            add(aadhar);

            JLabel state = new JLabel("Senior Citizen : ");
            state.setFont(new Font("Railway", Font.BOLD, 20));
            state.setBounds(100,540,200,30);
            add(state);
            syes = new JRadioButton("Yes");
            syes.setBounds(300,540,100,30);
            syes.setBackground(Color.WHITE);
            add(syes);

            sno = new JRadioButton("No");
            sno.setBounds(450,540, 130,30);
            sno.setBackground(Color.WHITE);
            add(sno);

            ButtonGroup maritalgroup = new ButtonGroup();
            maritalgroup.add(syes);
            maritalgroup.add(sno);


            JLabel pincode = new JLabel("Existing Account : ");
            pincode.setFont(new Font("Railway", Font.BOLD, 20));
            pincode.setBounds(100,590,200,30);
            add(pincode);
            eyes = new JRadioButton("Yes");
            eyes.setBounds(300,590,100,30);
            eyes.setBackground(Color.WHITE);
            add(eyes);

            eno = new JRadioButton("No");
            eno.setBounds(450,590, 130,30);
            eno.setBackground(Color.WHITE);
            add(eno);

            ButtonGroup existingAccount = new ButtonGroup();
            existingAccount.add(eyes);
            existingAccount.add(eno);



            next = new JButton("Next");
            next.setBackground(Color.BLACK);
            next.setOpaque(true);
            next.setForeground(Color.WHITE);
            next.setFont(new Font("Railway",Font.BOLD, 14));
            next.setBounds(620, 660, 80, 30);
            next.addActionListener(this);
            add(next);


            getContentPane().setBackground(Color.WHITE);
            setSize(850, 800);

            setLocation(350,10);

            setVisible(true);
        }

        public void actionPerformed(ActionEvent ae){
            String sreligion = (String) religion.getSelectedItem();
            String scategory = (String) category.getSelectedItem();
            String sincome = (String) income.getSelectedItem();
            String seducation = (String) education.getSelectedItem();
            String soccupation = (String) occupation.getSelectedItem();
            String seniorcitizen = "null";
            if (syes.isSelected()){
                seniorcitizen = "Yes";
            } else if (sno.isSelected()) {
                seniorcitizen = "No";
            }
            String existingaccount = "null";
            if (eyes.isSelected()){
                existingaccount = "Yes";
            } else if (eno.isSelected()) {
                existingaccount = "No";
            }
            String span = pan.getText();
            String saadhar = aadhar.getText();

            try {

               /*if-else (fname.equals("")) {
                   JOptionPane.showMessageDialog(null,"Father's name is required!");
               }
               if-else (dob.equals("")) {
                   JOptionPane.showMessageDialog(null,"DOB is required!");
               }

               /*else-if (gender.equals("")) {
                   JOptionPane.showMessageDialog(null,"Gender is required!");
               }
               if-else (email.equals("")) {
                   JOptionPane.showMessageDialog(null,"Email is required!");
               }
               else-if (marital.equals("")) {
                   JOptionPane.showMessageDialog(null,"Marital status is required!");
               }
               if-else (address.equals("")) {
                   JOptionPane.showMessageDialog(null,"Address is required!");
               }
               if-else (city.equals("")) {
                   JOptionPane.showMessageDialog(null,"City is required!");
               }
               if-else (state.equals("")) {
                   JOptionPane.showMessageDialog(null,"State is required!");
               }
               if-else (pincode.equals("")) {
                   JOptionPane.showMessageDialog(null,"Pincode is required!");
               }*/

                    Conn c = new Conn();
                    String query = "insert into signuptwo values ( '"+formno+"' , '"+sreligion+"' , '"+scategory+"' , '"+sincome+"' , '"+seducation+"' , '"+soccupation+"' , '"+span+"' , '"+saadhar+"' , '"+seniorcitizen+"' , '"+existingaccount+"')";
                    c.s.executeUpdate(query);

                    setVisible(false);
                    new SignupThree(formno).setVisible(true);

            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        public static void main(String[] args) {

            new SignupTwo("");
        }
    }


