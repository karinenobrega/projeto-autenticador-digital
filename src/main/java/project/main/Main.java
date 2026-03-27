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
        
        String fileName = "text.txt";

        List<String> lines = FileService.readFile(fileName);

        MyStack<BinarySearchTree> stack = new MyStack<>();

        for (String line : lines) {

            BinarySearchTree tree = new BinarySearchTree();
            
            //cria uma lista dupla para a linha
            DoublyLinkedList list = new DoublyLinkedList();

            //método: limpa o texto (pontuação, virgula e maiusculo)
            String cleanLine = TextProcessor.cleanText(line);

            //método: usa os espaços em branco como separação
            String[] words = TextProcessor.splitWords(cleanLine);

            //insere cada palavra em words dentro da lista criada
            for (String word : words) {
                if (!word.isEmpty()) {
                    list.insertToBack(word);
                }
            }

            Node current = list.getTail(); //percorre ao contrário
            
            while (current != null) { //enquanto o prev nao for null (até o primeiro da lista)
                tree.insert(current.getData());
                current = current.getPrev(); //segue para o nó anterior
            }

            stack.push(tree); //joga a árvore na pilha: empilhando
        }

        while (!stack.isEmpty()) { //execução do hash linha por linha
            BinarySearchTree poppedTree = stack.pop();
            String hash = poppedTree.generateHash();
            System.out.println(hash);
        }
    }
}
