package kg.company.cashbackapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Filial of Organization
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "filial")
public class Filial {

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "filial_seq", sequenceName = "filial_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filial_seq")
    private Long id;

    /**
     * Filial Organization
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "organization_id")
    private Organization organization;

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
     * Filial address
     */
    @Column(name = "address")
    private String address;

    /**
     * Filial latitude
     */
    @Column(name = "latitude")
    private Double latitude;

    /**
     * Filial longitude
     */
    @Column(name = "longitude")
    private Double longitude;

    /**
     * Average rate
     */
    @Column(name = "average_rate")
    private Double averageRate;

    /**
     * Status
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

}
