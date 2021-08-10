package be.vdab.wijnhuis.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Embeddable
@Access(AccessType.FIELD)
@Table(name = "bestelbonlijnen")
public class BestelbonLijn {
    private int aantal;
    private BigDecimal prijs;
    /*@OneToOne(fetch = FetchType.LAZY, optional = false)
    private Wijn wijn;*/



}
