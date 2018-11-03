package template.demo.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import template.demo.pet.model.Pets;
import template.demo.pet.service.IPetService;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("api/pets")
public class PetRestConroller {

    @Autowired
    IPetService petService;

    @RequestMapping(value = "/{petId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Pets> getPet(@PathVariable("petId") Integer petId){
        Pets pet = petService.findByPetId(petId);
        if (pet == null){
            return new ResponseEntity<Pets>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Pets>(pet, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Pets> addPet(@RequestBody @Valid Pets pet, BindingResult bindingResult, UriComponentsBuilder uriBuilder){

        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors() || pet == null){
            headers.add("errors", bindingResult.getAllErrors().toString());
            return new ResponseEntity<Pets>(headers, HttpStatus.BAD_REQUEST);
        }

        pet.setBirthDate(new Date());
        petService.savePet(pet);
        headers.setLocation(uriBuilder.path("/api/pets/{petId}").buildAndExpand(pet.getId()).toUri());
        return new ResponseEntity<>(pet, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{petId}", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Pets> updatePet(@PathVariable Integer petId, @RequestBody Pets pet){
        Pets currentPet =petService.findByPetId(petId);
        if (currentPet == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentPet.setName(pet.getName());
        currentPet.setBirthDate(pet.getBirthDate());
        currentPet.setOwnerId(pet.getOwnerId());
        currentPet.setTypeId(pet.getTypeId());
        petService.savePet(currentPet);
        return new ResponseEntity<>(currentPet, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{petId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Pets> deletePet(@PathVariable Integer petId){
        Pets pet = petService.findByPetId(petId);
        if (pet == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        petService.deletePet(petId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
