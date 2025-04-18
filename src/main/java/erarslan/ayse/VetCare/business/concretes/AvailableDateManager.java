package erarslan.ayse.VetCare.business.concretes;

import erarslan.ayse.VetCare.business.abstracts.IAvailableDateService;
import erarslan.ayse.VetCare.core.modelmapper.IModelMapperService;
import erarslan.ayse.VetCare.dao.AvailableDateRepo;
import erarslan.ayse.VetCare.dto.request.availabledate.AvailableDateSaveRequest;
import erarslan.ayse.VetCare.dto.request.availabledate.AvailableDateUpdateRequest;
import erarslan.ayse.VetCare.dto.response.availabledate.AvailableDateResponse;
import erarslan.ayse.VetCare.entitiy.AvailableDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvailableDateManager implements IAvailableDateService {

    private final AvailableDateRepo availableDateRepo;
    private final IModelMapperService modelMapperService;


    @Override
    public AvailableDate getById(long id) {
        return this.availableDateRepo.findById(id);
    }

    @Override
    public AvailableDateResponse save(AvailableDateSaveRequest availableDateSaveRequest) {
        AvailableDate saveAvDate = this.modelMapperService.forRequest().map(availableDateSaveRequest, AvailableDate.class);
        System.out.println(saveAvDate.getDoctor().getId());
        if (this.availableDateRepo.existsByAvailableDateAndDoctor(saveAvDate.getAvailableDate(), saveAvDate.getDoctor())) {
            throw new IllegalArgumentException(saveAvDate.getDoctor().getName() + " doctor " + saveAvDate.getAvailableDate() + " working on that date, please enter a different date.");
        }
        return this.modelMapperService.forResponse().map(this.availableDateRepo.save(saveAvDate), AvailableDateResponse.class);
    }

    @Override
    public AvailableDateResponse update(long id, AvailableDateUpdateRequest availableDateUpdateRequest) {
        AvailableDate updateAvDate = this.modelMapperService.forRequest().map(availableDateUpdateRequest, AvailableDate.class);
        updateAvDate.setId(id);
        if (this.availableDateRepo.existsByAvailableDateAndDoctor(updateAvDate.getAvailableDate(), updateAvDate.getDoctor())) {
            throw new IllegalArgumentException("Doctor " + updateAvDate.getAvailableDate() + " working on that date, please enter a different date.");
        }
        return this.modelMapperService.forResponse().map(this.availableDateRepo.save(updateAvDate), AvailableDateResponse.class);
    }

    @Override
    public void delete(long id) {
        this.availableDateRepo.delete(this.getById(id));
    }

    @Override
    public List<AvailableDate> findAll() {
        return this.availableDateRepo.findAll();
    }
}
