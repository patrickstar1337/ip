package roko.ui;

public class UndoAdd implements UndoAction {
    @Override
    public void undo(TaskList tasks) {
        int last = tasks.size() - 1;
        tasks.removeTaskById(last);
    }
}
