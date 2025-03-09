package erarslan.ayse.VetCare.api;

import erarslan.ayse.VetCare.business.abstracts.IAppointmentService;
import erarslan.ayse.VetCare.dto.request.appointment.AppointmentSaveRequest;
import erarslan.ayse.VetCare.dto.request.appointment.AppointmentUpdateRequest;
import erarslan.ayse.VetCare.dto.response.appointment.AppointmentResponse;
import erarslan.ayse.VetCare.entitiy.Appointment;
import erarslan.ayse.VetCare.entitiy.Doctor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/appointments")
public class AppointmentController {

    private final IAppointmentService appointmentService;

    public AppointmentController(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @GetMapping()
    public String home(){
        return "Appointments";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointment> findAll(){
        return this.appointmentService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Appointment findById(@PathVariable("id")int id){
        return this.appointmentService.getById(id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentResponse save(@Valid @RequestBody AppointmentSaveRequest appointmentSaveRequest){
        return appointmentService.save(appointmentSaveRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentResponse update(@PathVariable("id") int id,@Valid @RequestBody AppointmentUpdateRequest appointmentUpdateRequest){
        return appointmentService.update(id, appointmentUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        this.appointmentService.delete(id);
    }

}
