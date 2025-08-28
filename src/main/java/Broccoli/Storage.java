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

public class Storage {
    private TaskList taskList;
    public Storage(TaskList taskList){
        this.taskList = taskList;
    }
    public void writeToFile() {
        try {
            Path data = Paths.get("./data");
            if (!Files.exists(data)) {
                Files.createDirectories(data);
            }
            FileWriter fw = new FileWriter("./data/broccoli.txt");
            for(Task task : taskList.getList()){
                String taskContent = task.taskText();
                fw.write(taskContent + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public void loadFromFile(){
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

    public ArrayList<Task> getTaskList(){
        return taskList.getList();
    }

}
