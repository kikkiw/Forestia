/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TestBuntumi.java
 *
 * Created on 16 ส.ค. 2554, 13:46:14
 */
package buntsumi_agileandgit_project;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Forestia
 */
public class TestBuntumi extends javax.swing.JFrame {
    ListHole list;                      
    boolean check = true;               // ไว้ใช้ check ว่าเป็นตาเล่นของฝ่ายไหน
    int i = 0;                          // ไว้ใช้ check ในการเปิด-ปิดปุ่ม
    int numBean = 4;                    // ค่าตั้งตนของถั่ว
    int countP1 = 0,countP2 = 0;        // ไว้ใช้ให้ check ว่าถ้าฝ่ายไหนชนะให้นับเพิ่มไป 1
    boolean n;                          // ไว้ใช้ check message dialog      
    int sum1 = 0;                       // ใช้เก็บผลรวมของถั่วในหลุมของผู้เล่น 1 ทั้งหมด
    int sum2 = 0;                       // ใช้เก็บผลรวมของถั่วในหลุมของผู้เล่น 2 ทั้งหมด
    
    //Ctreate List
    public final void CreateList(int numBean){
        list = new ListHole();      
        
        // ทำการเชื่อมหลุมทุกหลุมไว้ด้วยกัน
        list.add(numBean,1,13);        
        list.add(numBean,2,12);
        list.add(numBean,3,11);
        list.add(numBean,4,10);
        list.add(numBean,5,9);
        list.add(numBean,6,8);  
        list.add(0,7,0);                      // ตะกร้าผู้เล่น 1
        list.add(numBean,8,6);
        list.add(numBean,9,5);
        list.add(numBean,10,4);
        list.add(numBean,11,3);
        list.add(numBean,12,2);
        list.add(numBean,13,1);
        list.add(0,14,0);                     // ตะกร้าผู้เล่น 2
    }
    
    /** Creates new form TestBuntumi */
    public TestBuntumi() {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("Bean-icon.gif");
        setIconImage(img);
        
        CreateList(numBean);
        
        //list.listAll();
        initComponents();
        
        defaultBackground();
        setText();                          // set ค่าถั่วไว้บน textField
        
        //set ปุ่มเริ่มต้น
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
            
        jButton7.setEnabled(true);
        jButton8.setEnabled(true);
        jButton9.setEnabled(true);
        jButton10.setEnabled(true);
        jButton11.setEnabled(true);
        jButton12.setEnabled(true);
        
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField7.setEnabled(false);
        jTextField8.setEnabled(false);
        jTextField9.setEnabled(false);
        jTextField10.setEnabled(false);
        jTextField11.setEnabled(false);
        jTextField12.setEnabled(false);
        jTextField13.setEnabled(false);
        jTextField14.setEnabled(false);
    }
    
    /**
     * method check ว่าในหลุมทุกหลุุมของฝ่ายใดฝ่ายหนึ่งว่างเปล่าหรือไม่
     * @return true เมื่อหลุมทุกหลุมของฝ่ายใดฝ่ายหนึ่งว่างเปล่า
     */
    public boolean checkEnd(){
        sum1 = 0;
        sum2 = 0;
        for(int j = 1;j<7;j++){
            sum1 = sum1+list.getHole(j).getBeans();
        }
        for(int j = 8;j<14;j++){
            sum2 = list.getHole(j).getBeans()+sum2;
        }
        if(sum1 == 0 || sum2 == 0){
            return true;
        }
        return false;
    } 
    
