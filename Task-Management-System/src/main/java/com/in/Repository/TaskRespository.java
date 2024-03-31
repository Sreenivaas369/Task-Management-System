package com.in.Repository;

import com.in.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRespository extends  JpaRepository<Task, Integer> {
}
