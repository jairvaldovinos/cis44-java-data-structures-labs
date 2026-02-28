// This class just runs everything so we can test it.

public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        // Add starting items
        inventory.addItem(new Item("Stick"));
        inventory.addItem(new Item("Crystal"));
        inventory.addItem(new Item("Rope"));

        // Show inventory before combining
        inventory.display();

        // Try combining Stick + Crystal
        inventory.combineItems("Stick", "Crystal");

        // Show inventory after combining
        inventory.display();
    }
}
