package kg.company.cashbackapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Organization
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organization")
public class Organization {

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "organization_seq", sequenceName = "organization_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_seq")
    private Long id;

    /**
     * Organization Category
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id")
    private OrgCategory orgCategory;

    /**
     * Organization Clients
     */
    @ManyToMany(mappedBy = "organizations")
    Set<Client> clients;

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
     * Status
     * active = true / false
     */
    @Column(name = "status", columnDefinition = "boolean default true")
    private boolean status;

    /**
     * Image URL
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * Created date
     */
    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;
}
