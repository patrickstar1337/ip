package roko.ui;

public class UndoMark implements UndoAction {
    private int index;
    private boolean previousIsDone;

    public UndoMark(int index, boolean previousIsDone) {
        this.index = index;
        this.previousIsDone = previousIsDone;
    }

    @Override
    public void undo(TaskList tasks) {
        tasks.getTaskById(index).isDone = previousIsDone;
    }
}
