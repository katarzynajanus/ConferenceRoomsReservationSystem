package pl.kjanus.ConferenceRoomsReservationSystem.organizations;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationsRepository extends JpaRepository<Organizations, Long> {
    Optional<Organizations> findByName(String name);
}
