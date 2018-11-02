package template.demo.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import template.demo.pet.dao.PetRepository;
import template.demo.pet.model.Pets;

@Service
public class PetServiceImpl implements IPetService {

    @Autowired
    PetRepository petRepository;

    @Override
    public Pets findByPetId(Integer petId) {
        return petRepository.findPetById(petId);
    }
}
