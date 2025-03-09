package erarslan.ayse.VetCare.business.abstracts;
import erarslan.ayse.VetCare.dto.request.vaccine.VaccineSaveRequest;
import erarslan.ayse.VetCare.dto.request.vaccine.VaccineUpdateRequest;
import erarslan.ayse.VetCare.dto.response.vaccine.VaccineResponse;
import erarslan.ayse.VetCare.entitiy.Vaccine;

import java.time.LocalDate;
import java.util.List;

public interface IVaccineService {
    Vaccine getById(long id);
    VaccineResponse save(VaccineSaveRequest vaccineSaveRequest);
    VaccineResponse update(long id, VaccineUpdateRequest vaccineUpdateRequest);
    void delete(long id);
    List<Vaccine> findByAnimal(long id);
    List<Vaccine> findVaccinesInDateRange(LocalDate protectionStartDate, LocalDate protectionFinishDate);
    List<Vaccine> findAll();
}
