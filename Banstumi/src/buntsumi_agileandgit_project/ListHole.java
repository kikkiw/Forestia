/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buntsumi_agileandgit_project;

/**
 *
 * @author Ei8ht
 */
public class ListHole{
    Hole head = null;
    Hole last = null;
    public void add(int value,int numHole){
        if(head == null){//empty list
            head = new Hole(value,numHole,null);
            last = head;
        }else{
            last.next = new Hole(value,numHole,null);
            last = last.next;
            last.next = head;
        }
    }
    
    public void listAll(){
        Hole pointer = head;
        while(pointer != null){
            System.out.println(pointer.getBeans()+" "+pointer.getNumHole());
            pointer = pointer.next;
        }
    }
    
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
    
//    public void delay(){
//        for(int t = 0 ; t < 1000000 ; t++){
//            
//        }
//    }
    
    public void ShiftBean(Hole pointer){
        int amount = pointer.getBeans();
        pointer.setBeans(0);
//        delay();
        for(int i = 0;i<amount;i++){
            pointer = pointer.next;
            if(pointer.getNumHole() == 14){
                pointer = pointer.next;
            }
            int shiftBean = 1+pointer.getBeans();
            pointer.setBeans(shiftBean);
//            setText();
            System.out.println(shiftBean);
        }
    }
}
