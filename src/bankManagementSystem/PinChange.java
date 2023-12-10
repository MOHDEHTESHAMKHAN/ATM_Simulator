package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JButton change, back;
    JPasswordField pin, repin;
    String pinnumber;
    PinChange(String pinnumber){
        setLayout(null);
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900 ,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0 , 900, 900);
        add(image);


        JLabel text = new JLabel("Change your Pin Number.");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(230, 300, 500, 35);
        image.add(text);


        JLabel pintext = new JLabel("New Pin :");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(243, 335, 180, 25);
        image.add(pintext);


        pin = new JPasswordField();
        pin.setFont(new Font("Railway", Font.BOLD, 25));
        pin.setBounds(330, 335, 180, 25);
        image.add(pin);


        JLabel repintext = new JLabel("Re-Enter New Pin :");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 370, 200, 25);
        image.add(repintext);


        repin = new JPasswordField();
        repin.setFont(new Font("Railway", Font.BOLD, 25));
        repin.setBounds(330, 370, 180, 25);
        image.add(repin);


        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 35);
        change.setFont(new Font("System", Font.BOLD, 16));
        change.addActionListener(this);
        image.add(change);


        back = new JButton("BACK");
        back.setFont(new Font("Railway", Font.BOLD, 16));
        back.setBounds(355, 520, 150, 35);
        back.addActionListener(this);
        image.add(back);


        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change){
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if (!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, " Entered PIN does not match!");
                    return;
                }

                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter New PIN!");
                }

                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-enter New PIN!");
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed Successfully!");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            }
            catch (Exception e){
                System.out.println(e);
            }
        } else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
