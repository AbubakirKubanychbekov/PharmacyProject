package boss.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@EntityListeners(Listens.class)
@Entity
@Table(name = "pharmacies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pharmacy {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pharmacy_seq")
    @SequenceGenerator(
            name = "pharmacy_seq",
    allocationSize = 1)

    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "pharmacy",
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Worker>workers;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Medicine>medicines;

    private LocalDate createdEt;
    private LocalDate updatedEt;
}