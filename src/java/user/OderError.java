/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user;

/**
 *
 * @author Minh Hoàng
 */
public class OderError {
    private String nameError;
    private String addressError;
    private String PhoneError;
    private String emailError;

    public OderError() {
    }

    public OderError(String nameError, String addressError, String PhoneError, String emailError) {
        this.nameError = nameError;
        this.addressError = addressError;
        this.PhoneError = PhoneError;
        this.emailError = emailError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getPhoneError() {
        return PhoneError;
    }

    public void setPhoneError(String PhoneError) {
        this.PhoneError = PhoneError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }
    
}
