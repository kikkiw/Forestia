/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buntsumi_agileandgit_project;

/**
 *
 * @author NoodlemaN
 */
public class Node {
    private  Object data; 
    private int val;
    private Node next;

    public Node(Object data, int val) {
        this.data = data;
        this.val = val;
        this.next = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
    
    public String toString() {
        return data.toString();
    }
}
