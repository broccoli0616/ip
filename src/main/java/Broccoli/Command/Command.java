package Broccoli.Command;

// Command.java

import Broccoli.Broccoli;
import Broccoli.Storage;
import Broccoli.TaskList;
import Broccoli.Ui;

public abstract class Command {
    public abstract String execute(TaskList taskList, Ui ui, Storage storage);
}
