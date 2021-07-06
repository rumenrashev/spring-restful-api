package spring.restful.crud;

import org.modelmapper.ModelMapper;

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
        return null;
    }

    @Override
    public PersonViewModel createPerson(PersonRequestModel personRequestModel) {
        return null;
    }

    @Override
    public PersonViewModel putPerson(PersonRequestModel personRequestModel) {
        return null;
    }

    @Override
    public PersonViewModel deletePerson(Long id) {
        return null;
    }
}
