package roko.commands.undo;

import java.util.Stack;

import roko.ui.TaskList;

public class UndoBuffer {
    private Stack<UndoAction> actions = new Stack<>();

    public void push(UndoAction action) {
        actions.push(action);
    }

    public void undo(TaskList tasks) {
        if (actions.empty()) {
            throw new IllegalStateException("Nothing more to undo!");
        }
        actions.pop().undo(tasks);
    }
}
