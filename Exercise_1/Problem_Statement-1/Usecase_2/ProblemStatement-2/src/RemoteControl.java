// RemoteControl.java
import java.util.ArrayDeque;
import java.util.Deque;

public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Deque<Command> commandHistory;

    public RemoteControl() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        commandHistory = new ArrayDeque<>();
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonPressed(int slot) {
        try {
            onCommands[slot].execute();
            commandHistory.push(onCommands[slot]);
        } catch (Exception e) {
            System.err.println("Error executing ON command: " + e.getMessage());
        }
    }

    public void offButtonPressed(int slot) {
        try {
            offCommands[slot].execute();
            commandHistory.push(offCommands[slot]);
        } catch (Exception e) {
            System.err.println("Error executing OFF command: " + e.getMessage());
        }
    }

    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            commandHistory.pop().undo();
        } else {
            System.out.println("No command to undo");
        }
    }
}
