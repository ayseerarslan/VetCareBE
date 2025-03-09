package erarslan.ayse.VetCare.dto.request.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {
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
}
