package pl.kjanus.ConferenceRoomsReservationSystem.conference_room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kjanus.ConferenceRoomsReservationSystem.organizations.OrganizationsRepository;

@Service
public class ConferenceRoomService {
    private final ConferenceRoomRepository conferenceRoomRepository;
    private final OrganizationsRepository organizationsRepository;

    @Autowired
    public ConferenceRoomService(ConferenceRoomRepository conferenceRoomRepository, OrganizationsRepository organizationsRepository) {
        this.conferenceRoomRepository = conferenceRoomRepository;
        this.organizationsRepository = organizationsRepository;
    }


}
