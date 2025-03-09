package erarslan.ayse.VetCare.dto.request.availabledate;

import erarslan.ayse.VetCare.entitiy.Doctor;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateSaveRequest {
    @Temporal(TemporalType.DATE)
    @NotNull
    private LocalDate availableDate;
    @NotNull(message = "Doktor ID'si boş olamaz")
    private Doctor doctor;

    /*
    {
        "availableDate": "2023-12-13",
        "doctor": {
            "id": 2
        }
    }
     */
}
