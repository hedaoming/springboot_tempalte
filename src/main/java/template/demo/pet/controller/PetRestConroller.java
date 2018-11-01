package template.demo.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import template.demo.pet.model.Pet;
import template.demo.pet.service.IPetService;

@RestController
@RequestMapping("api/pets")
public class PetRestConroller {

    @Autowired
    IPetService petService;

    @RequestMapping(value = "/{petId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Pet> getPet(@PathVariable("petId") Integer petId){
        Pet pet = petService.findByPetId(petId);
        if (pet == null){
            return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Pet>(pet, HttpStatus.OK);
    }
}
