package To.Do.app.service;

import To.Do.app.dto.Task;
import To.Do.app.exception.TaskNotFoundException;
import To.Do.app.repository.TaskRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    Long id = 0L;

    public List<Task> tasks = new ArrayList<>();
    private TaskRepository taskRepository;

    private TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    public Task create(Task source) {
        return taskRepository.save(source);
    }

    public Task update(Long id, Task source) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        task.setTitle(source.getTitle());

        return task;
    }

    public void delete(Long id) {
       Task task = taskRepository.findById(id)
               .orElseThrow(() -> new TaskNotFoundException(id));

       taskRepository.delete(task);
    }

}
