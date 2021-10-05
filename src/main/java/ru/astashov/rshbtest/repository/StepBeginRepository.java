package ru.astashov.rshbtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.astashov.rshbtest.entity.CreditAppEntity;
import ru.astashov.rshbtest.entity.StepBeginEntity;
import ru.astashov.rshbtest.util.Step;

import java.util.List;

public interface StepBeginRepository extends JpaRepository<StepBeginEntity, Long> {

    // TODO Реализовать загрузку не только данных по StepBegin, но и из StepEnd
    @Query(value = "select sb.stepId, sb.timestamp from StepBeginEntity sb where sb.appNum = ?1")
    List<Step> findStepsByCreditApp(Long appNum);

}
