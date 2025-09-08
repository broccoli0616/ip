package Broccoli;

import Broccoli.Tasks.Task;

import java.util.ArrayList;

/**
 * Manages tasks collection and operation.
 * Provides methods to add, remove, and display tasks.
 */
public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList(ArrayList<Task> taskList){
        this.taskList = taskList;
    }

    public void add(Task task){
        this.taskList.add(task);
    }

    public void remove(int index){
        this.taskList.remove(index);
    }

    /**
     * Prints all tasks in the list with order .
     */
    public void printTask() {
        int counter = 1;
        for(Task task : taskList) {
            System.out.println(counter + ". " + task.toString());
            counter++;
        }
    }
    public String displayTask() {
        int counter = 1;
        String output = "";
        for(Task task : taskList) {
           output = output + "\n"+ counter + ". " + task.toString();
            counter++;
        }
        return output;
    }
    public ArrayList<Task> getList(){
        return this.taskList;

    }
}
