package template.demo.pet.model;

import lombok.Data;

import java.util.Date;

@Data
public class Pet {
    private int id;
    private String name;
    private Date birthDay;
    private int typeId;
    private int ownerId;
}
