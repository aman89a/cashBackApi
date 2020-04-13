package kg.company.cashbackapi.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Event
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event")
public class Event {

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "event_seq", sequenceName = "event_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    private Long id;

    /**
     * Organization which create Event
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    /**
     * Date when Event starts
     */
    @Column(name = "date_from")
    private Date dateFrom;

    /**
     * Date when Event finishes
     */
    @Column(name = "date_to")
    private Date dateTo;

    /**
     * Event description
     */
    @Column(name = "description")
    private String description;

    /**
     * Event created date
     */
    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;
}
