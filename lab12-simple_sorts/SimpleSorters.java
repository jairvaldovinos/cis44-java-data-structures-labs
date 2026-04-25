import java.util.Comparator;

public class SimpleSorters {

    /**
     * Optimized Bubble Sort (stops early if already sorted)
     */
    public static <K> void bubbleSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (comp.compare(S[j], S[j + 1]) > 0) {
                    // swap
                    K temp = S[j];
                    S[j] = S[j + 1];
                    S[j + 1] = temp;

                    swapped = true;
                }
            }

            // stop early if no swaps happened
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Standard Insertion Sort
     */
    public static <K> void insertionSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        for (int i = 1; i < n; i++) {
            K cur = S[i];
            int j = i - 1;

            // shift bigger elements to the right
            while (j >= 0 && comp.compare(S[j], cur) > 0) {
                S[j + 1] = S[j];
                j--;
            }

            // insert current element
            S[j + 1] = cur;
        }
    }
}
