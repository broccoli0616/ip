package Broccoli;

import Broccoli.Tasks.Task;

import java.util.Scanner;

/**
 * Handles parsing and processing of user input commands.
 * Coordinates between userInterface and task storage operations.
 */
public class Parser {
    private Storage storage;
    private Scanner scanner;
    private Ui userInterface;

    public Parser(Storage storage, Ui userInterface, Scanner scanner){
        this.storage = storage;
        this.userInterface = userInterface;
        this.scanner = scanner;
    }

    /**
     * Processes user input commands in a continuous loop until exit.
     * Handles commands like list, mark, unmark, delete, and task addition.
     *
     * @param taskList The task list to operate on.
     */
    public void echo(TaskList taskList) {
        String task = "";
        while(true) {
            task = scanner.nextLine();
            if(task.trim().equals("bye")) {
                this.userInterface.exiting();
                break;
            }
            if(task.equals("list".trim())){
                this.userInterface.displayList(taskList);
                continue;
            }
            if(task.trim().equals("mark".trim())){
                try{
                    this.userInterface.mark(taskList, storage);}
                catch(RuntimeException e){
                    System.out.println(e.getMessage());
                }
                continue;
            }
            if(task.trim().equals("unmark".trim())){
                try{
                    this.userInterface.unmark(taskList, storage);}
                catch(RuntimeException e){
                    System.out.println(e.getMessage());
                }
                continue;
            }

            if(task.trim().equals("delete".trim())){
                try{
                    this.userInterface.delete(taskList, storage);}
                catch(RuntimeException e){
                    System.out.println(e.getMessage());
                }
                continue;
            }
            Task newTask = null;
            try{
                newTask = Task.checkTask(task);
            } catch(RuntimeException e){
                System.out.println(e.getMessage());
                continue;
            }
            taskList.add(newTask);
            this.storage.writeToFile();
            System.out.println(userInterface.getHorizontalLine());
            System.out.println("Got it. I've added this task:\n" + newTask.toString());
            int undone = (int) taskList.getList().stream().filter(a -> !a.getDone()).count();
            System.out.println("Hurry up! You have " + undone + " tasks unfinished!");
            System.out.println(userInterface.getHorizontalLine().toString());

        }
    }
}
