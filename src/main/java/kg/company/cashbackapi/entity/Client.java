package kg.company.cashbackapi.entity;

import kg.company.cashbackapi.enums.ClientSex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Clients
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "client_seq", sequenceName = "client_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    private Long id;

    /**
     * The list of Clients' Organizations
     */
    @ManyToMany
    @JoinTable(
            name = "client_organization",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "organization_id")
    )
    private Set<Organization> organizations;

    /**
     * Personal code for operations
     */
    @Column(name = "personal_code")
    private String personalCode;

    /**
     * Last name
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * First name
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Patronymic
     */
    @Column(name = "patronymic")
    private String patronymic;

    /**
     * Gender
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private ClientSex clientSex;

    /**
     * Language
     */
    @Column(name = "locale")
    private Character locale;

    /**
     * Nationality
     */
    @Column(name = "nationality")
    private String nationality;

    /**
     * Created date
     */
    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;
}
