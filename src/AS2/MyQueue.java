package AS2;

public class MyQueue {
    private Node head;
    private Node tail;

    public MyQueue(){
        head=tail=null;
    }

    public Node getHead() {
        return head;
    }

    public boolean isEmpty() {
        return(head==null);
    }

    public Product front() throws Exception {
      if (!isEmpty()){
          return head.getInfo();
      }else {
          throw new Exception();
      }
    }
    public Product dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        } else {
            Product x = head.getInfo();
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            return x;
        }
    }
    public void enqueue(Product x) {
        if(isEmpty()){
        head = tail = new Node(x);}
    else{
        tail.setNext(new Node(x));
        tail = tail.getNext();
    }
    }
    public void clear(){
        this.head=null;
        this.tail=null;
    }

}
