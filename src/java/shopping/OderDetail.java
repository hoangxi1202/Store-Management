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
public class OderDetail {
    private int detailID;
    private String productID;
    private long price;
    private int quantity;
    private int oderID;

    public OderDetail() {
    }

    public OderDetail(int detailID, String productID, long price, int quantity, int oderID) {
        this.detailID = detailID;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
        this.oderID = oderID;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOderID() {
        return oderID;
    }

    public void setOderID(int oderID) {
        this.oderID = oderID;
    }

    @Override
    public String toString() {
        return "OderDetail{" + "detailID=" + detailID + ", productID=" + productID + ", price=" + price + ", quantity=" + quantity + ", oderID=" + oderID + '}';
    }
    
}
