public class Stack {
    Node top;

    public Node pop() {
        if (top != null) {
            Node n = new Node(top.data);
            top = top.next;
            return n;
        }
        return null;
    }

    public void push(char d) {
        Node n = new Node(d);
        if (top != null) {
            n.next = top;
        }
        top = n;
    }

    boolean isEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }
}