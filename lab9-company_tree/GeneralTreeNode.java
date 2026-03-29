import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {
    String name; // Employee name or department title
    GeneralTreeNode parent;
    List<GeneralTreeNode> children;

    public GeneralTreeNode(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    // Add a child node and set its parent
    public void addChild(GeneralTreeNode child) {
        child.parent = this;
        this.children.add(child);
    }

    /**
     * Preorder Traversal
     * Visit current node first, then children
     */
    public void traversePreorder() {
        // print current node
        System.out.println(this.name);

        // visit children
        for (GeneralTreeNode child : children) {
            child.traversePreorder();
        }
    }

    /**
     * Postorder Traversal
     * Visit children first, then current node
     */
    public void traversePostorder() {
        // visit children first
        for (GeneralTreeNode child : children) {
            child.traversePostorder();
        }

        // then print current node
        System.out.println(this.name);
    }
}
