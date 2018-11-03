package template.demo.pet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import template.demo.pet.model.Pets;

@Repository
public interface PetRepository extends JpaRepository<Pets, Integer> {

    Pets findPetById(Integer petId);

}
