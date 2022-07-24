package bg.softuni.mobilele.services;

import bg.softuni.mobilele.models.dto.offer.AddOfferDTO;
import bg.softuni.mobilele.models.dto.offer.OfferDetailDTO;
import bg.softuni.mobilele.models.entities.ModelEntity;
import bg.softuni.mobilele.models.entities.OfferEntity;
import bg.softuni.mobilele.models.entities.UserEntity;
import bg.softuni.mobilele.models.mapper.OfferMapper;
import bg.softuni.mobilele.repositories.ModelRepository;
import bg.softuni.mobilele.repositories.OfferRepository;
import bg.softuni.mobilele.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private OfferRepository offerRepository;
    private UserRepository userRepository;
    private ModelRepository modelRepository;
    private OfferMapper offerMapper;

    public OfferService(OfferRepository offerRepository, UserRepository userRepository, ModelRepository modelRepository, OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.offerMapper = offerMapper;
    }

    public Page<OfferDetailDTO> getAllOffers(Pageable pageable) {
        return offerRepository.findAll(pageable)
                .map(offerMapper::offerEntityToCardListingOfferDto);
    }

    public void addOffer(AddOfferDTO addOfferDTO, UserDetails userDetails) {
        OfferEntity newOffer = offerMapper.addOfferDtoToOfferEntity(addOfferDTO);

        UserEntity seller = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        ModelEntity model = modelRepository.findById(addOfferDTO.getModelId()).orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        offerRepository.save(newOffer);

    }

    public List<OfferDetailDTO> findOfferByOfferName(String query) {
        return this.offerRepository.findAllByModel_NameContains(query)
                .stream()
                .map(offer -> offerMapper.offerEntityToCardListingOfferDto(offer))
                .toList();
    }
}
