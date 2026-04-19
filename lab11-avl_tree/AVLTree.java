// AVL Node class
class AVLNode {
    int key, height;
    AVLNode left, right;

    // Constructor
    AVLNode(int key) {
        this.key = key;
        this.height = 1; // new node starts as height 1
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {

    AVLNode root;

    // Return height of node
    int height(AVLNode N) {
        return (N == null) ? 0 : N.height;
    }

    // Max helper
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Balance factor
    int getBalance(AVLNode N) {
        return (N == null) ? 0 : height(N.left) - height(N.right);
    }

    // RIGHT ROTATION (LL case)
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x; // new root
    }

    // LEFT ROTATION (RR case)
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Rotate
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y; // new root
    }

    // LEFT-RIGHT ROTATION (LR case)
    AVLNode leftRightRotate(AVLNode z) {
        z.left = leftRotate(z.left);
        return rightRotate(z);
    }

    // RIGHT-LEFT ROTATION (RL case)
    AVLNode rightLeftRotate(AVLNode y) {
        y.right = rightRotate(y.right);
        return leftRotate(y);
    }

    // Public insert
    public void insert(int key) {
        root = insert(root, key);
    }

    // Recursive insert
    private AVLNode insert(AVLNode node, int key) {

        // 1. Normal BST insert
        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // no duplicates

        // 2. Update height
        node.height = 1 + max(height(node.left), height(node.right));

        // 3. Get balance
        int balance = getBalance(node);

        // 4. Handle imbalance

        // LL Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // RR Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // LR Case
        if (balance > 1 && key > node.left.key)
            return leftRightRotate(node);

        // RL Case
        if (balance < -1 && key < node.right.key)
            return rightLeftRotate(node);

        return node;
    }

    // ===== Traversals =====

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(AVLNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }
}
