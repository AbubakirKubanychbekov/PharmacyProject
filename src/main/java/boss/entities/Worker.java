package boss.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "workers")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Worker {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "worker_seq")
    @SequenceGenerator(
            name = "worker_seq",
    allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private BigDecimal salary;

    private String address;

    private LocalDate dateOfBirth;

    @ManyToOne
    private Pharmacy pharmacy;

}