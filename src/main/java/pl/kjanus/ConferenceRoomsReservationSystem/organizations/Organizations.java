package pl.kjanus.ConferenceRoomsReservationSystem.organizations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Organizations {

    @Id
    @NotBlank(groups = AddOrganization.class)
    @Size(min = 4, max = 20, groups = {AddOrganization.class, UpdateOrganization.class})
    private String name;
    @Size(max = 100, message = "Description is too long!")
    private String description;

    public Organizations() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
interface AddOrganization { }
interface UpdateOrganization { }
