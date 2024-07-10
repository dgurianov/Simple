package gud.radster.persistance.repository;

import gud.radster.persistance.entity.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateEntityRepository extends JpaRepository<TemplateEntity, String> {
}
