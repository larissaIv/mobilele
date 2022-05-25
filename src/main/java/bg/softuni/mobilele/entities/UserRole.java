package bg.softuni.mobilele.entities;

import bg.softuni.mobilele.entities.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Role name;
}
