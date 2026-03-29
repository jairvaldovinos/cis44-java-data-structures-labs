public class BinaryTreeNode {
    String value; // operator like "+" or number like "3"
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(String value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    // Preorder: Parent -> Left -> Right (Prefix)
    public void traversePreorder() {
        System.out.print(this.value + " "); // visit parent first

        if (left != null) {
            left.traversePreorder();
        }

        if (right != null) {
            right.traversePreorder();
        }
    }

    // Inorder: Left -> Parent -> Right (Infix)
    public void traverseInorder() {
        if (left != null) {
            System.out.print("("); // helps show structure
            left.traverseInorder();
        }

        System.out.print(this.value + " ");

        if (right != null) {
            right.traverseInorder();
            System.out.print(")");
        }
    }

    // Postorder: Left -> Right -> Parent (Postfix)
    public void traversePostorder() {
        if (left != null) {
            left.traversePostorder();
        }

        if (right != null) {
            right.traversePostorder();
        }

        System.out.print(this.value + " "); // visit parent last
    }
}
