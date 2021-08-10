package be.vdab.wijnhuis.repositories;

import be.vdab.wijnhuis.domain.Soort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaSoortRepository implements SoortRepository{
    private final EntityManager manager;

    public JpaSoortRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Soort> soortByLandId(long id) {
        return null;
    }



}
