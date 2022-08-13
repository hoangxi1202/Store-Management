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
public class Oder {
    private int oderID;
    private String userID;
    private long total;   
    private String phone;
    private String address;
    private int status;
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    

    public Oder() {
    }

    public Oder(int oderID, String userID, long total, String phone, String address, int status, String fullName) {
        this.oderID = oderID;
        this.userID = userID;
        this.total = total;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.fullName = fullName;
    }

    public int getOderID() {
        return oderID;
    }

    public void setOderID(int oderID) {
        this.oderID = oderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
