package erarslan.ayse.VetCare.dto.request.vaccine;

import erarslan.ayse.VetCare.entitiy.Animal;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineUpdateRequest {
    @Positive
    @NotNull(message = "The ID of the vaccine to be updated cannot be left blank.")
    private long id;
    @NotNull(message = "The vaccine name cannot be left blank.")
    private String name;
    @NotNull(message = "The vaccine name cannot be left blank")
    private String code;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "The protection start date cannot be left blank.")
    private LocalDate protectionStartDate;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "The protection finish date cannot be left blank.")
    private LocalDate protectionFinishDate;
    @NotNull(message = "The ID of the animal that received the vaccine cannot be left blank.")
    private Animal animal;

}
