package kg.company.cashbackapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;


/**
 * Events that was saved by Client,
 * with ability to set notification date.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client_event")
public class ClientEvent {

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "client_event_seq", sequenceName = "client_event_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_event_seq")
    private Long id;

    /**
     * Client
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "client_id")
    private Client client;

    /**
     * Event
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "event_id")
    private Event event;

    /**
     * Created Date
     */
    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    /**
     * Notification date
     */
    @Column(name = "notification_date")
    private Date notificationDate;


}
