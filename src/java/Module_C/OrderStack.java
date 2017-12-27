package Module_C;

public class OrderStack<OrderData> implements OrderStack_Interface<OrderData> {
    Node topNode;
    int length = -1;    //keeps track of size
    
    //initializes link list
    public OrderStack(){
        topNode = null;
    }
    
    //Adds a new node on top of the existing top node
    public void push(OrderData newEntry){
        length++;
        if (isEmpty()){
            Node newNode = new Node(newEntry);
            topNode = newNode;
            topNode.next = null;
        }
        else {
            Node newNode = new Node (newEntry, topNode);
            newNode.next = topNode;
            topNode = newNode;
        }
    }
    
    //Removes top most node and set the node below it as top
    public OrderData pop(){
        if (isEmpty()){
            return null;
        }
        else {
            length--;
            Node temp = topNode;
            topNode = topNode.next;
            return temp.data;
        }
    }
    
    //Returns topmost node without modifying the list
    public OrderData peek(){
        if (isEmpty()){
            return null;
        }
        else {
            return topNode.data;
        }
    }
    
    //Checks if the linked list is empty
    public boolean isEmpty(){
        if (topNode==null){
            return true;
        }
        else {
            return false;
        }
    }
    
    //Clears the linked list
    public void clear(){
        topNode = null;
    }
    
    //Node object class
    private class Node{
        private OrderData data;
        private Node next;
        
        public Node(OrderData Data){
            this.data = Data;
            this.next = null;
        }
        
        public Node(OrderData Data, Node top){
            this.data = Data;
            this.next = top;
        }
    }
}

