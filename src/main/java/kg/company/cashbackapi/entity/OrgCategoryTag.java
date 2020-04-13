package kg.company.cashbackapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Organization category tag
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tag")
public class OrgCategoryTag {

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "category_tag_seq", sequenceName = "category_tag_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_tag_seq")
    private Long id;

    /**
     * Name
     */
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "tags")
    Set<OrgCategory> orgCategories;
}
