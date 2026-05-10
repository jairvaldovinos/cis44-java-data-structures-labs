import java.util.ArrayList;
import java.util.LinkedList;

// Separate Chaining Hash Map
class SeparateChainingMap<K, V> implements MapADT<K, V> {

    private ArrayList<LinkedList<Entry<K, V>>> table;
    private int size = 0;
    private final int N = 11;

    public SeparateChainingMap() {

        table = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            table.add(new LinkedList<Entry<K, V>>());
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % N);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // O(1) expected time
    public V get(K key) {

        // 1. Calculate bucket index
        int h = hash(key);

        // 2. Get correct bucket
        LinkedList<Entry<K, V>> bucket = table.get(h);

        // 3. Search bucket
        for (Entry<K, V> entry : bucket) {

            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        // 4. Key not found
        return null;
    }

    public V put(K key, V value) {

        int h = hash(key);

        LinkedList<Entry<K, V>> bucket = table.get(h);

        // Key already exists
        for (Entry<K, V> entry : bucket) {

            if (entry.getKey().equals(key)) {

                return entry.setValue(value);
            }
        }

        // Add new entry
        bucket.addFirst(new Entry<>(key, value));

        size++;

        return null;
    }

    public V remove(K key) {

        int h = hash(key);

        LinkedList<Entry<K, V>> bucket = table.get(h);

        Entry<K, V> toRemove = null;

        for (Entry<K, V> entry : bucket) {

            if (entry.getKey().equals(key)) {

                toRemove = entry;

                break;
            }
        }

        if (toRemove != null) {

            V oldValue = toRemove.getValue();

            bucket.remove(toRemove);

            size--;

            return oldValue;
        }

        return null;
    }
}
