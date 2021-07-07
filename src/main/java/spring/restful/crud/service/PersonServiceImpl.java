package spring.restful.crud.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import spring.restful.crud.exceptions.FiledDoesNotException;
import spring.restful.crud.exceptions.PersonNotFoundException;
import spring.restful.crud.web.models.PersonRequestModel;
import spring.restful.crud.web.models.PersonViewModel;
import spring.restful.crud.data.PersonEntity;
import spring.restful.crud.data.PersonRepository;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    public PersonServiceImpl(PersonRepository personRepository,
                             ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<PersonViewModel> getAllPeople() {
        return this.personRepository.findAll()
                .stream()
                .map(e-> this.modelMapper.map(e,PersonViewModel.class))
                .collect(Collectors.toSet());
    }

    @Override
    public PersonViewModel getPersonById(Long id) {
        return this.personRepository.findById(id)
                .map(e-> this.modelMapper.map(e,PersonViewModel.class))
                .orElseThrow(()-> new PersonNotFoundException(id));
    }

    @Override
    @Transactional
    public PersonViewModel createPerson(PersonRequestModel personRequestModel) {
        PersonEntity entity = this.modelMapper.map(personRequestModel, PersonEntity.class);
        PersonEntity savedEntity = this.personRepository.saveAndFlush(entity);
        return this.modelMapper.map(savedEntity,PersonViewModel.class);
    }

    @Override
    public PersonViewModel putPerson(Long id,PersonRequestModel personRequestModel) {
        existById(id);
        PersonEntity entity = this.modelMapper.map(personRequestModel, PersonEntity.class);
        entity.setId(id);
        PersonEntity savedEntity = this.personRepository.saveAndFlush(entity);
        return this.modelMapper.map(savedEntity,PersonViewModel.class);
    }

    @Override
    public PersonViewModel deletePerson(Long id) {
        PersonViewModel entity = this.getPersonById(id);
        this.personRepository.deleteById(id);
        return this.modelMapper.map(entity,PersonViewModel.class);
    }

    @Override
    public PersonViewModel patchPerson(Long id, Map<String, String> fields) {
       PersonEntity personEntity = this.personRepository.findById(id)
               .orElseThrow(()-> new PersonNotFoundException(id));
        fields
                .forEach((fieldName, fieldValue) -> {
                    switch (fieldName) {
                        case "firstName":
                            personEntity.setFirstName(fieldValue);
                            break;
                        case "lastName":
                            personEntity.setLastName(fieldValue);
                            break;
                        case "age":
                            personEntity.setAge(Byte.parseByte(fieldValue));
                            break;
                        default:
                            throw new FiledDoesNotException(fieldName);
                    }
                });
        PersonEntity savedEntity = this.personRepository.saveAndFlush(personEntity);
        return this.modelMapper.map(savedEntity,PersonViewModel.class);
    }

    private void existById(Long id){
        if(!this.personRepository.existsById(id)){
            throw new PersonNotFoundException(id);
        }
    }
}
