/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopping;


import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author Minh Hoàng
 */
public class Cart  {
    private Map<String, Item> cart;

    public Cart() {
    }

    public Cart(Map<String, Item> cart) {
        this.cart = cart;
    }

    public Map<String, Item> getCart() {
        return cart;
    }

    public void setCart(Map<String, Item> cart) {
        this.cart = cart;
    }
    public void add(Item p){
        if (this.cart ==null){
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(p.getId()) ){
            int currentAmount = this.cart.get(p.getId()).getQuatity();          
                p.setQuatity(currentAmount + p.getQuatity());   
            if (p.getQuatity()<=0) {
                cart.remove(p.getId());
                return;
            }
        }
        cart.put(p.getId(), p);
    }
    public void delete(Item p){
        if (this.cart==null) return;
        if(cart.containsKey(p.getId())){       
                p.setQuatity(0);   
            if (p.getQuatity()<=0) {
                cart.remove(p.getId());
        }
    }}
    public void update(String id, Item newP){
        if (this.cart ==null){
            return;
        }
        if (this.cart.containsKey(id)){
            this.cart.replace(id, newP);
        }
    }
}