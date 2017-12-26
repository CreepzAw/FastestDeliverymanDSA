package Module_D;


public interface QueueInterface<T> {

    public void addDeliveryMan(T newEntry);

    public T listDeliveryMan();

    public T getLatest();
    
    public int getLength();
    
    public T getEntry(int givenPosition);

    public boolean isEmpty();

    public void clear();
}
