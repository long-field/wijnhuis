package be.vdab.wijnhuis.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "landen")
public class Land {
    @Id
    @GeneratedValue
    long id;

    private String naam;

    @OneToMany(mappedBy = "land")
    @OrderBy("naam")
    private Set<Soort> soorten;

    public Land() {
    }

    public Land(long id, String naam) {
        this.id = id;
        this.naam = naam;
        this.soorten = new LinkedHashSet<>();
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Set<Soort> getSoorten() {
        return Collections.unmodifiableSet(soorten);
    }

}
