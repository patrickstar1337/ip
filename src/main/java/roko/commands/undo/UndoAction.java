package roko.commands.undo;

import roko.ui.TaskList;

public interface UndoAction {
    void undo(TaskList tasks);
}
