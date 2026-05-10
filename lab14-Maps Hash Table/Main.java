public class Main {

    public static void main(String[] args) {

        SeparateChainingMap<String, String> map =
                new SeparateChainingMap<>();

        System.out.println("put(cat, A): "
                + map.put("cat", "A"));

        System.out.println("put(tac, B): "
                + map.put("tac", "B"));

        System.out.println("put(act, C): "
                + map.put("act", "C"));

        System.out.println("get(cat): "
                + map.get("cat"));

        System.out.println("get(tac): "
                + map.get("tac"));

        System.out.println("remove(act): "
                + map.remove("act"));
    }
}
