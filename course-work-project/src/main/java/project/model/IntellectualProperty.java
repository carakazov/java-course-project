package project.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "intellectual_property")
@EqualsAndHashCode(callSuper = true)
public class IntellectualProperty extends PrimaryKeyEntity {
    private String title;
    private double rating;
    private BigDecimal price = BigDecimal.ZERO;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    @ManyToMany(mappedBy = "createdWorks")
    private List<User> authors;
    @ManyToMany
    @JoinTable(
        name = "genre_intellectual_property",
        joinColumns = @JoinColumn(name = "intellectual_property_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;
    @Column(name = "content_type")
    @Enumerated(EnumType.STRING)
    private ContentTypeEnum contentType;
    @Column(name = "access_type")
    @Enumerated(EnumType.STRING)
    private AccessTypeEnum accessType;
    private byte[] content;
    private Boolean approved;
    @Column(name = "upload_date")
    private LocalDateTime uploadDate;
    @Column(name = "number_of_scores")
    private int numberOfScores;

    @OneToMany(mappedBy = "property")
    private List<AccessBuyerProfile> profiles;
}
