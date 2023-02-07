
package final_restaurant;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Add_Item extends JFrame{
    private Container c;
    private  JButton add,back;
    private JLabel item,price;
    private JTextArea itemarea,pricearea;
    
    public static int  height,width;
    FlowLayout layout=new FlowLayout(FlowLayout.LEFT);
    Font font=new Font("Arial",Font.BOLD,20);
    
    Add_Item(){
        initcomponent();
    }
    public void initcomponent(){
        c=this.getContentPane();
        c.setLayout(layout);
        layout.setVgap(30);
        layout.setHgap(50);
        
       item=new JLabel("Item Name:");
       item.setFont(font);
       c.add(item);
       
       itemarea=new JTextArea(2,10);
        itemarea.setFont(font);
       c.add(itemarea);
       
       price=new JLabel("Item Price: ");
       price.setFont(font);
       c.add(price);
       
       pricearea=new JTextArea(2,10);
       pricearea.setFont(font);
       c.add(pricearea);
       
        add=new JButton(" Add Item ");
       add.setFont(font);
       c.add(add);
       
       back=new JButton("    Back   ");
       back.setFont(font);
       c.add(back);
       
       add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                String filepath="Data.txt";
                String item=itemarea.getText();
                System.out.println(item);
                String price=pricearea.getText();
                System.out.println(price);
                File_Basic f=new File_Basic();
                Boolean x=f.SearchRecord(filepath,item);
                if(x){
                    JOptionPane.showMessageDialog(null, "Item already added in Menu");
                }
                else{
                f.saveRecord(item,price,filepath);
                System.out.println("Done");
                }
            }
       });     
       
       pricearea.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent ke) {
            String value = pricearea.getText();
           // int l = value.length();
            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
               pricearea.setEditable(true);
            } else {
               pricearea.setEditable(false);
            }
             if (ke.getKeyChar() ==KeyEvent.VK_BACK_SPACE ){
               
            }
         }
      });
       
      back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               Main frame=new Main();
              frame.setTitle("Restaurent Billing");
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              frame.setVisible(true);
              frame.setBounds(600, 150, 500,600);
               frame.setResizable(false);
              dispose();
            }
        });
    }
    public static void main(String[] args) {
        Add_Item frame=new Add_Item();
        frame.setTitle("Add new Item");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(650, 250, 450, 350);  
         frame.setResizable(false);
    }
    
   
    
}
