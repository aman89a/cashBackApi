package kg.company.cashbackapi.entity;

import kg.company.cashbackapi.enums.ClientLocale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Device that client use to login to the application
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client_device")
public class ClientDevice {

    /**
     * Identification
     */
    @Id
    @SequenceGenerator(name = "client_device_seq", sequenceName = "client_device_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_device_seq")
    private Long id;

    /**
     * Client
     */
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "client_id")
    private Client client;

    /**
     * Phone number on 996ХХХУУУУУУ format
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * Password
     * Requirements for the password will be set later
     */
    @Column(name = "password")
    private String password;

    /**
     * Imei code
     */
    @Column(name = "imei")
    private String imei;

    /**
     * Last enter date
     */
    @Column(name = "last_enter_date")
    private Date lastEnterDate;

    /**
     * Language
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "client_locale")
    private ClientLocale clientLocale;

    /**
     * Status
     * active = true / false
     */
    @Column(name = "status", columnDefinition = "boolean default true")
    private Boolean status;

}
