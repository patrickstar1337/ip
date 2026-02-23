package roko.commands.undo;

import roko.ui.TaskList;

public class UndoMark implements UndoAction {
    private int index;
    private boolean previousIsDone;

    public UndoMark(int index, boolean previousIsDone) {
        this.index = index;
        this.previousIsDone = previousIsDone;
    }

    @Override
    public void undo(TaskList tasks) {
        tasks.getTaskById(index).setIsDone(previousIsDone);
    }
}
