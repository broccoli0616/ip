package Broccoli;

import Broccoli.Tasks.Task;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

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
 public String greeting() {
    return "Hello! Hello! Hello! I'm Broccoli.Your Green Task Buddy!\n" + "Tell me what you gonna do and I will help you track them!\n";
}

    /**
     * Displays the goodbye message to the user.
     */
 public String exiting() {
     return "Bye! Wish you come back with tasks done!\n";
 }

    /**
     * Displays all tasks in the task list.
     *
     * @param taskList The task list to display.
     */
    public String displayList(TaskList taskList){
       return "Quickly go and finish all the UNDONE tasks!" +"\n"+ taskList.displayTask();
    }

        }


