package template.demo.pet.service;

import template.demo.pet.model.Pet;

public interface IPetService {

    Pet findByPetId(Integer petId);
}
