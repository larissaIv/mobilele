package bg.softuni.mobilele.entities;

import bg.softuni.mobilele.entities.enums.Category;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Category category;

    private LocalDateTime created;

    @Column(name = "end_year")
    private int endYear;

    @Column(name = "image_url")
    private String imageUrl;

    private LocalDateTime modified;

    private String name;

    @Column(name = "start_year")
    private int startYear;

    @Column(name = "brand_id")
    private Brand brandId;



}
