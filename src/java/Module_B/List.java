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
public class List<T> implements listInterface<T> {
    
    private Node firstNode; // reference to first node
    private int staffCounter;  	// number of entries in list
  
  public List() {
    clear();
  }
  
  @Override
  public final void clear() {
    firstNode = null;
    staffCounter = 0;
  }

    @Override
    public void add(T newEntry) {
        Node newNode= new Node(newEntry);
        
        if(isEmpty())
        {
        
            firstNode=newNode;
            
        }
        else{
        
            Node currentNode=firstNode;
            while (currentNode.next != null) {		
            currentNode = currentNode.next;
      }
            currentNode.next = newNode;
        }
        staffCounter++;
        
    }
    
    
   
    
    @Override
    public boolean update(int position, T newEntry) {
       boolean isSuccessful = true;

    if ((position >= 1) && (position <= staffCounter)) {
      Node currentNode = firstNode;
      for (int i = 0; i < position - 1; ++i) {
        
        currentNode = currentNode.next;		
      }
      currentNode.data = newEntry;	
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }

    @Override
    public boolean isEmpty() {
        boolean result;

    result = staffCounter == 0;

    return result;
    }



    
    public int size(){
    
        return staffCounter;
    }

    @Override
    public T getEntry(int position) {
       T result = null;

    if ((position >= 1) && (position <= staffCounter)) {
      Node currentNode = firstNode;
      for (int i = 0; i < position - 1; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      result = currentNode.data;	// currentNode is pointing to the node at givenPosition
    }

    return result;
    }
    
    public String toString() {
    String outputStr = "";
    Node currentNode = firstNode;
    while (currentNode != null) {
      outputStr += currentNode.data + "\n";
      currentNode = currentNode.next;
    }
    return outputStr;
  }

    

    
    
      private class Node {

    private T data;
    private Node next;

    private Node(T data) {
      this.data = data;
      this.next = null;
    }

    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}
