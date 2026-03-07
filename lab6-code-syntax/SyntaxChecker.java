import java.util.EmptyStackException;

/*
 * Simple Stack interface.
 * Defines the basic operations any stack should support.
 */
interface Stack<E> {
    void push(E element);   // add element to top
    E pop();                // remove element from top
    E peek();               // look at top element without removing
    boolean isEmpty();      // check if stack is empty
}

/*
 * ArrayStack class
 * A basic stack implementation using an array.
 */
class ArrayStack<E> implements Stack<E> {

    private E[] data;   // array to store stack elements
    private int top;    // index of the top element

    // constructor that creates the stack with a fixed size
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
        top = -1; // stack starts empty
    }

    // push: adds an element to the top of the stack
    public void push(E element) {
        data[++top] = element;
    }

    // pop: removes and returns the top element
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[top--];
    }

    // peek: returns the top element without removing it
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[top];
    }

    // checks if stack has no elements
    public boolean isEmpty() {
        return top == -1;
    }
}

/*
 * SyntaxChecker class
 * Uses a stack to check if symbols in a line of code are balanced.
 */
public class SyntaxChecker {

    /**
     * Checks if (), {}, and [] are balanced in a string.
     * Any other characters are ignored.
     */
    public static boolean isBalanced(String line) {

        // create stack large enough to hold characters from the line
        Stack<Character> buffer = new ArrayStack<>(line.length());

        // go through each character in the string
        for (int i = 0; i < line.length(); i++) {

            char current = line.charAt(i);

            // if we find an opening symbol, push it on the stack
            if (current == '(' || current == '{' || current == '[') {
                buffer.push(current);
            }

            // if we find a closing symbol, check if it matches
            else if (current == ')' || current == '}' || current == ']') {

                // if stack is empty, there is nothing to match
                if (buffer.isEmpty()) {
                    return false;
                }

                // pop the most recent opening symbol
                char last = buffer.pop();

                // check if the symbols match
                if (current == ')' && last != '(') {
                    return false;
                }

                if (current == '}' && last != '{') {
                    return false;
                }

                if (current == ']' && last != '[') {
                    return false;
                }
            }
        }

        // if stack is empty, everything matched correctly
        // if not empty, there are unmatched opening symbols
        return buffer.isEmpty();
    }

    /*
     * Main method used for testing the syntax checker.
     */
    public static void main(String[] args) {

        String line1 = "public static void main(String[] args) { ... }";
        String line2 = "int x = (5 + [a * 2]);";
        String line3 = "System.out.println('Hello');)";
        String line4 = "List list = new ArrayList<{String>();";
        String line5 = "if (x > 0) {";

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}
