public class AVLTreeDriver {
    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        // Insert values
        tree.insert(10);
        tree.insert(20);
        tree.insert(30); // triggers LEFT rotation

        tree.insert(5);
        tree.insert(4);  // triggers RIGHT rotation

        tree.insert(8);  // triggers LEFT-RIGHT rotation

        tree.insert(25); // triggers RIGHT-LEFT rotation

        // Traversals
        System.out.print("Inorder: ");
        tree.inorder();

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();

        /*
        Expected behavior:

        Inorder (sorted):
        4 5 8 10 20 25 30

        Preorder (root-first, shows structure):
        ~ balanced tree (exact shape depends on rotations but should be valid AVL)

        Postorder:
        leaves first, root last

        Most important check:
        - Inorder MUST be sorted
        - Tree height remains minimal (balanced)
        */
    }
}
