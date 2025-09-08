
package Broccoli.Command;

import Broccoli.Tasks.Task;
import java.util.ArrayList;
import java.util.stream.Collectors;
import Broccoli.Storage;
import Broccoli.TaskList;
import Broccoli.Ui;


public class FindCommand extends Command {
    private final String keyWords;

    public FindCommand(String keyWords) {
        this.keyWords = keyWords;
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            ArrayList<Task> taskList1 = (ArrayList<Task>) taskList.getList().stream()
                    .filter(task -> task.getDescription().contains(keyWords))
                    .collect(Collectors.toList());
            if (taskList1.isEmpty()) {
                throw new IllegalArgumentException("There is not matching tasks");
            } else {
                TaskList matchedTasks = new TaskList(taskList1);
                String output_2 = matchedTasks.displayTask();
                String output = "Here are the matching tasks in your list:\n" + output_2;
                return output;
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
