
package Broccoli.Command;

import Broccoli.Storage;
import Broccoli.TaskList;
import Broccoli.Tasks.Task;
import Broccoli.Ui;


public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        try{
        if (index > taskList.getList().size()) {
            throw new IllegalArgumentException("Task does not exist, please re-enter a valid one!");
        }
        Task markTask = taskList.getList().get(index - 1);
        taskList.remove(index);
        storage.writeToFile();
        int undone = (int) taskList.getList().stream().filter(a -> !a.getDone()).count();
       String output = "Noted. I've removed this task:\n" + markTask.toString() +"\n" +
               "Hurry up! You have " + undone + " tasks unfinished!";
       return output;
    } catch (IllegalArgumentException e) {
        return e.getMessage();
    }
    }

}
