package Module_C;

public class OrderStack<OrderData> implements OrderStack_Interface<OrderData> {
    OrderData[] order;
    int length = -1;
    int size = 1;
    
    public OrderStack(){
        order = (OrderData[]) new Object[size];
    }
    
    
    @Override
    public void push(OrderData newEntry){
        length++;
        if (isArrayFull()){
            doubleArray();
        }
        order[length] = newEntry;
    }
    public OrderData pop(){
        OrderData object = order[length];
        order[length] = null;
        length--;
        return object;
    }
    public OrderData peek(){
        return order[length];
    }
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
    public boolean isEmpty(){
        if (length == -1){
            return true;
        }
        else
            return false;
    }
    public void clear(){
        length = -1;
    }
    
    private boolean isArrayFull(){
        if (length >= size){
            return true;
        }
        else 
            return false;
    }
    private void doubleArray(){
        size = size * 2;
        
        OrderData[] oldArray = order;
        order = (OrderData[]) new Object[size];
        for (int counter = 0; counter < oldArray.length; counter++){
            order[counter] = oldArray[counter];
        }
    }
}
