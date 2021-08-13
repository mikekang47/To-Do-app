package To.Do.app.controller;

import To.Do.app.dto.Task;
import To.Do.app.exception.TaskNotFoundException;
import To.Do.app.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/tasks")
@RestController
@CrossOrigin
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
    Task detail(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    Task create(@RequestBody Task source) {
        return taskService.createTask(source);
    }

    @PutMapping("{id}")
    Task putTask(@PathVariable Long id, @RequestBody Task source) {
        return taskService.updateTask(id, source);
    }

    @PatchMapping("{id}")
    Task patchTask(@PathVariable Long id, @RequestBody Task source) {
        return taskService.updateTask(id, source);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long id) {
        taskService.delete(id);
    }


}
