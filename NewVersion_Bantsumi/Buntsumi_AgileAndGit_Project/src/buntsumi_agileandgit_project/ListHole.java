/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buntsumi_agileandgit_project;

/**
 *
 * @author Forestia
 */
public class ListHole {
    Hole head = null;
    Hole last = null;
    Hole still = null;
    
    /**
     * method ที่ใช้สร้างลิส
     * @param value เปรียบเสมือนจำนวนถั่วในหลุมนั้นๆ
     * @param numHole คือ ลำดับเลขของหลุม เปรียบเสมือนชื่อหลุม
     */
    public void add(int value,int numHole){
        if(head == null){                   //empty list
            head = new Hole(value,numHole,null);
            last = head;
        }else{
            last.next = new Hole(value,numHole,null);
            last = last.next;
            last.next = head;
        }
    }
    
    /**
     * method ไว้ show ลิสของหลุม
     */
    public void listAll(){
        Hole pointer = head;
        
        // ลูปนี้ ใช้ check ว่าลิสที่สร้างขึ้นเชื่อมวนถึงกันรึเปล่า
        for (int i = 0; i < 14; i++) {
            System.out.println(pointer.getBeans()+" "+pointer.getNumHole());
            pointer = pointer.next;
        }
    }
    
    /**
     * method ใช้ ค้นหาหลุมที่กด
     * @param numHole เป็นลำดับของหลุม หรือก็คือชื่อของหลุม
     * @return หลุมที่ต้องการ
     */
    public Hole getHole(int numHole){
        Hole pointer = head;
        while(pointer != null){
            if(pointer.getNumHole() == numHole){
                return pointer;
            }
            pointer = pointer.next;
        }
        return null;
    }
    
    /**
     * method ใช้ในการหยิบถั่วจากหลุมที่ต้องการ แล้วไปหยอดในหลุมต่อๆไป
     * @param pointer คือ หลุมที่ต้องการ
     * @param check ไว้ใช้ check ตาของผู้เล่น
     */
    public void ShiftBean(Hole pointer, boolean check){
        int amount = pointer.getBeans();         // เปรียบเสมือนการหยิบถั่วออกมาจากหลุม
        pointer.setBeans(0);                     // set ค่าให้หลุมนั้นว่างเปล่า
        for(int i = 0;i<amount;i++){
            pointer = pointer.next;
                       
            if(check == true){          // check ว่าเป็นตาของผู้เล่น Y
                
                // เงื่อนไขว่า ให้ทำการข้ามตะกร้าของตัวเอง
                if(pointer.getNumHole() == 14){
                    pointer = pointer.next;
                }
                int shiftBean = pointer.getBeans()+1;    // หยอดถั่วในหลุมต่อไปทีละ 1
                pointer.setBeans(shiftBean);             // set ค่าถั่วในหลุมนั้นๆ
            }
            else{                       // check ว่าเป็นตาของผู้เล่น X
                
                // เงื่อนไขว่า ให้ทำการข้ามตะกร้าของตัวเอง
                if(pointer.getNumHole() == 7){
                    pointer = pointer.next;
                }
                int shiftBean = pointer.getBeans()+1;    // หยอดถั่วในหลุมต่อไปทีละ 1
                pointer.setBeans(shiftBean);             // set ค่าถั่วในหลุมนั้นๆ
            }   
        }
    }
}