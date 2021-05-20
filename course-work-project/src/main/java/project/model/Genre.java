package project.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity(name = "genres")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Genre extends PrimaryKeyEntity {
    @Enumerated(EnumType.STRING)
    private GenreTypeEnum title;
    @ManyToMany(mappedBy = "genres")
    private List<IntellectualProperty> properties;
}
