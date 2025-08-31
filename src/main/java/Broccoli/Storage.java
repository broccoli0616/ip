package Broccoli;

import Broccoli.Tasks.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages data for task storage and retrieval.
 * Handles loading from and writing to the data file.
 */
public class Storage {
    private TaskList taskList;
    public String filePath;
    public Storage(TaskList taskList, String filePath){

        this.taskList = taskList;
        this.filePath = "./data/broccoli.txt";
    }

    /**
     * Writes all tasks in the task list to the storage file broccoli.txt.
     */
    public void writeToFile() {
        try {
            Path data = Paths.get("./data");
            if (!Files.exists(data)) {
                Files.createDirectories(data);
            }
            FileWriter fw = new FileWriter(this.filePath);
            for(Task task : taskList.getList()){
                String taskContent = task.taskText();
                fw.write(taskContent + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    /**
     * Loads tasks from the storage file into the task list.
     * Returns if the file doesn't exist.
     */
    public void loadFromFile(){
        try{
            File file = new File(this.filePath);
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

    public ArrayList<Task> getTaskList(){
        return taskList.getList();
    }

}
