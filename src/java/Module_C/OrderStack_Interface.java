package Module_C;

public interface OrderStack_Interface<OrderData> {
    public void push(OrderData newEntry);
    public OrderData pop();
    public OrderData peek();
    public boolean isEmpty();
    public void clear();
}
