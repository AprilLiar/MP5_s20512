package pja.edu.pl.mp5_s20512.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Treasure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "loot_id", nullable = false, updatable = false)
    private Treasure belongsTo;

    @NotBlank
    private String type;

    @NotBlank
    private int amount;

}
