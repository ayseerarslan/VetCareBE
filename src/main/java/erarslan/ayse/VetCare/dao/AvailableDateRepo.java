package erarslan.ayse.VetCare.dao;

import erarslan.ayse.VetCare.entitiy.AvailableDate;
import erarslan.ayse.VetCare.entitiy.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AvailableDateRepo extends JpaRepository<AvailableDate, Long> {
    AvailableDate findById(long id);
    boolean existsByAvailableDateAndDoctor(LocalDate availableDate, Doctor doctor);
    boolean existsByAvailableDate(LocalDate availableDate);
}
