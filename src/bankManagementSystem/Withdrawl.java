package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    JButton withdraw, back;
    JTextField amount;
    String pinnumber;
    Withdrawl(String pinnumber){
        try{
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }catch(Exception e){
            e.printStackTrace();
        }

        setTitle("Withdraw");
        setLayout(null);


        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);


        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Railway", Font.BOLD, 16));
        text.setBounds(180, 300, 400, 20);
        image.add(text);


        amount = new JTextField();
        amount.setFont(new Font("System", Font.BOLD, 22));
        amount.setBounds(180, 350, 310, 30);
        image.add(amount);


        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 35);
        withdraw.setFont(new Font("Railway", Font.BOLD, 18));
        withdraw.addActionListener(this);
        image.add(withdraw);


        back = new JButton("Back");
        back.setBounds(355, 520, 150, 35);
        back.setFont(new Font("Railway", Font.BOLD, 18));
        back.addActionListener(this);
        image.add(back);



        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter some amount.");
            }else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs : " + number + " Withdraw successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
