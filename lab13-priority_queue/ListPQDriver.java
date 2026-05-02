import java.util.LinkedList;

// --- 1. Entry ADT ---
class MyEntry<K extends Comparable<K>, V> implements Comparable<MyEntry<K, V>> {
    private K key;
    private V value;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }

    @Override
    public int compareTo(MyEntry<K, V> other) {
        return this.key.compareTo(other.key);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

// --- 2. Common Interface ---
interface PriorityQueue<K extends Comparable<K>, V> {
    void insert(K key, V value);
    MyEntry<K, V> removeMin();
    MyEntry<K, V> min();
    boolean isEmpty();
}

// --- 3. Unsorted List Implementation ---
// Insert: O(1) | RemoveMin: O(n)
class UnsortedListPQ<K extends Comparable<K>, V> implements PriorityQueue<K, V> {
    private LinkedList<MyEntry<K, V>> list = new LinkedList<>();

    public boolean isEmpty() { return list.isEmpty(); }

    public void insert(K key, V value) {
        list.addLast(new MyEntry<>(key, value)); // fast insert
    }

    public MyEntry<K, V> min() {
        if (isEmpty()) return null;

        MyEntry<K, V> minEntry = list.getFirst();

        for (MyEntry<K, V> entry : list) {
            if (entry.compareTo(minEntry) < 0) {
                minEntry = entry;
            }
        }
        return minEntry;
    }

    public MyEntry<K, V> removeMin() {
        if (isEmpty()) return null;

        // Find smallest entry
        MyEntry<K, V> minEntry = list.getFirst();

        for (MyEntry<K, V> entry : list) {
            if (entry.compareTo(minEntry) < 0) {
                minEntry = entry;
            }
        }

        // Remove it from the list
        list.remove(minEntry);

        return minEntry;
    }
}

// --- 4. Sorted List Implementation ---
// Insert: O(n) | RemoveMin: O(1)
class SortedListPQ<K extends Comparable<K>, V> implements PriorityQueue<K, V> {
    private LinkedList<MyEntry<K, V>> list = new LinkedList<>();

    public boolean isEmpty() { return list.isEmpty(); }

    public void insert(K key, V value) {
        MyEntry<K, V> newEntry = new MyEntry<>(key, value);

        // If list is empty, just add
        if (list.isEmpty()) {
            list.add(newEntry);
            return;
        }

        // Find correct position
        int index = 0;
        for (MyEntry<K, V> entry : list) {
            if (newEntry.compareTo(entry) < 0) {
                list.add(index, newEntry);
                return;
            }
            index++;
        }

        // If it's the largest, add at the end
        list.addLast(newEntry);
    }

    public MyEntry<K, V> min() {
        return isEmpty() ? null : list.getFirst();
    }

    public MyEntry<K, V> removeMin() {
        return isEmpty() ? null : list.removeFirst();
    }
}

// --- 5. Driver Class ---
public class ListPQDriver {
    public static void main(String[] args) {

        System.out.println("--- UnsortedListPQ (O(n) removal) ---");
        PriorityQueue<Integer, String> pq1 = new UnsortedListPQ<>();

        pq1.insert(5, "Task E");
        pq1.insert(1, "Task A");
        pq1.insert(10, "Task G");
        pq1.insert(3, "Task C");

        while (!pq1.isEmpty()) {
            System.out.println("Removed: " + pq1.removeMin());
        }

        System.out.println("\n--- SortedListPQ (O(n) insertion) ---");
        PriorityQueue<Integer, String> pq2 = new SortedListPQ<>();

        pq2.insert(5, "Task E");
        pq2.insert(1, "Task A");
        pq2.insert(10, "Task G");
        pq2.insert(3, "Task C");

        while (!pq2.isEmpty()) {
            System.out.println("Removed: " + pq2.removeMin());
        }
    }
}
