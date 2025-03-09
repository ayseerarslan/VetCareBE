package erarslan.ayse.VetCare.dto.request.animal;

import erarslan.ayse.VetCare.entitiy.Customer;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalUpdateRequest {
    @NotNull(message = "Animal name cannot be left blank.")
    private String name;
    @NotNull(message = "Animal species cannot be left blank.")
    private String species;
    @NotNull(message = "Animal breed cannot be left blank.")
    private String breed;
    @NotNull(message = "Animal gender cannot be left blank.")
    private String gender;
    private String color;
    @Temporal(TemporalType.DATE)
    @Past
    private LocalDate dateOfBirth;
    @NotNull(message = "An ownerless animal cannot be registered.")
    @Positive
    private Customer customer;
}
