package spring.restful.crud;

import org.modelmapper.ModelMapper;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

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
        return null;
    }

    private void existById(Long id){
        if(!this.personRepository.existsById(id)){
            throw new PersonNotFoundException(id);
        }
    }
}
