package bg.softuni.mobilele.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "role_id")
    private UserRole roleId;

    @Column(name = "image_url")
    private String imageUrl;

    private LocalDateTime created;

    private LocalDateTime modified;

}
