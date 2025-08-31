package Broccoli;

import Broccoli.Tasks.Task;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ui {
    private Scanner scanner;
    private String horizontalLine;

    public Ui(){
        this.scanner = new Scanner(System.in);
        this.horizontalLine = getHorizontalLine();
    }

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


 public void greeting() {
    System.out.println("Hello! Hello! Hello! I'm Broccoli.Your Green Task Buddy!\n" + "Tell me what you gonna do and I will help you track them!\n" + horizontalLine.toString());
}

public void exiting() {
    System.out.println("Bye! Wish you come back with tasks done!\n" + this.horizontalLine);
}

    public void displayList(TaskList taskList){
        System.out.println(horizontalLine.toString());
        System.out.println("Quickly go and finish all the UNDONE tasks!");
        taskList.printTask();
        System.out.println(horizontalLine.toString());
    }

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
    public void find(TaskList taskList, Storage storage){

        System.out.println("Which task would you like to find? Please enter the key words:");
        String keyWords = scanner.nextLine();

        ArrayList<Task> taskList1 = (ArrayList<Task>) taskList.getList().stream().filter(task->task.getDescription().contains(keyWords)).collect(Collectors.toList());
        System.out.println(getHorizontalLine());
        if(taskList1.isEmpty()){
            System.out.println("There is not matching tasks");
        } else {
            System.out.println("Here are the matching tasks in your list:\n");
            TaskList matchedTasks = new TaskList(taskList1);
            matchedTasks.printTask();
//            int undone = (int) taskList.getList().stream().filter(a -> !a.getDone()).count();
//            System.out.println("Hurry up! You have " + undone + " tasks unfinished!");
        }
    }
        }


