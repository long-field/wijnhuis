package be.vdab.wijnhuis.repositories;

import be.vdab.wijnhuis.domain.Soort;

import java.util.List;

public interface SoortRepository {
    List<Soort> soortByLandId(long id);
}
