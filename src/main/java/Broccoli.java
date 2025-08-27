import Tasks.Task;
import Tasks.DeadlineTask;
import Tasks.TodoTask;
import Tasks.EventTask;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Broccoli {
    private char line = '-';
    private int count = 60;
    private StringBuilder horizontalLine;
    private Scanner scanner;
    private ArrayList<Task> taskList;
    public Broccoli() {
        this.line = '-';
        this.count = 60;
        this.scanner = new Scanner(System.in);   // give access to whatever the user type
        this.horizontalLine = new StringBuilder();
        this.taskList = new ArrayList<>();
        loadFromFile();
    }

    public void setHorizontalLine() {
        while(this.count >= 0) {
            this.horizontalLine.append(line);
            count --;
        }
        System.out.println(this.horizontalLine.toString());
    }

    public void greeting() {
        System.out.println("Hello! Hello! Hello! I'm Broccoli, Your Green Task Buddy!\n" + "Tell me what you gonna do and I will help you track them!\n" + horizontalLine.toString());
    }

    public void exiting() {
        System.out.println("Bye! Wish you come back with tasks done!\n" + horizontalLine.toString());
    }

    public void echo() {
        String task = "";
        while(true) {
            task = scanner.nextLine();
            if(task.equals("bye")) {
                exiting();
                break;
            }
            if(task.equals("list")){
                displayList();
                continue;
            }
            if(task.equals("mark")){
                try{
                mark();}
                catch(RuntimeException e){
                    System.out.println(e.getMessage());
                }
                continue;
            }
            if(task.equals("unmark")){
                try{
                unmark();}
                catch(RuntimeException e){
                    System.out.println(e.getMessage());
                }
                continue;
            }

            if(task.equals("delete")){
                try{
                delete();}
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
                this.taskList.add(newTask);
                writeToFile();
                System.out.println(horizontalLine.toString());
                System.out.println("Got it. I've added this task:\n" + newTask.toString());
                int undone = (int) taskList.stream().filter(a -> !a.getDone()).count();
                System.out.println("Hurry up! You have " + undone + " tasks unfinished!");
                System.out.println(horizontalLine.toString());

        }
    }
    public void displayList(){
        int counter = 1;
        System.out.println(horizontalLine.toString());
        System.out.println("Quickly go and finish all the UNDONE tasks!");
        for(Task task : this.taskList) {
            System.out.println(counter + ". " + task.toString());
            counter++;
        }
        System.out.println(horizontalLine.toString());
    }
    public void mark(){
        int counter = 1;
        System.out.println("Which task would you like to mark as done? Please enter the number:");
        for(Task task : this.taskList) {
            System.out.println(counter + ". " + task.toString());
            counter++;
        }
        System.out.println(horizontalLine.toString());
        //Scanner scanner1 = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        int index = number - 1;
        if(index >= taskList.stream().count()){
            throw new IllegalArgumentException("Task does not exist, please re-enter a valid one!");
        }
        Task markTask = taskList.get(index);
        markTask.markAsDone();
        writeToFile();
        System.out.println("Nice! I've marked this task as done:\n" + markTask.toString());
    }

    public void unmark(){
        int counter = 1;
        System.out.println("Which task would you like to unmark as done? Please enter the number:");
        for(Task task : this.taskList) {
            System.out.println(counter + ". " + task.toString());
            counter++;
        }
        System.out.println(horizontalLine.toString());
      //  Scanner scanner1 = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        int index = number - 1;
        if(index >= taskList.stream().count()){
            throw new IllegalArgumentException("Task does not exist, please re-enter a valid one!");
        }
        Task markTask = taskList.get(index);
        markTask.markAsUndone();
        writeToFile();
        System.out.println("OK, I've marked this task as not done yet:\n" + markTask.toString());
    }

    public void delete(){
        int counter = 1;
        System.out.println("Which task would you like to delete? Please enter the number:");
        for(Task task : this.taskList) {
            System.out.println(counter + ". " + task.toString());
            counter++;
        }
        System.out.println(horizontalLine.toString());
        //  Scanner scanner1 = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        int index = number - 1;
        if(index >=taskList.stream().count()){
            throw new IllegalArgumentException("Task does not exist, please re-enter a valid one!");
        }
        Task markTask = taskList.get(index);
        taskList.remove(index);
        writeToFile();
        System.out.println("Noted. I've removed this task:\n" + markTask.toString());
        int undone = (int) taskList.stream().filter(a -> !a.getDone()).count();
        System.out.println("Hurry up! You have " + undone + " tasks unfinished!");
    }

      private void writeToFile() {
        try {
            Path data = Paths.get("./data");
            if (!Files.exists(data)) {
                Files.createDirectories(data);
            }
            FileWriter fw = new FileWriter("./data/broccoli.txt");
            for(Task task : taskList){
                String taskContent = task.taskText();
                fw.write(taskContent + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
      }

      private void loadFromFile(){
        try{
            File file = new File("./data/broccoli.txt");
            if(!file.exists()) {
                return;
            }
            Scanner textScanner = new Scanner(file);
            while(textScanner.hasNextLine()){
                String content = textScanner.nextLine();
                Task task = Task.parseTask(content);
                if(task != null) {
                    taskList.add(task);
                }
            }
            textScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
      }

    public static void main(String[] args) {
     Broccoli broccoli = new Broccoli();
     broccoli.setHorizontalLine();
     broccoli.greeting();
     broccoli.echo();
    }
}
