/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buntsumi_agileandgit_project;

/**
 *
 * @author NoodlemaN
 */
public class Hole {
    private int beans;
    private int numHole;
    Hole next;

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
