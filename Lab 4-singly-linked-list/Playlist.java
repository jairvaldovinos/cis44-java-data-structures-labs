public class Playlist {

    private static class Node {
        Song song;
        Node next;

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        head = null;
        tail = null;
        currentNode = null;
        size = 0;
    }

    // Add song to the end
    public void addSong(Song song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = tail = newNode;
            currentNode = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println("Added: " + song);
    }

    // Remove first occurrence of a song by title
    public void removeSong(String title) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        // Case 1: Removing head
        if (head.song.getTitle().equalsIgnoreCase(title)) {
            if (currentNode == head) {
                currentNode = head.next;
            }

            head = head.next;
            size--;

            if (head == null) {
                tail = null;
                currentNode = null;
            }

            System.out.println("Song removed.");
            return;
        }

        // Case 2: Removing from elsewhere
        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.song.getTitle().equalsIgnoreCase(title)) {

                if (curr == currentNode) {
                    currentNode = curr.next;
                }

                prev.next = curr.next;

                if (curr == tail) {
                    tail = prev;
                }

                size--;
                System.out.println("Song removed.");
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Song not found.");
    }

    // Play current song and move to next (wrap around)
    public void playNext() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (currentNode == null) {
            currentNode = head;
        }

        System.out.println("Now playing: " + currentNode.song);

        currentNode = (currentNode.next != null) ? currentNode.next : head;
    }

    // Display all songs
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("\n🎵 Playlist:");
        Node temp = head;
        int index = 1;

        while (temp != null) {
            System.out.println(index++ + ". " + temp.song);
            temp = temp.next;
        }
    }
}
