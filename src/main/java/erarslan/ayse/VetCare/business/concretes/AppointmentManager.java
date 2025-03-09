package erarslan.ayse.VetCare.business.concretes;

import erarslan.ayse.VetCare.business.abstracts.IAppointmentService;
import erarslan.ayse.VetCare.core.modelmapper.IModelMapperService;
import erarslan.ayse.VetCare.dao.AppointmentRepo;
import erarslan.ayse.VetCare.dao.AvailableDateRepo;
import erarslan.ayse.VetCare.dto.request.appointment.AppointmentSaveRequest;
import erarslan.ayse.VetCare.dto.request.appointment.AppointmentUpdateRequest;
import erarslan.ayse.VetCare.dto.response.appointment.AppointmentResponse;
import erarslan.ayse.VetCare.entitiy.Animal;
import erarslan.ayse.VetCare.entitiy.Appointment;
import erarslan.ayse.VetCare.entitiy.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentManager implements IAppointmentService {

    private final AppointmentRepo appointmentRepo;
    private final AvailableDateRepo availableDateRepo;
    private final IModelMapperService modelMapperService;


    @Override
    public Appointment getById(long id) {
        return this.appointmentRepo.findById(id);
    }

    @Override
    public AppointmentResponse save(AppointmentSaveRequest appointmentSaveRequest) {
        Appointment saveAppointment = this.modelMapperService.forRequest().map(appointmentSaveRequest, Appointment.class);
        if (this.availableDateRepo.existsByAvailableDate(LocalDate.from(saveAppointment.getAppointmentDate()))){
            if (this.appointmentRepo.existsByAppointmentDate(saveAppointment.getAppointmentDate())){
                throw new IllegalArgumentException("Another appointment is available at the time entered.");
            } else {
                return this.modelMapperService.forResponse().map(this.appointmentRepo.save(saveAppointment), AppointmentResponse.class);
            }
        } else {
            throw new IllegalArgumentException("The doctor is not working on this date!");
        }
    }

    @Override
    public AppointmentResponse update(long id, AppointmentUpdateRequest appointmentUpdateRequest) {
        Appointment updateAppointment = this.modelMapperService.forRequest().map(appointmentUpdateRequest, Appointment.class);
        updateAppointment.setId(id);
        if (this.availableDateRepo.existsByAvailableDate(LocalDate.from(updateAppointment.getAppointmentDate()))){
            if (this.appointmentRepo.existsByAppointmentDate(updateAppointment.getAppointmentDate())){
                throw new IllegalArgumentException("Another appointment is available at the time entered.");
            } else {
                return this.modelMapperService.forResponse().map(this.appointmentRepo.save(updateAppointment), AppointmentResponse.class);
            }
        } else {
            throw new IllegalArgumentException("The doctor is not working on this date!");
        }
    }

    @Override
    public void delete(long id) {
        this.appointmentRepo.delete(this.getById(id));
    }

    @Override
    public List<Appointment> findAll() {
        return this.appointmentRepo.findAll();
    }
}