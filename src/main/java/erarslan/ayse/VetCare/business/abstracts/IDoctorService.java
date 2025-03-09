package erarslan.ayse.VetCare.business.abstracts;
import erarslan.ayse.VetCare.dto.request.doctor.DoctorSaveRequest;
import erarslan.ayse.VetCare.dto.request.doctor.DoctorUpdateRequest;
import erarslan.ayse.VetCare.dto.response.doctor.DoctorResponse;
import erarslan.ayse.VetCare.entitiy.Doctor;

import java.util.List;

public interface IDoctorService {
    Doctor getById(long id);
    DoctorResponse save(DoctorSaveRequest doctorSaveRequest);
    DoctorResponse update(long id, DoctorUpdateRequest doctorUpdateRequest);
    void delete(long id);
    List<Doctor> findAll();
}
