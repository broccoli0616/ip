package Broccoli.Command;

import Broccoli.Storage;
import Broccoli.TaskList;
import Broccoli.Tasks.Task;
import Broccoli.Ui;

public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            if (index >= taskList.getList().size()) {
                throw new IllegalArgumentException("Task does not exist, please re-enter a valid one!");
            }
            Task markTask = taskList.getList().get(index);
            markTask.markAsDone();
            storage.writeToFile();
            String outPut = "Nice! I've marked this task as done:\n" + markTask.toString();
            return outPut;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

    }
}