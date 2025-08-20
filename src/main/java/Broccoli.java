import java.util.ArrayList;
import java.util.Scanner;

public class Broccoli {
    private char line = '-';
    private int count = 60;
    private StringBuilder horizontalLine;
    private Scanner scanner;
    private ArrayList<String> taskList;

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
            System.out.println(horizontalLine.toString());
            System.out.println("added:" + task);
            System.out.println(horizontalLine.toString());
            this.taskList.add(task);
        }
    }
    public void displayList(){
        int counter = 1;
        System.out.println(horizontalLine.toString());
        for(String task : this.taskList) {
            System.out.println(counter + ". " + task);
            counter++;
        }
        System.out.println(horizontalLine.toString());
    }

    public static void main(String[] args) {
     Broccoli broccoli = new Broccoli();
     broccoli.setHorizontalLine();
     broccoli.greeting();
     broccoli.echo();
    }
}
