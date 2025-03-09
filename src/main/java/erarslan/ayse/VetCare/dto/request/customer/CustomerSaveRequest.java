package erarslan.ayse.VetCare.dto.request.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {
    @NotNull(message = "Customer name cannot be blank")
    private String name;
    @NotNull(message = "Customer phone cannot be blank")
    private String phone;
    @Email
    @NotNull(message = "Customer mail cannot be blank")
    private String mail;
    @NotNull(message = "Customer address cannot be blank")
    private String address;
    @NotNull(message = "Customer city cannot be blank")
    private String city;
    /*
    {
        "name": "John",
        "phone": "5359876582",
        "mail": "asdf@john.com",
        "address": "Blackqood Sq, Apt 7",
        "city": "Cork"
}
     */
}
