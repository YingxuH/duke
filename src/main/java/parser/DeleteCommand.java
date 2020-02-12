package parser;

/**
 * Presents a command to delete a task from inner-task list.
 */
public class DeleteCommand extends Command {
    protected Integer position;

    /**
     * Constructs a {@code DeleteCommand}.
     * @param position A valid position within the bound of the task list indicating the task to remove.
     */
    public DeleteCommand(Integer position) {
        this.position = position;
    }

    /**
     * Remove a task from the task list by calling TaskList class.
     * @return response from the TaskList class as a string.
     */
    @Override
    public String execute() {
        String commandResult = this.taskList.remove(this.position);
        return commandResult;
    }
}
