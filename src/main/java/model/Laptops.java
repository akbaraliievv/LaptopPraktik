package model;

import enums.OperationSystem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor

public class Laptops {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "laptop_id")
    @SequenceGenerator(name = "laptop_id",sequenceName = "laptop",allocationSize = 1)
    private Long id;
    private String brand;
    @Column(name = "operation_system")
    @Enumerated(EnumType.STRING)
    private OperationSystem operationSystem;
    private String memory;
    private int price;
    @Column(name = "date_of_issue")
    private Date dateOfIssue;

    public Laptops(String brand, OperationSystem operationSystem, String memory, int price, Date dateOfIssue) {
        this.brand = brand;
        this.operationSystem = operationSystem;
        this.memory = memory;
        this.price = price;
        this.dateOfIssue = dateOfIssue;
    }
}
