package spring.restful.crud.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.restful.crud.exceptions.FiledDoesNotException;
import spring.restful.crud.exceptions.PersonNotFoundException;
import spring.restful.crud.service.PersonService;
import spring.restful.crud.web.models.PersonRequestModel;
import spring.restful.crud.web.models.PersonViewModel;

import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/people")
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<Set<PersonViewModel>> getAllPeople(){
        Set<PersonViewModel> allPeople = this.personService.getAllPeople();
        return ResponseEntity
                .ok(allPeople);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonViewModel> getPersonById(@PathVariable Long id){
        PersonViewModel personById = this.personService.getPersonById(id);
        return ResponseEntity
                .ok(personById);
    }

    @PostMapping
    public ResponseEntity<PersonViewModel> createPerson(@RequestBody PersonRequestModel personRequestModel){
        PersonViewModel createdPerson = this.personService.createPerson(personRequestModel);
        return ResponseEntity
                .ok(createdPerson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonViewModel> deletePerson(@PathVariable Long id){
        PersonViewModel deletedPerson = this.personService.deletePerson(id);
        return ResponseEntity
                .ok(deletedPerson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonViewModel> putPerson(@PathVariable Long id,
                                                     @RequestBody PersonRequestModel personRequestModel){
        PersonViewModel putPerson = this.personService.putPerson(id, personRequestModel);
        return ResponseEntity
                .ok(putPerson);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<PersonViewModel> patchPerson(@PathVariable Long id,
                                                               @RequestBody Map<String,String> fields){
        PersonViewModel patchedPerson = this.personService.patchPerson(id, fields);
        return ResponseEntity
                .ok(patchedPerson);
    }

    @ExceptionHandler({PersonNotFoundException.class,
                       FiledDoesNotException.class})
    public ResponseEntity<String> handlePersonNotFoundException(RuntimeException exception){
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }
}
