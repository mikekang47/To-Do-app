package To.Do.app.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Long id) {
        super("Task not found: " + id);
    }
}
