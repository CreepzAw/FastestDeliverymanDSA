package Module_D;


public class LinkedQueue<T> implements QueueInterface<T> {

    private Node lastNode;
    private int length;

    public LinkedQueue() {
        lastNode = null;
        length = 0;
    }

    @Override
    public void addDeliveryMan(T newElement) {/*add deliveryman to the list*/
        if (isEmpty()) {
            Node newNode = new Node(newElement);
            lastNode = newNode;
            lastNode.next = newNode;
            lastNode.previous = newNode;

        } else {
            Node newNode = new Node(newElement, lastNode.next, lastNode);
            lastNode.next = newNode;
            lastNode = newNode;
            lastNode.next.previous = lastNode;
        }
        length++;
    }

    public T listDeliveryMan() {/*remove deliveryman from the list*/
        if (isEmpty()) {
            return null;
        } else if (lastNode.next == lastNode) {
            T temp = lastNode.next.data;
            lastNode = null;
            return temp;
        } else {
            T temp = lastNode.next.data;
            lastNode.next = lastNode.next.next;
            lastNode.next.previous = lastNode;
            return temp;
        }

    }

    @Override
    public T getLatest() {/*get the lastest deliveryman on the list*/
        if (isEmpty()) {
            return null;
        } else {
            return lastNode.next.data;
        }
    }

    public int getLength() {//get the length of the list
        return length;
    }
    
    public T getEntry(int givenPosition) {//get the specific position of entry in the list
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= length)) {
            //currentNode to the firstNode
            Node currentNode = lastNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                //advance currentNode to next node
                currentNode = currentNode.next;
            }
            //current is pointing to the Node at givenPosition
            result = currentNode.data;
        }
        return result;
    }

    @Override
    public boolean isEmpty() {/*check list isn't empty*/
        return lastNode == null;
    }

    @Override
    public void clear() {/*clear list*/
        lastNode = null;
    }

    private class Node {

        private T data;
        private Node next;
        private Node previous;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        public T getData() {
            return this.data;
        }

        public Node getNext() {
            return this.previous;
        }
    }

}
