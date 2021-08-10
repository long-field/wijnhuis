package be.vdab.wijnhuis.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "landen")
public class Land {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    @Version
    private long versie;
    @OneToMany(mappedBy = "soorten", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Soort> soorten;

    public Land(String naam) {
        this.naam = naam;
        this.versie = versie;
        this.soorten = new LinkedHashSet<>();
    }

    protected  Land() {
    }

    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public long getVersie() {
        return versie;
    }

    public Set<Soort> getSoorten() {
        return Collections.unmodifiableSet(soorten);
    }
}
