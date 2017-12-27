package Module_C;

public class OrderStack<OrderData> implements OrderStack_Interface<OrderData> {
    private Node topNode;
    OrderData[] order;  //The object array to store data
    int length = -1;    //Index pointer for stack ADT
    int size = 1;       //Size indicator
    
    //Default constructor that sets the object array size to 1
    public OrderStack(){
        order = (OrderData[]) new Object[size];
        
    }
    
    //Increases length by 1 everytime it is invoked
    public void push(OrderData newEntry){
        length++;   
        if (isArrayFull()){
            doubleArray();
        }
        order[length] = newEntry;
    }
    
    //Decreases length by 1 every time this is invoked and returns the object
    public OrderData pop(){
        OrderData object = order[length];
        order[length] = null;
        length--;
        return object;  //Returns OrderData object on top of the stack
    }
    
    //Returns the OrderData object on top of the stack
    public OrderData peek(){
        return order[length];
    }
    
    //Removes the object with the index passed into the method
    public void removeSelected(int index){
        int pointer = index;    //Points to the index that needs to be removed
        if (index >= 0){
            for (int counter = length; counter >= pointer; counter--){
                if ((counter) != (length+1)){
                    order[counter] = order[counter+1];
                    length--;
                }
                else {
                    order[counter] = null;
                    length--;
                }
            }
        }
    }
    
    //Checks if the stack is empty, returns boolean value
    public boolean isEmpty(){
        if (length == -1){
            return true;
        }
        else
            return false;
    }
    
    //Sets length to -1 
    //Causes stack information to be "reset" but does not affect existing size
    public void clear(){
        length = -1;
    }
    
    //Checks if array is full, returns boolean value 
    private boolean isArrayFull(){
        if (length >= size){
            return true;
        }
        else 
            return false;
    }
    
    //Doubles the size of the array when invoked
    private void doubleArray(){
        size = size * 2;
        
        OrderData[] oldArray = order;
        order = (OrderData[]) new Object[size];
        for (int counter = 0; counter < oldArray.length; counter++){
            order[counter] = oldArray[counter];
        }
    }
    
    private class Node{
        private OrderData data;
        private Node top;
        
        public Node(OrderData Data){
            this.data = Data;
            this.top = null;
        }
        
        public Node(OrderData Data, Node top){
            this.data = Data;
            this.top = top;
        }
    }
}
