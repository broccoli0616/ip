package Broccoli;

import Broccoli.Tasks.Task;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Represents the main application class that manages task tracking functionality.
 * Initializes and coordinates the user interface, storage, parser, and task list components.
 */
public class Broccoli {
    private Ui userInterface;
    private Storage storage;
    private Parser parser;
    private TaskList tasklist;
    private Scanner scanner;

    public Broccoli() {
        this.scanner = new Scanner(System.in);
        this.userInterface = new Ui();
        TaskList tasklist1 = new TaskList(new ArrayList<Task>());
        this.storage = new Storage(tasklist1, "./data/broccoli.txt");
        storage.loadFromFile();
        this.tasklist = new TaskList(storage.getTaskList());
        this.parser = new Parser(storage, userInterface,scanner);
    }

    /**
     * Starts the Broccoli task tracking application.
     * Displays greeting and begins the main interaction loop.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Broccoli broccoli = new Broccoli();
        System.out.println(broccoli.userInterface.getHorizontalLine());
        broccoli.userInterface.greeting();
        broccoli.parser.echo(broccoli.tasklist);
    }
}
