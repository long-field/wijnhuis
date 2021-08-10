package be.vdab.wijnhuis.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "wijnen")
public class Wijn implements Serializable, Comparable<Wijn>{
    private static final long serialVersionUID = 1L;

    // MEMBER VARIABLES
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private byte beoordeling;
    private int inBestelling;
    private int jaar;
    private BigDecimal prijs;

    @ManyToOne(optional=false, fetch=FetchType.LAZY)
    @JoinColumn(name="soortid")
    private Soort soort;


    // CONSTRUCTORS
    protected Wijn() {}

    public Wijn(byte beoordeling, int inBestelling, int jaar, BigDecimal prijs, Soort soort) {
        setBeoordeling(beoordeling);
        setInBestelling(inBestelling);
        setJaar(jaar);
        setPrijs(prijs);
        setSoort(soort);
    }


    // GETTERS & SETTERS
    public long getId() {
        return this.id;
    }
    public byte getBeoordeling() {
        return this.beoordeling;
    }
    public int getInBestelling() {
        return this.inBestelling;
    }
    public int getJaar() {
        return this.jaar;
    }
    public BigDecimal getPrijs() {
        return this.prijs;
    }
    public Soort getSoort() {
        return this.soort;
    }

    public void setSoort(Soort soort) {
        this.soort = soort;
    }
    public void setBeoordeling(byte beoordeling) {
        this.beoordeling = beoordeling;
    }
    public void setInBestelling(int inBestelling) {
        this.inBestelling = inBestelling;
    }
    public void setJaar(int jaar) {
        this.jaar = jaar;
    }
    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    public String getSterrenBeoordeling() {
        String sterretjes = "";
        for (byte i = 0; i < beoordeling; i++) {
            sterretjes += "&#9733;";
        }
        return sterretjes;
    }


    // OVERRIDDEN OBJECT METHODS
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + jaar;
        result = prime * result + ((soort == null) ? 0 : soort.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Wijn))
            return false;
        Wijn other = (Wijn) obj;
        if (jaar != other.jaar)
            return false;
        if (soort == null) {
            if (other.soort != null)
                return false;
        } else if (!soort.equals(other.soort))
            return false;
        return true;
    }

    /**
     * Vergelijkt twee wijnen op natuurlijke volgorde van hun jaartal. Deze is gelijk aan this.jaar - other.jaar.
     */
    @Override
    public int compareTo(Wijn other) {
        return this.jaar - other.jaar;
    }


    // OPERATIONS
    public final void addInBestelling(int aantal) {
        this.inBestelling = this.inBestelling + aantal;
    }
}