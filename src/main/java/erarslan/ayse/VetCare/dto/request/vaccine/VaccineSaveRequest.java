package erarslan.ayse.VetCare.dto.request.vaccine;

import erarslan.ayse.VetCare.entitiy.Animal;
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
public class VaccineSaveRequest {
    @NotNull(message = "The vaccine name cannot be left blank.")
    private String name;
    @NotNull(message = "The vaccine code cannot be left blank")
    private String code;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "The protection start date cannot be left blank.")
    private LocalDate protectionStartDate;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "The protection finish date cannot be left blank.")
    private LocalDate protectionFinishDate;
    @NotNull(message = "The ID of the animal that received the vaccine cannot be left blank.")
    private Animal animal;

    /*
    {
        "name": "VetVac",
        "code": "UDFIG345",
        "protectionStartDate": "2023-12-13",
        "protectionFinishDate": "2024-12-13",
        "animal": {
            "id": 2
        }
    }
     */
}
