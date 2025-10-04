package interview;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class UBSInterview {

    public static void main(String[] args) {
            TaskScheduler scheduler = new TaskScheduler();
            // Add sample tasks
            scheduler.addTask("task1", 5, LocalDateTime.of(2025, 9, 9, 10, 0));
            scheduler.addTask("task2", 3, LocalDateTime.of(2025, 9, 9, 9, 0));
            scheduler.addTask("task3", 5, LocalDateTime.of(2025, 9, 9, 8, 0));
            scheduler.addTask("task4", 7, LocalDateTime.of(2025, 9, 9, 11, 0));
            // Display next task
            System.out.println("Next task to execute: " + scheduler.getNextTask());
            // Display all tasks sorted
            // System.out.println("All tasks sorted:");
            // scheduler.getAllTasksSorted().forEach(System.out::println);
            // // Remove a task
            // scheduler.removeTask("task2");
            // // Display tasks after removal
            // System.out.println("Tasks after removing 'task2':");
            // scheduler.getAllTasksSorted().forEach(System.out::println);
        }
}

class TaskScheduler {
    private final Map<String, Task> tasks = new HashMap<>();
    /**
     * Adds a new task to the scheduler.
     */
    public void addTask(String id, int priority, LocalDateTime timestamp) {
        if (tasks.containsKey(id)) {
            System.out.println("Task with ID '" + id + "' already exists.");
            return;
        }
        tasks.put(id, new Task(id, priority, timestamp));
    }
    /**
     * Returns the ID of the next task to execute.
     * Highest priority first; if tie, earliest timestamp.
     */
    public String getNextTask() {

       /* int id = tasks.values().stream().
                mapToInt(x-> x.getPriority())
                .sorted().findFirst().getAsInt();*/


        //scheduler.addTask("task1", 5, LocalDateTime.of(2025, 9, 9, 10, 0));

/*      String task =  tasks.values().stream().sorted(Comparator.comparingInt(Task::getPriority).reversed())
                .map(Task::getId)
                .findFirst()
                .orElse(null);*/
        Task s = tasks.values().stream().sorted(Comparator.comparingInt(Task::getPriority).reversed())
                .findFirst().get();


        Task s1 = tasks.values().stream().sorted((x,y)->y.getPriority()- x.getPriority())
                .findFirst().get();


       // s.forEach(x->System.out.println(x.getPriority()));

        System.out.println("Next task ======"+s.getId());
        System.out.println("Next task ======"+s1.getId());
        return null;

    }
    /**
     * Removes a task by its ID.
     */
    public void removeTask(String id) {

    }
    /**
     * Returns all task IDs sorted by priority (desc), then timestamp (asc).
     */
    public List<String> getAllTasksSorted() {

        return null;
    }
}

class Task {
    private final String id;
    private final int priority;
    private final LocalDateTime timestamp;
    public Task(String id, int priority, LocalDateTime timestamp) {
        this.id = id;
        this.priority = priority;
        this.timestamp = timestamp;
    }
    public String getId() {
        return id;
    }
    public int getPriority() {
        return priority;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    @Override
    public String toString() {
        return String.format("Task{id='%s', priority=%d, timestamp=%s}", id, priority, timestamp);
    }
}