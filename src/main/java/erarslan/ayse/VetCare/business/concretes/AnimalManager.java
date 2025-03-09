package erarslan.ayse.VetCare.business.concretes;

import erarslan.ayse.VetCare.business.abstracts.IAnimalService;
import erarslan.ayse.VetCare.business.abstracts.ICustomerService;
import erarslan.ayse.VetCare.core.modelmapper.IModelMapperService;
import erarslan.ayse.VetCare.dao.AnimalRepo;
import erarslan.ayse.VetCare.dao.CustomerRepo;
import erarslan.ayse.VetCare.dto.request.animal.AnimalSaveRequest;
import erarslan.ayse.VetCare.dto.request.animal.AnimalUpdateRequest;
import erarslan.ayse.VetCare.dto.response.animal.AnimalResponse;
import erarslan.ayse.VetCare.entitiy.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalManager implements IAnimalService {


    private final AnimalRepo animalRepo;
    private final CustomerRepo customerRepo;
    private final ICustomerService customerService;
    private final IModelMapperService modelMapperService;

    @Override
    public Animal getById(long id) {
        return this.animalRepo.findById(id);
    }

    @Override
    public AnimalResponse save(AnimalSaveRequest animalSaveRequest) {
        Animal saveAnimal = this.modelMapperService.forRequest().map(animalSaveRequest, Animal.class);
        if (this.animalRepo.existsByNameAndSpeciesAndBreedAndGenderAndColorAndDateOfBirth(
                saveAnimal.getName(),
                saveAnimal.getSpecies(),
                saveAnimal.getBreed(),
                saveAnimal.getGender(),
                saveAnimal.getColor(),
                saveAnimal.getDateOfBirth())){
            throw new IllegalArgumentException("There is an animal that exactly matches the provided information.");
        } else if (!("MALE".equals(saveAnimal.getGender()) || "FEMALE".equals(saveAnimal.getGender()))) {
            throw new IllegalArgumentException("Gender can only be MALE or FEMALE.");
        }
        return modelMapperService.forResponse().map(this.animalRepo.save(saveAnimal), AnimalResponse.class);
    }

    @Override
    public AnimalResponse update(long id, AnimalUpdateRequest animalUpdateRequest) {
        Animal updateAnimal = this.modelMapperService.forRequest().map(animalUpdateRequest, Animal.class);
        updateAnimal.setId(id);
        if (this.animalRepo.existsByNameAndSpeciesAndBreedAndGenderAndColorAndDateOfBirth(
                updateAnimal.getName(),
                updateAnimal.getSpecies(),
                updateAnimal.getBreed(),
                updateAnimal.getGender(),
                updateAnimal.getColor(),
                updateAnimal.getDateOfBirth())){
            throw new IllegalArgumentException("There is an animal that exactly matches the provided information.");
        } else if (!("MALE".equals(updateAnimal.getGender()) || "FEMALE".equals(updateAnimal.getGender()))) {
            throw new IllegalArgumentException("Gender can only be MALE or FEMALE.");
        }
        return modelMapperService.forResponse().map(this.animalRepo.save(updateAnimal), AnimalResponse.class);
    }


    @Override
    public void delete(long id) {
        this.animalRepo.delete(this.getById(id));
    }

    @Override
    public List<Animal> findAll() {
        return this.animalRepo.findAll();
    }
}
