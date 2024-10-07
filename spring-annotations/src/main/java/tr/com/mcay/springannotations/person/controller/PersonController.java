package tr.com.mcay.springannotations.person.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.mcay.springannotations.person.dto.PersonDTO;
import tr.com.mcay.springannotations.person.service.PersonService;

import java.util.List;
@Tag(name = "PersonController", description = "PersonController API")
@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Operation(summary = "Tüm kişileri listele", description = "Veritabanındaki tüm kişileri listeler.")
    @GetMapping
    public List<PersonDTO> getAllPersons() {
        return personService.getAllPersons();
    }

    @Operation(summary = "ID'ye göre kişi getir", description = "Belirtilen ID'ye sahip kişiyi getirir.")
    @GetMapping("/{id}")
    public PersonDTO getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @Operation(summary = "Yeni kişi oluştur", description = "Yeni bir kişi oluşturur.")
    @PostMapping
    public PersonDTO createPerson(@RequestBody PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @Operation(summary = "Kişiyi güncelle", description = "Belirtilen ID'ye sahip kişiyi günceller.")
    @PutMapping("/{id}")
    public PersonDTO updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        return personService.updatePerson(id, personDTO);
    }

    @Operation(summary = "Kişiyi sil", description = "Belirtilen ID'ye sahip kişiyi siler.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

}
