package pja.edu.pl.mp5_s20512.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Worker extends Person{

    @NotNull
    private double wage;

    @ElementCollection
    @CollectionTable(name = "worker_skill", joinColumns = @JoinColumn(name = "worker_id"))
    @Builder.Default
    private Set<String> skills = new HashSet<>();

    @OneToMany(mappedBy = "worker", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Transaction> transactions;


}
