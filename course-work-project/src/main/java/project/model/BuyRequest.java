package project.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "buy_requests")
@Data
@Accessors(chain = true)
public class BuyRequest extends PrimaryKeyEntity {
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;
    @ManyToOne
    @JoinColumn(name = "intellectual_property_id")
    private IntellectualProperty property;

    @Column(name = "sending_date")
    private LocalDateTime sendingDate;
    @Column(name = "response_date")
    private LocalDateTime responseDate;

    private boolean success;
}
