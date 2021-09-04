package data_structure;

/**
 * @author prateek.bangre on 20/07/21.
 * @Project Algorithm_Study
 */
public class BinarySearchTree {

    class Node{
        int key;
        Node left, right;

        Node(int item){
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree(){
        root = null;
    }

    private void insert(int key){
        root = insertKey(root, key);
    }

    // Insert key in the tree
    private Node insertKey(Node root, int key){

        // Return a new node if the tree is empty
        if (root == null){
            root = new Node(key);
            return root;
        }

        // Traverse to the right place and insert the node
        if (key < root.key){
            insertKey(root.left, key);
        }else if( key > root.key){
            insertKey(root.right, key);
        }

        return root;
    }

    private void inorder(){
        inOrderRec(root);
    }

    // Inorder Traversal
    private void inOrderRec(Node root){
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + " -> ");
            inOrderRec(root.right);
        }
    }

    private void deleteKey(int key){
        root = deleteKeyRec(root, key);
    }

    private Node deleteKeyRec(Node root, int key){
        // Return if the tree is empty
        if (root == null)
            return root;

        // Find the node to be deleted
        if (key < root.key)
            root.left = deleteKeyRec(root.left, key);
        else if (key > root.key)
            root.right = deleteKeyRec(root.right, key);
        else {
            // If the node is with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // If the node has two children
            // Place the inorder successor in position of the node to be deleted
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteKeyRec(root.right, root.key);
        }
        return root;
    }

    // Find the inorder successor
    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(4);

        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.println("\n\nAfter deleting 10");
        tree.deleteKey(10);
        System.out.print("Inorder traversal: ");
        tree.inorder();
    }
}