    /**
     * method check การจบเกม
     * @param end คือที่ check ว่าหลุมทุกหลุมของฝ่ายใดฝ่ายหนึ่งว่างเปล่า
     */
    public void finishGame(boolean end){
        if(end == true){        // ถ้ามีหลุมฝ่ายใดฝ่ายหนึ่งว่างเปล่า
            int valP1 = list.getHole(7).getBeans();     // จำนวนถั่วในตะกร้าของ player 1
            int valP2 = list.getHole(14).getBeans();    // จำนวนถั่วในตะกร้าของ player 2
            
            if(valP1 > valP2){              // จำนวนถั่วของ player 1 มากกว่า       
                countP1++;
                JOptionPane.showMessageDialog(null
                        , "            Player 1 win!!\nPlayer 1 win: " + countP1 + "    Player 2 win: " + countP2
                        , "Finish Game", JOptionPane.INFORMATION_MESSAGE);
                defaultBackground();
                CreateList(numBean);
                setText();
            }
            else if(valP1 < valP2){         // จำนวนถั่วของ player 2 มากกว่า
                countP2++;
                JOptionPane.showMessageDialog(null
                        , "            Player 2 win!!\nPlayer 1 win: " + countP1 + "    Player 2 win: " + countP2
                        , "Finish Game", JOptionPane.INFORMATION_MESSAGE);
                defaultBackground();
                CreateList(numBean);
                setText();
            }  
            else{                           // จำนวนถั่วในตะกร้าเท่ากัน
                if(sum1 > sum2){            // check ว่าผู้เล่น 1 ยังมีถั่วอยู่ในหลุมจะเป็นฝ่ายชนะ
                    countP1++;
                    JOptionPane.showMessageDialog(null
                        , "            Player 1 win!!\nPlayer 1 win: " + countP1 + "    Player 2 win: " + countP2
                        , "Finish Game", JOptionPane.INFORMATION_MESSAGE);
                    defaultBackground();
                    CreateList(numBean);
                    setText();
                }
                else if(sum1 < sum2){       // check ว่าผู้เล่น 1 ยังมีถั่วอยู่ในหลุมจะเป็นฝ่ายชนะ
                    countP2++;
                    JOptionPane.showMessageDialog(null
                        , "            Player 2 win!!\nPlayer 1 win: " + countP1 + "    Player 2 win: " + countP2
                        , "Finish Game", JOptionPane.INFORMATION_MESSAGE);
                    defaultBackground();
                    CreateList(numBean);
                    setText();
                }
            }
        }
        else{
            if(n != check){
                showDialogChangePlayer(check);
            }
        }
    }
    
    /**
     * method ใช้ set ค่าสีเริ่มต้น
     */
    private void defaultBackground(){
        Color c = Color.darkGray;
        jTextField7.setBackground(c);
        jTextField8.setBackground(c);
        jTextField9.setBackground(c);
        jTextField10.setBackground(c);
        jTextField11.setBackground(c);
        jTextField12.setBackground(c);
        jTextField14.setBackground(c);
            
        jTextField1.setBackground(c);
        jTextField2.setBackground(c);
        jTextField3.setBackground(c);
        jTextField4.setBackground(c);
        jTextField5.setBackground(c);
        jTextField6.setBackground(c);
        jTextField13.setBackground(c);
    }
    
    /**
     * method ใช้ทำการ set สีเส้นทางที่เดิน
     * @param i 
     */
    private void paintBackground(int i){
        Color c = Color.red;
        if(i == 0)
            jTextField7.setBackground(c);
        else if(i == 1)
            jTextField8.setBackground(c);
        else if(i == 2)
            jTextField9.setBackground(c);
        else if(i == 3)
            jTextField10.setBackground(c);
        else if(i == 4)
            jTextField11.setBackground(c);
        else if(i == 5)
            jTextField12.setBackground(c);
        else if(i == 6)
            jTextField14.setBackground(c);
        else if(i == 7)
            jTextField1.setBackground(c);
        else if(i == 8)
            jTextField2.setBackground(c);
        else if(i == 9)
            jTextField3.setBackground(c);
        else if(i == 10)
            jTextField4.setBackground(c);
        else if(i == 11)
            jTextField5.setBackground(c);
        else if(i == 12)
            jTextField6.setBackground(c);
        else if(i == 13)
            jTextField13.setBackground(c);
    }
    
