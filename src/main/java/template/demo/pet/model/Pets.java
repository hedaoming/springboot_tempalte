package template.demo.pet.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Pets {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Date birthDate;
    private int typeId;
    private int ownerId;
}
