package ru.astashov.rshbtest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_START")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditAppEntity {

    @Id
    @SequenceGenerator(name = "creditapp_sequence", sequenceName = "creditapp_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "creditapp_sequence")
    private Long appNum;

    @CreationTimestamp
    private Timestamp timestamp;

    @Column(length = 10)
    private String product;

    @Column(length = 10)
    private String subProduct;

    @OneToMany(mappedBy = "creditApp", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<StepBeginEntity> stepBeginEntityList = new ArrayList<>();

}
