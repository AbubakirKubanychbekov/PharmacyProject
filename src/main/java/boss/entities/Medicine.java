package boss.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "medicines")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "medicine_seq")
    @SequenceGenerator(
            name = "medicine_seq",
    allocationSize = 1)

    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

//    @Column(columnDefinition = "NUMERIC(10, 2) CHECK (price >= 0)")
    private BigDecimal price;

    @ToString.Exclude
    @ManyToMany(mappedBy = "medicines",
    cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Pharmacy>pharmacies;


}