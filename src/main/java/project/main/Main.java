package project.main;

import project.list.DoublyLinkedList;
import project.list.Node;
import project.util.FileService;
import project.util.TextProcessor;
import project.tree.BinarySearchTree;
import project.stack.MyStack;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> lines = FileService.readFile("testeee.txt");
        MyStack<BinarySearchTree> stack = new MyStack<>();

        for (String line : lines) {

            BinarySearchTree tree = new BinarySearchTree(); //cria a bst
            DoublyLinkedList list = new DoublyLinkedList(); //cria a lista dupla

            //método: usa os espaços em branco como separação
            String[] words = TextProcessor.splitWords(line);

            //insere cada palavra na lista dupla
            for (String word : words) {
                if (!word.isEmpty()) {
                    list.insertToBack(word);
                }
            }

            Node current = list.getTail(); //percorre ao contrário
            while (current != null) { //(até o primeiro da lista)
                tree.insert(current.getData()); //insere a palavra na árvore
                current = current.getPrev(); //segue para o nó anterior
            }

            stack.push(tree); //joga a árvore na pilha: empilhando
        }

        while (!stack.isEmpty()) { //execução do hash linha por linha
            BinarySearchTree poppedTree = stack.pop();
            System.out.println(poppedTree.generateHash());
        }
    }
}
