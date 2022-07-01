package pja.edu.pl.mp5_s20512.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "worker_id", nullable = false)
    @NotNull
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    @NotNull
    private Loot loot;

    @NotNull
    private LocalDate transDate;
}
