package To.Do.app.controller;

import To.Do.app.dto.Task;
import To.Do.app.exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/tasks")
@RestController
public class TaskController {

    List<Task> tasks = new ArrayList<>();
    Long id = 0L;

    @GetMapping
    List<Task> showAll() {
        return tasks;
    }

    @GetMapping("{id}")
    Task detail(@PathVariable Long id) {
        return getTask(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    Task create(@RequestBody Task source) {
        Task task = new Task();
        task.setTitle(source.getTitle());
        task.setId(generateId());

        tasks.add(task);

        return task;
    }

    @PutMapping("{id}")
    Task put(@PathVariable Long id, @RequestBody Task source) {
        Task task = getTask(id);

        task.setTitle(source.getTitle());

        return task;
    }

    @PatchMapping("{id}")
    Task patch(@PathVariable Long id, @RequestBody Task source) {
        Task task = getTask(id);
        task.setTitle(source.getTitle());

        return task;
    }


    Task getTask(Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException(id));
    }


   private Long generateId() {
        id += 1L;
        return id;
    }
}
