package ru.astashov.rshbtest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "T_END")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StepEndEntity {

    @Id
    @SequenceGenerator(name = "stepend_sequence", sequenceName = "stepend_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stepend_sequence")
    private Long id;

    @CreationTimestamp
    private Timestamp timestamp;

    private int stepResultNum;

    @Column(length = 200)
    private String stepResult;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stepGuid")
    private StepBeginEntity stepBeginEntity;

}
