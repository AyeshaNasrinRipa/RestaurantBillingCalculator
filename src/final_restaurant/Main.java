
package final_restaurant;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Main extends JFrame {
         private Container c;
         private JButton add,delete,bill,calculator;
         private JLabel labeladd,labelremove,labelbill,labelcalculator;
         public static FlowLayout fl=new FlowLayout(FlowLayout.LEFT);
         
         Font f=new Font("Arial",Font.BOLD,20);
    
         Main(){
             initcomponents();
         }
         public void initcomponents(){
             c=this.getContentPane();
             c.setLayout(null);
             c.setBackground(Color.decode("#F0F3F4"));
             
             ImageIcon Billpic =new ImageIcon(getClass().getResource("Bill.png"));
             ImageIcon addpic =new ImageIcon(getClass().getResource("Add_item.png"));
             ImageIcon removepic =new ImageIcon(getClass().getResource("remove_item.jpg"));
             ImageIcon Calculatorpic =new ImageIcon(getClass().getResource("calculator.png"));
             add=new JButton();
             add.setIcon(addpic);
             add.setBounds(20, 20, 200, 200);
             c.add(add);
             
             delete=new JButton();
             delete.setIcon(removepic);
             delete.setBounds(250, 20, 200, 200);
             c.add(delete);
             
             bill=new JButton();
             bill.setIcon(Billpic);
             bill.setBounds(20, 280, 200, 200);
             c.add(bill);
             
             calculator=new JButton();
             calculator.setIcon(Calculatorpic);
             calculator.setBounds(250, 280, 200, 200);
             c.add(calculator);
             
             labeladd=new JLabel("Add Item");
             labeladd.setBounds(50, 225, 200, 30);
             labeladd.setFont(f);
             c.add(labeladd);
             
              labelremove=new JLabel("Delete Item");
             labelremove.setBounds(260, 225, 200, 30);
             labelremove.setFont(f);
             c.add(labelremove);
             
             labelbill=new JLabel("Generate Bill");
             labelbill.setBounds(50, 485, 200, 30);
             labelbill.setFont(f);
             c.add(labelbill);
             
             labelcalculator=new JLabel("Calculator");
             labelcalculator.setBounds(260, 485, 200, 30);
             labelcalculator.setFont(f);
             c.add(labelcalculator);
          
             add.addActionListener(new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent ae) {
                     Add_Item frame=new Add_Item();
                    frame.setTitle("Add new Item");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setBounds(600, 150, 450, 350);
                     frame.setResizable(false);
                     dispose();
                 }
             });
             
             delete.addActionListener(new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent ae) {
                   Delete_item frame=new Delete_item();
                  frame.setTitle("Delete Item");
                  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   frame.setVisible(true);
                   frame.setBounds(600, 150,380, 350); 
                   frame.setResizable(false);
                   dispose();
                 }
             });
             
             bill.addActionListener(new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent ae) {
                     Bill_final frame=new Bill_final();
                      frame.setTitle("Generate Bill");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setBounds(600, 150, 900, 600);
                     frame.setResizable(false);
                    dispose();
                 }
             });
             calculator.addActionListener(new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent ae) {
                      Calculator frame=new Calculator();
                       frame.setTitle("Calculator");
                       frame.setVisible(true);
                      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                      frame.setBounds(600, 150, 480, 500);
                       frame.setResizable(false);
                      dispose();
                 }
             });
             
         }
         
         public static void main(String[] args) {
            Main frame=new Main();
            frame.setTitle("Restaurent Billing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setBounds(600, 150, 500,600);
            frame.setResizable(false);
    }
}
