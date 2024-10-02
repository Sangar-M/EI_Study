import java.util.List;

public class CommandInvoker {
    public void executeCommands(List<Command> commands) throws Exception {
        for (Command command : commands) {
            command.execute();
        }
    }
}
