package erarslan.ayse.VetCare.business.abstracts;
import erarslan.ayse.VetCare.dto.request.vaccine.VaccineSaveRequest;
import erarslan.ayse.VetCare.dto.response.vaccine.VaccineResponse;
import erarslan.ayse.VetCare.entitiy.Vaccine;

import java.util.List;

public interface IVaccineService {
    Vaccine getById(long id);
    VaccineResponse save(VaccineSaveRequest vaccineSaveRequest);
    void delete(long id);
    List<Vaccine> findByAnimal(long id);
    List<Vaccine> findAll();
}
