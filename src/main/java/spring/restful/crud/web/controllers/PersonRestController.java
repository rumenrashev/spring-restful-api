package spring.restful.crud.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.restful.crud.exceptions.FiledDoesNotException;
import spring.restful.crud.exceptions.PersonNotFoundException;
import spring.restful.crud.service.PersonService;
import spring.restful.crud.web.models.PersonRequestModel;
import spring.restful.crud.web.models.MessageResponse;
import spring.restful.crud.web.models.PersonViewModel;

import static spring.restful.crud.constants.Messages.*;
import static spring.restful.crud.constants.URLs.*;

import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(PEOPLE_URL)
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<MessageResponse> getAllPeople() {
        Set<PersonViewModel> allPeople = this.personService.getAllPeople();
        MessageResponse messageResponse = new MessageResponse(GET_ALL_PEOPLE_MESSAGE, allPeople);
        return ResponseEntity
                .ok()
                .body(messageResponse);
    }

    @GetMapping(PERSON_ID)
    public ResponseEntity<MessageResponse> getPersonById(@PathVariable Long id) {
        PersonViewModel personById = this.personService.getPersonById(id);
        MessageResponse messageResponse = new MessageResponse(GET_PERSON_BY_ID_MESSAGE, personById);
        return ResponseEntity
                .ok()
                .body(messageResponse);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> createPerson(@RequestBody PersonRequestModel personRequestModel) {
        PersonViewModel createdPerson = this.personService.createPerson(personRequestModel);
        MessageResponse messageResponse = new MessageResponse(CREATE_PERSON_MESSAGE, createdPerson);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(messageResponse);
    }

    @DeleteMapping(PERSON_ID)
    public ResponseEntity<MessageResponse> deletePerson(@PathVariable Long id) {
        PersonViewModel deletedPerson = this.personService.deletePerson(id);
        MessageResponse messageResponse = new MessageResponse(DELETE_PERSON_BY_ID_MESSAGE, deletedPerson);
        return ResponseEntity
                .ok()
                .body(messageResponse);
    }

    @PutMapping(PERSON_ID)
    public ResponseEntity<MessageResponse> putPerson(@PathVariable Long id,
                                                     @RequestBody PersonRequestModel personRequestModel) {
        PersonViewModel editedPerson = this.personService.putPerson(id, personRequestModel);
        MessageResponse messageResponse = new MessageResponse(EDIT_PERSON_MESSAGE, editedPerson);
        return ResponseEntity
                .ok()
                .body(messageResponse);

    }

    @DeleteMapping
    public ResponseEntity<MessageResponse> deleteAllPeople(){
        Set<PersonViewModel> deletedPeople = this.personService.deleteAllPeople();
        MessageResponse messageResponse = new MessageResponse(DELETE_ALL_PEOPLE_MESSAGE, deletedPeople);
        return ResponseEntity
                .ok()
                .body(messageResponse);
    }

    @PatchMapping(PERSON_ID)
    public ResponseEntity<MessageResponse> patchPerson(@PathVariable Long id,
                                                       @RequestBody Map<String, String> fields) {
        PersonViewModel editedPerson = this.personService.patchPerson(id, fields);
        MessageResponse messageResponse = new MessageResponse(EDIT_PERSON_MESSAGE, editedPerson);
        return ResponseEntity
                .ok()
                .body(messageResponse);
    }


    @ExceptionHandler({PersonNotFoundException.class,
            FiledDoesNotException.class})
    public ResponseEntity<String> handleBadRequests(RuntimeException exception) {
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }
}
