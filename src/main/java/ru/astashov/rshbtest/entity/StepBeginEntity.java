package ru.astashov.rshbtest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import ru.astashov.rshbtest.ref.StepId;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "T_BEGIN")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StepBeginEntity {

    @Id
    private UUID stepGuid;

    @CreationTimestamp
    private Timestamp timestamp;

    @Column(updatable = false, insertable = false)
    private Long appNum;

    @Column(length = 10)
    private String subProduct;

    @Enumerated(EnumType.STRING)
    @Column(length = 5)
    private StepId stepId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="appNum")
    @JsonIgnore
    private CreditAppEntity creditApp;

    @PrePersist
    private void assignUuid() {
        this.setStepGuid(UUID.randomUUID());
    }

}
