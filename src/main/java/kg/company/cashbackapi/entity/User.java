package kg.company.cashbackapi.entity;

import kg.company.cashbackapi.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Users of whole system
 * Administrators, Organization, Administrators
 * Managers
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;

    /**
     * User Role
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    /**
     * User Organization
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    /**
     * Username
     */
    @Column(name = "username", nullable = false)
    private String username;

    /**
     * Password
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * User status
     * ACTIVE / NOT_ACTIVE / DELETED
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    /**
     * Created Date
     */
    @CreatedDate
    @Column(name = "create_date")
    private Date createdDate;
}
