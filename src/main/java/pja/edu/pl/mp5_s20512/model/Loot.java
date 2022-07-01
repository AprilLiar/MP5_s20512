package pja.edu.pl.mp5_s20512.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Loot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hordeName;

    private String methodOfObtaining;

    @OneToMany(mappedBy = "belongsTo", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Treasure> contents = new HashSet<>();

    @OneToMany(mappedBy = "loot", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Transaction> transactions;
}
