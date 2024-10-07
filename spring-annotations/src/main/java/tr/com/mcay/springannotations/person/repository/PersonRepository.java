package tr.com.mcay.springannotations.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.mcay.springannotations.person.model.Person;

import java.util.List;

/**
 * @Repository anotasyonu ile veri tabanına erişimi sağlayan sınıfı tanımlayacağız.
 * Spring bu sınıfı otomatik olarak bir bean olarak yönetecek.
 * Aslında JpaRepository için  bu anotasyonu burada kullanmayabiliriz.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByLastName(String lastName);
}
