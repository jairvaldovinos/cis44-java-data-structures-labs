import java.util.Scanner;

public class PlaylistApp {

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Music Playlist Menu ====");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Next Song");
            System.out.println("4. Display Playlist");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    playlist.addSong(new Song(title, artist));
                    break;

                case 2:
                    System.out.print("Enter song title to remove: ");
                    String removeTitle = scanner.nextLine();
                    playlist.removeSong(removeTitle);
                    break;

                case 3:
                    playlist.playNext();
                    break;

                case 4:
                    playlist.displayPlaylist();
                    break;

                case 5:
                    System.out.println("Goodbye! 🎶");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
