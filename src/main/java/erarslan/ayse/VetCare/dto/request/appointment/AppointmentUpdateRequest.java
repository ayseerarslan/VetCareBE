package erarslan.ayse.VetCare.dto.request.appointment;

import erarslan.ayse.VetCare.entitiy.Animal;
import erarslan.ayse.VetCare.entitiy.Doctor;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentUpdateRequest {
    @Temporal(TemporalType.DATE)
    @NotNull
    private LocalDateTime appointmentDate;
    @NotNull(message = "The ID of the animal attending the appointment cannot be left blank.")
    private Animal animal;
    @NotNull(message = "The ID of the doctor attending the appointment cannot be left blank.")
    private Doctor doctor;
}
