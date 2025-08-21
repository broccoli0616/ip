import java.util.ArrayList;
import java.util.Scanner;

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
    }

    public void setHorizontalLine() {
        while(this.count >= 0) {
            this.horizontalLine.append(line);
            count --;
        }
        System.out.println(this.horizontalLine.toString());
    }

    public void greeting() {
        System.out.println("Hello! I'm Broccoli\n" + "What can I do for you?\n" + horizontalLine.toString());
    }

    public void exiting() {
        System.out.println("Bye.Hope to see you again soon!\n" + horizontalLine.toString());
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
                mark();
                continue;
            }

            if(task.equals("unmark")){
                unmark();
                continue;
            }
            System.out.println(horizontalLine.toString());
            System.out.println("added:" + task.toString());
            System.out.println(horizontalLine.toString());
            this.taskList.add(new Task(task));
        }
    }
    public void displayList(){
        int counter = 1;
        System.out.println(horizontalLine.toString());
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
        Scanner scanner1 = new Scanner(System.in);
        int number = scanner1.nextInt();
        Task markTask = taskList.get(number - 1);
        markTask.markAsDone();
        System.out.println("Nice! I've marked this task as done: \n" + markTask.toString());
    }

    public void unmark(){
        int counter = 1;
        System.out.println("Which task would you like to unmark as done? Please enter the number:");
        for(Task task : this.taskList) {
            System.out.println(counter + ". " + task.toString());
            counter++;
        }
        System.out.println(horizontalLine.toString());
        Scanner scanner1 = new Scanner(System.in);
        int number = scanner1.nextInt();
        Task markTask = taskList.get(number - 1);
        markTask.markAsUndone();
        System.out.println("OK, I've marked this task as not done yet: \n" + markTask.toString());
    }

    public static void main(String[] args) {
     Broccoli broccoli = new Broccoli();
     broccoli.setHorizontalLine();
     broccoli.greeting();
     broccoli.echo();
    }
}
