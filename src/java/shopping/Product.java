/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopping;

import java.sql.Date;

/**
 *
 * @author Minh Hoàng
 */
public class Product {
    private String productID;
    private String productName;
    private String image;
    private double price;
    private int quantity;
    private String catagoryID;
    private Date importDate;
    private Date usingDate;
    private String description;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product(String id, String name, String image, double price) {
        this.productID = id;
        this.productName = name;
        this.image = image;
        this.price = price;
    }

    public Product(String id, String name, String image, double price, int amount) {
        this.productID = id;
        this.productName = name;
        this.image = image;
        this.price = price;
        this.amount = amount;
    }
    public Product() {
        this.productID = "";
        this.productName = "";
        this.image = "";
        this.price = 0;
        this.quantity = 0;
        this.catagoryID = "";
        this.importDate = null;
        this.usingDate = null;
        this.description = "";
    }

    public Product(String productID, String productName, String image, double price, int quantity, String catagoryID, Date importDate, Date usingDate, String description) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.catagoryID = catagoryID;
        this.importDate = importDate;
        this.usingDate = usingDate;
        this.description = description;
        
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCatagoryID() {
        return catagoryID;
    }

    public void setCatagoryID(String catagoryID) {
        this.catagoryID = catagoryID;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public Date getUsingDate() {
        return usingDate;
    }

    public void setUsingDate(Date usingDate) {
        this.usingDate = usingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", image=" + image + ", price=" + price + ", quantity=" + quantity + ", catagoryID=" + catagoryID + ", importDate=" + importDate + ", usingDate=" + usingDate + ", description=" + description + '}';
    }
    
    
    
}
