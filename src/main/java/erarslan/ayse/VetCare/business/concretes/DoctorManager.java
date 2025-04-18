package erarslan.ayse.VetCare.business.concretes;

import erarslan.ayse.VetCare.business.abstracts.IDoctorService;
import erarslan.ayse.VetCare.core.modelmapper.IModelMapperService;
import erarslan.ayse.VetCare.dao.DoctorRepo;
import erarslan.ayse.VetCare.dto.request.doctor.DoctorSaveRequest;
import erarslan.ayse.VetCare.dto.request.doctor.DoctorUpdateRequest;
import erarslan.ayse.VetCare.dto.response.doctor.DoctorResponse;
import erarslan.ayse.VetCare.entitiy.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorManager implements IDoctorService {

    private final DoctorRepo doctorRepo;
    private final IModelMapperService modelMapperService;

    @Override
    public Doctor getById(long id) {
        return this.doctorRepo.findById(id);
    }

    @Override
    public DoctorResponse save(DoctorSaveRequest doctorSaveRequest) {
        Doctor saveDoc = this.modelMapperService.forRequest().map(doctorSaveRequest, Doctor.class);
        System.out.println(saveDoc.getMail());

        if (this.doctorRepo.existsByMail(saveDoc.getMail())){
            throw new IllegalArgumentException("The email address has already been entered, please enter a different address.");
        }
        return this.modelMapperService.forResponse().map(this.doctorRepo.save(saveDoc), DoctorResponse.class);
    }

    @Override
    public DoctorResponse update(long id, DoctorUpdateRequest doctorUpdateRequest) {
        Doctor updateDoc = this.modelMapperService.forRequest().map(doctorUpdateRequest, Doctor.class);
        updateDoc.setId(id);
        if (this.doctorRepo.existsByMail(updateDoc.getMail()) && !this.doctorRepo.findById(id).getMail().equals(updateDoc.getMail())){
            throw new IllegalArgumentException("The email address has already been entered, please enter a different address.");
        }
        return modelMapperService.forResponse().map(this.doctorRepo.save(updateDoc), DoctorResponse.class);
    }

    @Override
    public void delete(long id) {
        this.doctorRepo.delete(this.getById(id));
    }

    @Override
    public List<Doctor> findAll() {
        return this.doctorRepo.findAll();
    }
}
