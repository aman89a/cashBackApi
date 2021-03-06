package kg.company.cashbackapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Balance
 * Client can has several Balances
 * One balance for every Organization Bonus
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "balance")
public class Balance {

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "balance_seq", sequenceName = "balance_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balance_seq")
    private Long id;

    /**
     * Client
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "client_id")
    private Client client;

    /**
     * Organization Bonus
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "org_bonus_id")
    private OrgBonus orgBonus;

    /**
     * Amount
     */
    @Column(name = "amount")
    private Double amount;
}
