package erarslan.ayse.VetCare.business.abstracts;
import erarslan.ayse.VetCare.dto.request.availabledate.AvailableDateSaveRequest;
import erarslan.ayse.VetCare.dto.request.availabledate.AvailableDateUpdateRequest;
import erarslan.ayse.VetCare.dto.response.availabledate.AvailableDateResponse;
import erarslan.ayse.VetCare.entitiy.AvailableDate;

import java.util.List;

public interface IAvailableDateService {
    AvailableDate getById(long id);
    AvailableDateResponse save(AvailableDateSaveRequest availableDateSaveRequest);
    AvailableDateResponse update(long id, AvailableDateUpdateRequest availableDateUpdateRequest);
    void delete(long id);
    List<AvailableDate> findAll();
}
