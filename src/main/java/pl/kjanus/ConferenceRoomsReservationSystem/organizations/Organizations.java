package pl.kjanus.ConferenceRoomsReservationSystem.organizations;

import pl.kjanus.ConferenceRoomsReservationSystem.conference_room.ConferenceRoom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Organizations {

    @Id
    @GeneratedValue
    private long id;
    @NotBlank(groups = AddOrganizations.class)
    @Size(min = 2, max = 20, groups = {AddOrganizations.class, UpdateOrganizations.class})
    private String name;
    @Size(max = 100, message = "Description is too long!")
    private String description;

    @OneToMany(mappedBy = "organizations")
    List<ConferenceRoom> conferenceRoomList;


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
}

interface AddOrganizations {
}

interface UpdateOrganizations {
}

