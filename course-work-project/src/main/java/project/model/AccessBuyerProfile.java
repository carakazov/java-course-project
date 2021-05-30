package project.model;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "access_buyer_profiles")
@Data
@Accessors(chain = true)
public class AccessBuyerProfile extends PrimaryKeyEntity {
    @ManyToOne
    @JoinColumn(name = "intellectual_property_id")
    private IntellectualProperty property;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "bought_forever")
    private Boolean boughtForever;
    private Boolean watched;
}