    /**
     * method ใช้มาร์กสีเส้นทางที่เดิน ของ turn นั้นๆ
     */
    private void paintText(){
        String buf[] = new String[14]; 
        
        buf[0] = jTextField7.getText();
        buf[1] = jTextField8.getText();
        buf[2] = jTextField9.getText();
        buf[3] = jTextField10.getText();
        buf[4] = jTextField11.getText();
        buf[5] = jTextField12.getText();
        buf[6] = jTextField14.getText();
        
        buf[7] = jTextField1.getText();
        buf[8] = jTextField2.getText();
        buf[9] = jTextField3.getText();
        buf[10] = jTextField4.getText();
        buf[11] = jTextField5.getText();
        buf[12] = jTextField6.getText();
        buf[13] = jTextField13.getText();
        
        setText();
        
        String buf2[] = new String[14]; 
        
        buf2[0] = jTextField7.getText();
        buf2[1] = jTextField8.getText();
        buf2[2] = jTextField9.getText();
        buf2[3] = jTextField10.getText();
        buf2[4] = jTextField11.getText();
        buf2[5] = jTextField12.getText();
        buf2[6] = jTextField14.getText();
        
        buf2[7] = jTextField1.getText();
        buf2[8] = jTextField2.getText();
        buf2[9] = jTextField3.getText();
        buf2[10] = jTextField4.getText();
        buf2[11] = jTextField5.getText();
        buf2[12] = jTextField6.getText();
        buf2[13] = jTextField13.getText();
        
        for(int j =0;j<14;j++){
            if(buf[j].equals(buf2[j]) != true){
                paintBackground(j);
            }
        }
    }
    
    /**
     * เป็น method ไว้ใช้ set ค่าลงบน textField
     */
    private void setText(){
        jTextField7.setText(Integer.toString(list.getHole(1).getBeans()));
        jTextField8.setText(Integer.toString(list.getHole(2).getBeans()));
        jTextField9.setText(Integer.toString(list.getHole(3).getBeans()));
        jTextField10.setText(Integer.toString(list.getHole(4).getBeans()));
        jTextField11.setText(Integer.toString(list.getHole(5).getBeans()));
        jTextField12.setText(Integer.toString(list.getHole(6).getBeans()));
        
        jTextField1.setText(Integer.toString(list.getHole(8).getBeans()));
        jTextField2.setText(Integer.toString(list.getHole(9).getBeans()));
        jTextField3.setText(Integer.toString(list.getHole(10).getBeans()));
        jTextField4.setText(Integer.toString(list.getHole(11).getBeans()));
        jTextField5.setText(Integer.toString(list.getHole(12).getBeans()));
        jTextField6.setText(Integer.toString(list.getHole(13).getBeans()));
        
        jTextField14.setText(Integer.toString(list.getHole(7).getBeans()));
        jTextField13.setText(Integer.toString(list.getHole(14).getBeans()));
    }
    
    /**
     * เป็น method ไว้ใช้เปิด-ปิดปุ่ม เมื่อ check การสลับเปลี่ยนตาของผู้เล่นแล้ว
     * @param i คือ ค่าสมมติที่ใช้ check turn ของผู้เล่น
     * @return boolean ออกมาเพื่อเก็บค่าเอาไว้ใช้เปิด-ปิดปุ่มในครั้งต่อไป
     */
    private boolean checkUser(int i){
        if(i%2 == 1){
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            jButton6.setEnabled(true);
            
            jButton7.setEnabled(false);
            jButton8.setEnabled(false);
            jButton9.setEnabled(false);
            jButton10.setEnabled(false);
            jButton11.setEnabled(false);
            jButton12.setEnabled(false);

            return false;
        }
        else {
            
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            jButton5.setEnabled(false);
            jButton6.setEnabled(false);
            
            jButton7.setEnabled(true);
            jButton8.setEnabled(true);
            jButton9.setEnabled(true);
            jButton10.setEnabled(true);
            jButton11.setEnabled(true);
            jButton12.setEnabled(true);
            
            return true;
        }        
    }
    
