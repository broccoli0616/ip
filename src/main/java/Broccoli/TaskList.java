package Broccoli;

import Broccoli.Tasks.Task;

import java.util.ArrayList;

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

    public void printTask() {
        int counter = 1;
        for(Task task : taskList) {
            System.out.println(counter + ". " + task.toString());
            counter++;
        }
    }

    public ArrayList<Task> getList(){
        return this.taskList;

    }
}
