/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopping;

/**
 *
 * @author Minh Hoàng
 */
public class Catagory {
    private String catagoryID;
    private String catagoryName;

    public Catagory() {
    }

    public Catagory(String catagoryID, String catagoryName) {
        this.catagoryID = catagoryID;
        this.catagoryName = catagoryName;
    }

    public String getCatagoryID() {
        return catagoryID;
    }

    public void setCatagoryID(String catagoryID) {
        this.catagoryID = catagoryID;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    @Override
    public String toString() {
        return "Catagory{" + "catagoryID=" + catagoryID + ", catagoryName=" + catagoryName + '}';
    }
    
    
}
