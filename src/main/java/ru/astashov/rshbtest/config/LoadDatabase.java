package ru.astashov.rshbtest.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.astashov.rshbtest.entity.CreditAppEntity;
import ru.astashov.rshbtest.entity.StepBeginEntity;
import ru.astashov.rshbtest.entity.StepEndEntity;
import ru.astashov.rshbtest.ref.StepId;
import ru.astashov.rshbtest.repository.CreditAppRepository;
import ru.astashov.rshbtest.repository.StepBeginRepository;
import ru.astashov.rshbtest.repository.StepEndRepository;

@Configuration
public class LoadDatabase {

    @Bean
    public CommandLineRunner initDatabase(CreditAppRepository creditAppRepository, StepBeginRepository stepBeginRepository, StepEndRepository stepEndRepository) {
        return args -> {
            // Генерим заявку 1 с её этапами
            CreditAppEntity creditAppEntity = new CreditAppEntity();
            creditAppEntity.setProduct("P1");
            creditAppEntity.setSubProduct("SP_P1_0001");
            creditAppRepository.save(creditAppEntity);

            StepBeginEntity stepBeginEntity = new StepBeginEntity();
            stepBeginEntity.setSubProduct("SP_P1_0001");
            stepBeginEntity.setStepId(StepId.NEW);
            stepBeginEntity.setCreditApp(creditAppEntity);
            stepBeginRepository.save(stepBeginEntity);

            StepEndEntity stepEndEntity = new StepEndEntity();
            stepEndEntity.setStepResultNum(0);
            stepEndEntity.setStepResult("SUCCESS");
            stepEndEntity.setStepBeginEntity(stepBeginEntity);
            stepEndRepository.save(stepEndEntity);

            stepBeginEntity = new StepBeginEntity();
            stepBeginEntity.setSubProduct("SP_P1_0001");
            stepBeginEntity.setStepId(StepId.VRF);
            stepBeginEntity.setCreditApp(creditAppEntity);
            stepBeginRepository.save(stepBeginEntity);

            stepEndEntity = new StepEndEntity();
            stepEndEntity.setStepResultNum(0);
            stepEndEntity.setStepResult("SUCCESS");
            stepEndEntity.setStepBeginEntity(stepBeginEntity);
            stepEndRepository.save(stepEndEntity);

            stepBeginEntity = new StepBeginEntity();
            stepBeginEntity.setSubProduct("SP_P1_0001");
            stepBeginEntity.setStepId(StepId.PROC);
            stepBeginEntity.setCreditApp(creditAppEntity);
            stepBeginRepository.save(stepBeginEntity);

            stepEndEntity = new StepEndEntity();
            stepEndEntity.setStepResultNum(0);
            stepEndEntity.setStepResult("SUCCESS");
            stepEndEntity.setStepBeginEntity(stepBeginEntity);
            stepEndRepository.save(stepEndEntity);

            stepBeginEntity = new StepBeginEntity();
            stepBeginEntity.setSubProduct("SP_P1_0001");
            stepBeginEntity.setStepId(StepId.DSC);
            stepBeginEntity.setCreditApp(creditAppEntity);
            stepBeginRepository.save(stepBeginEntity);

            stepEndEntity = new StepEndEntity();
            stepEndEntity.setStepResultNum(0);
            stepEndEntity.setStepResult("SUCCESS");
            stepEndEntity.setStepBeginEntity(stepBeginEntity);
            stepEndRepository.save(stepEndEntity);


            // Генерим заявку 2 с её этапами
            creditAppEntity = new CreditAppEntity();
            creditAppEntity.setProduct("P2");
            creditAppEntity.setSubProduct("SP_P2_0001");
            creditAppRepository.save(creditAppEntity);

            stepBeginEntity = new StepBeginEntity();
            stepBeginEntity.setSubProduct("SP_P2_0001");
            stepBeginEntity.setStepId(StepId.NEW);
            stepBeginEntity.setCreditApp(creditAppEntity);
            stepBeginRepository.save(stepBeginEntity);

            stepEndEntity = new StepEndEntity();
            stepEndEntity.setStepResultNum(0);
            stepEndEntity.setStepResult("SUCCESS");
            stepEndEntity.setStepBeginEntity(stepBeginEntity);
            stepEndRepository.save(stepEndEntity);


            // Генерим заявку 3 с её этапами
            creditAppEntity = new CreditAppEntity();
            creditAppEntity.setProduct("P2");
            creditAppEntity.setSubProduct("SP_P2_0001");
            creditAppRepository.save(creditAppEntity);

            stepBeginEntity = new StepBeginEntity();
            stepBeginEntity.setSubProduct("SP_P2_0001");
            stepBeginEntity.setStepId(StepId.NEW);
            stepBeginEntity.setCreditApp(creditAppEntity);
            stepBeginRepository.save(stepBeginEntity);

            stepEndEntity = new StepEndEntity();
            stepEndEntity.setStepResultNum(0);
            stepEndEntity.setStepResult("SUCCESS");
            stepEndEntity.setStepBeginEntity(stepBeginEntity);
            stepEndRepository.save(stepEndEntity);


            // Генерим заявку 4 с её этапами
            creditAppEntity = new CreditAppEntity();
            creditAppEntity.setProduct("P2");
            creditAppEntity.setSubProduct("SP_P2_0001");
            creditAppRepository.save(creditAppEntity);

            stepBeginEntity = new StepBeginEntity();
            stepBeginEntity.setSubProduct("SP_P2_0001");
            stepBeginEntity.setStepId(StepId.NEW);
            stepBeginEntity.setCreditApp(creditAppEntity);
            stepBeginRepository.save(stepBeginEntity);

            stepEndEntity = new StepEndEntity();
            stepEndEntity.setStepResultNum(0);
            stepEndEntity.setStepResult("SUCCESS");
            stepEndEntity.setStepBeginEntity(stepBeginEntity);
            stepEndRepository.save(stepEndEntity);

            stepBeginEntity = new StepBeginEntity();
            stepBeginEntity.setSubProduct("SP_P2_0001");
            stepBeginEntity.setStepId(StepId.VRF);
            stepBeginEntity.setCreditApp(creditAppEntity);
            stepBeginRepository.save(stepBeginEntity);

            stepEndEntity = new StepEndEntity();
            stepEndEntity.setStepResultNum(0);
            stepEndEntity.setStepResult("SUCCESS");
            stepEndEntity.setStepBeginEntity(stepBeginEntity);
            stepEndRepository.save(stepEndEntity);


            // Генерим заявку 5 с её этапами
            creditAppEntity = new CreditAppEntity();
            creditAppEntity.setProduct("P3");
            creditAppEntity.setSubProduct("SP_P3_0001");
            creditAppRepository.save(creditAppEntity);

            stepBeginEntity = new StepBeginEntity();
            stepBeginEntity.setSubProduct("SP_P3_0001");
            stepBeginEntity.setStepId(StepId.NEW);
            stepBeginEntity.setCreditApp(creditAppEntity);
            stepBeginRepository.save(stepBeginEntity);

            stepEndEntity = new StepEndEntity();
            stepEndEntity.setStepResultNum(0);
            stepEndEntity.setStepResult("SUCCESS");
            stepEndEntity.setStepBeginEntity(stepBeginEntity);
            stepEndRepository.save(stepEndEntity);

            stepBeginEntity = new StepBeginEntity();
            stepBeginEntity.setSubProduct("SP_P3_0001");
            stepBeginEntity.setSubProduct("SP_P3_0001");
            stepBeginEntity.setStepId(StepId.VRF);
            stepBeginEntity.setCreditApp(creditAppEntity);
            stepBeginRepository.save(stepBeginEntity);

            stepEndEntity = new StepEndEntity();
            stepEndEntity.setStepResultNum(0);
            stepEndEntity.setStepResult("SUCCESS");
            stepEndEntity.setStepBeginEntity(stepBeginEntity);
            stepEndRepository.save(stepEndEntity);


            // Генерим заявку 6 с её этапами
            creditAppEntity = new CreditAppEntity();
            creditAppEntity.setProduct("P1");
            creditAppEntity.setSubProduct("SP_P1_0001");
            creditAppRepository.save(creditAppEntity);

            stepBeginEntity = new StepBeginEntity();
            stepBeginEntity.setSubProduct("SP_P1_0001");
            stepBeginEntity.setStepId(StepId.NEW);
            stepBeginEntity.setCreditApp(creditAppEntity);
            stepBeginRepository.save(stepBeginEntity);

            stepEndEntity = new StepEndEntity();
            stepEndEntity.setStepResultNum(0);
            stepEndEntity.setStepResult("SUCCESS");
            stepEndEntity.setStepBeginEntity(stepBeginEntity);
            stepEndRepository.save(stepEndEntity);

            stepBeginEntity = new StepBeginEntity();
            stepBeginEntity.setSubProduct("SP_P1_0001");
            stepBeginEntity.setStepId(StepId.VRF);
            stepBeginEntity.setCreditApp(creditAppEntity);
            stepBeginRepository.save(stepBeginEntity);

            stepEndEntity = new StepEndEntity();
            stepEndEntity.setStepResultNum(0);
            stepEndEntity.setStepResult("SUCCESS");
            stepEndEntity.setStepBeginEntity(stepBeginEntity);
            stepEndRepository.save(stepEndEntity);

            stepBeginEntity = new StepBeginEntity();
            stepBeginEntity.setSubProduct("SP_P1_0001");
            stepBeginEntity.setStepId(StepId.PROC);
            stepBeginEntity.setCreditApp(creditAppEntity);
            stepBeginRepository.save(stepBeginEntity);

            stepEndEntity = new StepEndEntity();
            stepEndEntity.setStepResultNum(0);
            stepEndEntity.setStepResult("SUCCESS");
            stepEndEntity.setStepBeginEntity(stepBeginEntity);
            stepEndRepository.save(stepEndEntity);

            stepBeginEntity = new StepBeginEntity();
            stepBeginEntity.setSubProduct("SP_P1_0001");
            stepBeginEntity.setStepId(StepId.DSC);
            stepBeginEntity.setCreditApp(creditAppEntity);
            stepBeginRepository.save(stepBeginEntity);

        };
    }

}
