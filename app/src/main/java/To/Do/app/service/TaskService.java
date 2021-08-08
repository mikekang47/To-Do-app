package To.Do.app.service;

import To.Do.app.dto.Task;
import To.Do.app.exception.TaskNotFoundException;
import To.Do.app.repository.TaskRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    Long id = 0L;

    public List<Task> tasks = new ArrayList<>();
    private TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(Long id) {
        return tasks.stream()
                .filter((task) -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task create(Task source) {
        Task task = new Task();
        task.setTitle(source.getTitle());
        task.setId(generateId());

        tasks.add(task);

        return task;
    }

    public Task update(Long id, Task source) {
        Task task = getTask(id);

        task.setTitle(source.getTitle());

        return task;
    }

    public void delete(Long id) {
        Task task = getTask(id);
        tasks.remove(task);
    }

    public Long generateId() {
        id += 1L;
        return id;
    }

}
