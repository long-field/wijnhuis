package be.vdab.wijnhuis.domain;

import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "bestelbonnen")
public class Bestelbon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate besteld;
    private String naam;
    private String straat;
    private String huisNr;
    private String postCode;
    private String gemeente;
    private int bestelWijze;
    @Version
    private long versie;



}
