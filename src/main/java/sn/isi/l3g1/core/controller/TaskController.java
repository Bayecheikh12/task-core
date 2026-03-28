package sn.isi.l3g1.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.l3g1.core.model.Task;
import sn.isi.l3g1.core.model.TaskStatus;
import sn.isi.l3g1.core.service.TaskService;

import java.util.List;

/**
 * REST Controller pour la gestion des tâches.
 * Expose les endpoints CRUD pour l'entité Task.
 */
@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Créer une nouvelle tâche.
     * POST /api/tasks
     */
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task created = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Lister toutes les tâches.
     * GET /api/tasks
     */
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.listTasks());
    }

    /**
     * Mettre à jour le statut d'une tâche.
     * PATCH /api/tasks/{id}/status?status=IN_PROGRESS
     */
    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> updateTaskStatus(
            @PathVariable Long id,
            @RequestParam TaskStatus status) {
        Task updated = taskService.updateStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    /**
     * Compter les tâches terminées.
     * GET /api/tasks/completed/count
     */
    @GetMapping("/completed/count")
    public ResponseEntity<Long> countCompletedTasks() {
        return ResponseEntity.ok(taskService.countCompletedTasks());
    }
}
