package Broccoli;

import Broccoli.Tasks.Task;

import java.util.ArrayList;
import java.util.Scanner;

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


    public static void main(String[] args) {
        Broccoli broccoli = new Broccoli();
        System.out.println(broccoli.userInterface.getHorizontalLine());
        broccoli.userInterface.greeting();
        broccoli.parser.echo(broccoli.tasklist);
    }
}
