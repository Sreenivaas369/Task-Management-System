package com.in.Controller;

import com.in.Entity.Task;
import com.in.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/tasks")
    public ResponseEntity<Task> createNewTask(@RequestBody Task task){
        return new ResponseEntity<>(service.createNewTask(task), HttpStatus.CREATED);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>>  retrieveAllTasks(){
        return new ResponseEntity<>(service.retrieveAllTasks(),HttpStatus.OK);
    }

    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<Task> updateExistingTask(@PathVariable int taskId,@RequestBody Task task){
        return new ResponseEntity<>(service.updateExistingTask(taskId,task),HttpStatus.OK);
    }

}
