package be.vdab.wijnhuis.repositories;

import be.vdab.wijnhuis.domain.Land;

import java.util.List;

public interface LandRepository {
    List<Land> findAll();
}
