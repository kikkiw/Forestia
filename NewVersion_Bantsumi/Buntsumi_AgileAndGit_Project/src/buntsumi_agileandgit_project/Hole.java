/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buntsumi_agileandgit_project;

/**
 *
 * @author Forestia
 */
public class Hole {
    private int beans;                  // จำนวนถั่ว
    private int numHole;                // ลำดับของหลุม หรือชื่อหลุม
    Hole next;

    /**
     * constructor เปรียบเสมือนเป็นหลุมๆ หนึ่ง
     * @param beans จำนวนของถั่ว
     * @param numHole ลำดับของหลุม หรือชื่อหลุม
     * @param next ไว้ใช้เชื่อมต่อกับหลุมต่อไป
     */
    public Hole(int beans, int numHole, Hole next) {
        this.beans = beans;
        this.numHole = numHole;
        this.next = next;
    }

    /**
     * @return the beans
     */
    public int getNumHole() {
        return numHole;
    }

    /**
     * @return the beans
     */
    public int getBeans() {
        return beans;
    }

    /**
     * @param beans the beans to set
     */
    public void setBeans(int beans) {
        this.beans = beans;
    }

}
