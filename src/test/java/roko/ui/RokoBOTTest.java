package roko.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class RokoBOTTest {
    @Test
    public void parseCommand_unknownCommand_exceptionThrown() {
        try {
            String command = "giggidy";
            RokoBOT.checkValidInput(command);
            fail();
        } catch (RokoUnknownCommandException e) {
            assertEquals("Error: Empty or not a valid command", e.getMessage());
        } catch (RokoEmptyDescException e) {
            fail();
        }
    }

    @Test
    public void parseCommand_commandHasNoDescription_exceptionThrown() {
        try {
            String command = "todo";
            RokoBOT.checkValidInput(command);
            fail();
        } catch (RokoUnknownCommandException e) {
            fail();
        } catch (RokoEmptyDescException e) {
            assertEquals("Error: No description given", e.getMessage());
        }
    }
}
