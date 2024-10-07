package tr.com.mcay.springannotations.person.dto.mapper;

import org.mapstruct.Mapper;
import tr.com.mcay.springannotations.person.dto.PersonDTO;
import tr.com.mcay.springannotations.person.model.Person;

import java.util.List;

/**
 * MapStruct Mapper Arayüzü (PersonMapper)
 * MapStruct kullanarak, Person ve PersonDTO arasında dönüşüm yapan bir mapper sınıfı oluşturacağız.
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDTO mapPersonToPersonDTO(Person person);
    Person mapPersonDTOToPerson(PersonDTO personDTO);

    List<PersonDTO> mapPersonsToPersonDTOs(List<Person> persons);
    List<Person> mapPersonDTOsToPersons(List<PersonDTO> personDTOs);
}
