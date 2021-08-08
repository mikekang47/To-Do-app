package To.Do.app.controller;

import To.Do.app.dto.Task;
import To.Do.app.exception.TaskNotFoundException;
import To.Do.app.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/tasks")
@RestController
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    List<Task> showAll() {
        return taskService.getTasks();
    }

    @GetMapping("{id}")
    Optional<Task> detail(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    Task createTask(@RequestBody Task source) {
        return taskService.create(source);
    }

    @PutMapping("{id}")
    Task putTask(@PathVariable Long id, @RequestBody Task source) {
        return taskService.update(id, source);
    }

    @PatchMapping("{id}")
    Task patchTask(@PathVariable Long id, @RequestBody Task source) {
        return taskService.update(id, source);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        taskService.delete(id);
    }


}
