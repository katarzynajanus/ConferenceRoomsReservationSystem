package pl.kjanus.ConferenceRoomsReservationSystem.organizations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.kjanus.ConferenceRoomsReservationSystem.SortType;

import java.util.List;
import java.util.NoSuchElementException;

@Service
class OrganizationsService {
    private final OrganizationsRepository organizationsRepository;

    @Autowired
    public OrganizationsService(OrganizationsRepository organizationsRepository) {
        this.organizationsRepository = organizationsRepository;
    }


    Organizations add(Organizations organizations) {
        organizationsRepository.findById(organizations.getName()).ifPresent(o -> {
            throw new IllegalArgumentException("Organization already exists!");
        });
        return organizationsRepository.save(organizations);

    }


    List<Organizations> findAll(SortType sortType) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortType.name()), "name");
        return organizationsRepository.findAll(sort);
    }


    Organizations findByName(String name) {
        return organizationsRepository.findById(name)
                .orElseThrow(() -> new NoSuchElementException("No organization exists!"));
    }

    Organizations delete(String name) {
        Organizations organizations = organizationsRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException(""));
        organizationsRepository.deleteById(name);
        return organizations;
    }

    Organizations update(String name, Organizations organizations) {
        Organizations existingOrganizations = organizationsRepository
                .findByName(name)
                .orElseThrow(() -> new NoSuchElementException(""));
        if (organizations.getDescription() != null) {
            existingOrganizations.setDescription(organizations.getDescription());
        }
        if (organizations.getName() != null && !organizations.getName().equals(existingOrganizations.getName())) {
            existingOrganizations.setName(organizations.getName());
        }
        return organizationsRepository.save(existingOrganizations);
    }

}



