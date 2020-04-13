package kg.company.cashbackapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Organization Bonus
 * Bonuses created by organization admin for their clients
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "org_bonus")
public class OrgBonus {

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "org_bonus_seq", sequenceName = "org_bonus_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_bonus_seq")
    private Long id;

    /**
     * Organization bonus type
     * Examples: Welcome Bonus, Fixed Bonus, Cash-back Bonus
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "org_bonus_type_id", referencedColumnName = "id")
    private OrgBonusType orgBonusType;

    /**
     * Organization
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    /**
     * Bonus start date
     */
    @Column(name = "valid_from")
    private Date validFrom;

    /**
     * Bonus finish date
     */
    @Column(name = "valid_to")
    private Date validTo;

    /**
     * Bonus validation in days till it's end
     */
    @Column(name = "validity")
    private Integer validity;

    /**
     * Bonus status
     * active = true / false
     */
    @Column(name = "status", columnDefinition = "boolean default true")
    private Boolean status;

    /**
     * Created date
     */
    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;


    /**
     * Deleted date
     */
    @Column(name = "deleted_date")
    private Date deletedDate;
}
