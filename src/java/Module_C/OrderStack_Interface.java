/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module_C;

/**
 *
 * @author lenovo
 */
public interface OrderStack_Interface<OrderData> {
    public void push(OrderData newEntry);
    public OrderData pop();
    public OrderData peek();
    public boolean isEmpty();
    public void clear();
}
