package Broccoli.Command;

import Broccoli.Storage;
import Broccoli.TaskList;
import Broccoli.Tasks.Task;
import Broccoli.Ui;

public class AddCommand extends Command {
    private final String taskDescription;

    public AddCommand(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            Task newTask = Task.checkTask(taskDescription);
            taskList.add(newTask);
            storage.writeToFile();
            String displayContent1 = "Got it. I've added this task:\n" + newTask.toString();
            String displayContent2 = "Now you have " + taskList.getList().size() + " tasks in the list.";
            String output = displayContent1 + "\n" + displayContent2;
            return output;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}


