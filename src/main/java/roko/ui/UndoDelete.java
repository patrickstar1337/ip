package roko.ui;

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
