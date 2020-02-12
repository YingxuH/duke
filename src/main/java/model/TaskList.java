package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;

/**
 * Implements an iterable containing a list of tasks object.
 */
public class TaskList implements Iterable<Task> {
    protected final List<Task> internalList = new ArrayList<Task>();

    private static final String ECHO_ADD_TASK = "Got it. I've added this task:\n";
    private static final String ECHO_DELETE_TASK = "Noted. I have removed this task:\n";
    private static final String ECHO_VIEW_TASK_LIST = "Here are the tasks in your list:\n";
    private static final String ECHO_COMPLETE_TASK = "Nice! I've marked this task as done:\n";
    private static final String ECHO_FIND_TASK = "Here are the matching tasks in your list:\n";

    public TaskList() {

    }

    /**
     * Constructs a {@code Task} with multiple input tasks.
     * @param tasks multiple valid tasks.
     */
    public TaskList(Task... tasks) {
        final List<Task> initials = Arrays.asList(tasks);
        internalList.addAll(initials);
    }

    /**
     * Constructs a {@code Task} with a collection of tasks.
     * @param tasks a collection of tasks.
     */
    public TaskList(Collection<Task> tasks) {
        internalList.addAll(tasks);
    }

    /**
     * Adds a task to the inner-list.
     * @param task A valid task to add.
     * @return response of the add action.
     */
    public String add(Task task) {
        this.internalList.add(task);
        StringBuilder addTaskEnd = new StringBuilder("Now you have  tasks in the list.\n");

        String addTaskEndStr = addTaskEnd.insert(13, this.internalList.size()).toString();
        return ECHO_ADD_TASK
                + task.toString()
                + "\n"
                + addTaskEndStr;
    }

    /**
     * Remove the task at the specific index from the inner-list.
     * @param position A position within the bound of the list.
     * @return response of the remove action.
     */
    public String remove(int position) {
        Task deletedTask = internalList.get(position);
        internalList.remove(position);
        return ECHO_DELETE_TASK
                + " "
                + deletedTask.toString()
                + "\n"
                + "Now you have "
                + Integer.toString(this.internalList.size())
                + " tasks in the list.\n";
    }

    /**
     * Mark a task at the specific index from the inner-list.
     * @param position A position within the bound of the list.
     * @return response of the mark action.
     */
    public String markTaskAsDone(Integer position) {
        Task finishedTask = this.internalList.get(position);
        finishedTask.markAsDone();

        return ECHO_COMPLETE_TASK
                + " "
                + finishedTask.toString()
                + "\n";
    }

    public String findByKeyWord(String keyWord) {
        StringBuilder matchedTasks = new StringBuilder();
        matchedTasks.append(ECHO_FIND_TASK);

        for (int i = 0; i < this.internalList.size(); i++) {
            if (this.internalList.get(i) == null) {
                continue;
            }
            Task currentTask = this.internalList.get(i);

            if (currentTask.hasKeyWord(keyWord)) {
                matchedTasks.append(Integer.toString(i + 1));
                matchedTasks.append(".");
                matchedTasks.append(currentTask.toString());
                matchedTasks.append("\n");
            }
        }
        return matchedTasks.toString();
    }

    /**
     * Converts the task list to a string by looping through the tasks and concatenate
     * all the string representation of tasks.
     * @return string representation of the task list.
     */
    public String toString() {
        StringBuilder listOverView = new StringBuilder(ECHO_VIEW_TASK_LIST);
        for (int i = 0; i < this.internalList.size(); i++) {
            if (this.internalList.get(i) == null) {
                continue;
            }
            listOverView.append(Integer.toString(i + 1));
            listOverView.append(".");
            listOverView.append(this.internalList.get(i).toString());
            listOverView.append("\n");
        }
        return listOverView.toString();
    }

    /**
     * Iterate through the task list.
     * @return
     */
    @Override
    public Iterator<Task> iterator() {
        return this.internalList.iterator();
    }
}
