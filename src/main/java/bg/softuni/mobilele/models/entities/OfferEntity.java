package bg.softuni.mobilele.models.entities;

import bg.softuni.mobilele.models.enums.EngineEnum;
import bg.softuni.mobilele.models.enums.TransmissionEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class OfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EngineEnum engineEnum;

    private String imageUrl;

    private int mileage;

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransmissionEnum transmissionEnum;

    private int year;

    private LocalDateTime created;

    private LocalDateTime modified;

    @ManyToOne
    private ModelEntity model;

    @ManyToOne
    private UserEntity seller;

    public Long getId() {
        return id;
    }

    public OfferEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engineEnum;
    }

    public OfferEntity setEngine(EngineEnum engineEnum) {
        this.engineEnum = engineEnum;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmissionEnum;
    }

    public OfferEntity setTransmission(TransmissionEnum transmissionEnum) {
        this.transmissionEnum = transmissionEnum;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferEntity setYear(int year) {
        this.year = year;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public OfferEntity setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public OfferEntity setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity setModel(ModelEntity modelEntity) {
        this.model = modelEntity;
        return this;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public OfferEntity setSeller(UserEntity seller) {
        this.seller = seller;
        return this;
    }

    @Override
    public String toString() {
        return "OfferEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", engine=" + engineEnum +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmissionEnum +
                ", year=" + year +
                ", created=" + created +
                ", modified=" + modified +
                ", modelEntity=" + model +
                ", seller=" + seller +
                '}';
    }
}
