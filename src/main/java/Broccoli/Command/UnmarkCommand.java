package Broccoli.Command;

import Broccoli.Storage;
import Broccoli.TaskList;
import Broccoli.Tasks.Task;
import Broccoli.Ui;


public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        try{
        if (index > taskList.getList().size()) {
            throw new IllegalArgumentException("Task does not exist, please re-enter a valid one!");
        }
        Task markTask = taskList.getList().get(index - 1);
        markTask.markAsUndone();
        storage.writeToFile();
        String output = "OK, I've marked this task as not done yet:\n" + markTask.toString();
        return output;
    } catch(IllegalArgumentException e) {
        return e.getMessage();
    }
    }

}
