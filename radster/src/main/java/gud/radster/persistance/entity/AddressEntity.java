package gud.radster.persistance.entity;

import gud.radster.fixeddata.Country;
import gud.radster.persistance.EntitySupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ADDRESS")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class AddressEntity extends EntitySupport {

    @Size(min = 4, message = "Street at least x chars")
    private String street;

    @Size(min = 3, message = "City at least x chars")
    private String city;

    @NotBlank
    private String houseNumber;

    private Country country;

}
