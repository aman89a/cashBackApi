package kg.company.cashbackapi.entity;

import kg.company.cashbackapi.enums.PreferencesCategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Preference Category
 * The list of client preferences category
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "preference_category")
public class PreferenceCategory {

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "preference_category_seq", sequenceName = "preference_category_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "preference_category_seq")
    private Long id;

    /**
     * Parent Preference Category
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "parent_id")
    private PreferenceCategory parent;

    /**
     * Name
     */
    @Column(name = "name")
    private String name;

    /**
     * Type
     * NUMBER, TEXT, CHECKBOX
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private PreferencesCategoryType type;
}


