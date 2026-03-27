package project.list;

public class Node{
    private String data;
    private Node next;
    private Node prev;

    //metodo construtor
    public Node(String data) {
        this.data = data; 
        this.next = null;
        this.prev = null;
    }

    public String getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
