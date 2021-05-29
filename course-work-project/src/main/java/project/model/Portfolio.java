package project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity(name = "portfolios")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Portfolio extends PrimaryKeyEntity {
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "portfolio")
    private byte[] portfolio;
}
