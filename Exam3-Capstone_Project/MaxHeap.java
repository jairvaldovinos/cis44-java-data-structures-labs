import java.util.ArrayList;

public class MaxHeap {

    private ArrayList<Task> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public void insert(Task task) {
        heap.add(task);
        heapifyUp(heap.size() - 1);
    }

    public Task peek() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    public Task poll() {
        if (heap.isEmpty()) {
            return null;
        }

        Task root = heap.get(0);
        Task lastItem = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastItem);
            heapifyDown(0);
        }

        return root;
    }

    private void heapifyUp(int index) {
        while (index > 0) {

            int parentIndex = (index - 1) / 2;

            if (heap.get(index).getPriority() >
                heap.get(parentIndex).getPriority()) {

                swap(index, parentIndex);
                index = parentIndex;

            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {

        while (index < heap.size()) {

            int leftChild = (2 * index) + 1;
            int rightChild = (2 * index) + 2;
            int largest = index;

            if (leftChild < heap.size() &&
                heap.get(leftChild).getPriority() >
                heap.get(largest).getPriority()) {

                largest = leftChild;
            }

            if (rightChild < heap.size() &&
                heap.get(rightChild).getPriority() >
                heap.get(largest).getPriority()) {

                largest = rightChild;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {

        Task temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
