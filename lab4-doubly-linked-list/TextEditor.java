public class TextEditor {

    private static class Node {
        String textState;
        Node prev;
        Node next;

        Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        // start with empty text
        currentNode = new Node("", null, null);
    }

    // Add new text
    public void add(String newText) {
        // Combine current text with new text
        String updatedText = currentNode.textState + newText;

        // Clear redo history
        currentNode.next = null;

        // Create new node
        Node newNode = new Node(updatedText, currentNode, null);
        currentNode.next = newNode;

        // Move current pointer
        currentNode = newNode;

        System.out.println("Added: \"" + newText + "\"");
    }

    // Undo: move back in history
    public String undo() {
        if (currentNode.prev != null) {
            currentNode = currentNode.prev;
            System.out.println("Undo performed.");
            return currentNode.textState;
        } else {
            System.out.println("Cannot undo further.");
            return currentNode.textState;
        }
    }

    // Redo: move forward in history
    public String redo() {
        if (currentNode.next != null) {
            currentNode = currentNode.next;
            System.out.println("Redo performed.");
            return currentNode.textState;
        } else {
            System.out.println("Cannot redo further.");
            return currentNode.textState;
        }
    }

    // Print current text
    public void printCurrent() {
        System.out.println("Current text: \"" + currentNode.textState + "\"");
    }
}
