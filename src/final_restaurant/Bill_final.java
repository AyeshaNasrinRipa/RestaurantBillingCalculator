
package final_restaurant;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Bill_final extends JFrame{
    private Container c;
    private static Scanner scanner;
    public static String[] Item=new String[50];
     public static String[] price=new String[50];
   
    JLabel subtotal,vat,discount,total;
    JTextArea subtotalarea,vatarea,discountarea,totalarea;
    JButton totalbutton,resetbutton,backbutton,generatebutton;
     double totalbill=0;
     double bill=0,totalvat=0,totaldiscount=0;
     int flagforEnter=0;

    FlowLayout fl=new FlowLayout(FlowLayout.LEFT);
    Font font=new Font("Arial",Font.BOLD,20);
    Bill_final(){
        initcomponent();
    }
    public void initcomponent(){
        c=this.getContentPane();
           c.setLayout(null);
           c.setBackground(Color.decode("#F0F3F4"));
           
           JPanel panel1=new JPanel();
           panel1.setLayout(fl);
           panel1.setPreferredSize(new Dimension(300, 100));
           panel1.setBackground(Color.yellow);
           c.add(panel1);
           
           int len=ReadRecord("Data.txt");
           System.out.println(len);
           JCheckBox checkbox[]=new JCheckBox[len];
           JLabel label[]=new JLabel[len];
           JTextArea textarea[]=new JTextArea[len];
           for(int i=0;i<len;i++){
           checkbox[i]=new JCheckBox();
           panel1.add(checkbox[i]);
           
           label[i]=new JLabel(""+Item[i]+"("+price[i]+")");
           label[i].setPreferredSize(new Dimension(220, 50));
           label[i].setFont(font);
           panel1.add(label[i]);
           textarea[i]=new JTextArea(3,14);
           textarea[i].setEnabled(false);
           panel1.add(textarea[i]);
           panel1.setPreferredSize(new Dimension(300, 500+i*20));
           }
           
        JScrollPane scrollPane = new JScrollPane(panel1);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 450, 500);
        c.add(scrollPane);
          
           for(int i=0;i<len;i++){
               final int iValue = i;
               checkbox[i].addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent arg0) {
                       if(checkbox[iValue].isSelected()){
                     textarea[iValue].setEnabled(true);
                     flagforEnter=0;
                       }
                       else{
                           textarea[iValue].setEnabled(false);   
                       }
                   }
               });
           }
           for(int i=0;i<len;i++){
               final int j= i;
              textarea[i].addKeyListener(new KeyAdapter() {
             public void keyPressed(KeyEvent ke) {
            String value = textarea[j].getText();
           // int l = value.length();
            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
               textarea[j].setEditable(true);
            } else {
               textarea[j].setEditable(false);
            }
            if (ke.getKeyChar() ==KeyEvent.VK_ENTER ){
                
               double y=Double.parseDouble(price[j]);
               if(textarea[j].getText().isEmpty()){
                 bill=0;
                 checkbox[j].setSelected(false);
                 textarea[j].setText(null);
                 textarea[j].setEnabled(false);
                
               }
               else{
                bill=Double.parseDouble(textarea[j].getText())*y;
               }
               if(flagforEnter==0){
                totalbill=totalbill+bill;
                System.out.println(totalbill);
                String s=String.valueOf(totalbill);
                subtotalarea.setText(s);
                flagforEnter=1;
               }
               else{
                   
               }
            }
            if (ke.getKeyChar() ==KeyEvent.VK_BACK_SPACE ){
                if(textarea[j].getText().isEmpty()){
                    
                }
                else{
                textarea[j].setText(""); 
                textarea[j].setEditable(true);
                totalbill=totalbill-bill;
                System.out.println(totalbill);
                String s=String.valueOf(totalbill);
                subtotalarea.setText(s);
                flagforEnter=0;
                }
            }
         }
      });
              
           }
           subtotal=new JLabel("Sub-Total:");
           subtotal.setFont(font);
           subtotal.setBounds(500, 20, 100, 50);
           c.add(subtotal);
           subtotalarea=new JTextArea();
           subtotalarea.setFont(font);
           subtotalarea.setEditable(false);
           subtotalarea.setBounds(700, 20, 150, 40);
           c.add(subtotalarea);
           
           vat=new JLabel("Vat(%):");
           vat.setFont(font);
           vat.setBounds(500,80, 100, 50);
           c.add(vat);
           vatarea=new JTextArea();
           vatarea.setFont(font);
           //vatarea.setEditable(false);
           vatarea.setBounds(700,80, 150, 40);
           c.add(vatarea);
           
           discount=new JLabel("Discount(%):");
           discount.setFont(font);
           discount.setBounds(500,140, 150, 50);
           c.add(discount);
           discountarea=new JTextArea();
           discountarea.setFont(font);
           //discountarea.setEditable(false);
           discountarea.setBounds(700,140, 150, 40);
           c.add(discountarea);
           
           total=new JLabel("Total:");
           total.setFont(font);
           total.setBounds(500,200, 100, 50);
           c.add(total);
           totalarea=new JTextArea();
           totalarea.setFont(font);
           totalarea.setEditable(false);
           totalarea.setBounds(700,200, 150, 40);
           c.add(totalarea);
           
           backbutton=new JButton("Back");
           backbutton.setFont(font);
           backbutton.setBounds(0, 500, 200, 50);
            c.add(backbutton);
          
           totalbutton=new JButton("Total");
            totalbutton.setFont(font);
            totalbutton.setBounds(220, 500, 200, 50);
            c.add(totalbutton);
            
            generatebutton=new JButton("Generate Bill");
            generatebutton.setFont(font);
            generatebutton.setBounds(440, 500, 200, 50);
            c.add(generatebutton);
            resetbutton=new JButton("Reset");
            resetbutton.setFont(font);
            resetbutton.setBounds(660, 500, 200, 50);
            c.add(resetbutton);
           
           vatarea.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent ke) {
            String value = vatarea.getText();
            int l = value.length();
            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
               vatarea.setEditable(true);
            } else {
               vatarea.setEditable(false);
            }
         }
      });
           
            discountarea.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent ke) {
            String value = discountarea.getText();
            int l = value.length();
            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
               discountarea.setEditable(true);
            } else {
               discountarea.setEditable(false);
            }
         }
      });
            
            backbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               Main frame=new Main();
             frame.setTitle("Restaurent Billing");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            frame.setBounds(600, 150, 500,600);
             frame.setResizable(false);
            dispose();
            }
        });
            totalbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               totalvat=0;
               totaldiscount=0;
               if(vatarea.getText().isEmpty()){
                   totalvat=0;
               }
               else{
                   totalvat=Double.parseDouble(vatarea.getText());
               }
               if(discountarea.getText().isEmpty()){
                   totaldiscount=0;
               }
               else{
                   totaldiscount=Double.parseDouble(discountarea.getText());
               }
              totalvat=(totalbill*(totalvat/100));
                System.out.println(totalvat);
             totaldiscount=(totalbill*(totaldiscount/100));
              totalbill=(totalbill+totalvat)-totaldiscount;
              System.out.println(totalbill);
              totalarea.setText(Double.toString(totalbill));
            }
        });
            resetbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               for(int i=0;i<len;i++){
                   checkbox[i].setSelected(false);
                   textarea[i].setText("");
                   totalbill=0; bill=0;totalvat=0;totaldiscount=0;
                   subtotalarea.setText("");vatarea.setText("");discountarea.setText("");totalarea.setText("");
                   flagforEnter=0;
               }
            }
        });
            generatebutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               Generate_Bill bill=new Generate_Bill();
               Generate_Bill.textarea1.append("\n IIT CAFE \n");
               for(int i=0;i<len;i++){
                   
                 if(checkbox[i].isSelected()){
                     double y=0;
                     if(textarea[i].getText().isEmpty()){
                         y=0;
                     }
                     else{
                   String s=textarea[i].getText();
                   y=Double.valueOf(s);
                     }
                  Generate_Bill.textarea1.append("\n"+Item[i]+"("+price[i]+") X"+textarea[i].getText()+"                      "+y*Double.parseDouble(price[i].toString()));
               }
               }
                Generate_Bill.textarea1.append("\nVat:                                         "+totalvat);
                Generate_Bill.textarea1.append("\nDiscount:                                "+totaldiscount);
                Generate_Bill.textarea1.append("\nTotal:                                      "+totalbill);
               bill.setVisible(true);
               bill.setTitle("Bill");
               bill.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               bill.setBounds(600, 150, 500, 650);
               dispose();
            }
        });  
          
    }
    
     public static int ReadRecord(String filepath){
    int i=0;
    try {
    scanner=new Scanner(new File(filepath));
    scanner.useDelimiter("[,\n]");
    while(scanner.hasNext()){
    Item[i]=scanner.next();
    price[i]=scanner.next();
    i++;
    }
    scanner.close();
    System.out.println(i);
    } catch (FileNotFoundException ex) {
    
    }
    return i;
    }
    
    public static void main(String[] args) {
       Bill_final frame=new Bill_final();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(600, 150, 900, 600);
    }
}
