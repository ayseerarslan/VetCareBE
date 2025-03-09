package erarslan.ayse.VetCare.business.abstracts;

import erarslan.ayse.VetCare.dto.request.animal.AnimalSaveRequest;
import erarslan.ayse.VetCare.dto.request.animal.AnimalUpdateRequest;
import erarslan.ayse.VetCare.dto.response.animal.AnimalResponse;
import erarslan.ayse.VetCare.entitiy.Animal;

import java.util.List;

public interface IAnimalService {
    Animal getById(long id);
    AnimalResponse save(AnimalSaveRequest animalSaveRequest);
    AnimalResponse update(long id, AnimalUpdateRequest animalUpdateRequest);
    void delete(long id);
    List<Animal> findAll();
}
