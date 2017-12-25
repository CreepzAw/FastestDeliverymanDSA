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
public class Node<T> {
T data;
  Node next;
  
  public Node(){
    data = null;
    next = null;
  }
  
  public Node(T data){
    this.data = data;
    this.next = null;
  }
  
  @Override
  public String toString(){
    return this.data.toString();
  }
  
  public void setNext(Node next){
    this.next = next;
  }
  
  public Node getNext(){
    return this.next;
  }
  
  public void setData(T data){
    this.data = data;
  }
  
  public T  getData(){
    return this.data;
  }
}