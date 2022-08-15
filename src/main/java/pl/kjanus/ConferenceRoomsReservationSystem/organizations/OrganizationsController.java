package pl.kjanus.ConferenceRoomsReservationSystem.organizations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.kjanus.ConferenceRoomsReservationSystem.SortType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/organizations")
public class OrganizationsController {
    private final OrganizationsService organizationsService;

    public OrganizationsController(OrganizationsService organizationsService) {
        this.organizationsService = organizationsService;
    }

    @GetMapping("/{name}")
    Organizations findByName(@PathVariable String name) {
        return organizationsService.findByName(name);
    }

    @GetMapping
    List<Organizations> findAll(@RequestParam(required = false, defaultValue = "ASC") SortType sortType) {
        return organizationsService.findAll(sortType);
    }

    @PostMapping
    Organizations add(@Validated(value = AddOrganizations.class) @RequestBody Organizations organizations) {
        return organizationsService.add(organizations);
    }

    @DeleteMapping("/{name}")
    Organizations delete(@PathVariable String name) {
        return organizationsService.delete(name);

    }

    @PutMapping("/{name}")
    Organizations update(@PathVariable String name, @Validated(value = UpdateOrganizations.class) @RequestBody Organizations organizations) {
        return organizationsService.update(name, organizations);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
