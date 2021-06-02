package project.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity(name = "vacancies")
public class Vacancy extends PrimaryKeyEntity {
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private User employer;
    private String description;
    private BigDecimal salary;
    @Column(name = "open_date")
    private LocalDateTime openDate;
    @Column(name = "work_experience")
    private int workExperience;
    @OneToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;
}

