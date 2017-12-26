/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module_B;

/**
 *
 * @author C K
 */
public interface listInterface<T> {
    public void add(T newEntry);
    public boolean update(int position, T newEntry);
    public boolean isEmpty();
    public T getEntry(int position);
    public void clear(); 
    public int size();
}
