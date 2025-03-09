package erarslan.ayse.VetCare.business.abstracts;
import erarslan.ayse.VetCare.dto.request.appointment.AppointmentSaveRequest;
import erarslan.ayse.VetCare.dto.request.appointment.AppointmentUpdateRequest;
import erarslan.ayse.VetCare.dto.response.appointment.AppointmentResponse;
import erarslan.ayse.VetCare.entitiy.Animal;
import erarslan.ayse.VetCare.entitiy.Appointment;
import erarslan.ayse.VetCare.entitiy.Doctor;

import java.time.LocalDateTime;
import java.util.List;

public interface IAppointmentService {
    Appointment getById(long id);
    AppointmentResponse save(AppointmentSaveRequest appointmentSaveRequest);
    AppointmentResponse update(long id, AppointmentUpdateRequest appointmentUpdateRequest);
    void delete(long id);
    List<Appointment> findByDateAndDoctor(LocalDateTime startDate, LocalDateTime endDate, Doctor doctor);
    List<Appointment> findByDateAndAnimal(LocalDateTime startDate, LocalDateTime endDate, Animal animal);

    List<Appointment> findAll();
}
