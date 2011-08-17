/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buntsumi_agileandgit_project;

/**
 *
 * @author Ei8ht
 */
public class ListHole {
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
        
        for (int i = 0; i < 14; i++) {
            System.out.println(pointer.getBeans()+" "+pointer.getNumHole());
            pointer = pointer.next;
        }
//        while(pointer != null){
//            System.out.println(pointer.getBeans()+" "+pointer.getNumHole());
//            pointer = pointer.next;
//        }
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
    public void ShiftBean(Hole pointer, boolean check){
        int amount = pointer.getBeans();
        pointer.setBeans(0);
        for(int i = 0;i<amount;i++){
            pointer = pointer.next;
            if(check == true){
                if(pointer.getNumHole() == 14){
                    pointer = pointer.next;
                }
                int shiftBean = pointer.getBeans()+1;
                pointer.setBeans(shiftBean);
            }
            if(check == false){
                if(pointer.getNumHole() == 7){
                    pointer = pointer.next;
                }
                int shiftBean = pointer.getBeans()+1;
                pointer.setBeans(shiftBean);
            }   
        }
    }
}
