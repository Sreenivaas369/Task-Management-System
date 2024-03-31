package com.in.ServiceImpl;

import com.in.Entity.Task;
import com.in.Repository.TaskRespository;
import com.in.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {


    @Autowired
    private TaskRespository repo;
    @Override
    public Task createNewTask(Task task) {
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter df=DateTimeFormatter.ofPattern("dd-mm-yyyy-hh:mm:ss");
        task.setCreatedAt(ldt.format(df));
        task.setUpdatedAt(ldt.format(df));
        return repo.save(task);
    }

    @Override
    public List<Task> retrieveAllTasks() {
        return repo.findAll();
    }

    @Override
    public Task updateExistingTask( int taskId,Task task) {

        Task t=repo.findById(taskId).get();
        if(t!=null){
            task.setId(taskId);
            LocalDateTime ldt=LocalDateTime.now();
            DateTimeFormatter df=DateTimeFormatter.ofPattern("dd-mm-yyyy-hh:mm:ss");
            task.setCreatedAt(t.getCreatedAt());
            task.setUpdatedAt(ldt.format(df));
            return repo.save(task);
        }
        throw new NullPointerException("Task Not Found in the Database");
    }
}
