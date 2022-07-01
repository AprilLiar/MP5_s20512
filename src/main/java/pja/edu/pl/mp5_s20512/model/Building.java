package pja.edu.pl.mp5_s20512.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long building_id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 255)
    private String name;

    @NotBlank(message = "Location is mandatory")
    @Size(min = 2, max = 255)
    private String location;

    @NotBlank(message = "Type is mandatory")
    @Size(min = 4, max = 10)
    private String type;

    @ManyToMany(mappedBy = "buildings", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Person> persons = new HashSet<>();
}
