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
public class AppointmentSaveRequest {
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Randevu günü boş bırakılamaz")
    private LocalDateTime appointmentDate;
    @NotNull(message = "Randevuya gelecek olan hayvanın ID'si boş bırakılamaz")
    private Animal animal;
    @NotNull(message = "Randevuya gelecek olan doktorun ID'si boş bırakılamaz")
    private Doctor doctor;

    /*
    {
        "appointmentDate": "2023-12-10T11:00",
        "animal": {
            "id": 4
        },
        "doctor": {
            "id": 2
        }
    }
     */
}
