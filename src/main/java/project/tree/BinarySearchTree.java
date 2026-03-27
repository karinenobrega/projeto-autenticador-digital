package project.tree;

public class BinarySearchTree {
    
    private Node root;

    private static class Node {
        String data;
        Node left;
        Node right;
        int height;

        Node(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1; //altura do node

        }
    }

    public void insert(String data) { //parte publica do método
        root = insertRec(root, data);
    }

    private Node insertRec(Node current, String data) { //parte privada do método
        
        if (current == null) { //se o current for null, já cria o node
            return new Node(data);
        }

        int compare = data.compareToIgnoreCase(current.data); //faz a comparação: menor(<0) maior(>0) igual(0)

        if (compare < 0) {
            current.left = insertRec(current.left, data); //se menor, entra na recursividade agora com o nó filho esquerdo
        } else if (compare > 0) {
            current.right = insertRec(current.right, data); //se maior, entra na recursividade agora com o nó filho direito
        }

        //como não tem comparação com igual, as duplicatas são ignoradas.

        updateHeight(current); //atualiza a altura

        int balance = getBalance(current);

        //esquerda
        if (balance > 1) { //se a avl estiver desbalanceada pra esquerda

            if (data.compareToIgnoreCase(current.left.data) < 0) { //se entrou à esquerda do filho da esquerda
                return rotateRight(current); //caso simples
            }

            if (data.compareToIgnoreCase(current.left.data) > 0) { //se entrou à direita do filho da esquerda
                current.left = rotateLeft(current.left); //caso torto
                return rotateRight(current);
            }
        }

        //direita
        if (balance < -1) { //se a avl estiver desbalanceada pra direita

            if (data.compareToIgnoreCase(current.right.data) > 0) { //se entrou à direita do filho da direita
                return rotateLeft(current); //caso simples
            }

            if (data.compareToIgnoreCase(current.right.data) < 0) { //se entrou à esquerda do filho da direita
                current.right = rotateRight(current.right); //caso torto
                return rotateLeft(current);
            }
        }

        return current;
    }
    
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private Node rotateRight(Node c) {
        Node b = c.left;
        Node y = b.right;

        //rotação pra direita:
        b.right = c;
        c.left = y;

        //atualizar alturas
        updateHeight(c);
        updateHeight(b);

        return b;
    }

    private Node rotateLeft(Node d) {
        Node e = d.right;
        Node y = e.left;

        //rotação pra esquerda:
        e.left = d;
        d.right = y;

        //atualizar alturas
        updateHeight(d);
        updateHeight(e);

        return e;
    }

    //Método para calcular o hash da árvore na ordem correta
    public String generateHash() {
        return generateHashRec(root);
    }

    private String generateHashRec(Node current) {
        if (current == null) {
            return "";
        }

        String leftHash = generateHashRec(current.left);
        String rightHash = generateHashRec(current.right);

        String nodeHash = project.util.HashService.generateHash(current.data);
        String combined = leftHash + rightHash + nodeHash;

        return project.util.HashService.generateHash(combined);
    }
}
