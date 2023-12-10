package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit, withdrawl, balanceEnquiry, fastcash, miniStatement,exit, pinChange;
    String pinnumber;
    Transactions( String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("AUTOMATIC TELLER MACHINE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);


        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210, 320, 700, 30);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);


        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 35);
        deposit.setFont(new Font("Railway", Font.BOLD, 14));
        deposit.addActionListener(this);
        image.add(deposit);


        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355, 415, 150, 35);
        withdrawl.setFont(new Font("Railway", Font.BOLD, 14));
        withdrawl.addActionListener(this);
        image.add(withdrawl);


        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 35);
        fastcash.setFont(new Font("Railway", Font.BOLD, 14));
        fastcash.addActionListener(this);
        image.add(fastcash);


        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 450, 150, 35);
        miniStatement.setFont(new Font("Railway", Font.BOLD, 14));
        miniStatement.addActionListener(this);
        image.add(miniStatement);


        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 485, 150, 35);
        pinChange.setFont(new Font("Railway", Font.BOLD, 14));
        pinChange.addActionListener(this);
        image.add(pinChange);


        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355, 485, 150, 35);
        balanceEnquiry.setFont(new Font("Railway", Font.BOLD, 14));
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);


        exit = new JButton("Exit");
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
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == miniStatement) {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
