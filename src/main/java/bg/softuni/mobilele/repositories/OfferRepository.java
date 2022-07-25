package bg.softuni.mobilele.repositories;

import bg.softuni.mobilele.model.entities.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

    List<OfferEntity> findAllByModel_NameContains(String query);
}
