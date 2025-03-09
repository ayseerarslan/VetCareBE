package erarslan.ayse.VetCare.dto.request.doctor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSaveRequest {
    @NotNull(message = "Doctor name cannot be blank")
    private String name;
    @NotNull(message = "Doctor phone cannot be blank")
    private String phone;
    @NotNull(message = "Doctor mail cannot be blank")
    @Email
    private String mail;
    @NotNull(message = "Doctor address cannot be blank")
    private String address;
    @NotNull(message = "Doctor city cannot be blank")
    private String city;
    /*
    {
        "name": "Ayse",
        "phone": "5359876582",
        "mail": "erarslan@ayse.com",
        "address": "7000 JFK boulevard east",
        "city": "new york"
}
     */
}
