/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA;

/**
 *
 * @author Greyson
 */
public interface ListInterface<T> {
    public void add(T newEntry);
    public void remove(int givenPosition);
    public void clear();
    public void display();
    public T get(int givenPosition);
    public boolean replace(T newEntry, int givenPosition);
    public boolean isEmpty();
    public boolean contains(T  newEntry);
}
