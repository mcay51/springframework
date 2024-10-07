package tr.com.mcay.springannotations.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.mcay.springannotations.person.dto.PersonDTO;
import tr.com.mcay.springannotations.person.dto.mapper.PersonMapper;
import tr.com.mcay.springannotations.person.model.Person;
import tr.com.mcay.springannotations.person.repository.PersonRepository;
import tr.com.mcay.springannotations.person.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }
    @Override
    public List<PersonDTO> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return personMapper.mapPersonsToPersonDTOs(persons);
    }
    @Override
    public PersonDTO getPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
        return personMapper.mapPersonToPersonDTO(person);
    }
    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = personMapper.mapPersonDTOToPerson(personDTO);
        Person savedPerson = personRepository.save(person);
        return personMapper.mapPersonToPersonDTO(savedPerson);
    }
    @Override
    public PersonDTO updatePerson(Long id, PersonDTO personDTO) {
        Person existingPerson = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));

        existingPerson.setFirstName(personDTO.getFirstName());
        existingPerson.setLastName(personDTO.getLastName());
        existingPerson.setEmail(personDTO.getEmail());

        Person updatedPerson = personRepository.save(existingPerson);
        return personMapper.mapPersonToPersonDTO(updatedPerson);
    }
    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
