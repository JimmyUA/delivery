package deliveries.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

    @Query("SELECT delivery from Delivery delivery where delivery.clientId = :client")
    List<Delivery> findByClient(@Param("client") Long clientId);
}
