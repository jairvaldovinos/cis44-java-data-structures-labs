import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a single document that we want to print.
 * Stores the name of the document and how many pages it has.
 */
class PrintJob {
    private String documentName;
    private int pageCount;

    // Constructor: create a new print job with a name and page count
    public PrintJob(String documentName, int pageCount) {
        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    // Return a readable description of this print job
    @Override
    public String toString() {
        return "PrintJob[Document: " + documentName + ", Pages: " + pageCount + "]";
    }
}

/**
 * Simulates a printer that manages a queue of print jobs.
 * Jobs are processed in the order they are added (FIFO).
 */
public class Printer {

    // A queue to hold our print jobs
    private Queue<PrintJob> jobQueue;

    // Constructor: set up an empty queue for our jobs
    public Printer() {
        jobQueue = new LinkedList<>();
    }

    /**
     * Add a new print job to the end of the queue.
     * @param job The print job to add.
     */
    public void addJob(PrintJob job) {
        System.out.println("Adding job to queue: " + job);
        jobQueue.offer(job); // Add to the queue
    }

    /**
     * Process the next print job in the queue.
     * If there are no jobs left, let the user know.
     */
    public void processNextJob() {
        if (jobQueue.isEmpty()) {
            System.out.println("No jobs left to print. The printer is idle.");
        } else {
            PrintJob nextJob = jobQueue.poll(); // Remove the job from the front
            System.out.println("Printing now: " + nextJob);
        }
    }

    public static void main(String[] args) {
        Printer officePrinter = new Printer();

        // Add a few jobs to start with
        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting the printing process ---");
        officePrinter.processNextJob(); // Should print Annual_Report.pdf
        officePrinter.processNextJob(); // Should print Meeting_Agenda.docx

        System.out.println("\nWhoa! A high-priority job just came in...");
        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

        // Continue processing remaining jobs
        officePrinter.processNextJob(); // Should print Presentation_Slides.pptx
        officePrinter.processNextJob(); // Should print Urgent_Memo.pdf
        officePrinter.processNextJob(); // Queue is empty now
    }
}
