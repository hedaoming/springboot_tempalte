package template.demo.pet.service;

import template.demo.pet.model.Pets;

public interface IPetService {

    Pets findByPetId(Integer petId);

    void savePet(Pets pet);

    void deletePet(Integer petId);
}
