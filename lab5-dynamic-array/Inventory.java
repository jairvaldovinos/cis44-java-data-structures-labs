import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// This class stores and manages the player's items.
public class Inventory {

    private List<Item> items;

    // When an Inventory is created, start with an empty list.
    public Inventory() {
        this.items = new ArrayList<>();
    }

    // Adds a new item to the inventory.
    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getName() + " was added to your inventory.");
    }

    // Displays everything currently in the inventory.
    public void display() {
        System.out.println("\n--- Current Inventory ---");

        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }

        for (Item item : items) {
            System.out.println("- " + item);
        }
    }

    // Combines two items if both are found.
    // IMPORTANT: Uses an Iterator to safely remove items while looping.
    public void combineItems(String name1, String name2) {

        boolean foundFirst = false;
        boolean foundSecond = false;

        Iterator<Item> iter = items.iterator();

        while (iter.hasNext()) {
            Item current = iter.next();

            // If we find the first item and haven't removed it yet
            if (!foundFirst && current.getName().equalsIgnoreCase(name1)) {
                foundFirst = true;
                iter.remove();  // Safe removal using iterator
                continue;       // Move to next item
            }

            // If we find the second item and haven't removed it yet
            if (!foundSecond && current.getName().equalsIgnoreCase(name2)) {
                foundSecond = true;
                iter.remove();  // Safe removal using iterator
            }
        }

        // After the loop finishes, check if we found BOTH items
        if (foundFirst && foundSecond) {
            // Create the new combined item
            Item combined = new Item("Magic Staff");
            items.add(combined);

            System.out.println("\nYou combined " + name1 + " and " + name2 + " to create a Magic Staff!");
        } else {
            System.out.println("\nCombination failed. You don't have both required items.");
        }
    }
}
