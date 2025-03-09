package erarslan.ayse.VetCare.dto.request.report;

import erarslan.ayse.VetCare.entitiy.Appointment;
import erarslan.ayse.VetCare.entitiy.Vaccine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportUpdateRequest {
    @NotNull(message = "Başlık bilgisi boş bırakılamaz")
    private String title;
    @NotNull(message = "Teşhis bilgisi boş bırakılamaz")
    private String diagnosis;
    @NotNull(message = "Fiyat bilgisi boş bırakılamaz")
    @Digits(integer = 10, fraction = 2, message = "Fiyat bilgisi geçersiz")
    @DecimalMin(value = "0.0", inclusive = false, message = "Fiyat bilgisi sıfırdan büyük olmalıdır")
    private double price;
    @NotNull(message = "Randevu bilgisi boş bırakılamaz")
    private Appointment appointment;
    @NotNull(message = "Aşı bilgisi boş bırakılamaz")
    private Vaccine vaccine;
}
