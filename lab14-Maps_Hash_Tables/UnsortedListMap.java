import java.util.ArrayList;

class UnsortedListMap<K, V> implements MapADT<K, V> {

    private ArrayList<Entry<K, V>> list = new ArrayList<>();

    private int findEntryIndex(K key) {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public V get(K key) {

        int i = findEntryIndex(key);

        return (i != -1) ? list.get(i).getValue() : null;
    }

    public V remove(K key) {

        int i = findEntryIndex(key);

        if (i != -1) {

            V oldValue = list.get(i).getValue();

            list.remove(i);

            return oldValue;
        }

        return null;
    }

    // O(n)
    public V put(K key, V value) {

        int i = findEntryIndex(key);

        // Key already exists
        if (i != -1) {
            return list.get(i).setValue(value);
        }

        // Add new entry
        list.add(new Entry<>(key, value));

        return null;
    }
}
