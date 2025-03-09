package erarslan.ayse.VetCare.dto.request.doctor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorUpdateRequest {
    @NotNull(message = "Doctor name cannot be blank")
    private String name;
    @NotNull(message = "Doctor phone cannot be blank")
    private String phone;
    @NotNull(message = "Doctor email cannot be blank")
    @Email
    private String mail;
    @NotNull(message = "Doctor address cannot be blank")
    private String address;
    @NotNull(message = "Doctor city cannot be blank")
    private String city;
}
