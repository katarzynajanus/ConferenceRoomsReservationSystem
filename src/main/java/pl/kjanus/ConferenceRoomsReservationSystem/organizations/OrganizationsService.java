package pl.kjanus.ConferenceRoomsReservationSystem.organizations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
class OrganizationsService {
    private final OrganizationsRepository organizationsRepository;

    @Autowired
    public OrganizationsService(OrganizationsRepository organizationsRepository) {
        this.organizationsRepository = organizationsRepository;
    }


    Organizations add(Organizations organizations) {
        return organizationsRepository.save(organizations);

    }

    List<Organizations> findAll() {
        return organizationsRepository.findAll();
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



