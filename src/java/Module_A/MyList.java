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
public class MyList<T> implements ListInterface<T>{
 Node head = null;
  Node tail = null;
  int count = 0;
  
  public void add(T newEntry){
    if(head == null){
      head = new Node(newEntry);
      tail = head;
    }
    else{
      tail.setNext( new Node(newEntry) );
      tail = tail.getNext();
    }
    
    count++;
  }
  
  public void remove(int givenPosition){
    if(givenPosition >= 0 && givenPosition < count){
      Node temp = this.head;
      
      if(givenPosition == 0){
        this.head = head.getNext();
        count--;
        return;
      }
      
      // [0,1]->[1,2]-[2,null]
      int i = 0;
      Node previous = temp;
      while(temp.getNext() != null){
        
        if(i == givenPosition){
          break;
        }
        previous = temp;
        temp = temp.getNext();
        i++;
      }
      
      previous.setNext(temp.getNext());
      temp = null;
      count--;
    }
  }
  
  public void clear(){
    while(this.size() != 0){
      this.remove(0);
    }
  }
  
  public T get(int givenPosition){
    
    int i = 0;
    
    Node<T> temp = head;
    
    while(temp != null){
      
      if(i == givenPosition){
        return temp.getData();
      }
      
      temp = temp.getNext();
      i++;
    }
    
    return null;
  }
  
      public boolean replace(T newEntry, int givenPosition) {
        Node current = head;
        Node prev = null;

        while (current != null && givenPosition >= 0) {
            givenPosition--;
            prev = current;
            current = current.next;
        }

        if (givenPosition > 0) return false;

        if (prev != null)
            prev.data = newEntry;

        return true;
    }
  
     public boolean isEmpty() {
    boolean result;

    if (count == 0) {
      result = true;
    } else {
      result = false;
    }

    return result;
  }
    
    
    
    
    
  
  public void display(){
    
    Node temp = head;
    
    while(temp != null){
      
      System.out.println("\n " + temp);
      temp = temp.getNext();
      
    }
  }
  
  public boolean contains(T  newEntry){
    
    Node temp = head;
    
    while(temp != null){
      
      if(newEntry.equals(temp.getData())){
        return true;
      }      
      
      temp = temp.getNext();
    }
    
    return false;
  }
  
  public int size(){
    return this.count;
  }
}