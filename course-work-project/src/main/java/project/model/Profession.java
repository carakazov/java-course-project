package project.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Entity(name = "professions")
public class Profession extends PrimaryKeyEntity {
    @Enumerated(EnumType.STRING)
    private ProfessionEnum title;
}
