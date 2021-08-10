package be.vdab.wijnhuis.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "wijnen")
public class Wijn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int jaar;
    private int  beoordeling;
    private BigDecimal prijs;
    private int inBestelling;
    @Version
    private long versie;

    public Wijn( int jaar, int beoordeling, BigDecimal prijs, int inBestelling) {

        this.jaar = jaar;
        this.beoordeling = beoordeling;
        this.prijs = prijs;
        this.inBestelling = inBestelling;
        this.versie = 1;
    }
    protected Wijn() {
    }
    public int getBeoordeling() {
        return beoordeling;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }



    public long getId() {
        return id;
    }



    public int getJaar() {
        return jaar;
    }

    public int getInBestelling() {
        return inBestelling;
    }

    public long getVersie() {
        return versie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wijn wijn = (Wijn) o;
        return id == wijn.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jaar, inBestelling, versie);
    }
}
