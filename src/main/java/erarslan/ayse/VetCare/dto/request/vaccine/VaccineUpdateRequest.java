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
    @NotNull(message = "Güncellenecek olan aşının ID'si boş bırakılamaz")
    private long id;
    @NotNull(message = "Aşı adı boş bırakılamaz")
    private String name;
    @NotNull(message = "Aşı kodu boş bırakılamaz")
    private String code;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Bağışıklık başlangıç tarihi boş bırakılamaz")
    private LocalDate protectionStartDate;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Bağışıklık bitiş tarihi boş bırakılamaz")
    private LocalDate protectionFinishDate;
    @NotNull(message = "Aşının yapıldığı hayvanın ID'si boş bırakılamaz")
    private Animal animal;
    @NotNull(message = "Aşının rapor ID'si boş bırakılamaz")
    private long reportId;
}
