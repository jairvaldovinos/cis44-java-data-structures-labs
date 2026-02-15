public class Main {
    public static void main(String[] args) {

        DynamicArray<Integer> arr = new DynamicArray<>();

        for (int i = 0; i < 12; i++) {
            arr.add(i);
        }

        System.out.println("Size: " + arr.size());
        System.out.println("Item at index 5: " + arr.get(5));

        System.out.println("Removed: " + arr.remove(2));

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
