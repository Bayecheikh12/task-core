package com.taskmanager.core.service;

import com.taskmanager.core.entity.Task;
import com.taskmanager.core.entity.TaskStatus;
import com.taskmanager.core.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public Task createTask(String title, String description) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(TaskStatus.TODO);
        return taskRepository.save(task);
    }

    @Transactional(readOnly = true)
    public List<Task> listTasks() {
        return taskRepository.findAll();
    }

    @Transactional
    public Task updateStatus(Long taskId, TaskStatus newStatus) {
        Task task = taskRepository.findById(taskId)
            .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));
        task.setStatus(newStatus);
        return taskRepository.save(task);
    }

    @Transactional(readOnly = true)
    public long countCompletedTasks() {
        return taskRepository.countByStatus(TaskStatus.DONE);
    }
}
