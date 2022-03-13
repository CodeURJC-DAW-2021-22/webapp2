package es.codeurjc.Flyventas.repository;

import es.codeurjc.Flyventas.model.Counteroffer;
import es.codeurjc.Flyventas.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CounterofferRepository extends JpaRepository<Counteroffer, Long> {

    @Query("SELECT p FROM Counteroffer p WHERE p.id=:id")
    public Optional<Counteroffer> findById(@Param("id") Long id);

    public List<Counteroffer> findCounteroffersByReceiver(User receiver, Pageable page);
}