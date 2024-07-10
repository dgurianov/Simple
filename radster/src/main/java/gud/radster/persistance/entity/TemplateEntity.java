package gud.radster.persistance.entity;

import gud.radster.persistance.EntitySupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TEMPLATE_ENTITY")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class TemplateEntity extends EntitySupport {

    @Size(min = 4, message = "Name at least x chars")
    private String firstName;

    @Size(min = 4, message = "Second Name at least x chars")
    private String secondName;

}
