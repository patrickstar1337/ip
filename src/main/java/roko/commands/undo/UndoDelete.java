package roko.commands.undo;

import roko.ui.Task;
import roko.ui.TaskList;

public class UndoDelete implements UndoAction{
    private int index;
    private Task deletedTask;

    public UndoDelete(int index, Task deletedTask) {
        this.index = index;
        this.deletedTask = deletedTask;
    }

    @Override
    public void undo(TaskList tasks) {
        tasks.addById(index, deletedTask);
    }
}
