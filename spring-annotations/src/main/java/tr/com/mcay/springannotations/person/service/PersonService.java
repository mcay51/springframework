package tr.com.mcay.springannotations.person.service;

import tr.com.mcay.springannotations.person.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    List<PersonDTO> getAllPersons();
    PersonDTO getPersonById(Long id);
    PersonDTO createPerson(PersonDTO personDTO);
    PersonDTO updatePerson(Long id, PersonDTO personDTO);
    void deletePerson(Long id);
}
