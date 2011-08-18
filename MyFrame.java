/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyFrame  extends JFrame{

    public MyFrame(String title){
        this();  // call MyFrame()
        setTitle(title);    
    }
    public MyFrame() {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        
        Image img0 = kit.getImage("images/Smiley-love-icon.png");
        Image img1 = kit.getImage("images/Smiley-bored-icon.png");
        Image img2 = kit.getImage("images/Smiley-bored-2-icon.png");
        Image img3 = kit.getImage("images/Smiley-disappointed-icon.png");
        
        setIconImage(img0);
        
        Icon icon1 = new ImageIcon(img1);
        Icon icon2 = new ImageIcon(img2);
        Icon icon3 = new ImageIcon(img3);
      
        JButton b1 = new JButton("Click me",icon1);
        b1.setRolloverIcon(icon2);
        b1.setVerticalTextPosition(SwingConstants.BOTTOM);
        b1.setHorizontalTextPosition(SwingConstants.CENTER);
        
        
        JButton b2 = new JButton("Click me please",icon3);
        b2.setRolloverIcon(icon1);
        b2.setVerticalTextPosition(SwingConstants.BOTTOM);
        b2.setHorizontalTextPosition(SwingConstants.CENTER);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.red);
        panel.add(b1);
        panel.add(b2);
        add(panel,BorderLayout.SOUTH);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MyFrame("MyFrame");
    }
}
