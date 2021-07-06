package spring.restful.crud.service;

import spring.restful.crud.web.models.PersonRequestModel;
import spring.restful.crud.web.models.PersonViewModel;

import java.util.Set;

public interface PersonService {

    Set<PersonViewModel> getAllPeople();

    PersonViewModel getPersonById(Long id);

    PersonViewModel createPerson(PersonRequestModel personRequestModel);

    PersonViewModel putPerson(Long id,PersonRequestModel personRequestModel);

    PersonViewModel deletePerson(Long id);

}
