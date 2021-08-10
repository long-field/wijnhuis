package be.vdab.wijnhuis.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "soorten")
public class Soort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    @Version
    private long versie;
    @OneToMany(mappedBy = "soorten")
    @JoinColumn(name = "soortId")
    private Set<Wijn> wijnen;
    @ManyToOne(optional = false)
    @JoinColumn(name = "landId")
    private Land land;
    protected Soort() {
    }
    public Soort(String naam, Land land) {
        this.naam = naam;
        this.land = land;
        this.versie = 1;
        this.wijnen= new LinkedHashSet<>();

    }
    public long getId() {
        return id;
    }
    public String getNaam() {
        return naam;
    }
    public Land getLand() {
        return land;
    }
    public long getVersie() {
        return versie;
    }
    public Set<Wijn> getWijnen() {
        return Collections.unmodifiableSet(wijnen);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Soort soort = (Soort) o;
        return id == soort.id && versie == soort.versie && Objects.equals(naam, soort.naam) && Objects.equals(wijnen, soort.wijnen) && Objects.equals(land, soort.land);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naam, versie, wijnen, land);
    }
}
