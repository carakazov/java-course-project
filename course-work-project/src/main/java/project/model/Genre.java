package project.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "genres")
@EqualsAndHashCode(callSuper = true)
public class Genre extends PrimaryKeyEntity {
    @Enumerated(EnumType.STRING)
    private GenreTypeEnum title;

}
