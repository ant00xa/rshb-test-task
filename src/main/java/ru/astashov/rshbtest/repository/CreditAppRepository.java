package ru.astashov.rshbtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.astashov.rshbtest.entity.CreditAppEntity;
import ru.astashov.rshbtest.util.ProductStatistic;

import java.sql.Timestamp;
import java.util.List;

public interface CreditAppRepository extends JpaRepository<CreditAppEntity, Long> {

    List<CreditAppEntity> findCreditAppEntityBySubProduct(String subProduct);

    List<CreditAppEntity> findCreditAppEntitiesByTimestampBetween(Timestamp dateStart, Timestamp dateEnd);

    @Query(value = "select cr " +
            "from CreditAppEntity cr " +
            "where cr.subProduct = ?1 " +
            "and not exists (select sb from StepBeginEntity sb where cr.appNum = sb.appNum and sb.stepId = 'VRF')")
    List<CreditAppEntity> findNotVrfBySubProduct(String subProduct);

    // TODO Решить проблему с конвертацией из нативного запроса в List<ProductStatistic>
    @Query(nativeQuery = true,
            value = "select res.product as product, res.count as count " +
                    "from " +
                    "(select st.product as product, COUNT(st.*) as count " +
                    "from t_start st " +
                    "where st.timestamp between ?1 and ?2 " +
                    "group by st.product ) as res " +
                    "order by count desc " +
                    "limit 5")
    List<ProductStatistic> findProductsTopByAppTimestampBetween(Timestamp dateStart, Timestamp dateEnd);

    @Query(nativeQuery = true,
            value = "select * from " +
                    "t_start ts " +
                    "where exists(select * " +
                    "from t_begin tb " +
                    "where tb.app_num = ts.app_num " +
                    "and tb.step_id = 'DSC' " +
                    "and DATE_PART('day', tb.timestamp - current_timestamp) >= ?1 " +
                    "and not exists(select * from t_end te where te.step_guid = tb.step_guid))")
    List<CreditAppEntity> findExpiredDscByDays(int days);

}
