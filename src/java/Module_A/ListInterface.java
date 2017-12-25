/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module_A;

/**
 *
 * @author Greyson
 */
public interface ListInterface<T> {
    public void add(T newEntry);
    public void remove(int index);
    public void clear();
    public T get(int index);
    public boolean replace(T element, int index);
    public boolean isEmpty();
}
