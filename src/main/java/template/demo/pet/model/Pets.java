package template.demo.pet.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Pets {

    @Id
    private int id;

    @NotNull(message = "name 不能为空")
    private String name;
    private Date birthDate;
    private int typeId;
    private int ownerId;
}
