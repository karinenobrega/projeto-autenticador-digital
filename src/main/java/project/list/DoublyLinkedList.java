package project.list;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    //construtor:
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    //método
    public void insertToBack(String data) {
        Node newNode = new Node(data);

        if (head == null) { //se a lista estiver vazia
            head = newNode;
            tail = newNode;
            return;
        }

        //caso nao esteja vazia
        tail.setNext(newNode); //o atual tail aponta para o newNode
        newNode.setPrev(tail); //o newNode aponta para tras o antigo tail
        tail = newNode; //o newNode agora é o tail
    }

    public Node getTail() {
        return tail;
    }
}
