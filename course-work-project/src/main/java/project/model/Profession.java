package project.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;


@Entity(name = "professions")
@Data
public class Profession extends PrimaryKeyEntity {
    @Enumerated(EnumType.STRING)
    private ProfessionEnum title;
}
