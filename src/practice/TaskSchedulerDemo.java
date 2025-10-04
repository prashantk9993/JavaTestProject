package practice;// Fill in the TODO sections with working code.
// Use appropriate Java collections and sorting techniques.
// Handle edge cases like duplicate IDs or empty scheduler.
// Optional: Add unit tests using JUnit or TestNG.
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;


/**
 * Represents a task with ID, priority, and timestamp.
 */
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

/**
 * A scheduler that manages tasks based on priority and timestamp.
 */
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
        if (tasks.isEmpty()) {
            throw new NoSuchElementException("No tasks available");
        }
        
        return tasks.values().stream()
                .sorted(Comparator
                    .comparingInt(Task::getPriority).reversed()
                    .thenComparing(Task::getTimestamp))
                .findFirst()
                .map(Task::getId)
                .orElseThrow(() -> new NoSuchElementException("No tasks available"));
    }
    
    /**
     * Removes a task by its ID.
     */
    public void removeTask(String id) {
        if (!tasks.containsKey(id)) {
            System.out.println("Task with ID '" + id + "' not found.");
            return;
        }
        tasks.remove(id);
    }
    
    /**
     * Returns all task IDs sorted by priority (desc), then timestamp (asc).
     */
    public List<String> getAllTasksSorted() {
        return tasks.values().stream()
                .sorted(Comparator
                    .comparingInt(Task::getPriority).reversed()
                    .thenComparing(Task::getTimestamp))
                .map(Task::getId)
                .toList();
    }
    
    /**
     * Returns the number of tasks in the scheduler.
     */
    public int getTaskCount() {
        return tasks.size();
    }
    
    /**
     * Checks if a task exists by ID.
     */
    public boolean containsTask(String id) {
        return tasks.containsKey(id);
    }
    
    /**
     * Clears all tasks from the scheduler.
     */
    public void clear() {
        tasks.clear();
    }
}

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
        // Display all tasks sorted
        System.out.println("All tasks sorted:");
        scheduler.getAllTasksSorted().forEach(System.out::println);
        // Remove a task
        scheduler.removeTask("task2");
        // Display tasks after removal
        System.out.println("Tasks after removing 'task2':");
        scheduler.getAllTasksSorted().forEach(System.out::println);
    }
}

// ==================== JUnit 5 Tests ====================

/**
 * Unit tests for TaskScheduler using JUnit 5
 */
class TaskSchedulerTest {

   /* @Test
    void testAddTask() {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask("task1", 5, LocalDateTime.now());
        assertEquals(1, scheduler.getTaskCount());
        assertTrue(scheduler.containsTask("task1"));
    }

    @Test
    void testAddDuplicateTask() {
        TaskScheduler scheduler = new TaskScheduler();
        LocalDateTime timestamp = LocalDateTime.now();
        scheduler.addTask("task1", 5, timestamp);
        scheduler.addTask("task1", 3, timestamp); // Duplicate ID
        
        assertEquals(1, scheduler.getTaskCount());
        // Should still have the original task
        assertEquals("task1", scheduler.getNextTask());
    }

    @Test
    void testGetNextTask_HighestPriority() {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask("low", 1, LocalDateTime.of(2025, 1, 1, 10, 0));
        scheduler.addTask("high", 10, LocalDateTime.of(2025, 1, 1, 12, 0));
        scheduler.addTask("medium", 5, LocalDateTime.of(2025, 1, 1, 11, 0));
        
        assertEquals("high", scheduler.getNextTask());
    }

    @Test
    void testGetNextTask_TieBreakerByTimestamp() {
        TaskScheduler scheduler = new TaskScheduler();
        // Same priority, different timestamps
        scheduler.addTask("later", 5, LocalDateTime.of(2025, 1, 1, 11, 0));
        scheduler.addTask("earlier", 5, LocalDateTime.of(2025, 1, 1, 9, 0));
        
        // Should pick earlier timestamp
        assertEquals("earlier", scheduler.getNextTask());
    }

    @Test
    void testGetNextTask_EmptyScheduler() {
        TaskScheduler scheduler = new TaskScheduler();
        assertThrows(NoSuchElementException.class, () -> {
            scheduler.getNextTask();
        });
    }

    @Test
    void testRemoveTask() {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask("task1", 5, LocalDateTime.now());
        scheduler.addTask("task2", 3, LocalDateTime.now());
        
        scheduler.removeTask("task1");
        
        assertEquals(1, scheduler.getTaskCount());
        assertFalse(scheduler.containsTask("task1"));
        assertTrue(scheduler.containsTask("task2"));
    }

    @Test
    void testRemoveNonExistentTask() {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask("task1", 5, LocalDateTime.now());
        
        scheduler.removeTask("nonexistent"); // Should not throw exception
        
        assertEquals(1, scheduler.getTaskCount()); // Count should remain same
    }

    @Test
    void testGetAllTasksSorted() {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask("task3", 3, LocalDateTime.of(2025, 1, 1, 11, 0));
        scheduler.addTask("task1", 5, LocalDateTime.of(2025, 1, 1, 10, 0));
        scheduler.addTask("task2", 5, LocalDateTime.of(2025, 1, 1, 9, 0)); // Same priority, earlier time
        scheduler.addTask("task4", 1, LocalDateTime.of(2025, 1, 1, 8, 0));
        
        List<String> sortedTasks = scheduler.getAllTasksSorted();
        
        // Expected order: highest priority first, then earliest timestamp for same priority
        List<String> expected = List.of("task2", "task1", "task3", "task4");
        assertEquals(expected, sortedTasks);
    }

    @Test
    void testGetAllTasksSorted_Empty() {
        TaskScheduler scheduler = new TaskScheduler();
        List<String> sortedTasks = scheduler.getAllTasksSorted();
        
        assertTrue(sortedTasks.isEmpty());
    }

    @Test
    void testComplexScenario() {
        TaskScheduler scheduler = new TaskScheduler();
        
        // Add tasks with various priorities and timestamps
        scheduler.addTask("A", 10, LocalDateTime.of(2025, 1, 1, 15, 0));
        scheduler.addTask("B", 10, LocalDateTime.of(2025, 1, 1, 10, 0)); // Same priority, earlier time
        scheduler.addTask("C", 5, LocalDateTime.of(2025, 1, 1, 12, 0));
        scheduler.addTask("D", 15, LocalDateTime.of(2025, 1, 1, 14, 0)); // Highest priority
        
        // Test next task
        assertEquals("D", scheduler.getNextTask());
        
        // Test sorted list
        List<String> expectedOrder = List.of("D", "B", "A", "C");
        assertEquals(expectedOrder, scheduler.getAllTasksSorted());
        
        // Remove and test again
        scheduler.removeTask("D");
        assertEquals("B", scheduler.getNextTask()); // Now B should be next (earlier timestamp than A)
        
        List<String> expectedAfterRemoval = List.of("B", "A", "C");
        assertEquals(expectedAfterRemoval, scheduler.getAllTasksSorted());
    }

    @Test
    void testTaskCountAndClear() {
        TaskScheduler scheduler = new TaskScheduler();
        assertEquals(0, scheduler.getTaskCount());
        
        scheduler.addTask("task1", 1, LocalDateTime.now());
        scheduler.addTask("task2", 2, LocalDateTime.now());
        assertEquals(2, scheduler.getTaskCount());
        
        scheduler.clear();
        assertEquals(0, scheduler.getTaskCount());
        assertTrue(scheduler.getAllTasksSorted().isEmpty());
    }*/
}