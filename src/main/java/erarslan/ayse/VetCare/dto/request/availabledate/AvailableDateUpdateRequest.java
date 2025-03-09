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
public class AvailableDateUpdateRequest {
    @Temporal(TemporalType.DATE)
    @NotNull
    private LocalDate availableDate;
    @NotNull(message = "Doctor ID cannot be blank.")

    private Doctor doctor;
}
