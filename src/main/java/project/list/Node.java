package project.list;

public class Node{
    private String data; //palavra do texto
    private Node next; //ponteiro para frente
    private Node prev; //ponteiro para tras

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
