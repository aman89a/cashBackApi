package kg.company.cashbackapi.entity;

import kg.company.cashbackapi.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Client Balance History
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "balance_history")
public class BalanceHistory {

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "balance_history_seq", sequenceName = "balance_history_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balance_history_seq")
    private Long id;

    /**
     * Balance ID
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "balance_id")
    private Balance balance;

    /**
     * Operation Type
     * CREDIT, DEBIT;
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type")
    private OperationType operationType;

    /**
     * Amount
     */
    @Column(name = "amount")
    private Double amount;

    /**
     * Created date
     */
    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;
}
