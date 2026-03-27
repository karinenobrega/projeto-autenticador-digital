package project.stack;

public class MyStack<T> { //tipo generico, guarda qq tipo
    
    private Node<T> top; //declara o topo da linha

    //nó interno da pilha
    private static class Node<T> {
        T data; //dado de qq tipo
        Node<T> next; //declara o next

        //construtor
        Node(T data) {
            this.data = data; //seta o data
            this.next = null; //seta o next como null
        }
    }

    //empilhar
    public void push(T data) {
        Node<T> newNode = new Node<>(data); //cria um novo nó
        newNode.next = top; //o antigo top é agora o next do novo
        top = newNode; //o novo node agora é o top
    }

    //desempilhar
    public T pop() {
        if (top == null) { //se a pilha estiver vazia
            return null;
        }
        
        T value = top.data; //guarda o valor do topo
        top = top.next; //remove o top
        return value;
    }

    public boolean isEmpty() {
        return top == null; //verdadeiro se estiver vazio
    }
}
