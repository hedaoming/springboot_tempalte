package template.demo.pet;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import template.demo.BaseTest;
import template.demo.pet.model.Pets;
import template.demo.pet.service.IPetService;

import javax.transaction.Transactional;
import java.util.Date;

public class ServiceTest extends BaseTest {

    @Autowired
    IPetService petService;

    Integer petId;
    Pets pet;

    @Before
    public void setValues(){
        petId = 1;
        pet = new Pets();
        pet.setName("Hoo");
        pet.setBirthDate(new Date());
        pet.setOwnerId(1);
        pet.setTypeId(0);
    }

    @Test
    @Transactional
    public void testFindPetById(){
        Pets petDB = petService.findByPetId(petId);
        Assert.assertNotNull(petDB);
        Assert.assertEquals("Hoo", petDB.getName());
    }
}
