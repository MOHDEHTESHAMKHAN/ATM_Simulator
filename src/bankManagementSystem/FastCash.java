package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit, withdrawl, balanceEnquiry, fastcash, miniStatement,exit, pinChange;
    String pinnumber;
    FastCash( String pinnumber) {
        this.pinnumber = pinnumber;

        setTitle("Fast Cash");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);


        JLabel text = new JLabel("Please select Withdrawl amount.");
        text.setBounds(210, 320, 700, 30);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);


        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 415, 150, 35);
        deposit.setFont(new Font("Railway", Font.BOLD, 14));
        deposit.addActionListener(this);
        image.add(deposit);


        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355, 415, 150, 35);
        withdrawl.setFont(new Font("Railway", Font.BOLD, 14));
        withdrawl.addActionListener(this);
        image.add(withdrawl);


        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 450, 150, 35);
        fastcash.setFont(new Font("Railway", Font.BOLD, 14));
        fastcash.addActionListener(this);
        image.add(fastcash);


        miniStatement = new JButton("Rs 2000");
        miniStatement.setBounds(355, 450, 150, 35);
        miniStatement.setFont(new Font("Railway", Font.BOLD, 14));
        miniStatement.addActionListener(this);
        image.add(miniStatement);


        pinChange = new JButton("Rs 5000");
        pinChange.setBounds(170, 485, 150, 35);
        pinChange.setFont(new Font("Railway", Font.BOLD, 14));
        pinChange.addActionListener(this);
        image.add(pinChange);


        balanceEnquiry = new JButton("Rs 10000");
        balanceEnquiry.setBounds(355, 485, 150, 35);
        balanceEnquiry.setFont(new Font("Railway", Font.BOLD, 14));
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);


        exit = new JButton("Back");
        exit.setBounds(355, 520, 150, 35);
        exit.setFont(new Font("Railway", Font.BOLD, 14));
        exit.addActionListener(this);
        image.add(exit);



        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

}

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText();
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient balance in Account.");
                    return;
                }else {
                    Date date = new Date();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs : " + amount + " Debited Successfully!");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}

