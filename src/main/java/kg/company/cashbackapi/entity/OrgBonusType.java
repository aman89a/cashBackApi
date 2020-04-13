package kg.company.cashbackapi.entity;

import kg.company.cashbackapi.enums.BonusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "org_bonus_type")
public class OrgBonusType {

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "org_bonus_type_seq", sequenceName = "org_bonus_type_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_bonus_type_seq")
    private Long id;

    /**
     * Name
     */
    @Column
    private String name;

    /**
     * Value Type
     * VALUE / LIST_TYPE
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "value_type")
    private BonusType valueType;
}
