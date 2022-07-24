package bg.softuni.mobilele.models.mapper;

import bg.softuni.mobilele.models.dto.offer.AddOfferDTO;
import bg.softuni.mobilele.models.dto.offer.OfferDetailDTO;
import bg.softuni.mobilele.models.entities.OfferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferEntity addOfferDtoToOfferEntity(AddOfferDTO addOfferDTO);

    @Mapping(source = "model.name", target = "model")
    @Mapping(source = "model.brand.name", target = "brand")
    OfferDetailDTO offerEntityToCardListingOfferDto(OfferEntity offerEntity);
}
