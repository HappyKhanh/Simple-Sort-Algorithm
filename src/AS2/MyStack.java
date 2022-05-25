package AS2;

public class MyStack {

    private Node headStack;

    public Node getHeadStack() {
        return headStack;
    }
    public boolean isEmpty(){
        return this.headStack==null;
    }

    public void push(Product p) {
        this.headStack = new Node(p,headStack);
    }
    public void clear(){
        this.headStack = null;
    }
}
