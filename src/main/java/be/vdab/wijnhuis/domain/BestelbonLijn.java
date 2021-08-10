package be.vdab.wijnhuis.domain;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;

@Embeddable
public class BestelbonLijn implements Serializable {
    private static final long serialVersionUID = 1L;

    private int aantal;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="wijnid")
    private Wijn wijn;

    // CONSTRUCTORS
    protected BestelbonLijn() {}

    public BestelbonLijn(int aantal, Wijn wijn) {
        this.aantal = aantal;
        this.wijn = wijn;
    }

    public int getAantal() {
        return aantal;
    }
    public Wijn getWijn() {
        return wijn;
    }
    public BigDecimal getTotaalPrijs() {
        return this.wijn.getPrijs().multiply(BigDecimal.valueOf(aantal));
    }


    // OVERRIDDEN OBJECT METHODS
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + aantal;
        result = prime * result + ((wijn == null) ? 0 : wijn.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BestelbonLijn other = (BestelbonLijn) obj;
        if (aantal != other.aantal)
            return false;
        if (wijn == null) {
            if (other.wijn != null)
                return false;
        } else if (!wijn.equals(other.wijn))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Bestelbonlijn [aantal=" + aantal + ", wijn=" + wijn + "]";
    }

}
