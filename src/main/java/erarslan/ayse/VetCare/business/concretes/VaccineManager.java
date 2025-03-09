package erarslan.ayse.VetCare.business.concretes;

import erarslan.ayse.VetCare.business.abstracts.IVaccineService;
import erarslan.ayse.VetCare.core.modelmapper.IModelMapperService;
import erarslan.ayse.VetCare.dao.AnimalRepo;
import erarslan.ayse.VetCare.dao.VaccineRepo;
import erarslan.ayse.VetCare.dto.request.vaccine.VaccineSaveRequest;
import erarslan.ayse.VetCare.dto.request.vaccine.VaccineUpdateRequest;
import erarslan.ayse.VetCare.dto.response.vaccine.VaccineResponse;
import erarslan.ayse.VetCare.entitiy.Vaccine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VaccineManager implements IVaccineService {
    private final VaccineRepo vaccineRepo;
    private final AnimalRepo animalRepo;
    private final IModelMapperService modelMapperService;


    @Override
    public Vaccine getById(long id) {
        return this.vaccineRepo.findById(id);
    }

    @Override
    public VaccineResponse save(VaccineSaveRequest vaccineSaveRequest) {
        Vaccine saveVac = this.modelMapperService.forRequest().map(vaccineSaveRequest, Vaccine.class);

        if (this.vaccineRepo.existsByNameAndCode(saveVac.getName(), saveVac.getCode()) && saveVac.getProtectionFinishDate().isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Bu aşının koruma tarihi henüz sona ermemiş");
        }

        return this.modelMapperService.forResponse().map(this.vaccineRepo.save(saveVac), VaccineResponse.class);
    }

    @Override
    public VaccineResponse update(long id, VaccineUpdateRequest vaccineUpdateRequest) {
        Vaccine updateVac = this.modelMapperService.forRequest().map(vaccineUpdateRequest, Vaccine.class);
        updateVac.setId(id);

        if (this.vaccineRepo.existsByCode(updateVac.getCode())){
            throw new IllegalArgumentException("Bu koda sahip bir aşı mevcut, lütfen farklı bir kod giriniz");
        }

        return this.modelMapperService.forResponse().map(this.vaccineRepo.save(updateVac), VaccineResponse.class);
    }

    @Override
    public void delete(long id) {
        this.vaccineRepo.delete(this.getById(id));
    }

    @Override
    public List<Vaccine> findByAnimal(long id) {
        return vaccineRepo.findByAnimal(this.animalRepo.findById(id));
    }

    @Override
    public List<Vaccine> findVaccinesInDateRange(LocalDate protectionStartDate, LocalDate protectionFinishDate) {
        return vaccineRepo.findByProtectionStartDateGreaterThanEqualAndProtectionFinishDateLessThanEqual(
                protectionStartDate, protectionFinishDate);
    }

    @Override
    public List<Vaccine> findAll() {
        return this.vaccineRepo.findAll();
    }
}
