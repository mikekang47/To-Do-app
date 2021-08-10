package To.Do.app.service;

import To.Do.app.dto.Task;
import To.Do.app.exception.TaskNotFoundException;
import To.Do.app.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    private TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task createTask(Task source) {
        Task task = new Task();
        task.setTitle(source.getTitle());

        return taskRepository.save(task);
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
