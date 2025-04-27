package uk.gov.hmcts.reform.dev.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.gov.hmcts.reform.dev.models.Task;
import uk.gov.hmcts.reform.dev.models.TaskDTO;
import uk.gov.hmcts.reform.dev.services.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping //localhost:4000/tasks
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}") //localhost:4000/tasks/1
    public ResponseEntity<Task> getTaskById (@PathVariable Long id){
        Optional<Task> foundTask = taskService.getTaskById(id);
        if (foundTask.isPresent()){
            return new ResponseEntity<>(foundTask.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping //localhost:4000/tasks
    public ResponseEntity<Task> createTask (@RequestBody TaskDTO taskDTO) {
        Task newTask = taskService.createTask(taskDTO);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/update-status/{taskId}") //  localhost:4000/tasks/update-status/1  // update task 1
    public ResponseEntity<Task> updateStatusOfTask(@PathVariable long taskId, @RequestBody TaskDTO taskDTO) {
        Task updatedTask = taskService.updateTaskStatus(taskId, taskDTO);
        if (updatedTask == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-task/{taskId}") // localhost:4000/delete-task/1 // delete task 1
    public ResponseEntity<String> deleteTask(@PathVariable long taskId) {
        String message = taskService.deleteTask(taskId);

        if (message.equals("Invalid task Id")) {
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(message, HttpStatus.OK);
    }



}
