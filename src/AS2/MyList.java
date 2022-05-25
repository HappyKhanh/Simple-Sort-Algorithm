package AS2;

public class MyList {
    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }


    public MyList(){}

    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }
    public boolean isEmpty(){
        return (this.head==null);
    }
    public int length(){
        Node current = head;
        int length = 0;
        while (current != null){
            length++;
            current = current.getNext();
        }
        return length;
    }

    public void insertToHead (Product p){
        if (this.isEmpty()){
            this.tail = this.head = new Node(p);
        } else {
            this.head = new Node(p, this.head);
        }
    }
    public void insertToTail(Product p){
        if (this.isEmpty()){
            this.tail = this.head = new Node(p);
        } else {
            this.tail.setNext(new Node(p));
            this.tail = this.tail.getNext();
        }
    }
    public void deleteHead() {
        if (!this.isEmpty()) {
            this.head = this.head.getNext();
        }
    }

    public void insertAfterPosition(int position, Product p){
        if (!this.isEmpty()) {
            if (position > this.length()+1) {
                System.out.println("Danh sách chưa đủ độ dài cần thiết, hãy thử lại");
            } else if (position == 1) {
                insertToHead(p);
            } else if(position == length()+1){
                insertToTail(p);
            }
            else {
                Node current = this.head;
                int pos = 1;
                while (pos != (position - 1)) {
                    pos++;
                    current = current.getNext();
                }
                current.setNext(new Node(p, current.getNext()));
            }
        }
    }
    public void deleteTail(){
        if (!this.isEmpty()){
            if (this.head == this.tail){
                deleteHead();
            }
            Node current = this.head;
            Node prev = null;
            while (current != tail){
                prev = current;
                current = current.getNext();
            }
            prev.setNext(null);
            this.tail = prev;
        }
    }
    public void deleteElement(Product p) {
        if (!this.isEmpty()) {
            Node current = this.head;
            Node prev = null;
            if(this.head.getInfo().equals(p)){
                current = current.getNext();
                this.head = current;
            }
            if (this.tail.getInfo().equals(p)){
                this.deleteTail();
            }
            while (current != null) {
                if (current.getInfo().equals(p)){
                    prev.setNext(current.getNext());
                    current = current.getNext();
                    continue;
                }
                prev = current;
                current = current.getNext();

            }
        }
    }
    public void clear(){
        this.head=null;
        this.tail=null;
    }

    public void swap (Node fNode, Node sNode){
        Product p = fNode.getInfo();
        fNode.setInfo(sNode.getInfo());
        sNode.setInfo(p);
    }
    @Override
    public String toString() {
        String result="";
        Node current = this.head.getNext();
        while (current != tail) {
            result += current.toString() + "\n";
            current = current.getNext();
        }
        return "head: " + head +"\n"+
                result+
                "tail: " + tail +"\n";
    }
}
