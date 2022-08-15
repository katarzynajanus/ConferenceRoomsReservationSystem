package pl.kjanus.ConferenceRoomsReservationSystem.conference_room;


import org.hibernate.annotations.GenericGenerator;
import pl.kjanus.ConferenceRoomsReservationSystem.organizations.Organizations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
public class ConferenceRoom {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    private String id;
    @NotBlank(groups = AddConferenceRoom.class)
    @Size(min = 2, max = 20, groups = {AddConferenceRoom.class, UpdateConferenceRoom.class})
    private String name;
    @Size(min = 2, max = 20, groups = {AddConferenceRoom.class, UpdateConferenceRoom.class})
    private long identifier;
    @Min(value = 0, groups = {AddConferenceRoom.class, UpdateConferenceRoom.class})
    @Max(value = 10, groups = {AddConferenceRoom.class, UpdateConferenceRoom.class})
    private Integer level;
    private Boolean availability;
    @NotNull(groups = AddConferenceRoom.class)
    @PositiveOrZero(groups = {AddConferenceRoom.class, UpdateConferenceRoom.class})
    private Integer number_of_seats;


    public ConferenceRoom(String id, String name, Long identifier, Integer level, Boolean availability, Integer number_of_seats) {
        this.id = id;
        this.name = name;
        this.identifier = identifier;
        this.level = level;
        this.availability = availability;
        this.number_of_seats = number_of_seats;
    }

    public ConferenceRoom(String name, Long identifier, Integer level, Boolean availability, Integer number_of_seats) {
        this.name = name;
        this.identifier = identifier;
        this.level = level;
        this.availability = availability;
        this.number_of_seats = number_of_seats;
    }

    @ManyToOne
    private Organizations organizations;

    public ConferenceRoom() {
    }

    public ConferenceRoom(String id, String name, long identifier, Integer level, Boolean availability, Integer number_of_seats, Organizations organizations) {
        this.id = id;
        this.name = name;
        this.identifier = identifier;
        this.level = level;
        this.availability = availability;
        this.number_of_seats = number_of_seats;
        this.organizations = organizations;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public long getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(Integer number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public Organizations getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Organizations organizations) {
        this.organizations = organizations;
    }

    @Override
    public String toString() {
        return "ConferenceRoom{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", identifier=" + identifier +
                ", level=" + level +
                ", availability=" + availability +
                ", number_of_seats=" + number_of_seats +
                ", organizations=" + organizations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceRoom that = (ConferenceRoom) o;
        return identifier == that.identifier && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(level, that.level) && Objects.equals(availability, that.availability) && Objects.equals(number_of_seats, that.number_of_seats) && Objects.equals(organizations, that.organizations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, identifier, level, availability, number_of_seats, organizations);
    }
}

interface AddConferenceRoom {
}

interface UpdateConferenceRoom {
}

