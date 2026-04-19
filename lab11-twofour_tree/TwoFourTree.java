import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean isFull() {
        return keys.size() == 3;
    }

    public TwoFourNode getNextChild(int key) {
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    public void insertKey(int key) {
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // go down to leaf
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        // insert into leaf
        node.insertKey(key);

        // fix overflow
        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent;
        }
    }

    private void split(TwoFourNode node) {
        // keys: [a b c d] → b goes up
        int midIndex = 1;
        int middleKey = node.keys.get(midIndex);

        TwoFourNode leftNode = new TwoFourNode();
        TwoFourNode rightNode = new TwoFourNode();

        // left gets first key
        leftNode.keys.add(node.keys.get(0));

        // right gets last two keys
        rightNode.keys.add(node.keys.get(2));
        rightNode.keys.add(node.keys.get(3));

        // handle children if not leaf
        if (!node.isLeaf()) {
            for (int i = 0; i <= 1; i++) {
                leftNode.children.add(node.children.get(i));
                node.children.get(i).parent = leftNode;
            }
            for (int i = 2; i < node.children.size(); i++) {
                rightNode.children.add(node.children.get(i));
                node.children.get(i).parent = rightNode;
            }
        }

        // if node is root → create new root
        if (node.parent == null) {
            TwoFourNode newRoot = new TwoFourNode();
            newRoot.keys.add(middleKey);

            newRoot.children.add(leftNode);
            newRoot.children.add(rightNode);

            leftNode.parent = newRoot;
            rightNode.parent = newRoot;

            root = newRoot;
        } else {
            TwoFourNode parent = node.parent;

            // insert middle into parent
            parent.insertKey(middleKey);

            // replace old child with left/right
            int index = parent.children.indexOf(node);
            parent.children.remove(index);

            parent.children.add(index, rightNode);
            parent.children.add(index, leftNode);

            leftNode.parent = parent;
            rightNode.parent = parent;
        }
    }

    // inorder traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                inorder(node.children.get(i));
                System.out.print(node.keys.get(i) + " ");
            }
            inorder(node.children.get(i));
        }
    }
}
