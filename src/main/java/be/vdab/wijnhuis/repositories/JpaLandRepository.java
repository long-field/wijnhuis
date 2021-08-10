package be.vdab.wijnhuis.repositories;

import be.vdab.wijnhuis.domain.Land;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaLandRepository implements LandRepository{
    private final EntityManager manager;


    public JpaLandRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Land> findAll() {
        return manager.createQuery("select l from Land l", Land.class).getResultList();
    }
}
