package be.vdab.wijnhuis.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "soorten")
public class Soort {
    @Id
    @GeneratedValue
    long id;

    private String naam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landid")
    private Land land;

    @OneToMany(mappedBy = "soort")
    @OrderBy("jaar")
    private Set<Wijn> wijnen;


}
