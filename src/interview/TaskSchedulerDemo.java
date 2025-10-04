package interview;// Fill in the TODO sections with working code.
// Use appropriate Java collections and sorting techniques.
// Handle edge cases like duplicate IDs or empty scheduler.
// Optional: Add unit tests using JUnit or TestNG.
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;
/**
 * Represents a task with ID, priority, and timestamp.
 */
/*class Task {
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
}*/
/**
 * A scheduler that manages tasks based on priority and timestamp.
 */
/*class TaskScheduler {
    private final Map<String, Task> tasks = new HashMap<>();
    *//**
     * Adds a new task to the scheduler.
     *//*
    public void addTask(String id, int priority, LocalDateTime timestamp) {
        if (tasks.containsKey(id)) {
            System.out.println("Task with ID '" + id + "' already exists.");
            return;
        }
        tasks.put(id, new Task(id, priority, timestamp));
    }
    *//**
     * Returns the ID of the next task to execute.
     * Highest priority first; if tie, earliest timestamp.
     *//*
    public String getNextTask() {
        
          Optional<Task> firstTask = tasks.values().stream()
            .sorted((x,y) -> y.getPriority() - x.getPriority()).findFirst();
        
       // System.out.println("Next task "+firstTask.get());
        return firstTask.get().getId();

    }
    *//**
     * Removes a task by its ID.
     *//*
    public void removeTask(String id) {
        
        //tasks.values().stream().iterator().hasNext()
        Iterator<Task> iter = tasks.values().iterator();
        while (iter.hasNext()) {
            if(iter.next().getId().equals(id)){
                iter.remove();
            }
        }
        //System.out.println("Removed "+id+ "After "+tasks);
    }
    *//**
     * Returns all task IDs sorted by priority (desc), then timestamp (asc).
     *//*
    public List<String> getAllTasksSorted() {

return tasks.values().stream().sorted((x,y)-> y.getPriority()-x.getPriority())
        .map(Taks -> Taks.getId()).toList();
    }
}*/
/**
 * Demo class to run the TaskScheduler.
 */
public class TaskSchedulerDemo {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        // Add sample tasks
        scheduler.addTask("task1", 5, LocalDateTime.of(2025, 9, 9, 10, 0));
        scheduler.addTask("task2", 3, LocalDateTime.of(2025, 9, 9, 9, 0));
        scheduler.addTask("task3", 5, LocalDateTime.of(2025, 9, 9, 8, 0));
        scheduler.addTask("task4", 7, LocalDateTime.of(2025, 9, 9, 11, 0));
        // Display next task
        System.out.println("Next task to execute: " + scheduler.getNextTask());
        // // Display all tasks sorted
        System.out.println("All tasks sorted:");
        scheduler.getAllTasksSorted().forEach(System.out::println);
         // Remove a task
         scheduler.removeTask("task2");
        // // Display tasks after removal
         System.out.println("Tasks after removing 'task2':");
         scheduler.getAllTasksSorted().forEach(System.out::println);
    }
}