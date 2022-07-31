package pl.kjanus.ConferenceRoomsReservationSystem.organizations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Organizations {

    @Id
    @GeneratedValue
    private long id;
    @NotBlank(groups = AddOrganization.class)
    @Size(min = 4, max = 20, groups = {AddOrganization.class, UpdateOrganization.class})
    private String name;
    @Size(max = 100, message = "Description is too long!")
    private String description;

    public Organizations() {
    }

    public Organizations(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Organizations(String name, String description) {
        this.name = name;
        this.description = description;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

interface AddOrganization {
}

interface UpdateOrganization {
}
