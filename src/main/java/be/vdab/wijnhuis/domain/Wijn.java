package be.vdab.wijnhuis.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "wijnen")
public class Wijn {
    @Id
    @GeneratedValue
    long id;
    private int jaar;
    private int beoordeling;
    private BigDecimal prijs;
    private long inBestelling;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "soortid")
    private Soort soort;

    protected Wijn() {
    }

    public Wijn(int jaar, int beoordeling, BigDecimal prijs, long inBestelling, Soort soort) {
        this.jaar = jaar;
        this.beoordeling = beoordeling;
        this.prijs = prijs;
        this.inBestelling = inBestelling;
        this.soort = soort;
    }

    public long getId() {
        return id;
    }

    public int getJaar() {
        return jaar;
    }

    public int getBeoordeling() {
        return beoordeling;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public long getInBestelling() {
        return inBestelling;
    }

    public Soort getSoort() {
        return soort;
    }
}