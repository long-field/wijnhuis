package be.vdab.wijnhuis.domain;

import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="bestelbonnen")
public class Bestelbon implements Serializable, Comparable<Bestelbon> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private LocalDateTime besteld;
    private int bestelwijze;
    private String naam;
    @Embedded
    private Adres adres;
    @ElementCollection(fetch=FetchType.LAZY)
    @CollectionTable(name="bestelbonlijnen", joinColumns= @JoinColumn(name="bonid"))
    private Set<BestelbonLijn> bestelbonlijnen;


    protected Bestelbon() {}
    public Bestelbon(int bestelwijze, String naam, Adres adres, Set<BestelbonLijn> bestelbonlijnen)
            throws IllegalArgumentException, NullPointerException {
        this.besteld = LocalDateTime.now();
        setBestelwijze(bestelwijze);
        setNaam(naam);
        setAdres(adres);
        setBestelbonlijnen(bestelbonlijnen);
    }


    // GETTERS & SETTERS
    public long getId() {
        return this.id;
    }
    public LocalDateTime getBesteld() {
        return this.besteld;
    }
    public int getBestelwijze() {
        return this.bestelwijze;
    }
    public String getNaam() {
        return this.naam;
    }
    public Adres getAdres() {
        return adres;
    }
    public Set<BestelbonLijn> getBestelbonlijnen() {
        return bestelbonlijnen;
    }

    public void setBestelwijze(int bestelwijze) {
        Objects.requireNonNull(bestelwijze, "Verplicht een bestelwijze op te geven.");
        this.bestelwijze = bestelwijze;
    }
    public void setNaam(String naam) throws IllegalArgumentException {
        this.naam = naam;
    }
    public void setAdres(Adres adres) throws NullPointerException {
        Objects.requireNonNull(adres, "Verplicht een adres op te geven.");
        this.adres = adres;
    }
    public void setBestelbonlijnen(Set<BestelbonLijn> bestelbonlijnen) throws NullPointerException {
        Objects.requireNonNull(bestelbonlijnen, "Verplicht bestelbonlijnen op te geven.");
        this.bestelbonlijnen = bestelbonlijnen;
    }

    // OVERRIDDEN OBJECT METHODS
    @Override
    public int hashCode() {
        // besteld is eigenlijk niet uniek genoeg, timestamp zou beter zijn
        final int prime = 31;
        int result = 1;
        result = prime * result + ((besteld == null) ? 0 : besteld.hashCode());
        result = prime * result + ((naam == null) ? 0 : naam.hashCode());
        return result;
    }

    /**
     * Vergelijkt twee bestelbonnen op gelijkheid.
     *
     * Bestelbonnen worden als gelijk beschouwd wanneer ze naar hetzelfde object verwijzen, of wanneer ze gelijke waarden hebben als naam en besteldatum.
     */
    @Override
    public boolean equals(Object obj) {
        // idem comment als bij hashCode
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Bestelbon))
            return false;
        Bestelbon other = (Bestelbon) obj;
        if (besteld == null) {
            if (other.besteld != null)
                return false;
        } else if (!besteld.equals(other.besteld))
            return false;
        if (naam == null) {
            if (other.naam != null)
                return false;
        } else if (!naam.equals(other.naam))
            return false;
        return true;
    }

    /**
     * Vergelijkt twee bestelbonnen met elkaar op basis van naam, en indien dezelfde naam op besteldatum.
     *
     * De teruggegeven waarde is dezelfde als this.naam.compareTo(other.naam).
     * Bij dezelfde namen telt de besteldatum in chronologische, oplopende volgorde. Datums worden vergeleken d.m.v. LocalDate.compareTo.
     */
    @Override
    public int compareTo(Bestelbon other) {
        if (this.naam.compareTo(other.naam) == 0) {
            return this.besteld.compareTo(other.besteld);
        }
        return this.naam.compareTo(other.naam);
    }

}
