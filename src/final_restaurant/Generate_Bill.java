
package final_restaurant;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Generate_Bill extends JFrame{
    private Container c;
    JButton back,print;
    public static JTextArea textarea1;
    Font font=new Font("Arial",Font.BOLD,20);
    Generate_Bill(){
        initcomponent();
    }
    public void initcomponent(){
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F0F3F4"));
        
        
        
        textarea1=new JTextArea();
        textarea1.setBounds(10, 10, 455, 500);
        textarea1.setFont(font);
        textarea1.setEditable(false);
        c.add(textarea1);
        
         back=new JButton("Back");
        back.setFont(font);
        back.setBounds(10, 540, 100, 40);
        c.add(back);
        
         print=new JButton("Print");
        print.setFont(font);
        print.setBounds(360, 540, 100, 40);
        c.add(print);
        
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                 Bill_final frame=new Bill_final();
                 frame.setTitle("Restaurent Billing");
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 frame.setVisible(true);
                 frame.setBounds(600, 150, 900, 600);
                  frame.setResizable(false);
            }
        });
        
        print.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Boolean ppt=textarea1.print();
                    if(ppt){
                        JOptionPane.showMessageDialog(null,"Done");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Printing...");
                    }
                } catch (PrinterException ex) {
                    Logger.getLogger(Generate_Bill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
     public static void main(String[] args) {
        Generate_Bill frame=new Generate_Bill();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(600, 150, 500, 650);
         frame.setResizable(false);
    }
}
