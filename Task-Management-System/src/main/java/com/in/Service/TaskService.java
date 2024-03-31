package com.in.Service;

import com.in.Entity.Task;

import java.util.List;

public interface TaskService {
    Task createNewTask(Task task);

    List<Task> retrieveAllTasks();

    Task updateExistingTask( int taskId,Task task);
}