    /**
     * method ใช้ show message dialog check turn ของผู้เล่น
     * @param player ใช้ check turn ของผู้เล่น
     */
    public void showDialogChangePlayer(boolean player){
        if(player == true){
            JOptionPane.showMessageDialog(null, "Player 1", 
                    "Change Turn", JOptionPane.WARNING_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Player 2", 
                    "Change Turn", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * method ใช้ check การเดินของแต่ละฝ่าย
     * @param hole หลุมที่ต้องการ
     * @param player ไว้ใช้ check ว่าเป็นตาของผู้เล่นฝ่ายไหนเล่นอยู่
     */
    public void checkPassHole(Hole hole, boolean player){
        if(player == true){             // Player 1
            if((hole.getBeans()) != (7 - hole.getNumHole())){
                list.ShiftBean(hole,check);
                paintText();
                i++;
                check = checkUser(i);
            }
            else{
                list.ShiftBean(hole,check);
                paintText(); 
            }
        }
        else{                           // Player 2
            if((hole.getBeans()) != (14 - hole.getNumHole())){
                list.ShiftBean(hole,check);
                paintText();
                i++;
                check = checkUser(i);
            }
            else{
                list.ShiftBean(hole,check);
                paintText(); 
            }
        }       
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jTextField14 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jTextField13 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bantsumi");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(153, 102, 0));

        jPanel3.setBackground(new java.awt.Color(106, 106, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(430, 100));

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton2.setBackground(new java.awt.Color(153, 255, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton2.setText("หยิบ");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 255, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton1.setText("หยิบ");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton6.setBackground(new java.awt.Color(153, 255, 102));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton6.setText("หยิบ");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 255, 102));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton5.setText("หยิบ");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 255, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton4.setText("หยิบ");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 255, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton3.setText("หยิบ");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 204, 153));
        jPanel6.setPreferredSize(new java.awt.Dimension(100, 100));

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 24));
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField14, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField14, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(106, 106, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 100));

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 24));
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setText("0");
        jTextField13.setPreferredSize(new java.awt.Dimension(20, 20));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField13, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField13, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 204, 153));
        jPanel5.setPreferredSize(new java.awt.Dimension(430, 100));

        jButton12.setBackground(new java.awt.Color(153, 255, 102));
        jButton12.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton12.setText("หยิบ");
        jButton12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton12.setPreferredSize(new java.awt.Dimension(61, 33));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(153, 255, 102));
        jButton10.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton10.setText("หยิบ");
        jButton10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(153, 255, 102));
        jButton11.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton11.setText("หยิบ");
        jButton11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton11.setPreferredSize(new java.awt.Dimension(61, 33));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(153, 255, 102));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton8.setText("หยิบ");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(153, 255, 102));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton9.setText("หยิบ");
        jButton9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(153, 255, 102));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton7.setText("หยิบ");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("ไฟล์");
        jMenu1.setFont(new java.awt.Font("Tahoma", 0, 12));

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jMenuItem2.setText("เริ่มเกมใหม่");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jMenuItem1.setText("ออกจากเกม");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("ตั้งค่า");
        jMenu2.setFont(new java.awt.Font("Tahoma", 0, 12));

        jMenu3.setText("จำนวนเมล็ดถั่ว");
        jMenu3.setFont(new java.awt.Font("Tahoma", 0, 12));

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, 0));
        jMenuItem3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jMenuItem3.setText("ถั่ว 1 เมล็ด");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, 0));
        jMenuItem4.setFont(new java.awt.Font("Tahoma", 0, 12));
        jMenuItem4.setText("ถั่ว 2 เมล็ด");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, 0));
        jMenuItem5.setFont(new java.awt.Font("Tahoma", 0, 12));
        jMenuItem5.setText("ถั่ว 3 เมล็ด");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, 0));
        jMenuItem6.setFont(new java.awt.Font("Tahoma", 0, 12));
        jMenuItem6.setText("ถั่ว 4 เมล็ด");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, 0));
        jMenuItem7.setFont(new java.awt.Font("Tahoma", 0, 12));
        jMenuItem7.setText("ถั่ว 5 เมล็ด");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, 0));
        jMenuItem8.setFont(new java.awt.Font("Tahoma", 0, 12));
        jMenuItem8.setText("ถั่ว 6 เมล็ด");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, 0));
        jMenuItem9.setFont(new java.awt.Font("Tahoma", 0, 12));
        jMenuItem9.setText("ถั่ว 7 เมล็ด");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenu2.add(jMenu3);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("รายละเอียด");
        jMenu5.setFont(new java.awt.Font("Tahoma", 0, 12));

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem10.setFont(new java.awt.Font("Tahoma", 0, 12));
        jMenuItem10.setText("วิธีเล่น");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem11.setFont(new java.awt.Font("Tahoma", 0, 12));
        jMenuItem11.setText("เกี่ยวกับเรา");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * method ของ ปุ่ม Y1
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(list.getHole(8).getBeans() != 0){
            defaultBackground();
            n = check;
            checkPassHole(list.getHole(8), check);
            finishGame(checkEnd());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * method ของ ปุ่ม X1
     * @param evt 
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if(list.getHole(1).getBeans() != 0){
            defaultBackground();
            n = check;
            checkPassHole(list.getHole(1), check);
            finishGame(checkEnd());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * method ของ ปุ่ม X2
     * @param evt 
     */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(list.getHole(2).getBeans() != 0){
            defaultBackground();
            n = check;
            checkPassHole(list.getHole(2), check);
            finishGame(checkEnd());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * method ของ ปุ่ม X3
     * @param evt 
     */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if(list.getHole(3).getBeans() != 0){
            defaultBackground();
            n = check;
            checkPassHole(list.getHole(3), check);
            finishGame(checkEnd());
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * method ของ ปุ่ม X4
     * @param evt 
     */
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if(list.getHole(4).getBeans() != 0){
            defaultBackground();
            n = check;
            checkPassHole(list.getHole(4), check);
            finishGame(checkEnd());
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    /**
     * method ของ ปุ่ม X5
     * @param evt 
     */
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        if(list.getHole(5).getBeans() != 0){
            defaultBackground();
            n = check;
            checkPassHole(list.getHole(5), check);
            finishGame(checkEnd());
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * method ของ ปุ่ม X6
     * @param evt 
     */
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        if(list.getHole(6).getBeans() != 0){
            defaultBackground();
            n = check;
            checkPassHole(list.getHole(6), check);
            finishGame(checkEnd());
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    /**
     * method ของ ปุ่ม Y2
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(list.getHole(9).getBeans() != 0){
            defaultBackground();
            n = check;
            checkPassHole(list.getHole(9), check);
            finishGame(checkEnd());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * method ของ menu exit ใน menubar 
     * @param evt 
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * method ของ ปุ่ม Y3
     * @param evt 
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(list.getHole(10).getBeans() != 0){
            defaultBackground();
            n = check;
            checkPassHole(list.getHole(10), check);
            finishGame(checkEnd());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * method ของ ปุ่ม Y4
     * @param evt 
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(list.getHole(11).getBeans() != 0){
            defaultBackground();
            n = check;
            checkPassHole(list.getHole(11), check);
            finishGame(checkEnd());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * method ของ ปุ่ม Y5
     * @param evt 
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(list.getHole(12).getBeans() != 0){
            defaultBackground();
            n = check;
            checkPassHole(list.getHole(12), check);
            finishGame(checkEnd());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * method ของ ปุ่ม Y6
     * @param evt 
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(list.getHole(13).getBeans() != 0){
            defaultBackground();
            n = check;
            checkPassHole(list.getHole(13), check);
            finishGame(checkEnd());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        defaultBackground();
        CreateList(numBean);
        setText();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        numBean = 1;
        CreateList(numBean);
        setText();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        numBean = 2;
        CreateList(numBean);
        setText();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        numBean = 3;
        CreateList(numBean);
        setText();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        numBean = 4;
        CreateList(numBean);
        setText();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        numBean = 5;
        CreateList(numBean);
        setText();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        numBean = 6;
        CreateList(numBean);
        setText();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        numBean = 7;
        CreateList(numBean);
        setText();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, 
                "เกม Bantsumi เป็นเกมเล่น 2 คน\nโดยผู้เล่นแต่ละคนจะต้องเลือกหยิบถั่วในหลุมของตน\nเพื่อนำถั่วที่หยิบขึ้นมาไปใส่ในตะกร้าของตน\n"
                + "ซึ่งถ้าหยิบใส่ลงตะกร้าตนเงพอดีจะได้เล่นต่อ\nแต่ถ้าไม่พอดีเลยไปที่หลุมฝ่ายตรงข้าม\nหรือตกที่หลุมตนเองแต่ไม่ถึงตะกร้าจะเปลี่ยนตาเล่น\n"
                + "แล้วถ้าฝ่ายไหนถั่วหมดหลุมก่อนและถั่วในตะกร้า\nมีจำนวนมากกว่าจะเป็นผู้ชนะ",
                "วิธีเล่น", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, 
                "Create By Forestia Group\n"
                + "                 @Gorn\n"
                + "                 @Kik\n"
                + "                 @Champ\n"
                + "                 @Best\n"
                + "                 @Auy",
                "เกี่ยวกับเรา", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestBuntumi().setVisible(true);
            }
        });
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
