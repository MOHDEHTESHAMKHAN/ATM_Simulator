package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pinnumber;

    MiniStatement( String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        setTitle("Mini Statement");

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 300);
        add(mini);


        JLabel bank = new JLabel("AXIS BANK");
        bank.setBounds(155, 20, 100, 20);
        bank.setFont(new Font("System", Font.BOLD, 16));
        add(bank);


        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        card.setFont(new Font("Railway", Font.BOLD, 14));
        add(card);


        JLabel balance = new JLabel();
        balance.setBounds(20, 450, 300, 20);
        balance.setFont(new Font("System", Font.BOLD, 14));
        add(balance);


        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while (rs.next()){
                card.setText("Card Number : " + rs.getString("cardnumber").substring(0, 4) + "-XXXX-XXXX-" + rs.getString("cardnumber").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }


        try {
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Account balance is Rs : " + bal + ".");
        }catch (Exception e){
            System.out.println(e);
        }



        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
