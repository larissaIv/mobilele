package bg.softuni.mobilele.entities;

import bg.softuni.mobilele.entities.enums.Engine;
import bg.softuni.mobilele.entities.enums.Transmission;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime created;

    private String description;

    private Engine engine;

    private String imageUrl;

    private int mileage;

    private LocalDateTime modified;

    private BigDecimal price;

    private Transmission transmission;

    private int year;

    private Model model;

    private User seller;
}
