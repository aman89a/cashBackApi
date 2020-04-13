package kg.company.cashbackapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Organization Category
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "org_category")
public class OrgCategory {

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "org_category_seq", sequenceName = "org_category_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_category_seq")
    private Long id;

    /**
     * Name
     */
    @Column(name = "name")
    private String name;

    /**
     * Description
     */
    @Column(name = "description")
    private String description;

    /**
     * Tags
     */
    @ManyToMany
    @JoinTable(
            name = "org_category_tag",
            joinColumns = @JoinColumn(name = "org_category_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    Set<OrgCategoryTag> tags;

    /**
     * Image URL
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * Created Date
     */
    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

}
