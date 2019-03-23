public class Queue {
    Cell front;
    Cell rear;

    public void push(Cell c) {
        if (front == null) {
            front = c;
            rear = front;
        } else {
            rear.next = c;
            rear = rear.next;
        }
    }

    public Cell pop() {
        Cell c = null;
        if (front != null) {
            c = front;
            front = front.next;
        }
        return c;
    }

    public boolean isEmpty() {
        return (front == null);
    }
}
