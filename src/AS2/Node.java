package AS2;

public class Node {
    private Product info;
    private Node next;

    public Node(Product p){
        this.info = p;
    }
    public Node(Product info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Product getInfo() {
        return info;
    }

    public void setInfo(Product info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return ""+info;
    }
}

