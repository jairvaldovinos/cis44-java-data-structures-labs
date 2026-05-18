public class Main {

    public static void main(String[] args) {

        System.out.println("=== Normal Test ===");

        MaxHeap heap = new MaxHeap();

        heap.insert(new Task("Task A", 3));
        heap.insert(new Task("Task B", 10));
        heap.insert(new Task("Task C", 5));

        Task highest = heap.poll();

        if (highest != null && highest.getPriority() == 10) {
            System.out.println("PASS: Highest priority removed first");
        } else {
            System.out.println("FAIL: Incorrect priority order");
        }

        System.out.println();

        System.out.println("=== Empty Heap Test ===");

        MaxHeap emptyHeap = new MaxHeap();

        if (emptyHeap.poll() == null) {
            System.out.println("PASS: Empty heap handled correctly");
        } else {
            System.out.println("FAIL: Empty heap error");
        }

        System.out.println();

        System.out.println("=== Edge Case Test (Same Priority) ===");

        MaxHeap tieHeap = new MaxHeap();

        tieHeap.insert(new Task("Task X", 7));
        tieHeap.insert(new Task("Task Y", 7));

        Task result = tieHeap.poll();

        if (result != null && result.getPriority() == 7) {
            System.out.println("PASS: Tie priority handled correctly");
        } else {
            System.out.println("FAIL: Tie priority issue");
        }
    }
}
