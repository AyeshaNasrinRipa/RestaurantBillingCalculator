
package final_restaurant;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calculator extends JFrame{
    private Container c;
    FlowLayout cardlayout=new FlowLayout();
    Font font=new Font("Arial",Font.BOLD,30);
    double cnum1,cnum2,cresult;
    int addc=0,subc=0,mulc=0,divc=0,add=0,flagforpoint=0,flagforsign=0;
    Calculator(){
        initcomponent();
    }
    public void initcomponent(){
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F0F3F4"));
        JTextArea textarea=new JTextArea();
        textarea.setFont(font);
        textarea.setEditable(false);
        textarea.setBounds(20, 10, 420, 110);
        c.add(textarea);
        
        JPanel panel1=new JPanel();
        panel1.setLayout(cardlayout);
        panel1.setBounds(10, 130, 440,300);
        c.add(panel1);
        
        JButton button7=new JButton("7");
        button7.setFont(font);
        button7.setPreferredSize(new Dimension(100, 50));
        panel1.add(button7);
        JButton button8=new JButton("8");
        button8.setFont(font);
        button8.setPreferredSize(new Dimension(100, 50));
        panel1.add(button8);
       JButton button9=new JButton("9");
        button9.setFont(font);
        button9.setPreferredSize(new Dimension(100, 50));
        panel1.add(button9);
        JButton addbutton=new JButton("+");
        addbutton.setFont(font);
        addbutton.setPreferredSize(new Dimension(100, 50));
        panel1.add(addbutton);
        JButton button4=new JButton("4");
        button4.setFont(font);
        button4.setPreferredSize(new Dimension(100, 50));
        panel1.add(button4);
        JButton button5=new JButton("5");
        button5.setFont(font);
        button5.setPreferredSize(new Dimension(100, 50));
        panel1.add(button5);
        JButton button6=new JButton("6");
        button6.setFont(font);
        button6.setPreferredSize(new Dimension(100, 50));
        panel1.add(button6);
        JButton subbutton=new JButton("-");
        subbutton.setFont(font);
        subbutton.setPreferredSize(new Dimension(100, 50));
        panel1.add(subbutton);
        JButton button1=new JButton("1");
        button1.setFont(font);
        button1.setPreferredSize(new Dimension(100, 50));
        panel1.add(button1);
        JButton button2=new JButton("2");
        button2.setFont(font);
        button2.setPreferredSize(new Dimension(100, 50));
        panel1.add(button2);
        JButton button3=new JButton("3");
        button3.setFont(font);
        button3.setPreferredSize(new Dimension(100, 50));
        panel1.add(button3);
        JButton mulbutton=new JButton("*");
        mulbutton.setFont(font);
        mulbutton.setPreferredSize(new Dimension(100, 50));
        panel1.add(mulbutton);
        JButton pointbutton=new JButton(".");
        pointbutton.setFont(font);
        pointbutton.setPreferredSize(new Dimension(100, 50));
        panel1.add(pointbutton);
        JButton button0=new JButton("0");
        button0.setFont(font);
        button0.setPreferredSize(new Dimension(100, 50));
        panel1.add(button0);
        JButton equalbutton=new JButton("=");
        equalbutton.setFont(font);
        equalbutton.setPreferredSize(new Dimension(100, 50));
        panel1.add(equalbutton);
        JButton divbutton=new JButton("/");
        divbutton.setFont(font);
        divbutton.setPreferredSize(new Dimension(100, 50));
        panel1.add(divbutton);
        JButton clearbutton=new JButton("Clear");
        clearbutton.setFont(font);
        clearbutton.setPreferredSize(new Dimension(420, 50));
        panel1.add(clearbutton);
        
        
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textarea.append("1");
            }
        });
     button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textarea.append("2");
            }
        });
     button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textarea.append("3");
            }
        });
       button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textarea.append("4");
            }
        });
       button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textarea.append("5");
            }
        });
       button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textarea.append("6");
            }
        });
       button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textarea.append("7");
            }
        });
       button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textarea.append("8");
            }
        });
       button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textarea.append("9");
            }
        });
       button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textarea.append("0");
            }
        });
       pointbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flagforpoint==0){
                textarea.append(".");
                flagforpoint=1;}
                else{
                    JOptionPane.showMessageDialog(null, "You can't use it twice");
                }
            }
        });
       addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flagforsign==0){
               cnum1=Double.parseDouble(textarea.getText());
                add=1;
                textarea.setText("");
                flagforpoint=0;
                flagforsign=1;
                }
                else{
                    JOptionPane.showMessageDialog(null, "You can't use it twice");
                }
                
            }
        });
       subbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textarea.getText().isEmpty()){
                    textarea.setText("-");
                    flagforpoint=0;
                }
                else{
                cnum1=Double.parseDouble(textarea.getText());
                add=2;
                textarea.setText("");
                flagforpoint=0;
                }
            }
        });
       mulbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flagforsign==0){
                cnum1=Double.parseDouble(textarea.getText());
                textarea.setText("");
                add=3;
                flagforpoint=0;
                flagforsign=1;
                }
                else{
                     JOptionPane.showMessageDialog(null, "You can't use it twice");
                }
            }
        });
       divbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(flagforsign==0){
               cnum1=Double.parseDouble(textarea.getText());
                textarea.setText("");
                add=4;
                flagforpoint=0;
                flagforsign=1;
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "You can't use it twice");
                }
            }
        });
       equalbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cnum2=Double.parseDouble(textarea.getText());
                switch(add){
                    case  1:
                        cresult=cnum1+cnum2;
                        textarea.setText(Double.toString(cresult));
                        break;
                        case  2:
                        cresult=cnum1-cnum2;
                        textarea.setText(Double.toString(cresult));
                        break;
                        case  3:
                        cresult=cnum1*cnum2;
                        textarea.setText(Double.toString(cresult));
                        break;
                        case  4:
                        cresult=cnum1/cnum2;
                        textarea.setText(Double.toString(cresult));
                        break;
                }
                            }
        });
       clearbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cnum1=0;
                cnum2=0;
                textarea.setText("");
                add=0;
                flagforpoint=0;
                flagforsign=0;
                            }
        });
        
        
        
    }
    public static void main(String[] args) {
        Calculator frame=new Calculator();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(650, 250, 480, 500);
    }
}
