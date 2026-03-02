package sn.isi.l3g1.core.service;

import org.springframework.stereotype.Service;
import sn.isi.l3g1.core.model.Task;
import sn.isi.l3g1.core.model.TaskStatus;
import sn.isi.l3g1.core.repository.TaskRepository;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Créer une nouvelle tâche
    public Task createTask(Task task) {
        task.setStatus(TaskStatus.TODO);
        return taskRepository.save(task);
    }

    // Lister toutes les tâches
    public List<Task> listTasks() {
        return taskRepository.findAll();
    }

    // Modifier le statut d'une tâche
    public Task updateStatus(Long id, TaskStatus status) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tâche non trouvée"));
        task.setStatus(status);
        return taskRepository.save(task);
    }

    // Compter les tâches terminées
    public long countCompletedTasks() {
        return taskRepository.findByStatus(TaskStatus.DONE).size();
    }
}