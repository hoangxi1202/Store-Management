/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopping;

import java.io.Serializable;

/**
 *
 * @author Minh Hoàng
 */
public class Item implements Serializable{
    private String id;
    private String name;
    private String img;
    private int quatity;
    private double price;

    public Item() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Item(String id, String name, String img, int quatity, double price) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.quatity = quatity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    

    
    
}
