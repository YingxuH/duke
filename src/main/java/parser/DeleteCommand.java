package main.java.Parser;

public class DeleteCommand extends Command {
    protected Integer position;


    public DeleteCommand() { }

    public DeleteCommand(Integer position) {
        this.position = position;
    }

    @Override
    public String execute() {
        String commandResult = this.taskList.remove(this.position);
        return commandResult;
    }
}