
package final_restaurant;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;




public class Delete_item extends JFrame{
    String filepath="Data.txt";
    private Container c;
    private  static JButton delete,back;
    private static JComboBox box1;
    Font font=new Font("Arial",Font.BOLD,20);
   Delete_item(){
        initcomponent();
    }
    public void initcomponent(){
        c=this.getContentPane();
        c.setLayout(null);
        
        
        File_Basic f=new File_Basic();
         f.ReadRecord(filepath);
         box1=new JComboBox(f.Item);
         box1.setBounds(20, 20, 300, 50);
        box1.setFont(font);
        c.add(box1);
        
       delete=new JButton("Delete");
       delete.setFont(font);
       delete.setBounds(20, 200, 100, 50);
       c.add(delete);
       
       back=new JButton("Back");
       back.setFont(font);
       back.setBounds(210, 200, 100, 50);
       c.add(back);
       
       
       delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                String S=box1.getSelectedItem().toString();
                System.out.println(S);
             f.removeRecord(filepath,S,1,",");
             Main frame=new Main();
            frame.setTitle("Restaurent Billing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setBounds(600, 150, 500,600);
             frame.setResizable(false);
            dispose();
            }
       });
       back.addActionListener(new ActionListener(){
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
        
        Delete_item frame=new Delete_item();
        frame.setTitle("Delete Item");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(650, 250,380, 350); 
         frame.setResizable(false);
    }
    
}
