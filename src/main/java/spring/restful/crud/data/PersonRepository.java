package spring.restful.crud.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.restful.crud.data.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {

    boolean existsById(Long id);

}
