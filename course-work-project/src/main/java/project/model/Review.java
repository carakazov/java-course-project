package project.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity(name = "reviews")
@Accessors(chain = true)
@Data
public class Review extends PrimaryKeyEntity {
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    private String text;
    private double score;
    @OneToOne
    @JoinColumn(name = "intellectual_property_id")
    private IntellectualProperty intellectualProperty;
}
