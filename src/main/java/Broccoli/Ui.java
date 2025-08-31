package Broccoli;

import Broccoli.Tasks.Task;

import java.util.Scanner;

/**
 * Handles user interface interactions and display formatting.
 */
public class Ui {
    private Scanner scanner;
    private String horizontalLine;

    public Ui(){
        this.scanner = new Scanner(System.in);
        this.horizontalLine = getHorizontalLine();
    }

    /**
     * Returns a horizontal line string.
     *
     * @return A string of dashes.
     */
    public String getHorizontalLine(){
        StringBuilder horizontal = new StringBuilder();
        int count = 60;
        char line = '-';
            while(count >= 0) {
                horizontal.append(line);
                count --;
            }
      return horizontal.toString();
    }

    /**
     * Displays the greeting to the user.
     */
 public void greeting() {
    System.out.println("Hello! Hello! Hello! I'm Broccoli.Your Green Task Buddy!\n" + "Tell me what you gonna do and I will help you track them!\n" + horizontalLine.toString());
}

    /**
     * Displays the goodbye message to the user.
     */
 public void exiting() {
     System.out.println("Bye! Wish you come back with tasks done!\n" + this.horizontalLine);
}
    /**
     * Displays all tasks in the task list.
     *
     * @param taskList The task list to display.
     */
    public void displayList(TaskList taskList){
        System.out.println(horizontalLine.toString());
        System.out.println("Quickly go and finish all the UNDONE tasks!");
        taskList.printTask();
        System.out.println(horizontalLine.toString());
    }

    /**
     * Handles marking a task as done based on user input.
     *
     * @param taskList The task list containing the tasks available for user to mark.
     * @param storage The storage component for saving changes.
     */
    public void mark(TaskList taskList, Storage storage){

        System.out.println("Which task would you like to mark as done? Please enter the number:");
        taskList.printTask();;
        System.out.println(horizontalLine.toString());
        //Scanner scanner1 = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        int index = number - 1;
        if(index >= taskList.getList().stream().count()){
            throw new IllegalArgumentException("Task does not exist, please re-enter a valid one!");
        }
        Task markTask = taskList.getList().get(index);
        markTask.markAsDone();
        storage.writeToFile();
        System.out.println("Nice! I've marked this task as done:\n" + markTask.toString());
    }
    /**
     * Handles unmarking a task as not done based on user input.
     *
     * @param taskList The task list containing the tasks available for user to unmark.
     * @param storage The storage component for saving changes.
     */
    public void unmark(TaskList taskList, Storage storage){
        System.out.println("Which task would you like to unmark as done? Please enter the number:");
         taskList.printTask();
        System.out.println(horizontalLine.toString());
        //  Scanner scanner1 = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        int index = number - 1;
        if(index >= taskList.getList().stream().count()){
            throw new IllegalArgumentException("Task does not exist, please re-enter a valid one!");
        }
        Task markTask = taskList.getList().get(index);
        markTask.markAsUndone();
        storage.writeToFile();
        System.out.println("OK, I've marked this task as not done yet:\n" + markTask.toString());
    }

    /**
     * Handles deleting a task based on user input.
     *
     * @param taskList The task list containing the task to delete.
     * @param storage The storage component for saving changes.
     */
    public void delete(TaskList taskList, Storage storage){
        System.out.println("Which task would you like to delete? Please enter the number:");
       taskList.printTask();
       System.out.println(horizontalLine.toString());
        //  Scanner scanner1 = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        int index = number - 1;
        if(index >=taskList.getList().stream().count()){
            throw new IllegalArgumentException("Task does not exist, please re-enter a valid one!");
        }
        Task markTask = taskList.getList().get(index);
        taskList.remove(index);
        storage.writeToFile();
        System.out.println("Noted. I've removed this task:\n" + markTask.toString());
        int undone = (int) taskList.getList().stream().filter(a -> !a.getDone()).count();
        System.out.println("Hurry up! You have " + undone + " tasks unfinished!");
    }
        }


