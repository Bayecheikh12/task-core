package sn.isi.l3g1.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.l3g1.core.model.Task;
import sn.isi.l3g1.core.model.TaskStatus;
import java.util.List;

@Repository

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
